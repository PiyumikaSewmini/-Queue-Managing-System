
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


public class foodiesFaveQueueManagementSystem {

    // View all Queues method
    public static void viewAll() {   //method to print the cashier.

        int Q1_count = FoodQ[0].Current_Customers;
        int Q2_count = FoodQ[1].Current_Customers;
        int Q3_count = FoodQ[2].Current_Customers;

        if (Q1_count == 0 && Q2_count == 0 && Q3_count == 0) {
            System.out.println("All Queues are Empty\n");
        }

        System.out.println("\n***********");
        System.out.println("*" + " " + "Cashier" + " " + "*");
        System.out.println("***********");

        // Checking Queues
        for (int i = 0; i < 5; i++) {

            String Queue_1;
            if (i < FoodQ[0].Queue_count) {
                if (FoodQ[0].customers[i].First_Name.equals("X")) {
                    Queue_1 = "X";
                } else {
                    Queue_1 = "O";
                }
            } else {
                Queue_1 = " ";
            }

            String Queue_2;
            if (i < FoodQ[1].Queue_count) {
                if (FoodQ[1].customers[i].First_Name.equals("X")) {
                    Queue_2 = "X";
                } else {
                    Queue_2 = "O";
                }
            } else {
                Queue_2 = " ";
            }
            String Queue_3;
            if (i < FoodQ[2].Queue_count) {
                if (FoodQ[2].customers[i].First_Name.equals("X")) {
                    Queue_3 = "X";
                } else {
                    Queue_3 = "O";
                }
            } else {
                Queue_3 = " ";
            }
            System.out.println("\n" + Queue_1 + "   " + Queue_2 + "   " + Queue_3);

        }

    }

    // View All Empty Queues
    public static void viewEmpty() {

        for (int i = 0; i < 3; i++) {
            if (FoodQ[i].Current_Customers == 0) {
                System.out.println("Q " + (i + 1) + " is Empty");
            } else {
                System.out.println("Q " + (i + 1) + "is not Empty");
            }
        }

    }

    // Method to Add Customer to queue
    public static void addCustomer() {
        String F_name;
        String L_name;
        int R_Buger_count;

        int Q1_count = FoodQ[0].Current_Customers;
        int Q2_count = FoodQ[1].Current_Customers;
        int Q3_count = FoodQ[2].Current_Customers;

        System.out.print("\nEnter first name: ");
        F_name = scannerObject.next();

        System.out.print("\nEnter second name: ");
        L_name = scannerObject.next();

        System.out.print("\nEnter No of requried burgers: ");
        R_Buger_count = Integer.parseInt(scannerObject.next());

        if (Q1_count == 2 && Q2_count == 3 && Q3_count == 5) {
            WaitQueue.customers[waitcount].Adding_Customer(F_name, L_name, R_Buger_count);
            System.out.println(F_name + " " + L_name + " added to waiting queue");
            waitcount++;
        } else {
            if (Q1_count <= Q2_count && Q2_count <= Q3_count && Q1_count != 2) {

                FoodQ[0].customers[FoodQ[0].Current_Customers].Adding_Customer(F_name, L_name, R_Buger_count);
                FoodQ[0].Current_Customers++;

            } else if (Q2_count <= Q1_count && Q2_count <= Q3_count && Q2_count != 3) {
                FoodQ[1].customers[FoodQ[1].Current_Customers].Adding_Customer(F_name, L_name, R_Buger_count);
                FoodQ[1].Current_Customers++;
            } else {
                FoodQ[2].customers[FoodQ[2].Current_Customers].Adding_Customer(F_name, L_name, R_Buger_count);
                FoodQ[2].Current_Customers++;
            }
            System.out.println(F_name + " " + L_name + " " + "Added to the Queue");
        }

    }

