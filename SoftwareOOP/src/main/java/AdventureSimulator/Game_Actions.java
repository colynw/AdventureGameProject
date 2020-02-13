/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdventureSimulator;

import static AdventureSimulator.Classes.die;
import static AdventureSimulator.Classes.fighting;
import static AdventureSimulator.Classes.scan;



public class Game_Actions 
{
    String PlayerTxt;
    int enemyhp = 0;
    int enemy_melee_dmg = 0;
    
    
    
    public String Display_status(Classes player) //displays player status
    {
        //System.out.println(player.Name + "\nhp: " + player.playerhp + "\nmana: " + player.mana + "\ndamage: " + player.player_melee_dmg + "\nxp: " + player.xp + "\n");
        String text = (player.Name + "\nhp: " + player.playerhp + "\nmana: " + player.mana + "\ndamage: " + player.player_melee_dmg + "\nxp: " + player.xp + "\n");
        return text;
    }
    
    
    
    public void fight(Classes player, Enemies enemy) //initiates combat
    {
        String action;
        String spellAction = null;
        //System.out.println("An enemy approaches");
        
        
        fighting = true;

            //System.out.println("Press 'a' to attack\nPress 'i' for info");
            if(player.char_class.equals("Wizard"))
            {
                System.out.print("Press 's' for spells \n");
            }
            //action = scan.nextLine();
            /*if(action.charAt(0)== 'a')
            {*/
                fighting = attack(player,enemy);
                if(fighting == false)
                {
                    switch(player.level)
                    {
                        case 1:
                            player.xp = player.xp + 4;
                            break;
                        case 2:
                            player.xp = player.xp + 6;
                            break;
                        case 3:
                            player.xp = player.xp + 9;
                            break;
                        case 4:
                            player.xp = player.xp + 12;
                            break;
                    }
                    System.out.println("You earned :" + player.xp + " xp");
                    checkLevelUp(player);
                    return;
                }
                enemy.enemyattack(player,enemy);
            //}
            /*if(action.charAt(0) == 'i')
                {
                        Display_status(player);
                        enemy.printEnemyStats();
          
                    
                }*/
            /*if(action.charAt(0) == 's')
            {
                System.out.println("Press 'f' for fireball\nPress 'h' to heal\n");
                spellAction = scan.nextLine();
                                if(spellAction.charAt(0) == 'f'){
                    if(die.roll10() > 2){
                        player.mana = player.mana - 10;
                        if(player.mana <0){
                            System.out.println("You don't have enough mana...");
                            player.mana = player.mana + 10;
                        }else{
                            int k = die.roll10();
                            System.out.println("You hit for " + k + " damage!");
                            enemy.enemyhp = enemy.enemyhp - k;
                            if(enemy.enemyhp <= 0){
                                System.out.println("You Won!");
                                switch(player.level){
                                    case 1:
                                        player.xp = player.xp + 4;
                                        break;
                                    case 2:
                                        player.xp = player.xp + 6;
                                        break;
                                    case 3:
                                        player.xp = player.xp + 9;
                                        break;
                                    case 4:
                                        player.xp = player.xp + 12;
                                        break;
                                }
                                System.out.println("You earned :" + player.xp + " xp");
                                checkLevelUp(player);
                                return;
                            }
                            enemy.enemyattack(player, enemy);
                        }
                    }
                    else{
                        System.out.println("You miss!");
                        enemy.enemyattack(player,enemy);
                    }
                }
            }
                    
                
        }*/
        
        
    }
    public boolean attack(Classes player,Enemies enemy)
    {
        if(die.roll6() >2)
        {
            System.out.println("You hit!");
            PlayerTxt = ("You hit!");
            enemy.enemyhp = enemy.enemyhp - player.player_melee_dmg;
            if(enemy.enemyhp <= 0)
            {
                System.out.println("You Won!");
                PlayerTxt = ("You Won!");
                return false;
            }
            
        }
        else
            {
                System.out.println("You miss!");
                PlayerTxt = ("You Miss!");
            }   
        return true;
    }
    public static void gameover(Classes player)
    {
        System.out.println(player.Name + " Died!") ;
        System.out.println("GAME OVER!");
        System.exit(0);
        return;
    }
    
 
    
    
    protected void checkLevelUp(Classes player) 
        {
        if(player.xp >= 1000 && player.level == 6){
            System.out.println("Level 7!");
            player.level = player.level + 1;
            player.maxhp = player.maxhp + 25;
            player.playerhp = player.maxhp;
            if(player.char_class.equals("wizard")){
                player.maxmana = player.maxmana + 7;
                player.mana = player.maxmana;
            }
            player.player_melee_dmg = player.player_melee_dmg + 3;
            Display_status(player);
        }else
        if(player.xp >= 400 && player.level == 5){
            System.out.println("Level 6!");
            player.level = player.level + 1;
            player.maxhp = player.maxhp + 25;
            player.playerhp = player.maxhp;
            if(player.char_class.equals("wizard")){
                player.maxmana = player.maxmana + 7;
                player.mana = player.maxmana;
            }
            player.player_melee_dmg = player.player_melee_dmg + 3;
            Display_status(player);
        }else
        if(player.xp >= 100 && player.level == 4){
            System.out.println("Level 5!");
            player.level = player.level + 1;
            player.maxhp = player.maxhp + 25;
            player.playerhp = player.maxhp;
            if(player.char_class.equals("wizard")){
                player.maxmana = player.maxmana + 7;
                player.mana = player.maxmana;
            }
            player.player_melee_dmg = player.player_melee_dmg + 3;
            Display_status(player);
        }else
        if(player.xp >= 50 && player.level == 3){
            System.out.println("Level 4!");
            player.level = player.level + 1;
            player.maxhp = player.maxhp + 20;
            player.playerhp = player.maxhp;
            if(player.char_class.equals("wizard")){
                player.maxmana = player.maxmana + 7;
                player.mana = player.maxmana;
            }
            player.player_melee_dmg = player.player_melee_dmg + 2;
            Display_status(player);
        }else
        if(player.xp >= 25 && player.level == 2){
            System.out.println("Level 3!");
            player.level = player.level + 1;
            player.maxhp = player.maxhp + 10;
            player.playerhp = player.maxhp;
            if(player.char_class.equals("wizard")){
                player.maxmana = player.maxmana + 7;
                player.mana = player.maxmana;
            }
            player.player_melee_dmg = player.player_melee_dmg + 2;
            Display_status(player);
        }else
        if(player.xp >= 10 && player.level == 1){
            System.out.println("Level 2!");
            player.level = player.level + 1;
            player.maxhp = player.maxhp + 5;
            player.playerhp = player.maxhp;
            if(player.char_class.equals("wizard"))
            {
                player.maxmana = player.maxmana + 7;
                player.mana = player.maxmana;
            }
            player.player_melee_dmg = player.player_melee_dmg + 1;
            Display_status(player);
        }

    }
}
