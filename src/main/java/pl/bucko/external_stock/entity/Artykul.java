package pl.bucko.external_stock.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * The persistent class for the ARTYKUL database table.
 *
 */
@Entity
@Table(name="ARTYKUL")
//@NamedQuery(name="Artykul.findAll", query="SELECT a FROM Artykul a")
public class Artykul implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="ID_ARTYKULU")
    private long idArtykulu;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "idPozDokMag")
    private List<PozycjaDokumentuMagazynowego> pozycjaDokumentuMagazynowego;

    @Column(name="AKCYZA")
    private Integer akcyza;

    @Column(name="AKCYZA_JM")
    private String akcyzaJm;

    @Column(name="AKCYZA_PRZELICZNIK")
    private BigDecimal akcyzaPrzelicznik;

    @Column(name="AKCYZA_PRZELICZNIK_JM_JA")
    private BigDecimal akcyzaPrzelicznikJmJa;

    @Column(name="AKCYZA_STAWKA_ZA_JM")
    private BigDecimal akcyzaStawkaZaJm;

    @Column(name="AKT_CEN_PRZY_DOSTAWIE")
    private Integer aktCenPrzyDostawie;

    @Column(name="AKTYWNY_DLA_SYS_ZEW")
    private Integer aktywnyDlaSysZew;

    @Column(name="C_ZAKUPU_BRUTTO_WAL")
    private BigDecimal cZakupuBruttoWal;

    @Column(name="C_ZAKUPU_NETTO_WAL")
    private BigDecimal cZakupuNettoWal;

    @Column(name="CENA_B_KGO")
    private BigDecimal cenaBKgo;

    @Column(name="CENA_N_KGO")
    private BigDecimal cenaNKgo;

    @Column(name="CENA_PROMOCJI_B")
    private BigDecimal cenaPromocjiB;

    @Column(name="CENA_PROMOCJI_N")
    private BigDecimal cenaPromocjiN;

    @Column(name="CENA_ZAKUPU_BRUTTO")
    private BigDecimal cenaZakupuBrutto;

    @Column(name="CENA_ZAKUPU_NETTO")
    private BigDecimal cenaZakupuNetto;

    @Column(name="CERTYFIKAT")
    private Integer certyfikat;

    @Column(name="DATA_CERTYFIKATU")
    private int dataCertyfikatu;

    @Column(name="DATA_ZM_CZ")
    private int dataZmCz;

    @Column(name="DO_ODBIORCOW")
    private BigDecimal doOdbiorcow;

    @Column(name="DO_REZERWACJI")
    private BigDecimal doRezerwacji;

    @Column(name="DOMYSLNY_VAT_ZA_GRANICA")
    private Integer domyslnyVatZaGranica;

    @Column(name="DOSTEPNY_W_AUKCJACH")
    private Integer dostepnyWAukcjach;

    @Column(name="DOSTEPNY_W_SKLEPIE_INTER")
    private Integer dostepnyWSklepieInter;

    @Column(name="FLAGA_STANU")
    private Integer flagaStanu;

    @Column(name="GUID_ARTYKUL")
    private String guidArtykul;

    @Column(name="ID_ARTYKULU_PROD")
    private BigDecimal idArtykuluProd;

    @Column(name="ID_CENY_DOM")
    private BigDecimal idCenyDom;

    @Column(name="ID_DOSTAWCY_PREFEROWANEGO")
    private BigDecimal idDostawcyPreferowanego;

    @Column(name="ID_ETYKIETY")
    private BigDecimal idEtykiety;

    @Column(name="ID_FPROM")
    private BigDecimal idFprom;

    @Column(name="ID_JEDNOSTKI")
    private BigDecimal idJednostki;

    @Column(name="ID_JEDNOSTKI_REF")
    private BigDecimal idJednostkiRef;

    @Column(name="ID_JEDNOSTKI_SPRZ")
    private BigDecimal idJednostkiSprz;

    @Column(name="ID_JEDNOSTKI_ZAK")
    private BigDecimal idJednostkiZak;

    @Column(name="ID_KATEGORII")
    private BigDecimal idKategorii;

    @Column(name="ID_KATEGORII_TREE")
    private BigDecimal idKategoriiTree;

    @Column(name="ID_MAGAZYNU")
    private BigDecimal idMagazynu;

    @Column(name="ID_OPAKOWANIA_REF")
    private BigDecimal idOpakowaniaRef;

    @Column(name="ID_PRODUCENTA")
    private BigDecimal idProducenta;

    @Column(name="ILOSC_EDYTOWANA")
    private BigDecimal iloscEdytowana;

    @Column(name="ILOSC_PROD")
    private BigDecimal iloscProd;

    @Column(name="IND_KAT_TOWAR_ZAST")
    private String indKatTowarZast;

    @Column(name="INDEKS_HANDLOWY")
    private String indeksHandlowy;

    @Column(name="INDEKS_KATALOGOWY")
    private String indeksKatalogowy;

    @Column(name="INDEKS_PRODUCENTA")
    private String indeksProducenta;

    @Column(name="JED_WAGI")
    private String jedWagi;

    @Column(name="JED_WYMIARU")
    private String jedWymiaru;

    @Column(name="JEDNOSTKA_PROD")
    private String jednostkaProd;

    @Column(name="JEST_ZDJECIE")
    private Integer jestZdjecie;

    @Column(name="KOD_CN")
    private String kodCn;

    @Column(name="KOD_KRESKOWY")
    private String kodKreskowy;

    @Column(name="KRAJ_POCHODZENIA")
    private String krajPochodzenia;

    @Column(name="LOKALIZACJA")
    private String lokalizacja;

    @Column(name="MARZOWY")
    private Integer marzowy;

    @Column(name="MIN_NARZUT")
    private BigDecimal minNarzut;

    @Column(name="NAZWA")
    private String nazwa;

    @Column(name="NAZWA_CALA")
    private String nazwaCala;

    @Column(name="NAZWA_CERTYFIKATU")
    private String nazwaCertyfikatu;

    @Column(name="NAZWA_INTRASTAT")
    private String nazwaIntrastat;

    @Column(name="NAZWA_ORYG")
    private String nazwaOryg;

    @Column(name="NAZWA2")
    private String nazwa2;

    @Column(name="OD_DOSTAWCOW")
    private BigDecimal odDostawcow;

    @Column(name="ODWROTNY")
    private Integer odwrotny;

    @Column(name="OPIS")
    private String opis;

    @Column(name="OSTRZEZENIE")
    private String ostrzezenie;

    @Column(name="PC_AKTYWNY")
    private Integer pcAktywny;

    @Column(name="PC_ILOSC_GR_NA100ML")
    private BigDecimal pcIloscGrNa100ml;

    @Column(name="PC_ILOSC_ML")
    private BigDecimal pcIloscMl;

    @Column(name="PC_KOF_TAUR")
    private Integer pcKofTaur;

    @Column(name="PC_KWOTA_STALA")
    private BigDecimal pcKwotaStala;

    @Column(name="PC_KWOTA_ZMIENNA")
    private BigDecimal pcKwotaZmienna;

    @Column(name="PC_ROZTWOR_WE")
    private Integer pcRoztworWe;

    @Column(name="PC_SOKI")
    private Integer pcSoki;

    @Column(name="PKWIU")
    private String pkwiu;

    @Column(name="PLU")
    private int plu;

    @Column(name="PODATEK_CUKROWY")
    private BigDecimal podatekCukrowy;

    @Column(name="PODLEGA_PP")
    private Integer podlegaPp;

    @Column(name="PODLEGA_RABATOWANIU")
    private Integer podlegaRabatowaniu;

    @Column(name="POKAZUJ_OSTRZEZENIE")
    private Integer pokazujOstrzezenie;

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

    @Column(name="PRG_ILOSC")
    private BigDecimal prgIlosc;

    @Column(name="PRG_LOJAL")
    private Integer prgLojal;

    @Column(name="PRODUCENT")
    private String producent;

    @Column(name="PROMOCJA_DO")
    private int promocjaDo;

    @Column(name="PROMOCJA_OD")
    private int promocjaOd;

    @Column(name="PROMOCJA_PROCENT")
    private BigDecimal promocjaProcent;

    @Column(name="PROMOCJA_RABAT")
    private Integer promocjaRabat;

    @Column(name="PRZELICZNIK_PROD")
    private BigDecimal przelicznikProd;

    @Column(name="RODZAJ")
    private String rodzaj;

    @Column(name="RODZAJ_TRANSAKCJI_HANDLOWEJ")
    private String rodzajTransakcjiHandlowej;

    @Column(name="ROZCHODY_ROZBIJAJ_PO_DOSTAWACH")
    private Integer rozchodyRozbijajPoDostawach;

    @Column(name="SEMAFOR")
    private BigDecimal semafor;

    @Column(name="STAN")
    private BigDecimal stan;

    @Column(name="STAN_MAKSYMALNY")
    private BigDecimal stanMaksymalny;

    @Column(name="STAN_MINIMALNY")
    private BigDecimal stanMinimalny;

    @Column(name="SWWKU")
    private String swwku;

    @Column(name="SYM_WAL")
    private String symWal;

    @Column(name="TYP_OPLATY")
    private Integer typOplaty;

    @Column(name="UWAGI")
    private String uwagi;

    @Column(name="VAT_SPRZEDAZY")
    private String vatSprzedazy;

    @Column(name="VAT_ZAKUPU")
    private String vatZakupu;

    @Column(name="WAGA")
    private BigDecimal waga;

    @Column(name="WYLACZ_CENY_IND")
    private String wylaczCenyInd;

    @Column(name="WYMIAR_G")
    private BigDecimal wymiarG;

    @Column(name="WYMIAR_S")
    private BigDecimal wymiarS;

    @Column(name="WYMIAR_W")
    private BigDecimal wymiarW;

    @Column(name="WYMUSZAJ_DOSTAWY")
    private Integer wymuszajDostawy;

    @Column(name="WYROZNIK")
    private String wyroznik;

    @Column(name="ZABLOKOWANY")
    private Integer zablokowany;

    @Column(name="ZAMOWIONO")
    private BigDecimal zamowiono;

    @Column(name="ZAREZERWOWANO")
    private BigDecimal zarezerwowano;

    @Column(name="ZASADA_ZDEJMOWANIA_ZE_STANU")
    private String zasadaZdejmowaniaZeStanu;

    //bi-directional many-to-one association to PozycjaDokumentuMagazynowego
