package khentbayut;

import java.sql.*;

public class Connect {

    Connection c;
    Statement s;
    Connect() {
        try {
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/arth", "arth", "arth123");
            s = c.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
