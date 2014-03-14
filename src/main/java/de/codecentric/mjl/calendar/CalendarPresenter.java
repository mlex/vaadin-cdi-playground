package de.codecentric.mjl.calendar;

import com.vaadin.data.Item;
import de.codecentric.mjl.model.Contact;
import org.vaadin.addon.cdimvp.AbstractMVPPresenter;
import org.vaadin.addon.cdimvp.CDIEvent;
import org.vaadin.addon.cdimvp.ParameterDTO;

import javax.enterprise.event.Observes;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.logging.Logger;

@AbstractMVPPresenter.ViewInterface(CalendarView.class)
public class CalendarPresenter extends AbstractMVPPresenter<CalendarView> {
    @Override
    public void viewEntered() {
        // TODO fill calendar view with data
    }
}
