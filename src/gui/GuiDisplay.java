package gui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.stage.*;
import java.util.Stack;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.Pos;
import javafx.collections.ObservableList;
import javafx.scene.Parent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GuiDisplay extends Application {

  private Stage window;
  private Controller controller;
  private BorderPane canvas;

  private VBox centrePanel;

  /**
  The start method. Is called to launch the window.
  @param primaryStage the Stage object to initiate the program.
  */
  @Override
  public void start(Stage primaryStage) throws Exception {
    window = primaryStage;
    controller = new Controller(this);
    canvas = setLayout();
    Scene scene = new Scene(canvas, 800, 600);
    //scene.getStylesheets().add("res/stylesheet.css"); //import the stylesheet

    window.setTitle("Fighterz Finale"); //instantiate the window
    window.setScene(scene);
    window.show();
  }

  /**Creates the BorderPane objects and organizes nodes for left, right and middle of the screen.
  @return temp, the completed layout
  */
  private BorderPane setLayout() {
    BorderPane temp = new BorderPane();
    centrePanel = buildCentrePanel();

    temp.setCenter(centrePanel);

    return temp;
  }

  private VBox buildCentrePanel() {
    VBox temp = new VBox(10);
    Button testButton = createButton("EZ GAEM");

    temp.getChildren().add(testButton);
    return temp;
  }

  private VBox buildRightPanel() {
    return temp;
  }

  private VBox buildLeftPanel() {
    return temp;
  }

  /**Helper function that creates a new instance of Button.
  @param text the button text
  @return button, the created button
  */
  public Button createButton(String text) {
    Button button = new Button();
    button.setText(text);
    return button;
  }

  /**Helper function that creates a new instance of label.
  @param text the content of the label
  @param format the css style of the button
  @return label, the created label
  */
  public Label createLabel(String text) {
    Label label = new Label(text);
    return label;
  }

  /**Helper function that creates a new instance of choice box.
  @param options the array of choices to be added
  @return temp, the created choice box.
  */
  public ChoiceBox<String> createChoiceBox(String... options) {
    ChoiceBox<String> temp = new ChoiceBox<>();

    for (String s : options) {
      temp.getItems().add(s);
    }
    if (options.length > 0) { //set the displayed value
      temp.setValue(options[0]);
    }

    return temp;
  }

  /**Another helper function that creates an instance of a popup window.
  @param title the title of the window
  @param text the first label to be added
  @return popupWindow, the created popup
  */
  public Stage createPopup(String title, String text) {
    Stage popupWindow = new Stage();

    popupWindow.initModality(Modality.APPLICATION_MODAL); //Silence the original window while this one is open
    popupWindow.setTitle(title);

    VBox layout = new VBox(10);

    return popupWindow;
  }

  /**Dynamically adds a button to a window.
  @param theWindow the target to add the button to
  @param newButton the button to be added
  */
  public void addButton(Stage theWindow, Button newButton) {
    Parent sroot = theWindow.getScene().getRoot();
    ObservableList<Node> rootChildren = null;
    if (sroot instanceof VBox) { //Cast the root as a VBox.
      rootChildren = ((VBox) sroot).getChildren();
    }

    rootChildren.add(newButton);
  }

  /**Dynamically adds a choice box to a window.
  @param theWindow the target to add the button to
  @param dropDown the box to be added
  */
  public void addChoiceBox(Stage theWindow, ChoiceBox<String> dropDown) {
    Parent sroot = theWindow.getScene().getRoot();
    ObservableList<Node> rootChildren = null;
    if (sroot instanceof VBox) { //Cast the root as a VBox
      rootChildren = ((VBox) sroot).getChildren();
    }

    if (!rootChildren.contains(dropDown)) {
      rootChildren.add(dropDown);
    }
  }

  /**The main method.
   * @param args  The array of arguments passed at runtime.
   * */
  public static void main(String[] args) {

    launch(args);

  }
}

