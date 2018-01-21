package dream.development.firstProjectGWT.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import dream.development.firstProjectGWT.client.objects.CallInput;
import dream.development.firstProjectGWT.client.objects.CallResult;
import dream.development.firstProjectGWT.client.services.callObjectsService.CallObjectsService;
import dream.development.firstProjectGWT.client.services.callObjectsService.CallObjectsServiceAsync;
import dream.development.firstProjectGWT.client.services.firstProjectGWTService.FirstProjectGWTService;
import dream.development.firstProjectGWT.client.services.stringService.StringService;
import dream.development.firstProjectGWT.client.services.stringService.StringServiceAsync;
import dream.development.firstProjectGWT.client.ui.TestPanel;
import dream.development.firstProjectGWT.client.uploadedFile.UploadedFile;
import dream.development.firstProjectGWT.validator.FieldVerifier;

/**
 * Entry point classes define <code>onModuleLoad()</code>
 */
public class FirstProjectGWT implements EntryPoint, ClickHandler { //implements handlers

    private StringServiceAsync stringService = GWT.create(StringService.class);
    private CallObjectsServiceAsync callObjectsService = GWT.create(CallObjectsService.class);

    private final Button buttonGetEventName = new Button("Get event name");
    private final Button buttonStringService = new Button("Sent text to server");
    private final Button buttonCallObjects = new Button("Sent object to server");
    private final TextBox textForCountingLetters = new TextBox();
    private final TextBox textStringService = new TextBox();
    private final TextBox textCallObject = new TextBox();
    private final Label labelCountedLetters = new Label();
    private final Label labelStringService = new Label();
    private final Label labelCallObject = new Label();

    /**
     * This is the entry point method.
     */
    public void onModuleLoad() {
        final Button button = new Button("Click me");
        final Label label = new Label();

        button.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                if (label.getText().equals("")) {
                    FirstProjectGWTService.App.getInstance().getMessage("Hello, World!", new MyAsyncCallback(label));
                } else {
                    label.setText("");
                }
            }
        });

        // Assume that the host HTML has elements defined whose
        // IDs are "slot1", "slot2".  In a real app, you probably would not want
        // to hard-code IDs.  Instead, you could, for example, search for all
        // elements with a particular CSS class and replace them with widgets.
        //
        RootPanel.get("slot1").add(button);
        RootPanel.get("slot2").add(label);

        //button for getting event name
        buttonGetEventName.addClickHandler(this);
        buttonGetEventName.setStyleName("redButtonForCountingLetters");

        RootPanel.get("buttonGetEventName").add(buttonGetEventName);

        //Counting letters
        labelCountedLetters.setStyleName("labelOfCountedLetters");

        //anonymous class
        textForCountingLetters.addKeyPressHandler(new KeyPressHandler() {
            @Override
            public void onKeyPress(KeyPressEvent event) {
                labelCountedLetters.setText(String.valueOf(textForCountingLetters.getText().trim().length())); //set count of letters (trim - without blank)
            }
        });

        RootPanel.get("textForCountingLetters").add(textForCountingLetters);
        RootPanel.get("labelCountedLetters").add(labelCountedLetters);

        //StringService widgets. Client-server example
        buttonStringService.addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {

                stringService.checkString(textStringService.getText(), new AsyncCallback<String>() {
                    @Override
                    public void onSuccess(String result) {
                        labelStringService.setText(result);
                    }

                    @Override
                    public void onFailure(Throwable caught) {
                        //TODO Auto-generated method stub
                    }
                });

            }

        });

        RootPanel.get("buttonStringService").add(buttonStringService);
        RootPanel.get("textStringService").add(textStringService);
        RootPanel.get("labelStringService").add(labelStringService);

        //StringService widgets. Client-server example
        buttonCallObjects.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {

                if (!FieldVerifier.isValidName(textCallObject.getText())) {
                    labelCallObject.setStyleName("error");
                    labelCallObject.setText("Text is invalid!");
                    return;
                }

                CallInput callInput = new CallInput();
                callInput.setText(textCallObject.getText());

                callObjectsService.checkString(callInput, new AsyncCallback<CallResult>() {
                    @Override
                    public void onSuccess(CallResult result) {
                        labelCallObject.setStyleName("common");
                        labelCallObject.setText(result.getText() + "(" + result.getCode() + ")");
                    }

                    @Override
                    public void onFailure(Throwable caught) {
                        labelCallObject.setStyleName("error");
                        labelCallObject.setText(caught.getMessage());
                    }
                });

            }
        });

        RootPanel.get("buttonCallObjects").add(buttonCallObjects);
        RootPanel.get("textCallObject").add(textCallObject);
        RootPanel.get("labelCallObject").add(labelCallObject);

        //UI TestPanel
        TestPanel testPanel = new TestPanel("Test name");
        RootPanel.get("testPanel").add(testPanel);

        //FileUpload
        UploadedFile uploadedFile = new UploadedFile();
        RootPanel.get("sendButtonContainer").add(uploadedFile.upload());

    }

    @Override
    public void onClick(ClickEvent event) {
        buttonClick(event.getSource().toString());
    }

    private void buttonClick(String source) {
        Window.alert(source);
    }

    private static class MyAsyncCallback implements AsyncCallback<String> {
        private Label label;

        public MyAsyncCallback(Label label) {
            this.label = label;
        }

        public void onSuccess(String result) {
            label.getElement().setInnerHTML(result);
        }

        public void onFailure(Throwable throwable) {
            label.setText("Failed to receive answer from server!");
        }
    }
}
