package pl.bucko.external_stock.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name="POZYCJA_ZAMOWIENIA")
public class PozycjaZamowienia implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="ID_POZYCJI_ZAMOWIENIA")
    private long idPozycjiZamowienia;

    @Column(name="CENA_BRUTTO")
    private BigDecimal cenaBrutto;

    @Column(name="CENA_BRUTTO_WAL")
    private BigDecimal cenaBruttoWal;

    @Column(name="CENA_NETTO")
    private BigDecimal cenaNetto;

    @Column(name="CENA_NETTO_WAL")
    private BigDecimal cenaNettoWal;

    @Column(name="DO_REALIZACJI")
    private BigDecimal doRealizacji;

    @Column(name="DO_REZ_POP")
    private BigDecimal doRezPop;

    @Column(name="DO_REZ_USER")
    private BigDecimal doRezUser;

    @Column(name="DO_REZERWACJI")
    private BigDecimal doRezerwacji;

    @Column(name="ID_ARTYKULU")
    private BigDecimal idArtykulu;

    @Column(name="ID_DOSTAWY_REZ")
    private BigDecimal idDostawyRez;

    @Column(name="ID_ETYKIETY")
    private BigDecimal idEtykiety;

    @Column(name="ID_POZYCJI_OFERTY")
    private BigDecimal idPozycjiOferty;

    @Column(name="ID_WARIANTU")
    private BigDecimal idWariantu;

    @Column(name="ID_ZAMOWIENIA")
    private BigDecimal idZamowienia;

    @Column(name="JEDNOSTKA")
    private String jednostka;

    @Column(name="KOD_VAT")
    private String kodVat;

    @Column(name="NARZUT")
    private BigDecimal narzut;

    @Column(name="NR_SERII")
    private String nrSerii;

    @Column(name="OPIS")
    private String opis;

    @Column(name="POLE1")
    private String pole1;

    @Column(name="POLE10")
    private String pole10;

    @Column(name="POLE2")
    private String pole2;

    @Column(name="POLE3")
    private String pole3;

    @Column(name="POLE4")
    private String pole4;

    @Column(name="POLE5")
    private String pole5;

    @Column(name="POLE6")
    private String pole6;

    @Column(name="POLE7")
    private String pole7;

    @Column(name="POLE8")
    private String pole8;

    @Column(name="POLE9")
    private String pole9;

    @Column(name="PRZELICZNIK")
    private BigDecimal przelicznik;

    @Column(name="STAN_ZREALIZOWANO")
    private BigDecimal stanZrealizowano;

    @Column(name="TRYBREJESTRACJI")
    private Integer trybrejestracji;

    @Column(name="TYP")
    private Integer typ;

    @Column(name="ZAMOWIONO")
    private BigDecimal zamowiono;

    @Column(name="ZAREZERWOWANO")
    private BigDecimal zarezerwowano;

    @Column(name="ZNACZNIK_CENY")
    private String znacznikCeny;

    @Column(name="ZREALIZOWANO")
    private BigDecimal zrealizowano;

    public PozycjaZamowienia() {
    }

    public PozycjaZamowienia(long idPozycjiZamowienia, BigDecimal cenaBrutto, BigDecimal cenaBruttoWal, BigDecimal cenaNetto, BigDecimal cenaNettoWal, BigDecimal doRealizacji, BigDecimal doRezPop, BigDecimal doRezUser, BigDecimal doRezerwacji, BigDecimal idArtykulu, BigDecimal idDostawyRez, BigDecimal idEtykiety, BigDecimal idPozycjiOferty, BigDecimal idWariantu, BigDecimal idZamowienia, String jednostka, String kodVat, BigDecimal narzut, String nrSerii, String opis, String pole1, String pole10, String pole2, String pole3, String pole4, String pole5, String pole6, String pole7, String pole8, String pole9, BigDecimal przelicznik, BigDecimal stanZrealizowano, Integer trybrejestracji, Integer typ, BigDecimal zamowiono, BigDecimal zarezerwowano, String znacznikCeny, BigDecimal zrealizowano) {
        this.idPozycjiZamowienia = idPozycjiZamowienia;
        this.cenaBrutto = cenaBrutto;
        this.cenaBruttoWal = cenaBruttoWal;
        this.cenaNetto = cenaNetto;
        this.cenaNettoWal = cenaNettoWal;
        this.doRealizacji = doRealizacji;
        this.doRezPop = doRezPop;
        this.doRezUser = doRezUser;
        this.doRezerwacji = doRezerwacji;
        this.idArtykulu = idArtykulu;
        this.idDostawyRez = idDostawyRez;
        this.idEtykiety = idEtykiety;
        this.idPozycjiOferty = idPozycjiOferty;
        this.idWariantu = idWariantu;
        this.idZamowienia = idZamowienia;
        this.jednostka = jednostka;
        this.kodVat = kodVat;
        this.narzut = narzut;
        this.nrSerii = nrSerii;
        this.opis = opis;
        this.pole1 = pole1;
        this.pole10 = pole10;
        this.pole2 = pole2;
        this.pole3 = pole3;
        this.pole4 = pole4;
        this.pole5 = pole5;
        this.pole6 = pole6;
        this.pole7 = pole7;
        this.pole8 = pole8;
        this.pole9 = pole9;
        this.przelicznik = przelicznik;
        this.stanZrealizowano = stanZrealizowano;
        this.trybrejestracji = trybrejestracji;
        this.typ = typ;
        this.zamowiono = zamowiono;
        this.zarezerwowano = zarezerwowano;
        this.znacznikCeny = znacznikCeny;
        this.zrealizowano = zrealizowano;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public long getIdPozycjiZamowienia() {
        return idPozycjiZamowienia;
    }

    public void setIdPozycjiZamowienia(long idPozycjiZamowienia) {
        this.idPozycjiZamowienia = idPozycjiZamowienia;
    }

    public BigDecimal getCenaBrutto() {
        return cenaBrutto;
    }

    public void setCenaBrutto(BigDecimal cenaBrutto) {
        this.cenaBrutto = cenaBrutto;
    }

    public BigDecimal getCenaBruttoWal() {
        return cenaBruttoWal;
    }

    public void setCenaBruttoWal(BigDecimal cenaBruttoWal) {
        this.cenaBruttoWal = cenaBruttoWal;
    }

    public BigDecimal getCenaNetto() {
        return cenaNetto;
    }

    public void setCenaNetto(BigDecimal cenaNetto) {
        this.cenaNetto = cenaNetto;
    }

    public BigDecimal getCenaNettoWal() {
        return cenaNettoWal;
    }

    public void setCenaNettoWal(BigDecimal cenaNettoWal) {
        this.cenaNettoWal = cenaNettoWal;
    }

    public BigDecimal getDoRealizacji() {
        return doRealizacji;
    }

    public void setDoRealizacji(BigDecimal doRealizacji) {
        this.doRealizacji = doRealizacji;
    }

    public BigDecimal getDoRezPop() {
        return doRezPop;
    }

    public void setDoRezPop(BigDecimal doRezPop) {
        this.doRezPop = doRezPop;
    }

    public BigDecimal getDoRezUser() {
        return doRezUser;
    }

    public void setDoRezUser(BigDecimal doRezUser) {
        this.doRezUser = doRezUser;
    }

    public BigDecimal getDoRezerwacji() {
        return doRezerwacji;
    }

    public void setDoRezerwacji(BigDecimal doRezerwacji) {
        this.doRezerwacji = doRezerwacji;
    }

    public BigDecimal getIdArtykulu() {
        return idArtykulu;
    }

    public void setIdArtykulu(BigDecimal idArtykulu) {
        this.idArtykulu = idArtykulu;
    }

    public BigDecimal getIdDostawyRez() {
        return idDostawyRez;
    }

    public void setIdDostawyRez(BigDecimal idDostawyRez) {
        this.idDostawyRez = idDostawyRez;
    }

    public BigDecimal getIdEtykiety() {
        return idEtykiety;
    }

    public void setIdEtykiety(BigDecimal idEtykiety) {
        this.idEtykiety = idEtykiety;
    }

    public BigDecimal getIdPozycjiOferty() {
        return idPozycjiOferty;
    }

    public void setIdPozycjiOferty(BigDecimal idPozycjiOferty) {
        this.idPozycjiOferty = idPozycjiOferty;
    }

    public BigDecimal getIdWariantu() {
        return idWariantu;
    }

    public void setIdWariantu(BigDecimal idWariantu) {
        this.idWariantu = idWariantu;
    }

    public BigDecimal getIdZamowienia() {
        return idZamowienia;
    }

    public void setIdZamowienia(BigDecimal idZamowienia) {
        this.idZamowienia = idZamowienia;
    }

    public String getJednostka() {
        return jednostka;
    }

    public void setJednostka(String jednostka) {
        this.jednostka = jednostka;
    }

    public String getKodVat() {
        return kodVat;
    }

    public void setKodVat(String kodVat) {
        this.kodVat = kodVat;
    }

    public BigDecimal getNarzut() {
        return narzut;
    }

    public void setNarzut(BigDecimal narzut) {
        this.narzut = narzut;
    }

    public String getNrSerii() {
        return nrSerii;
    }

    public void setNrSerii(String nrSerii) {
        this.nrSerii = nrSerii;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getPole1() {
        return pole1;
    }

    public void setPole1(String pole1) {
        this.pole1 = pole1;
    }

    public String getPole10() {
        return pole10;
    }

    public void setPole10(String pole10) {
        this.pole10 = pole10;
    }

    public String getPole2() {
        return pole2;
    }

    public void setPole2(String pole2) {
        this.pole2 = pole2;
    }

    public String getPole3() {
        return pole3;
    }

    public void setPole3(String pole3) {
        this.pole3 = pole3;
    }

    public String getPole4() {
        return pole4;
    }

    public void setPole4(String pole4) {
        this.pole4 = pole4;
    }

    public String getPole5() {
        return pole5;
    }

    public void setPole5(String pole5) {
        this.pole5 = pole5;
    }

    public String getPole6() {
        return pole6;
    }

    public void setPole6(String pole6) {
        this.pole6 = pole6;
    }

    public String getPole7() {
        return pole7;
    }

    public void setPole7(String pole7) {
        this.pole7 = pole7;
    }

    public String getPole8() {
        return pole8;
    }

    public void setPole8(String pole8) {
        this.pole8 = pole8;
    }

    public String getPole9() {
        return pole9;
    }

    public void setPole9(String pole9) {
        this.pole9 = pole9;
    }

    public BigDecimal getPrzelicznik() {
        return przelicznik;
    }

    public void setPrzelicznik(BigDecimal przelicznik) {
        this.przelicznik = przelicznik;
    }

    public BigDecimal getStanZrealizowano() {
        return stanZrealizowano;
    }

    public void setStanZrealizowano(BigDecimal stanZrealizowano) {
        this.stanZrealizowano = stanZrealizowano;
    }

    public Integer getTrybrejestracji() {
        return trybrejestracji;
    }

    public void setTrybrejestracji(Integer trybrejestracji) {
        this.trybrejestracji = trybrejestracji;
    }

    public Integer getTyp() {
        return typ;
    }

    public void setTyp(Integer typ) {
        this.typ = typ;
    }

    public BigDecimal getZamowiono() {
        return zamowiono;
    }

    public void setZamowiono(BigDecimal zamowiono) {
        this.zamowiono = zamowiono;
    }

    public BigDecimal getZarezerwowano() {
        return zarezerwowano;
    }

    public void setZarezerwowano(BigDecimal zarezerwowano) {
        this.zarezerwowano = zarezerwowano;
    }

    public String getZnacznikCeny() {
        return znacznikCeny;
    }

    public void setZnacznikCeny(String znacznikCeny) {
        this.znacznikCeny = znacznikCeny;
    }

    public BigDecimal getZrealizowano() {
        return zrealizowano;
    }

    public void setZrealizowano(BigDecimal zrealizowano) {
        this.zrealizowano = zrealizowano;
    }
}
