import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        try {

            String url = "jdbc:mysql://localhost:3306/sys";
            String un = "root";
            String pw = "root1234";
            Connection connection = DriverManager.getConnection(url, un, pw); //used to establish a connection to the database done through the connection class but not as a new instance but a method of driver manager which contain takes the db credentials as parameters

            //create a statement, this interface represents a SQL statement created using the connection class
            Statement statement = connection.createStatement();

            //result set represents the set of results returned from the database
            ResultSet resultSet = statement.executeQuery("SELECT * FROM juniorstudents;");

            //use a while block to iterate and print the elements within the selected table
            //the next function of resultset is used to check whether an element is available, this returns a boolean
            while(resultSet.next()){
                System.out.print(resultSet.getInt("id") );
                System.out.print(resultSet.getString("name") + "\n");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}