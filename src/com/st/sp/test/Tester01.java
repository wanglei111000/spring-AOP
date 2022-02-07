package com.st.sp.test;

import com.st.sp.api.Caculater;
import com.st.sp.impl.MyCaculater;
import com.st.sp.proxy.CustomInvocationHandler;

import java.lang.reflect.Proxy;

public class Tester01 {

    //JDK 动态代理 只能对接口进行代理
    public static void main(String[] args) {
        //传入被代理对象MyCaculater  即接口的实现类
        CustomInvocationHandler handler = new CustomInvocationHandler(new MyCaculater());
        Caculater proxy = (Caculater) Proxy.newProxyInstance(  //创建代理对象
                Tester01.class.getClassLoader(),  //当前执行操作对象的 classLoader
                new Class[]{Caculater.class}, //被代理对象实现的接口
                handler);  //具体的方法执行操作
        proxy.add(100,100);
        proxy.min(100,20);
        proxy.multi(100,0);
        proxy.div(10 , 2);
    }

}
