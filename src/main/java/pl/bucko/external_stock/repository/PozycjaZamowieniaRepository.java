package pl.bucko.external_stock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.bucko.external_stock.entity.PozycjaZamowienia;

import java.math.BigDecimal;

@Repository
public interface PozycjaZamowieniaRepository extends JpaRepository<PozycjaZamowienia, Long> {

    void deleteById(Long id);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(value = "UPDATE POZYCJA_ZAMOWIENIA SET POZYCJA_ZAMOWIENIA.ZAMOWIONO =:ilosc WHERE POZYCJA_ZAMOWIENIA.ID_POZYCJI_ZAMOWIENIA =:id", nativeQuery = true)
    void updateIloscZamowienia(@Param(value = "id") long id, @Param(value = "ilosc") BigDecimal ilosc);

}
