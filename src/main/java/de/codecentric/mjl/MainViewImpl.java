package de.codecentric.mjl;

import com.vaadin.cdi.CDIView;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import org.vaadin.addon.cdimvp.AbstractMVPView;
import org.vaadin.addon.cdimvp.ViewComponent;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.inject.Instance;
import javax.enterprise.inject.New;
import javax.inject.Inject;
import java.util.logging.Logger;

@CDIView
public class MainViewImpl extends AbstractMVPView implements MainView {
    private static final Logger LOGGER = Logger.getLogger(MainViewImpl.class.getName());

    private final HorizontalLayout layout;

    @Inject
    @New
    private MainPresenter presenter;

     @Inject
     @New
     private Instance<TestViewImpl> testViews;

    public MainViewImpl() {
        super();
        Label label = new Label("Hello World");
        Button button = new Button("New SubView");
        button.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                fireViewEvent(MainPresenter.ADD_VIEW, event);
            }
        });
        layout = new HorizontalLayout(label, button);
        setCompositionRoot(layout);
    }

    @Override
    public void addNewSubView() {
        TestViewImpl newView = testViews.get();
        layout.addComponent(newView);
        newView.enter();
    }

    @Override
    public void removeSubView(AbstractMVPView component) {
        layout.removeComponent(component);
    }

    @PostConstruct
    public void attachToPresenter() {
        presenter.attachToView(this);
        LOGGER.info(this.toString() + " " + "POSTCONSTRUCT");
    }

    @PreDestroy
    public void logPreDestroy() {
        LOGGER.info(this.toString() + " " + "PREDESTROY");
    }

}
