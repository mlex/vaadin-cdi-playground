package de.codecentric.mjl;

import com.vaadin.cdi.CDIView;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import org.vaadin.addon.cdimvp.AbstractMVPView;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.logging.Logger;

@CDIView
public class TestViewImpl extends AbstractMVPView implements TestView {
    private static final Logger LOGGER = Logger.getLogger(TestViewImpl.class.getName());

    private Label label;

    public TestViewImpl() {
        super();
        label = new Label("Value: <none>");
        setCompositionRoot(new HorizontalLayout(label, buildIncrementButton(), buildDestroyButton()));
    }

    private Button buildIncrementButton() {
        Button button = new Button("Increment");
        button.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                TestViewImpl.this.setValue("FOOBAR");
                fireViewEvent(TestPresenter.INCREMENT, event);
            }
        });
        return button;
    }

    private Button buildDestroyButton() {
        Button button = new Button("Destroy");
        button.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                fireViewEvent(MainPresenter.REMOVE_VIEW, TestViewImpl.this);
            }
        });
        return button;
    }

    @Override
    public void setValue(String value) {
        label.setValue("Value: " + value);
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
