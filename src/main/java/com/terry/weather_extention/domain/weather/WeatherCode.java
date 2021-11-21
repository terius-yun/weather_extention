package com.terry.weather_extention.domain.weather;

import com.terry.weather_extention.domain.BaseTimeEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@Entity
public class WeatherCode extends BaseTimeEntity {
    @Column(length = 3)
    @Id
    private int id; // 날씨 ID

    @Column(length = 20)
    private String main;//날씨 설명

    @Column(length = 30)
    private String description;//날씨 설명
}
