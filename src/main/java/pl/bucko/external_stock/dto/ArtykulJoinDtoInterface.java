package pl.bucko.external_stock.dto;

import java.math.BigDecimal;

public interface ArtykulJoinDtoInterface {

    long getIdArtykulu();
    String getIndeksKatalogowy();
    BigDecimal getStan();
    BigDecimal getIloscSprzedana();
    BigDecimal getStanMinimalny();
    BigDecimal getStanMaksymalny();
    String getDostawca();


}
