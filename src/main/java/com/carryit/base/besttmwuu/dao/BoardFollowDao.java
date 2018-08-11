package com.carryit.base.besttmwuu.dao;

import com.carryit.base.besttmwuu.entity.BoardFollow;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardFollowDao {

    BoardFollow getBoardByUid(@Param("uid") int uid, @Param("bid")int bid);
}
