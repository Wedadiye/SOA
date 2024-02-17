package RestClient;


import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import models.Person;

import java.util.List;

public class RestClient {

    public static void main(String[] args) {
        // Création d'un client JAX-RS
        Client client = ClientBuilder.newClient();

        // URL du service REST
        String serviceURL = "http://localhost:8081/person"; // Modifier si nécessaire en fonction de votre service

        // Appel du service pour récupérer toutes les personnes
        Response response = client.target(serviceURL)
                .request(MediaType.APPLICATION_JSON)
                .get();

        // Vérification du code de statut de la réponse
        if (response.getStatus() == 200) {
            // Si la réponse est OK (200), récupérer les données
            List<Person> persons = response.readEntity(new GenericType<List<Person>>() {});

            // Traiter les données récupérées
            for (Person person : persons) {
                System.out.println("Person NNI: " + person.getNni() + ", Name: " + person.getNom());
                // Ajoutez ici d'autres actions à effectuer avec les données des personnes
            }
        } else {
            // Gérer d'autres codes de statut si nécessaire
            System.out.println("Erreur lors de la récupération des personnes. Code de statut : " + response.getStatus());
        }

        // Fermeture du client
        client.close();
    }
}
