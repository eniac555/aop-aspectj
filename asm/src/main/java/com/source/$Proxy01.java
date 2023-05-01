package com.source;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.UndeclaredThrowableException;

/**
 * 通过ASM插件生成字节码
 */
public class $Proxy01 extends Proxy implements Foo {

    static Method foo;
    static {
        try {
            foo = Foo.class.getMethod("foo");
        } catch (NoSuchMethodException e) {
            throw new NoSuchMethodError(e.getMessage());
        }
    }

    /**
     * Constructs a new {@code Proxy} instance from a subclass
     * (typically, a dynamic proxy class) with the specified value
     * for its invocation handler.
     *
     * @param h the invocation handler for this proxy instance
     * @throws NullPointerException if the given invocation handler, {@code h},
     *                              is {@code null}.
     */
    public $Proxy01(InvocationHandler h) {
        super(h);
    }

    @Override
    public void foo() {
        try {
            this.h.invoke(this, foo, null);
        } catch (Throwable e) {
            throw new UndeclaredThrowableException(e);
        }
    }


}
