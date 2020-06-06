package com.example.demo.service;

import com.example.demo.dao.ShowDataDao;
import com.example.demo.entity.PointVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @version 1.0
 * @Description :
 * Copyright: Copyright (c)2019
 * Created Date : 2020/4/11
 */
@Service
public class ShowDataService {

    @Autowired(required = false)
    private ShowDataDao showDataDao;

    public List<PointVo> listTrajectory(){
        return showDataDao.listTrajectory();
    }

    public void batchInsert(List<PointVo> pointVos){
        showDataDao.batchInsert(pointVos);
    }

    public int insert(PointVo pointVo){
        return showDataDao.insert(pointVo);
    }

    public void deleteAll(){
        showDataDao.deleteAll();
    }



}
