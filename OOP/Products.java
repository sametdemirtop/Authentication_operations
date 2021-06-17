import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Products {
    String pName;
    String pID;
    int pStock;
    float pPrice;
    String type;

    public Products(String pName, String pID, int pStock, float pPrice, String type) {
        this.pName = pName;
        this.pID = pID;
        this.pStock = pStock;
        this.pPrice = pPrice;
        this.type = type;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getpID() {
        return pID;
    }

    public void setpID(String pID) {
        this.pID = pID;
    }

    public int getpStock() {
        return pStock;
    }

    public void setpStock(int pStock) {
        this.pStock = pStock;
    }

    public float getpPrice() {
        return pPrice;
    }

    public void setpPrice(float pPrice) {
        this.pPrice = pPrice;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public static void setProducts(ArrayList<Products> products) {
        Products.products = products;
    }

    public Products() {
        super();
    }

    static ArrayList<Products> products = new ArrayList<Products>();

    public static ArrayList<Products> getProducts() {
        return products;
    }

    public void write() {
        String fileName = "C:\\Users\\Adem\\Desktop\\files\\product.bin";

        try {
            FileOutputStream fos = new FileOutputStream(fileName, true);
            for (Products temp : products) {
                byte[] getDelimeter = ",".getBytes();
                byte[] pNamebyte = new byte[256];
                pNamebyte = temp.getpName().getBytes();
                byte bytes[] = temp.pID.getBytes();
                int blength = bytes.length;
                fos.write(blength);
                fos.write(blength >> 8);
                fos.write(bytes);
                fos.write(getDelimeter);
                fos.write(pNamebyte);
                fos.write(getDelimeter);
                int[] stock = new int[4];
                stock[0] = temp.pStock << 24;
                stock[1] = temp.pStock << 16;
                stock[2] = temp.pStock << 8;
                stock[3] = temp.pStock;
                for (int i = 0; i < stock.length; i++) {
                    fos.write(stock[i]);
                }
                fos.write(getDelimeter);
                int[] price = new int[4];
                price[0] = (int) temp.pPrice << 24;
                price[1] = (int) temp.pPrice << 16;
                price[2] = (int) temp.pPrice << 8;
                price[3] = (int) temp.pPrice;
                for (int i = 0; i < price.length; i++) {
                    fos.write(price[i]);
                }
                fos.write(getDelimeter);
                byte[] typebyte = new byte[32];
                typebyte = temp.getType().getBytes();
                fos.write(typebyte);
                fos.write("\n".getBytes());
            }
            fos.close();

        } catch (IOException ex) {
            System.out.println("Error writing to file '" + "C:\\Users\\Adem\\Desktop\\files\\product.bin" + "'");
        }

    }

    public void read() {
        String fileName = "C:\\Users\\Adem\\Desktop\\files\\product.bin";
        try {
            FileInputStream fis = new FileInputStream(fileName);
            short stlength = 0;
            char[] st = null;
            byte[] b = new byte[2];
            fis.read(b);
            stlength = (short) (stlength | b[0]);
            stlength <<= 8;
            stlength = (short) (stlength | b[1]);

            st = new char[stlength];
            byte[] bytes = new byte[stlength];
            fis.read(bytes);
            for (int i = 0; i < stlength; i++) {
                st[i] = (char) bytes[i];
            }
            for (Products temp : products) {
                if (temp.pID.equals(st.toString())) {
                    temp.setpStock(pStock - 1);
                }
            }
            fis.close();
        } catch (IOException ex) {
            System.out.println("Error writing to file '" + "C:\\Users\\Adem\\Desktop\\files\\product.bin" + "'");
        }
    }
}

class Tv extends Products {

    private String inc;

    Tv(String pName, String pID, int pStock, float pPrice, String type, String inc) {
        super(pName, pID, pStock, pPrice, type);
        this.inc = inc;
    }

    public String getInc() {
        return inc;
    }

    public void setInc(String inc) {
        this.inc = inc;
    }

    @Override
    public void read() {
        super.read();
    }

    @Override
    public void write() {
        super.write();
        String fileName = "C:\\Users\\Adem\\Desktop\\files\\product.bin";
        try {
            FileOutputStream fos = new FileOutputStream(fileName);
            byte[] incbyte = new byte[8];
            incbyte = inc.getBytes();
            fos.write(",".getBytes());
            fos.write(incbyte);
            fos.close();
        } catch (IOException ex) {
            System.out.println("Error writing to file '" + "C:\\Users\\Adem\\Desktop\\files\\product.bin" + "'");
        }

    }

}

class Telephone extends Products {
    private String megapixel;

    Telephone(String pName, String pID, int pStock, float pPrice, String type, String megapixel) {
        super(pName, pID, pStock, pPrice, type);
        this.megapixel = megapixel;
    }

    public String getMegapixel() {
        return megapixel;
    }

    public void setMegapixel(String megapixel) {
        this.megapixel = megapixel;
    }

    @Override
    public void write() {
        super.write();
        String fileName = "C:\\Users\\Adem\\Desktop\\files\\product.bin";
        try {
            FileOutputStream fos = new FileOutputStream(fileName);
            byte[] megapixelbyte = new byte[16];
            megapixelbyte = megapixel.getBytes();
            fos.write(",".getBytes());
            fos.write(megapixelbyte);
            fos.close();
        } catch (IOException ex) {
            System.out.println("Error writing to file '" + "C:\\Users\\Adem\\Desktop\\files\\product.bin" + "'");
        }

    }

    @Override
    public void read() {
        super.read();
    }

}

class DrawingTablet extends Products {
    private String checkBattery;

    DrawingTablet(String pName, String pID, int pStock, float pPrice, String type, String checkBattery) {
        super(pName, pID, pStock, pPrice, type);
        this.checkBattery = checkBattery;
    }

    public String getCheckBattery() {
        return checkBattery;
    }

    public void setCheckBattery(String checkBattery) {
        this.checkBattery = checkBattery;
    }

    @Override
    public void read() {
        super.read();
    }

    @Override
    public void write() {
        super.write();
        String fileName = "C:\\Users\\Adem\\Desktop\\files\\product.bin";
        try {
            FileOutputStream fos = new FileOutputStream(fileName);
            byte[] checkBatterybyte;
            checkBatterybyte = checkBattery.getBytes();
            fos.write(",".getBytes());
            fos.write(checkBatterybyte);
            fos.close();
        } catch (IOException ex) {
            System.out.println("Error writing to file '" + "C:\\Users\\Adem\\Desktop\\files\\product.bin" + "'");
        }
    }

}
