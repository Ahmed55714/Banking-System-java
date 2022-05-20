import java.util.Scanner;

public class BankingApplication {

	public static void main(String[] args) {

		BankAccount obj = new BankAccount("SL DevCode", "SL00001");
		obj.showMenu();

	}

}

class BankAccount {
	int balance;
	int previousTransaction;
	String customerName;
	String customerId;

	BankAccount(String cname, String cid) {
		customerName = cname;
		customerId = cid;
	}

	void deposit(int amount) {
		if (amount != 0) {
			balance = balance + amount;
			previousTransaction = amount;
		}
	}

	void withdraw(int amount) {
		if (amount != 0) {
			balance = balance - amount;
			previousTransaction = -amount;
		}
	}

	void getPreviousTransaction() {
		if (previousTransaction > 0) {
			System.out.println("Deposited: " + previousTransaction);
		} else if (previousTransaction < 0) {
			System.out.println("Withdraw: " + Math.abs(previousTransaction));
		}

		else {
			System.out.println("No Transaction Occured");
		}
	}

	void showMenu() {

		char option = '\0';
		Scanner scanner = new Scanner(System.in);

		System.out.println("Welcome " + customerName);
		System.out.println("Your ID is " + customerId);
		System.out.println("\n");

		System.out.println("1 : Check Your Balance");
		System.out.println("2 : Deposit");
		System.out.println("3 : Withdraw");
		System.out.println("4 : Previous Transaction");
		System.out.println("5 : Exit The System");

		do {
			System.out.println(
					"=========================================================================================================");
			System.out.println("Enter Your Option");
			System.out.println(
					"=========================================================================================================");
			option = scanner.next().charAt(0);
			System.out.println("\n");

			switch (option) {

				case '1':
					System.out.println("-------------------------------------------------------");
					System.out.println("Balance = " + balance);
					System.out.println("-------------------------------------------------------");
					System.out.println("\n");
					break;

				case '2':
					System.out.println("-------------------------------------------------------");
					System.out.println("Enter an amount to deposit ");
					System.out.println("-------------------------------------------------------");

					int amount = scanner.nextInt();
					deposit(amount);
					System.out.println("\n");
					break;

				case '3':
					System.out.println("-------------------------------------------------------");
					System.out.println("Enter an amount to withdraw ");
					System.out.println("-------------------------------------------------------");

					int amount2 = scanner.nextInt();
					withdraw(amount2);
					System.out.println("\n");
					break;

				case '4':
					System.out.println("-------------------------------------------------------");
					getPreviousTransaction();
					System.out.println("-------------------------------------------------------");
					System.out.println("\n");
					break;

				case '5':
					System.out.println(
							"=========================================================================================================");
					break;

				default:
					System.out.println("Invalid Option!! Please Enter Correct Opton...");
					break;
			}
		} while (option != 'E');
		System.out.println("Thank You for Using our Services.....!!");
	}
}
