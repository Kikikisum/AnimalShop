public class Cat extends Animal {

    public Cat(String name, int age, char sex, double price) {
        super(name, age, sex, price);
    }

    @Override
    public String toString() {
        return getName() + getAge() + "岁" + getSex() + getPrice();
    }

}
