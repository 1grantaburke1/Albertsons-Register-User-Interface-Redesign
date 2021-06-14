/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package register;

/**
 *
 * @author 1gran
 */
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.Pos;
import javafx.scene.input.*;
import javafx.geometry.Insets;

public class Keyboard {
    //Declartions for attributes
    String Message;
    int mode;           
    
    //keyboard chars to be used on buttons
    String[] keyChars = {"1","2","3"
            ,"4","5","6","7","8","9"
            ,"0","q","w","e","r","t"
            ,"y","u","i","o","p","a"
            ,"s","d","f","g","h","j"
            ,"k","l","z","x","c","v"
            ,"b","n","m"
            ,"Exit Action"," ",".","Backspace", "Submit"};
    
    //create an array to contain the buttons for keyboard.
    Button[] keys = new Button[keyChars.length];
    HBox rows[] = new HBox[5];
    VBox Col = new VBox();
    
    //Textfield to show the current input of the keyboard
    public static TextField input = new TextField("");
    public static Boolean decEnt = false;
    
    VBox inPane = new VBox(input,Col);
    
    //Labels to dispay side info about keyboard and current action
    Label intel = new Label( "--Your Action-- \n   -> Search for a product in memory.\n" +"--System Instructions--\n"+"   -> Enter the product name then click 'Submit'.");
    Label response = new Label("--Keyboard Response-- \n" + "   -> The keyboard is ready for next entry.");
    Label setting = new Label("--Keyboard (Current Settings)-- \n" + "   -> Number Keys are enabled \n" + "   -> Letter Keys are enabled");
    VBox inPaneb = new VBox(intel, response, setting);
    
    HBox allFrame;
    
    //to contain the keyboard
    public static StackPane board;
    
    //Constructors
    Keyboard(String messPane, int mode){
    
    }
    
    Keyboard(int mode){
        
    }
    
    Keyboard(String messPane){
        
    }
    
    Keyboard(){
        //board.setPrefSize(100, 1000);
        makeKeyBoard();
    }
    
    //methods
    private void makeKeyBoard(){
        createButtons();
        setRows();
        setFinalCol();
        input.setMaxSize(812, 70);
        input.setDisable(true);
        input.setStyle("-fx-font-size: 20pt; -fx-padding: 7;-fx-border-style: solid inside;" +
"        -fx-border-width: 4;-fx-border-insets: 2;" +
"     -fx-border-color: black;");
        input.setAlignment(Pos.CENTER);
        inPane.setAlignment(Pos.TOP_CENTER);
        
        //inPaneb.setAlignment(Pos.CENTER)
        
        intel.setStyle("-fx-font-size: 14pt; -fx-text-fill: white;-fx-border-radius: 10; -fx-border-style: solid inside; -fx-border-width: 2;");
        intel.getStylesheets().add(this.getClass().getResource("scrollpane.css").toExternalForm());
        intel.setPrefSize(500,147);
        intel.setAlignment(Pos.TOP_LEFT);
        response.setStyle("-fx-font-size: 14pt; -fx-text-fill: white;-fx-border-radius: 10;-fx-border-style: solid inside; -fx-border-width: 2;");
        response.getStylesheets().add(this.getClass().getResource("scrollpane.css").toExternalForm());
        response.setPrefSize(500,147);
        response.setAlignment(Pos.TOP_LEFT);
        setting.setStyle("-fx-font-size: 14pt; -fx-text-fill: white;-fx-border-radius: 10;-fx-border-style: solid inside; -fx-border-width: 2;");
        setting.getStylesheets().add(this.getClass().getResource("scrollpane.css").toExternalForm());
        setting.setPrefSize(500,84);
        setting.setAlignment(Pos.TOP_LEFT);
        
        inPaneb.setPadding(new Insets(5));
        inPane.setPadding(new Insets(5));
        inPaneb.setSpacing(3);
        //inPane.setPadding(new Insets(8));
        
        board = new StackPane();
        allFrame = new HBox(inPaneb,inPane);
        allFrame.setSpacing(0);
        board.getChildren().add(allFrame);
        board.setStyle("-fx-background-color: #8FBDFF;");
        
    }
    
    private void createButtons(){
        for (int i=0; i<keys.length; i++){
            keys[i] = new Button(keyChars[i]);
            keys[i].setStyle("-fx-background-color: \n" +
"        #000000,\n" +
"        linear-gradient(#7ebcea, #2f4b8f),\n" +
"        linear-gradient(#426ab7, #263e75),\n" +
"        linear-gradient(#395cab, #223768);\n" +
"    -fx-background-insets: 0,1,2,3;\n" +
"    -fx-background-radius: 3,2,2,2;\n" +
"    -fx-padding: 12 30 12 30;\n" +
"    -fx-text-fill: white;\n" +
"    -fx-font-size: 16pt; -fx-content-display: center;");
            
            hButt(keys[i]);
            
           
        }
        
        keys[37].setPrefSize(285, keys[37].getHeight());
    }
    
    private void setRows(){
        rows[0] = new HBox(10);
        rows[1] = new HBox(10);
        rows[2] = new HBox(9);
        rows[3] = new HBox(7);
        rows[4] = new HBox(5);
        
        for (int i = 0; i<rows.length; i++){
            rows[i].setAlignment(Pos.CENTER);
            rows[i].setPadding(new Insets(5));
        }
        
        for (int i = 0; i<10;i++){
            rows[0].getChildren().add(keys[i]);
        }
        
        for (int i = 10; i<20;i++){
            rows[1].getChildren().add(keys[i]);
        }
        
        for (int i = 20; i<29;i++){
            rows[2].getChildren().add(keys[i]);
        }
        
        for (int i = 29; i<36;i++){
            rows[3].getChildren().add(keys[i]);
        }
        
        for (int i = 36; i<41;i++){
            rows[4].getChildren().add(keys[i]);
        }
    }
    
    private void setFinalCol(){
        Col.getChildren().addAll(rows[0],rows[1],rows[2],rows[3],rows[4]);
    }
    
    public StackPane getBoard(){
        return board;
    }
    
    public static void hButt(Button butt){
        
        
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
}
