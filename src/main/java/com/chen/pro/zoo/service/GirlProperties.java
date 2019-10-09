package com.chen.pro.zoo.service;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "girl")
public class GirlProperties {
    private String size;

    private Integer age;

    public String getSize() {
        return size;
    }

    public Integer getAge() {
        return age;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
