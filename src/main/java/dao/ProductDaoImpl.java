package dao;

import api.ProductDao;
import entity.Boots;
import entity.Cloth;
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
        List<Product> products = new ArrayList<>();
        Product product;
        BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_NAME));
        String readOneLineFromFile = bufferedReader.readLine();
        while (readOneLineFromFile != null){
            product = parseStringToProduct(readOneLineFromFile);
            products.add(product);
            readOneLineFromFile = bufferedReader.readLine();
        }
        bufferedReader.close();
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

    public Product parseStringToProduct(String string){
        String[] textProduct = string.split("#");
        switch (textProduct[0]){
            case "Boots":
                return parseBoots(textProduct);
            case "Cloth":
                return parseCloth(textProduct);
            case "Product":
                return parseProduct(textProduct);
            default:
                return null;
        }
    }

    public Product parseProduct(String[] boots){
        return new Product(Long.parseLong(boots[1]),
                boots[2],
                Float.parseFloat(boots[3]),
                Float.parseFloat(boots[4]),
                boots[5],
                Integer.parseInt(boots[6]));
    }

    public Boots parseBoots(String[] boots){
        return new Boots(Long.parseLong(boots[1]),
               boots[2],
               Float.parseFloat(boots[3]),
               Float.parseFloat(boots[4]),
               boots[5],
               Integer.parseInt(boots[6]),
               Integer.parseInt(boots[7]),
               Boolean.parseBoolean(boots[8]));
    }

    public Cloth parseCloth(String[] boots){
        return new Cloth(Long.parseLong(boots[1]),
                boots[2],
                Float.parseFloat(boots[3]),
                Float.parseFloat(boots[4]),
                boots[5],
                Integer.parseInt(boots[6]),
                boots[7],
                boots[8]);
    }
}
