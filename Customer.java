import java.time.LocalDate;

public class Customer {
    private String name;  //名字
    private int frequency; //到店次数
    private LocalDate newLocalDate;  //最新到店时间

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public LocalDate getNewLocalDate() {
        return newLocalDate;
    }

    public void setNewLocalDate(LocalDate newLocalDate) {
        this.newLocalDate = newLocalDate;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "姓名='" + name + '\'' +
                ", 到店次数=" + frequency +
                ", 最新到店时间=" + newLocalDate +
                '}';
    }
}
