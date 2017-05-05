package tests;

import controllers.PersonsController;
import active_record.PersonActiveRecord;

/**
 *
 * @author Jhon Vega <jhonvegamas@gmail.com>
 */
public class PersonTest {

    public static void main(String[] args) {
        PersonActiveRecord person = new PersonActiveRecord();
        person.createPerson(1, "Active Record", "activerecord@mail.com");

        PersonsController controller = new PersonsController();
        controller.createPerson(person);

        System.out.println(
                controller.getPerson(1).getId()+ " "
                + controller.getPerson(1).getName() + " "
                + controller.getPerson(1).getEmail()
        );

    }
}
