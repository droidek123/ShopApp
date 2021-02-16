package entity;

public class Cloth extends Product {
    private static final String PRODUCT_SEPARATOR = "#";
    private String size;
    private String material;

    public Cloth(Long id, String productName, Float price, Float weight, String color, Integer productCount, String size, String material) {
        super(id, productName, price, weight, color, productCount);
        this.size = size;
        this.material = material;
    }

    public String getSize() {
        return size;
    }

    public String getMaterial() {
        return material;
    }

    @Override
    public String toString() {
        return "C" + PRODUCT_SEPARATOR + super.toString() + PRODUCT_SEPARATOR + size + PRODUCT_SEPARATOR + material;
    }
}
