package com.terry.weather_extention.web;

import com.terry.weather_extention.service.weather.CallWeather;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;

@RequiredArgsConstructor
@RestController
public class PostApiController {

    private CallWeather callWeather;

    @CrossOrigin("*")
    @ResponseBody
    @GetMapping("/api/v1/getWeather")
    public String getWeather() throws IOException {
        return callWeather.getWeather();
    }
}
