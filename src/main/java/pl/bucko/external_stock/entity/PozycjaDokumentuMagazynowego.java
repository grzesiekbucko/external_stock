package pl.bucko.external_stock.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name="POZYCJA_DOKUMENTU_MAGAZYNOWEGO")
public class PozycjaDokumentuMagazynowego implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="ID_POZ_DOK_MAG")
    private long idPozDokMag;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="ID_ARTYKULU")
    private Artykul idArtykulu;

    @Column(name="AKCYZA")
    private Integer akcyza;

    @Column(name="AKT_CEN_PRZY_DOSTAWIE")
    private Integer aktCenPrzyDostawie;

    @Column(name="CB_SPRZ_PZ")
    private BigDecimal cbSprzPz;

    @Column(name="CENA_B_KGO")
    private BigDecimal cenaBKgo;

    @Column(name="CENA_BRUTTO")
    private BigDecimal cenaBrutto;

    @Column(name="CENA_BRUTTO_BEZ_KOSZTU")
    private BigDecimal cenaBruttoBezKosztu;

    @Column(name="CENA_BRUTTO_WAL")
    private BigDecimal cenaBruttoWal;

    @Column(name="CENA_N_KGO")
    private BigDecimal cenaNKgo;

    @Column(name="CENA_NETTO")
    private BigDecimal cenaNetto;

    @Column(name="CENA_NETTO_BEZ_KOSZTU")
    private BigDecimal cenaNettoBezKosztu;

    @Column(name="CENA_NETTO_WAL")
    private BigDecimal cenaNettoWal;

    @Column(name="CN_SPRZ_PZ")
    private BigDecimal cnSprzPz;

    @Column(name="CZB_MARZA")
    private BigDecimal czbMarza;

    @Column(name="[DATA]")
    private Integer data;

    @Column(name="DATA_WAZNOSCI")
    private Integer dataWaznosci;

    @Column(name="FLAGA_STANU")
    private Integer flagaStanu;

    @Column(name="GUID_POZ_DOK_MAG")
    private String guidPozDokMag;

    @Column(name="GUID_POZ_DOSTAWY_MM")
    private String guidPozDostawyMm;

    @Column(name="I_KOD_CN")
    private String iKodCn;

    @Column(name="I_KOD_DOSTAWY")
    private String iKodDostawy;

    @Column(name="I_KOD_KONTRAHENTA_ZAGR")
    private String iKodKontrahentaZagr;

    @Column(name="I_KOD_KRAJU_POCH")
    private String iKodKrajuPoch;

    @Column(name="I_KOD_KRAJU_PRZEZ_WYS")
    private String iKodKrajuPrzezWys;

    @Column(name="I_KOD_TRANSAKCJI")
    private String iKodTransakcji;

    @Column(name="I_KOD_TRANSPORTU")
    private String iKodTransportu;

    @Column(name="I_MASA_NETTO")
    private BigDecimal iMasaNetto;

    @Column(name="I_PODLEGA_DEKLARACJI")
    private Integer iPodlegaDeklaracji;

    @Column(name="ID_DOK_KORYGUJACEGO_ZBIORCZO")
    private BigDecimal idDokKorygujacegoZbiorczo;

    @Column(name="ID_DOK_MAGAZYNOWEGO")
    private BigDecimal idDokMagazynowego;

    @Column(name="ID_ETYKIETY")
    private BigDecimal idEtykiety;

    @Column(name="ID_OST_KOREKTY")
    private BigDecimal idOstKorekty;

    @Column(name="ID_POW_KOREKTY")
    private BigDecimal idPowKorekty;

    @Column(name="ID_POZ_KORYGOWANEJ")
    private BigDecimal idPozKorygowanej;

    @Column(name="ID_POZ_OBROTOWEJ")
    private BigDecimal idPozObrotowej;

    @Column(name="ID_POZ_ORYGINALNEJ")
    private BigDecimal idPozOryginalnej;

    @Column(name="ID_POZ_PRZYCH")
    private BigDecimal idPozPrzych;

    @Column(name="ID_POZ_ZAM")
    private BigDecimal idPozZam;

    @Column(name="ID_POZ_ZAM_ZAL")
    private BigDecimal idPozZamZal;

    @Column(name="ID_POZ_ZLECENIA")
    private BigDecimal idPozZlecenia;

    @Column(name="ID_POZYCJI_OFERTY")
    private BigDecimal idPozycjiOferty;

    @Column(name="ILOSC")
    private BigDecimal ilosc;

    @Column(name="JEDNOSTKA")
    private String jednostka;

    @Column(name="KOD_VAT")
    private String kodVat;

    @Column(name="KOD_VAT_UE")
    private String kodVatUe;

    @Column(name="NR_PACZKI")
    private String nrPaczki;

    @Column(name="NR_SERII")
    private String nrSerii;

    @Column(name="OPAKOWANIA_PRZYJETO")
    private BigDecimal opakowaniaPrzyjeto;

    @Column(name="OPAKOWANIA_WYDANO")
    private BigDecimal opakowaniaWydano;

    @Column(name="OPIS")
    private String opis;

    @Column(name="OPIS_CENY")
    private String opisCeny;

    @Column(name="PODLEGA_PP")
    private Integer podlegaPp;

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

    @Column(name="POZ_KOREKTY")
    private Integer pozKorekty;

    @Column(name="POZ_PRZYCHODU_OK")
    private Integer pozPrzychoduOk;

    @Column(name="POZ_WYB_DOSTAWY")
    private Integer pozWybDostawy;

    @Column(name="PRZELICZNIK")
    private BigDecimal przelicznik;

    @Column(name="RABAT")
    private BigDecimal rabat;

    @Column(name="RABAT2")
    private BigDecimal rabat2;

    @Column(name="RABAT2_ZB")
    private BigDecimal rabat2Zb;

    @Column(name="RODZAJ_ARTYKULU")
    private String rodzajArtykulu;

    @Column(name="RODZAJ_POZYCJI")
    private String rodzajPozycji;

    @Column(name="TRYBREJESTRACJI")
    private Integer trybrejestracji;

    @Column(name="WYDANO")
    private BigDecimal wydano;

    @Column(name="ZAREZERWOWANO")
    private BigDecimal zarezerwowano;

    @Column(name="ZNACZNIK_CENY")
    private String znacznikCeny;


    public PozycjaDokumentuMagazynowego() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public long getIdPozDokMag() {
        return idPozDokMag;
    }

    public void setIdPozDokMag(long idPozDokMag) {
        this.idPozDokMag = idPozDokMag;
    }

    public Artykul getIdArtykulu() {
        return idArtykulu;
    }

    public void setIdArtykulu(Artykul idArtykulu) {
        this.idArtykulu = idArtykulu;
    }

    public Integer getAkcyza() {
        return akcyza;
    }

    public void setAkcyza(Integer akcyza) {
        this.akcyza = akcyza;
    }

    public Integer getAktCenPrzyDostawie() {
        return aktCenPrzyDostawie;
    }

    public void setAktCenPrzyDostawie(Integer aktCenPrzyDostawie) {
        this.aktCenPrzyDostawie = aktCenPrzyDostawie;
    }

    public BigDecimal getCbSprzPz() {
        return cbSprzPz;
    }

    public void setCbSprzPz(BigDecimal cbSprzPz) {
        this.cbSprzPz = cbSprzPz;
    }

    public BigDecimal getCenaBKgo() {
        return cenaBKgo;
    }

    public void setCenaBKgo(BigDecimal cenaBKgo) {
        this.cenaBKgo = cenaBKgo;
    }

    public BigDecimal getCenaBrutto() {
        return cenaBrutto;
    }

    public void setCenaBrutto(BigDecimal cenaBrutto) {
        this.cenaBrutto = cenaBrutto;
    }

    public BigDecimal getCenaBruttoBezKosztu() {
        return cenaBruttoBezKosztu;
    }

    public void setCenaBruttoBezKosztu(BigDecimal cenaBruttoBezKosztu) {
        this.cenaBruttoBezKosztu = cenaBruttoBezKosztu;
    }

    public BigDecimal getCenaBruttoWal() {
        return cenaBruttoWal;
    }

    public void setCenaBruttoWal(BigDecimal cenaBruttoWal) {
        this.cenaBruttoWal = cenaBruttoWal;
    }

    public BigDecimal getCenaNKgo() {
        return cenaNKgo;
    }

    public void setCenaNKgo(BigDecimal cenaNKgo) {
        this.cenaNKgo = cenaNKgo;
    }

    public BigDecimal getCenaNetto() {
        return cenaNetto;
    }

    public void setCenaNetto(BigDecimal cenaNetto) {
        this.cenaNetto = cenaNetto;
    }

    public BigDecimal getCenaNettoBezKosztu() {
        return cenaNettoBezKosztu;
    }

    public void setCenaNettoBezKosztu(BigDecimal cenaNettoBezKosztu) {
        this.cenaNettoBezKosztu = cenaNettoBezKosztu;
    }

    public BigDecimal getCenaNettoWal() {
        return cenaNettoWal;
    }

    public void setCenaNettoWal(BigDecimal cenaNettoWal) {
        this.cenaNettoWal = cenaNettoWal;
    }

    public BigDecimal getCnSprzPz() {
        return cnSprzPz;
    }

    public void setCnSprzPz(BigDecimal cnSprzPz) {
        this.cnSprzPz = cnSprzPz;
    }

    public BigDecimal getCzbMarza() {
        return czbMarza;
    }

    public void setCzbMarza(BigDecimal czbMarza) {
        this.czbMarza = czbMarza;
    }

    public Integer getData() {
        return data;
    }

    public void setData(Integer data) {
        this.data = data;
    }

    public Integer getDataWaznosci() {
        return dataWaznosci;
    }

    public void setDataWaznosci(Integer dataWaznosci) {
        this.dataWaznosci = dataWaznosci;
    }

    public Integer getFlagaStanu() {
        return flagaStanu;
    }

    public void setFlagaStanu(Integer flagaStanu) {
        this.flagaStanu = flagaStanu;
    }

    public String getGuidPozDokMag() {
        return guidPozDokMag;
    }

    public void setGuidPozDokMag(String guidPozDokMag) {
        this.guidPozDokMag = guidPozDokMag;
    }

    public String getGuidPozDostawyMm() {
        return guidPozDostawyMm;
    }

    public void setGuidPozDostawyMm(String guidPozDostawyMm) {
        this.guidPozDostawyMm = guidPozDostawyMm;
    }

    public String getiKodCn() {
        return iKodCn;
    }

    public void setiKodCn(String iKodCn) {
        this.iKodCn = iKodCn;
    }

    public String getiKodDostawy() {
        return iKodDostawy;
    }

    public void setiKodDostawy(String iKodDostawy) {
        this.iKodDostawy = iKodDostawy;
    }

    public String getiKodKontrahentaZagr() {
        return iKodKontrahentaZagr;
    }

    public void setiKodKontrahentaZagr(String iKodKontrahentaZagr) {
        this.iKodKontrahentaZagr = iKodKontrahentaZagr;
    }

    public String getiKodKrajuPoch() {
        return iKodKrajuPoch;
    }

    public void setiKodKrajuPoch(String iKodKrajuPoch) {
        this.iKodKrajuPoch = iKodKrajuPoch;
    }

    public String getiKodKrajuPrzezWys() {
        return iKodKrajuPrzezWys;
    }

    public void setiKodKrajuPrzezWys(String iKodKrajuPrzezWys) {
        this.iKodKrajuPrzezWys = iKodKrajuPrzezWys;
    }

    public String getiKodTransakcji() {
        return iKodTransakcji;
    }

    public void setiKodTransakcji(String iKodTransakcji) {
        this.iKodTransakcji = iKodTransakcji;
    }

    public String getiKodTransportu() {
        return iKodTransportu;
    }

    public void setiKodTransportu(String iKodTransportu) {
        this.iKodTransportu = iKodTransportu;
    }

    public BigDecimal getiMasaNetto() {
        return iMasaNetto;
    }

    public void setiMasaNetto(BigDecimal iMasaNetto) {
        this.iMasaNetto = iMasaNetto;
    }

    public Integer getiPodlegaDeklaracji() {
        return iPodlegaDeklaracji;
    }

    public void setiPodlegaDeklaracji(Integer iPodlegaDeklaracji) {
        this.iPodlegaDeklaracji = iPodlegaDeklaracji;
    }

    public BigDecimal getIdDokKorygujacegoZbiorczo() {
        return idDokKorygujacegoZbiorczo;
    }

    public void setIdDokKorygujacegoZbiorczo(BigDecimal idDokKorygujacegoZbiorczo) {
        this.idDokKorygujacegoZbiorczo = idDokKorygujacegoZbiorczo;
    }

    public BigDecimal getIdDokMagazynowego() {
        return idDokMagazynowego;
    }

    public void setIdDokMagazynowego(BigDecimal idDokMagazynowego) {
        this.idDokMagazynowego = idDokMagazynowego;
    }

    public BigDecimal getIdEtykiety() {
        return idEtykiety;
    }

    public void setIdEtykiety(BigDecimal idEtykiety) {
        this.idEtykiety = idEtykiety;
    }

    public BigDecimal getIdOstKorekty() {
        return idOstKorekty;
    }

    public void setIdOstKorekty(BigDecimal idOstKorekty) {
        this.idOstKorekty = idOstKorekty;
    }

    public BigDecimal getIdPowKorekty() {
        return idPowKorekty;
    }

    public void setIdPowKorekty(BigDecimal idPowKorekty) {
        this.idPowKorekty = idPowKorekty;
    }

    public BigDecimal getIdPozKorygowanej() {
        return idPozKorygowanej;
    }

    public void setIdPozKorygowanej(BigDecimal idPozKorygowanej) {
        this.idPozKorygowanej = idPozKorygowanej;
    }

    public BigDecimal getIdPozObrotowej() {
        return idPozObrotowej;
    }

    public void setIdPozObrotowej(BigDecimal idPozObrotowej) {
        this.idPozObrotowej = idPozObrotowej;
    }

    public BigDecimal getIdPozOryginalnej() {
        return idPozOryginalnej;
    }

    public void setIdPozOryginalnej(BigDecimal idPozOryginalnej) {
        this.idPozOryginalnej = idPozOryginalnej;
    }

    public BigDecimal getIdPozPrzych() {
        return idPozPrzych;
    }

    public void setIdPozPrzych(BigDecimal idPozPrzych) {
        this.idPozPrzych = idPozPrzych;
    }

    public BigDecimal getIdPozZam() {
        return idPozZam;
    }

    public void setIdPozZam(BigDecimal idPozZam) {
        this.idPozZam = idPozZam;
    }

    public BigDecimal getIdPozZamZal() {
        return idPozZamZal;
    }

    public void setIdPozZamZal(BigDecimal idPozZamZal) {
        this.idPozZamZal = idPozZamZal;
    }

    public BigDecimal getIdPozZlecenia() {
        return idPozZlecenia;
    }

    public void setIdPozZlecenia(BigDecimal idPozZlecenia) {
        this.idPozZlecenia = idPozZlecenia;
    }

    public BigDecimal getIdPozycjiOferty() {
        return idPozycjiOferty;
    }

    public void setIdPozycjiOferty(BigDecimal idPozycjiOferty) {
        this.idPozycjiOferty = idPozycjiOferty;
    }

    public BigDecimal getIlosc() {
        return ilosc;
    }

    public void setIlosc(BigDecimal ilosc) {
        this.ilosc = ilosc;
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

    public String getKodVatUe() {
        return kodVatUe;
    }

    public void setKodVatUe(String kodVatUe) {
        this.kodVatUe = kodVatUe;
    }

    public String getNrPaczki() {
        return nrPaczki;
    }

    public void setNrPaczki(String nrPaczki) {
        this.nrPaczki = nrPaczki;
    }

    public String getNrSerii() {
        return nrSerii;
    }

    public void setNrSerii(String nrSerii) {
        this.nrSerii = nrSerii;
    }

    public BigDecimal getOpakowaniaPrzyjeto() {
        return opakowaniaPrzyjeto;
    }

    public void setOpakowaniaPrzyjeto(BigDecimal opakowaniaPrzyjeto) {
        this.opakowaniaPrzyjeto = opakowaniaPrzyjeto;
    }

    public BigDecimal getOpakowaniaWydano() {
        return opakowaniaWydano;
    }

    public void setOpakowaniaWydano(BigDecimal opakowaniaWydano) {
        this.opakowaniaWydano = opakowaniaWydano;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getOpisCeny() {
        return opisCeny;
    }

    public void setOpisCeny(String opisCeny) {
        this.opisCeny = opisCeny;
    }

    public Integer getPodlegaPp() {
        return podlegaPp;
    }

    public void setPodlegaPp(Integer podlegaPp) {
        this.podlegaPp = podlegaPp;
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

    public Integer getPozKorekty() {
        return pozKorekty;
    }

    public void setPozKorekty(Integer pozKorekty) {
        this.pozKorekty = pozKorekty;
    }

    public Integer getPozPrzychoduOk() {
        return pozPrzychoduOk;
    }

    public void setPozPrzychoduOk(Integer pozPrzychoduOk) {
        this.pozPrzychoduOk = pozPrzychoduOk;
    }

    public Integer getPozWybDostawy() {
        return pozWybDostawy;
    }

    public void setPozWybDostawy(Integer pozWybDostawy) {
        this.pozWybDostawy = pozWybDostawy;
    }

    public BigDecimal getPrzelicznik() {
        return przelicznik;
    }

    public void setPrzelicznik(BigDecimal przelicznik) {
        this.przelicznik = przelicznik;
    }

    public BigDecimal getRabat() {
        return rabat;
    }

    public void setRabat(BigDecimal rabat) {
        this.rabat = rabat;
    }

    public BigDecimal getRabat2() {
        return rabat2;
    }

    public void setRabat2(BigDecimal rabat2) {
        this.rabat2 = rabat2;
    }

    public BigDecimal getRabat2Zb() {
        return rabat2Zb;
    }

    public void setRabat2Zb(BigDecimal rabat2Zb) {
        this.rabat2Zb = rabat2Zb;
    }

    public String getRodzajArtykulu() {
        return rodzajArtykulu;
    }

    public void setRodzajArtykulu(String rodzajArtykulu) {
        this.rodzajArtykulu = rodzajArtykulu;
    }

    public String getRodzajPozycji() {
        return rodzajPozycji;
    }

    public void setRodzajPozycji(String rodzajPozycji) {
        this.rodzajPozycji = rodzajPozycji;
    }

    public Integer getTrybrejestracji() {
        return trybrejestracji;
    }

    public void setTrybrejestracji(Integer trybrejestracji) {
        this.trybrejestracji = trybrejestracji;
    }

    public BigDecimal getWydano() {
        return wydano;
    }

    public void setWydano(BigDecimal wydano) {
        this.wydano = wydano;
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


}
