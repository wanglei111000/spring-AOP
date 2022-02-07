package com.st.sp.bean;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
//动态代理 即在代码运行时 ，通过某一种代理技术 将一些与业务无关的但是 对于程序本身可以
//增强其某一方面的功能的代码逻辑嵌入到代码中去
import java.lang.reflect.Method;
//注意 这里可以在 maven 仓库 下载 需要的CGLIB的jar 包 ，需要版本对应上
//否则会出现一些莫名其妙的错误
//一下是我下载的路径

// https://mvnrepository.com/artifact/asm/asm-all/2.2
// https://mvnrepository.com/artifact/cglib/cglib-nodep/2.2
// https://mvnrepository.com/artifact/cglib/cglib/2.2
// 注意 这个和 cglib-nodep/2.2 同时存在 有可能报错  org.objectweb.asm.ClassWriter.<init>(I)V
// 我在测试的时候 时 去掉了 cglib/2.2


// 执行结果如下
//say将要被执行
//hello everyone
//say执行完成
public class CglibProxy implements MethodInterceptor {
    Enhancer enhancer = new Enhancer();

    public Object getProxy(Class clazz){
        //设置需要创建子类的类 ,即Student
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        //通过字节码技术动态创建子类实例
        return enhancer.create();
    }

    @Override
    public Object intercept(Object object, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println(methodProxy.getSignature().getName()+"将要被执行");
        //通过代理类调用父类中的方法
        Object result = methodProxy.invokeSuper(object, args);
        System.out.println(methodProxy.getSignature().getName()+"执行完成");
        return result;

    }
}
