package cashe;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Emulator {
    public static int menu() {
        int selection;
        Scanner input = new Scanner(System.in);
        System.out.println("1 - load content into cash");
        System.out.println("2 - take content from cash");
        System.out.println("3 - Exit");
        selection = input.nextInt();
        return selection;
    }

    public static void main(String[] args) throws IOException {
        int userChoice = 0;
        System.out.println("Enter cashing directory");
        Scanner input = new Scanner(System.in);
        String path = input.nextLine();
        DirFileCash dirFileCash = new DirFileCash(path);
        System.out.println("Enter file name");
        String fileName = input.nextLine();
        while (userChoice != 3) {
            System.out.println("Select menu item");
            userChoice = menu();
            if (userChoice == 1) {
                dirFileCash.load(fileName);
            }
            if (userChoice == 2) {
                System.out.println(dirFileCash.get(fileName));
            }
        }
    }
}
