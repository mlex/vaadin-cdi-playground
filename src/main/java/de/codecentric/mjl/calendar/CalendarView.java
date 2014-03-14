package de.codecentric.mjl.calendar;

import com.vaadin.data.Container;
import com.vaadin.navigator.View;
import com.vaadin.ui.Component;
import org.vaadin.addon.cdimvp.MVPView;

public interface CalendarView extends MVPView, View, Component {
    String NAME = "calendar";

    Container getContainer();

    void enter();
}
