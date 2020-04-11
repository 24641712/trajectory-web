package com.example.demo.service;

import com.example.demo.dao.ShowDataDao;
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

    @Autowired
    private ShowDataDao showDataDao;

    public List<Integer> listTrajectory(){
        return showDataDao.list();
    }



}
