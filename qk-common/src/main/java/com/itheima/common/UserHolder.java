package com.itheima.common;

import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class UserHolder<T> {
    private ThreadLocal<T> tl = new ThreadLocal<>();

    public void set(T data) {
        tl.set(data);
    }

    public T get() {
        return tl.get();
    }

    public void remove() {
        tl.remove();
    }

    public Integer getUserId() {
        Map map  = (Map) tl.get();
        Object id = map.get("id");
        return Integer.parseInt(id.toString());
    }
}
