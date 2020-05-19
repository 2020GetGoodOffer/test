package com.sjh.feign;

import com.sjh.entity.Student;
import com.sjh.feign.impl.FeignError;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

@FeignClient(value = "provider",fallback = FeignError.class)//value值是服务提供者的名称
public interface FeignProvider {

    @GetMapping("/stu/findAll")
    Collection<Student> findAll();

    @GetMapping("/stu")
    String index();
}
