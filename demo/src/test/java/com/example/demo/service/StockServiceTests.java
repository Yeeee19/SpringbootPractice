package com.example.demo.service;

import com.example.demo.entity.StockEntity;
import com.example.demo.mapper.StockMapper;
import com.example.demo.service.ex.ServiceException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

// @SpringBootTest 標註當前的類是測試類, 不會隨著專案打包
// @RunWith 啟動單元測試類
@SpringBootTest
@RunWith(SpringRunner.class)
public class StockServiceTests {

    @Autowired
    private IStockService stockService ;

    @Test
    public void addRecord(){
        try {
            StockEntity stockEntity = new StockEntity();
            stockEntity.setId(1);
            stockEntity.setStock("2330");
            stockEntity.setVolume(1000);
            stockService.addRecord(stockEntity);
            System.out.println("OK");
        } catch (ServiceException e) {
            System.out.println(e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void findAllRecord(){
        List<StockEntity> result = stockService.findAllRecord();

        for(StockEntity s : result){
            System.out.println(s);
        }
    }
}
