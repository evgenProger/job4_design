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
    /*
    Объект состоит из:
    1. Заголовок - для 64 разрядной системы 16 байт
    2. Память для примитивных типов. Предопределена и прописана в доках https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html
    3. Ссылки на объект

    Подсчитаем размер для String:
    Класс String:
        private final char value[];
        private final int offset;
        private final int count;
        private int hash;

        Подсчитаем размер для 64 разрядной ОС для строки new String("a"):
            new String()
            Заголовок: 16 байт
            Поля int: 4 байта * 3 == 12 байт
            Ссылочная переменная на объект массива: 4 байта
        Итого: 32 байта
            Размер выделенного для символов массива:
            new char[1]
            Заголовок: 8 байт + 4 байта на длину массива == 12 байт
            Примитивы char: 2 байта * 1 == 2 байта
            Выравнивание для кратности 8 : 2 байта
            Итого: 16 байта

Итого, new String("a") == 48 байт
*/
}

