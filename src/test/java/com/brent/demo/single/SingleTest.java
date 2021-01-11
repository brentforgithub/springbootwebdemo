package com.brent.demo.single;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SingleTest {

    @Test
    public void getSingle() throws ClassNotFoundException, IllegalAccessException,
            InstantiationException, NoSuchMethodException, InvocationTargetException {

        ServerSingle serverSingle = ServerSingle.getServerSingle();
        System.out.println(serverSingle);
        Constructor<ServerSingle> constructor = ServerSingle.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        ServerSingle serverSinglec = constructor.newInstance();
        System.out.println(serverSinglec);
        System.out.println(ServerSingle.getServerSingle());



        //ServerSingle serverSingle2 = (ServerSingle)Class.forName(ServerSingle.class.getName()).newInstance();
        //System.out.println(serverSingle2);
    }
}
