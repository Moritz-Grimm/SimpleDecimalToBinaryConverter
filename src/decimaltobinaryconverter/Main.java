package decimaltobinaryconverter;

import java.util.Scanner;

/**
 *
 * @author m.grimm
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            int input = getDecimalNumberInput(scanner);
            int[] binaryResult = new int[32];

            for (int i = 31; i >= 0; i--) {
                if (input % 2 == 1) {
                    binaryResult[i] = 1;
                }
                input = input / 2;
            }
            printArray(binaryResult);

            switch (getContinueInputConfirmation(scanner)) {
                case 1:
                    System.out.println();
                    break;
                case 2:
                    running = false;
                    System.out.println("\nExiting program...\n");
                    break;
            }
        }
        scanner.close();
    }

    public static int getDecimalNumberInput(Scanner scanner) {
        int inputInt = 0;

        while (true) {
            System.out.print("Please input a decimal number: ");
            String inputString = scanner.nextLine();

            try {
                inputInt = Integer.parseInt(inputString);
                if (inputInt <= 0) {
                    System.out.println("\nInvalid input. Please try again\n");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("\nInvalid input. Please try again\n");
            }

        }
        return inputInt;
    }

    public static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i);
        }
    }

    public static int getContinueInputConfirmation(Scanner scanner) {
        System.out.println();
        while (true) {
            int continueInputParsedAsInt = 2;

            System.out.print("\n 1.Yes\n 2.No\nDo you want to input another number: ");
            String continueInputString = scanner.nextLine();

            try {
                continueInputParsedAsInt = Integer.parseInt(continueInputString);
                if (continueInputParsedAsInt < 0 || continueInputParsedAsInt > 2) {
                    System.out.println("\nInvalid Input. Please try again");
                } else {
                    return continueInputParsedAsInt;
                }
            } catch (NumberFormatException e) {
                System.out.println("\nInvalid Input. Please try again");
            }
        }
    }
}
