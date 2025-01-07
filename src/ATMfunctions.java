import java.util.ArrayList;
import java.util.List;

public class ATMfunctions implements ATMdefinitions {
    ATM atm = new ATM();
    List<String> ministmt = new ArrayList<>(); // List to store transaction history

    @Override
    public void viewBalance() {
        System.out.println("Available balance is: " + atm.getBalance());
    }

    @Override
    public void withDrawAmount(double withdrawAmount) {
        if (withdrawAmount <= atm.getBalance()) {
            ministmt.add("Withdrawn: " + withdrawAmount);
            System.out.println("Collect the cash " + withdrawAmount);
            atm.setBalance(atm.getBalance() - withdrawAmount);
            viewBalance();
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    @Override
    public void depositAmount(double depositAmount) {
        ministmt.add("Deposited: " + depositAmount);
        System.out.println(depositAmount + " Deposited Successfully!");
        atm.setBalance(atm.getBalance() + depositAmount);
        viewBalance();
    }

    @Override
    public void viewHistory() {
        System.out.println("Transaction History:");
        if (ministmt.isEmpty()) {
            System.out.println("No transactions found.");
        } else {
            for (String transaction : ministmt) {
                System.out.println(transaction);
            }
        }
    }
}
