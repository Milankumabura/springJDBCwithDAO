//Class.forName()

import java.sql.DriverManager;

public class DemoClass {
    public static void main(String[] args) throws Exception {
        //Pqr obj = new Pqr();
        //Class.forName("Pqr");
        //Class.forName("Pqr").newInstance();
        //DriverManager.registerDriver(new org.postgresql.Driver());
        Class.forName("org.postgresql.Driver");

    }
}

class Pqr {
    static//it loads when class is loaded
    {
        System.out.println("in static");
    }

    {
        System.out.println("in instance");
    }
}
