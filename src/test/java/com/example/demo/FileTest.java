package com.example.demo;

import com.example.demo.dao.ShowDataDao;
import com.example.demo.entity.PointVo;
import com.example.demo.entity.PointVo3;
import com.example.demo.service.ShowDataService;
import com.example.demo.util.FileTransforUtil;
import com.example.demo.util.SortListUtil;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.io.File;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @version 1.0
 * @Description :
 * Copyright: Copyright (c)2019
 * Created Date : 2020/4/22
 */
@SpringBootTest
public class FileTest {

    @Autowired
    private ShowDataService showDataService;

    @Autowired
    private ShowDataDao showDataDao;

    @Test
    public void readFolder(){
        System.out.println("file");
        String user = "001";
        String filePath = "G:\\Geolife Trajectories 1.3\\Data\\"+user+"\\Trajectory\\";
//        String filePath = "G:\\trajectorys\\sub_taxi_log_2008_by_id\\";
        File file = new File(filePath);
        List<PointVo> resultList = new ArrayList<>();
        try {
            List<PointVo> list = FileTransforUtil.readFolderByLines(file);
            int separa = 1;
            showDataService.deleteAll();
            for(int i=0;i<list.size();i = i+separa){
                resultList.add(list.get(i));
//                showDataService.insert(list.get(i));
            }
            showDataService.batchInsert(resultList);
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void readFolder33() throws InvocationTargetException, IllegalAccessException
    {
        System.out.println("file");
        String user = "001";
        String filePath = "G:\\Geolife Trajectories 1.3\\Data\\"+user+"\\Trajectory\\";
//        String filePath = "G:\\trajectorys\\sub_taxi_log_2008_by_id\\";
        File file = new File(filePath);
        List<PointVo> resultList = new ArrayList<>();
        try {
            List<PointVo> pointVoList = FileTransforUtil.readFolderByLines(file);
            List<PointVo> filterList = pointVoList.stream().filter(e->e.getId()>80000).collect(Collectors.toList());
            List<PointVo3> pointVo3List = new ArrayList<>();
            filterList.stream().forEach(e->{
               PointVo3 pointVo3 = new PointVo3();
                try {
                    BeanUtils.copyProperties(pointVo3,e);
                    pointVo3List.add(pointVo3);
                } catch (IllegalAccessException e1) {
                    e1.printStackTrace();
                } catch (InvocationTargetException e1) {
                    e1.printStackTrace();
                }
            });


//            pointVo3List.stream().sorted(Comparator.comparing(PointVo3::getId).reversed()).collect(Collectors.toList());

            SortListUtil.sort(pointVo3List,"id","asc");

            pointVo3List.stream().forEach(e-> System.out.println(e));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
