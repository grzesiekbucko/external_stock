package pl.bucko.external_stock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.bucko.external_stock.dto.KompletyDtoInterface;
import pl.bucko.external_stock.entity.Artykul;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ArtykulRepository extends JpaRepository<Artykul, Long> {

    Long countByPole2(String Pole2);
    List<Artykul> findByPole2(String Pole2);

    @Query(value = "SELECT DISTINCT e.Pole2 FROM ARTYKUL e where e.Pole2 is not null", nativeQuery = true)
    List<String> znajdzDostawcow();


    @Query(value = "SELECT * from artykul where Rodzaj like 'Zestaw'", nativeQuery = true)
    List<Artykul> znajdzKomplety();
    List<Artykul> findAllByPole2(String Pole2);


    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(value = "UPDATE ARTYKUL SET ARTYKUL.STAN_MINIMALNY =:stan, ARTYKUL.STAN_MAKSYMALNY =:stan_max WHERE ARTYKUL.ID_ARTYKULU =:id", nativeQuery = true)
    void updateStanMinimalny(@Param(value = "id") long id, @Param(value = "stan") BigDecimal stan, @Param(value = "stan_max") BigDecimal stanMax);

    List<Artykul> findByIndeksKatalogowy(String kod_kompletu);

//    List<Artykul> findAllByIdIn(List<Long> kod_kompletu);

    @Query(value = "SELECT aa.INDEKS_KATALOGOWY AS indeksKatalogowyKomplet, d.ilosc AS ilosckomplet, a.indeks_katalogowy AS indeksKatalogowyProdukt, a.stan AS iloscProduct, a.pole2 AS dostawca FROM ((DEFINICJA_PRODUKTU d INNER JOIN ARTYKUL aa ON d.ID_ARTYKULU = aa.ID_ARTYKULU) INNER JOIN ARTYKUL a ON d.ID_SKLADNIKA = a.ID_ARTYKULU) WHERE a.ID_MAGAZYNU = '14'" , nativeQuery = true)
    List<KompletyDtoInterface> pobierzProduktyKompletow();

//    @Modifying(clearAutomatically = true)
//    @Transactional
//    @Query(value = "UPDATE ARTYKUL SET ARTYKUL.STAN =:stan WHERE ARTYKUL.INDEKS_KATALOGOWY =:kod AND ARTYKUL.ID_MAGAZYNU = '23';", nativeQuery = true)
//    void updateStanWirtualny(@Param(value = "stan") BigDecimal stan, @Param(value = "indeks_katalogowy") String kod);

}
