package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.PointVo;
import com.example.demo.entity.User;
import com.example.demo.service.ShowDataService;
import com.example.demo.util.FileTransforUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @Description :
 * Copyright: Copyright (c)2019
 * Created Date : 2020/4/11
 */
@Controller
public class ShowDataController {

    @Autowired
    private ShowDataService showDataService;

    @RequestMapping("data")
    public String getData(){
          return "ShowData";
    }

    @RequestMapping("listData")
    public void getTrajectory(HttpServletResponse response){

        List<PointVo> pointVoList = showDataService.listTrajectory();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status","success");
        jsonObject.put("datas",pointVoList);
        PrintWriter out = null;
        try {
            out = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
            jsonObject.put("status","error");
        }
        out.print(jsonObject);

    }

    @RequestMapping("batchInsert")
    public String batchInsert(@RequestParam("file") MultipartFile file, HttpServletRequest req) throws IOException {
        System.out.println(file.getOriginalFilename());
        List<PointVo> pointVoList = FileTransforUtil.getTrajectory(file.getInputStream());
        System.out.println(pointVoList.size());
        showDataService.deleteAll();
        showDataService.batchInsert(pointVoList);
        return "index";
    }

    @RequestMapping("uid")
    public void getUid(HttpServletResponse response){
      List<User> userList = new ArrayList<>();
      User user = new User();
      user.setId(1);
      user.setAge("12");
      user.setUid("1");
      userList.add(user);
      JSONObject jsonObject = new JSONObject();
      jsonObject.put("status","success");
      jsonObject.put("datas",userList);
      PrintWriter out = null;
      try {
          out = response.getWriter();
      } catch (IOException e) {
          e.printStackTrace();
          jsonObject.put("status","error");
      }
      out.print(jsonObject);

    }




}
