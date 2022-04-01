import java.util.ArrayList;

public class item {


    private String name;
    private int id;
    private int price;
    private int quantity;
    private ArrayList<String> seller = new ArrayList<String>();

    public item(String nm, int i, int pr, int qn, String sl) {
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

    public ArrayList<String> getSeller() {
        return seller;
    }

    public void setSeller(String ss) {
        seller.add(ss);
    }

    public String getName() {
        return name;
    }

    public void setName(String s) {
        this.name = s;
    }


}
