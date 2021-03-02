package entity;

public class Boots extends Product {
    private static final String PRODUCT_SEPARATOR = "#";
    private Integer size;
    private boolean isNaturalSkin;

    public Boots(Long id, String productName, Float price, Float weight, String color, Integer productCount, Integer size, Boolean isNaturalSkin) {
        super(id, productName, price, weight, color, productCount);
        this.size = size;
        this.isNaturalSkin = isNaturalSkin;
    }

    @Override
    public String toString() {
        return "Boots"+ PRODUCT_SEPARATOR + super.toString() + PRODUCT_SEPARATOR + size + PRODUCT_SEPARATOR + isNaturalSkin;
    }
}
