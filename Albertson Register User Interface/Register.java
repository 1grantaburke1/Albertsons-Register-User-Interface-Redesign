
package register;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.text.Font; 
import javafx.scene.text.FontWeight; 
import javafx.geometry.Insets;
import javafx.scene.input.*;


import java.text.SimpleDateFormat;  
import java.util.Date;  

import javafx.scene.image.*;
import java.io.*;
import javafx.geometry.Pos;
import static register.Keyboard.decEnt;
import static register.Keyboard.input;
/**
 *
 * @author 1gran
 */
public class Register extends Application {
    // create keyboard using class
    public static Keyboard myKeyB = new Keyboard();
    
    public static Font buttonFont = Font.font("Arial",FontWeight.BOLD,45);
    public static Font textEntryFont = Font.font("Arial",FontWeight.NORMAL,20);
    public static String baseEntry = "";
    
    public static TextField entry = new TextField("");
    
    public static int userType = 1;
    
    public static VBox userPane;
    public static int ItemQuan = 1;
    public static int rn = 3;
    public static String opn = "Grant";
    public static String pnn = "Richard Harding";
    
    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        //////////////////////////////////////////////////
        //setup example buttons for item entry Scrollpane.
        Button item1 = new Button("5 Habernero Chile:\n     Orginal Cost = 5 @ 0.78 each = " + "3.90" + "\n     Sale Amount = -0.26" + "\n     FAB5 = -0.00\n     Final Total = 3.64");
        item1.getStylesheets().add(this.getClass().getResource("scrollpane.css").toExternalForm());
        item1.setPrefWidth(562);
        item1.setAlignment(Pos.CENTER_LEFT);
        Button item2 = new Button("1.7 lb Roma Tomatoes:\n     Orginal Cost = 1.7 @ 1.10/lb = " + "1.87" + "\n     Sale Amount = -0.13" + "\n     FAB5 = -0.00\n     Final Total = 1.74");
        item2.getStylesheets().add(this.getClass().getResource("scrollpane.css").toExternalForm());
        item2.setPrefWidth(562);
        item2.setAlignment(Pos.CENTER_LEFT);
        Button item3 = new Button("6.7 lb Prime Ribs:\n     Orginal Cost = 6.7 @ 7.60/lb = " + "50.92" + "\n     Sale Amount = -1.00" + "\n     FAB5 = -5.00\n     Final Total = 44.92");
        item3.getStylesheets().add(this.getClass().getResource("scrollpane.css").toExternalForm());
        item3.setPrefWidth(562);
        item3.setAlignment(Pos.CENTER_LEFT);
        
        //setup VBox to contain the buttons
        VBox contents = new VBox(item1,item2,item3);
        contents.setPadding(new Insets(3));
        contents.setSpacing(3.0);
       
        //Used to get the date.
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
        Date date = new Date();  
        
        //creates top section for register information: 
        //  register #
        //  operator name
        //  phone number entered name
        //  time
        HBox baseSet = new HBox();
        baseSet.setAlignment(Pos.CENTER);
        baseSet.setSpacing(110);
        baseSet.setPadding(new Insets(10));
        baseSet.setStyle("-fx-background-color: #F6F6F6;");
        Label opName = new Label(formatter.format(date));
        opName.setStyle("-fx-font-size: 20pt; -fx-font-family: Arial");
        HBox logoSet = new HBox();
        logoSet.setAlignment(Pos.CENTER);
        Label pn = new Label("Phone: " + pnn);
        pn.setStyle("-fx-font-size: 20pt; -fx-font-family: Arial;");
        Label rst = new Label("||  Register: " + rn + "  ||  " +"Operator: " + opn);
        rst.setStyle("-fx-font-size: 20pt; -fx-font-family: Arial;");
        baseSet.getChildren().addAll(logoSet, pn, opName);
        ImageView logo = new ImageView(new Image(new FileInputStream("C:\\Users\\1gran\\Desktop\\226-2262734_alberstons-safeway-albertsons-safeway-logo.png")));
        logo.setFitWidth(170);
        logo.setFitHeight(60);
        logoSet.getChildren().addAll(logo, rst);        //order pane
        
        // More layouts
        HBox orderPane = new HBox();
        VBox listSpPane = new VBox();
        VBox amountMenuPane = new VBox();
        orderPane.setSpacing(20);
        
