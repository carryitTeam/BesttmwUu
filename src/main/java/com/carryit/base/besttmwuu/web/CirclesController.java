package com.carryit.base.besttmwuu.web;

import com.carryit.base.besttmwuu.entity.Board;
import com.carryit.base.besttmwuu.entity.BoardFollow;
import com.carryit.base.besttmwuu.entity.Circles;
import com.carryit.base.besttmwuu.service.BoardService;
import com.carryit.base.besttmwuu.service.BoardFollowService;
import com.carryit.base.besttmwuu.service.CirclesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/circle")
public class CirclesController {

    Logger logger = LoggerFactory.getLogger(CirclesController.class);

    @Autowired
    CirclesService circlesService;
    @Autowired
    BoardService boardService;
    @Autowired
    BoardFollowService boardFollowService;

    /*获取圈子分组，和每组下面的关联的圈子信息（包括关注数，话题数）
    * */
    @RequestMapping("/getCircles")
    public List<Circles> getCircles(){
        List<Circles> circles = new ArrayList<>();

        try {
            circles  = circlesService.getCircles();
            if(circles.size()>0){
                for (Circles circle :circles) {
                    List<Board> boardList = boardService.getBoardByCid(circle.getId());
                    circle.setBoards(boardList);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return circles;
    }
    /*
    * 根据用户id,圈子id获取圈子信息，并且判断用户是否关注圈子
    * */
    @RequestMapping("/getBoardByUid")
    public Board getBoardByUid(int uid,int bid){
        Board board =  new Board();

        BoardFollow bf = null;

        try {
            board =  boardService.getBoardById(bid);//查询圈子详细信息
            bf =  boardFollowService.getBoardByUid(uid,bid);//查询该用户是否关注该圈子
            if(bf!=null){
                board.setFollow(true);
            }else{
                board.setFollow(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return board;

    }
}