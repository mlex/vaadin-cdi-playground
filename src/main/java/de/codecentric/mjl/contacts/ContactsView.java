package de.codecentric.mjl.contacts;

import com.vaadin.data.Container;
import com.vaadin.navigator.View;
import com.vaadin.ui.Component;
import org.vaadin.addon.cdimvp.MVPView;

public interface ContactsView extends MVPView, View, Component {
    public static final String NAME = "contacts";

    void enter();

    Container getContainer();

    String getSearchTerm();
}
