package service;

import api.ProductService;
import entity.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    List<Product> products;

    public ProductServiceImpl(List<Product> products){
        this.products = products;
    }

    public ProductServiceImpl(){
        this.products = new ArrayList<>();
    }


    @Override
    public List<Product> getAllProducts() {
        return this.products;
    }

    @Override
    public Integer getProductCount() {
        return products.size();
    }

    @Override
    public Product getProduct(String productName) {
        for(Product product : products) {
            if (product.getProductName().equals(productName)) {
                return product;
            }
        }
        return null;
    }

    @Override
    public boolean isCountHigherThenZero(String productName) {
        for(Product product : products) {
            if (isProductExist(productName) && product.getProductCount() > 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isProductExist(String productName) {
        for(Product product : products) {
            if (product.getProductName().equals(productName)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isProductExist(Long id) {
        for(Product product : products) {
            if (product.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }
}
