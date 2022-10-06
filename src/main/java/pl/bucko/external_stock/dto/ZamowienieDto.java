package pl.bucko.external_stock.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class ZamowienieDto {

    private long idPozycjiZamowienia;
    private long idZamowienia;
    private String indeksKatalogowy;
    private String waga;
    private BigDecimal odDostawcow;
    private BigDecimal stan;
    private BigDecimal stanMinimalny;
    private BigDecimal zamowiono;
    private String numerZamowienia;
    private Timestamp data;
    private String kontrahent;
    private String nazwa;

    public ZamowienieDto() {
    }

    public ZamowienieDto(long idPozycjiZamowienia, long idZamowienia, String indeksKatalogowy, String waga, BigDecimal odDostawcow, BigDecimal stan, BigDecimal stanMinimalny, BigDecimal zamowiono, String numerZamowienia, Timestamp data, String kontrahent, String nazwa) {
        this.idPozycjiZamowienia = idPozycjiZamowienia;
        this.idZamowienia = idZamowienia;
        this.indeksKatalogowy = indeksKatalogowy;
        this.waga = waga;
        this.odDostawcow = odDostawcow;
        this.stan = stan;
        this.stanMinimalny = stanMinimalny;
        this.zamowiono = zamowiono;
        this.numerZamowienia = numerZamowienia;
        this.data = data;
        this.kontrahent = kontrahent;
        this.nazwa = nazwa;
    }

    public long getIdPozycjiZamowienia() {
        return idPozycjiZamowienia;
    }

    public void setIdPozycjiZamowienia(long idPozycjiZamowienia) {
        this.idPozycjiZamowienia = idPozycjiZamowienia;
    }

    public long getIdZamowienia() {
        return idZamowienia;
    }

    public void setIdZamowienia(long idZamowienia) {
        this.idZamowienia = idZamowienia;
    }

    public String getIndeksKatalogowy() {
        return indeksKatalogowy;
    }

    public void setIndeksKatalogowy(String indeksKatalogowy) {
        this.indeksKatalogowy = indeksKatalogowy;
    }

    public String getWaga() {
        return waga;
    }

    public void setWaga(String waga) {
        this.waga = waga;
    }

    public BigDecimal getOdDostawcow() {
        return odDostawcow;
    }

    public void setOdDostawcow(BigDecimal odDostawcow) {
        this.odDostawcow = odDostawcow;
    }

    public BigDecimal getStan() {
        return stan;
    }

    public void setStan(BigDecimal stan) {
        this.stan = stan;
    }

    public BigDecimal getStanMinimalny() {
        return stanMinimalny;
    }

    public void setStanMinimalny(BigDecimal stanMinimalny) {
        this.stanMinimalny = stanMinimalny;
    }

    public BigDecimal getZamowiono() {
        return zamowiono;
    }

    public void setZamowiono(BigDecimal zamowiono) {
        this.zamowiono = zamowiono;
    }

    public String getNumerZamowienia() {
        return numerZamowienia;
    }

    public void setNumerZamowienia(String numerZamowienia) {
        this.numerZamowienia = numerZamowienia;
    }

    public Timestamp getData() {
        return data;
    }

    public void setData(Timestamp data) {
        this.data = data;
    }

    public String getKontrahent() {
        return kontrahent;
    }

    public void setKontrahent(String kontrahent) {
        this.kontrahent = kontrahent;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }
}
