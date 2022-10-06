package pl.bucko.external_stock.service;


import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.TimerTask;

@Service
public class CacheService extends TimerTask {

    public String clearCacheOnTime(String startHour) throws IOException, UnirestException {

        Unirest.setTimeouts(0, 0);
        HttpResponse<String> response = Unirest.post("https://api.cloudflare.com/client/v4/zones/0b24c6e8c14e17691286dabb692a3076/purge_cache")
                .header("Content-Type", "application/json")
                .header("X-Auth-Email", "")
                .header("X-Auth-Key", "")
                .header("Authorization", "")
                .header("Cookie", "__cflb=0H28vgHxwvgAQtjUGU56Rb8iNWZVUvXhp96biURfGoo; __cfruid=15d7170a99a3d7c4e4cdef1a34ba7f685a6cfdad-1642060335")
                .body("{\"purge_everything\":true}")
                .asString();

        return "6:00";
    }

    @Override
    public void run() {
        System.out.println("start");

        Unirest.setTimeouts(0, 0);
        try {
            HttpResponse<String> response = Unirest.post("https://api.cloudflare.com/client/v4/zones/0b24c6e8c14e17691286dabb692a3076/purge_cache")
                    .header("Content-Type", "application/json")
                    .header("X-Auth-Email", "")
                    .header("X-Auth-Key", "")
                    .header("Authorization", "")
                    .header("Cookie", "__cflb=0H28vgHxwvgAQtjUGU56Rb8iNWZVUvXhp96biURfGoo; __cfruid=15d7170a99a3d7c4e4cdef1a34ba7f685a6cfdad-1642060335")
                    .body("{\"purge_everything\":true}")
                    .asString();
        } catch (UnirestException e) {
            e.printStackTrace();
        }


    }
}
