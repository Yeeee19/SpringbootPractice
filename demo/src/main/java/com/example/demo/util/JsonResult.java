package com.example.demo.util;

import java.io.Serializable;

public class JsonResult<E> implements Serializable {

    // 狀態
    private Integer state;
    // 描述
    private String message;
    // 數據
    private E data;

    public JsonResult(){}

    public JsonResult(Throwable e){
        this.message = e.getMessage();
    }

    public JsonResult(Integer state){
        this.state = state;
    }

    public JsonResult(Integer state, E Data){
        this.state = state;
        this.data = data;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }
}