        VBox overPane = new VBox();
        overPane.setSpacing(10);
        
        HBox menupane = new HBox();
        
        //buttons for the top menu
        Button ringup = new Button("Ringup Menu");
        ringup.setPrefSize(200,60);
        //ringup.setStyle(brevel());
        greyButt(ringup);
        Button instoreLook = new Button("Instore Lookup");
        //instoreLook.setStyle(brevel());
        greyButt(instoreLook);
        Button totalMenu = new Button("Total Menu");
        //totalMenu.setStyle(brevel());
        greyButt(totalMenu);
        Button preOrder = new Button("Prior Order Functions");
        //preOrder.setStyle(brevel());
        greyButt(preOrder);
        Button manager = new Button("Manager Functions");
        //manager.setStyle(brevel());
        greyButt(manager);
        Button systemHelp = new Button("System Help");
        //systemHelp.setStyle(brevel());
        greyButt(systemHelp);
        menupane.getChildren().addAll(ringup,totalMenu,instoreLook,preOrder,manager,systemHelp);
        menupane.setSpacing(5);
        
        VBox SecPane = new VBox();
        
        //Label to mark the catagories for buttons in right panel.
        Label QuickLabel = new Label("Quick Merchandise Lookup:");
        QuickLabel.setStyle("-fx-font-size: 18pt; -fx-font-weight: bold;");
        Button SearchButt = new Button("Search for Item");
        SearchButt.wrapTextProperty().setValue(true);
        SearchButt.setAlignment(Pos.CENTER);
        SearchButt.setPrefSize(210,120);
        Button BrowseAButt = new Button("Browse All Items");
        BrowseAButt.wrapTextProperty().setValue(true);
        BrowseAButt.setPrefSize(210,120);
        Button BrowsePButt = new Button("Browse Produce");
        BrowsePButt.wrapTextProperty().setValue(true);
        BrowsePButt.setPrefSize(210,120);
        Button charge = new Button("Department Charge");
        charge.wrapTextProperty().setValue(true);
      
        charge.setPrefSize(210,120);
        HBox selC = new HBox(SearchButt, BrowseAButt, BrowsePButt);
        selC.setSpacing(5);
        VBox QuickLook = new VBox(QuickLabel, selC);
        
        Label QuantityChangeLabel = new Label("Item Adjustments and Additions:");
        QuantityChangeLabel.setStyle("-fx-font-size: 18pt; -fx-font-weight: bold;");
        Button VoidButt = new Button("Void an Item");
        VoidButt.wrapTextProperty().setValue(true);
        
        VoidButt.setMinSize(210,120);
        Button QuanButt = new Button("Change Scan Quantity(" + ItemQuan + ")");
        QuanButt.wrapTextProperty().setValue(true);
        QuanButt.setPrefSize(210,120);
        HBox selB = new HBox(VoidButt, QuanButt, charge);
        selB.setSpacing(5);
        VBox ScanOp = new VBox(QuantityChangeLabel, selB);
        
        Label OrderLabel = new Label("In Order Options:");
        OrderLabel.setStyle("-fx-font-size: 18pt; -fx-font-weight: bold;");
        Button findButt = new Button("Find Item");
        findButt.wrapTextProperty().setValue(true);
        findButt.setAlignment(Pos.CENTER);
        findButt.setPrefSize(210,120);
        Button groupButt = new Button("Group Items with Coupons");
        groupButt.wrapTextProperty().setValue(true);
        groupButt.setPrefSize(210,120);
        Button statusButt = new Button("Current Status");
        statusButt.wrapTextProperty().setValue(true);
        statusButt.setPrefSize(210,120);
        HBox selA = new HBox(findButt, groupButt, statusButt);
        selA.setSpacing(5);
        VBox InOrder = new VBox(OrderLabel, selA);
        
        blueButt(SearchButt);
        blueButt(BrowseAButt);
        blueButt(BrowsePButt);
        blueButt(charge);
        blueButt(QuanButt);
        blueButt(findButt);
        blueButt(groupButt);
        blueButt(statusButt);
        redButt(VoidButt);
        
