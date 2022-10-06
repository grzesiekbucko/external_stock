package pl.bucko.external_stock.dto;

import java.math.BigDecimal;

public class ArtykulJoinDto {

    private long idArtykulu;
    private String indeksKatalogowy;
    private BigDecimal stan;
    private BigDecimal iloscSprzedana;
    private BigDecimal pozMagazynowa;
    private BigDecimal stanMinimalny;
    private BigDecimal stanMaksymalny;
    private String dostawca;

    public ArtykulJoinDto() {
    }

    public ArtykulJoinDto(long idArtykulu, String indeksKatalogowy, BigDecimal stan, BigDecimal iloscSprzedana, BigDecimal pozMagazynowa, BigDecimal stanMinimalny, BigDecimal stanMaksymalny, String dostawca) {
        this.idArtykulu = idArtykulu;
        this.indeksKatalogowy = indeksKatalogowy;
        this.stan = stan;
        this.iloscSprzedana = iloscSprzedana;
        this.pozMagazynowa = pozMagazynowa;
        this.stanMinimalny = stanMinimalny;
        this.stanMaksymalny = stanMaksymalny;
        this.dostawca = dostawca;
    }

    public ArtykulJoinDto(long idArtykulu, String indeksKatalogowy, BigDecimal stan, BigDecimal iloscSprzedana, BigDecimal stanMinimalny, BigDecimal stanMaksymalny, String dostawca) {
        this.idArtykulu = idArtykulu;
        this.indeksKatalogowy = indeksKatalogowy;
        this.stan = stan;
        this.iloscSprzedana = iloscSprzedana;
        this.stanMinimalny = stanMinimalny;
        this.stanMaksymalny = stanMaksymalny;
        this.dostawca = dostawca;
    }

    public long getIdArtykulu() {
        return idArtykulu;
    }

    public void setIdArtykulu(long idArtykulu) {
        this.idArtykulu = idArtykulu;
    }

    public String getIndeksKatalogowy() {
        return indeksKatalogowy;
    }

    public void setIndeksKatalogowy(String indeksKatalogowy) {
        this.indeksKatalogowy = indeksKatalogowy;
    }

    public BigDecimal getStan() {
        return stan;
    }

    public void setStan(BigDecimal stan) {
        this.stan = stan;
    }

    public BigDecimal getIloscSprzedana() {
        return iloscSprzedana;
    }

    public void setIloscSprzedana(BigDecimal iloscSprzedana) {
        this.iloscSprzedana = iloscSprzedana;
    }

    public BigDecimal getPozMagazynowa() {
        return pozMagazynowa;
    }

    public void setPozMagazynowa(BigDecimal pozMagazynowa) {
        this.pozMagazynowa = pozMagazynowa;
    }

    public BigDecimal getStanMinimalny() {
        return stanMinimalny;
    }

    public void setStanMinimalny(BigDecimal stanMinimalny) {
        this.stanMinimalny = stanMinimalny;
    }

    public BigDecimal getStanMaksymalny() {
        return stanMaksymalny;
    }

    public void setStanMaksymalny(BigDecimal stanMaksymalny) {
        this.stanMaksymalny = stanMaksymalny;
    }

    public String getDostawca() {
        return dostawca;
    }

    public void setDostawca(String dostawca) {
        this.dostawca = dostawca;
    }
}
