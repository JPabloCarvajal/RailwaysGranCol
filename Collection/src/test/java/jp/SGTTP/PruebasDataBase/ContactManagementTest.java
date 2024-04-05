package jp.SGTTP.PruebasDataBase;

import jp.array.Array;
import jp.sgttp.model.domain.persons.Contact;
import jp.sgttp.model.repository.Contacts.ContactRepository;
import jp.util.iterator.Iterator;

public class ContactManagementTest {
    public static void main(String[] args) {
        // Ruta del archivo JSON de contactos
        String pathFile = "C:\\Users\\juanp\\OneDrive\\Escritorio\\RailwaysGranCol\\EDDJP\\Collection\\src\\main\\java\\jp\\sgttp\\database\\contacts.json";

        // Instancia de ContactRepository
        ContactRepository contactRepository = new ContactRepository(pathFile);

        try {
            // Agregar un nuevo contacto
            Contact newContact = new Contact("John", "Doe", new Array<>(new String[]{"123456789"}), "1234");
            boolean added = contactRepository.addContact(newContact);
            if (added) {
                System.out.println("New contact added successfully.");
            } else {
                System.out.println("Failed to add new contact.");
            }

            // Eliminar un contacto existente (suponiendo que el ID del contacto es "5678")
            String contactIdToRemove = "5678"; // Cambiar por el ID del contacto que deseas remover
            boolean removed = contactRepository.removeContact(contactIdToRemove);
            if (removed) {
                System.out.println("Contact removed successfully.");
            } else {
                System.out.println("Failed to remove contact with ID: " + contactIdToRemove);
            }

            // Modificar un contacto existente (suponiendo que el ID del contacto es "91011")
            String contactIdToModify = "91011"; // Cambiar por el ID del contacto que deseas modificar
            Contact modifiedContact = new Contact("John", "ModifiedDoe", new Array<>(new String[]{"987654321"}), contactIdToModify);
            boolean modified = contactRepository.modifyContact(contactIdToModify, modifiedContact);
            if (modified) {
                System.out.println("Contact modified successfully.");
            } else {
                System.out.println("Failed to modify contact with ID: " + contactIdToModify);
            }

            // Obtener todos los contactos como una lista enlazada y mostrarlos
            Iterator<Contact> iterator = contactRepository.getAllContactsAsLinkedList().iterator();
            System.out.println("All contacts:");
            while(iterator.hasNext()) {
                Contact contact = iterator.next();
                System.out.println(contact.toString());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

