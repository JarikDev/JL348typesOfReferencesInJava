package com;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;

public class AllRefs {
    public static void main(String[] args) {
        MyObject o = new MyObject();
        SoftReference<MyObject> softReference=new SoftReference<MyObject>(o);
        WeakReference<MyObject> weakReference=new WeakReference<MyObject>(o);
        ReferenceQueue<MyObject> referenceQueue=new ReferenceQueue<>();
        PhantomReference<MyObject> phantomReference=new PhantomReference<MyObject>(o,referenceQueue);
        o=null;
        System.out.println(softReference.get());
        System.out.println(weakReference.get());
        System.out.println(phantomReference.get());

        List<Integer> list=new ArrayList<>();
        for (int i = 0; i < 100000000; i++) {
            list.add(i);
        }

        System.gc();
        System.out.println("#######################");
        System.out.println(softReference.get());
        System.out.println(weakReference.get());
        System.out.println(phantomReference.get());

        WeakHashMap weakHashMap=new WeakHashMap();



    }
    static class MyObject extends Object{
        @Override
        protected void finalize() throws Throwable {
            System.out.println("Was finalized");
        }
    }
}
