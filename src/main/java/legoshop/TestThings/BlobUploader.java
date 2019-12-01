package legoshop.TestThings;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;

/**
 * Утилита для кодировки и загрузки картинок в виде blob в базу данных
 */

public class BlobUploader {
    private static final String url = "jdbc:mysql://localhost:3306/legoshop";
    private static final String user = "root";
    private static final String password = "njirf14n";
    private static final String partBlobQuery = "update part set image = ? where img_name = ?";
    private static final String categoryBlobQuery = "update part_category set image = ? where img_name = ?";

    // JDBC variables for opening and managing connection
    private static Connection con;

    public static void main(String[] args) throws IOException {


        try {
            con = DriverManager.getConnection(url, user, password);


            File picsToUploadDirectory = new File("C:\\Users\\flatl\\Desktop\\MyProjects\\lego shop\\pictures\\");
            File[] files = picsToUploadDirectory.listFiles();

            System.out.println("total files to upload: " + files.length);
            int uploadedCounter = 0;

            for (File pic : files) {
                String fileName = pic.getName();
                System.out.println(fileName);
                FileInputStream fis = new FileInputStream(pic);
                byte content[] = new byte[(int)pic.length()];
                fis.read(content);
                fis.close();

                PreparedStatement preparedStatement = con.prepareStatement(partBlobQuery);
                preparedStatement.setBytes(1, content);
                preparedStatement.setString(2,fileName);

                if (preparedStatement.executeUpdate() != 0) {
                    System.out.println("successfully uploaded");
                    uploadedCounter++;
                }
            }

            System.out.println("file uploaded succesfully: " + uploadedCounter);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try { con.close(); } catch(SQLException se) { /*can't do anything */ }
        }

    }
}
