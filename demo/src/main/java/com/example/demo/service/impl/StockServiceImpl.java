package com.example.demo.service.impl;

import com.example.demo.entity.StockEntity;
import com.example.demo.mapper.StockMapper;
import com.example.demo.service.IStockService;
import com.example.demo.service.ex.DataNotFoundException;
import com.example.demo.service.ex.InsertException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

@Service
public class StockServiceImpl implements IStockService {

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
