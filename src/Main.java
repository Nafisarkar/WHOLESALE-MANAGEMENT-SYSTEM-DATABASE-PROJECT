import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

//16 wholesale management system database project
public class Main {
    public static ArrayList<item> box = new ArrayList<item>();

    public static void removeItem(ArrayList<item> s){
        System.out.println("Enter the name of the item you want to delete");
        Scanner scan = new Scanner(System.in);
        String srcName = scan.nextLine();
        boolean found=false;
        for(item ss:s){
            if(Objects.equals(ss.getName(), srcName)){
                System.out.println("Item : " + ss.getName()  +" Id : "+ ss.getId()+" is deleted !");
                s.remove(ss);
                found = true;
            }
        }
        if(found==false){
            System.out.println("item not found!");
        }else{
            System.out.println("Item is successfully deleted !");
        }
        manu();
    }

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
            manager temp_manager = new manager(tempseller,temp_manager_id,temp_manage_address,tempid);
            item l = new item(tempname, tempid, tempprice, tempquantity, temp_manager);
            b.add(l);
        }
        System.out.println("size : " + b.size());
        manu();
    }

    public static void displayItem(ArrayList<item> b) {
        for (item x : b) {
            System.out.println("|----------------------------------------------|");
            System.out.println("Item name :" + x.getName());
            System.out.println("Item id : " + x.getId());
            System.out.println("Item price : " + x.getPrice() + " TK per unit");
            System.out.println("Item quantity " + x.getQuantity() + " units");
            x.printManagerDetails();
            System.out.println("|----------------------------------------------|");
        }
        manu();
    }

    public static void menuList() {
        System.out.println("[------------------------]");
        System.out.println("     Enter 0 to exit ");
        System.out.println("      1.Show Items.");
        System.out.println("      2.Add Items.");
        System.out.println("      3.remove Item.");
        System.out.println("[________________________]");
    }

    public static void manu() {
        Scanner scan = new Scanner(System.in);

        boolean run = true;
        while (run) {
            try {
                menuList();
                //just added base items for testing
                int choice = scan.nextInt();
                switch (choice) {
                    case 1:
                        displayItem(box);
                        scan.nextLine();
                        break;
                    case 2:
                        addItem(box);
                        break;

                    case 3:
                        removeItem(box);
                        break;
                }
                if (choice == 0) {
                    run = false;
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

    public static void main(String[] args) {
        manager m1 = new manager("asif",23,"mohammodpur",12);
        item rice = new item("rice", 1, 50, 200, m1);
        manager m2 = new manager("arif",24,"bogura",245);
        item sugar = new item("sugar", 2, 30, 300, m2);
        manager m3 = new manager("haris",32,"mohammodpur",2323);
        item egg = new item("egg", 3, 10, 2000, m3);
        box.add(rice);
        box.add(sugar);
        box.add(egg);
        manu();
    }
}
