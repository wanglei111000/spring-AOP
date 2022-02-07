package com.st.sp.impl;

import com.st.sp.api.Caculater;
//被代理的接口实现类
public class MyCaculater implements Caculater {
    @Override
    public int add(int i, int j) {

        return i + j;
    }

    @Override
    public int min(int i, int j) {
        return i - j;
    }

    @Override
    public int multi(int i, int j) {
        return i * j;
    }

    @Override
    public int div(int i, int j) {
        return i / j;
    }
}
