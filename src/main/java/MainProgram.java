import com.sun.source.tree.WhileLoopTree;

import java.sql.SQLException;
import java.util.Scanner;

public class MainProgram {
    private DAO_Implementation obj;
    Connection con;

    MainProgram() throws SQLException, ClassNotFoundException {
        this.con = new Connection();
        this.obj = new DAO_Implementation(con.connect());
    }

    public static void main(String args[]) throws SQLException, ClassNotFoundException {
        Boolean flag = true;

        Scanner key = new Scanner(System.in);

        MainProgram obj1 = new MainProgram();

        String ans;

        System.out.println("Choose from the following options");

        while (flag) {
            System.out.println("\nEnter A to Add, D to Delete, S to Search, Di to Display, E to Edit, Ex to Exit");

            ans = key.nextLine();

            if (ans.equals("A")) {
                obj1.addingdata();
            }

        }
    }

    private void addingdata() throws SQLException, ClassNotFoundException {

        String catcode, catdesc;
        Category cat, catr;

        Scanner key = new Scanner(System.in);

        System.out.println("Enter a category code ");
        catcode = key.nextLine();

        catr = obj.search(catcode);

        if (!(catr == null)) {
            System.out.println("Please use another number");

            return;
        } else {
            System.out.print(" yet, this is a new record\n");
        }

        System.out.println("Enter a Category description");
        catdesc = key.nextLine();

        cat = new Category(catcode, catdesc);

        if (obj.search(catcode) == null) {
            obj.add(cat);
            obj.display();
        }
    }
}