        SecPane.getChildren().addAll(InOrder,ScanOp, QuickLook);
        SecPane.setSpacing(5);
        SecPane.setStyle("-fx-padding: 7;-fx-border-style: solid inside;" +
"        -fx-border-width: 2;-fx-border-insets: 2;" +
"     -fx-border-radius: 10;-fx-border-color: blue;");
        
        
        Button logout = new Button("Operator Logout");
        darkGreyButt(logout);
        logout.setMinSize(210,80);
        Button lock = new Button("Lock Register");
        darkGreyButt(lock);
        lock.setMinSize(210,80);
        Button total = new Button("To Total Menu");
        darkGreyButt(total);
        total.setMinSize(210,80);
        HBox ShiftMenusPane = new HBox(lock, logout, total);
        ShiftMenusPane.setSpacing(5);
        ShiftMenusPane.setStyle("-fx-padding: 7;-fx-border-style: dashed;" +
"        -fx-border-width: 2;-fx-border-insets: 2;" +
"     -fx-border-radius: 10;-fx-border-color: green;");
        
        
        amountMenuPane.getChildren().addAll(SecPane,ShiftMenusPane);
        amountMenuPane.setSpacing(5);
        
        ScrollPane s = new ScrollPane();  
        s.getStylesheets().add(this.getClass().getResource("scrollpane.css").toExternalForm());
        s.setPrefSize(650, 430);
        
        s.setContent(contents);
        
        
        HBox totalDisplay = new HBox();
        totalDisplay.setAlignment(Pos.CENTER);
        Label totalL = new Label("Current Balance: ");
        totalL.setAlignment(Pos.CENTER);
        totalL.setStyle("-fx-font-size: 20pt; -fx-font-weight: bold;");
        TextField tt = new TextField("$50.30");
        tt.setStyle("-fx-font-size: 20pt; -fx-padding: 7;-fx-border-style: solid inside;" +
"        -fx-border-width: 4;-fx-border-insets: 2;" +
"     -fx-border-color: black;");
        tt.setAlignment(Pos.CENTER);
        tt.setDisable(true);
        
        TextField in = new TextField("94011");
        in.setDisable(true);
        in.setStyle("-fx-font-size: 20pt; -fx-padding: 7;-fx-border-style: solid inside;" +
"        -fx-border-width: 4;-fx-border-insets: 2;" +
"     -fx-border-color: black;");
        in.setAlignment(Pos.CENTER);
        
        totalDisplay.getChildren().addAll(totalL,tt);
        listSpPane.getChildren().addAll(in,s, totalDisplay);
        listSpPane.setSpacing(10);
        listSpPane.setAlignment(Pos.CENTER_LEFT);
        orderPane.getChildren().addAll(listSpPane, amountMenuPane);
        overPane.getChildren().addAll(baseSet,menupane,orderPane);
        overPane.setPadding(new Insets(5));
        orderPane.setAlignment(Pos.CENTER);
       
        StackPane root = new StackPane();  
        root.getChildren().add(overPane);  
        root.setStyle("-fx-background-color: #8FBDFF;");
        Scene scene = new Scene(root,300,200);  
        primaryStage.setScene(scene);  
        primaryStage.setTitle("ScrollBar Example");  
        
        
        
        
        //////////////////////////////////////////////////
        //login pane
        ImageView myView = new ImageView(new Image(new FileInputStream("C:\\Users\\1gran\\Downloads\\Albertsons-Logo-Digital-Magazine.jpg")));
        myView.setTranslateX(0);
        myView.setTranslateY(0);
        myView.setFitHeight(540); 
        myView.setFitWidth(800); 
        
        BorderPane login = new BorderPane();
        BorderPane baseLayout = new BorderPane();
        
        Button numButton[] = new Button[12];
        
        Button employeeButton = new Button("Employee");
        employeeButton.setStyle("-fx-background-color: \n" +
"        #a6b5c9,\n" +
"        linear-gradient(#303842 0%, #3e5577 20%, #375074 100%),\n" +
"        linear-gradient(#768aa5 0%, #849cbb 5%, #5877a2 50%, #486a9a 51%, #4a6c9b 100%);\n" +
"    -fx-background-insets: 0 0 -1 0,0,1;\n" +
"    -fx-background-radius: 5,5,4;\n" +
"    -fx-padding: 7 30 7 30;\n" +
"    -fx-text-fill: #242d35;\n" +
"    -fx-font-family: \"Times New Roman\";\n" +
"    -fx-font-size: 35px;\n" +
"    -fx-text-fill: white; -fx-font-weight: bold;");
        employeeButton.setMinSize(250, 157);
        employeeButton.setFont(buttonFont);
        
