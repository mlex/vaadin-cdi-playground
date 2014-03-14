package de.codecentric.mjl;

import org.vaadin.addon.cdimvp.AbstractMVPPresenter;
import org.vaadin.addon.cdimvp.CDIEvent;
import org.vaadin.addon.cdimvp.ParameterDTO;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.Dependent;
import javax.enterprise.event.Observes;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;

@Dependent
public class TestPresenter {
    private static final Logger LOGGER = Logger.getLogger(TestPresenter.class.getName());

    public static final String INCREMENT = "INCREMENT";

    private AtomicInteger value = new AtomicInteger(0);

    private TestView view;

    public void increment(@Observes @CDIEvent(INCREMENT) ParameterDTO dto) {
        int newValue = value.incrementAndGet();
        view.setValue(String.valueOf(newValue));
    }

    public void attachToView(TestView view) {
        this.view = view;
        LOGGER.info(this.toString() + " " + "VIEW_ENTERED");
    }

    @PostConstruct
    public void logPostConstruct() {
        LOGGER.info(this.toString() + " " + "POSTCONSTRUCT");
    }

    @PreDestroy
    public void logPreDestroy() {
        LOGGER.info(this.toString() + " " + "PREDESTROY");
    }

}
