
package kata5.dbpersistence;

import kata5.dbpersistence.PeopleLoader;
import kata5.model.Person;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class SqlitePeopleLoader implements PeopleLoader {
    @Override
    public List<Person> load() {
        List<Person> lista = new ArrayList();
        try {
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection("jdbc:sqlite:data/us500.db");
            Statement statement = connection.createStatement();
            ResultSet set = statement.executeQuery("SELECT * FROM people");
            while(set.next()){
                String name = set.getString("first_name")+set.getString("last_name");
                String address = set.getString("address");
                String email = set.getString("email");
                lista.add(new Person(name, address, email));
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Error:ClassNotFoundException" + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Error:SQLException" + ex.getMessage());
        }
        return lista;
    }

}
