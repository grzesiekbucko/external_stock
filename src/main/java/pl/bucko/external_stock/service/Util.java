package pl.bucko.external_stock.service;

import pl.bucko.external_stock.dto.ArtykulJoinDto;
import pl.bucko.external_stock.dto.ArtykulJoinDtoInterface;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Util {

    public static List<ArtykulJoinDto> policzSprzedaz(List<ArtykulJoinDtoInterface> products) {
        HashMap<Long, ArtykulJoinDto> finalMap = new HashMap<>();
        for (ArtykulJoinDtoInterface artykul : products) {
            Long id = artykul.getIdArtykulu();
            BigDecimal sprzedaz = artykul.getIloscSprzedana();
            if (finalMap.containsKey(id)) {
                BigDecimal nowaSprzedaz = finalMap.get(id).getIloscSprzedana().add(artykul.getIloscSprzedana());
                ArtykulJoinDto updatedSaleArtykul = finalMap.get(id);
                updatedSaleArtykul.setIloscSprzedana(nowaSprzedaz);
            } else {
                finalMap.put(id, new ArtykulJoinDto(artykul.getIdArtykulu(), artykul.getIndeksKatalogowy(), artykul.getStan(), artykul.getIloscSprzedana(), artykul.getStanMinimalny(), artykul.getStanMaksymalny(), artykul.getDostawca()));
            }
        }
        List<ArtykulJoinDto> finalList = new ArrayList<>();
        for (Long key : finalMap.keySet()) {
            finalList.add(finalMap.get(key));
        }

        return finalList;
    }


}
