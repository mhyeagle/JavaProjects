package mybatisTest.po;

public class User {
    private int id;
    private String name;
    private String password;
    private double money;

    public User() {
    }

    public User(String name, String password, double money) {
        this.name = name;
        this.password = password;
        this.money = money;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        String result = "" +
                id + "\t" +
                name + "\t" +
                password + "\t" +
                money + "\n";

        return result;
    }
}
