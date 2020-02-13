/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdventureSimulator;
import static AdventureSimulator.Classes.die;
import static AdventureSimulator.Classes.fighting;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView; 
import java.io.FileInputStream; 
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;

public class AdventureSimulator extends Application
{
    //Working Directory = C:\Users\Luis Sandoval\Documents\NetBeansProjects\Directory
    static Scanner scan = new Scanner(System.in);
    Label messageLbl = new Label();
    String name = null;
    
    Label Start = new Label("Start");
    BackgroundFill bacground_fill = new BackgroundFill(Color.SLATEGRAY,CornerRadii.EMPTY,Insets.EMPTY);
    Background background = new Background(bacground_fill);
    public static void main(String[] args)
    {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws FileNotFoundException
    {
        //System.out.println(System.getProperty("user.dir"));
        
        Image image = new Image(new FileInputStream("Title.gif"));
        Image bkg = new Image(new FileInputStream("BKG.png"));
        
        BackgroundImage Mountains = new BackgroundImage(bkg, BackgroundRepeat.SPACE, BackgroundRepeat.SPACE, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        Background Mountainsbkg = new Background(Mountains);
        
        //System.out.println(new File(".").getAbsolutePath());
        
        ImageView imageView = new ImageView(image);
  
        imageView.setX(50);
        imageView.setY(25);
        

        
        imageView.setFitHeight(200);
        imageView.setFitWidth(500);
        imageView.setPreserveRatio(true);
        

        
        
        
        //create new Button
        Button startBtn = new Button("Start");
        startBtn.setDefaultButton(true);
        //startBtn.setAlignment(Pos.CENTER);
        startBtn.setMinSize(200, 100);
        //event handler 
        
        startBtn.setOnAction(new EventHandler<ActionEvent>() 
        {
            @Override public void handle(ActionEvent e)
            {
                stage.setScene(NameScene(stage));
            }
        });
        
        Button OptionsBtn = new Button("Options");
        OptionsBtn.setMinSize(200,100);
        OptionsBtn.setOnAction(new EventHandler<ActionEvent>() 
        {
            @Override public void handle(ActionEvent e)
            {
                printMessage("ok");
            }
        });
        VBox buttonBox = new VBox();
        buttonBox.getChildren().addAll(imageView,startBtn,OptionsBtn);
        buttonBox.setSpacing(20);
        buttonBox.setAlignment(Pos.CENTER);

        
        VBox root = new VBox();
        
        root.getChildren().addAll(messageLbl,buttonBox);
        
        root.setSpacing(20);
        root.setMinSize(1280,720);
        root.setBackground(Mountainsbkg);
        
        
        root.setStyle(STYLESHEET_MODENA);
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        
        stage.setTitle("Adventure Game");
       
        
        stage.show();
        
    
    }
    
    
    protected Scene NameScene(Stage stage)
    {
        Label namechk = new Label();
        VBox nameBox = new VBox();
        Label nameLabel = new Label("Enter Name:");
        TextField nameField = new TextField();
        nameField.setMaxWidth(300);
        
        Button nameCreate = new Button("Confirm");
        nameCreate.setOnAction(new EventHandler<ActionEvent>()
        {
           public void handle(ActionEvent t)
           {
               
               if(nameField.getText()== null || nameField.getText().trim().isEmpty())
               {
                   namechk.setText("No Name Selected");
                  
               }
               else
               {
                System.out.println("Name:"+ nameField.getText()+"was Created");
                name = nameField.getText();
                stage.setScene(ClassSelectionScene(stage));
               }
           }
        });
       
        nameBox.getChildren().addAll(nameLabel,nameField,nameCreate,namechk);
        
        nameBox.setSpacing(20);
        nameBox.setMinSize(1280, 720);
        nameBox.setAlignment(Pos.CENTER);
        nameBox.setBackground(background);
        nameBox.setStyle(STYLESHEET_MODENA);
        
        
        return new Scene(nameBox);
    }
    
    
    protected Scene ClassSelectionScene(Stage stage)
    {
        Classes player = new Classes(name);
        Label selectionMsg = new Label ("Choose your Class");
        Label checkSelection = new Label();
        VBox classBox = new VBox();
        
        RadioButton BerserkerBtn = new RadioButton("Berserker");
        
        RadioButton KnightBtn = new RadioButton("Knight   ");
        
        RadioButton RogueBtn = new RadioButton("Rogue   ");
        
        RadioButton WizardBtn = new RadioButton("Wizard   ");
        
        Button Confirmbtn = new Button("Confirm");
        
        
        Confirmbtn.setOnAction(new EventHandler<ActionEvent>()
        {
           public void handle(ActionEvent t)
           {
               if (BerserkerBtn.isSelected())
               {
                   player.Berserker();
                   System.out.println("BERSERKER!");
                   stage.setScene(GameMenu(player));
               }
               if(KnightBtn.isSelected())
               {
                   player.Knight();
                   stage.setScene(GameMenu(player));
               }
               if(RogueBtn.isSelected())
               {
                   player.Rogue();
                   stage.setScene(GameMenu(player));
               }
               if(WizardBtn.isSelected())
               {
                   player.Wizard();
                   stage.setScene(GameMenu(player));
               }

           }
        });
        
        
        ToggleGroup group = new ToggleGroup();
        
        group.getToggles().addAll(BerserkerBtn,KnightBtn,RogueBtn,WizardBtn);
        
        classBox.getChildren().addAll(selectionMsg,BerserkerBtn,KnightBtn,RogueBtn,WizardBtn,Confirmbtn,checkSelection);
        classBox.setSpacing(20);
        classBox.setMinSize(1280,720);
        classBox.setAlignment(Pos.CENTER);
        classBox.setBackground(background);
        
        return new Scene(classBox);
        
        
    }
    protected Scene GameMenu(Classes player)
    {
        
        Game_Actions game = new Game_Actions();
        Button Statsbtn = new Button("stats");
        Button adventurebtn = new Button("Start Adventure");
        Button fightbtn = new Button("fight!");
        Button atkbtn = new Button("attack");
        Button enemystats = new Button("enemystats");
        Enemies enemy = new Enemies(player);
        
        
        
        Label StatsLbl = new Label();
        Label enemyLbl = new Label();
        Label gameLbl = new Label();
        Label enemyatkLbl = new Label();
        Label playeratkLbl = new Label();
        VBox status_menu = new VBox();
        
        
        
        fightbtn.setVisible(false);
        atkbtn.setVisible(false);
        enemystats.setVisible(false);
        Statsbtn.setVisible(false);
        
        Statsbtn.setOnAction(new EventHandler<ActionEvent>()
        {
            //int counter = 0;
            public void handle(ActionEvent t)
            {
                
                
                StatsLbl.setText(game.Display_status(player));
                
            }
            
        });
        adventurebtn.setOnAction(new EventHandler<ActionEvent>()
        {
            public void handle(ActionEvent t)
            {
                //game.fight(player, enemy);
                adventurebtn.setVisible(false);
                fightbtn.setVisible(true);
                Statsbtn.setVisible(true);
                gameLbl.setText("an enemy approches!");
                
                
            }
        });
        fightbtn.setOnAction(new EventHandler<ActionEvent>()
        {
            public void handle(ActionEvent t)
            {
                atkbtn.setVisible(true);
                enemystats.setVisible(true);
            }
        });
        atkbtn.setOnAction(new EventHandler<ActionEvent>()
        {
            public void handle(ActionEvent t)
            {
                
                gameLbl.setVisible(false);
                game.fight(player,enemy);
                //game.saveEnemyStats(enemy);
                if(enemy.enemyhp <= 0)
                {
                    Enemies enemy1 = new Enemies(player);
                    enemy.enemyhp = enemy1.enemyhp;
                    enemy.enemy_melee_dmg = enemy1.enemy_melee_dmg;
                    gameLbl.setVisible(true);
                    gameLbl.setText("a new enemy approches!");
                    
                }
                StatsLbl.setText(game.Display_status(player));
                enemyLbl.setText(enemy.printEnemyStats());
                enemyatkLbl.setText(enemy.EnemyTxt);
                playeratkLbl.setText(game.PlayerTxt);
                
                    
                
            }
        });
        
        enemystats.setOnAction(new EventHandler<ActionEvent>()
        {
            public void handle(ActionEvent t)
            {
                
                //enemyLbl.setText("Enemy "+"\nhp: " + enemy.enemyhp + "\ndmg: " + enemy.enemy_melee_dmg + "\n");
                enemyLbl.setText(enemy.printEnemyStats());
                
            }
        });
        
        
        
        status_menu.getChildren().addAll(adventurebtn,Statsbtn,StatsLbl,fightbtn,enemystats,enemyLbl,atkbtn,gameLbl,playeratkLbl,enemyatkLbl);
        status_menu.setSpacing(20);
        status_menu.setMinSize(1280,720);
        status_menu.setAlignment(Pos.CENTER);
        status_menu.setBackground(background);
        
        return new Scene(status_menu);
        
        

    }
    
    
    //create second button

    
    //create boundaries

    
    
    
    public void printMessage(String message)
    {
        messageLbl.setText(message);
    }

}
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        /*String charclass;
        String Name;
        
        Game_Actions game = new Game_Actions();
        int num = 2;
        
        while(num > 1)
        {
            System.out.println("Enter Name");
            Name = scan.nextLine();
            Classes player = new Classes(Name);
            System.out.println("Choose your class");
            System.out.println("'k' for knight");
            System.out.println("'r' for rogue");
            System.out.println("'w' for wizard");
            System.out.println("'b' for berserker");
            charclass = scan.nextLine();
            while(charclass.charAt(0) != 'k' && charclass.charAt(0) != 'r' && charclass.charAt(0) != 'w' && charclass.charAt(0) != 'b' && charclass.charAt(0) != 'a'){
                System.out.println("'k' for knight");
                System.out.println("'r' for rogue");
                System.out.println("'w' for wizard");
                System.out.println("'b' for berserker");
                charclass = scan.nextLine();
            }
            if(charclass.charAt(0) == 'k')
            {
                player.Knight();
            }
            else if(charclass.charAt(0) == 'r')
            {
                player.Rogue();
            }
            else if(charclass.charAt(0) == 'w')
            {
                player.Wizard();
            }
            else if(charclass.charAt(0) == 'b'){
                player.Berserker();
            }
            for(int currentLevel = 1; currentLevel <= 5; currentLevel ++)
            {
                while(player.level == currentLevel)
                {
                    Enemies enemy = new Enemies(player);
                    game.fight(player, enemy);
                }
                game.Display_status(player); 
            }
            */
            /*Game_Actions game = new Game_Actions();
            player.Rogue();//initializes class ENIMIES MUST BE INITIATED AFTER CLASS CREATION!
            Enemies enemy = new Enemies(player);
            game.Display_status(player); 
            game.fight(player, enemy);*/
        
        
        
        
        
        
        
        
    

