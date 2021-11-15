package com.terry.weather_extention.domain.weather;

import com.terry.weather_extention.domain.BaseTimeEntity;
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
    private int id;

    @Column(length = 20)
    private String discription;
}
