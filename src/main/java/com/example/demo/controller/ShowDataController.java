package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.PointVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @RequestMapping("data")
    public String getData(){
          return "ShowData";
    }

    @RequestMapping()
    public Object getTrajectory(){

        List<PointVo> pointVoList = new ArrayList<>();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status","success");
        jsonObject.put("datas",pointVoList);




        return null;

    }



}