    // Remove Customer from queue
    public static void removeCustomer() {

        System.out.println("Enter Queue number: ");
        int Q_No = scannerObject.nextInt();

        if (Q_No == 1) {
            System.out.println("Enter Position: ");
            int position = scannerObject.nextInt();
            if (position > FoodQ[0].Current_Customers) {
                System.out.println("Position Empty");
            } else {
                FoodQ[0].customers[position - 1].First_Name = FoodQ[0].customers[position - 1].Last_Name = "X";

                int a = position - 1;
                for (int i = a; i < 1; i++) {
                    FoodQ[0].customers[i].First_Name = FoodQ[0].customers[i + 1].First_Name;
                    FoodQ[0].customers[i].Last_Name = FoodQ[0].customers[i + 1].Last_Name;
                    FoodQ[0].customers[i].Required_Burgers = FoodQ[0].customers[i + 1].Required_Burgers;
                }

                FoodQ[0].customers[1].First_Name = FoodQ[0].customers[1].Last_Name = "X";
                FoodQ[0].Current_Customers--;

                System.out.println("Customer Removed Successfully ");
            }

        } else if (Q_No == 2) {
            System.out.println("Enter Position: ");
            int position = scannerObject.nextInt();
            if (position > FoodQ[1].Current_Customers) {
                System.out.println("Position Empty");
            } else {
                FoodQ[1].customers[position - 1].First_Name = FoodQ[1].customers[position - 1].Last_Name = "X";
                int a = position - 1;
                for (int i = a; i < 2; i++) {
                    FoodQ[1].customers[i].First_Name = FoodQ[1].customers[i + 1].First_Name;
                    FoodQ[1].customers[i].Last_Name = FoodQ[1].customers[i + 1].Last_Name;
                    FoodQ[1].customers[i].Required_Burgers = FoodQ[1].customers[i + 1].Required_Burgers;
                }
                FoodQ[1].customers[2].First_Name = FoodQ[1].customers[2].Last_Name = "X";
                FoodQ[1].Current_Customers--;

                System.out.println("Customer Removed Successfully ");
            }

        } else {
            System.out.println("Enter Position: ");
            int position = scannerObject.nextInt();
            if (position > FoodQ[2].Current_Customers) {
                System.out.println("Position Empty");
            } else {
                FoodQ[2].customers[position - 1].First_Name = FoodQ[2].customers[position - 1].Last_Name = "X";
                int a = position - 1;
                for (int i = a; i < 4; i++) {
                    FoodQ[2].customers[i].First_Name = FoodQ[2].customers[i + 1].First_Name;
                    FoodQ[2].customers[i].Last_Name = FoodQ[2].customers[i + 1].Last_Name;
                    FoodQ[2].customers[i].Required_Burgers = FoodQ[2].customers[i + 1].Required_Burgers;
                }
                FoodQ[2].customers[4].First_Name = FoodQ[2].customers[4].Last_Name = "X";
                FoodQ[2].Current_Customers--;
                System.out.println("Customer Removed Successfully ");
            }
        }
    }

