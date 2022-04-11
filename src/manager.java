//this manages class
public class manager {
    private String manager_Name;
    private int manager_Id;
    private String manager_Address;
    private int manager_StockID;

    //manger constructor
    public manager(String manager_Name, int manager_Id, String manager_Address, int manager_StockID) {
        setManager_Name(manager_Name);
        setManager_Id(manager_Id);
        setManager_Address(manager_Address);
        setManager_StockID(manager_StockID);
    }

    public String getManager_Name() {

        return manager_Name;
    }

    public void setManager_Name(String manager_Name) {

        this.manager_Name = manager_Name;
    }

    public int getManager_Id() {

        return manager_Id;
    }

    public void setManager_Id(int manager_Id) {

        this.manager_Id = manager_Id;
    }

    public String getManager_Address() {

        return manager_Address;
    }

    public void setManager_Address(String manager_Address) {

        this.manager_Address = manager_Address;
    }

    public int getManager_StockID() {

        return manager_StockID;
    }

    public void setManager_StockID(int manager_StockID) {

        this.manager_StockID = manager_StockID;
    }
}
