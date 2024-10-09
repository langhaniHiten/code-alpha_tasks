import java.util.Scanner;
 class OnlineQuizPlatform {
    private double balance;
    public OnlineQuizPlatform() {
        this.balance = 0;
    }
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited"+amount);
        }
    }
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdraw" +amount);
        } else if (amount > balance) {
            System.out.println("Insufficient funds");
        }
    }
    public void checkBalance() {
        System.out.println("Current Balance" +balance);
    }
    public static void main(String[] args) {
        OnlineQuizPlatform onlineQuizPlatform1 = new OnlineQuizPlatform();
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Online Quiz Platform ");
            System.out.println("1.Deposit");
            System.out.println("2.Withdraw");
            System.out.println("3.Check Balance");
            System.out.println("4.Exit");
            System.out.print("Choose an option (1-4)");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    onlineQuizPlatform1.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    onlineQuizPlatform1.withdraw(withdrawAmount);
                    break;
                case 3:
                    onlineQuizPlatform1.checkBalance();
                    break;
                case 4:
                    System.out.println("Exiting the program");
                    break;
                default:
                    System.out.println("Invalid choice,Please select a valid option.");
            }
        } while (choice != 4);

        scanner.close();
    }
}
