package pl.bucko.external_stock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Temporal;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.bucko.external_stock.entity.Zamowienie;

import java.util.Date;
import java.util.List;

@Repository
public interface ZamowienieRepository extends JpaRepository<Zamowienie, Long> {

    @Query(value = "select * from zamowienie where DATA_UTWORZENIA_WIERSZA BETWEEN :startDate AND :endDate AND TYP LIKE '2' AND ID_MAGAZYNU LIKE '14'", nativeQuery = true)
    List<Zamowienie> znajdzPoDacie(@Param("startDate") @Temporal Date startDate, @Param("endDate") @Temporal Date endDate);

}
