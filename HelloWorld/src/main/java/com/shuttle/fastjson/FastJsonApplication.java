package com.shuttle.fastjson;

import com.alibaba.fastjson2.JSON;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class FastJsonApplication {
    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("abc", 1);
        FastJsonObj fastJsonObj = new FastJsonObj(map);
//        FastJsonObj fastJsonObj1 = JSON.parseObject(JSON.toJSONString(fastJsonObj), FastJsonObj.class);

        System.out.println(JSON.toJSONString(fastJsonObj));
        Class<? extends FastJsonObj> aClass = fastJsonObj.getClass();
        Field[] fields = aClass.getFields();
        for (Field field : fields) {
            System.out.println(field.getName());
        }
    }
}
