package com.example.demo.util;

import com.example.demo.entity.PointVo;

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @Description :
 * Copyright: Copyright (c)2019
 * Created Date : 2020/4/12
 */
public class FileTransforUtil {

    public static List<PointVo> getTrajectory(InputStream inputStream){
        List<PointVo> pointVoList = new ArrayList<>();
        try {
            Reader reader = new InputStreamReader(inputStream,"utf-8");
            BufferedReader br = new BufferedReader(reader);
            String line;
            PointVo pointVo  = null;
            int skip = 0,id = 1;
            while ((line = br.readLine())!=null){
                if((skip++)<6){
                    continue;
                }

                String[] strings = line.split(",");
                pointVo = new PointVo();
                pointVo.setId(id++);
                pointVo.setUid(1);
                pointVo.setLongtitude(new BigDecimal(strings[1]));
                pointVo.setLatitude(new BigDecimal(strings[0]));
                pointVoList.add(pointVo);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return pointVoList;
    }




}
