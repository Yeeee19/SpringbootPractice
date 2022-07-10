package com.example.demo.service;

import com.example.demo.entity.StockEntity;

import java.util.List;

public interface IStockService {
    /**
     * 添加紀錄
     * @param stock
     */
    void addRecord(StockEntity stock);

    /**
     * 查詢全部記錄
     * @return stock
     */
    List<StockEntity> findAllRecord();
}
