package de.codecentric.mjl;

import com.vaadin.ui.CustomComponent;
import org.vaadin.addon.cdimvp.AbstractMVPPresenter;
import org.vaadin.addon.cdimvp.AbstractMVPView;
import org.vaadin.addon.cdimvp.CDIEvent;
import org.vaadin.addon.cdimvp.ParameterDTO;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.Dependent;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.Instance;
import javax.enterprise.inject.New;
import javax.inject.Inject;
import java.util.logging.Logger;

@Dependent
public class MainPresenter {

    private static final Logger LOGGER = Logger.getLogger(MainPresenter.class.getName());

    public static final String ADD_VIEW = "ADD_VIEW";

    public static final String REMOVE_VIEW = "REMOVE_VIEW";

    private MainView view;

    public void addView(@Observes @CDIEvent(ADD_VIEW) ParameterDTO parameter) {
        view.addNewSubView();
    }

    public void removeView(@Observes @CDIEvent(REMOVE_VIEW) ParameterDTO parameter) {
        view.removeSubView((AbstractMVPView) parameter.getPrimaryParameter());
    }

    public void attachToView(MainView view) {
        this.view = view;
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
