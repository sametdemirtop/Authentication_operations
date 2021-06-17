import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int button;
    static int button2;
    static ArrayList<Register> users1 = Register.getUsers();
    static ArrayList<Products> products = Products.getProducts();
    static ArrayList<Products> products2 = new ArrayList<Products>();
    static ArrayList<Purchasing> purchasings = Purchasing.getPurchasings();
    static Purchasing pAll = new Purchasing();
    static int ln;

    public static void main(String[] args) {
        getLineNumbers();
        initializeProducts();
        boolean control = false;
        Scanner sc1 = new Scanner(System.in);
        menu();
        while (control == false) {
            button2 = sc1.nextInt();
            switch (button2) {
                case 0: {
                    System.out.print("exiting the system.");
                    control = true;
                    break;
                }
                case 1: {
                    System.out.println("You can register");
                    Scanner input = new Scanner(System.in);
                    System.out.println("Enter your name");
                    String cName = input.nextLine();
                    System.out.println("Enter your username");
                    String cID = input.nextLine();
                    System.out.println("Enter your password");
                    String cPass = input.nextLine();
                    Register r1 = new Register(cName, cID, cPass);
                    users1.add(r1);
                    r1.write();
                    System.out.println("Succesfully Registered.");
                    menu();
                    break;
                }
                case 2: {
                    checkData();
                    break;
                }
                default:
                    System.out.println("Enter the value between 0-2");
                    break;

            }
        }
        sc1.close();
    }

    private static void initializeProducts() {
        Tv tv = new Tv("SamsungTV", "smsng", 10, 30.0f, "Tv", "26inç");
        Tv tv1 = new Tv("VestelTV", "vstl", 10, 30.0f, "Tv", "32inç");

        Telephone telephone = new Telephone("XiaomiPhone", "mi", 10, 30.0f, "Telephone", "32megapixel");
        Telephone telephone1 = new Telephone("HuaweiPhone", "hwi", 10, 30.0f, "Telephone", "16megapixel");

        DrawingTablet drawingTablet = new DrawingTablet("AppleTablet", "apple", 10, 30.0f, "DrawingTablet",
                "haspenbattery");
        DrawingTablet drawingTablet1 = new DrawingTablet("OppoTablet", "oppo", 10, 30.0f, "DrawingTablet",
                "hasntpenbattery");
        products.add(tv);
        products.add(tv1);
        products.add(telephone);
        products.add(telephone1);
        products.add(drawingTablet);
        products.add(drawingTablet1);
        Products pro = new Products();
        pro.write();
    }

    private static void checkData() {
        try {
            System.out.println("You can sign-in");
            Scanner input2 = new Scanner(System.in);
            System.out.println("Enter your username");
            String usr = input2.nextLine();
            System.out.println("Enter your password");
            String pass = input2.nextLine();
            RandomAccessFile randomAccessFile = new RandomAccessFile("C:\\Users\\Adem\\Desktop\\files\\customer.txt",
                    "rw");
            for (int i = 0; i < ln; i += 4) {
                String forUser = randomAccessFile.readLine().substring(9);
                String forPswd = randomAccessFile.readLine().substring(9);
                if (usr.equals(forUser) & pass.equals(forPswd)) {
                    boolean control1 = false;
                    Scanner sc2 = new Scanner(System.in);
                    secondMenu();
                    String customerID;
                    String productID;
                    String productName;
                    while (control1 == false) {

                        button = sc2.nextInt();
                        switch (button) {
                            case 0: {
                                System.out.print("exiting the system.");
                                control1 = true;
                                break;
                            }
                            case 1: {
                                String ID = "smsng";
                                int index;
                                int k;
                                for (k = 0; k < products.size(); k++) {
                                    if (ID.equals(products.get(k).getpID())) {
                                        products.get(k).read();
                                        index = k;
                                        customerID = usr;
                                        productID = products.get(index).getpID();
                                        productName = products.get(index).getpName();
                                        Purchasing p1 = new Purchasing(customerID, productID, productName);
                                        if (purchasings.contains(p1) == false) {
                                            purchasings.add(p1);
                                        }

                                    }
                                }

                                break;
                            }
                            case 2: {
                                String ID1 = "vstl";
                                int index1;
                                int k1;
                                for (k1 = 0; k1 < products.size(); k1++) {
                                    if (ID1.equals(products.get(k1).getpID())) {
                                        products.get(k1).read();
                                        index1 = k1;
                                        customerID = usr;
                                        productID = products.get(index1).getpID();
                                        productName = products.get(index1).getpName();
                                        Purchasing p2 = new Purchasing(customerID, productID, productName);
                                        if (purchasings.contains(p2) == false) {
                                            purchasings.add(p2);
                                        }

                                    }

                                }
                                break;
                            }
                            case 3: {
                                String ID2 = "mi";
                                int index2;
                                int k2;
                                for (k2 = 0; k2 < products.size(); k2++) {
                                    if (ID2.equals(products.get(k2).getpID())) {
                                        products.get(k2).read();
                                        index2 = k2;
                                        customerID = usr;
                                        productID = products.get(index2).getpID();
                                        productName = products.get(index2).getpName();
                                        Purchasing p3 = new Purchasing(customerID, productID, productName);
                                        if (purchasings.contains(p3) == false) {
                                            purchasings.add(p3);
                                        }

                                    }

                                }
                                break;
                            }
                            case 4: {
                                String ID3 = "hwi";
                                int index3;
                                int k3;
                                for (k3 = 0; k3 < products.size(); k3++) {
                                    if (ID3.equals(products.get(k3).getpID())) {
                                        products.get(k3).read();
                                        index3 = k3;
                                        customerID = usr;
                                        productID = products.get(index3).getpID();
                                        productName = products.get(index3).getpName();
                                        Purchasing p4 = new Purchasing(customerID, productID, productName);
                                        if (purchasings.contains(p4) == false) {
                                            purchasings.add(p4);
                                        }

                                    }

                                }
                                break;
                            }
                            case 5: {
                                String ID4 = "apple";
                                int index4;
                                int k4;
                                for (k4 = 0; k4 < products.size(); k4++) {
                                    if (ID4.equals(products.get(k4).getpID())) {
                                        products.get(k4).read();
                                        index4 = k4;
                                        customerID = usr;
                                        productID = products.get(index4).getpID();
                                        productName = products.get(index4).getpName();
                                        Purchasing p5 = new Purchasing(customerID, productID, productName);
                                        if (purchasings.contains(p5) == false) {
                                            purchasings.add(p5);
                                        }

                                    }

                                }
                                break;
                            }
                            case 6: {
                                String ID5 = "oppo";
                                int index5;
                                int k5;
                                for (k5 = 0; k5 < products.size(); k5++) {
                                    if (ID5.equals(products.get(k5).getpID())) {
                                        products.get(k5).read();
                                        index5 = k5;
                                        customerID = usr;
                                        productID = products.get(index5).getpID();
                                        productName = products.get(index5).getpName();
                                        Purchasing p6 = new Purchasing(customerID, productID, productName);
                                        if (purchasings.contains(p6) == false) {
                                            purchasings.add(p6);
                                        }

                                    }

                                }
                                break;
                            }
                            case 7: {
                                pAll.write();
                                readPastOrders(usr);
                                break;
                            }
                            default:
                                System.out.println("Enter the value between 0-7");
                                break;
                        }

                    }
                    sc2.close();

                    break;
                } else if (i == (ln - 3)) {
                    System.out.println("girmedi");
                    break;
                }
                for (int space = 1; space <= 2; space++) {
                    randomAccessFile.readLine();
                }

            }
            randomAccessFile.close();
            input2.close();
        } catch (IOException ex) {
            System.out.println("Error writing to file '" + "C:\\Users\\Adem\\Desktop\\files\\customer.txt" + "'");
        }
    }

    private static void readPastOrders(String usr) {
        try {
            String fileName = "C:\\Users\\Adem\\Desktop\\files\\purchases.txt";
            Scanner scan = new Scanner(new File(fileName));
            while (scan.hasNext()) {
                String line = scan.nextLine().toString();
                if (line.contains(usr)) {
                    System.out.println(line);
                }
            }

        } catch (IOException ex) {
            System.out.println("Error writing to file '" + "C:\\Users\\Adem\\Desktop\\files\\purchases.txt" + "'");
        }
    }

    private static void secondMenu() {
        System.out.println("*******Welcome to our Store*******");
        System.out.println("You can choose and buy the products what you want.");
        System.out.println("1-buy Samsung tv which is 26inç ");
        System.out.println("2-buy Vestel tv which is 32inç");
        System.out.println("3-buy Xiaomi phone which is 32megapixel");
        System.out.println("4-buy Huawei phone which is 16megapixel");
        System.out.println("5-buy Apple DrawingTablet which has penbattery");
        System.out.println("6-buy Oppo DrawingTablet which hasn't penbattery");
        System.out.println("7-My Past Orders");
        System.out.println("0-Exiting system");
    }

    private static void menu() {
        System.out.println("*******Welcome to our Store*******");
        System.out.println("if you dont have an acoount , please register");
        System.out.println("1-Register");
        System.out.println("2-Sign in");
        System.out.println("0-Exiting system");
    }

    private static void getLineNumbers() {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile("C:\\Users\\Adem\\Desktop\\files\\customer.txt",
                    "rw");
            while (randomAccessFile.readLine() != null) {
                ln++;
                // to see what is linenumbers
                // System.out.println("ln =" + ln);
            }
            randomAccessFile.close();
        } catch (IOException ex) {
            System.out.println("Error writing to file '" + "C:\\Users\\Adem\\Desktop\\files\\customer.txt" + "'");
        }
    }

}
