package com.zgm.myscrum.service;

import com.alibaba.fastjson.JSONArray;
import com.zgm.myscrum.entity.Scrum;

public interface ScrumService {
    JSONArray selectScrumsAll(String nickName);
    Scrum  selectScrumById(Long id);
    boolean updateScrum(Scrum scrum);
    boolean deleteScrum(Long id,String nickName);
    boolean insertScrum(Scrum scrum);
    boolean changeStatus( Long id,String nickName,Integer status);
}
