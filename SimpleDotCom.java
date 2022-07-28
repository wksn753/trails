import java.util.ArrayList;
import java.util.Scanner;

public class SimpleDotCom {
    static Scanner sc;
    ArrayList<Integer> locationCells;
    Boolean isAlive;
    int numGuess;
    String status;
    String checkYourSelf(String guess){
        int guesses=Integer.parseInt(guess);
        for(Integer e:locationCells){
            if(e.equals(guesses)){
                locationCells.remove(e);
                if(this.locationCells.isEmpty()){
                  this.status="kill";
                  break;
                }
                this.status="hit";
                break;
            }else {
                this.status="miss";
            }
        }
        return status;
    }
    //insert random values into guess array
    void setLocationCells(ArrayList<Integer> arrayList){
        for(int i=0;i<4;i++){
            int randNum=(int)Math.floor(Math.random()*5);
            //System.out.println(randNum); print the random numbers required
            arrayList.add(randNum+2);
        }
    }
     public static void main(String[] args){
        SimpleDotCom game= new SimpleDotCom();
        game.locationCells=new ArrayList<Integer>();
        sc=new Scanner(System.in);
        String userGuess;
        game.setLocationCells(game.locationCells);

         game.isAlive=true;
         //run so long as user has more location cells to hit
         while(game.isAlive){
             System.out.println("Enter guess");
             userGuess=sc.next();
             System.out.println(game.checkYourSelf(userGuess));
             game.numGuess++;
             if(game.locationCells.isEmpty()){
                 game.isAlive=false;
                 System.out.println(game.numGuess);
                 break;
             }
         }
     }

}
