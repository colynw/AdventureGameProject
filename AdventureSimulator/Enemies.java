/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdventureSimulator;


public class Enemies 
{   //variables//
    protected int enemyhp;
    protected int enemy_melee_dmg;
    static dice die = new dice();
    
    //methods//
    protected Enemies(Classes player)
    {
        //System.out.println("Player level:"+player.level+"\n");
        switch(player.level)
        {
            case 1:
                this.enemyhp = 9;
                this.enemy_melee_dmg =1;
                break;
            case 2:
                enemyhp = 19;
                enemy_melee_dmg = 4;
                break;
            case 3:
                enemyhp = 24;
                enemy_melee_dmg = 6;
                break;
            case 4:
                enemyhp = 32;
                enemy_melee_dmg = 7;
                break;
            case 5:
                enemyhp = 40;
                enemy_melee_dmg = 9;
                break;
            case 6:
                enemyhp = 65;
                enemy_melee_dmg = 11;
                break;
        }
        
        
    }
    protected void printEnemyStats()
    {
        System.out.println("Enemy "+"\nhp: " + enemyhp + "\ndmg: " + enemy_melee_dmg + "\n");
    }
    protected void enemyattack(Classes player,Enemies enemy)
    {
        Game_Actions game = new Game_Actions(); //initiates game
        if(die.roll6() > 2)
        {
            System.out.println("Enemy hits!");
            player.playerhp = player.playerhp - enemy.enemyhp;
            if(player.playerhp <= 0)
            {
                game.gameover(player);
                System.out.println("you loose");
                System.exit(0);
            }
            else
            {
               System.out.println("Enemy Misses!");
            }
            if(player.char_class.equals("Berserker"))
            {
                player.playerhp = player.playerhp - 3;
                System.out.println("Your Rage eats away part of your life force!");
                
            }
        }
    }
}
