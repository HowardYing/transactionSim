import java.util.Scanner;

public class Transaction {

	public static void main(String[] args) {
		boolean cont = true;
		System.out.println("$ Welcome to Transaction Simulator! $");
		System.out.println("This program simulates bank transactions between checking and savings accounts. \n");
		Scanner in = new Scanner(System.in);
		System.out.print("SETUP: Please enter the initial balance for the CHECKING account: $");
		double checking = in.nextDouble();
		if (checking < 0) {
			wrongAmt();
		}
		System.out.print("SETUP: Please enter the initial balance for the SAVINGS account: $");
		double savings = in.nextDouble();
		if (savings < 0) {
			wrongAmt();
		}
		getBal(checking, savings);
		System.out.println("Setup Complete! \n");
		while (cont = true) {
			System.out.println(
					"\nMAIN MENU: What would you like to do? Options are: \n1). Deposit \n2). Withdraw \n3). Transfer \n4). Terminate Simulation");
			System.out.print("\nSelect a choice by entering the number: ");
			int choice1 = in.nextInt();
			if (choice1 == 1) {
				System.out.println("\nSelected DEPOSIT");
				System.out.println("Which account? Options are: \n1). Checking \n2). Savings");
				System.out.print("Select a choice by entering the number: ");
				int choice2 = in.nextInt();
				if (choice2 == 1) {
					System.out.print("\nSelected CHECKING \nEnter Amount to deposit: $");
					double depAmt = in.nextDouble();
					checking = depAmt + checking;
					getBal(checking, savings);
				} else if (choice2 == 2) {
					System.out.print("\nSelected SAVINGS \nEnter Amount to deposit: $");
					double depAmt = in.nextDouble();
					savings = depAmt + savings;
					getBal(checking, savings);
				} else {
					wrongChoice();
				}
			} else if (choice1 == 2) {
				System.out.println("\nSelected WITHDRAW");
				System.out.println("Which account? Options are: \n1). Checking \n2). Savings");
				System.out.print("Select a choice by entering the number: ");
				int choice3 = in.nextInt();
				if (choice3 == 1) {
					System.out.print("\nSelected CHECKING \nEnter Amount to withdraw: $");
					double withAmt = in.nextDouble();
					if (withAmt > checking) {
						System.out.println("That amount exceeds what is available in your checking account.");
					} else {
						checking = checking - withAmt;
						getBal(checking, savings);
					}
				} else if (choice3 == 2) {
					System.out.print("\nSelected SAVINGS \nEnter Amount to withdraw: $");
					double withAmt = in.nextDouble();
					if (withAmt > savings) {
						System.out.println("That amount exceeds what is available in your savings account.");
					} else {
						savings = savings - withAmt;
						getBal(checking, savings);
					}
				} else {
					wrongChoice();
				}
			} else if (choice1 == 3) {
				System.out.println("\nSelected TRANSFER");
				System.out
						.println("Which direction? Options are: \n1). Checking --> Savings \n2). Savings --> Checking");
				System.out.print("Select a choice by entering the number: ");
				int choice4 = in.nextInt();
				if (choice4 == 1) {
					System.out.print("\nSelected CHECKING --> SAVINGS \nEnter Amount to transfer: $");
					double transAmt = in.nextDouble();
					if (transAmt > checking) {
						System.out.println("That amount exceeds what is available in your checking account.");
					} else {
						checking = checking - transAmt;
						savings = savings + transAmt;
						getBal(checking, savings);
					}
				} else if (choice4 == 2) {
					System.out.print("\nSelected SAVINGS --> CHECKING \nEnter Amount to transfer: $");
					double transAmt = in.nextDouble();
					if (transAmt > savings) {
						System.out.println("That amount exceeds what is available in your savings account.");
					} else {
						savings = savings - transAmt;
						checking = checking + transAmt;
						getBal(checking, savings);
					}
				} else {
					wrongChoice();
				}
			} else if (choice1 == 4) {
				System.out.println("\nSelected TERMINATE SIMULATION");
				System.out.print("Are you sure you would like to exit? Y/N: ");
				String rep = in.next();
				if (rep.charAt(0) == 'Y' || rep.charAt(0) == 'y') {
					System.out.println("Thank you for using Transaction Simulator! Exiting...");
					System.exit(0);
				} else {
					System.out.println("Resuming...");
				}
			} else {
				wrongChoice();
			}
		}
	}

	public static void wrongChoice() {
		System.out.println("Sorry, that is not a valid choice");
	}

	public static void wrongAmt() {
		System.out.println("Sorry, negative initial values are not accepted.");
		System.exit(0);
	}

	public static void getBal(double checking, double savings) {
		System.out.printf("Your checking account balance is now: $%.2f", checking);
		System.out.printf("\nYour savings account balance is now: $%.2f\n", savings);
	}

}
