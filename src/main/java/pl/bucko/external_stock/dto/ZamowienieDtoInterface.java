package pl.bucko.external_stock.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;

public interface ZamowienieDtoInterface {

    long getIdPozycjiZamowienia();
    long getIdZamowienia();
    String getIndeksKatalogowy();
    String getWaga();
    BigDecimal getOdDostawcow();
    BigDecimal getStan();
    BigDecimal getStanMinimalny();
    BigDecimal getZamowiono();
    String getNumerZamowienia();
    Timestamp getData();
    String getKontrahent();
    String getNazwa();

}
