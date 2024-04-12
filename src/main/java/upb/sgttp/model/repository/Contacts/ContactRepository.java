package upb.sgttp.model.repository.Contacts;

import jp.array.Array;
import jp.linkedlist.singly.LinkedList;
import upb.sgttp.model.domain.persons.Contact;
import upb.sgttp.shared.filejsonadapter.FileJsonAdapter;
import upb.sgttp.shared.filejsonadapter.FileJsonInterface;

public class ContactRepository {

    private FileJsonInterface<ContactEntity> fileJson;
    private String pathFile;

    public ContactRepository(String pathFile) {
        this.pathFile = pathFile;
        this.fileJson = FileJsonAdapter.getInstance();
    }

    public boolean addContact(Contact contact) {
        // Obtener todos los contactos del archivo JSON
        ContactEntity[] contactEntities = fileJson.getObjects(pathFile, ContactEntity[].class);

        // Verificar si contactEntities es null antes de continuar
        if (contactEntities == null) {
            contactEntities = new ContactEntity[0]; // Si es null, asignamos un array vacío
        }

        // Crear una nueva instancia de ContactEntity a partir del contacto proporcionado
        ContactEntity newContactEntity = new ContactEntity(
                contact.getNames(),
                contact.getLastNames(),
                contact.getPhoneNumbers(),
                contact.getContactId()
        );

        // Crear un nuevo array para almacenar todos los contactos, incluido el nuevo contacto
        Array<ContactEntity> updatedContactEntities = new Array<>(contactEntities.length + 1);
        for (ContactEntity entity : contactEntities) {
            updatedContactEntities.add(entity);
        }
        updatedContactEntities.add(newContactEntity);

        // Convertir el Array<ContactEntity> a un array regular de ContactEntity[]
        ContactEntity[] updatedContactEntitiesArray = new ContactEntity[updatedContactEntities.size()];
        for (int i = 0; i < updatedContactEntities.size(); i++) {
            updatedContactEntitiesArray[i] = updatedContactEntities.get(i);
        }

        return fileJson.writeObjects(pathFile, updatedContactEntitiesArray);
    }

    public boolean removeContact(String contactId) {
        // Obtener todos los contactos del archivo JSON
        ContactEntity[] contactEntities = fileJson.getObjects(pathFile, ContactEntity[].class);

        // Buscar el contacto con el ID especificado
        int indexToRemove = -1;
        for (int i = 0; i < contactEntities.length; i++) {
            if (contactEntities[i].getContactId().equals(contactId)) {
                indexToRemove = i;
                break;
            }
        }

        // Si se encontró el contacto, eliminarlo y escribir de nuevo los contactos actualizados en el archivo JSON
        if (indexToRemove != -1) {
            Array<ContactEntity> updatedContactEntities = new Array<>(contactEntities.length - 1);
            for (int i = 0; i < contactEntities.length; i++) {
                if (i != indexToRemove) {
                    updatedContactEntities.add(contactEntities[i]);
                }
            }

            ContactEntity[] updatedContactEntitiesArray = new ContactEntity[updatedContactEntities.size()];
            for (int i = 0; i < updatedContactEntities.size(); i++) {
                updatedContactEntitiesArray[i] = updatedContactEntities.get(i);
            }

            return fileJson.writeObjects(pathFile, updatedContactEntitiesArray);
        } else {
            // Si no se encontró el contacto con el ID especificado, devolver false
            return false;
        }
    }

    public boolean modifyContact(String contactId, Contact modifiedContact) {
        // Obtener todos los contactos del archivo JSON
        ContactEntity[] contactEntities = fileJson.getObjects(pathFile, ContactEntity[].class);

        // Buscar el contacto con el ID especificado
        int indexToModify = -1;
        for (int i = 0; i < contactEntities.length; i++) {
            if (contactEntities[i].getContactId().equals(contactId)) {
                indexToModify = i;
                break;
            }
        }

        // Si se encontró el contacto, modificarlo y escribir de nuevo los contactos actualizados en el archivo JSON
        if (indexToModify != -1) {
            contactEntities[indexToModify].setNames(modifiedContact.getNames());
            contactEntities[indexToModify].setLastNames(modifiedContact.getLastNames());
            contactEntities[indexToModify].setPhoneNumbers(modifiedContact.getPhoneNumbers());

            return fileJson.writeObjects(pathFile, contactEntities);
        } else {
            // Si no se encontró el contacto con el ID especificado, devolver false
            return false;
        }
    }

    public LinkedList<Contact> getAllContactsAsLinkedList() {
        // Obtener todos los contactos del archivo JSON
        ContactEntity[] contactEntities = fileJson.getObjects(pathFile, ContactEntity[].class);

        // Crear una lista enlazada para almacenar los contactos
        LinkedList<Contact> contactList = new LinkedList<>();

        // Agregar cada contacto a la lista enlazada
        for (ContactEntity entity : contactEntities) {
            Contact contact = new Contact(
                    entity.getNames(),
                    entity.getLastNames(),
                    entity.getPhoneNumbers(),
                    entity.getContactId()
            );
            contactList.add(contact);
        }

        return contactList;
    }

    public boolean modifyContact(LinkedList<Contact> modifiedContacts) {
        // Convertir la LinkedList a un arreglo de ContactEntity
        ContactEntity[] modifiedContactEntities = new ContactEntity[modifiedContacts.size()];
        for (int i = 0; i < modifiedContacts.size(); i++) {
            Contact contact = modifiedContacts.get(i);
            modifiedContactEntities[i] = new ContactEntity(
                    contact.getNames(),
                    contact.getLastNames(),
                    contact.getPhoneNumbers(),
                    contact.getContactId()
            );
        }

        // Escribir los nuevos objetos en el archivo JSON
        return fileJson.writeObjects(pathFile, modifiedContactEntities);
    }
}
