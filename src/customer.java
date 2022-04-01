import java.util.ArrayList;

public class customer {
    private String customer_Name;
    private String customer_Address;
    private int customer_Id;
    private int paid_amount;
    private int unpaid_amount;
    private final ArrayList<String> soldItem = new ArrayList<>();

    public customer(String customer_Name, String customer_Address, int customer_Id, int paid_amount, int unpaid_amount) {
        setCustomer_Name(customer_Name);
        setCustomer_Address(customer_Address);
        setCustomer_Id(customer_Id);
        setPaid_amount(paid_amount);
        setUnpaid_amount(unpaid_amount);
    }

    public String getCustomer_Name() {
        return customer_Name;
    }

    public void setCustomer_Name(String customer_Name) {
        this.customer_Name = customer_Name;
    }

    public String getCustomer_Address() {
        return customer_Address;
    }

    public void setCustomer_Address(String customer_Address) {
        this.customer_Address = customer_Address;
    }

    public int getCustomer_Id() {
        return customer_Id;
    }

    public void setCustomer_Id(int customer_Id) {
        this.customer_Id = customer_Id;
    }

    public int getPaid_amount() {
        return paid_amount;
    }

    public void setPaid_amount(int paid_amount) {
        this.paid_amount = paid_amount;
    }

    public int getUnpaid_amount() {
        return unpaid_amount;
    }

    public void setUnpaid_amount(int unpaid_amount) {
        this.unpaid_amount = unpaid_amount;
    }

    public ArrayList<String> getSoldItem() {
        return soldItem;
    }

    public void setSoldItem(String s) {
        soldItem.add(s);
    }

    public void displayCustomerDetails(){
        System.out.println("Customer name ----------> "+this.customer_Name);
        System.out.println("Customer id ------------> "+this.customer_Id);
        System.out.println("Customer address -------> "+this.customer_Address);
        System.out.println("Customer paid ----------> "+this.paid_amount);
        System.out.println("Customer unpaid amount -> "+this.unpaid_amount);
        System.out.println(soldItem);
    }

}
