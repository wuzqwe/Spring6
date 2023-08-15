package factory;

public class Test {
    public static void main(String[] args) {
        WeaponFactory weaponFactory=new FighterFactory();
        weaponFactory.get().attack();

        WeaponFactory weaponFactory1=new TankFactory();
        weaponFactory1.get().attack();
    }
}
