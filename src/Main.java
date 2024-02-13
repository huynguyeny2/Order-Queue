import java.util.Scanner;

public class Main {
    OrderClass myMainQueue = new OrderClass(10);
    DisplayClass sort = new DisplayClass();

    public Main() {
        this.myMainQueue.enqueue(new Orders(2, 2.1, "Jhin"));
        this.myMainQueue.enqueue(new Orders(3, 23.1, "Jan"));
        this.myMainQueue.enqueue(new Orders(6, 62.1, "Miz"));
        this.myMainQueue.enqueue(new Orders(7, 37.1, "Bem"));
        this.myMainQueue.enqueue(new Orders(1, 95.2, "Zay"));
        this.myMainQueue.enqueue(new Orders(4, 49.9, "Pat"));
        this.myMainQueue.enqueue(new Orders(8, 6.1, "Hazz"));
        this.myMainQueue.enqueue(new Orders(5, 37.1, "Walter"));
    }
    public Orders createOrderFromInput() {
        //function to create an order from user's input
        Scanner scnr = new Scanner(System.in);
        Integer orderNumber = null;
        while (orderNumber == null) {
            try {
                System.out.println("Please enter the order number: ");
                //parse a string and convert it into an integer and assess the value to condition
                int tempOrderNumber = Integer.parseInt(scnr.nextLine());
                //check for an existing order number. Continue entry if order number is unique.
                if (myMainQueue.uniqueOrder(tempOrderNumber)) {
                    if (tempOrderNumber > 0) {
                        orderNumber = tempOrderNumber;
                    } else {
                        System.out.println("Please enter a valid order greater than 0.");
                    }
                }
            }
            /*
            Catch exception when entry is not a numerical value.
            Loop and have the user try again.
            */
            catch (NumberFormatException e) {
                System.out.println("Please enter a valid numerical value");
            }
        }
        Double totalCost = null;
        while (totalCost == null) {
            try {
                System.out.println("Please enter the total cost: ");
                double tempTotalCost = Double.parseDouble(scnr.nextLine());
                if ( tempTotalCost > 0) {
                    totalCost = tempTotalCost;
                }
                else {
                    System.out.println("Please enter a valid total cost greater than 0.");
                }
            }
            catch (NumberFormatException e) {
                System.out.println("Please enter a valid numerical value");
            }
        }
        System.out.println("Please enter the customer's last name: ");
        String lastName = scnr.nextLine();
        if ( lastName.equals("")) {
            return null;
        }
        return new Orders(orderNumber, totalCost, lastName);
    }
    public void addOrder() {
        //add order from the user's input
        Orders order = this.createOrderFromInput();
        if (order != null) {
            //enqueue order from OrderClass to help add the order.
            this.myMainQueue.enqueue(order);
            System.out.println("Order Successfully Added.\n" + order);
        }
    }
    public void removeOrder() {
        Scanner scnr = new Scanner(System.in);
        this.myMainQueue.getSize();
        System.out.println("Type 'yes' to continue removing the order at the beginning of the queue." +
                "\nPress any other keys to cancel this operation.");
        // Taking a response from the user to remove the order at the beginning of the unsorted queue.
        char letter = scnr.next().toLowerCase().charAt(0);
        if (letter == 'y')  {
            System.out.println("Order Successfully Removed:\n" + this.myMainQueue.dequeue());
        } else {
            System.out.println("Operation Canceled.");
        }
    }
    public void displayOrder() {
        Scanner scnr = new Scanner(System.in);

        Orders[] varLastName = myMainQueue.getQueue();
        Orders[] varOrderNumber = myMainQueue.getQueue();

        int selection = 0;

        while (selection != 4) {
            System.out.println("Please choose one an option to view the Order Queue:");
            System.out.println("\t1 = Order Queue by Insertion");
            System.out.println("\t2 = Order Queue Sorted by Last Name");
            System.out.println("\t3 = Order Queue Sorted by Order Number");
            System.out.println("\t4 = Return to Main Menu.");

            System.out.println("Please enter an option from 1 to 4...:");

            try {
                selection = Integer.parseInt(scnr.nextLine());
                switch (selection) {
                    case 1 -> this.myMainQueue.viewOrder();
                    case 2 -> {
                        sort.quickSort(varLastName, 0, myMainQueue.getQueue().length - 1, new DisplayClass.NameCompare());
                        sort.displaySort(varLastName);
                    }
                    case 3 -> {
                        sort.quickSort(varOrderNumber, 0, myMainQueue.getQueue().length - 1, new DisplayClass.OrderNumberCompare());
                        sort.displaySort(varOrderNumber);
                    }

                    case 4 -> { return; }
                    default -> System.out.println("Invalid Selection. Please select a valid option.");
                }
            } catch (NumberFormatException e) {
                System.out.println(" Please enter a valid entry.");
            }
        }
    }

    public void mainLoop() {
        Scanner scnr = new Scanner(System.in);
        int selection = 0;
        while (selection != 4) {
            System.out.println("Order Queue:");
            System.out.println("\t1 = Add an Order");
            System.out.println("\t2 = Remove an Order");
            System.out.println("\t3 = View Order");
            System.out.println("\t4 = End");

            System.out.println("Please enter an option from 1 to 4...:");

            try {
                selection = Integer.parseInt(scnr.nextLine());
                switch (selection) {
                    case 1 -> addOrder();
                    case 2 -> removeOrder();
                    case 3 -> displayOrder();
                    case 4 -> { return; }
                    default -> System.out.println("Invalid Selection. Please select a valid option.");
                }
            } catch (NumberFormatException e) {
                System.out.println(" Please enter a valid entry.");
            }
        }
    }
    public static void main (String[] args) {
        Main orderAccess = new Main();
        orderAccess.mainLoop();
    }
}