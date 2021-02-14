package service;

import entity.Boots;
import entity.Cloth;
import entity.Product;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceTest {
    @Test
    public void testGetAllProductsPositive() {
        List<Product> products = new ArrayList<>();
        products.add(new Boots(1L, "Boots", 200.0f, 2.5f, "Blue", 26, 44, false));
        products.add(new Cloth(1L, "T-shirt", 120.0f, 0.5f, "Red", 8, "XL", "Cotton"));

        ProductServiceImpl productService = new ProductServiceImpl(products);
        List<Product> productsFromClass = productService.getAllProducts();

        Assert.assertEquals(products,productsFromClass);
    }

    @Test
    public void testGetAllProductsNegative(){
        List<Product> products = new ArrayList<>();
        products.add(new Boots(1L, "Boots", 200.0f, 2.5f, "Blue", 26, 44, false));
        products.add(new Cloth(1L, "T-shirt", 120.0f, 0.5f, "Red", 8, "XL", "Cotton"));

        List<Product> productList = new ArrayList<>(products);
        productList.add(new Cloth(2L, "Shirt", 220.0f, 0.75f, "Red", 8, "XL", "Cotton"));
        ProductServiceImpl productService = new ProductServiceImpl(productList);
        List<Product> productsFromClass = productService.getAllProducts();

        Assert.assertNotEquals(products,productsFromClass);
    }

    @Test
    public void testGetProductCountPositive(){
        //is
        List<Product> products = new ArrayList<>();
        products.add(new Boots(1L, "Boots", 200.0f, 2.5f, "Blue", 26, 44, false));
        products.add(new Cloth(1L, "T-shirt", 120.0f, 0.5f, "Red", 8, "XL", "Cotton"));

        ProductServiceImpl productService = new ProductServiceImpl(products);
        final int PRODUCTCOUNT = productService.getProductCount();

        Assert.assertEquals(2, PRODUCTCOUNT);
    }

    @Test
    public void testGetProductCountNegative(){
        ProductServiceImpl productService = new ProductServiceImpl();
        final int PRODUCTCOUNT = productService.getProductCount();

        Assert.assertEquals(0,PRODUCTCOUNT);
    }

    @Test
    public void testGetProductName(){
        List<Product> products = new ArrayList<>();
        Product cloth = new Cloth(1L, "T-shirt", 120.0f, 0.5f, "Red", 8, "XL", "Cotton");
        products.add(cloth);
        ProductServiceImpl productService = new ProductServiceImpl(products);
        final Product PRODUCTNAME = productService.getProduct("T-shirt");

        Assert.assertEquals(cloth, PRODUCTNAME);
    }

    @Test
    public void testGetProductNameWhenNoExist(){
        List<Product> products = new ArrayList<>();
        ProductServiceImpl productService = new ProductServiceImpl(products);
        final Product PRODUCTNAME = productService.getProduct("Shirt");

        Assert.assertNull(PRODUCTNAME);
    }

    @Test
    public void testIsCountHigherThenZeroPositive(){
        List<Product> products = new ArrayList<>();
        products.add(new Boots(1L, "Boots", 35.0f, 0.3f, "Black", 4, 38, true));
        ProductServiceImpl productService = new ProductServiceImpl(products);
        final boolean RESULT = productService.isCountHigherThenZero("Boots");

        Assert.assertTrue(RESULT);
    }

    @Test
    public void testIsCountHigherThenZeroNegative(){
        List<Product> products = new ArrayList<>();
        products.add(new Boots(1L, "Boots", 35.0f, 0.3f, "Black", 0, 38, true));
        ProductServiceImpl productService = new ProductServiceImpl(products);
        final boolean RESULT = productService.isCountHigherThenZero("Boots");

        Assert.assertFalse(RESULT);
    }

    @Test
    public  void testIsExistByNamePositive(){
        List<Product> products = new ArrayList<>();
        products.add(new Boots(1L, "Boots", 35.0f, 0.3f, "Black", 0, 38, true));
        ProductServiceImpl productService = new ProductServiceImpl(products);
        final boolean RESULT = productService.isProductExist("Boots");

        Assert.assertTrue(RESULT);
    }

    @Test
    public  void testIsExistByNameNegative(){
        List<Product> products = new ArrayList<>();
        products.add(new Boots(1L, "Boots", 35.0f, 0.3f, "Black", 0, 38, true));
        ProductServiceImpl productService = new ProductServiceImpl(products);
        final boolean RESULT = productService.isProductExist("Shirt");

        Assert.assertFalse(RESULT);
    }

    @Test
    public  void testIsExistByIdPositive(){
        List<Product> products = new ArrayList<>();
        products.add(new Boots(1L, "Boots", 35.0f, 0.3f, "Black", 0, 38, true));
        ProductServiceImpl productService = new ProductServiceImpl(products);
        final boolean RESULT = productService.isProductExist(1L);

        Assert.assertTrue(RESULT);
    }

    @Test
    public  void testIsExistByIdNegative(){
        List<Product> products = new ArrayList<>();
        products.add(new Boots(1L, "Boots", 35.0f, 0.3f, "Black", 0, 38, true));
        ProductServiceImpl productService = new ProductServiceImpl(products);
        final boolean RESULT = productService.isProductExist(2L);

        Assert.assertFalse(RESULT);
    }
}
