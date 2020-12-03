package com.ashwin.routeimpl;

import com.ashwin.dto.RequestDto;
import com.ashwin.dto.ResponseDto;
import com.ashwin.mapper.GreetingMapper;
import com.ashwin.route.GreetingRoute;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GreetingRouteClient implements GreetingRoute {
    private String host;

    public GreetingRouteClient(String host) {
        this.host = host;
    }

    @Override
    public ResponseDto greeting(RequestDto request) {
        try {
            String data = GreetingMapper.toJson(request);

            HttpClient httpClient = HttpClient.newBuilder().build();
            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .uri(URI.create(host + "greeting/"))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(data))
                    .build();

            HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            System.out.println("Client response | status: " + httpResponse.statusCode() + ", body: " + httpResponse.body());
            return GreetingMapper.toResponse(httpResponse.body());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
