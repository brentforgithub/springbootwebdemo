package com.brent.demo.common.basecontroller;

import lombok.Data;

@Data
public class ResBody {
    private Integer state;
    private String msg;
    private Object data;
}
