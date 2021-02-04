import java.util.ArrayList;
public class Dice {
    //Rolls any number of any sided dice and returns results as an Integer ArrayList
    public static ArrayList<Integer> rollDice(int sides, int numRolls){
        ArrayList<Integer> rolls = new ArrayList<Integer>();
        for(int i = 0; i < numRolls; i++){
            rolls.add((int)(Math.random() * sides + 1));
        }
        return rolls;
    }   
    //Will take any numbers out of any string that could be found in a WH40K datasheet.
    //if a Dice roll (2D3) is required it will return an appropriate random int
    public static int extractString(String str){
        if (Character.isDigit(str.charAt(0))){
            //Converts Chars to Ints if no preceading symbols found (ex: "4" - > 4)
            return Character.getNumericValue(str.charAt(0));
        }else if (str.charAt(1) == 'D'){
            //returns random value when given a dice roll.  Often D3. (ex: 2D3 -> between 2 and 6)
            ArrayList<Integer> rolls = rollDice(Character.getNumericValue(str.charAt(2)), Character.getNumericValue(str.charAt(0)));
            int total = 0;
            for(int i = 0; i< rolls.size(); i++){
                total += rolls.get(i);
            }
            return total;
        }else if(!Character.isDigit(str.charAt(0)) && Character.isDigit(str.charAt(1))){
            //gets int out from modified values. (ex: "x2" -> 2)
            return str.charAt(1);
        }
        //returns 0 if none of the conditions above are met
        return 0;
    } 
} 
