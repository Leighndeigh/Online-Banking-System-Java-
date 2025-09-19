import java.util.LinkedList;
import java.util.Scanner;

public class BankSystem {
    private LinkedList<User> users = new LinkedList<>();  //The linked list is initiated 
    private User loggedInUser = null;                     //The User object iss set to null
    private Scanner sc = new Scanner(System.in);          //The scanner is initiated

    public void register(String username, String password){ //This method is for registering the user into the system
        for(User user: users){
            if(user.username.equals(username)){
                System.out.println("Username already exists");
                return;
            }
        }
        users.add(new User(username,password, 0.0));
        System.out.println("Registration successful");
    }

    public boolean login(String username, String password){
        for(User user : users){
            if(user.username.equals(username) && user.password.equals(password)){
                loggedInUser = user;
                System.out.println("Login successful! Welcome, " + username);
                return true;
            }
        }
        System.out.println("Invalid login credentials");
        return false;
    }

    public void logout(){
        loggedInUser = null;
        System.out.println("Please login first");
        return;
    }

    public void performOperations(){
        if(loggedInUser == null){
            System.out.println("Please login first");
            return;
        }

        while(true){
            System.out.println("\n1.Deposit\n2.Withdraw\n3.Transfer\n4.Logout\nChoose an option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch(choice){
                case 1:
                    System.out.println("Enter deposit amount:");
                    double depositAmount = sc.nextDouble();
                    
                    loggedInUser.deposit(depositAmount);
                    break;

                case 2:
                    System.out.println("Enter withdrawal amount:");
                    double WithdrawAmount = sc.nextDouble();

                    loggedInUser.withdraw(WithdrawAmount);
                    break;

                case 3: 
                    System.out.println("Enter recipient username:");
                    sc.nextLine();

                    String recepientUsername = sc.nextLine();
                    System.out.println("Enter transfer amount");
                    double transferAmount = sc.nextDouble();

                    User recipient = findUser(recepientUsername);
                    if(recipient != null){
                        loggedInUser.transfer(recipient, transferAmount);
                    }
                    else{
                        System.out.println("Recipient not found");
                    }
                    break;

                case 4: 
                    logout();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private User findUser(String username){
        for(User user: users){
            if(user.username.equals(username)){
                return user;
            }
        }
        return null;
    }

}