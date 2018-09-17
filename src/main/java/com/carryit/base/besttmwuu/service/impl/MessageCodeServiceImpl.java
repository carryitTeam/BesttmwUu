package com.carryit.base.besttmwuu.service.impl;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.carryit.base.besttmwuu.dao.MessageCodeDao;
import com.carryit.base.besttmwuu.entity.MessageCode;
import com.carryit.base.besttmwuu.service.MessageCodeService;
import com.util.PropertyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;

@Service("messageCodeService")
public class MessageCodeServiceImpl implements MessageCodeService{
    @Autowired
    public MessageCodeDao messageCodeDao;



    @Override
    public String getByPhone(String phoneNumber) {
        return null;
    }

    @Override
    public void insert(MessageCode messageCode) {
        messageCodeDao.insert(messageCode);
    }

    @Override
    public void update(MessageCode messageCode) {
        messageCodeDao.update(messageCode);
    }

    @Override
    public MessageCode getIdByPhone(String phoneNumber) {
        return messageCodeDao.getIdByPhone(phoneNumber);
    }

    @Override
    public void saveMessageCode(String phoneNumber,int code) {
        MessageCode phone = this.getIdByPhone(phoneNumber);
        MessageCode messageCode=new MessageCode();
        messageCode.setCreateTime(new Date());
        messageCode.setCode(code);
        messageCode.setStatus(1);
        if(phone==null){
            messageCode.setPhone(phoneNumber);
            this.insert(messageCode);
        }else{
            messageCode.setId(phone.getId());
            this.update(messageCode);
        }
    }

    @Override
    public boolean checkCode(String json) {
        JSONObject jo = JSON.parseObject(json);
        String phoneNumber = jo.getString("phoneNumber");
        int code = jo.getInteger("code");
        MessageCode messageCode=this.getIdByPhone(phoneNumber);
        if(StringUtils.isEmpty(messageCode)){ //验证码表没数据
            return false;
        }else{
            //有效期：创建时间 + 有效时长（60秒） > 当前时间
            Long SMS_TIME = Long.valueOf(PropertyUtil.getProperty("sms_time"));
            Long userfulTime = messageCode.getCreateTime().getTime() + SMS_TIME;
            //验证码失效
            if(messageCode.getStatus()!=1 || messageCode.getCode()!=code || userfulTime > new Date().getTime() )
            {
                return false;
            }else{
                return true;
            }


        }
    }


}