import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Register {
    String cName;
    String cID;
    String cPass;

    int ln;

    public Register(String cName, String cID, String cPass) {
        this.cID = cID;
        this.cName = cName;
        this.cPass = cPass;
    }

    @Override
    public String toString() {
        String write = "";
        write += "Username:" + this.cID + "\n";
        write += "Password:" + this.cPass + "\n";
        write += "Name:" + this.cName + "\n";
        return write;
    }

    private static ArrayList<Register> users = new ArrayList<Register>();

    public static ArrayList<Register> getUsers() {
        return users;
    }

    void write() {
        try {
            File file = new File("C:\\Users\\Adem\\Desktop\\files\\customer.txt");
            FileWriter fileWriter = new FileWriter(file, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Register temp : users) {
                bufferedWriter.write(temp.toString());
                bufferedWriter.write("\n");
            }
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException ex) {
            System.out.println("Error writing to file '" + "C:\\Users\\Adem\\Desktop\\files\\customer.txt" + "'");
        }
    }
}