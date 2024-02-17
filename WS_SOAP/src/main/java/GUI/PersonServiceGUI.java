package GUI;


import javax.swing.*;

import jakarta.xml.ws.Service;
import model.Personne;
import ServiceSOAP.PersonService;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class PersonServiceGUI extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField idField, nameField;
    private JLabel idLabel, nomLabel;
    private JButton addButton, getButton, updateButton, deleteButton;
    private JTextArea outputArea;


// Remplacez PersonServiceImplService par le nom de votre service
    private PersonService personService; // Remplacez PersonService par le nom de votre service

    public PersonServiceGUI() {
        setTitle("Person Service Tester");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        
        getContentPane().add(panel);
        
        
        idLabel = new JLabel("ID:");
        
        panel.add(idLabel);


        idField = new JTextField(15); // Assurez-vous que cette ligne est bien ajoutée
        panel.add(idField);
        
        nomLabel = new JLabel("NOM:");
        
        panel.add(nomLabel);

        nameField = new JTextField(15); // Assurez-vous que cette ligne est bien ajoutée
        panel.add(nameField);
        addButton = new JButton("Ajouter");
        panel.add(addButton);

        getButton = new JButton("Obtenir");
        panel.add(getButton);

        updateButton = new JButton("Mettre à jour");
        panel.add(updateButton);

        deleteButton = new JButton("Supprimer");
        panel.add(deleteButton);

        outputArea = new JTextArea(10, 30);
        panel.add(new JScrollPane(outputArea));


        
        try {
            URL url = new URL("http://localhost:8083/personService?wsdl");
            Service service = Service.create(url, new javax.xml.namespace.QName("http://service/", "PersonServiceImplService"));
            personService = service.getPort(PersonService.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // ... (le reste du code est similaire à l'exemple précédent)
        // ...

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Appeler la méthode addPerson du service web avec les valeurs des champs
                String name = nameField.getText();
 
                Personne person = new Personne();
                person.setNom(name);
               

                personService.addPerson(person);
                outputArea.setText("Person added successfully!");
            }
        });

        getButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Appeler la méthode getPerson du service web avec l'ID du champ idField
                int id = Integer.parseInt(idField.getText());

                Personne person = personService.getPerson(id);
                if (person != null) {
                    outputArea.setText("Person found: ID: " + person.getId() + ", Name: " + person.getNom() );
                } else {
                    outputArea.setText("Person with ID " + id + " not found!");
                }
            }
        });

        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Appeler la méthode updatePerson du service web avec les valeurs des champs
                int id = Integer.parseInt(idField.getText());
                String name = nameField.getText();

                Personne person = personService.getPerson(id);
                if (person != null) {
                    person.setNom(name);
                    
                    personService.updatePerson(person);
                    outputArea.setText("Person updated successfully!");
                } else {
                    outputArea.setText("Person with ID " + id + " not found!");
                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Appeler la méthode deletePerson du service web avec l'ID du champ idField
                int id = Integer.parseInt(idField.getText());

                personService.deletePerson(id);
                outputArea.setText("Person deleted successfully!");
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new PersonServiceGUI();
            }
        });
    }
}