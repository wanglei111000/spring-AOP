package com.st.sp.test;

import com.st.sp.bean.CglibProxy;
import com.st.sp.bean.Student;

public class Tester02 {
    //CglibProxy  动态代理 是基于字节码结束来实现的 ，实际上是通过字节码创建了被代理对象的子类
    //然后通过该子类来 调用对应的方法
    public static void main(String[] args) {
        CglibProxy cglibProxy = new CglibProxy();
        Student proxyStu =  (Student)cglibProxy.getProxy(Student.class);
        proxyStu.say();
    }
}
