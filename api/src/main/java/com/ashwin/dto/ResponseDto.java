package com.ashwin.dto;

public class ResponseDto {
    private String greeting;

    public ResponseDto() {
    }

    public ResponseDto(String greeting) {
        this.greeting = greeting;
    }

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    @Override
    public String toString() {
        return "ResponseDto{" +
                "greeting='" + greeting + '\'' +
                '}';
    }
}
