package com.example.demo.dao;

import com.example.demo.entity.PointVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @version 1.0
 * @Description :
 * Copyright: Copyright (c)2019
 * Created Date : 2020/4/11
 */
@Mapper
public interface ShowDataDao {

    List<PointVo> listTrajectory();

    void deleteAll();

    int batchInsert(List<PointVo> list);


}
