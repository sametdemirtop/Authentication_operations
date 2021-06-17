import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Purchasing {
    String customerID;
    String productID;
    String productName;
    static ArrayList<Purchasing> purchasings = new ArrayList<Purchasing>();

    public static ArrayList<Purchasing> getPurchasings() {
        return purchasings;
    }

    public Purchasing() {
        super();
    }

    public Purchasing(String customerID, String productID, String productName) {
        this.customerID = customerID;
        this.productID = productID;
        this.productName = productName;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public String toString() {
        String write = "";
        write += this.customerID + "," + this.productID + "," + this.productName;
        return write;
    }

    void write() {
        try {
            File file = new File("C:\\Users\\Adem\\Desktop\\files\\purchases.txt");
            FileWriter fileWriter = new FileWriter(file, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Purchasing temp1 : purchasings) {
                temp1.toString();
                bufferedWriter.write(temp1.toString());
                bufferedWriter.write("\n");
                

            }

            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException ex) {
            System.out.println("Error writing to file '" + "C:\\Users\\Adem\\Desktop\\files\\purchases.txt" + "'");
        }
    }

}
