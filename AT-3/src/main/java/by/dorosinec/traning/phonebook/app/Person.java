package by.dorosinec.traning.phonebook.app;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.dorosinec.traning.phonebook.util.DBWorker;

public class Person {

    private String id = "";
    private String name = "";
    private String surname = "";
    private String middlename = "";
    private HashMap<String, String> phones = new HashMap<String, String>();

    /**
     * Constructor to create a record of the person on the basis of data from the database.
     *
     * @param id         key of person
     * @param name       name of person
     * @param surname    surname of person
     * @param middlename middlename surname of person
     */
    public Person(String id, String name, String surname, String middlename) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.middlename = middlename;

        // Removing a person from the phone database.
        ResultSet db_data = DBWorker.getInstance().getDBData("SELECT * FROM `phone` WHERE `owner`=" + id);

        try {
            if (db_data != null) {
                while (db_data.next()) {
                    this.phones.put(db_data.getString("id"), db_data.getString("number"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Person() {
        this.id = "0";
        this.name = "";
        this.surname = "";
        this.middlename = "";
    }

    /**
     * Constructor for creating records intended to be added to the database.
     */
    public Person(String name, String surname, String middlename) {
        this.id = "0";
        this.name = name;
        this.surname = surname;
        this.middlename = middlename;
    }

    /**
     * Validation of parts of the name. For a middle name can be passed a second parameter == true then allowed to empty.
     *
     * @param fml_name_part name of person
     * @param empty_allowed flag, which indicates whether the is middlename
     * @return verified name
     */
    public boolean validateFMLNamePart(String fml_name_part, boolean empty_allowed) {
        if (empty_allowed) {
            Matcher matcher = Pattern.compile("[\\w-[а-яА-Я]&&[^0-9]]{0,150}").matcher(fml_name_part);
            return matcher.matches();
        } else {
            Matcher matcher = Pattern.compile("[\\w-[а-яА-Я]&&[^0-9]]{1,150}").matcher(fml_name_part);
            return matcher.matches();
        }

    }

    // ++++++++++++++++++++++++++++++++++++++
    // Геттеры и сеттеры
    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }

    public String getMiddlename() {
        if ((this.middlename != null) && (!this.middlename.equals("null"))) {
            return this.middlename;
        } else {
            return "";
        }
    }

    public HashMap<String, String> getPhones() {
        return this.phones;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public void setPhones(HashMap<String, String> phones) {
        this.phones = phones;
    }
    // Геттеры и сеттеры
    // --------------------------------------

}
