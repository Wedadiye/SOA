package ServiceClient;


import model.Personne;
import ServiceSOAP.PersonService;
import jakarta.xml.ws.Service;
import java.net.URL;

public class PersonServiceClient {
    public static void main(String[] args) {
        try {
            // Créez l'URL du service web
            URL url = new URL("http://localhost:8083/personService?wsdl");

            // Créez un objet Service à partir de l'URL et du nom du service
            Service service = Service.create(url, new javax.xml.namespace.QName("http://ServiceSOAP/", "PersonServiceImplService"));

            // Obtenez le port du service
            PersonService personService = service.getPort(PersonService.class);

            // Utilisez les méthodes exposées par le service web
            // Ajouter une personne
            Personne newPerson = new Personne();
            newPerson.setNom("Sejad");
            //newPerson.setId(3);
            // Ajoutez la personne en utilisant le service web
            personService.addPerson(newPerson);

            // Obtenez une personne par son identifiant
            Personne retrievedPerson = personService.getPerson(1);
            System.out.println("Personne récupérée : " + retrievedPerson.getNom());

            // Obtenez toutes les personnes
            for (Personne person : personService.getAllPersons()) {
                System.out.println("Nom : " + person.getNom() + ", ID : " + person.getId());
            }

            // Mettez à jour une personne existante
            //retrievedPerson.setId(3);
            //personService.updatePerson(retrievedPerson);

            // Supprimez une personne
            //personService.deletePerson(3);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

