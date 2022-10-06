package pl.bucko.external_stock.dto;

import java.math.BigDecimal;

public class KopmletyDto {

    String indeksKatalogowyKomplet;
    BigDecimal ilosckomplet;
    String indeksKatalogowyProdukt;
    BigDecimal iloscProduct;
    String dostawca;

    public KopmletyDto() {
    }

    public KopmletyDto(String indeksKatalogowyKomplet, BigDecimal ilosckomplet, String indeksKatalogowyProdukt, BigDecimal iloscProduct, String dostawca) {
        this.indeksKatalogowyKomplet = indeksKatalogowyKomplet;
        this.ilosckomplet = ilosckomplet;
        this.indeksKatalogowyProdukt = indeksKatalogowyProdukt;
        this.iloscProduct = iloscProduct;
        this.dostawca = dostawca;
    }

    public String getIndeksKatalogowyKomplet() {
        return indeksKatalogowyKomplet;
    }

    public void setIndeksKatalogowyKomplet(String indeksKatalogowyKomplet) {
        this.indeksKatalogowyKomplet = indeksKatalogowyKomplet;
    }

    public BigDecimal getIlosckomplet() {
        return ilosckomplet;
    }

    public void setIlosckomplet(BigDecimal ilosckomplet) {
        this.ilosckomplet = ilosckomplet;
    }

    public String getIndeksKatalogowyProdukt() {
        return indeksKatalogowyProdukt;
    }

    public void setIndeksKatalogowyProdukt(String indeksKatalogowyProdukt) {
        this.indeksKatalogowyProdukt = indeksKatalogowyProdukt;
    }

    public BigDecimal getIloscProduct() {
        return iloscProduct;
    }

    public void setIloscProduct(BigDecimal iloscProduct) {
        this.iloscProduct = iloscProduct;
    }

    public String getDostawca() {
        return dostawca;
    }

    public void setDostawca(String dostawca) {
        this.dostawca = dostawca;
    }
}
