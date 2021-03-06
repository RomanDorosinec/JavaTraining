package by.dorosinec.traning.phonebook.app;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import by.dorosinec.traning.phonebook.util.DBWorker;

public class Phonebook {
    private HashMap<String, Person> persons = new HashMap<String, Person>();
    private DBWorker db = DBWorker.getInstance();
    private static Phonebook instance = null;

    /**
     * Method for the instance (implemented Singleton).
     *
     * @return object of class phonebook
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static Phonebook getInstance() throws ClassNotFoundException, SQLException {
        if (instance == null) {
            instance = new Phonebook();
        }

        return instance;
    }

    /**
     * When you create an instance of a class is retrieved from the database all the records.
     *
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    protected Phonebook() throws ClassNotFoundException, SQLException {
        ResultSet db_data = this.db.getDBData("SELECT * FROM `person` ORDER BY `surname` ASC");
        while (db_data.next()) {
            this.persons.put(db_data.getString("id"), new Person(db_data.getString("id"), db_data.getString("name"), db_data.getString("surname"), db_data.getString("middlename")));
        }
    }

    /**
     * Addition of the person recording.
     *
     * @param person object of class person
     * @return true - if record is added, false - if record is not add
     */
    public boolean addPerson(Person person) {
        ResultSet db_result;
        String query;

        // A person may not be a patronymic.
        if (!person.getSurname().equals("")) {
            query = "INSERT INTO `person` (`name`, `surname`, `middlename`) VALUES ('" + person.getName() + "', '" + person.getSurname() + "', '" + person.getMiddlename() + "')";
        } else {
            query = "INSERT INTO `person` (`name`, `surname`) VALUES ('" + person.getName() + "', '" + person.getSurname() + "')";
        }
        Integer affected_rows = this.db.changeDBData(query);
        if (affected_rows > 0) {
            person.setId(this.db.getLastInsertId().toString());
            this.persons.put(person.getId(), person);

            return true;
        } else {
            return false;
        }
    }


    /**
     * Updating of the person recording.
     *
     * @param id     key of person
     * @param person object of class person
     * @return true - if record is update, false - if record is not update
     */
    public boolean updatePerson(String id, Person person) {
        Integer id_filtered = Integer.parseInt(person.getId());
        String query = "";

        // A person may not be a patronymic.
        if (!person.getSurname().equals("")) {
            query = "UPDATE `person` SET `name` = '" + person.getName() + "', `surname` = '" + person.getSurname() + "', `middlename` = '" + person.getMiddlename() + "' WHERE `id` = " + id_filtered;
        } else {
            query = "UPDATE `person` SET `name` = '" + person.getName() + "', `surname` = '" + person.getSurname() + "' WHERE `id` = " + id_filtered;
        }
        Integer affected_rows = this.db.changeDBData(query);
        if (affected_rows > 0) {
            this.persons.put(person.getId(), person);
            return true;
        } else {
            return false;
        }
    }


    /**
     * Delete of the person recording.
     *
     * @param id key of person
     * @return true - if record is delete, false - if record is not delete
     */
    public boolean deletePerson(String id) {
        if ((id != null) && (!id.equals("null"))) {
            int filtered_id = Integer.parseInt(id);
            Integer affected_rows = this.db.changeDBData("DELETE FROM `person` WHERE `id`=" + filtered_id);
            if (affected_rows > 0) {
                this.persons.remove(id);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public HashMap<String, Person> getContents() {
        return persons;
    }

    public Person getPerson(String id) {
        return this.persons.get(id);
    }
}
