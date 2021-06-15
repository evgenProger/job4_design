package gc;

import  com.carrotsearch.sizeof.RamUsageEstimator;

import static com.carrotsearch.sizeof.RamUsageEstimator.sizeOf;

public class User {
    private int age;
    private String name;

    public User(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    protected void finalize() {
        System.out.printf("Removed %d, %s%n", age, name);
    }

    public static void main(String[] args) {
        User userOne = new User(25, "Evgeny");
        User userTwo = new User(35, "Kate");
        System.out.println(RamUsageEstimator.sizeOf(userOne));
    }
}

