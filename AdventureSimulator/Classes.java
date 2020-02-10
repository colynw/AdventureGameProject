
package AdventureSimulator;

import java.util.Scanner;

public class Classes 
{   
    //variables//
    protected String Name;
    protected int Health;
    protected String char_class;
    protected int maxhp;
    protected int playerhp;
    protected int mana,maxmana;
    protected int player_melee_dmg;
    protected int xp;
    protected int level;
    protected static boolean fighting = false; 
    static dice die = new dice();
    //Enemies enemy = new Enemies(1,1);
    static Scanner scan = new Scanner(System.in);
    //end of variable declaration//
    
    Classes(String Name)
    {
        this.Name = Name;
        this.selectClass();
    }
    
    //class methods//
    protected void Rogue()
    {
        char_class = "Rogue";
        maxhp = 14;
        playerhp = 14;
        player_melee_dmg = 6;
        xp = 0;
        level = 1;
        
    }
    
    protected void Wizard()
    {
        char_class = "Wizard";
        maxhp = 10;
        playerhp = 10;
        mana = 20;
        maxmana = 20;
        player_melee_dmg = 2;
        xp = 0;
        level = 1;
    }
   
    protected void Berserker()
    {
        char_class = "Berserker";
        maxhp = 28;
        playerhp = 28;
        player_melee_dmg = 8;
        xp = 0;
        level = 1;
        
    }
    
    protected void Knight()
    {
        char_class = "Knight";
        maxhp = 20;
        playerhp = 20;
        player_melee_dmg = 4;
        xp = 0;
        level = 1;
    }

    protected void selectClass() {
        System.out.println("Choose your class");
        System.out.println("'k' for knight");
        System.out.println("'r' for rogue");
        System.out.println("'w' for wizard");
        System.out.println("'b' for berserker");
        String charclass = scan.nextLine();
        while(charclass.charAt(0) != 'k' && charclass.charAt(0) != 'r' && charclass.charAt(0) != 'w' && charclass.charAt(0) != 'b' && charclass.charAt(0) != 'a'){
            System.out.println("'k' for knight");
            System.out.println("'r' for rogue");
            System.out.println("'w' for wizard");
            System.out.println("'b' for berserker");
            charclass = scan.nextLine();
        }
        if(charclass.charAt(0) == 'k')
        {
            this.Knight();
        }
        else if(charclass.charAt(0) == 'r')
        {
            this.Rogue();
        }
        else if(charclass.charAt(0) == 'w')
        {
            this.Wizard();
        }
        else if(charclass.charAt(0) == 'b'){
            this.Berserker();
        }
    }

}

