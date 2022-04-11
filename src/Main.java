import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

//16 wholesale management system database project.
//this is the main function.
public class Main {

    //this is the arraylist for box that holds items.
    public static ArrayList<item> box = new ArrayList<>();
    //this arraylist holds customer details
    public static ArrayList<customer> cust = new ArrayList<>();

    //this function is for profit this month .
    public static void profitthisMonth(ArrayList<customer> cust){
        int total_paidit=0;
        int total_notPaidit=0;
        //checks if the  arraylist is empty or not.
        if(Main.cust.isEmpty()){
            System.out.println(" no data added ! ");
        }else{
            //this will count the total paid amount and total unpaid amount.
            for(customer x: Main.cust){
                total_paidit += x.getPaid_amount();
                total_notPaidit += x.getUnpaid_amount();
            }
            System.out.println("Total sold this month "+ total_paidit+ " $ ");
            System.out.println("Total paid amount  "+ total_paidit+ " $ ");
            System.out.println("Total not paid  "+total_notPaidit+ " $ ");
        }
        manu();
    }

    //this function adds customer to arraylist.
    public static void addCustomer(ArrayList<customer> c){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the customer count : ");
        int customer_Count = scan.nextInt();
        for(int i=0;i<customer_Count;i++){
            scan.nextLine();
            System.out.println("Customer name : ");
            String tempCustomerName = scan.nextLine();
            System.out.println("Customer address : ");
            String tempCustomerAddress = scan.nextLine();
            System.out.println("Customer id : ");
            int tempCustomerID = scan.nextInt();
            System.out.println("Paid amount : ");
            int tempPaidAmount = scan.nextInt();
            System.out.println("Unpaid amount : ");
            int tempUnpaidAmount = scan.nextInt();
            System.out.println("Number of items sold : ");
            int tempSoldeItem = scan.nextInt();
            customer tempcustomer = new customer(tempCustomerName,tempCustomerAddress,tempCustomerID,tempPaidAmount,tempUnpaidAmount);
            scan.nextLine();
            for(int j=0;j<tempSoldeItem;j++){
                System.out.println( "Number "+(j+1)+ "item name :");
                String tempItemName = scan.nextLine();
                tempcustomer.setSoldItem(tempItemName);
            }
            //this line adds the local object to the arraylist.
            cust.add(tempcustomer);
        }
        manu();
    }

    //this function is used to show the customer details.
    public static void showCustomer(ArrayList<customer> ccustomer){
        for(customer c:ccustomer){
            c.displayCustomerDetails();
        }
        manu();
    }

    //this is used for remove item from the array list.
    public static void removeItem(ArrayList<item> s) {
        System.out.println("Enter the name of the item you want to delete");
        Scanner scan = new Scanner(System.in);
        String srcName = scan.nextLine();
        boolean found = false;
        //this searches through the list and finds the object .
        for (item ss : s) {
            if (Objects.equals(ss.getName(), srcName)) {
                System.out.println("Item : " + ss.getName() + " Id : " + ss.getId() + " is deleted !");
                s.remove(ss);
                found = true;
            }
        }
        //if the object is not found.
        if (!found) {
            System.out.println("item not found!");
        } else {
            //if the object is found!.
            System.out.println("Item is successfully deleted !");
        }
        manu();
    }

    //this adds item to the arraylist.
    public static void addItem(ArrayList<item> b) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter how many item you want to create :");
        int create_item = scan.nextInt();
        scan.nextLine();
        for (int i = 0; i < create_item; i++) {
            System.out.println("Details for item -> " + (i + 1));
            System.out.print("Enter the item name :");
            String tempname = scan.nextLine();
            System.out.print("Enter the item id : ");
            int tempid = scan.nextInt();
            System.out.print("Enter the per unit price : ");
            int tempprice = scan.nextInt();
            System.out.print("Enter the item quantity : ");
            int tempquantity = scan.nextInt();
            scan.nextLine();
            System.out.print("Enter the Seller name : ");
            String tempseller = scan.nextLine();
            System.out.println("Enter manager id : ");
            int temp_manager_id = scan.nextInt();
            System.out.println("Enter manager address : ");
            scan.nextLine();
            String temp_manage_address = scan.nextLine();
            manager temp_manager = new manager(tempseller, temp_manager_id, temp_manage_address, tempid);
            item l = new item(tempname, tempid, tempprice, tempquantity, temp_manager);
            b.add(l);
        }
//        System.out.println("size : " + b.size());
        manu();
    }

    //this function displays all the details in the object.
    public static void displayItem(ArrayList<item> b) {
        for (item x : b) {
            System.out.println("|----------------------------------------------|");
            System.out.println("     Item name       : " + x.getName());
            System.out.println("     Item id         : " + x.getId());
            System.out.println("     Item price      : " + x.getPrice() + " TK per unit");
            System.out.println("     Item quantity   : " + x.getQuantity() + " units");
            x.printManagerDetails();
            System.out.println("|----------------------------------------------|");
        }
        manu();
    }

    //this prints the list to the terminal.
    public static void menuList() {
        System.out.println("[------------------------]");
        System.out.println("     Enter 0 to exit      ");
        System.out.println("      1.Show Items.       ");
        System.out.println("      2.Add Items.        ");
        System.out.println("      3.Remove Item.      ");
        System.out.println("      4.Show Customer.    ");
        System.out.println("      5.Add Customer.     ");
        System.out.println("      6.Profit            ");
        System.out.println("[________________________]");
    }

    //this function drives the menu and call all the functions
    public static void manu() {
        Scanner scan = new Scanner(System.in);
        boolean run = true;
        while (run) {
            //this will try retry untill a valid input is taken
            try {
                menuList();
                //just added base items for testing
                int choice = scan.nextInt();
                //smart switch
                switch (choice) {
                    case 1 -> {
                        displayItem(box);
                        scan.nextLine();
                    }
                    case 2 -> addItem(box);
                    case 3 -> removeItem(box);
                    case 4 -> showCustomer(cust);
                    case 5 -> addCustomer(cust);
                    case 6 -> profitthisMonth(cust);
                }
                if (choice == 0) {
                    run = false;
                    //this is used to exit a function
                    System.exit(0);

                }
            } catch (Exception e) {
                //recursive function manu
                System.out.println("Please enter a digit between (0-9)");
                manu();
                break;
            }
        }
    }

    //this is the main function that drives the code.
    public static void main(String[] args) {
        manager m1 = new manager("asif", 23, "mohammodpur", 12);
        item rice = new item("rice", 1, 50, 200, m1);
        manager m2 = new manager("arif", 24, "bogura", 245);
        item sugar = new item("sugar", 2, 30, 300, m2);
        manager m3 = new manager("haris", 32, "mohammodpur", 2323);
        item egg = new item("egg",2,10,234,m3);
        item pepsi = new item("pepsi",23,30,200,m3);
        box.add(rice);
        box.add(sugar);
        box.add(egg);
        box.add(pepsi);
        manu();
    }
}
