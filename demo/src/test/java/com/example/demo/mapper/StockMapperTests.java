package com.example.demo.mapper;

import com.example.demo.entity.StockEntity;
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
public class StockMapperTests {

    @Autowired
    private StockMapper stockMapper;

    /**
     * 單元測試方法獨立運行的條件: (不必啟動整個項目, 提高效率)
     * 1. 必須被 @Test註解修飾 (org.junit)
     * 2. 返回值必須為void
     * 3. 不傳入任何參數
     * 4. 訪問類型必須是 public
     */

    @Test
    public void insert(){
        StockEntity stockEntity = new StockEntity();
        stockEntity.setStock("1319");
        stockEntity.setVolume(1);

        Integer rows = stockMapper.insert(stockEntity);
        System.out.println(rows);
    }

    @Test
    public void selectAllRecord(){
        List<StockEntity> stockEntityList = stockMapper.selectAllRecord();

        for (StockEntity s:stockEntityList) {
            System.out.println(s);
        }
    }
}
