import java.sql.*;

public class TestJDBC {
    public static void main(String[] args) throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection cx = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/test",
                "bicho",
                "");
        Statement st = cx.createStatement();
        ResultSet rs = st.executeQuery("SELECT first_name,location FROM users;");
        while (rs.next()) {
            String nom = rs.getString("first_name");
            String location = rs.getString("location");
            System.out.println(nom + " lives in " + location);
        }
        rs.close();
        st.close();
        cx.close();
    }
}