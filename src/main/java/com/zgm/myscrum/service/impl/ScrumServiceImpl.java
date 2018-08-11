package com.zgm.myscrum.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zgm.myscrum.dao.ScrumMapper;
import com.zgm.myscrum.entity.Scrum;
import com.zgm.myscrum.service.ScrumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;
@Service
public class ScrumServiceImpl implements ScrumService {
    @Autowired
    private ScrumMapper scrumMapper;
    @Override
    public JSONArray selectScrumsAll(String nickName) {
        List<Scrum> scrums=scrumMapper.select(nickName);
        SimpleDateFormat formatter=new SimpleDateFormat("MM-dd HH:mm:ss");
        JSONArray array=new JSONArray();
        for (Scrum scrum : scrums) {
             JSONObject jsonObject=new JSONObject();
             jsonObject.fluentPut("task",scrum.getTask()).fluentPut("id",scrum.getId())
            .fluentPut("createTime",formatter.format(scrum.getCreateTime()))
            .fluentPut("lastModifyTime",formatter.format(scrum.getLastModifyTime()))
            .fluentPut("status",scrum.getStatus());
             array.add(jsonObject);
        }
        return array;
    }

    @Override
    public Scrum selectScrumById(Long id) {
        return scrumMapper.selectById(id);
    }

    @Override
    public boolean updateScrum(Scrum scrum) {
      int count = scrumMapper.update(scrum);
      if(count==1)
          return true;
      else return false;
    }

    @Override
    public boolean deleteScrum(Long id,String nickName) {
        int count= scrumMapper.delete(id,nickName);
        if(count==1)
            return true;
        else return false;
    }

    @Override
    public boolean insertScrum(Scrum scrum) {
        int count=scrumMapper.insert(scrum);
        if(count==1)
            return true;
        return false;
    }

    @Override
    public boolean changeStatus(Long id ,String nickName,Integer status) {
        int count;
        if (status==1){
            count=scrumMapper.change(id ,nickName,2);
        }
        else {
           count=scrumMapper.change(id,nickName,1);
        }
        if(count==1)
            return true;
        return false;
    }
}
