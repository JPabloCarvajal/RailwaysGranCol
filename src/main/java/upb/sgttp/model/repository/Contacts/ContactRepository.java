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
        ContactEntity[] contactEntities = fileJson.getObjects(pathFile, ContactEntity[].class);

        if (contactEntities == null) {
            contactEntities = new ContactEntity[0];
        }

        ContactEntity newContactEntity = new ContactEntity(
                contact.getNames(),
                contact.getLastNames(),
                contact.getPhoneNumbers(),
                contact.getContactId()
        );

        Array<ContactEntity> updatedContactEntities = new Array<>(contactEntities.length + 1);
        for (ContactEntity entity : contactEntities) {
            updatedContactEntities.add(entity);
        }
        updatedContactEntities.add(newContactEntity);

        ContactEntity[] updatedContactEntitiesArray = new ContactEntity[updatedContactEntities.size()];
        for (int i = 0; i < updatedContactEntities.size(); i++) {
            updatedContactEntitiesArray[i] = updatedContactEntities.get(i);
        }

        return fileJson.writeObjects(pathFile, updatedContactEntitiesArray);
    }

    public boolean removeContact(String contactId) {
        ContactEntity[] contactEntities = fileJson.getObjects(pathFile, ContactEntity[].class);

        int indexToRemove = -1;
        for (int i = 0; i < contactEntities.length; i++) {
            if (contactEntities[i].getContactId().equals(contactId)) {
                indexToRemove = i;
                break;
            }
        }

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
            return false;
        }
    }

    public boolean modifyContact(String contactId, Contact modifiedContact) {
        ContactEntity[] contactEntities = fileJson.getObjects(pathFile, ContactEntity[].class);

        int indexToModify = -1;
        for (int i = 0; i < contactEntities.length; i++) {
            if (contactEntities[i].getContactId().equals(contactId)) {
                indexToModify = i;
                break;
            }
        }

        if (indexToModify != -1) {
            contactEntities[indexToModify].setNames(modifiedContact.getNames());
            contactEntities[indexToModify].setLastNames(modifiedContact.getLastNames());
            contactEntities[indexToModify].setPhoneNumbers(modifiedContact.getPhoneNumbers());

            return fileJson.writeObjects(pathFile, contactEntities);
        } else {
            return false;
        }
    }

    public LinkedList<Contact> getAllContactsAsLinkedList() {
        ContactEntity[] contactEntities = fileJson.getObjects(pathFile, ContactEntity[].class);

        LinkedList<Contact> contactList = new LinkedList<>();

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

        return fileJson.writeObjects(pathFile, modifiedContactEntities);
    }
}
