package com.terry.weather_extention.service.weather;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.NoArgsConstructor;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.charset.Charset;

@Service
@NoArgsConstructor
public class CallWeather {

        @Value("${cloud.api.token}")
        private String token;

        Charset charSet = Charset.forName("UTF-8");

        JsonObject jsonObject = new JsonObject();
        JsonObject mmsAttach = new JsonObject();
        JsonArray jsonArray = new JsonArray();
        JsonParser parser = new JsonParser();

        String result = null;

        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;


        public String getWeather() throws IOException {
            String result = "";

            CloseableHttpClient httpClient = HttpClients.createDefault();

            HttpGet httpGet = new HttpGet("https://api.openweathermap.org/data/2.5/weather?id=1835847&units=metric&lang=kr&callback=test&appid="+this.token);
            System.out.println("https://api.openweathermap.org/data/2.5/weather?id=1835847&units=metric&lang=kr&callback=test&appid="+this.token);

    //        httpPost.setEntity(new StringEntity(String.valueOf(jsonObject)));
            httpGet.addHeader("Content-type", "application/json;charset=UTF-8");
            httpGet.addHeader("Accept", "application/json");

            CloseableHttpResponse response = httpClient.execute(httpGet);
            response.setHeader("Access-Control-Allow-Origin", "*");

            result = EntityUtils.toString(response.getEntity());
            result = result.substring(5,result.length()-1);
            System.out.println(result);

            return result;
        }

}
