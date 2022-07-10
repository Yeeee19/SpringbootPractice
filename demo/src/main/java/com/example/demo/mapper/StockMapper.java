package com.example.demo.mapper;

import com.example.demo.entity.StockEntity;

import java.util.List;

public interface StockMapper {

    /**
     * 新增交易紀錄
     * @param stock 交易類
     * @return 受影響的行數
     */
    public Integer insert(StockEntity stock);

    public List<StockEntity> selectAllRecord();
}
