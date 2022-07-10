package com.example.demo.controller;


import com.example.demo.service.ex.DataNotFoundException;
import com.example.demo.service.ex.InsertException;
import com.example.demo.service.ex.ServiceException;
import com.example.demo.util.JsonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class BaseController {

    // 操作成功的狀態碼
    public static final int OK = 200;

    // 統一攔截異常至此, 將結果返回至前端
    @ExceptionHandler(ServiceException.class)
    public JsonResult<Void> exceptionHandler(Throwable e){
        JsonResult<Void> result = new JsonResult<>(e);

        if(e instanceof InsertException){
            result.setState(4000);
            result.setMessage("新增資料失敗");
        } else if(e instanceof DataNotFoundException){
            result.setState(4001);
            result.setMessage("無指定資料");
        }

        return result;
    }
}
