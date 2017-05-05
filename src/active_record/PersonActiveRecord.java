package active_record;

import connection.ConnectionMySQL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Jhon Vega <jhonvegamas@gmail.com>
 */
public class PersonActiveRecord {

    private int id;
    private String name;
    private String email;
    private ConnectionMySQL db;

    public void createPerson(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void create(PersonActiveRecord person) {
        try {
            this.db = new ConnectionMySQL();
            String query = "insert into persons (id, name, email) values (?, ?, ?)";
            PreparedStatement preparedStmt = this.db.getConnection().prepareStatement(query);
            preparedStmt.setInt(1, person.getId());
            preparedStmt.setString(2, person.getName());
            preparedStmt.setString(3, person.getEmail());

            preparedStmt.execute();

            this.db.getConnection().close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public ArrayList<PersonActiveRecord> read() {
        try {
            this.db = new ConnectionMySQL();
            String query = "select * from persons";
            ArrayList<PersonActiveRecord> persons = new ArrayList<>();
            Statement statement = this.db.getConnection().createStatement();
            ResultSet result = statement.executeQuery(query);
            while (result.next()) {
                PersonActiveRecord person = new PersonActiveRecord();
                person.createPerson(
                        result.getInt("id"),
                        result.getString("name"),
                        result.getString("email")
                );
                persons.add(person);
            }
            return persons;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public void update(PersonActiveRecord person) { 
        //Code....
    }

    public void delete(PersonActiveRecord person) {        
        //Code....
    }
}
