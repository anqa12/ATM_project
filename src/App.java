import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        ATMdefinitions op = new ATMfunctions();
        int atmNumber = 12345;
        int atmPin = 123;
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to ATM Machine");
        System.out.print("Enter ATM Number: ");
        int number = input.nextInt();
        input.nextLine(); // Clear the buffer after nextInt()
        System.out.print("Enter Pin: ");
        int pin = input.nextInt();
        input.nextLine(); // Clear the buffer after nextInt()

        if ((atmNumber == number) && (atmPin == pin)) {
            boolean isRunning = true;

            while (isRunning) {
                clearConsole(); // Clear the console at the start of each iteration
                System.out.println(
                        "1. View Available Balance\n2. Withdraw Amount\n3. Deposit Amount\n4. View History\n5. Exit");
                System.out.print("Enter Choice: ");
                try {
                    int choice = input.nextInt();
                    input.nextLine(); // Clear the buffer after nextInt()
                    switch (choice) {
                        case 1:
                            op.viewBalance();
                            break;
                        case 2:
                            System.out.print("Enter amount to withdraw: ");
                            double withdrawAmount = input.nextDouble();
                            input.nextLine(); // Clear the buffer after nextDouble()
                            op.withDrawAmount(withdrawAmount);
                            break;
                        case 3:
                            System.out.print("Enter Amount to deposit: ");
                            double depositAmount = input.nextDouble();
                            input.nextLine(); // Clear the buffer after nextDouble()
                            op.depositAmount(depositAmount);
                            break;
                        case 4:
                            op.viewHistory();
                            break;
                        case 5:
                            System.out.println("Collect your ATM card\nThank you for using my ATM Machine!");
                            isRunning = false;
                            break;
                        default:
                            System.out.println("Invalid input! Please enter the correct choice.");
                            break;
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input! Please enter the correct choice.");
                    input.nextLine(); // Clear the invalid input
                }

                if (isRunning) { // Prompt user only if the application hasn't exited
                    System.out.println("Press Enter to continue...");
                    input.nextLine(); // Wait for the user to press Enter
                }
            }
        } else {
            System.out.println("Incorrect Credentials");
            System.exit(0);
        }
        input.close();
    }

    // Method to clear the console
    public static void clearConsole() {
        // ANSI escape code to clear the screen
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
