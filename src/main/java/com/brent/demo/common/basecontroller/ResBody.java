package com.brent.demo.common.basecontroller;

import lombok.Data;

@Data
public class ResBody<T> {
    private Integer state;
    private String msg;
    private T data;
}
