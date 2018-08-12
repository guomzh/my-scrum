package com.zgm.myscrum.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zgm.myscrum.entity.Scrum;
import com.zgm.myscrum.service.ScrumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
public class ScrumController {
    @Autowired
    private ScrumService service;
    @RequestMapping("/hello")
    public String sayHello(){
        return "你好，微信小程序！" +
                "\n测试一些jenkins好不好用哟。" +
                "\n服务器上的Jenkins所在的tomcat的关闭监听端口改为了6000" +
                "\nJenkins不会因为其他tomcat的关闭而自杀啦！";
    }
    @RequestMapping("/selectScrums")
    public JSONObject selectScrums(@RequestParam("nickName") String nickName){
        JSONObject ob=new JSONObject();
        JSONArray re=service.selectScrumsAll(nickName);
        ob.fluentPut("scrums",re);
        return ob;
    }
    @RequestMapping(value="/selectScrumById",method = RequestMethod.GET)
    public Map<String ,Object> selectScrumById(
            @RequestParam (value = "id") Long id
            ){
        Map<String,Object> map=new HashMap<>();
        Scrum scrum=service.selectScrumById(id);
        map.put("scrum" , scrum);
        return map;
    }
    @RequestMapping(value = "/updateScrum",method = RequestMethod.POST)
    public Map<String,Object> updateScrum(@RequestBody Scrum scrum){
        Map<String,Object> map=new HashMap<>();
        map.put("success",service.updateScrum(scrum));
        return map;
    }
    @RequestMapping(value = "/deleteScrum",method = RequestMethod.GET)
    public Map<String,Object> deleteScrum(@RequestParam(value = "id") Long id,
                                          @RequestParam(value = "nickName")String nickName){
        Map<String,Object> map=new HashMap<>();
        map.put("success",service.deleteScrum(id,nickName));
        return map;
    }
    @RequestMapping(value = "/insertScrum",method = RequestMethod.POST)
    public Map<String,Object> insertScrum(@RequestBody Scrum scrum){
        Map<String,Object> map=new HashMap<>();
        map.put("success",service.insertScrum(scrum));
        return map;
    }
    @RequestMapping(value="/changeStatusById",method = RequestMethod.GET)
    public Map<String ,Object> changeStatusById(
            @RequestParam (value = "id") Long id,
            @RequestParam(value = "nickName" )String nickName,
            @RequestParam (value= "status")Integer status
    ){
        Map<String,Object> map=new HashMap<>();
        boolean res=service.changeStatus(id ,nickName,status);
        map.put("success" , res);
        return map;
    }
}
