package com.sjh.factory;

import com.sjh.entity.Car;

import java.util.HashMap;
import java.util.Map;

//创建Car的静态工厂
public class StaticFactory {

    private static Map<Integer, Car> carMap;

    static {
        carMap = new HashMap<>();
        carMap.put(1,new Car(1,"宝马"));
        carMap.put(2,new Car(2,"奔驰"));
    }

    public static Car getCar(Integer id){
        return carMap.get(id);
    }
}
