package com.carryit.base.besttmwuu.web;


import com.alibaba.fastjson.JSONObject;
import com.base.BaseController;
import com.bean.req.BoardReq;
import com.carryit.base.besttmwuu.entity.*;
import com.carryit.base.besttmwuu.service.GlobounService;
import com.carryit.base.besttmwuu.service.MemberService;
import com.carryit.base.besttmwuu.service.SincerityService;
import com.util.UploadHelper;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Decoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/image")
public class ImageController {

    @Value(value = "${domain_name}")
    private String domain_name;
//
//    //上传图片,先临时保存在/static/index_img下,做测试.后面保存到图片服务器
//    @RequestMapping(value = "/upload", method = {RequestMethod.GET,
//            RequestMethod.POST}, produces = "application/json;charset=UTF-8")
//    public JSONObject save(@RequestBody(required = false) String json) {
//        return callHttpReqTask(json, 0);
//    }
//


//    @Override
//    public JSONObject runTask(String json, int cmd) {
//        switch (cmd) {
//
//            case 0:
//                Image image = p(json, Image.class);
//                if(image==null){
//                    return faild("参数为空~", false);
//                }
//                if (image.getBase64() == null) { //图像数据为空
//                    return faild("参数为空~", false);
//                }
//                String path = "/var/apache-tomcat-8.5.31/webapps/besttmwuu-0.0.1/WEB-INF/classes/static/index_img/";
//                byte[] base64Bytes = Base64.decodeBase64(image.getBase64());
//                //生成文件名,仅供测试,不保证唯一
//                String files = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date())
//                        + (new Random().nextInt(9000) % (9000 - 1000 + 1) + 1000) + ".jpg";
//                 path = path+files;
//
//                OutputStream out = null;
//                try {
//                    out = new FileOutputStream(path);
//                    out.write(base64Bytes);
//                    out.flush();
//                    out.close();
//                    String url = domain_name + "/index_img/" + files;
//                    return doObjResp(url);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                    return faild("异常~", false);
//                }
//
//                }
//        return null;
//
//        }

    @RequestMapping(value="/upload", method = RequestMethod.POST)
    @ResponseBody
    public String uploadFile(HttpServletRequest request,
                             HttpServletResponse response) {
        List<MultipartFile> multipartFiles = UploadHelper.getFileSet(request, 1024 * 20, null);
        String path = "/var/apache-tomcat-8.5.31/webapps/besttmwuu-0.0.1/WEB-INF/classes/static/index_img/";
        if (multipartFiles.size() == 0) {
            // TODO 给出提示,不允许没选择文件点击上传

        }
        for (MultipartFile multipartFile : multipartFiles) {
            try {
                String filePath = UploadHelper.uploadFile(multipartFile, path);
                System.out.println(filePath);
            } catch (Exception e) {
                e.printStackTrace();
            }
            // 拿到的imgPath就是图片的相对于contextPath的存储路径了
        }
        return null;
    }


    }

