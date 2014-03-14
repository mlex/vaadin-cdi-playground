package de.codecentric.mjl.contacts;

import com.vaadin.cdi.CDIView;
import com.vaadin.data.Container;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.*;
import org.vaadin.addon.cdimvp.AbstractMVPView;
import org.vaadin.addon.cdiproperties.annotation.ButtonProperties;
import org.vaadin.addon.cdiproperties.annotation.TableProperties;
import org.vaadin.addon.cdiproperties.annotation.TextFieldProperties;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.logging.Logger;

@CDIView(ContactsView.NAME)
public class ContactsViewImpl extends AbstractMVPView implements ContactsView {
    private static final Logger LOGGER = Logger.getLogger(ContactsViewImpl.class.getName());


    @Inject
    @TextFieldProperties(caption = "Suchbegriff")
    private TextField searchField;

    @Inject
    @ButtonProperties(caption = "Suchen")
    private Button searchButton;

    @Inject
    @TableProperties(caption = "Kontakte")
    private Table contactsTable;

    @PostConstruct
    public void setup() {
        searchButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                fireViewEvent(ContactsPresenter.SEARCH_CALENDAR, searchField.getValue());
            }
        });
        contactsTable.addContainerProperty("name", String.class, "");
        contactsTable.addContainerProperty("email", String.class, "");

        setCompositionRoot(
                new HorizontalLayout(
                        new VerticalLayout(searchField, searchButton),
                        contactsTable));
    }

    @Override
    public Container getContainer() {
        return contactsTable.getContainerDataSource();
    }

    @Override
    public String getSearchTerm() {
        return searchField.getValue();
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        enter();
    }
}
