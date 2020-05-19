package com.sjh.utils.impl;

import com.sjh.utils.Cal;
import org.springframework.stereotype.Component;

@Component
public class CalImpl implements Cal {

    @Override
    public int add(int a, int b) {
        int res = a + b;
        return res;
    }

    @Override
    public int sub(int a, int b) {
        int res = a - b;
        return res;
    }

    @Override
    public int mul(int a, int b) {
        int res = a * b;
        return res;
    }

    @Override
    public int div(int a, int b) {
        int res = a / b;
        return res;
    }
}
