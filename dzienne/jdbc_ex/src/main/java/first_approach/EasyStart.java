package first_approach;

import java.sql.*;

public class EasyStart {

    public static void main(String[] args)
            throws ClassNotFoundException,
            IllegalAccessException, InstantiationException, SQLException {

        Class.forName("org.sqlite.JDBC").newInstance();
        Connection conn = DriverManager.getConnection("" +
                "jdbc:sqlite:C:\\Users\\user\\git\\JavaEE2019\\persons.db");
        Statement st = conn.createStatement();
        st.execute("SELECT * FROM Person");
        ResultSet rs = st.getResultSet();
        while(rs.next()){
            System.out.print(rs.getString(4));
            System.out.print(" ");
            System.out.print(rs.getString("name"));
            System.out.print(" ");
            System.out.print(rs.getString("surname"));
            System.out.print(" ");
            System.out.println(rs.getString(3));
        }
        conn.close();
    }
}
