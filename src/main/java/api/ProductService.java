package api;

import entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    Integer getProductCount();
    Product getProduct(String productName);
    boolean isCountHigherThenZero(String productName);
    boolean isProductExist(String productName);
    boolean isProductExist(Long id);
}
