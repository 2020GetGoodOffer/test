package com.sjh.factory;

import com.sjh.entity.Car;

import java.util.HashMap;
import java.util.Map;

//创建Car的实例工厂
public class InstanceFactory {

    private Map<Integer, Car> carMap;

    public InstanceFactory(){
        carMap = new HashMap<>();
        carMap.put(1,new Car(1,"宝马"));
        carMap.put(2,new Car(2,"奔驰"));
    }

    public Car getCar(Integer id){
        return carMap.get(id);
    }
}
