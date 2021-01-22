import java.util.ArrayList;
public class Dice {
    public static ArrayList<Integer> rollDice(int sides, int numRolls){
        ArrayList<Integer> rolls = new ArrayList<Integer>();
        for(int i = 0; i < numRolls; i++){
            rolls.add((int)(Math.random() * sides + 1));
        }
        return rolls;
    }    
}
