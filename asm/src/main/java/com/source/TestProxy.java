package com.source;

import java.io.FileOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TestProxy {
    public static void main(String[] args) throws Exception {
        byte[] dump = $Proxy0Dump.dump();//字节数组

        //把利用asm生成的字节码写到class文件里，其实就是通过字节码文件反向生成了源码，源码和原来写的是一样的
        //FileOutputStream os = new FileOutputStream("$Proxy0.class");
        //os.write(dump, 0, dump.length);
        //os.close();


        //没必要生成class文件，key直接在内存中加载并使用
        ClassLoader loader = new ClassLoader() {
            @Override
            protected Class<?> findClass(String name) throws ClassNotFoundException {
                return super.defineClass(name, dump, 0, dump.length);
                //类名，字节数组，数组起始偏移量，总长度
            }
        };
        //得到类对象
        Class<?> proxyClass = loader.loadClass("com.source.$Proxy0");

        //获得构造方法
        Constructor<?> constructor = proxyClass.getConstructor(InvocationHandler.class);
        //创建类实例
        Foo proxy = (Foo) constructor.newInstance(new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("before...");
                System.out.println("调用目标");
                return null;
            }
        });

        proxy.foo();
    }
}
