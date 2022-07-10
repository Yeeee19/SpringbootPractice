package com.example.demo.service.impl;

import com.example.demo.entity.StockEntity;
import com.example.demo.mapper.StockMapper;
import com.example.demo.service.IStockService;
import com.example.demo.service.ex.DataNotFoundException;
import com.example.demo.service.ex.InsertException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockServiceImpl implements IStockService {

    /* TODO:
    *       1. HTML頁面輸入驗證
    *           1.1. 介面美化
    *           1.2. 輸入驗證 (正則表達, 未輸入攔截)
    *           1.3. 輔助輸入 (日期欄位)
    *       2. 接收端資料驗證 (未通過網頁入口, 直接發 API 傳輸資料)
    *       3. Select 功能未實作
    *       4. Update 功能未實作
    */

    @Autowired
    private StockMapper stockMapper;

    @Override
    public void addRecord(StockEntity stock) {
        Integer rows = stockMapper.insert(stock);
        if (rows != 1){
            throw new InsertException("新增資料失敗");
        }
    }

    @Override
    public List<StockEntity> findAllRecord() {
        List<StockEntity> result =  stockMapper.selectAllRecord();
        if (result == null){
            throw new DataNotFoundException("無指定資料");
        }
        return result;
    }
}
