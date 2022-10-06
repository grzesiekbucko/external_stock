package pl.bucko.external_stock.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name="WIDOK_DOKUMENTMAGAZYNOWY")
public class WidokDokumentMagazynowy implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name="DataVAT")
    private Timestamp dataVAT;

    @Column(name="DataWystawienia")
    private Timestamp dataWystawienia;

    @Column(name="DataWystawieniaSys")
    private Integer dataWystawieniaSys;

    @Column(name="DokumentKorekty")
    private Integer dokumentKorekty;

    @Column(name="DokumentPrzychodowy")
    private Integer dokumentPrzychodowy;

    @Column(name="DokumentRozchodowy")
    private Integer dokumentRozchodowy;

    @Column(name="Handlowiec")
    private String handlowiec;

    @Id
    @Column(name="IdDokumentu")
    private Long idDokumentu;

    @Column(name="IdKontrahenta")
    private BigDecimal idKontrahenta;

    @Column(name="IdMagazynu")
    private BigDecimal idMagazynu;

    @Column(name="IdDokumentuHandlowego")
    private BigDecimal idDokumentuHandlowego;

    @Column(name="IdMagazynuDocelowego")
    private BigDecimal idMagazynuDocelowego;

    @Column(name="IdOrgFakturyZaliczkowej")
    private BigDecimal idOrgFakturyZaliczkowej;

    @Column(name="IdPracownika")
    private BigDecimal idPracownika;

    @Column(name="IdTypu")
    private BigDecimal idTypu;

    @Column(name="IdUzytkownika")
    private BigDecimal idUzytkownika;

    @Column(name="IdZlecenia")
    private BigDecimal idZlecenia;

    @Column(name="KOD_KRESKOWY")
    private String kodKreskowy;

    @Column(name="Numer")
    private String numer;

    @Column(name="NumerDokumentuHandlowego")
    private String numerDokumentuHandlowego;

    @Column(name="ObliczanieWgCen")
    private String obliczanieWgCen;

    @Column(name="Pole1")
    private String pole1;

    @Column(name="Pole10")
    private String pole10;

    @Column(name="Pole2")
    private String pole2;

    @Column(name="Pole3")
    private String pole3;

    @Column(name="Pole4")
    private String pole4;

    @Column(name="Pole5")
    private String pole5;

    @Column(name="Pole6")
    private String pole6;

    @Column(name="Pole7")
    private String pole7;

    @Column(name="Pole8")
    private String pole8;

    @Column(name="Pole9")
    private String pole9;

    @Column(name="RodzajDokumentu")
    private String rodzajDokumentu;

    @Column(name="TrybRejestracji")
    private Integer trybRejestracji;

    @Column(name="Uwagi")
    private String uwagi;

    @Column(name="WartoscBrutto")
    private BigDecimal wartoscBrutto;

    @Column(name="WartoscNetto")
    private BigDecimal wartoscNetto;

    @Column(name="WartoscVAT")
    private BigDecimal wartoscVAT;

    @Column(name="Wycena")
    private String wycena;

    @Column(name="Wyroznik")
    private String wyroznik;


    public WidokDokumentMagazynowy() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Timestamp getDataVAT() {
        return dataVAT;
    }

    public void setDataVAT(Timestamp dataVAT) {
        this.dataVAT = dataVAT;
    }

    public Timestamp getDataWystawienia() {
        return dataWystawienia;
    }

    public void setDataWystawienia(Timestamp dataWystawienia) {
        this.dataWystawienia = dataWystawienia;
    }

    public Integer getDataWystawieniaSys() {
        return dataWystawieniaSys;
    }

    public void setDataWystawieniaSys(Integer dataWystawieniaSys) {
        this.dataWystawieniaSys = dataWystawieniaSys;
    }

    public Integer getDokumentKorekty() {
        return dokumentKorekty;
    }

    public void setDokumentKorekty(Integer dokumentKorekty) {
        this.dokumentKorekty = dokumentKorekty;
    }

    public Integer getDokumentPrzychodowy() {
        return dokumentPrzychodowy;
    }

    public void setDokumentPrzychodowy(Integer dokumentPrzychodowy) {
        this.dokumentPrzychodowy = dokumentPrzychodowy;
    }

    public Integer getDokumentRozchodowy() {
        return dokumentRozchodowy;
    }

    public void setDokumentRozchodowy(Integer dokumentRozchodowy) {
        this.dokumentRozchodowy = dokumentRozchodowy;
    }

    public String getHandlowiec() {
        return handlowiec;
    }

    public void setHandlowiec(String handlowiec) {
        this.handlowiec = handlowiec;
    }

    public Long getIdDokumentu() {
        return idDokumentu;
    }

    public void setIdDokumentu(Long idDokumentu) {
        this.idDokumentu = idDokumentu;
    }

    public BigDecimal getIdKontrahenta() {
        return idKontrahenta;
    }

    public void setIdKontrahenta(BigDecimal idKontrahenta) {
        this.idKontrahenta = idKontrahenta;
    }

    public BigDecimal getIdMagazynu() {
        return idMagazynu;
    }

    public void setIdMagazynu(BigDecimal idMagazynu) {
        this.idMagazynu = idMagazynu;
    }

    public BigDecimal getIdDokumentuHandlowego() {
        return idDokumentuHandlowego;
    }

    public void setIdDokumentuHandlowego(BigDecimal idDokumentuHandlowego) {
        this.idDokumentuHandlowego = idDokumentuHandlowego;
    }

    public BigDecimal getIdMagazynuDocelowego() {
        return idMagazynuDocelowego;
    }

    public void setIdMagazynuDocelowego(BigDecimal idMagazynuDocelowego) {
        this.idMagazynuDocelowego = idMagazynuDocelowego;
    }

    public BigDecimal getIdOrgFakturyZaliczkowej() {
        return idOrgFakturyZaliczkowej;
    }

    public void setIdOrgFakturyZaliczkowej(BigDecimal idOrgFakturyZaliczkowej) {
        this.idOrgFakturyZaliczkowej = idOrgFakturyZaliczkowej;
    }

    public BigDecimal getIdPracownika() {
        return idPracownika;
    }

    public void setIdPracownika(BigDecimal idPracownika) {
        this.idPracownika = idPracownika;
    }

    public BigDecimal getIdTypu() {
        return idTypu;
    }

    public void setIdTypu(BigDecimal idTypu) {
        this.idTypu = idTypu;
    }

    public BigDecimal getIdUzytkownika() {
        return idUzytkownika;
    }

    public void setIdUzytkownika(BigDecimal idUzytkownika) {
        this.idUzytkownika = idUzytkownika;
    }

    public BigDecimal getIdZlecenia() {
        return idZlecenia;
    }

    public void setIdZlecenia(BigDecimal idZlecenia) {
        this.idZlecenia = idZlecenia;
    }

    public String getKodKreskowy() {
        return kodKreskowy;
    }

    public void setKodKreskowy(String kodKreskowy) {
        this.kodKreskowy = kodKreskowy;
    }

    public String getNumer() {
        return numer;
    }

    public void setNumer(String numer) {
        this.numer = numer;
    }

    public String getNumerDokumentuHandlowego() {
        return numerDokumentuHandlowego;
    }

    public void setNumerDokumentuHandlowego(String numerDokumentuHandlowego) {
        this.numerDokumentuHandlowego = numerDokumentuHandlowego;
    }

    public String getObliczanieWgCen() {
        return obliczanieWgCen;
    }

    public void setObliczanieWgCen(String obliczanieWgCen) {
        this.obliczanieWgCen = obliczanieWgCen;
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

    public String getRodzajDokumentu() {
        return rodzajDokumentu;
    }

    public void setRodzajDokumentu(String rodzajDokumentu) {
        this.rodzajDokumentu = rodzajDokumentu;
    }

    public Integer getTrybRejestracji() {
        return trybRejestracji;
    }

    public void setTrybRejestracji(Integer trybRejestracji) {
        this.trybRejestracji = trybRejestracji;
    }

    public String getUwagi() {
        return uwagi;
    }

    public void setUwagi(String uwagi) {
        this.uwagi = uwagi;
    }

    public BigDecimal getWartoscBrutto() {
        return wartoscBrutto;
    }

    public void setWartoscBrutto(BigDecimal wartoscBrutto) {
        this.wartoscBrutto = wartoscBrutto;
    }

    public BigDecimal getWartoscNetto() {
        return wartoscNetto;
    }

    public void setWartoscNetto(BigDecimal wartoscNetto) {
        this.wartoscNetto = wartoscNetto;
    }

    public BigDecimal getWartoscVAT() {
        return wartoscVAT;
    }

    public void setWartoscVAT(BigDecimal wartoscVAT) {
        this.wartoscVAT = wartoscVAT;
    }

    public String getWycena() {
        return wycena;
    }

    public void setWycena(String wycena) {
        this.wycena = wycena;
    }

    public String getWyroznik() {
        return wyroznik;
    }

    public void setWyroznik(String wyroznik) {
        this.wyroznik = wyroznik;
    }

}
