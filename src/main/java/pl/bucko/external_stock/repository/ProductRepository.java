package pl.bucko.external_stock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.bucko.external_stock.entity.ProductEntity;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, String> {

    @Override
    <S extends ProductEntity> List<S> saveAll(Iterable<S> iterable);

    @Override
    <S extends ProductEntity> S save(S s);

    Long countByDystrybutor(String Dystrybutor);

    List<ProductEntity> findByKodMarkoIsNotNullAndDystrybutorAndStanGreaterThan(String Dystrybutor, int Stan);

    @Transactional
    @Modifying
    @Query(value ="update products set products.stan=0 where products.dystrybutor=:Dystrybutor", nativeQuery = true)
    void changeStockToZero(@Param("Dystrybutor") String dystrybutor);

    @Query(value ="SELECT DISTINCT e.producent FROM PRODUCTS e where e.producent is not null", nativeQuery = true)
    List<String> znajdzProducentow();

    ArrayList<ProductEntity> findByKodMarkoIsNotNullAndStanGreaterThanAndProducentIn(int Stan, List<String> brandSplitedList);

    @Transactional
    @Modifying
    @Query(value ="delete from PRODUCTS where producent = :producent", nativeQuery = true)
    void deleteByProducent(String producent);

}
