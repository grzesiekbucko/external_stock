package pl.bucko.external_stock.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name="ZAMOWIENIE")
public class Zamowienie implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="ID_ZAMOWIENIA")
    private long idZamowienia;

    @Column(name="AUTO_REZERWACJA")
    private Integer autoRezerwacja;

    @Column(name="AUTONUMER")
    private BigDecimal autonumer;

    @Column(name="[DATA]")
    private Integer data;

    @Column(name="DATA_BLOKADY_WIERSZA")
    private Timestamp dataBlokadyWiersza;

    @Column(name="DATA_KURS_WAL")
    private Integer dataKursWal;

    @Column(name="DATA_REALIZACJI")
    private Integer dataRealizacji;

    @Column(name="DATA_UTWORZENIA_WIERSZA")
    private Timestamp dataUtworzeniaWiersza;

    @Column(name="DNI_PLATNOSCI")
    private Integer dniPlatnosci;

    @Column(name="DOK_WAL")
    private Integer dokWal;

    @Column(name="DOK_ZABLOKOWANY")
    private Integer dokZablokowany;

    @Column(name="FAKTURA_DO_ZAMOWIENIA")
    private Integer fakturaDoZamowienia;

    @Column(name="FLAGA_STANU")
    private Integer flagaStanu;

    @Column(name="FORMA_PLATNOSCI")
    private String formaPlatnosci;

    @Column(name="ID_ETYKIETY")
    private BigDecimal idEtykiety;

    @Column(name="ID_FIRMY")
    private BigDecimal idFirmy;

    @Column(name="ID_KONTAKTU")
    private BigDecimal idKontaktu;

    @Column(name="ID_KONTRAHENTA")
    private BigDecimal idKontrahenta;

    @Column(name="ID_MAGAZYNU")
    private BigDecimal idMagazynu;

    @Column(name="ID_OPERATORA_PRZESYLKI")
    private BigDecimal idOperatoraPrzesylki;

    @Column(name="ID_PRACOWNIKA")
    private BigDecimal idPracownika;

    @Column(name="ID_RACHUNKU")
    private BigDecimal idRachunku;

    @Column(name="ID_UZYTKOWNIKA")
    private BigDecimal idUzytkownika;

    @Column(name="INFORMACJE_DODATKOWE")
    private String informacjeDodatkowe;

    @Column(name="KOD_KRESKOWY")
    private String kodKreskowy;

    @Column(name="KONTRAHENT_NAZWA")
    private String kontrahentNazwa;

    @Column(name="NR_ZAMOWIENIA_KLIENTA")
    private String nrZamowieniaKlienta;

    @Column(name="NUMER")
    private String numer;

    @Column(name="NUMER_PRZESYLKI")
    private String numerPrzesylki;

    @Column(name="OBLICZANIE_WG_CEN")
    private String obliczanieWgCen;

    @Column(name="OPLACONE_INTERNETOWO")
    private Integer oplaconeInternetowo;

    @Column(name="OSOBA_ZAMAWIAJACA")
    private String osobaZamawiajaca;

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

    @Column(name="PRIORYTET")
    private Integer priorytet;

    @Column(name="PRZELICZNIK_WAL")
    private BigDecimal przelicznikWal;

    @Column(name="RABAT_NARZUT")
    private BigDecimal rabatNarzut;

    @Column(name="SEMAFOR")
    private BigDecimal semafor;

    @Column(name="STAN_REALIZ")
    private String stanRealiz;

    @Column(name="STATUS_ZAM")
    private String statusZam;

    @Column(name="SYM_WAL")
    private String symWal;

    @Column(name="TRYBREJESTRACJI")
    private Integer trybrejestracji;

    @Column(name="TYP")
    private Integer typ;

    @Column(name="TYP_SYS_INTERNETOWEGO")
    private Integer typSysInternetowego;

    @Column(name="UWAGI")
    private String uwagi;

    @Column(name="WARTOSC_BRUTTO")
    private BigDecimal wartoscBrutto;

    @Column(name="WARTOSC_BRUTTO_WAL")
    private BigDecimal wartoscBruttoWal;

    @Column(name="WARTOSC_NETTO")
    private BigDecimal wartoscNetto;

    @Column(name="WARTOSC_NETTO_WAL")
    private BigDecimal wartoscNettoWal;

    @Column(name="ZALICZKA")
    private BigDecimal zaliczka;

    @Column(name="ZAMOWIENIE_INTERNETOWE")
    private Integer zamowienieInternetowe;

    @Column(name="ZAMOWIENIE_INTERNETOWE_ID")
    private String zamowienieInternetoweId;

    public Zamowienie() {
    }

    public Zamowienie(long idZamowienia, Integer autoRezerwacja, BigDecimal autonumer, Integer data, Timestamp dataBlokadyWiersza, Integer dataKursWal, Integer dataRealizacji, Timestamp dataUtworzeniaWiersza, Integer dniPlatnosci, Integer dokWal, Integer dokZablokowany, Integer fakturaDoZamowienia, Integer flagaStanu, String formaPlatnosci, BigDecimal idEtykiety, BigDecimal idFirmy, BigDecimal idKontaktu, BigDecimal idKontrahenta, BigDecimal idMagazynu, BigDecimal idOperatoraPrzesylki, BigDecimal idPracownika, BigDecimal idRachunku, BigDecimal idUzytkownika, String informacjeDodatkowe, String kodKreskowy, String kontrahentNazwa, String nrZamowieniaKlienta, String numer, String numerPrzesylki, String obliczanieWgCen, Integer oplaconeInternetowo, String osobaZamawiajaca, String pole1, String pole10, String pole2, String pole3, String pole4, String pole5, String pole6, String pole7, String pole8, String pole9, Integer priorytet, BigDecimal przelicznikWal, BigDecimal rabatNarzut, BigDecimal semafor, String stanRealiz, String statusZam, String symWal, Integer trybrejestracji, Integer typ, Integer typSysInternetowego, String uwagi, BigDecimal wartoscBrutto, BigDecimal wartoscBruttoWal, BigDecimal wartoscNetto, BigDecimal wartoscNettoWal, BigDecimal zaliczka, Integer zamowienieInternetowe, String zamowienieInternetoweId) {
        this.idZamowienia = idZamowienia;
        this.autoRezerwacja = autoRezerwacja;
        this.autonumer = autonumer;
        this.data = data;
        this.dataBlokadyWiersza = dataBlokadyWiersza;
        this.dataKursWal = dataKursWal;
        this.dataRealizacji = dataRealizacji;
        this.dataUtworzeniaWiersza = dataUtworzeniaWiersza;
        this.dniPlatnosci = dniPlatnosci;
        this.dokWal = dokWal;
        this.dokZablokowany = dokZablokowany;
        this.fakturaDoZamowienia = fakturaDoZamowienia;
        this.flagaStanu = flagaStanu;
        this.formaPlatnosci = formaPlatnosci;
        this.idEtykiety = idEtykiety;
        this.idFirmy = idFirmy;
        this.idKontaktu = idKontaktu;
        this.idKontrahenta = idKontrahenta;
        this.idMagazynu = idMagazynu;
        this.idOperatoraPrzesylki = idOperatoraPrzesylki;
        this.idPracownika = idPracownika;
        this.idRachunku = idRachunku;
        this.idUzytkownika = idUzytkownika;
        this.informacjeDodatkowe = informacjeDodatkowe;
        this.kodKreskowy = kodKreskowy;
        this.kontrahentNazwa = kontrahentNazwa;
        this.nrZamowieniaKlienta = nrZamowieniaKlienta;
        this.numer = numer;
        this.numerPrzesylki = numerPrzesylki;
        this.obliczanieWgCen = obliczanieWgCen;
        this.oplaconeInternetowo = oplaconeInternetowo;
        this.osobaZamawiajaca = osobaZamawiajaca;
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
        this.priorytet = priorytet;
        this.przelicznikWal = przelicznikWal;
        this.rabatNarzut = rabatNarzut;
        this.semafor = semafor;
        this.stanRealiz = stanRealiz;
        this.statusZam = statusZam;
        this.symWal = symWal;
        this.trybrejestracji = trybrejestracji;
        this.typ = typ;
        this.typSysInternetowego = typSysInternetowego;
        this.uwagi = uwagi;
        this.wartoscBrutto = wartoscBrutto;
        this.wartoscBruttoWal = wartoscBruttoWal;
        this.wartoscNetto = wartoscNetto;
        this.wartoscNettoWal = wartoscNettoWal;
        this.zaliczka = zaliczka;
        this.zamowienieInternetowe = zamowienieInternetowe;
        this.zamowienieInternetoweId = zamowienieInternetoweId;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public long getIdZamowienia() {
        return idZamowienia;
    }

    public void setIdZamowienia(long idZamowienia) {
        this.idZamowienia = idZamowienia;
    }

    public Integer getAutoRezerwacja() {
        return autoRezerwacja;
    }

    public void setAutoRezerwacja(Integer autoRezerwacja) {
        this.autoRezerwacja = autoRezerwacja;
    }

    public BigDecimal getAutonumer() {
        return autonumer;
    }

    public void setAutonumer(BigDecimal autonumer) {
        this.autonumer = autonumer;
    }

    public Integer getData() {
        return data;
    }

    public void setData(Integer data) {
        this.data = data;
    }

    public Timestamp getDataBlokadyWiersza() {
        return dataBlokadyWiersza;
    }

    public void setDataBlokadyWiersza(Timestamp dataBlokadyWiersza) {
        this.dataBlokadyWiersza = dataBlokadyWiersza;
    }

    public Integer getDataKursWal() {
        return dataKursWal;
    }

    public void setDataKursWal(Integer dataKursWal) {
        this.dataKursWal = dataKursWal;
    }

    public Integer getDataRealizacji() {
        return dataRealizacji;
    }

    public void setDataRealizacji(Integer dataRealizacji) {
        this.dataRealizacji = dataRealizacji;
    }

    public Timestamp getDataUtworzeniaWiersza() {
        return dataUtworzeniaWiersza;
    }

    public void setDataUtworzeniaWiersza(Timestamp dataUtworzeniaWiersza) {
        this.dataUtworzeniaWiersza = dataUtworzeniaWiersza;
    }

    public Integer getDniPlatnosci() {
        return dniPlatnosci;
    }

    public void setDniPlatnosci(Integer dniPlatnosci) {
        this.dniPlatnosci = dniPlatnosci;
    }

    public Integer getDokWal() {
        return dokWal;
    }

    public void setDokWal(Integer dokWal) {
        this.dokWal = dokWal;
    }

    public Integer getDokZablokowany() {
        return dokZablokowany;
    }

    public void setDokZablokowany(Integer dokZablokowany) {
        this.dokZablokowany = dokZablokowany;
    }

    public Integer getFakturaDoZamowienia() {
        return fakturaDoZamowienia;
    }

    public void setFakturaDoZamowienia(Integer fakturaDoZamowienia) {
        this.fakturaDoZamowienia = fakturaDoZamowienia;
    }

    public Integer getFlagaStanu() {
        return flagaStanu;
    }

    public void setFlagaStanu(Integer flagaStanu) {
        this.flagaStanu = flagaStanu;
    }

    public String getFormaPlatnosci() {
        return formaPlatnosci;
    }

    public void setFormaPlatnosci(String formaPlatnosci) {
        this.formaPlatnosci = formaPlatnosci;
    }

    public BigDecimal getIdEtykiety() {
        return idEtykiety;
    }

    public void setIdEtykiety(BigDecimal idEtykiety) {
        this.idEtykiety = idEtykiety;
    }

    public BigDecimal getIdFirmy() {
        return idFirmy;
    }

    public void setIdFirmy(BigDecimal idFirmy) {
        this.idFirmy = idFirmy;
    }

    public BigDecimal getIdKontaktu() {
        return idKontaktu;
    }

    public void setIdKontaktu(BigDecimal idKontaktu) {
        this.idKontaktu = idKontaktu;
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

    public BigDecimal getIdOperatoraPrzesylki() {
        return idOperatoraPrzesylki;
    }

    public void setIdOperatoraPrzesylki(BigDecimal idOperatoraPrzesylki) {
        this.idOperatoraPrzesylki = idOperatoraPrzesylki;
    }

    public BigDecimal getIdPracownika() {
        return idPracownika;
    }

    public void setIdPracownika(BigDecimal idPracownika) {
        this.idPracownika = idPracownika;
    }

    public BigDecimal getIdRachunku() {
        return idRachunku;
    }

    public void setIdRachunku(BigDecimal idRachunku) {
        this.idRachunku = idRachunku;
    }

    public BigDecimal getIdUzytkownika() {
        return idUzytkownika;
    }

    public void setIdUzytkownika(BigDecimal idUzytkownika) {
        this.idUzytkownika = idUzytkownika;
    }

    public String getInformacjeDodatkowe() {
        return informacjeDodatkowe;
    }

    public void setInformacjeDodatkowe(String informacjeDodatkowe) {
        this.informacjeDodatkowe = informacjeDodatkowe;
    }

    public String getKodKreskowy() {
        return kodKreskowy;
    }

    public void setKodKreskowy(String kodKreskowy) {
        this.kodKreskowy = kodKreskowy;
    }

    public String getKontrahentNazwa() {
        return kontrahentNazwa;
    }

    public void setKontrahentNazwa(String kontrahentNazwa) {
        this.kontrahentNazwa = kontrahentNazwa;
    }

    public String getNrZamowieniaKlienta() {
        return nrZamowieniaKlienta;
    }

    public void setNrZamowieniaKlienta(String nrZamowieniaKlienta) {
        this.nrZamowieniaKlienta = nrZamowieniaKlienta;
    }

    public String getNumer() {
        return numer;
    }

    public void setNumer(String numer) {
        this.numer = numer;
    }

    public String getNumerPrzesylki() {
        return numerPrzesylki;
    }

    public void setNumerPrzesylki(String numerPrzesylki) {
        this.numerPrzesylki = numerPrzesylki;
    }

    public String getObliczanieWgCen() {
        return obliczanieWgCen;
    }

    public void setObliczanieWgCen(String obliczanieWgCen) {
        this.obliczanieWgCen = obliczanieWgCen;
    }

    public Integer getOplaconeInternetowo() {
        return oplaconeInternetowo;
    }

    public void setOplaconeInternetowo(Integer oplaconeInternetowo) {
        this.oplaconeInternetowo = oplaconeInternetowo;
    }

    public String getOsobaZamawiajaca() {
        return osobaZamawiajaca;
    }

    public void setOsobaZamawiajaca(String osobaZamawiajaca) {
        this.osobaZamawiajaca = osobaZamawiajaca;
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

    public Integer getPriorytet() {
        return priorytet;
    }

    public void setPriorytet(Integer priorytet) {
        this.priorytet = priorytet;
    }

    public BigDecimal getPrzelicznikWal() {
        return przelicznikWal;
    }

    public void setPrzelicznikWal(BigDecimal przelicznikWal) {
        this.przelicznikWal = przelicznikWal;
    }

    public BigDecimal getRabatNarzut() {
        return rabatNarzut;
    }

    public void setRabatNarzut(BigDecimal rabatNarzut) {
        this.rabatNarzut = rabatNarzut;
    }

    public BigDecimal getSemafor() {
        return semafor;
    }

    public void setSemafor(BigDecimal semafor) {
        this.semafor = semafor;
    }

    public String getStanRealiz() {
        return stanRealiz;
    }

    public void setStanRealiz(String stanRealiz) {
        this.stanRealiz = stanRealiz;
    }

    public String getStatusZam() {
        return statusZam;
    }

    public void setStatusZam(String statusZam) {
        this.statusZam = statusZam;
    }

    public String getSymWal() {
        return symWal;
    }

    public void setSymWal(String symWal) {
        this.symWal = symWal;
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

    public Integer getTypSysInternetowego() {
        return typSysInternetowego;
    }

    public void setTypSysInternetowego(Integer typSysInternetowego) {
        this.typSysInternetowego = typSysInternetowego;
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

    public BigDecimal getWartoscBruttoWal() {
        return wartoscBruttoWal;
    }

    public void setWartoscBruttoWal(BigDecimal wartoscBruttoWal) {
        this.wartoscBruttoWal = wartoscBruttoWal;
    }

    public BigDecimal getWartoscNetto() {
        return wartoscNetto;
    }

    public void setWartoscNetto(BigDecimal wartoscNetto) {
        this.wartoscNetto = wartoscNetto;
    }

    public BigDecimal getWartoscNettoWal() {
        return wartoscNettoWal;
    }

    public void setWartoscNettoWal(BigDecimal wartoscNettoWal) {
        this.wartoscNettoWal = wartoscNettoWal;
    }

    public BigDecimal getZaliczka() {
        return zaliczka;
    }

    public void setZaliczka(BigDecimal zaliczka) {
        this.zaliczka = zaliczka;
    }

    public Integer getZamowienieInternetowe() {
        return zamowienieInternetowe;
    }

    public void setZamowienieInternetowe(Integer zamowienieInternetowe) {
        this.zamowienieInternetowe = zamowienieInternetowe;
    }

    public String getZamowienieInternetoweId() {
        return zamowienieInternetoweId;
    }

    public void setZamowienieInternetoweId(String zamowienieInternetoweId) {
        this.zamowienieInternetoweId = zamowienieInternetoweId;
    }
}
