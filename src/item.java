import java.util.ArrayList;

public class item {


    private String name;
    private int id;
    private int price;
    private int quantity;
    private ArrayList<manager> seller = new ArrayList<manager>();

    public item(String nm, int i, int pr, int qn, manager sl) {
        setName(nm);
        setId(i);
        setPrice(pr);
        setQuantity(qn);
        setSeller(sl);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public ArrayList<manager> getSeller() {
        return seller;
    }

    public void setSeller(manager ss) {
        seller.add(ss);
    }

    public String getName() {
        return name;
    }

    public void setName(String s) {
        this.name = s;
    }

    public void printManagerDetails() {
        for (manager m : seller) {
            System.out.println("Manager name : " + m.getManager_Name());
            System.out.println("Manager id : " + m.getManager_StockID());
            System.out.println("Manager address : " + m.getManager_Address());
            System.out.println("Manager Stock id : " + m.getManager_StockID());
        }
    }


}
