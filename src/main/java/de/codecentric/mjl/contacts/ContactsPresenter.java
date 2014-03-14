package de.codecentric.mjl.contacts;

import com.vaadin.data.Item;
import de.codecentric.mjl.model.Contact;
import org.vaadin.addon.cdimvp.AbstractMVPPresenter;
import org.vaadin.addon.cdimvp.CDIEvent;
import org.vaadin.addon.cdimvp.ParameterDTO;

import javax.enterprise.event.Observes;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.logging.Logger;

@AbstractMVPPresenter.ViewInterface(ContactsView.class)
public class ContactsPresenter extends AbstractMVPPresenter<ContactsView> {
    private static final Logger LOGGER = Logger.getLogger(ContactsPresenter.class.getName());

    public static final String SEARCH_CALENDAR = "SEARCH_CALENDAR";

    private List<Contact> contacts = new CopyOnWriteArrayList<Contact>();

    public ContactsPresenter() {
        contacts.add(new Contact("Max Mustermann", "max.mustermann@localhost.local"));
        contacts.add(new Contact("Maria Musterfrau", "maria.musterfrau@localhost.local"));
    }

    @Override
    public void viewEntered() {
        updateDisplayedContacts(view.getSearchTerm());
    }

    public void filterContacts(@Observes @CDIEvent(SEARCH_CALENDAR) ParameterDTO parameter) {
        updateDisplayedContacts((String) parameter.getPrimaryParameter());
    }

    private void updateDisplayedContacts(String searchString) {
        view.getContainer().removeAllItems();
        for (Contact contact : contacts) {
            if (contact.getName().contains(searchString)) {
                Item item = view.getContainer().addItem(contact.getId());
                item.getItemProperty("name").setValue(contact.getName());
                item.getItemProperty("email").setValue(contact.getName());
            }
        }
    }

}
