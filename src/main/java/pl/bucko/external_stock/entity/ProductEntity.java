package pl.bucko.external_stock.entity;

import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity(name = "Products")
@Table(name = "products")
public class ProductEntity {


    @Column(name = "kod_marko")
    private String kodMarko;

    @Id
    @Column(name = "kod_producenta", unique = true, nullable = false)
    private String kodProducenta;

    @Column(name = "producent")
    private String producent;

    @Column(name = "dystrybutor")
    private String dystrybutor;

    @Column(name = "stan")
    private Integer stan;


    public ProductEntity() {
    }

    public ProductEntity(String kodProducenta, String kodMarko, String producent, String dystrybutor, Integer stan) {

        this.kodProducenta = kodProducenta;
        this.kodMarko = kodMarko;
        this.producent = producent;
        this.dystrybutor = dystrybutor;
        this.stan = stan;
    }

    public String getKodProducenta() {
        return kodProducenta;
    }

    public void setKodProducenta(String kodProducenta) {
        this.kodProducenta = kodProducenta;
    }

    public String getKodMarko() {
        return kodMarko;
    }

    public void setKodMarko(String kodMarko) {
        this.kodMarko = kodMarko;
    }

    public String getProducent() {
        return producent;
    }

    public void setProducent(String producent) {
        this.producent = producent;
    }

    public String getDystrybutor() {
        return dystrybutor;
    }

    public void setDystrybutor(String dystrybutor) {
        this.dystrybutor = dystrybutor;
    }

    public Integer getStan() {
        return stan;
    }

    public void setStan(Integer stan) {
        this.stan = stan;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ProductEntity{");
        sb.append(", kod Producenta='").append(kodProducenta).append('\'');
        sb.append(", kod Marko='").append(kodMarko).append('\'');
        sb.append(", producent='").append(producent).append('\'');
        sb.append(", dystrybutor='").append(dystrybutor).append('\'');
        sb.append(", stan=").append(stan);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductEntity that = (ProductEntity) o;
        return Objects.equals(kodMarko, that.kodMarko) &&
                Objects.equals(kodProducenta, that.kodProducenta) &&
                Objects.equals(producent, that.producent) &&
                Objects.equals(dystrybutor, that.dystrybutor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(kodMarko, kodProducenta, producent, dystrybutor);
    }
}
