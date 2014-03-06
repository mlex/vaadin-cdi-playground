package de.codecentric.mjl;

import com.vaadin.annotations.Theme;
import com.vaadin.cdi.CDIUI;
import com.vaadin.cdi.URLMapping;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import java.util.logging.Logger;

@Theme("mytheme")
@CDIUI
@URLMapping("/*")
public class WelcomePage extends UI {
    private static final Logger LOGGER = Logger.getLogger(WelcomePage.class.getName());

    @Inject
    Instance<MainViewImpl> mainView;

    public WelcomePage() {
        LOGGER.info(this.toString() + " " + "CREATED");
    }

    @PostConstruct
    public void logPostConstruct() {
        LOGGER.info(this.toString() + " " + "POSTCONSTRUCT");
    }

    @PreDestroy
    public void logPreDestroy() {
        LOGGER.info(this.toString() + " " + "PREDESTROY");
    }

    @Override
    protected void init(VaadinRequest request) {
        LOGGER.info(this.toString() + " " + "INIT BEGIN");
        setSizeFull();
        MainViewImpl mainView = this.mainView.get();
        setContent(mainView);
        mainView.enter();
        LOGGER.info(this.toString() + " " + "INIT END");
    }
}
