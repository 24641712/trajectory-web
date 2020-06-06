package com.example.demo;

import com.example.demo.dao.ShowDataDao;
import com.example.demo.entity.PointVo;
import com.example.demo.service.ShowDataService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    ShowDataService showDataService;

    @Autowired
    ShowDataDao showDataDao;

    @Test
    void contextLoads() {
        List<PointVo> list = showDataService.listTrajectory();
        for (PointVo pointVo : list){
            System.out.print(pointVo.getId()+" ");
            System.out.print(pointVo.getLongtitude()+" ");
            System.out.println(pointVo.getLatitude());

        }

    }

    @Test
    void batchInsert(){
        List<PointVo> pointVos = new ArrayList<>();

        PointVo pointVo = new PointVo();
        pointVo.setId(3);
        pointVo.setLongtitude(new BigDecimal(116.318417));
        pointVo.setLatitude(new BigDecimal(39.984702));
        pointVos.add(pointVo);

        PointVo pointVo1 = new PointVo();
        pointVo1.setId(4);
        pointVo1.setLongtitude(new BigDecimal(116.31845));
        pointVo1.setLatitude(new BigDecimal(39.984683));
        pointVos.add(pointVo1);

        showDataService.batchInsert(pointVos);

    }

    @Test
    public void insert(){
        showDataService.deleteAll();
        PointVo pointVo = new PointVo();
        pointVo.setId(1);
        pointVo.setUid(1);
        pointVo.setLatitude(new BigDecimal(1));
        pointVo.setLongtitude(new BigDecimal(1));
        showDataService.insert(pointVo);

    }

    @Test
    public void deleteAll(){
        showDataService.deleteAll();

    }

}
