package factory;

/**
 * 具体工厂角色
 */
public class FighterFactory extends WeaponFactory{
    @Override
    public Weapon get() {
        return new Fighter();
    }
}
