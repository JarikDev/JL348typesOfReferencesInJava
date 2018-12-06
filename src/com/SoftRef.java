package com;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class SoftRef {
    public static void main(String[] args) {
        Object o = new Object();
        o=null;
        SoftReference<Object> softReference=new SoftReference<Object>(o);
        Object o1=softReference.get();
    }
}
