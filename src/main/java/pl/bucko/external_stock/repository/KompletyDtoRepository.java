package pl.bucko.external_stock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.bucko.external_stock.dto.KompletyDtoInterface;
import pl.bucko.external_stock.entity.Artykul;

import java.util.List;

@Repository
public interface KompletyDtoRepository extends JpaRepository<Artykul, Long> {

    @Query(value = "SELECT aa.INDEKS_KATALOGOWY AS indeksKatalogowyKomplet, d.ilosc AS ilosckomplet, a.indeks_katalogowy AS indeksKatalogowyProdukt, a.stan AS iloscProduct, a.pole2 AS dostawca FROM ((DEFINICJA_PRODUKTU d INNER JOIN ARTYKUL aa ON d.ID_ARTYKULU = aa.ID_ARTYKULU) INNER JOIN ARTYKUL a ON d.ID_SKLADNIKA = a.ID_ARTYKULU)" , nativeQuery = true)
    List<KompletyDtoInterface> pobierzProduktyKompletow();
}
