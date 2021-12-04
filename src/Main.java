import java.util.Scanner;

public class Main {
    public static AccountRepo accountRepo = new AccountRepo();
    public static void main(String[] args) {
        while (true) {
            showMenu();
        }

    }

    public static void showMenu() {
        Scanner sc = new Scanner(System.in);
        String username;
        String password;
        String email;
        System.out.println("1 - Đăng nhập");
        System.out.println("2 - Đăng ký");
        System.out.println("3 - Print all accounts");
        System.out.print("Choice: ");
        int choice = sc.nextInt();
        sc.nextLine();
        switch (choice) {
            case 1:
                System.out.print("Username: ");
                username = sc.nextLine();
                System.out.print("Password: ");
                password = sc.nextLine();
                System.out.println();

                accountRepo.logIn(username, password);
                break;
            case 2:
                System.out.print("Username: ");
                username = sc.nextLine();
                System.out.print("Email: ");
                email = sc.nextLine();
                System.out.print("Password: ");
                password = sc.nextLine();

                accountRepo.addAccount(username, email, password);
                break;
            case 3:
                accountRepo.printList();
                break;
        }
    }
}
