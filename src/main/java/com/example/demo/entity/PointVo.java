package com.example.demo.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Description:
 * @update logs
 * @throws Exception
 */
@Data
public class PointVo implements Serializable {

    private int id;

    private int uid;

    private BigDecimal latitude;  //纬度

    private BigDecimal longtitude;  //经度

    private String sdate;  //日期

    private String stime;  //时间

}
