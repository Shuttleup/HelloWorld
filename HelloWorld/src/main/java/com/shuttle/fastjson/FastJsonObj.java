package com.shuttle.fastjson;

import lombok.Getter;

import java.util.Map;

@Getter
public class FastJsonObj {

    private Map<String, Object> map;

    public FastJsonObj(Map<String, Object> map) {
        this.map = map;
    }

    public Integer toInt(String key) {
        return (Integer) map.get(key);
    }

    @Override
    public String toString() {
        return "FastJsonObj{" +
                "map=" + map +
                '}';
    }
}