    // Method to RemoveServedCustomer
    public static void removeAServedCustomer() {

        System.out.println("Enter the Served custumer Queue: ");
        int Q_No = scannerObject.nextInt();

        if (Q_No == 1) {
            if (FoodQ[0].Current_Customers != 0) {
                int Bcount = FoodQ[0].customers[0].Required_Burgers;

                FoodQ[0].customers[0].First_Name = FoodQ[0].customers[0].Last_Name = "X";

                for (int i = 0; i < 1; i++) {
                    FoodQ[0].customers[i].First_Name = FoodQ[0].customers[i + 1].First_Name;
                    FoodQ[0].customers[i].Last_Name = FoodQ[0].customers[i + 1].Last_Name;
                    FoodQ[0].customers[i].Required_Burgers = FoodQ[0].customers[i + 1].Required_Burgers;
                }
                FoodQ[0].customers[1].First_Name = FoodQ[0].customers[1].Last_Name = "X";

                if (waitcount != 0) {
                    FoodQ[0].customers[FoodQ[0].Current_Customers - 1] = WaitQueue.customers[0];
                    System.out.println("Customer Added to Queue 1 from watiting Queue");
                    for (int i = 0; i < waitcount - 1; i++) {
                        WaitQueue.customers[i] = WaitQueue.customers[i + 1];
                    }
                    waitcount--;
                    FoodQ[0].Current_Customers++;
                }
                if (Current_Burger_Count >= Bcount) {
                    FoodQ[0].Current_Customers--;
                    Current_Burger_Count = Current_Burger_Count - Bcount;
                    if (Current_Burger_Count <= 10) {

                        System.out.println("Burger Stock has reached 10");
                    }
                    FoodQ[0].income = FoodQ[0].income + Bcount * 650;
                    System.out.println("Customer Served Successfully from Queue 1");
                } else {
                    FoodQ[0].Current_Customers--;
                    System.out.println("Stock is Empty customer removed");
                }

            } else {
                System.out.println("Queue is empty");
            }
        } else if (Q_No == 2)

        {
            if (FoodQ[1].Current_Customers != 0) {
                int Bcount = FoodQ[1].customers[0].Required_Burgers;
                FoodQ[1].customers[0].First_Name = "X";
                FoodQ[1].customers[0].Last_Name = "X";
                for (int i = 0; i < 2; i++) {
                    FoodQ[1].customers[i].First_Name = FoodQ[1].customers[i + 1].First_Name;
                    FoodQ[1].customers[i].Last_Name = FoodQ[1].customers[i + 1].Last_Name;
                    FoodQ[1].customers[i].Required_Burgers = FoodQ[1].customers[i + 1].Required_Burgers;
                }

                FoodQ[1].customers[2].First_Name = FoodQ[1].customers[2].Last_Name = "X";

                if (waitcount != 0) {
                    FoodQ[1].customers[FoodQ[1].Current_Customers - 1] = WaitQueue.customers[0];
                    System.out.println("Customer Added to Queue 2 from watiting Queue");
                    for (int i = 0; i < waitcount - 1; i++) {
                        WaitQueue.customers[i] = WaitQueue.customers[i + 1];
                    }
                    waitcount--;
                    FoodQ[1].Current_Customers++;
                }

                if (Current_Burger_Count >= Bcount) {
                    FoodQ[1].Current_Customers--;

                    Current_Burger_Count = Current_Burger_Count - Bcount;
                    if (Current_Burger_Count <= 10) {
                        System.out.println("Burger Stock has reached 10");
                    }
                    FoodQ[1].income = FoodQ[1].income + Bcount * 650;
                    System.out.println("Customer Served Successfully from Queue 2");
                } else {
                    System.out.println("Stock is Empty customer removed");
                    FoodQ[1].Current_Customers--;
                }

            } else {
                System.out.println("Queue is empty");
            }
        } else {
            if (FoodQ[2].Current_Customers != 0) {

                int Bcount = FoodQ[2].customers[0].Required_Burgers;
                FoodQ[2].customers[0].First_Name = FoodQ[2].customers[0].Last_Name = "X";

                for (int i = 0; i < 4; i++) {
                    FoodQ[2].customers[i].First_Name = FoodQ[2].customers[i + 1].First_Name;
                    FoodQ[2].customers[i].Last_Name = FoodQ[2].customers[i + 1].Last_Name;
                    FoodQ[2].customers[i].Required_Burgers = FoodQ[2].customers[i + 1].Required_Burgers;
                }
                FoodQ[2].customers[4].First_Name = "X";
                FoodQ[2].customers[4].Last_Name = "X";

                if (waitcount != 0) {
                    FoodQ[2].customers[FoodQ[2].Current_Customers - 1] = WaitQueue.customers[0];
                    System.out.println("Customer Added to Queue 3 from watiting Queue");
                    for (int i = 0; i < waitcount - 1; i++) {
                        WaitQueue.customers[i] = WaitQueue.customers[i + 1];
                    }
                    waitcount--;
                    FoodQ[2].Current_Customers++;

                }

                if (Current_Burger_Count >= Bcount) {
                    FoodQ[2].Current_Customers--;
                    Current_Burger_Count = Current_Burger_Count - Bcount;
                    if (Current_Burger_Count <= 10) {
                        System.out.println("Burger Stock has reached 10");
                    }
                    FoodQ[2].income = FoodQ[2].income + Bcount * 650;
                    System.out.println("Customer Served Successfully from Queue 3");
                } else {
                    FoodQ[2].Current_Customers--;
                    System.out.println("Stock is Empty customer removed");
                }

            } else {
                System.out.println("Queue is empty");
            }
        }
    }

