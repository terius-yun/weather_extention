package com.terry.weather_extention.web.dto;

import com.terry.weather_extention.domain.weather.Weathers;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class WeathersSaveDto {
    private int id;
    private String description;//날씨 설명
    private float temp;//온도
    private int humidity; //습도

    @Builder
    public WeathersSaveDto(int id, String description, float temp, int humidity){
        this.id = id;
        this.description = description;
        this.temp = temp;
        this.humidity = humidity;
    }
    public Weathers toEntity(){
        return Weathers.builder()
                .id(id)
                .description(description)
                .temp(temp)
                .humidity(humidity)
                .build();
    }
}
