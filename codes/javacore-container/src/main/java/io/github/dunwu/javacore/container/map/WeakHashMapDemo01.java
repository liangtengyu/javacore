package io.github.dunwu.javacore.container.map;

import io.github.dunwu.javacore.container.bean.Person;

import java.util.Map;
import java.util.WeakHashMap;

public class WeakHashMapDemo01 {

    public static void main(String[] args) {
        Map<String, Person> map = null; // 声明Map对象，其中key和value的类型为String
        map = new WeakHashMap<>();
        for (int i = 0; i < 20; i++) {
            map.put("key"+i, new Person("name" + i, i));
        }
        System.out.println("进行垃圾回收之前的map为:"+map);
        System.gc();    // 强制性进行垃圾的收集操作
        map.put("InsertNewKey", new Person("TestName",100));
        System.out.println("");
        System.out.println("进行垃圾回收之后的map"+map);
    }

}
