package pl.bucko.external_stock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Temporal;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.bucko.external_stock.dto.ArtykulJoinDtoInterface;
import pl.bucko.external_stock.entity.PozycjaDokumentuMagazynowego;

import java.util.Date;
import java.util.List;

@Repository
public interface ArtykulJoinDtoRepository extends JpaRepository<PozycjaDokumentuMagazynowego, Long> {

    @Transactional
    @Modifying
    @Query(value = "SELECT a.ID_ARTYKULU AS idArtykulu, a.INDEKS_KATALOGOWY AS indeksKatalogowy, a.STAN AS stan, SUM(p.ilosc) AS iloscSprzedana, p.ID_POZ_DOK_MAG AS pozMagazynowa," +
            "a.STAN_MINIMALNY AS stanMinimalny, a.STAN_MAKSYMALNY AS stanMaksymalny, a.POLE2 AS dostawca FROM WIDOK_DOKUMENTMAGAZYNOWY w JOIN POZYCJA_DOKUMENTU_MAGAZYNOWEGO AS p ON w.IdDokumentuHandlowego=p.ID_DOK_HANDLOWEGO JOIN ARTYKUL AS a ON a.ID_ARTYKULU = p.ID_ARTYKULU WHERE w.DataWystawienia BETWEEN :startDate AND :endDate AND a.POLE2 IN :dostawca AND w.IdTypu = '1' AND w.IdMagazynu = '14' AND a.RODZAJ NOT LIKE 'Usługa' Group BY a.ID_ARTYKULU, a.INDEKS_KATALOGOWY, a.STAN, p.ID_POZ_DOK_MAG, a.STAN_MINIMALNY, a.STAN_MAKSYMALNY, a.POLE2", nativeQuery = true)
    List<ArtykulJoinDtoInterface> getArtykulJoinDto(@Param("dostawca") List<String> dostawca, @Param("startDate") @Temporal Date startDate, @Param("endDate") @Temporal Date endDate );

    @Transactional
    @Modifying
    @Query(value = "SELECT a.ID_ARTYKULU AS idArtykulu, a.INDEKS_KATALOGOWY AS indeksKatalogowy, a.STAN AS stan, SUM(p.ilosc) AS iloscSprzedana, p.ID_POZ_DOK_MAG AS pozMagazynowa," +
            "a.STAN_MINIMALNY AS stanMinimalny, a.STAN_MAKSYMALNY AS stanMaksymalny, a.POLE2 AS dostawca FROM WIDOK_DOKUMENTMAGAZYNOWY w JOIN POZYCJA_DOKUMENTU_MAGAZYNOWEGO AS p ON w.IdDokumentuHandlowego=p.ID_DOK_HANDLOWEGO JOIN ARTYKUL AS a ON a.ID_ARTYKULU = p.ID_ARTYKULU WHERE w.DataWystawienia BETWEEN :startDate AND :endDate AND a.POLE2 IN :dostawca AND a.ID_ARTYKULU = :id AND w.IdTypu = '1' AND w.IdMagazynu = '14' AND a.RODZAJ NOT LIKE 'Usługa' Group BY a.ID_ARTYKULU, a.INDEKS_KATALOGOWY, a.STAN, p.ID_POZ_DOK_MAG, a.STAN_MINIMALNY, a.STAN_MAKSYMALNY, a.POLE2", nativeQuery = true)
    List<ArtykulJoinDtoInterface> getUpdatedArtykulJoinDto(@Param("dostawca") List<String> dostawca, @Param("startDate") @Temporal Date startDate, @Param("endDate") @Temporal Date endDate, @Param("id") String id );
}
