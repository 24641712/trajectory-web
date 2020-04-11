package com.example.demo;

import com.example.demo.dao.ShowDataDao;
import com.example.demo.service.ShowDataService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    ShowDataService showDataService;

    @Autowired
    ShowDataDao showDataDao;

    @Test
    void contextLoads() {
        List<Integer> list = showDataDao.list();
        for (Integer integer : list){
            System.out.println(integer);
        }

    }

}
