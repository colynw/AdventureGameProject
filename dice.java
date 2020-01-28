import java.util.*;
public class dice {

    public int roll6(){
        Random rand = new Random();
        int n = rand.nextInt(7);
        while(n == 0){
            n = rand.nextInt(7);
        }//1-6
        return n;
    }
    public int roll10(){
        Random rand = new Random();
        int n = rand.nextInt(11);
        while(n == 0){
            n = rand.nextInt(11);
        }
        return n;
    }//1-10
    public int roll20(){
        Random rand = new Random();
        int n = rand.nextInt(21);
        while(n == 0){
            n = rand.nextInt(21);
        }//1-20
        return n;
    }

}