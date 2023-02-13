package mk.ukim.finki.wpvezbi.bootstrap;

import mk.ukim.finki.wpvezbi.model.*;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component //Singleton za da bidi,edna instanca se povikuva
public class DataHolder {

    public static List<Category> categories=new ArrayList<>();
    public static List<User>users=new ArrayList<>();
    public static List<Manufacturer> manufacturers=new ArrayList<>();
    public static List<Product> products=new ArrayList<>();
    public static List<ShoppingCart> shoppingCarts=new ArrayList<>();

    @PostConstruct
    public void init(){
        this.categories.add(new Category("Software","Software category"));
        this.categories.add(new Category("Books","Books category"));

        Manufacturer m=new Manufacturer("Nike","NY NY");
        manufacturers.add(m);
        Category category=new Category("Sport","Sport category");
        categories.add(category);

        this.products.add(new Product("Ball",235.8,7,category,m));

        this.users.add(new User("ana.drogrishka","ad","Ana","Drogrishka"));
        this.users.add(new User("jana.drogrishka","jd","Jana","Drogrishka"));

    }
}
