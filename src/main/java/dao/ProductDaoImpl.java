package dao;

import api.ProductDao;
import entity.Product;

import java.util.List;

public class ProductDaoImpl implements ProductDao {
    final String FILENAME = "data.txt";

    public ProductDaoImpl() {
    }

    @Override
    public void saveProduct(Product product) {

    }

    @Override
    public void saveProducts(List<Product> products) {

    }

    @Override
    public void removeProductById(Long productId) {

    }

    @Override
    public void removeProductByName(String productName) {

    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public Product getProductById(Long productId) {
        return null;
    }

    @Override
    public Product getProductByProductName(String productName) {
        return null;
    }
}
