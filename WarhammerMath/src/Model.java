import java.util.ArrayList;
public class Model {
    private int moveVal;
    private int WSkill;
    private int BSkill;
    private int strength;
    private int toughness;
    private int wound;
    private int attack;
    private int lead;
    private int save;
    public Model(int M, int WS, int BS, int S, int T, int W, int A, int Ld, int Sv){
        moveVal = M;
        WSkill = WS;
        BSkill = BS;
        strength = S;
        toughness = T;
        wound = W;
        attack = A;
        lead = Ld;
        save = Sv;
    }
    public String fight(Model target){
        ArrayList<Integer> toRoll = Dice.rollDice(6, attack);
        //Represents the Hit roll
        for(int i = 0; i < toRoll.size(); i++){
            if(toRoll.get(i) < WSkill){
                toRoll.remove(i);
            }
        }
        if(toRoll.size() == 0){
            return "No Wounds";
        }
        //Represents the wound rolls
        toRoll = Dice.rollDice(6, toRoll.size());
        for(int i = 0; i < toRoll.size(); i++){
            if(toRoll.get(i) < toWound(strength, target.getT())){
                toRoll.remove(i);
            }
        }
        if(toRoll.size() == 0){
            return "No Wounds";
        }
        //Represents the Armor Saves
        toRoll = Dice.rollDice(6, toRoll.size());
        for(int i = 0; i < toRoll.size(); i++){
            if(toRoll.get(i) < target.getSv()){
                toRoll.remove(i);
            }
        }
        if(toRoll.size() == 0){
            return "No Wounds";
        }else{
            return "Your Model Scored " + toRoll.size() + " successfull  wound(s)";
        }
    }
    public String avgFight(Model target){
        double hitChance = (6.0-(WSkill - 1.0))/6.0;
        double expHit = (attack * 1.0) * hitChance;
        
        double woundChance = (6.0-((toWound(strength, target.getT()) - 1) * 1.0)) / 6.0;
        double expWound = expHit * woundChance;

        double APChance = (target.getSv() - 1)/6.0;
        double expAP = APChance * expWound;
        return "" + expAP;
    }
    private int toWound(int Str, int Tgh){
        if(Str >= Tgh * 2){
            return 2;
        }else if(Str > Tgh){
            return 3;
        }else if(Str == Tgh){
            return 4;
        }else if(Str <= Tgh / 2){
            return 6;
        }else{
            return 5;
        }
    }
    public int getM(){
        return moveVal;
    }
    public int getWS(){
        return WSkill;
    }
    public int getBS(){
        return BSkill;
    }
    public int getStr(){
        return strength;
    }
    public int getT(){
        return toughness;
    }
    public int getWnd(){
        return wound;
    }
    public int getAtk(){
        return attack;
    }
    public int getLd(){
        return lead; 
    }
    public int getSv(){
        return save;
    }

}
