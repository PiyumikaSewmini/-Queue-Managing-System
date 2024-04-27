import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main{
    //to access variable from everywhere making them global variable using 'public static'.
    public static char[] cashier_1 = new char[2];
    public static char[] cashier_2 = new char[3];
    public static char[] cashier_3 = new char[5];
    public static String[] names = new String[10];
    public static int Burgers = 50;

    public static void main(String[] args) throws IOException {
        cashier_1[0] = 'x';
        cashier_1[1] = 'x';
        cashier_2[0] = 'x';
        cashier_2[1] = 'x';
        cashier_2[2] = 'x';
        cashier_3[0] = 'x';
        cashier_3[1] = 'x';
        cashier_3[2] = 'x';
        cashier_3[3] = 'x';
        cashier_3[4] = 'x';
//to loop forever until the condition evaluate.
        while (true) {

            System.out.println(" <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<                Hello!...Welcome to Foodies Fave Queue Management System.             >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> ");
            System.out.println("--------------*****  MENU OPTIONS  *****----------------------");
            System.out.println("100 or VFQ: View all Queues");
            System.out.println("101 or VEQ: View all Empty Queues.");
            System.out.println("102 or ACQ:Add customer to a Queue");
            System.out.println("103 or RCQ:Remove a customer from a Queue. (From a specific location)");
            System.out.println("104 or PCQ: Remove a served customer.");
            System.out.println("105 or VCS: View Customers Sorted in alphabetical order (Do not use library sort routine");
            System.out.println("106 or SPD: Store Program Data into file");
            System.out.println("107 or LPD: Load Program Data from file");
            System.out.println("108 or STK: View Remaining burgers Stock");
            System.out.println("109 or AFS: Add burgers to Stock.");
            System.out.println("999 or EXT: Exit the Program.\n");

            System.out.print("Select your choice: ");
            Scanner input1 = new Scanner(System.in);
            String choice = input1.nextLine();
          //Viewing all Queues methods

            if (choice.equals("100") || choice.equals("VFQ")) {
                code();
                //a method calling in main method.
            }
            //Method to View All Empty Queues

            else if (choice.equals("101") || choice.equals("VEQ")) {

                code();
            }

          // Method to add a customer to queue

            else if (choice.equals("102") || choice.equals("ACQ")) {
                System.out.print("Enter your name: ");
                Scanner input_2 = new Scanner(System.in);
                String customer_name = input_2.nextLine();

                // saving a customer name into an array
                for (int i = 0; i < names.length; i++) {
                    if (names[i] == null) {
                        names[i] = customer_name.toLowerCase();
                        break;
                    }
                }
                System.out.print(customer_name + " " + "Choose the queue you want to go(cashier_1's queue=1,cashier_2's queue=2 or cashier_3's queue=3): ");
                Scanner input_3 = new Scanner(System.in);
                int chosen_queue = input_3.nextInt();

                if (chosen_queue == 1) {
                    int i = 0;
                    while (i < cashier_1.length) {
                        if (cashier_1[i] == 'x') {
                            cashier_1[i] = 'o';
                            break;
                        }
                        i++;
                    }
                } else if (chosen_queue == 2) {
                    int j = 0;
                    while (j < cashier_2.length) {
                        if (cashier_2[j] == 'x') {
                            cashier_2[j] = 'o';
                            break;
                        }
                        j++;
                    }
                } else if (chosen_queue == 3) {
                    int k = 0;
                    while (k < cashier_3.length) {
                        if (cashier_3[k] == 'x') {
                            cashier_3[k] = 'o';
                        }
                        break;
                    }
                    k++;
                } else {
                    System.out.println("You entered wrong queue.There is no queue like this.");
                }
                code();
            }

            //Method to  remove Customer to queue

            else if (choice.equals("103") || choice.equals("RCQ")) {

                Scanner input_5 = new Scanner(System.in);
                System.out.println("Enter the queue you want to remove the customer(cashier_1's queue=1,cashier_2;s queue=2 or cashier_3's queue=3): ");
                int removed_queue = input_5.nextInt();

                System.out.println("Enter the customers location: ");
                int customer_location = input_5.nextInt();
                if (removed_queue == 1) {
                    cashier_1[customer_location] = 'x';
                    System.out.println("Now customer removed from cashier" + removed_queue);
                    code();
                } else if (removed_queue == 2) {
                    cashier_2[customer_location] = 'x';
                    System.out.println("Now customer removed from cashier" + removed_queue);
                    code();
                } else if (removed_queue == 3) {
                    cashier_3[customer_location] = 'x';
                    System.out.println("Now customer removed from cashier" + removed_queue);
                    code();
                } else {
                    System.out.println("You entered wrong location.We can't find your location.Reenter it.");
                }
            //Method to remove served customer

            } else if (choice.equals("104") || choice.equals("PCQ")) {
           // add a customer to queue
                System.out.print("Choose the queue you want to go(cashier_1's queue=1,cashier_2;s queue=2 or cashier_3's queue=3): ");
                Scanner input_9 = new Scanner(System.in);
                int chosen_queue = input_9.nextInt();

                if (chosen_queue == 1) {
                    int i = 0;
                    while (i < cashier_1.length) {
                        if (cashier_1[i] == 'x') {
                            cashier_1[i] = 'o';
                            break;
                        }
                        i++;
                    }
                } else if (chosen_queue == 2) {
                    int j = 0;
                    while (j < cashier_2.length) {
                        if (cashier_2[j] == 'x') {
                            cashier_2[j] = 'o';
                            break;
                        }
                        j++;
                    }
                } else if (chosen_queue == 3) {
                    int k = 0;
                    while (k < cashier_3.length) {
                        if (cashier_3[k] == 'x') {
                            cashier_3[k] = 'o';
                        }
                        break;
                    }
                    k++;
                } else {
                    System.out.println("You entered wrong queue number.");
                }
                //asking for the burger count each person need

                System.out.println("Give your order !....");
                System.out.print("How many burgers do you want: ");
                Scanner input_4 = new Scanner(System.in);
                int ordered_burgers = input_4.nextInt();

                if (ordered_burgers > Burgers) {
                    System.out.println("Available Burgers are: " + Burgers);
                    continue;
                }
                Burgers = Burgers - ordered_burgers;


                if (Burgers <= 10) {
                    System.out.println("Warning: Low stock! Remaining burgers: " + Burgers);
                }
                System.out.println();
                code();
                // remove surved customer

                System.out.print("Choose the queue you want to remove served customer(cashier_1's queue=1,cashier_2;s queue=2 or cashier_3's queue=3): ");
                Scanner input_8 = new Scanner(System.in);
                int served_queue = input_8.nextInt();

                Scanner input_5 = new Scanner(System.in);
                System.out.println("Enter the customers location: ");
                int customer_location = input_5.nextInt();
                if (served_queue == 1) {
                    cashier_1[customer_location] = 'x';
                    System.out.println("Now customer removed from cashier " + chosen_queue);
                    code();
                } else if (served_queue == 2) {
                    cashier_2[customer_location] = 'x';
                    System.out.println("Now customer removed from cashier " + chosen_queue);
                    code();
                } else if (served_queue == 3) {
                    cashier_3[customer_location] = 'x';
                    System.out.println("Now customer removed from cashier " + chosen_queue);
                    code();
                } else {
                    System.out.println("Sorry we can't remove a served customer.You entered wrong location.Please recheck it.");
                }
                System.out.println("ok...! Successfully we removed served customer.");
            }

            //Method to sort customer in alphabetical order

            else if (choice.equals("105") || choice.equals("VCS")) {
                int temp = 0;

                for (int i = 0; i < 10 - 1; i++) {
                    for (int j = 0; j < 10 - i - 1; j++) {
                        boolean found = false;
                        if (names[j] != null && names[j + 1] != null) {

                            int length = Math.min(names[j].length(), names[j + 1].length());

                            for (int a = 0; a < length; a++) {
                                char ch1 = names[j].charAt(a);
                                char ch2 = names[j + 1].charAt(a);

                                if (ch1 != ch2) {
                                    temp = ch1 - ch2;
                                    found = true;
                                    break;
                                }
                            }
                            if (!found) {
                                temp = names[j].length() - names[j + 1].length();
                            }
                            if (temp > 0) {
                                // Swap the elements
                                String tempy = names[j];
                                names[j] = names[j + 1];
                                names[j + 1] = tempy;
                            }
                        }
                    }
                }
                for (String name : names) {
                    if (name != null) {
                        System.out.println(name);
                    }
                }
            }
            // Method to Store Program Data Into File
            else if (choice.equals("106") || choice.equals("SPD")) {
                //to find any errors in the given code.
                try {
                    FileWriter file = new FileWriter("C:\\Users\\Piyumika Thennakoon\\Desktop\\CW\\FIle\\FoodiesFaveFile.txt");   //to create a file.
                    file.write(Burgers + "\n");
                    file.write(Arrays.toString(names));

                    file.close();
                System.out.println("ok...sorted to the file");
                }
                //to handle error that found in try block.
                catch(Exception e) {
                    e.printStackTrace();
                }
            }
            // Method to Load Program Data Into File
            else if (choice.equals("107") || choice.equals("LPD")){
                try {
                    FileReader pointer = new FileReader("C:\\Users\\Piyumika Thennakoon\\Desktop\\CW\\FIle\\FoodiesFaveFile.txt");
                    Scanner readfile = new Scanner(pointer);
                    while (readfile.hasNextLine()) {
                        String data = readfile.nextLine();
                        System.out.println(data);
                    }
                }catch(IOException e){
                        System.out.println("Error");
                    }
                }
            // Method to print the remaining Burger Stock
            else  if (choice.equals("108") || choice.equals("STK")) {
                System.out.println("Now remaining Burger stock is " + Burgers);
            }

            // Method to add new Burgers to Burger Stock
            else if (choice.equals("109") || choice.equals("AFS")) {
                Burgers = Burgers + 50;
                System.out.println("Burger stock filled with burgers again.Now Burger Stock is:  " + Burgers);
            }
            // Method to stop the loop
            else if (choice.equals("999") || choice.equals("EXT")) {
                break;
            }
            else{
                System.out.println("Ohh Sorry your choice not in the menu option.Please check menu option and enter your choice.");
            }
        }
    }
//a method to print cashier output.
    public static void code() {

        System.out.println("*****************");
        System.out.println("*    cashiers   *");
        System.out.println("*****************");

        for (int i = 0; i < 5; i++) {
            if (i < cashier_1.length) {
                System.out.print(cashier_1[i] + "\t");
            } else {
                System.out.print("\t");
            }
            if (i < cashier_2.length) {
                System.out.print(cashier_2[i] + "\t");
            } else {
                System.out.print("\t");
            }
            if (i < cashier_3.length) {
                System.out.print(cashier_3[i] + "\t");
            } else {
                System.out.print("\t");
            }
            System.out.println();
        }
        System.out.println("x – Not Occupied o – Occupied");

    }
}