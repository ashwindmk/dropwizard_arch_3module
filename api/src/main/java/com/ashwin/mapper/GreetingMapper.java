package com.ashwin.mapper;

import com.ashwin.dto.RequestDto;
import com.ashwin.dto.ResponseDto;
import com.ashwin.model.Greeting;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GreetingMapper {
    public static Greeting toGreeting(String message, String name) {
        return new Greeting(message, name);
    }

    public static ResponseDto toResponse(String json) {
        Pattern greetingPattern = Pattern.compile("\"greeting\":\\s*\".*\"");
        Matcher greetingMatcher = greetingPattern.matcher(json);
        if (greetingMatcher.find()) {
            String keyValue = greetingMatcher.group(0);
            String greeting = getValue(keyValue);
            return new ResponseDto(greeting);
        }
        return null;
    }

    public static ResponseDto toResponse(Greeting greeting) {
        return new ResponseDto(greeting.toString());
    }

    public static String toJson(RequestDto request) {
        String name = request.getName();
        return new StringBuilder()
                .append("{")
                .append("\"name\": \"")
                .append(name)
                .append("\"")
                .append("}")
                .toString();
    }

    public static Greeting fromJson(String json) {
        Pattern messagePattern = Pattern.compile("\"message\":\\s*\".*\"");
        Pattern namePattern = Pattern.compile("\"name\":\\s*\".*\"");

        Matcher nameMatcher = namePattern.matcher(json);
        Matcher messageMatcher = messagePattern.matcher(json);

        String message = null;
        if (messageMatcher.find()) {
            String keyValue = messageMatcher.group(0);
            message = getValue(keyValue);
        }

        String name = null;
        if (nameMatcher.find()) {
            String keyValue = nameMatcher.group(0);
            name = getValue(keyValue);
        }

        return toGreeting(message, name);
    }

    private static String getValue(String keyValue) {
        String[] arr = keyValue.split(":");
        String value = arr[1].trim();
        return value.substring(1, value.length() - 1);
    }
}
