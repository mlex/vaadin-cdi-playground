package de.codecentric.mjl;

import com.vaadin.ui.CustomComponent;
import org.vaadin.addon.cdimvp.AbstractMVPView;
import org.vaadin.addon.cdimvp.MVPView;

public interface MainView extends MVPView {
    void addNewSubView();

    void removeSubView(AbstractMVPView component);
}
