package de.codecentric.mjl.main;

import com.vaadin.cdi.CDIView;
import com.vaadin.cdi.CDIViewProvider;
import com.vaadin.navigator.Navigator;
import com.vaadin.ui.*;
import de.codecentric.mjl.calendar.CalendarView;
import de.codecentric.mjl.contacts.ContactsView;
import org.vaadin.addon.cdimvp.AbstractMVPView;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.logging.Logger;

@CDIView
public class MainViewImpl extends AbstractMVPView implements MainView {
    private static final Logger LOGGER = Logger.getLogger(MainViewImpl.class.getName());

    private VerticalLayout layout;

    private Navigator navigator;

    @Inject
    private UI ui;

    @Inject
    private CDIViewProvider viewProvider;

    @PostConstruct
    public void setup() {
        HorizontalLayout mainArea = new HorizontalLayout();

        navigator = new Navigator(ui, mainArea);
        navigator.addProvider(viewProvider);

        layout = new VerticalLayout();
        layout.addComponent(buildMenuBar());
        layout.addComponent(mainArea);

        setCompositionRoot(this.layout);
    }

    public void navigateTo(String viewName) {
        navigator.navigateTo(viewName);
    }

    private Component buildMenuBar() {
        HorizontalLayout layout = new HorizontalLayout();
        layout.addComponent(buildMenuBarButton("Kontakte", ContactsView.NAME));
        layout.addComponent(buildMenuBarButton("Kalender", CalendarView.NAME));
        return layout;
    }

    private Button buildMenuBarButton(String caption, final String viewName) {
        return new Button(caption, new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                fireViewEvent(MainPresenter.MENU_BUTTON_CLICKED, viewName);
            }
        });
    }

}