    // Sort in Alphabatical order
    public static void AlphabeticalSort() {
        if (FoodQ[0].Current_Customers == 0) {
            System.out.println("Queue 1 is Empty\n");
        } else {
            String[] names = new String[FoodQ[0].Current_Customers];
            for (int i = 0; i < FoodQ[0].Current_Customers; i++) {
                names[i] = FoodQ[0].customers[i].First_Name + " " + FoodQ[0].customers[i].Last_Name;
            }

            int n = names.length;
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    if (names[j].compareTo(names[j + 1]) > 0) {
                        String temp = names[j];
                        names[j] = names[j + 1];
                        names[j + 1] = temp;
                    }
                }
            }
            System.out.println("Cashier 1: ");
            for (int i = 0; i < FoodQ[0].Current_Customers; i++) {
                System.out.print(names[i] + "\n");
            }
            System.out.println("\n");
        }

        if (FoodQ[1].Current_Customers == 0) {
            System.out.println("Queue 2 is Empty\n");
        } else {
            String[] names = new String[FoodQ[1].Current_Customers];
            for (int i = 0; i < FoodQ[1].Current_Customers; i++) {
                names[i] = FoodQ[1].customers[i].First_Name + " " + FoodQ[1].customers[i].Last_Name;
            }

            int n = names.length;
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    if (names[j].compareTo(names[j + 1]) > 0) {
                        String temp = names[j];
                        names[j] = names[j + 1];
                        names[j + 1] = temp;
                    }
                }
            }
            System.out.println("Cashier 2: ");
            for (int i = 0; i < FoodQ[1].Current_Customers; i++) {
                System.out.print(names[i] + "\n");
            }
            System.out.println("\n");
        }
        if (FoodQ[2].Current_Customers == 0) {
            System.out.println("Queue 3 is Empty\n");
        } else {
            String[] names = new String[FoodQ[2].Current_Customers];
            for (int i = 0; i < FoodQ[2].Current_Customers; i++) {
                names[i] = FoodQ[2].customers[i].First_Name + " " + FoodQ[2].customers[i].Last_Name;
            }
            int n = names.length;
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    if (names[j].compareTo(names[j + 1]) > 0) {
                        String temp = names[j];
                        names[j] = names[j + 1];
                        names[j + 1] = temp;
                    }
                }
            }
            System.out.println("Cashier 3: ");
            for (int i = 0; i < FoodQ[2].Current_Customers; i++) {
                System.out.print(names[i] + "\n");
            }
        }
    }

    // StoreProgramDataIntoFile
    public static void storeProgramDataIntoFile() {
        try {   //to catch errors in the given code.
            FileWriter pointer = new FileWriter("C:\\Users\\Piyumika Thennakoon\\Desktop\\CW\\SD 2 CourseWork\\Class version\\program output\\BurgerLoad.txt");

            pointer.write("Queue 1");
            pointer.write("\n");
            for (int i = 0; i < FoodQ[0].Current_Customers; i++) {
                String firstname = FoodQ[0].customers[i].First_Name;
                String lastname = FoodQ[0].customers[i].Last_Name;
                pointer.write("Fist name: " + firstname);
                pointer.write("\n");
                pointer.write("Last name: " + lastname);
                pointer.write("\n");
            }
            pointer.write("\n\n");
            pointer.write("Queue 2\n");

            for (int i = 0; i < FoodQ[1].Current_Customers; i++) {
                String firstname = FoodQ[1].customers[i].First_Name;
                String lastname = FoodQ[1].customers[i].Last_Name;
                pointer.write("Fist name: " + firstname);
                pointer.write("\n");
                pointer.write("Last name: " + lastname);
                pointer.write("\n");
            }
            pointer.write("\n\n");
            pointer.write("Queue 3");
            pointer.write("\n");
            for (int i = 0; i < FoodQ[2].Current_Customers; i++) {
                String firstname = FoodQ[2].customers[i].First_Name;
                String lastname = FoodQ[2].customers[i].Last_Name;
                pointer.write("Fist name: " + firstname);
                pointer.write("\n");
                pointer.write("Last name: " + lastname);
                pointer.write("\n");
            }
            pointer.write("\n");
            pointer.write("Burger stock:" + Current_Burger_Count);
            pointer.close();
        } catch (IOException e) {  //to handle the errors that caught in try block.
            System.out.println("Error");
        }

    }

    // LoadProgramDataIntoFile
    public static void loadProgramDataIntoFile() {
        try {
            FileReader p = new FileReader(
                    "C:\\Users\\Piyumika Thennakoon\\Desktop\\CW\\SD 2 CourseWork\\Class version\\program output\\BurgerLoad.txt");
            Scanner readfile = new Scanner(p);
            while (readfile.hasNextLine()) {
                String data = readfile.nextLine();
                System.out.println(data);
            }
        } catch (IOException e) {
            System.out.println("Error");
        }
    }

    // View remaining Burger Count
    public static void viewRemainingBurgers() {
        System.out.println("Burgers in the stock: " + Current_Burger_Count);
    }

    // Update Burger Count
    public static void addBurgersToStock() {
        if (Current_Burger_Count < 50) {
            System.out.print("Enter Value to add to the stock: ");
            int Add_Burgers = scannerObject.nextInt();

            int newStock = Current_Burger_Count + Add_Burgers;
            Current_Burger_Count = Math.min(newStock, 50);
            System.out.println("Stocks Added Successfully");

        } else {
            System.out.println("Adding Denied! Stock Full !");

        }

    }

    // Print income
    public static void printIncome() {

        System.out.println("Income of Queue 1 is " + FoodQ[0].income);
        System.out.println("Income of Queue 2 is " + FoodQ[1].income);
        System.out.println("Income of Queue 3 is " + FoodQ[2].income);
    }

    // Defining the Global Variables.
    public static int waitcount = 0;
    public static int Current_Burger_Count = 50;
    public static Scanner scannerObject = new Scanner(System.in);
    public static Queue[] FoodQ = new Queue[3];
    public static Queue WaitQueue = new Queue(100);

    public static void main(String[] args) {

        FoodQ[0] = new Queue(2);
        FoodQ[1] = new Queue(3);
        FoodQ[2] = new Queue(5);

        String Option;

        // Printing out the Menu
        System.out.println("\n------------------------------------");
        System.out.println("Foodies Fave Food Center");
        System.out.println("------------------------------------\n");
        System.out.println(
                "100 or VFQ: View all Queues\n101 or VEQ: View all Empty Queues.\n102 or ACQ: Add customer to a Queue.\n103 or RCQ: Remove a customer from a Queue.\n104 or PCQ: Remove a served customer.\n105 or VCS: View Customers Sorted in alphabetical order\n106 or SPD: Store Program Data into file.\n107 or LPD: Load Program Data from file.\n108 or STK: View Remaining burgers Stock.\n109 or AFS: Add burgers to Stock.\n110 or IFQ: View the income of the queues\n999 or EXT: Exit the Program.");

        // Getting in multiple Inputs using a While Loop
        do {
            System.out.print("\nEnter your Option: ");
            Option = scannerObject.next().toUpperCase();
            switch (Option) {
                case "100", "VFQ" -> {
                    System.out.println("\nView All Queues Selected");
                    viewAll();
                }
                case "101", "VEQ" -> {
                    System.out.println("\nView All Empty Selected");
                    viewEmpty();
                }
                case "102", "ACQ" -> {
                    System.out.println("\nAdd Customer to a Queue Selected");
                    addCustomer();
                }
                case "103", "RCQ" -> {
                    System.out.println("\nRemove customer from Queue selected");
                    removeCustomer();
                }
                case "104", "PCQ" -> {
                    System.out.println("\nRemove Served Customer");
                    removeAServedCustomer();
                }
                case "105", "VCS" -> AlphabeticalSort();
                case "106", "SPD" -> storeProgramDataIntoFile();
                case "107", "LPD" -> loadProgramDataIntoFile();
                case "108", "STK" -> viewRemainingBurgers();
                case "109", "AFS" -> addBurgersToStock();
                case "110", "IFQ" -> printIncome();
                case "999", "EXT" -> System.out.println("System Quiting....");
                default -> System.out.println("Invalid Input!");
            }
        } while (!(Option.equals("999") || Option.equals("EXT")));
    }
}




