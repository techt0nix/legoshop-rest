package legoshop.TestThings;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;

public class BlobUploader {
    private static final String url = "jdbc:mysql://localhost:3306/legoshop";
    private static final String user = "root";
    private static final String password = "njirf14n";

    // JDBC variables for opening and managing connection
    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;

    public static void main(String[] args) throws IOException {

        File file = new File("C:\\Users\\flatl\\Desktop\\MyProjects\\lego shop\\pictures\\32254(white).jpg");
        FileInputStream fileInputStream = new FileInputStream(file);

        byte fileContent[] = new byte[(int)file.length()];
        fileInputStream.read(fileContent);

        fileInputStream.close();


        String query = "select count(*) from part_type";
        String blobQuery = "update part set image = ? where id = 3";


        try {
            con = DriverManager.getConnection(url, user, password);
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);

            PreparedStatement fd = con.prepareStatement(blobQuery);
            fd.setBytes(1, fileContent);

            if (fd.executeUpdate() != 0)
                System.out.println("success");

            while (rs.next()) {
                int count = rs.getInt(1);
                System.out.println("total number: " + count);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try { con.close(); } catch(SQLException se) { /*can't do anything */ }
            try { stmt.close(); } catch(SQLException se) { /*can't do anything */ }
            try { rs.close(); } catch(SQLException se) { /*can't do anything */ }
        }

    }
}
