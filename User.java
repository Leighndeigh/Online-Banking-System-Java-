public class User {

    String username;
    String password;
    double balance;

    public User(String username, String password, double balance) {   //This is the constructor method for the User object
        this.username = username;
        this.password = password;
        this.balance = balance;
    }

    public void deposit(double amount) { //This is the method that is for depositing into the bank account
        if (amount > 0) {
            balance += amount;
            System.out.println("The deposit was successful!");
        } else {
            System.out.println("You have an insufficient balance to transact.");
        }
    }

    public boolean withdraw(double amount) {  //This is the method for withdrawing from the bank account
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println("The withdrawal was successful, the current balance is R " + balance);
            return true;
        } else {
            System.out.println("You have an insufficient balance to transact.");
            return false;
        }
    }

    public boolean transfer(User receiver, double amount) { //This is the method for transferring to another saved beneficiary
        if (this.withdraw(amount)) {
            receiver.deposit(amount); //It calls the deposit method for the receiver
            System.out.println("The transaction was successful to " + receiver.username);
            return true;
        } else {
            System.out.println("You have an insufficient balance to transfer.");
            return false;
        }
    }

}