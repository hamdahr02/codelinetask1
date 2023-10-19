import java.util.Scanner;
import java.util.stream.Stream;

class MyTest {

    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";

    public static void OptionsList() {

        System.out.println("Please " + BLUE + "select " + RESET + "an" + BLUE + " option:\n" + RESET);

        System.out.println(PURPLE + "1" + RESET + ". Print Pattern");
        System.out.println(PURPLE + "2" + RESET + ". Rotate Array");
        System.out.println(PURPLE + "3" + RESET + ". Help");
        System.out.println(PURPLE + "4" + RESET + "." + BLUE + " Exit\n" + RESET);
    }

    public static void main(String[] args) {

        int option;

        try (Scanner input = new Scanner(System.in)) {

            System.out.println(RESET + "\nWelcome " + BLUE + "to " + RESET + "the Menu-Based Program!\n");

            boolean cont = true;

            while (cont) {
                OptionsList();
                System.out.print(RED + "Option: " + RESET + PURPLE);
                option = Integer.parseInt(input.nextLine());

                if (option == 1) {

                    System.out.print(RESET + "Enter the number " + BLUE + "of " + RESET + "rows" + BLUE + " for " + RESET+ "the pattern: " + PURPLE);
                    int rows = Integer.parseInt(input.nextLine());
                    System.out.println(RESET + RED + "\nOutput: " + RESET);
                    if (rows > 0) {

                        for (int i = 0; i <= rows; i++) {
                            for (int n = rows; n > i; n--) {
                                System.out.print("*");
                            }
                            System.out.println();
                        }
                    } else {
                        System.out.print(RESET + "Please enter a positive number: ");
                        rows = Integer.parseInt(input.nextLine());
                        for (int i = 0; i <= rows; i++) {
                            for (int n = rows; n > i; n--) {
                                System.out.print("*");
                            }
                            System.out.println();
                        }
                    }

                } else if (option == 2) {

                    System.out.print(RESET + "Enter the number " + BLUE + "of " + RESET + "elements (n): " + PURPLE);
                    int n = Integer.parseInt(input.nextLine());

                    System.out.print(RESET + "Enter the number " + BLUE + "of " + RESET + "steps (k): " + PURPLE);
                    int k = Integer.parseInt(input.nextLine());

                    System.out.print(RESET + "Enter the array elements separated " + BLUE + "by " + RESET + "spaces: " + PURPLE);

                    int[] myArrayElements = Stream.of(input.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

                    

                    int[] rotatedArray = new int[n];

                    k = k % n;
                    for (int m = 0; m < n; m++) {
                        rotatedArray[(m + k) % n] = myArrayElements[m];
                    }

                    System.out.println(RED + "\nOutput: " + RESET);
                    System.arraycopy(rotatedArray, 0, myArrayElements, 0, n);

                    for (int i = 0; i < n; i++) {
                        System.out.print(RED + " " + myArrayElements[i] + RESET);
                    }
                    System.out.println();

                } else if (option == 3) {

                    System.out.println(RESET + "--- Help ---");
                    System.out.println(RESET +PURPLE + "1:" + RESET + " Print Pattern"+ BLUE + " with" + RESET+ " 'n' rows of decreasing asterisks.");
                    System.out.println(RESET +PURPLE + "2:" + RESET + " Rotate an array"+ BLUE + " of" + RESET+ " 'n' elements to the right by 'k' steps.");
                    System.out.println(RESET +PURPLE + "3:" + RESET + " Display this help message.");
                    System.out.println(RESET +PURPLE + "4:" + RESET + BLUE + " Exit" + RESET+ " the program.\n");
                }

                else if (option == 4) {
                    System.out.println(RESET + "Exiting the program. Goodbye!");
                    cont = false;
                }

            }

        }
    }

}