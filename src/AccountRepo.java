import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class AccountRepo {
    public List<Account> accountList = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    int temp = 0;

    public void addAccount(String usernameVariable, String emailVariable, String passwordVariable) {
        Pattern emailRegex = Pattern.compile("^(.+)@(.+)$", Pattern.CASE_INSENSITIVE);
        Pattern passwordRegex = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[.,-_;])(?=\\\\S+$).{7,15}$", Pattern.CASE_INSENSITIVE);

        Matcher emailMatcher = emailRegex.matcher(emailVariable);
        Matcher passwordMatcher = passwordRegex.matcher(passwordVariable);
        if (accountList.size() > 0) {
            accountList.stream().forEach(account -> {
                if (account.getUsername().equals(usernameVariable) && account.getPassword().equals(passwordVariable) && account.getEmail().equals(emailVariable)) {
                    System.out.println("Account da ton tai");
                } else {
                    if (!emailMatcher.find()) {
                        System.out.println("Sai format email");
                    }
//        else if (!passwordMatcher.find()) {
//            System.out.println("password dài từ 7 đến 15 ký tự, chứa ít nhất 1 ký tự in hoa, 1 ký tự đặc biệt (. , - _ ;)");
//        }
                    else {
                        accountList.add(new Account(usernameVariable, emailVariable, passwordVariable));
                        System.out.println("Da them");
                    }
                }
            });
        } else {
            accountList.add(new Account(usernameVariable, emailVariable, passwordVariable));
            System.out.println("Da them");
        }
    }

    public void printList() {
        accountList.stream().forEach(System.out::println);
    }

    public void logIn(String usernameVariable, String passwordVariable) {
        List<Account> compare = accountList
                .stream()
                .filter(account -> account.getUsername().equals(usernameVariable))
                .collect(Collectors.toList());

//        if (compare.size() != 0) {
//            compare.get(0);
        accountList.stream().forEach(account -> {
            if (account.getUsername().equals(usernameVariable) && account.getPassword().equals(passwordVariable)) {
                System.out.println("Chào mừng " + usernameVariable);
                while (temp == 0) {
                    logInMenu(account);
                }
            } else {
                System.out.println("Sai username hoac pass");
            }
        });
//        }
    }

    public void logInMenu(Account accountVariable) {

        System.out.println("1 - Thay đổi username");
        System.out.println("2 - Thay đổi email");
        System.out.println("3 - Thay đổi mật khẩu");
        System.out.println("4 - Đăng xuất");
        System.out.print("Choice: ");
        int choice = sc.nextInt();
        sc.nextLine();
        switch (choice) {
            case 1:
                System.out.print("Username: ");
                String tempUser = sc.nextLine();
                accountVariable.setUsername(tempUser);
                System.out.println(accountVariable.getUsername() + " - " + tempUser);
                System.out.println("Da thay doi username");

                break;
            case 2:
                System.out.print("New Email: ");
                String tempEmail = sc.nextLine();
                accountVariable.setEmail(tempEmail);
                System.out.println("Da thay doi email");
                break;
            case 3:
                System.out.print("Password hien tai: ");
                String tempPassword = sc.nextLine();
                if (accountVariable.getPassword().equals(tempPassword)) {
                    String tempNewPassword = sc.nextLine();
                    accountVariable.setPassword(tempNewPassword);
                    System.out.println("Da doi mat khau");
                } else {
                    System.out.println("Nhap sai");
                }
                break;
            case 4:
                temp = 1;
                break;
        }
    }

}
