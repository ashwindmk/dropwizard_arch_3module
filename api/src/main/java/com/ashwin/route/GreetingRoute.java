package com.ashwin.route;

import com.ashwin.dto.RequestDto;
import com.ashwin.dto.ResponseDto;

public interface GreetingRoute {
    public ResponseDto greeting(RequestDto request);
}
