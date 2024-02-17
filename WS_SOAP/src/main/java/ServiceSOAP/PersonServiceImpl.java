package ServiceSOAP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
//import java.util.Map;
import java.util.Map;

import jakarta.jws.WebService;
import model.Personne;

@WebService(endpointInterface = "ServiceSOAP.PersonService")
public class PersonServiceImpl implements PersonService {

    private Map<Integer, Personne> persons = new HashMap<>();
    private int idCounter = 1;

    @Override
    public void addPerson(Personne person) {
        person.setId(idCounter++);
        persons.put(person.getId(), person);
    }

    @Override
    public Personne getPerson(int id) {
        return persons.get(id);
    }

    @Override
    public List<Personne> getAllPersons() {
        return new ArrayList<>(persons.values());
    }

    @Override
    public void updatePerson(Personne person) {
        if (persons.containsKey(person.getId())) {
            persons.put(person.getId(), person);
        }
    }

    @Override
    public void deletePerson(int id) {
        persons.remove(id);
    }

	
}
