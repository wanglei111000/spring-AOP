package com.st.sp.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

//代理执行被代理对象的工具
public class CustomInvocationHandler implements InvocationHandler {
    private Object target;  //目标对象即被代理对象

    public CustomInvocationHandler(Object target) {  //将被代理对象作为构造参数
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(method.getName()+".........Before invocation..........");
        Object result = method.invoke(target, args);
        System.out.println(method.getName()+"..........After invocation..........");
        return result;
    }
}
