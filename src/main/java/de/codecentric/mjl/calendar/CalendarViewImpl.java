package de.codecentric.mjl.calendar;

import com.vaadin.cdi.CDIView;
import com.vaadin.data.Container;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.*;
import org.vaadin.addon.cdimvp.AbstractMVPView;

import java.util.Date;
import java.util.logging.Logger;

@CDIView(CalendarView.NAME)
public class CalendarViewImpl extends AbstractMVPView implements CalendarView {
    private static final Logger LOGGER = Logger.getLogger(CalendarViewImpl.class.getName());

    private Label label;

    private TextField searchField;
    private Button searchButton;
    private Table calendarTable;

    public CalendarViewImpl() {
        super();
        setCompositionRoot(buildCalendarTable());
    }

    @Override
    public Container getContainer() {
        return calendarTable.getContainerDataSource();
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        enter();
    }

    private Component buildCalendarTable() {
        calendarTable = new Table("Kalender");
        calendarTable.addContainerProperty("Termin", String.class, "");
        calendarTable.addContainerProperty("Datum", Date.class, null);
        calendarTable.addContainerProperty("Ort", String.class, "");
        return calendarTable;
    }
}
