import java.util.*;
public class AdventureSimulator {
    static Scanner scan = new Scanner(System.in);
    static Random rand = new Random();
    static dice die = new dice();
    public static String playerName;
    public static int playerhp;
    public static int maxhp;
    public static int maxmana;
    public static int mana;
    public static int playermeleedmg;
    public static int xp;
    public static int enemyhp;
    public static int enemymeleedmg;
    public static int Level;
    public static String charclass;
    public static boolean fighting = false;

    private static void printStats() {
        if(charclass.equals("wizard")){
            System.out.println(playerName + "\nhp: " + playerhp + "\nmana: " + mana + "\ndamage: " + playermeleedmg + "\nxp: " + xp + "\n");
        }else{
            System.out.println(playerName + "\nhp: " + playerhp + "\ndamage: " + playermeleedmg + "\nxp: " + xp + "\n");
        }
    }
    private static void printEnemyStats() {
        System.out.println("Enemy "+"\nhp: " + enemyhp + "\ndamage: " + enemymeleedmg + "\n");
    }

    private static void buildKnight() {
        charclass = "knight";
        maxhp = 20;
        playerhp = 20;
        playermeleedmg = 4;
        xp = 0;
        Level = 1;
    }
    private static void buildRogue() {
        charclass = "rogue";
        maxhp = 14;
        playerhp = 14;
        playermeleedmg = 6;
        xp = 0;
        Level = 1;
    }
    private static void buildWizard() {
        charclass = "wizard";
        maxhp = 10;
        playerhp = 10;
        mana = 20;
        maxmana = 20;
        playermeleedmg = 2;
        xp = 0;
        Level = 1;
    }
    private static void buildBerserker() {
        charclass = "berserker";
        maxhp = 28;
        playerhp = 28;
        playermeleedmg = 8;
        xp = 0;
        Level = 1;
    }
    private static void buildAdmin() {
        charclass = "admin";
        maxhp = 1000;
        playerhp = 1000;
        playermeleedmg = 100;
        xp = 0;
        Level = 1;
        //Class used for late game testing
    }
    private static void buildEnemy() {
        switch(Level){
            case 1:
                enemyhp = 9;
                enemymeleedmg = 1;
                break;
            case 2:
                enemyhp = 19;
                enemymeleedmg = 4;
                break;
            case 3:
                enemyhp = 24;
                enemymeleedmg = 6;
                break;
            case 4:
                enemyhp = 32;
                enemymeleedmg = 7;
                break;
            case 5:
                enemyhp = 40;
                enemymeleedmg = 9;
                break;
            case 6:
                enemyhp = 65;
                enemymeleedmg = 11;
                break;
        }
    }
    private static void fight() {
        String action;
        String spellAction = null;
        System.out.println("An enemy approaches");
        buildEnemy();
        fighting = true;
        while(fighting = true){
            System.out.println("Press 'a' to attack\nPress 'i' for info");
            if(charclass.equals("wizard")){
                System.out.print("Press 's' for spells\n");
            }
            action = scan.nextLine();
            if(action.charAt(0) == 'a'){
                fighting = attack();
                if(fighting == false){
                    switch(Level){
                        case 1:
                            xp = xp + 4;
                            break;
                        case 2:
                            xp = xp + 6;
                            break;
                        case 3:
                            xp = xp + 9;
                            break;
                        case 4:
                            xp = xp + 12;
                            break;
                    }
                    System.out.println("You earned :" + xp + " xp");
                    checkLevelUp();
                    return;
                }
                enemyattack();
            }

            if(action.charAt(0) == 'i'){
                printStats();
                printEnemyStats();

            }
            if(action.charAt(0) == 's'){
                System.out.println("Press 'f' for fireball\nPress 'h' to heal\n");
                spellAction = scan.nextLine();
                if(spellAction.charAt(0) == 'f'){
                    if(die.roll10() > 2){
                        mana = mana - 10;
                        if(mana <0){
                            System.out.println("You don't have enough mana...");
                            mana = mana + 10;
                        }else{
                            int k = die.roll10();
                            System.out.println("You hit for " + k + " damage!");
                            enemyhp = enemyhp - k;
                            if(enemyhp <= 0){
                                System.out.println("You Won!");
                                switch(Level){
                                    case 1:
                                        xp = xp + 4;
                                        break;
                                    case 2:
                                        xp = xp + 6;
                                        break;
                                    case 3:
                                        xp = xp + 9;
                                        break;
                                    case 4:
                                        xp = xp + 12;
                                        break;
                                }
                                System.out.println("You earned :" + xp + " xp");
                                checkLevelUp();
                                return;
                            }
                            enemyattack();
                        }
                    }
                    else{
                        System.out.println("You miss!");
                        enemyattack();
                    }
                }else
                if(spellAction.charAt(0) == 'h'){
                    mana = mana - 8;
                    if(mana <0){
                        System.out.println("You don't have enough mana...");
                        mana = mana + 8;
                    }else{
                        int x = die.roll10();
                        System.out.println("You heal your wounds...");
                        System.out.println("+ " + x + " hp");
                        playerhp = playerhp + x;
                        if(playerhp>maxhp){
                            playerhp = maxhp;
                        }
                        enemyattack();
                    }
                }

            }
        }
    }

