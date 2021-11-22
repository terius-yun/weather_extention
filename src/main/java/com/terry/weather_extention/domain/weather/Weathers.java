package com.terry.weather_extention.domain.weather;

import com.terry.weather_extention.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@Entity
public class Weathers extends BaseTimeEntity {

    @Column(length = 3)
    @Id
    private int id; // 날씨 ID

    @Column(length = 30)
    private String description;//날씨 설명

    @Column(length = 5)
    private float temp;//온도

    @Column(length = 5)
    private int humidity; //습도

    @Builder
    public Weathers(int id, String description, float temp, int humidity){
        this.id = id;
        this.description = description;
        this.temp = temp;
        this.humidity = humidity;
    }

    public void update(int id, String description, float temp, int humidity){
        this.id = id;
        this.description = description;
        this.temp = temp;
        this.humidity = humidity;
    }
}
