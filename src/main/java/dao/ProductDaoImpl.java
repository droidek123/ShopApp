package dao;

import api.ProductDao;
import entity.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {
    final String FILE_NAME;

    public ProductDaoImpl(String filename) {
        FILE_NAME = filename;
    }

    @Override
    public void saveProduct(Product product) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(FILE_NAME,true);
        PrintWriter printWriter = new PrintWriter(fileOutputStream);
        printWriter.write(product.toString() + "\n");
        printWriter.close();
        fileOutputStream.close();
    }

    @Override
    public void saveProducts(List<Product> products) {
        try {
            PrintWriter printWriter = new PrintWriter(FILE_NAME);
            products.forEach(product -> printWriter.write(product.toString() + "\n"));
            printWriter.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    @Override
    public void removeProductById(Long productId) throws IOException {
        List<Product> products = getAllProducts();

        products.forEach(product -> {
            int i = products.indexOf(product);
            boolean isFoundProduct = products.get(i).getId().equals(productId);
            if (isFoundProduct) {
                products.remove(i);
            }
        });


        saveProducts(products);

    }

    @Override
    public void removeProductByName(String productName) throws IOException {
        List<Product> products = getAllProducts();

        products.forEach(product -> {
            int i = products.indexOf(product);
            boolean isFoundProduct = products.get(i).getProductName().equals(productName);
            if (isFoundProduct) {
                products.remove(i);
            }
        });
    }

    @Override
    public List<Product> getAllProducts() throws IOException {
        List<Product> products = new ArrayList<Product>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_NAME));


        return products;
    }

    @Override
    public Product getProductById(Long productId) {
        return null;
    }

    @Override
    public Product getProductByProductName(String productName) {
        return null;
    }

    public void parseProductToString(){

    }
}
