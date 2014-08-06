/**
 * Copyright (c) 2005-2012 https://github.com/zhangkaitao
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.sishuok.hello;

import org.springframework.context.ApplicationEvent;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 13-7-8 下午9:09
 * <p>Version: 1.0
 */
public class ContentEvent extends ApplicationEvent {
    public ContentEvent(final String content) {
        super(content);
    }
}
