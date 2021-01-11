package com.brent.demo.single;

public class ServerSingle {

    private volatile static ServerSingle se = new ServerSingle();

    private ServerSingle(){
        if(se != null){
            throw new RuntimeException("已初始化！");
        }
    }

    public static ServerSingle getServerSingle(){
        if(se == null){
            synchronized (ServerSingle.class){
                if(se == null){
                    se = new ServerSingle();
                }
            }
        }
        return se;
    }
}
