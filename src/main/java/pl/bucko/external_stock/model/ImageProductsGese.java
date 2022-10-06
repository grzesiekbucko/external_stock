package pl.bucko.external_stock.model;

public class ImageProductsGese {

    String kodGese;
    String zdjecieGese;
    String kodMarko;
    String zdjecieMarko;

    public ImageProductsGese(String kodGese, String zdjecieGese, String kodMarko, String zdjecieMarko) {
        this.kodGese = kodGese;
        this.zdjecieGese = zdjecieGese;
        this.kodMarko = kodMarko;
        this.zdjecieMarko = zdjecieMarko;
    }

    public ImageProductsGese() {
    }

    public String getKodGese() {
        return kodGese;
    }

    public void setKodGese(String kodGese) {
        this.kodGese = kodGese;
    }

    public String getZdjecieGese() {
        return zdjecieGese;
    }

    public void setZdjecieGese(String zdjecieGese) {
        this.zdjecieGese = zdjecieGese;
    }

    public String getKodMarko() {
        return kodMarko;
    }

    public void setKodMarko(String kodMarko) {
        this.kodMarko = kodMarko;
    }

    public String getZdjecieMarko() {
        return zdjecieMarko;
    }

    public void setZdjecieMarko(String zdjecieMarko) {
        this.zdjecieMarko = zdjecieMarko;
    }

    @Override
    public String toString() {
        return "ImageProductsGese{" +
                ", kodGese='" + kodGese + '\'' +
                ", zdjecieGese='" + zdjecieGese + '\'' +
                ", kodMarko='" + kodMarko + '\'' +
                ", zdjecieMarko='" + zdjecieMarko + '\'' +
                '}';
    }
}
