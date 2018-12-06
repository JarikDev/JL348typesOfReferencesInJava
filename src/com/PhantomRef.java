package com;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;

public class PhantomRef {
    public static void main(String[] args) throws InterruptedException {
        MyObject o = new MyObject();
        ReferenceQueue<MyObject>referenceQueue=new ReferenceQueue<>();
        PhantomReference<MyObject> phantomReference=new PhantomReference<MyObject>(o,referenceQueue);
        o=null;
        new Thread(){
            @Override
            public void run() {
                try {
                    referenceQueue.remove();
                    System.out.println("Reference was removed");
                }catch (InterruptedException e){e.printStackTrace();}
            }
        }.start();
        System.out.println("Start GC");
        System.gc();
        System.out.println("GC was started");
    }
    static class MyObject{
        @Override
        protected void finalize() throws Throwable {
            System.out.println("Object was finalized" );
        }
    }
}
