package pl.bucko.external_stock.dto;

import java.math.BigDecimal;

public interface KompletyDtoInterface {

    String getIndeksKatalogowyKomplet();
    BigDecimal getIlosckomplet();
    String getIndeksKatalogowyProdukt();
    BigDecimal getIloscProduct();
    String getDostawca();

}
