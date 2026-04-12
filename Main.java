import java.util.*;

public class Main {
    public static void main(String[] args) {
        LinkedList<BankAccount> accounts = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        Stack<String> history = new Stack<>();
        Queue<String> billQueue = new LinkedList<>();
        Queue<BankAccount> accountRequests = new LinkedList<>();

        BankAccount[] fixedAccounts = new BankAccount[3];

        fixedAccounts[0] = new BankAccount(1, "Akarys", 15000);
        fixedAccounts[1] = new BankAccount(2, "Abyl", 20000);
        fixedAccounts[2] = new BankAccount(3, "Nurda", 30000);

        while (true) {
            System.out.println("\n1. Add account");
            System.out.println("2. Show all accounts");
            System.out.println("3. Search by username");
            System.out.println("4. Deposit");
            System.out.println("5. Withdraw");
            System.out.println("6. Pay bill");
            System.out.println("7. Show last transaction");
            System.out.println("8. Undo last transaction");
            System.out.println("9. Add bill request");
            System.out.println("10. Process next bill");
            System.out.println("11. Show bill queue");
            System.out.println("12. Submit account request");
            System.out.println("13. Process account request (Admin)");
            System.out.println("14. Show pending requests");
            System.out.println("15. Exit");
            System.out.println("0. Show fixed accounts (Array)");

            System.out.println("\nEnter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 0) {
                System.out.println("Fixed Accounts (Array):");

                for (int i = 0; i < fixedAccounts.length; i++) {
                    fixedAccounts[i].display();
                }
            } else if (choice == 1) {
                int accountNumber = accounts.size() + 1;

                System.out.println("Enter username: ");
                String username = sc.nextLine();

                System.out.println("Enter balance: ");
                double balance = sc.nextDouble();

                accounts.add(new BankAccount(accountNumber, username, balance));
                System.out.println("Account added successfully");

            } else if (choice == 2) {
                System.out.println("\nAll accounts: ");
                for (BankAccount acc : accounts) {
                    acc.display();
                }
            } else if (choice == 3) {
                System.out.println("Enter username: ");
                String search = sc.nextLine();

                boolean found = false;
                for (BankAccount acc : accounts) {
                    if (acc.username.equalsIgnoreCase(search)) {
                        acc.display();
                        found = true;
                    }
                }
                if (!found) {
                    System.out.println("Account not found");
                }
            } else if (choice == 4) {
                System.out.println("Enter username: ");
                String name = sc.nextLine();

                boolean found = false;
                for (BankAccount acc : accounts) {
                    if (acc.username.equalsIgnoreCase(name)) {
                        System.out.println("Enter amount: ");
                        double money = sc.nextDouble();
                        sc.nextLine();

                        acc.balance += money;
                        history.push("Deposit " + money + " to " + name);
                        System.out.println("New balance: " + acc.balance);

                        found = true;
                    }
                }
                if (!found) {
                    System.out.println("Account not found");
                }
            } else if (choice == 5) {
                System.out.println("Enter username: ");
                String name = sc.nextLine();

                boolean found = false;
                for (BankAccount acc : accounts) {
                    if (acc.username.equalsIgnoreCase(name)) {
                        System.out.println("Enter amount: ");
                        double money = sc.nextDouble();
                        sc.nextLine();

                        if (acc.balance >= money) {
                            acc.balance -= money;
                            history.push("Withdraw " + money + " from " + name);
                            System.out.println("New balance: " + acc.balance);
                        } else {
                            System.out.println("Not enough money");
                        }
                        found = true;
                    }
                }
                if (!found) {
                    System.out.println("Account not found");
                }
            } else if (choice == 6) {
                System.out.println("Enter bill type: ");
                String bill = sc.nextLine();

                System.out.println("Enter amount: ");
                double money = sc.nextDouble();
                sc.nextLine();

                System.out.println("Bill paid: " + bill);
                history.push("Bill payment " + money + " (" + bill + ")");

            } else if (choice == 7) {
                if (!history.isEmpty()) {
                    System.out.println("Last transaction: " + history.peek());
                } else {
                    System.out.println("No transactions");
                }
            } else if (choice == 8) {
                if (!history.isEmpty()) {
                    System.out.println("Undo: " + history.pop());
                } else {
                    System.out.println("Nothing to undo");
                }
            } else if (choice == 9) {
                System.out.println("Enter bill type: ");
                String bill = sc.nextLine();

                billQueue.add(bill);
                System.out.println("Added: " + bill);
            } else if (choice == 10) {
                if (!billQueue.isEmpty()) {
                    String bill = billQueue.poll();
                    System.out.println("Processing: " + bill);
                } else {
                    System.out.println("No bills in queue");
                }
            } else if (choice == 11) {
                System.out.println("Bill Queue: ");
                for (String b : billQueue) {
                    System.out.println(b);
                }
            } else if (choice == 12) {
                System.out.println("Enter username: ");
                String username = sc.nextLine();

                System.out.println("Enter initial balance: ");
                double balance = sc.nextDouble();
                sc.nextLine();

                int accountNumber = accounts.size() + accountRequests.size() + 1;
                BankAccount newAcc = new BankAccount(accountNumber, username, balance);
                accountRequests.add(newAcc);
                System.out.println("Request submitted for: " + username);

            } else if (choice == 13) {
                if (!accountRequests.isEmpty()) {
                    BankAccount acc = accountRequests.poll();
                    accounts.add(acc);

                    System.out.println("Account approved: " + acc.username);
                } else {
                    System.out.println("No pending requests");
                }
            } else if (choice == 14) {
                System.out.println("Pending requests:");

                for (BankAccount acc : accountRequests) {
                    System.out.println(acc.accountNumber + ". " + acc.username + " - " + acc.balance);
                }
            } else if (choice == 15) {
                break;
            } else {
                System.out.println("Invalid choice");
            }
        }
    }
}
