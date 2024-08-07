package gc;

public class User {
    private int age;
    private boolean married;

    public User(int age, boolean married) {
        this.age = age;
        this.married = married;
    }

    @Override
    protected void finalize() {
        System.out.printf("Removed %d, %s%n", age, married);
    }

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 1000; i++) {
            User userOne = new User(i, true);
        }
        System.gc();
        Thread.sleep(1000);
    }
}