//    @ManyToOne
//    @JoinColumn(name="ID_ARTYKULU", referencedColumnName="ID_ARTYKULU", insertable=false, updatable=false)
//    private PozycjaDokumentuMagazynowego pozycjaDokumentuMagazynowego;



    public Artykul() {
    }

    public long getIdArtykulu() {
        return this.idArtykulu;
    }

    public void setIdArtykulu(long idArtykulu) {
        this.idArtykulu = idArtykulu;
    }

    public Integer getAkcyza() {
        return this.akcyza;
    }

    public void setAkcyza(Integer akcyza) {
        this.akcyza = akcyza;
    }

    public String getAkcyzaJm() {
        return this.akcyzaJm;
    }

    public void setAkcyzaJm(String akcyzaJm) {
        this.akcyzaJm = akcyzaJm;
    }

    public BigDecimal getAkcyzaPrzelicznik() {
        return this.akcyzaPrzelicznik;
    }

    public void setAkcyzaPrzelicznik(BigDecimal akcyzaPrzelicznik) {
        this.akcyzaPrzelicznik = akcyzaPrzelicznik;
    }

    public BigDecimal getAkcyzaPrzelicznikJmJa() {
        return this.akcyzaPrzelicznikJmJa;
    }

    public void setAkcyzaPrzelicznikJmJa(BigDecimal akcyzaPrzelicznikJmJa) {
        this.akcyzaPrzelicznikJmJa = akcyzaPrzelicznikJmJa;
    }

    public BigDecimal getAkcyzaStawkaZaJm() {
        return this.akcyzaStawkaZaJm;
    }

    public void setAkcyzaStawkaZaJm(BigDecimal akcyzaStawkaZaJm) {
        this.akcyzaStawkaZaJm = akcyzaStawkaZaJm;
    }

    public Integer getAktCenPrzyDostawie() {
        return this.aktCenPrzyDostawie;
    }

    public void setAktCenPrzyDostawie(Integer aktCenPrzyDostawie) {
        this.aktCenPrzyDostawie = aktCenPrzyDostawie;
    }

    public Integer getAktywnyDlaSysZew() {
        return this.aktywnyDlaSysZew;
    }

    public void setAktywnyDlaSysZew(Integer aktywnyDlaSysZew) {
        this.aktywnyDlaSysZew = aktywnyDlaSysZew;
    }

    public BigDecimal getCZakupuBruttoWal() {
        return this.cZakupuBruttoWal;
    }

    public void setCZakupuBruttoWal(BigDecimal cZakupuBruttoWal) {
        this.cZakupuBruttoWal = cZakupuBruttoWal;
    }

    public BigDecimal getCZakupuNettoWal() {
        return this.cZakupuNettoWal;
    }

    public void setCZakupuNettoWal(BigDecimal cZakupuNettoWal) {
        this.cZakupuNettoWal = cZakupuNettoWal;
    }

    public BigDecimal getCenaBKgo() {
        return this.cenaBKgo;
    }

    public void setCenaBKgo(BigDecimal cenaBKgo) {
        this.cenaBKgo = cenaBKgo;
    }

    public BigDecimal getCenaNKgo() {
        return this.cenaNKgo;
    }

    public void setCenaNKgo(BigDecimal cenaNKgo) {
        this.cenaNKgo = cenaNKgo;
    }

    public BigDecimal getCenaPromocjiB() {
        return this.cenaPromocjiB;
    }

    public void setCenaPromocjiB(BigDecimal cenaPromocjiB) {
        this.cenaPromocjiB = cenaPromocjiB;
    }

    public BigDecimal getCenaPromocjiN() {
        return this.cenaPromocjiN;
    }

    public void setCenaPromocjiN(BigDecimal cenaPromocjiN) {
        this.cenaPromocjiN = cenaPromocjiN;
    }

    public BigDecimal getCenaZakupuBrutto() {
        return this.cenaZakupuBrutto;
    }

    public void setCenaZakupuBrutto(BigDecimal cenaZakupuBrutto) {
        this.cenaZakupuBrutto = cenaZakupuBrutto;
    }

    public BigDecimal getCenaZakupuNetto() {
        return this.cenaZakupuNetto;
    }

    public void setCenaZakupuNetto(BigDecimal cenaZakupuNetto) {
        this.cenaZakupuNetto = cenaZakupuNetto;
    }

    public Integer getCertyfikat() {
        return this.certyfikat;
    }

    public void setCertyfikat(Integer certyfikat) {
        this.certyfikat = certyfikat;
    }

    public int getDataCertyfikatu() {
        return this.dataCertyfikatu;
    }

    public void setDataCertyfikatu(int dataCertyfikatu) {
        this.dataCertyfikatu = dataCertyfikatu;
    }

    public int getDataZmCz() {
        return this.dataZmCz;
    }

    public void setDataZmCz(int dataZmCz) {
        this.dataZmCz = dataZmCz;
    }

    public BigDecimal getDoOdbiorcow() {
        return this.doOdbiorcow;
    }

    public void setDoOdbiorcow(BigDecimal doOdbiorcow) {
        this.doOdbiorcow = doOdbiorcow;
    }

    public BigDecimal getDoRezerwacji() {
        return this.doRezerwacji;
    }

    public void setDoRezerwacji(BigDecimal doRezerwacji) {
        this.doRezerwacji = doRezerwacji;
    }

    public Integer getDomyslnyVatZaGranica() {
        return this.domyslnyVatZaGranica;
    }

    public void setDomyslnyVatZaGranica(Integer domyslnyVatZaGranica) {
        this.domyslnyVatZaGranica = domyslnyVatZaGranica;
    }

    public Integer getDostepnyWAukcjach() {
        return this.dostepnyWAukcjach;
    }

    public void setDostepnyWAukcjach(Integer dostepnyWAukcjach) {
        this.dostepnyWAukcjach = dostepnyWAukcjach;
    }

    public Integer getDostepnyWSklepieInter() {
        return this.dostepnyWSklepieInter;
    }

    public void setDostepnyWSklepieInter(Integer dostepnyWSklepieInter) {
        this.dostepnyWSklepieInter = dostepnyWSklepieInter;
    }

    public Integer getFlagaStanu() {
        return this.flagaStanu;
    }

    public void setFlagaStanu(Integer flagaStanu) {
        this.flagaStanu = flagaStanu;
    }

    public String getGuidArtykul() {
        return this.guidArtykul;
    }

    public void setGuidArtykul(String guidArtykul) {
        this.guidArtykul = guidArtykul;
    }

    public BigDecimal getIdArtykuluProd() {
        return this.idArtykuluProd;
    }

    public void setIdArtykuluProd(BigDecimal idArtykuluProd) {
        this.idArtykuluProd = idArtykuluProd;
    }

    public BigDecimal getIdCenyDom() {
        return this.idCenyDom;
    }

    public void setIdCenyDom(BigDecimal idCenyDom) {
        this.idCenyDom = idCenyDom;
    }

    public BigDecimal getIdDostawcyPreferowanego() {
        return this.idDostawcyPreferowanego;
    }

    public void setIdDostawcyPreferowanego(BigDecimal idDostawcyPreferowanego) {
        this.idDostawcyPreferowanego = idDostawcyPreferowanego;
    }

    public BigDecimal getIdEtykiety() {
        return this.idEtykiety;
    }

    public void setIdEtykiety(BigDecimal idEtykiety) {
        this.idEtykiety = idEtykiety;
    }

    public BigDecimal getIdFprom() {
        return this.idFprom;
    }

    public void setIdFprom(BigDecimal idFprom) {
        this.idFprom = idFprom;
    }

    public BigDecimal getIdJednostki() {
        return this.idJednostki;
    }

    public void setIdJednostki(BigDecimal idJednostki) {
        this.idJednostki = idJednostki;
    }

    public BigDecimal getIdJednostkiRef() {
        return this.idJednostkiRef;
    }

    public void setIdJednostkiRef(BigDecimal idJednostkiRef) {
        this.idJednostkiRef = idJednostkiRef;
    }

    public BigDecimal getIdJednostkiSprz() {
        return this.idJednostkiSprz;
    }

    public void setIdJednostkiSprz(BigDecimal idJednostkiSprz) {
        this.idJednostkiSprz = idJednostkiSprz;
    }

    public BigDecimal getIdJednostkiZak() {
        return this.idJednostkiZak;
    }

    public void setIdJednostkiZak(BigDecimal idJednostkiZak) {
        this.idJednostkiZak = idJednostkiZak;
    }

    public BigDecimal getIdKategorii() {
        return this.idKategorii;
    }

    public void setIdKategorii(BigDecimal idKategorii) {
        this.idKategorii = idKategorii;
    }

    public BigDecimal getIdKategoriiTree() {
        return this.idKategoriiTree;
    }

    public void setIdKategoriiTree(BigDecimal idKategoriiTree) {
        this.idKategoriiTree = idKategoriiTree;
    }

    public BigDecimal getIdMagazynu() {
        return this.idMagazynu;
    }

    public void setIdMagazynu(BigDecimal idMagazynu) {
        this.idMagazynu = idMagazynu;
    }

    public BigDecimal getIdOpakowaniaRef() {
        return this.idOpakowaniaRef;
    }

    public void setIdOpakowaniaRef(BigDecimal idOpakowaniaRef) {
        this.idOpakowaniaRef = idOpakowaniaRef;
    }

    public BigDecimal getIdProducenta() {
        return this.idProducenta;
    }

    public void setIdProducenta(BigDecimal idProducenta) {
        this.idProducenta = idProducenta;
    }

    public BigDecimal getIloscEdytowana() {
        return this.iloscEdytowana;
    }

    public void setIloscEdytowana(BigDecimal iloscEdytowana) {
        this.iloscEdytowana = iloscEdytowana;
    }

    public BigDecimal getIloscProd() {
        return this.iloscProd;
    }

    public void setIloscProd(BigDecimal iloscProd) {
        this.iloscProd = iloscProd;
    }

    public String getIndKatTowarZast() {
        return this.indKatTowarZast;
    }

    public void setIndKatTowarZast(String indKatTowarZast) {
        this.indKatTowarZast = indKatTowarZast;
    }

    public String getIndeksHandlowy() {
        return this.indeksHandlowy;
    }

    public void setIndeksHandlowy(String indeksHandlowy) {
        this.indeksHandlowy = indeksHandlowy;
    }

    public String getIndeksKatalogowy() {
        return this.indeksKatalogowy;
    }

    public void setIndeksKatalogowy(String indeksKatalogowy) {
        this.indeksKatalogowy = indeksKatalogowy;
    }

    public String getIndeksProducenta() {
        return this.indeksProducenta;
    }

    public void setIndeksProducenta(String indeksProducenta) {
        this.indeksProducenta = indeksProducenta;
    }

    public String getJedWagi() {
        return this.jedWagi;
    }

    public void setJedWagi(String jedWagi) {
        this.jedWagi = jedWagi;
    }

    public String getJedWymiaru() {
        return this.jedWymiaru;
    }

    public void setJedWymiaru(String jedWymiaru) {
        this.jedWymiaru = jedWymiaru;
    }

    public String getJednostkaProd() {
        return this.jednostkaProd;
    }

    public void setJednostkaProd(String jednostkaProd) {
        this.jednostkaProd = jednostkaProd;
    }

    public Integer getJestZdjecie() {
        return this.jestZdjecie;
    }

    public void setJestZdjecie(Integer jestZdjecie) {
        this.jestZdjecie = jestZdjecie;
    }

    public String getKodCn() {
        return this.kodCn;
    }

    public void setKodCn(String kodCn) {
        this.kodCn = kodCn;
    }

    public String getKodKreskowy() {
        return this.kodKreskowy;
    }

    public void setKodKreskowy(String kodKreskowy) {
        this.kodKreskowy = kodKreskowy;
    }

    public String getKrajPochodzenia() {
        return this.krajPochodzenia;
    }

    public void setKrajPochodzenia(String krajPochodzenia) {
        this.krajPochodzenia = krajPochodzenia;
    }

    public String getLokalizacja() {
        return this.lokalizacja;
    }

    public void setLokalizacja(String lokalizacja) {
        this.lokalizacja = lokalizacja;
    }

    public Integer getMarzowy() {
        return this.marzowy;
    }

    public void setMarzowy(Integer marzowy) {
        this.marzowy = marzowy;
    }

    public BigDecimal getMinNarzut() {
        return this.minNarzut;
    }

    public void setMinNarzut(BigDecimal minNarzut) {
        this.minNarzut = minNarzut;
    }

    public String getNazwa() {
        return this.nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getNazwaCala() {
        return this.nazwaCala;
    }

    public void setNazwaCala(String nazwaCala) {
        this.nazwaCala = nazwaCala;
    }

    public String getNazwaCertyfikatu() {
        return this.nazwaCertyfikatu;
    }

    public void setNazwaCertyfikatu(String nazwaCertyfikatu) {
        this.nazwaCertyfikatu = nazwaCertyfikatu;
    }

    public String getNazwaIntrastat() {
        return this.nazwaIntrastat;
    }

    public void setNazwaIntrastat(String nazwaIntrastat) {
        this.nazwaIntrastat = nazwaIntrastat;
    }

    public String getNazwaOryg() {
        return this.nazwaOryg;
    }

    public void setNazwaOryg(String nazwaOryg) {
        this.nazwaOryg = nazwaOryg;
    }

    public String getNazwa2() {
        return this.nazwa2;
    }

    public void setNazwa2(String nazwa2) {
        this.nazwa2 = nazwa2;
    }

    public BigDecimal getOdDostawcow() {
        return this.odDostawcow;
    }

    public void setOdDostawcow(BigDecimal odDostawcow) {
        this.odDostawcow = odDostawcow;
    }

    public Integer getOdwrotny() {
        return this.odwrotny;
    }

    public void setOdwrotny(Integer odwrotny) {
        this.odwrotny = odwrotny;
    }

    public String getOpis() {
        return this.opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getOstrzezenie() {
        return this.ostrzezenie;
    }

    public void setOstrzezenie(String ostrzezenie) {
        this.ostrzezenie = ostrzezenie;
    }

    public Integer getPcAktywny() {
        return this.pcAktywny;
    }

    public void setPcAktywny(Integer pcAktywny) {
        this.pcAktywny = pcAktywny;
    }

    public BigDecimal getPcIloscGrNa100ml() {
        return this.pcIloscGrNa100ml;
    }

    public void setPcIloscGrNa100ml(BigDecimal pcIloscGrNa100ml) {
        this.pcIloscGrNa100ml = pcIloscGrNa100ml;
    }

    public BigDecimal getPcIloscMl() {
        return this.pcIloscMl;
    }

    public void setPcIloscMl(BigDecimal pcIloscMl) {
        this.pcIloscMl = pcIloscMl;
    }

    public Integer getPcKofTaur() {
        return this.pcKofTaur;
    }

    public void setPcKofTaur(Integer pcKofTaur) {
        this.pcKofTaur = pcKofTaur;
    }

    public BigDecimal getPcKwotaStala() {
        return this.pcKwotaStala;
    }

    public void setPcKwotaStala(BigDecimal pcKwotaStala) {
        this.pcKwotaStala = pcKwotaStala;
    }

    public BigDecimal getPcKwotaZmienna() {
        return this.pcKwotaZmienna;
    }

    public void setPcKwotaZmienna(BigDecimal pcKwotaZmienna) {
        this.pcKwotaZmienna = pcKwotaZmienna;
    }

    public Integer getPcRoztworWe() {
        return this.pcRoztworWe;
    }

    public void setPcRoztworWe(Integer pcRoztworWe) {
        this.pcRoztworWe = pcRoztworWe;
    }

    public Integer getPcSoki() {
        return this.pcSoki;
    }

    public void setPcSoki(Integer pcSoki) {
        this.pcSoki = pcSoki;
    }

    public String getPkwiu() {
        return this.pkwiu;
    }

    public void setPkwiu(String pkwiu) {
        this.pkwiu = pkwiu;
    }

    public int getPlu() {
        return this.plu;
    }

    public void setPlu(int plu) {
        this.plu = plu;
    }

    public BigDecimal getPodatekCukrowy() {
        return this.podatekCukrowy;
    }

    public void setPodatekCukrowy(BigDecimal podatekCukrowy) {
        this.podatekCukrowy = podatekCukrowy;
    }

    public Integer getPodlegaPp() {
        return this.podlegaPp;
    }

    public void setPodlegaPp(Integer podlegaPp) {
        this.podlegaPp = podlegaPp;
    }

    public Integer getPodlegaRabatowaniu() {
        return this.podlegaRabatowaniu;
    }

    public void setPodlegaRabatowaniu(Integer podlegaRabatowaniu) {
        this.podlegaRabatowaniu = podlegaRabatowaniu;
    }

    public Integer getPokazujOstrzezenie() {
        return this.pokazujOstrzezenie;
    }

    public void setPokazujOstrzezenie(Integer pokazujOstrzezenie) {
        this.pokazujOstrzezenie = pokazujOstrzezenie;
    }

    public String getPole1() {
        return this.pole1;
    }

    public void setPole1(String pole1) {
        this.pole1 = pole1;
    }

    public String getPole10() {
        return this.pole10;
    }

    public void setPole10(String pole10) {
        this.pole10 = pole10;
    }

    public String getPole2() {
        return this.pole2;
    }

    public void setPole2(String pole2) {
        this.pole2 = pole2;
    }

    public String getPole3() {
        return this.pole3;
    }

    public void setPole3(String pole3) {
        this.pole3 = pole3;
    }

    public String getPole4() {
        return this.pole4;
    }

    public void setPole4(String pole4) {
        this.pole4 = pole4;
    }

    public String getPole5() {
        return this.pole5;
    }

    public void setPole5(String pole5) {
        this.pole5 = pole5;
    }

    public String getPole6() {
        return this.pole6;
    }

    public void setPole6(String pole6) {
        this.pole6 = pole6;
    }

    public String getPole7() {
        return this.pole7;
    }

    public void setPole7(String pole7) {
        this.pole7 = pole7;
    }

    public String getPole8() {
        return this.pole8;
    }

    public void setPole8(String pole8) {
        this.pole8 = pole8;
    }

    public String getPole9() {
        return this.pole9;
    }

    public void setPole9(String pole9) {
        this.pole9 = pole9;
    }

    public BigDecimal getPrgIlosc() {
        return this.prgIlosc;
    }

    public void setPrgIlosc(BigDecimal prgIlosc) {
        this.prgIlosc = prgIlosc;
    }

    public Integer getPrgLojal() {
        return this.prgLojal;
    }

    public void setPrgLojal(Integer prgLojal) {
        this.prgLojal = prgLojal;
    }

    public String getProducent() {
        return this.producent;
    }

    public void setProducent(String producent) {
        this.producent = producent;
    }

    public int getPromocjaDo() {
        return this.promocjaDo;
    }

    public void setPromocjaDo(int promocjaDo) {
        this.promocjaDo = promocjaDo;
    }

    public int getPromocjaOd() {
        return this.promocjaOd;
    }

    public void setPromocjaOd(int promocjaOd) {
        this.promocjaOd = promocjaOd;
    }

    public BigDecimal getPromocjaProcent() {
        return this.promocjaProcent;
    }

    public void setPromocjaProcent(BigDecimal promocjaProcent) {
        this.promocjaProcent = promocjaProcent;
    }

    public Integer getPromocjaRabat() {
        return this.promocjaRabat;
    }

    public void setPromocjaRabat(Integer promocjaRabat) {
        this.promocjaRabat = promocjaRabat;
    }

    public BigDecimal getPrzelicznikProd() {
        return this.przelicznikProd;
    }

    public void setPrzelicznikProd(BigDecimal przelicznikProd) {
        this.przelicznikProd = przelicznikProd;
    }

    public String getRodzaj() {
        return this.rodzaj;
    }

    public void setRodzaj(String rodzaj) {
        this.rodzaj = rodzaj;
    }

    public String getRodzajTransakcjiHandlowej() {
        return this.rodzajTransakcjiHandlowej;
    }

    public void setRodzajTransakcjiHandlowej(String rodzajTransakcjiHandlowej) {
        this.rodzajTransakcjiHandlowej = rodzajTransakcjiHandlowej;
    }

    public Integer getRozchodyRozbijajPoDostawach() {
        return this.rozchodyRozbijajPoDostawach;
    }

    public void setRozchodyRozbijajPoDostawach(Integer rozchodyRozbijajPoDostawach) {
        this.rozchodyRozbijajPoDostawach = rozchodyRozbijajPoDostawach;
    }

    public BigDecimal getSemafor() {
        return this.semafor;
    }

    public void setSemafor(BigDecimal semafor) {
        this.semafor = semafor;
    }

    public BigDecimal getStan() {
        return this.stan;
    }

    public void setStan(BigDecimal stan) {
        this.stan = stan;
    }

    public BigDecimal getStanMaksymalny() {
        return this.stanMaksymalny;
    }

    public void setStanMaksymalny(BigDecimal stanMaksymalny) {
        this.stanMaksymalny = stanMaksymalny;
    }

    public BigDecimal getStanMinimalny() {
        return this.stanMinimalny;
    }

    public void setStanMinimalny(BigDecimal stanMinimalny) {
        this.stanMinimalny = stanMinimalny;
    }

    public String getSwwku() {
        return this.swwku;
    }

    public void setSwwku(String swwku) {
        this.swwku = swwku;
    }

    public String getSymWal() {
        return this.symWal;
    }

    public void setSymWal(String symWal) {
        this.symWal = symWal;
    }

    public Integer getTypOplaty() {
        return this.typOplaty;
    }

    public void setTypOplaty(Integer typOplaty) {
        this.typOplaty = typOplaty;
    }

    public String getUwagi() {
        return this.uwagi;
    }

    public void setUwagi(String uwagi) {
        this.uwagi = uwagi;
    }

    public String getVatSprzedazy() {
        return this.vatSprzedazy;
    }

    public void setVatSprzedazy(String vatSprzedazy) {
        this.vatSprzedazy = vatSprzedazy;
    }

    public String getVatZakupu() {
        return this.vatZakupu;
    }

    public void setVatZakupu(String vatZakupu) {
        this.vatZakupu = vatZakupu;
    }

    public BigDecimal getWaga() {
        return this.waga;
    }

    public void setWaga(BigDecimal waga) {
        this.waga = waga;
    }

    public String getWylaczCenyInd() {
        return this.wylaczCenyInd;
    }

    public void setWylaczCenyInd(String wylaczCenyInd) {
        this.wylaczCenyInd = wylaczCenyInd;
    }

    public BigDecimal getWymiarG() {
        return this.wymiarG;
    }

    public void setWymiarG(BigDecimal wymiarG) {
        this.wymiarG = wymiarG;
    }

    public BigDecimal getWymiarS() {
        return this.wymiarS;
    }

    public void setWymiarS(BigDecimal wymiarS) {
        this.wymiarS = wymiarS;
    }

    public BigDecimal getWymiarW() {
        return this.wymiarW;
    }

    public void setWymiarW(BigDecimal wymiarW) {
        this.wymiarW = wymiarW;
    }

    public Integer getWymuszajDostawy() {
        return this.wymuszajDostawy;
    }

    public void setWymuszajDostawy(Integer wymuszajDostawy) {
        this.wymuszajDostawy = wymuszajDostawy;
    }

    public String getWyroznik() {
        return this.wyroznik;
    }

    public void setWyroznik(String wyroznik) {
        this.wyroznik = wyroznik;
    }

    public Integer getZablokowany() {
        return this.zablokowany;
    }

    public void setZablokowany(Integer zablokowany) {
        this.zablokowany = zablokowany;
    }

    public BigDecimal getZamowiono() {
        return this.zamowiono;
    }

    public void setZamowiono(BigDecimal zamowiono) {
        this.zamowiono = zamowiono;
    }

    public BigDecimal getZarezerwowano() {
        return this.zarezerwowano;
    }

    public void setZarezerwowano(BigDecimal zarezerwowano) {
        this.zarezerwowano = zarezerwowano;
    }

    public String getZasadaZdejmowaniaZeStanu() {
        return this.zasadaZdejmowaniaZeStanu;
    }

    public void setZasadaZdejmowaniaZeStanu(String zasadaZdejmowaniaZeStanu) {
        this.zasadaZdejmowaniaZeStanu = zasadaZdejmowaniaZeStanu;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public List<PozycjaDokumentuMagazynowego> getPozycjaDokumentuMagazynowego() {
        return pozycjaDokumentuMagazynowego;
    }

    public void setPozycjaDokumentuMagazynowego(List<PozycjaDokumentuMagazynowego> pozycjaDokumentuMagazynowego) {
        this.pozycjaDokumentuMagazynowego = pozycjaDokumentuMagazynowego;
    }

    public BigDecimal getcZakupuBruttoWal() {
        return cZakupuBruttoWal;
    }

    public void setcZakupuBruttoWal(BigDecimal cZakupuBruttoWal) {
        this.cZakupuBruttoWal = cZakupuBruttoWal;
    }

    public BigDecimal getcZakupuNettoWal() {
        return cZakupuNettoWal;
    }

    public void setcZakupuNettoWal(BigDecimal cZakupuNettoWal) {
        this.cZakupuNettoWal = cZakupuNettoWal;
    }
}