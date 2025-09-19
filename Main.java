import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankSystem bankSystem = new BankSystem();

        while(true){
            System.out.println("\n1. Register\n2. Login\n3. Exit\nChoose an option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch(choice) {
                case 1: 
                    System.out.println("Enter username");
                    sc.nextLine();
                    String username = sc.nextLine();
                    System.out.println("Enter the password:");
                    String password = sc.nextLine();

                    bankSystem.register(username, password);
                    break;
                
                case 2: 
                    System.out.println("Enter username:");
                    sc.nextLine();
                    String loginUser = sc.nextLine();
                    System.out.println("Enter the password");
                    String loginPass = sc.nextLine();

                    if(bankSystem.login(loginUser, loginPass)){
                        bankSystem.performOperations();
                    }
                    break;

                case 3: 
                    System.out.println("Exiting... Goodbye!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
