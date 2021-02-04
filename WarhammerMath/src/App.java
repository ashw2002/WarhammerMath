
public class App {
    public static void main(String[] args){
        Model Intercessor = new Model(6, 3, 3, 4, 4, 2, "2", 7, 3);
        Weapon PwrSwrd = new Weapon(0, "Melee", "User", "+1", 3, "1", Intercessor);
        System.out.println(Intercessor.fight(Intercessor, 0, PwrSwrd));
    }
}
