package entity;

public class Boots extends Product {
    private Integer size;
    private boolean isNaturalSkin;

    public Boots(Long id, String productName, Float price, Float weight, String color, Integer productCount, Integer size, boolean isNaturalSkin) {
        super(id, productName, price, weight, color, productCount);
        this.size = size;
        this.isNaturalSkin = isNaturalSkin;
    }

    @Override
    public String toString() {
        return "Boots{" +
                "size=" + size +
                ", isNaturalSkin=" + isNaturalSkin +
                ", id=" + id +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", weight=" + weight +
                ", color='" + color + '\'' +
                ", productCount=" + productCount +
                '}';
    }
}
