package com.ashwin.routeimpl;

import com.ashwin.dto.RequestDto;
import com.ashwin.dto.ResponseDto;
import com.ashwin.mapper.GreetingMapper;
import com.ashwin.model.Greeting;
import com.ashwin.route.GreetingRoute;
import com.ashwin.service.GreetingService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/greeting")
public class GreetingRouteImpl implements GreetingRoute {
    @Inject
    private GreetingService greetingService;

    @Override
    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseDto greeting(RequestDto request) {
        String name = request.getName();
        Greeting greeting = greetingService.generateGreeting(name);
        return GreetingMapper.toResponse(greeting);
    }
}
