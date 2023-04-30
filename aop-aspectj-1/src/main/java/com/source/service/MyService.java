package com.source.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class MyService {

    private static final Logger log = LoggerFactory.getLogger(MyService.class);

    //注意看target下编译好的类有什么变化
    public static void foo() {
        log.debug("foo()");
    }
}
