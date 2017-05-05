package controllers;

import java.util.ArrayList;
import active_record.PersonActiveRecord;

/**
 *
 * @author Jhon Vega <jhonvegamas@gmail.com>
 */
public class PersonsController {

    private PersonActiveRecord activeRecord;

    public PersonsController() {
        this.activeRecord = new PersonActiveRecord();
    }

    public void createPerson(PersonActiveRecord person) {
        this.activeRecord.create(person);
    }

    public ArrayList<PersonActiveRecord> getAllPersons() {
        return this.activeRecord.read();
    }

    public PersonActiveRecord getPerson(int id) {
        return this.activeRecord.read().get(id-1);
    }
}
