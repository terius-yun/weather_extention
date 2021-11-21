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
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.charset.Charset;

@Service
@NoArgsConstructor
public class CallWeather {

        private static String token;

        Charset charSet = Charset.forName("UTF-8");

        @Value("${cloud.api.token}")
        public void setToken(String token) {
            this.token = token;
        }

        public String getWeather() throws IOException {
            String result = "";

            CloseableHttpClient httpClient = HttpClients.createDefault();

            HttpGet httpGet = new HttpGet("https://api.openweathermap.org/data/2.5/weather?id=1835847&units=metric&lang=kr&callback=test&appid="+token);
            System.out.println("https://api.openweathermap.org/data/2.5/weather?id=1835847&units=metric&lang=kr&callback=test&appid="+token);

    //        httpPost.setEntity(new StringEntity(String.valueOf(jsonObject)));
            httpGet.addHeader("Content-type", "application/json;charset=UTF-8");
            httpGet.addHeader("Accept", "application/json");

            CloseableHttpResponse response = httpClient.execute(httpGet);
            response.setHeader("Access-Control-Allow-Origin", "*");

            result = EntityUtils.toString(response.getEntity());
            result = result.substring(5,result.length()-1);
            System.out.println(result);

            JSONObject jsonObject = new JSONObject(result);

            JSONObject jsonWheather = jsonObject.getJSONArray("weather").getJSONObject(0);
            JSONObject jsonMain = jsonObject.getJSONObject("main");

            int wheatherId = jsonWheather.getInt("id");
            String wheatherDes = jsonWheather.getString("description");
            float wheatherTemp = jsonMain.getFloat("temp");
            int wheatherHum = jsonMain.getInt("humidity");

            System.out.println(wheatherHum +" / "+ wheatherId +" / "+ wheatherTemp +" / "+ wheatherDes);

            return result;
        }

}
