import java.time.LocalDate;
import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        MyAnimalShop myAnimalShop = new MyAnimalShop();
        myAnimalShop.setBalance(999);
        ChineseDog chineseDog = new ChineseDog("汪汪",5,'公',100);
        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(chineseDog);
        myAnimalShop.setList(animals);
        myAnimalShop.setBusiness(true);
        myAnimalShop.setCustomers(new ArrayList<Customer>());
        //买入动物
        Cat cat = new Cat("咪咪", 2, '母', 20);
        Cat cat1= new Cat("咪西", 2, '母', 20);
        myAnimalShop.buyNewAnimal(cat);
        myAnimalShop.buyNewAnimal(cat1);
        //招揽客户
        Customer customer1 = new Customer();
        customer1.setFrequency(0);
        customer1.setName("唠叨");
        Customer customer2 = new Customer();
        customer2.setFrequency(0);
        customer2.setName("叨唠");
        myAnimalShop.serveCustomer(customer1, "咪咪");
        myAnimalShop.serveCustomer(customer2, "咪西");
        myAnimalShop.closeBusiness(LocalDate.now());
    }
}
