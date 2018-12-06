package com;

import java.lang.ref.WeakReference;

public class WeakRef {
    public static void main(String[] args) {
        Object o = new Object();
        o=null;
        WeakReference<Object> weakReference=new WeakReference<Object>(o);
        Object o1=weakReference.get();

    }
}
