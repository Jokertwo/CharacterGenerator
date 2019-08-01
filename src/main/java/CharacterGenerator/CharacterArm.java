package CharacterGenerator;

public class CharacterArm {

    private Arm arm;
    private Weapon weapon;

    public CharacterArm(Arm arm){
        this.arm = arm;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon){
        this.weapon = weapon;
    }

    /**
     * get arm, either Left or Right.
     * @return arm
     */
    public Arm getArm() {
        return arm;
    }

    public boolean hasWeapon() {
        if (weapon != null) {
            return true;
        }
        return false;
    }

}
