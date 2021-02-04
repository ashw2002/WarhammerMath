public class Weapon {
    private int range;
    private String type;
    private String shots;
    private String strMod;
    private int AP;
    private String damage;
    private Model weilder;

    public Weapon(int tmpRng, String tmpType, String tmpSh, String tmpStr, int tmpAP, String tmpDmg, Model tmpMdl){
        range = tmpRng;
        type = tmpType;
        shots = tmpSh;
        strMod = tmpStr;
        AP = tmpAP;
        damage = tmpDmg;
        weilder = tmpMdl;
    }
    public String shoot (int range){
        return "";
    }
    public int getRange(){
        return range;
    }
    public String getType(){
        return type;
    }
    public String getShots(){
        return shots;
    }
    public String getStrMod(){
        return strMod;
    }
    public int getAP(){
        return AP;
    }
    public String getDamage(){
        return damage;
    }
    public Model getWeilder(){
        return weilder;
    }
}
