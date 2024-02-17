


import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.net.URI;

public class Main {
    public static final String BASE_URI = "http://localhost:8080/";

    public static HttpServer startServer() {
        final ResourceConfig rc = new ResourceConfig().packages("RestImp"); // Assurez-vous que "rest" est le package contenant vos ressources JAX-RS
        return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
    }

    public static void main(String[] args) {
        final HttpServer server = startServer();
        System.out.println("Serveur démarré : " + BASE_URI);
        System.out.println("Appuyez sur Ctrl+C pour arrêter...");

        try {
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            System.err.println(e);
        } finally {
            server.shutdownNow();
        }
    }
}
