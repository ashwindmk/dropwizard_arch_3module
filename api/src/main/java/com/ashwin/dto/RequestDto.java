package com.ashwin.dto;

public class RequestDto {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "RequestDto{" +
                "name='" + name + '\'' +
                '}';
    }
}
