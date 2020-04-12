package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.PointVo;
import com.example.demo.service.ShowDataService;
import com.example.demo.util.FileTransforUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
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
    public String getTrajectory(){

        List<PointVo> pointVoList = new ArrayList<>();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status","success");
        jsonObject.put("datas",pointVoList);

        return "sss";

    }

    @RequestMapping("batchInsert")
    public void batchInsert(@RequestParam("file") MultipartFile file, HttpServletRequest req) throws IOException {
        System.out.println(file.getOriginalFilename());
        List<PointVo> pointVoList = FileTransforUtil.getTrajectory(file.getInputStream());
        System.out.println(pointVoList.size());
        showDataService.deleteAll();
        showDataService.batchInsert(pointVoList);
        System.out.println("oooooo");

    }





}
