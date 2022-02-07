package com.st.sp.bean;
//被代理的类，也就是父类，通过字节码技术创建这个类的子类，实现动态代理
public class Student {
    public void say(){
        System.out.println("hello everyone");
    }
}
