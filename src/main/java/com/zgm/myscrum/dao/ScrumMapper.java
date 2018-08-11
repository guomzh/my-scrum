package com.zgm.myscrum.dao;

import com.zgm.myscrum.entity.Scrum;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ScrumMapper {
    List<Scrum> select(String nickName);
    Scrum selectById(Long id);
    int insert(Scrum scrum);
    int update(Scrum scrum);
    int delete(@Param("id") Long id,@Param("nickName") String nickName);
    int change(@Param("id")Long id ,@Param("nickName")String nickName,@Param("status")Integer status);
}
