package de.codecentric.mjl.main;

import org.vaadin.addon.cdimvp.AbstractMVPPresenter;
import org.vaadin.addon.cdimvp.CDIEvent;
import org.vaadin.addon.cdimvp.ParameterDTO;

import javax.enterprise.event.Observes;
import java.util.logging.Logger;


@AbstractMVPPresenter.ViewInterface(MainView.class)
class MainPresenter extends AbstractMVPPresenter<MainView> {
    private static final Logger LOGGER = Logger.getLogger(MainPresenter.class.getName());

    public static final String MENU_BUTTON_CLICKED = "MENU_BUTTON_CLICKED";

    public void navigateToNewView(@Observes @CDIEvent(MENU_BUTTON_CLICKED) ParameterDTO parameter) {
        String viewName = (String) parameter.getPrimaryParameter();
        view.navigateTo(viewName);
    }

    @Override
    public void viewEntered() {
    }
}
