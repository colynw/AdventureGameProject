/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdventureSimulator;

import java.util.Scanner;

public class AdventureSimulator 
{
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args)
    {
        String Name;
        Game_Actions game = new Game_Actions();
        int num = 2;
        while(num > 1)
        {
            System.out.println("Enter Name");
            Name = scan.nextLine();
            Classes player = new Classes(Name);

            for(int currentLevel = 1; currentLevel <= 5; currentLevel ++)
            {
                while(player.level == currentLevel)
                {
                    Enemies enemy = new Enemies(player);
                    game.fight(player, enemy);
                }
                game.Display_status(player); 
            }

            /*Game_Actions game = new Game_Actions();
            player.Rogue();//initializes class ENIMIES MUST BE INITIATED AFTER CLASS CREATION!
            Enemies enemy = new Enemies(player);
            game.Display_status(player); 
            game.fight(player, enemy);*/
        }
        
        
        
        
        
        
    }
}