        Button cashierButton = new Button("Cashier");
        cashierButton.setStyle("-fx-background-color: \n" +
"        #a6b5c9,\n" +
"        linear-gradient(#303842 0%, #3e5577 20%, #375074 100%),\n" +
"        linear-gradient(#768aa5 0%, #849cbb 5%, #5877a2 50%, #486a9a 51%, #4a6c9b 100%);\n" +
"    -fx-background-insets: 0 0 -1 0,0,1;\n" +
"    -fx-background-radius: 5,5,4;\n" +
"    -fx-padding: 7 30 7 30;\n" +
"    -fx-text-fill: #242d35;\n" +
"    -fx-font-family: \"Times New Roman\";\n" +
"    -fx-font-size: 35px;\n" +
"    -fx-text-fill: white; -fx-font-weight: bold;");
        cashierButton.setMinSize(250, 157);
        cashierButton.setFont(textEntryFont);
        
        TextField mess = new TextField("Please enter your Cashier ID");
        mess.setFont(textEntryFont);
        mess.setDisable(true);
        mess.setMinSize(292, 157);
        
        HBox topLogMenu = new HBox(cashierButton, employeeButton,mess);
        topLogMenu.setSpacing(4);
        
        userPane = new VBox(myView, topLogMenu);
        
        numButton[10] = new Button("Back");
        numButton[11] = new Button("Cont.");
        setupButt(numButton[10]);
        setupButt(numButton[11]);
        numButton[10].setMinSize(182, 160);
        numButton[11].setMinSize(183, 160);
        numButton[10].setFont(buttonFont);
        numButton[11].setFont(buttonFont);
        numButton[10].setStyle("-fx-background-color: #FBF2CA ,linear-gradient(#6BE41C 50%, white 100%),radial-gradient(center 50% -40%, radius 200%, #F7FF00  45%, #FADE5F  50%);-fx-background-radius: 30;-fx-background-insets: 0,1,1;-fx-text-fill: black;-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 3, 0.0 , 0 , 1 );");
        numButton[11].setStyle("-fx-background-color: #c3c4c4,linear-gradient(#6BE41C 50%, white 100%),radial-gradient(center 50% -40%, radius 200%, #78FF20 45%, #92CD6C 50%);-fx-background-radius: 30;-fx-background-insets: 0,1,1;-fx-text-fill: black;-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 3, 0.0 , 0 , 1 );");
        
        String carrier;
        
        for (int i = 0; i < 10; i++){
            carrier = String.valueOf(i);
            numButton[i] = new Button(carrier);
            setupButt(numButton[i]);
            numButton[i].setMinSize(182, 160);
            numButton[i].setFont(buttonFont);
            numButton[i].setStyle("-fx-background-color: #c3c4c4,linear-gradient(#d6d6d6 50%, white 100%),radial-gradient(center 50% -40%, radius 200%, #e6e6e6 45%, rgba(230,230,230,0) 50%);-fx-background-radius: 30;-fx-background-insets: 0,1,1;-fx-text-fill: black;-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 3, 0.0 , 0 , 1 );");
        }
           
        
        GridPane bLayout = new GridPane();
        //bLayout.setPadding(new Insets(5));
        bLayout.setHgap(3);
        bLayout.setVgap(3);
        bLayout.add(numButton[7], 0, 0);
        bLayout.add(numButton[8], 1, 0);
        bLayout.add(numButton[9], 2, 0);
        bLayout.add(numButton[4], 0, 1);
        bLayout.add(numButton[5], 1, 1);
        bLayout.add(numButton[6], 2, 1);
        bLayout.add(numButton[1], 0, 2);
        bLayout.add(numButton[2], 1, 2);
        bLayout.add(numButton[3], 2, 2);
        bLayout.add(numButton[10], 1, 3);
        bLayout.add(numButton[0], 0, 3);
        bLayout.add(numButton[11], 2, 3);
        
        
        entry.setDisable(true);
        entry.setFont(textEntryFont);
        entry.setMaxSize(552, 100);
        entry.setPrefHeight(45);
        //entry.setPrefSize(416, 30);
        
        VBox entryPane = new VBox(entry, bLayout);
        entryPane.setPadding(new Insets(5));
        entryPane.setSpacing(10);
        
