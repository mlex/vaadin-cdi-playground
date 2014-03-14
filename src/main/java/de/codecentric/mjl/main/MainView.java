package de.codecentric.mjl.main;

import com.vaadin.navigator.View;
import com.vaadin.ui.Component;
import org.vaadin.addon.cdimvp.MVPView;

public interface MainView extends MVPView, Component {
    void navigateTo(String viewName);

    void enter();
}
