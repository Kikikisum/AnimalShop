import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyAnimalShop implements AnimalShop {
    private boolean isBusiness; //是否正在营业
    private double balance; //店的余额
    private List<Animal> list;
    private List<Customer> customers;
    private Map<LocalDate, Double> yye = new HashMap<>();  //营业额

    public boolean isBusiness() {
        return isBusiness;
    }

    public void setBusiness(boolean business) {
        isBusiness = business;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<Animal> getList() {
        return list;
    }

    public void setList(List<Animal> list) {
        this.list = list;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    @Override
    public void buyNewAnimal(Animal animal) {
        if (animal.getPrice() > this.balance) {
            throw new InsufficientBalanceException("店内余额不足");
        }
        list.add(animal);
        this.balance = this.balance - animal.getPrice();
        if (yye.containsKey(LocalDate.now())) {
            yye.put(LocalDate.now(), yye.get(LocalDate.now()) - animal.getPrice());
        }else {
            yye.put(LocalDate.now(), 0.0);
        }
    }

    @Override
    public void serveCustomer(Customer customer , String animalName) {
        Animal animaltemp = null;
        customer.setFrequency(customer.getFrequency() + 1);
        boolean flag = false;
        for (Animal animal : list) {
            if (animal.getName().equals(animalName)) {
                animaltemp = animal;
                flag = true;
            }
        }
        if (!flag) {
            throw new AnimalNotFountException("店内没有该动物");
        }
        customers.add(customer);
        customer.setNewLocalDate(LocalDate.now());
        list.remove(animaltemp);
        this.balance = this.balance + animaltemp.getPrice();
        System.out.println(animaltemp.toString());
        if (yye.containsKey(LocalDate.now())) {
            yye.put(LocalDate.now(), yye.get(LocalDate.now()) + animaltemp.getPrice());
        }else {
            yye.put(LocalDate.now(), 0.0);
        }
    }

    @Override
    public void closeBusiness(LocalDate localDate) {
        System.out.println("客户当天的信息：");
        for (Customer customer : customers) {
            if (customer.getNewLocalDate().isEqual(localDate)) {
                System.out.print(customer.getName() + "  ");
            }
        }
        System.out.println();
        System.out.println("当天的营业额为： " + this.yye.get(LocalDate.now()) + "元");
    }
}
