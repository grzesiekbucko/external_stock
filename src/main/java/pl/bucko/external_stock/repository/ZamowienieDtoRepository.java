package pl.bucko.external_stock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.bucko.external_stock.dto.ZamowienieDto;
import pl.bucko.external_stock.dto.ZamowienieDtoInterface;
import pl.bucko.external_stock.entity.Artykul;

import java.util.List;

@Repository
public interface ZamowienieDtoRepository extends JpaRepository<Artykul, Long> {

    @Transactional
    @Modifying
    @Query(value = "SELECT p.ID_POZYCJI_ZAMOWIENIA AS idPozycjiZamowienia, p.ID_ZAMOWIENIA AS idZamowienia, a.INDEKS_KATALOGOWY AS indeksKatalogowy, a.POLE6 AS waga, a.OD_DOSTAWCOW AS odDostawcow, a.STAN AS stan, a.STAN_MINIMALNY AS stanMinimalny, p.ZAMOWIONO AS zamowiono, z.NUMER AS numerZamowienia, z.DATA_UTWORZENIA_WIERSZA AS data, z.KONTRAHENT_NAZWA AS kontrahent, a.NAZWA_CALA AS nazwa from pozycja_zamowienia AS p INNER JOIN ARTYKUL AS a ON p.ID_ARTYKULU = a.ID_ARTYKULU INNER JOIN zamowienie AS z ON z.ID_ZAMOWIENIA = p.ID_ZAMOWIENIA WHERE p.ID_ZAMOWIENIA LIKE :idZamowienia", nativeQuery = true)
    List<ZamowienieDtoInterface> getZamowieniaDtoById(@Param("idZamowienia") String idZamowienia);

}
