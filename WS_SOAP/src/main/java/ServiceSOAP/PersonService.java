package ServiceSOAP;

import java.util.List;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import model.Personne;

@WebService
public interface PersonService {

    @WebMethod
    void addPerson(Personne person);

    @WebMethod
    Personne getPerson(int id);

    @WebMethod
    List<Personne> getAllPersons();

    @WebMethod
    void updatePerson(Personne person);

    @WebMethod
    void deletePerson(int id);
}
