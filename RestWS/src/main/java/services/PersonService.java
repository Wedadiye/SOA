package services;

import dao.PersonDao;
import models.Person;
import java.util.List;

public class PersonService {

    private PersonDao personDao = new PersonDao();

    public List<Person> getAllPersons() {
        return personDao.getAll();
    }

    public Person getPersonById(int id) {
        return personDao.getById(id);
    }

    public void createPerson(Person person) {
        personDao.save(person);
    }

    public void updatePerson(Person person) {
        personDao.update(person);
    }

    public void deletePerson(Person person) {
        personDao.delete(person);
    }
}

