package de.codecentric.mjl;

import com.vaadin.ui.CustomComponent;
import org.vaadin.addon.cdimvp.AbstractMVPView;
import org.vaadin.addon.cdimvp.MVPView;

public interface MainView extends MVPView {
    void addNewSubView(AbstractMVPView component);

    void removeSubView(AbstractMVPView component);
}
