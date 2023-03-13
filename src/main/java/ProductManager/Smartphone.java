package ProductManager;

public class Smartphone extends Product {
    private String generator;

    public Smartphone(int id, String name, int price, String generator) {
        super(id, name, price);
        this.generator = generator;
    }

    public String getGenerator() {
        return generator;
    }
}
