package com.example.demo.controller;

import com.example.demo.entity.StockEntity;
import com.example.demo.service.IStockService;
import com.example.demo.service.ex.InsertException;
import com.example.demo.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@RestController = @Controller + @ResponseBody
@RestController
@RequestMapping("/stock")
public class StockController extends BaseController{

    @Autowired
    private IStockService stockService;

    @RequestMapping("add")
    public JsonResult<Void> addRecord(StockEntity stockEntity){
        stockService.addRecord(stockEntity);
        return new JsonResult<>(OK);
    }

    @RequestMapping("findall")
    public List<StockEntity> findAllRecord(){
        List<StockEntity> result = stockService.findAllRecord();
        return result;
    }

    /*
    @RequestMapping("findall")
    public JsonResult<List> findAllRecord(){
        List<StockEntity> result = stockService.findAllRecord();
        return new JsonResult<List>(OK, result);
    }
    */
}