    private static void checkLevelUp() {
        if(xp >= 1000 && Level == 6){
            System.out.println("Level 7!");
            Level = Level + 1;
            maxhp = maxhp + 25;
            playerhp = maxhp;
            if(charclass.equals("wizard")){
                maxmana = maxmana + 7;
                mana = maxmana;
            }
            playermeleedmg = playermeleedmg + 3;
            printStats();
        }else
        if(xp >= 400 && Level == 5){
            System.out.println("Level 6!");
            Level = Level + 1;
            maxhp = maxhp + 25;
            playerhp = maxhp;
            if(charclass.equals("wizard")){
                maxmana = maxmana + 7;
                mana = maxmana;
            }
            playermeleedmg = playermeleedmg + 3;
            printStats();
        }else
        if(xp >= 100 && Level == 4){
            System.out.println("Level 5!");
            Level = Level + 1;
            maxhp = maxhp + 25;
            playerhp = maxhp;
            if(charclass.equals("wizard")){
                maxmana = maxmana + 7;
                mana = maxmana;
            }
            playermeleedmg = playermeleedmg + 3;
            printStats();
        }else
        if(xp >= 50 && Level == 3){
            System.out.println("Level 4!");
            Level = Level + 1;
            maxhp = maxhp + 20;
            playerhp = maxhp;
            if(charclass.equals("wizard")){
                maxmana = maxmana + 7;
                mana = maxmana;
            }
            playermeleedmg = playermeleedmg + 2;
            printStats();
        }else
        if(xp >= 25 && Level == 2){
            System.out.println("Level 3!");
            Level = Level + 1;
            maxhp = maxhp + 10;
            playerhp = maxhp;
            if(charclass.equals("wizard")){
                maxmana = maxmana + 7;
                mana = maxmana;
            }
            playermeleedmg = playermeleedmg + 2;
            printStats();
        }else
        if(xp >= 10 && Level == 1){
            System.out.println("Level 2!");
            Level = Level + 1;
            maxhp = maxhp + 5;
            playerhp = maxhp;
            if(charclass.equals("wizard")){
                maxmana = maxmana + 7;
                mana = maxmana;
            }
            playermeleedmg = playermeleedmg + 1;
            printStats();
        }

    }
    private static void enemyattack() {
        if(die.roll6() > 2){
            System.out.println("Enemy hits!");
            playerhp = playerhp - enemymeleedmg;
            if(playerhp <= 0){
                gameover();
                System.exit(0);
            }
        }else{
            System.out.println("Enemy Misses!");
        }
        if(charclass.equals("berserker")){
            playerhp = playerhp - 3;
            System.out.println("Your Rage eats away part of your life force!");
        }
    }
    private static boolean attack() {
        if(die.roll6() > 2){
            System.out.println("You hit!");
            enemyhp = enemyhp - playermeleedmg;
            if(enemyhp <= 0){
                System.out.println("You Won!");
                return false;
            }
        }else{
            System.out.println("You miss!");
        }
        return true;
    }

    private static void gameover() {
        System.out.println(playerName + " Died!") ;
        System.out.println("GAME OVER!");
        System.exit(0);
        return;
    }
    public static void main(String[] args) {
        String charclass;
        int num = 2;
        while(num > 1){
            System.out.println("Enter Character Name: ");
            playerName = scan.nextLine();
            System.out.println("Choose your class: ");
            System.out.println("'k' for knight");
            System.out.println("'r' for rogue");
            System.out.println("'w' for wizard");
            System.out.println("'b' for berserker");
            System.out.println("'a' for admin");
            charclass = scan.nextLine();
            while(charclass.charAt(0) != 'k' && charclass.charAt(0) != 'r' && charclass.charAt(0) != 'w'
                    && charclass.charAt(0) != 'b' && charclass.charAt(0) != 'a'){
                System.out.println("'k' for knight");
                System.out.println("'r' for rogue");
                System.out.println("'w' for wizard");
                System.out.println("'b' for berserker");
                System.out.println("'a' for admin");
                charclass = scan.nextLine();
            }
            if(charclass.charAt(0) == 'k'){
                buildKnight();
            }
            else if(charclass.charAt(0) == 'r'){
                buildRogue();
            }
            else if(charclass.charAt(0) == 'w'){
                buildWizard();
            }
            else if(charclass.charAt(0) == 'b'){
                buildBerserker();
            }
            else if(charclass.charAt(0) == 'a'){
                buildAdmin();
            }
            printStats();
            for (int currentLevel = 1; currentLevel <= 5; currentLevel++) {
                while(Level == currentLevel){
                    fight();
                }
                System.out.println("This area is clear... time to move on\n");
            }
        }

    }
}



