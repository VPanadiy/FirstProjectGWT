package dream.development.firstProjectGWT.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;

public class TestPanel extends Composite implements HasText{

    private static TestPanelUiBinder ourUiBinder = GWT.create(TestPanelUiBinder.class);

    interface TestPanelUiBinder extends UiBinder<Widget, TestPanel> {

    }

    public TestPanel() {
        initWidget(ourUiBinder.createAndBindUi(this));
    }

    @UiField
    Button uiButton;

    public TestPanel(String firstName){
        initWidget(ourUiBinder.createAndBindUi(this));
        uiButton.setText(firstName);
    }

    @UiHandler("uiButton")
    void onClick(ClickEvent e){
        Window.alert("Hello!");
    }

    @Override
    public String getText() {
        return uiButton.getText();
    }

    @Override
    public void setText(String text) {
        uiButton.setText(text);
    }
}