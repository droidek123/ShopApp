import entity.Boots;
import entity.Cloth;
import entity.Product;
import entity.User;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        User user = new User(1L, "admin", "admin");
        Cloth cloth = new Cloth(1L, "T-shirt", 35.9f, 0.3f, "Black", 10,"XL", "Cotton");
        Boots boots = new Boots(1L, "High heels", 99.9f, .5f, "Red", 12, 35, true);

        System.out.println(user.toString());
        System.out.println(cloth.toString());
        System.out.println(boots.toString());

        List<Product> products = new ArrayList<>();
        products.add(cloth);
        products.add(boots);

        products.forEach(p->System.out.println(products.toString()));
    }
}