        HBox LoginScreen = new HBox(entryPane, userPane);
        userPane.setPadding(new Insets(5));
        userPane.setSpacing(3);
        
        StackPane root2 = new StackPane();
        root2.getChildren().addAll(overPane);
        root2.setStyle("-fx-background-color: #8FBDFF;");
        
        
        // uncomment these lines to have Java load the Keyboard.
        //root2.getChildren().add(myKeyB.getBoard());
        //root2 = myKeyB.getBoard();
        
        Scene scene2 = new Scene(root2,0, 250);
        
        primaryStage.setTitle("Welcome, to your friendly everyday Albertsons.");
        primaryStage.setScene(scene2);
        primaryStage.setMaximized(true);
        primaryStage.show();
        
      
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    public static void setupButt(Button butt){
        butt.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                appendEntry(butt.getText());
                entry.setText(baseEntry);
                butt.setStyle(fetchStyle('s'));
            }
        });
        
        butt.addEventFilter(MouseEvent.MOUSE_RELEASED,                
            new EventHandler<MouseEvent>() {
                    public void handle(MouseEvent event) {  
                    butt.setStyle(fetchStyle('n'));
                 };
              });
        
        butt.addEventHandler(MouseEvent.MOUSE_ENTERED,
        new EventHandler<MouseEvent>() {
          @Override
          public void handle(MouseEvent e) {
            butt.setStyle(fetchStyle('n'));
          }
        });

        butt.addEventHandler(MouseEvent.MOUSE_EXITED,
            new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                butt.setStyle(fetchStyle('x'));
            }
        });
    }
    
    public static void appendEntry(String ent){
        if (ent.equals("Cont.")){
            
        }
        else if (ent.equals("Back")){
            removeCharAt(baseEntry.length()-1);
        }
        else {
            baseEntry += ent;
        }
    }
    
    public static void removeCharAt(int pos) {
      baseEntry = baseEntry.substring(0, pos) + baseEntry.substring(pos + 1);
   }
    
   public static String fetchStyle(char event){
       if (event == 'x'){
          return "-fx-background-color: #c3c4c4,linear-gradient(#d6d6d6 50%, white 100%),radial-gradient(center 50% -40%, radius 200%, #e6e6e6 45%, rgba(230,230,230,0) 50%);-fx-background-radius: 30;-fx-background-insets: 0,1,1;-fx-text-fill: black;-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 3, 0.0 , 0 , 1 );";
       }
       else if (event == 'n'){
           return "-fx-background-color: #c3c4c4,linear-gradient(#D5F5E3 50%, #D5F5E3 100%),radial-gradient(center 50% -40%, radius 200%, #82E0AA  45%, rgba(230,230,230,0) 50%);-fx-background-radius: 30;-fx-background-insets: 0,1,1;-fx-text-fill: black;-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 3, 0.0 , 0 , 1 );";
       }
       else{
           return "-fx-background-color: #c3c4c4,linear-gradient(#D5F5E3 50%, #145A32  100%),radial-gradient(center 50% -40%, radius 200%, #82E0AA  45%, rgba(230,230,230,0) 50%);-fx-background-radius: 30;-fx-background-insets: 0,1,1;-fx-text-fill: black;-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 3, 0.0 , 0 , 1 );";
       }
   }
   
   public static String brevel(){
       return "-fx-background-color: \n" +
"        linear-gradient(#f2f2f2, #d6d6d6),\n" +
"        linear-gradient(#fcfcfc 0%, #d9d9d9 20%, #d6d6d6 100%),\n" +
"        linear-gradient(#dddddd 0%, #f6f6f6 50%);\n" +
"    -fx-background-radius: 8,7,6;\n" +
"    -fx-background-insets: 0,1,2;\n" +
"    -fx-text-fill: black;\n" +
"    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 ); -fx-font-size: 14pt; -fx-pref-height: 28px;\n" +
"    -fx-pref-width: 240px;";
   }
   
   public static String border (){
       return "\"-fx-border-color: red;\\n\" +\n" +
"                   \"-fx-border-insets: 5;\\n\" +\n" +
"                   \"-fx-border-width: 3;\\n\" +\n" +
"                   \"-fx-border-style: solid inside;\\n\";";
   }
   
   public static void blueButt(Button butt){
        butt.setStyle("-fx-background-color: \n" +
"        #000000,\n" +
"        linear-gradient(#9DA0F3 , #2f4b8f),\n" +
"        linear-gradient(#426ab7, #263e75),\n" +
"        linear-gradient(#395cab, #223768);\n" +
"    -fx-background-insets: 0,1,2,3;\n" +
"    -fx-background-radius: 3,2,2,2;\n" +
"    -fx-padding: 12 30 12 30;\n" +
"    -fx-text-fill: white;\n" +
"    -fx-font-size: 16pt; -fx-content-display: center;");
        
        butt.addEventHandler(MouseEvent.MOUSE_ENTERED,
        new EventHandler<MouseEvent>() {
          @Override
          public void handle(MouseEvent e) {
             butt.setStyle("-fx-background-color: \n" +
"        #000000,\n" +
"        linear-gradient(black   , black  ),\n" +
"        linear-gradient(green, green),\n" +
"        linear-gradient(#9DA0F3 , #223768);\n" +
"    -fx-background-insets: 0,1,2,3;\n" +
"    -fx-background-radius: 3,2,2,2;\n" +
"    -fx-padding: 12 30 12 30;\n" +
"    -fx-text-fill: white;\n" +
"    -fx-font-size: 16pt; -fx-content-display: center;");
          }
        });

        butt.addEventHandler(MouseEvent.MOUSE_EXITED,
            new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                 butt.setStyle("-fx-background-color: \n" +
"        #000000,\n" +
"        linear-gradient(#9DA0F3 , #2f4b8f),\n" +
"        linear-gradient(#426ab7, #263e75),\n" +
"        linear-gradient(#395cab, #223768);\n" +
"    -fx-background-insets: 0,1,2,3;\n" +
"    -fx-background-radius: 3,2,2,2;\n" +
"    -fx-padding: 12 30 12 30;\n" +
"    -fx-text-fill: white;\n" +
"    -fx-font-size: 16pt; -fx-content-display: center;");
            }
        });
        
        
        butt.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                String test = input.getText();
                if (butt.getText().equals("Backspace")){
                    //String test = input.getText();
                    input.setText(input.getText().substring(0, test.length()-1));
                    if (test.charAt(test.length()-1) == '.'){
                        decEnt = false;
                    }
                }
                else if ((butt.getText().equals(".") && test.length()==0) || (butt.getText().equals(".") &&decEnt == true)){
                 
                }
                
                else{
                    input.setText(input.getText() + butt.getText());
                    
                    if (butt.getText().equals(".")){
                        decEnt = true;
                    }
                }
                butt.setStyle("-fx-background-color: \n" +
"        #000000,\n" +
"        linear-gradient(#9DA0F3 , #2f4b8f),\n" +
"        linear-gradient(#426ab7, #263e75),\n" +
"        linear-gradient(#CCFFC7 , #223768);\n" +
"    -fx-background-insets: 0,1,2,3;\n" +
"    -fx-background-radius: 3,2,2,2;\n" +
"    -fx-padding: 12 30 12 30;\n" +
"    -fx-text-fill: white;\n" +
"    -fx-font-size: 16pt; -fx-content-display: center;");
            }
        });
    }
   
   public static void redButt(Button butt){
        butt.setStyle("-fx-background-color: linear-gradient(#ff5400, #be1d00);\n" +
"    -fx-background-radius: 30;\n" +
"    -fx-background-insets: 0;\n" +
"    -fx-text-fill: white; -fx-font-size: 18pt ;");
        
        butt.addEventHandler(MouseEvent.MOUSE_ENTERED,
        new EventHandler<MouseEvent>() {
          @Override
          public void handle(MouseEvent e) {
             butt.setStyle("-fx-background-color: linear-gradient(#5B1200, #be1d00);\n" +
"    -fx-background-radius: 30;\n" +
"    -fx-background-insets: 0;\n" +
"    -fx-text-fill: white; -fx-font-size: 18pt ; -fx-border-width: 20pt;");
          }
        });

        butt.addEventHandler(MouseEvent.MOUSE_EXITED,
            new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                 butt.setStyle("-fx-background-color: linear-gradient(#ff5400, #be1d00);\n" +
"    -fx-background-radius: 30;\n" +
"    -fx-background-insets: 0;\n" +
"    -fx-text-fill: white; -fx-font-size: 18pt ;");
            }
        });
        
        
        butt.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                String test = input.getText();
                if (butt.getText().equals("Backspace")){
                    //String test = input.getText();
                    input.setText(input.getText().substring(0, test.length()-1));
                    if (test.charAt(test.length()-1) == '.'){
                        decEnt = false;
                    }
                }
                else if ((butt.getText().equals(".") && test.length()==0) || (butt.getText().equals(".") &&decEnt == true)){
                 
                }
                
                else{
                    input.setText(input.getText() + butt.getText());
                    
                    if (butt.getText().equals(".")){
                        decEnt = true;
                    }
                }
                butt.setStyle("-fx-background-color: linear-gradient(#F5BAAC , #be1d00);\n" +
"    -fx-background-radius: 30;\n" +
"    -fx-background-insets: 0;\n" +
"    -fx-text-fill: white; -fx-font-size: 18pt ;");
            }
        });
    }
   
   public static void greyButt(Button butt){
        butt.setStyle("-fx-background-color: \n" +
"        linear-gradient(#f2f2f2, #d6d6d6),\n" +
"        linear-gradient(#fcfcfc 0%, #d9d9d9 20%, #d6d6d6 100%),\n" +
"        linear-gradient(#dddddd 0%, #f6f6f6 50%);\n" +
"    -fx-background-radius: 8,7,6;\n" +
"    -fx-background-insets: 0,1,2;\n" +
"    -fx-text-fill: black;\n" +
"    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 ); -fx-font-size: 14pt; -fx-pref-height: 28px;\n" +
"    -fx-pref-width: 240px;");
        
        butt.addEventHandler(MouseEvent.MOUSE_ENTERED,
        new EventHandler<MouseEvent>() {
          @Override
          public void handle(MouseEvent e) {
             butt.setStyle("-fx-background-color: \n" +
"        linear-gradient(#C0BCBA , #d6d6d6),\n" +
"        linear-gradient(#C0BCBA  0%, #d9d9d9 20%, #d6d6d6 100%),\n" +
"        linear-gradient(#DDF3DA  0%, #8AE27C 50%);\n" +
"    -fx-background-radius: 8,7,6;\n" +
"    -fx-background-insets: 0,1,2;\n" +
"    -fx-text-fill: black;\n" +
"    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 ); -fx-font-size: 14pt; -fx-pref-height: 28px;\n" +
"    -fx-pref-width: 240px;");
          }
        });

        butt.addEventHandler(MouseEvent.MOUSE_EXITED,
            new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                 butt.setStyle(brevel());
            }
        });
        
        
        butt.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                String test = input.getText();
                if (butt.getText().equals("Backspace")){
                    //String test = input.getText();
                    input.setText(input.getText().substring(0, test.length()-1));
                    if (test.charAt(test.length()-1) == '.'){
                        decEnt = false;
                    }
                }
                else if ((butt.getText().equals(".") && test.length()==0) || (butt.getText().equals(".") &&decEnt == true)){
                 
                }
                
                else{
                    input.setText(input.getText() + butt.getText());
                    
                    if (butt.getText().equals(".")){
                        decEnt = true;
                    }
                }
                butt.setStyle("-fx-background-color: \n" +
"        linear-gradient(#f2f2f2, #d6d6d6),\n" +
"        linear-gradient(#fcfcfc 0%, #d9d9d9 20%, #d6d6d6 100%),\n" +
"        linear-gradient(#dddddd 0%, #f6f6f6 50%);\n" +
"    -fx-background-radius: 8,7,6;\n" +
"    -fx-background-insets: 0,1,2;\n" +
"    -fx-text-fill: black;\n" +
"    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 ); -fx-font-size: 14pt; -fx-pref-height: 28px;\n" +
"    -fx-pref-width: 240px;");
            }
        });
    }
   
   public static void darkGreyButt(Button butt){
        butt.setStyle("-fx-background-color: \n" +
"        #090a0c,\n" +
"        linear-gradient(#38424b 0%, #1f2429 20%, #191d22 100%),\n" +
"        linear-gradient(#20262b, #191d22),\n" +
"        radial-gradient(center 50% 0%, radius 100%, rgba(114,131,148,0.9), rgba(255,255,255,0));\n" +
"    -fx-background-radius: 5,4,3,5;\n" +
"    -fx-background-insets: 0,1,2,0;\n" +
"    -fx-text-fill: white;\n" +
"    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );\n" +
"    -fx-font-family: \"Arial\";\n" +
"    -fx-text-fill: linear-gradient(white, #d0d0d0);\n" +
"    -fx-font-size: 12px;\n" +
"    -fx-padding: 10 20 10 20;-fx-effect: dropshadow( one-pass-box , rgba(0,0,0,0.9) , 1, 0.0 , 0 , 1 ); -fx-font-size: 14pt;");
        
        butt.addEventHandler(MouseEvent.MOUSE_ENTERED,
        new EventHandler<MouseEvent>() {
          @Override
          public void handle(MouseEvent e) {
             butt.setStyle("-fx-background-color: \n" +
"        #090a0c,\n" +
"        linear-gradient(#38424b 0%, #1f2429 20%, #191d22 100%),\n" +
"        linear-gradient(#D4E7E6, #191d22),\n" +
"        radial-gradient(center 50% 0%, radius 100%, rgba(114,131,148,0.9), rgba(255,255,255,0));\n" +
"    -fx-background-radius: 5,4,3,5;\n" +
"    -fx-background-insets: 0,1,2,0;\n" +
"    -fx-text-fill: white;\n" +
"    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );\n" +
"    -fx-font-family: \"Arial\";\n" +
"    -fx-text-fill: linear-gradient(white, #d0d0d0);\n" +
"    -fx-font-size: 12px;\n" +
"    -fx-padding: 10 20 10 20;-fx-effect: dropshadow( one-pass-box , rgba(0,0,0,0.9) , 1, 0.0 , 0 , 1 ); -fx-font-size: 14pt;");
          }
        });

        butt.addEventHandler(MouseEvent.MOUSE_EXITED,
            new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                 butt.setStyle("-fx-background-color: \n" +
"        #090a0c,\n" +
"        linear-gradient(#38424b 0%, #1f2429 20%, #191d22 100%),\n" +
"        linear-gradient(#20262b, #191d22),\n" +
"        radial-gradient(center 50% 0%, radius 100%, rgba(114,131,148,0.9), rgba(255,255,255,0));\n" +
"    -fx-background-radius: 5,4,3,5;\n" +
"    -fx-background-insets: 0,1,2,0;\n" +
"    -fx-text-fill: white;\n" +
"    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );\n" +
"    -fx-font-family: \"Arial\";\n" +
"    -fx-text-fill: linear-gradient(white, #d0d0d0);\n" +
"    -fx-font-size: 12px;\n" +
"    -fx-padding: 10 20 10 20;-fx-effect: dropshadow( one-pass-box , rgba(0,0,0,0.9) , 1, 0.0 , 0 , 1 ); -fx-font-size: 14pt;");
            }
        });
        
        
        butt.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                String test = input.getText();
                if (butt.getText().equals("Backspace")){
                    //String test = input.getText();
                    input.setText(input.getText().substring(0, test.length()-1));
                    if (test.charAt(test.length()-1) == '.'){
                        decEnt = false;
                    }
                }
                else if ((butt.getText().equals(".") && test.length()==0) || (butt.getText().equals(".") &&decEnt == true)){
                 
                }
                
                else{
                    input.setText(input.getText() + butt.getText());
                    
                    if (butt.getText().equals(".")){
                        decEnt = true;
                    }
                }
                butt.setStyle("-fx-background-color: \n" +
"        #090a0c,\n" +
"        linear-gradient(#38424b 0%, #1f2429 20%, #191d22 100%),\n" +
"        linear-gradient(#20262b, #191d22),\n" +
"        radial-gradient(center 50% 0%, radius 100%, rgba(114,131,148,0.9), rgba(255,255,255,0));\n" +
"    -fx-background-radius: 5,4,3,5;\n" +
"    -fx-background-insets: 0,1,2,0;\n" +
"    -fx-text-fill: white;\n" +
"    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );\n" +
"    -fx-font-family: \"Arial\";\n" +
"    -fx-text-fill: linear-gradient(white, #d0d0d0);\n" +
"    -fx-font-size: 12px;\n" +
"    -fx-padding: 10 20 10 20;-fx-effect: dropshadow( one-pass-box , rgba(0,0,0,0.9) , 1, 0.0 , 0 , 1 ); -fx-font-size: 14pt;");
            }
        });
    }
}
