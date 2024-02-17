package RestImp;



import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import models.Person;
import services.PersonService;
import java.util.List;

@Path("/person")
public class PersonResource {

    private PersonService personService = new PersonService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllPersons() {
        List<Person> persons = personService.getAllPersons();
        return Response.ok(persons).build();
    }

    
    @GET
    @Path("/{nni}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPerson(@PathParam("nni") int nni) {
        Person person = personService.getPersonById(nni);
        if (person == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(person).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createPerson(Person person) {
        personService.createPerson(person);
        return Response.status(Response.Status.CREATED).entity(person).build();
    }

    @PUT
    @Path("/{nni}")
    @Consumes(MediaType.APPLICATION_JSON)

    @Produces(MediaType.APPLICATION_JSON)

    public Response updatePerson(@PathParam("nni") int nni, Person person) {
        Person existingPerson = personService.getPersonById(nni);
        if (existingPerson == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        personService.updatePerson(person);
      //        return Response.ok().build();
        return Response.ok().entity(person).build(); // Renvoyer la personne mise à jour dans la réponse

    }

    @DELETE
    @Path("/{nni}")
    public Response deletePerson(@PathParam("nni") int nni) {
        Person person = personService.getPersonById(nni);
        if (person == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        personService.deletePerson(person);
        return Response.ok().build();
    }
}

