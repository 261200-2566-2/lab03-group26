public class Character {
    private int level;
    private double hp;
    private double max_hp;
    private double mana;
    private double max_mana;
    double runSpeed;
    double max_runSpeed;
    double damage;
    private Shield shield;
    private Sword sword;
    private boolean sword_equip;
    private boolean shield_equip;
    String name;

    Character(String name, int level){
        this.name = name;
        this.level = level;
        this.max_hp = this.hp = 100*10*level;
        this.max_mana = this.mana = 50+2*level;
        this.max_runSpeed = this.runSpeed = 100;
        this.damage = 15; // Punch damage initialization
    }

    public void attack(Character c){
        double val = damage + (sword_equip ? sword.attackValue() : 0);
        c.receiveDamage(val);
    }

    public void receiveDamage(double damage){
        this.hp = hp + (shield_equip ? shield.defenseValue() : 0) - damage;
    }

    public void levelUp(){
        this.level++;
        this.max_hp = this.hp = 100*10*level;
        this.max_mana = this.mana = 50+2*level;
        System.out.println(name + "Level Up +++ !!! [Lvl." + level + "]");
    }

    public void setSword(){
        sword = new Sword(70);
        sword_equip = true;
    }

    public void clearSword(){
        sword_equip = false;
    }

    public void swordLevelUp(){
        sword.levelUp(this);
    }

    public void setShield(){
        shield = new Shield(120);
        shield_equip = true;
    }

    public void clearShield(){
        shield_equip = false;
    }

    public void setAllEquip(){
        setSword();
        setShield();
    }

    public void clearAllEquip(){
        clearSword();
        clearShield();
    }

}
