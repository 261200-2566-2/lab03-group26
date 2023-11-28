import javax.lang.model.element.Name;

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
        System.out.println("Create Hero Name : " + name);
        status();

    }

    public void attack(Character c){
        double val = damage + (sword_equip ? sword.attackValue() : 0);
        c.receiveDamage(val);
        System.out.println("---------------------------------------------------");
        System.out.println(this.name + " attack " + c.name);
        System.out.println(this.name + " +atk : " + val);
        System.out.println(c.name + " -def : " + (c.shield_equip ? c.shield.defenseValue() : 0));
        if (val <= (c.shield_equip ? c.shield.defenseValue() : 0))
            System.out.println("total atk : 0");
        else
            System.out.println("total atk : " + (val - (c.shield_equip ? c.shield.defenseValue() : 0)));
        System.out.println(c.name + "HP : "+ c.hp);
        System.out.println("---------------------------------------------------");
    }

    /*ลืมเขียนเงื่อนไขที่ว่า */
    public void receiveDamage(double damage){
        if(((shield_equip ? shield.defenseValue() : 0) - damage) >= 0)
            this.hp = hp + 0;
        else
            this.hp = hp + (shield_equip ? shield.defenseValue() : 0) - damage;
    }

    public void levelUp(){
        this.level++;
        this.max_hp = this.hp = 100*10*level;
        this.max_mana = this.mana = 50+2*level;
        System.out.println(name + "Level Up +++ !!! [Lvl." + level + "]");
        status();
    }

    public void status(){
        System.out.println("---------------------------------------------------");
        System.out.println("Status :");
        System.out.println("Name : " + this.name);
        System.out.println("Level : " + this.level);
        System.out.println("HP : " + this.hp);
        System.out.println("Mana : "+ this.mana);
        System.out.println("Damage : " + (this.damage + (this.sword_equip ? this.sword.attackValue() : 0)));
        System.out.println("RunSpeed : "+this.runSpeed);
        if(this.sword_equip)
            System.out.println("Sword : Have Sword") ;
        else
            System.out.println("Sword : Not Have Sword");
        if(this.shield_equip)
            System.out.println("Sword : Have Shield") ;
        else
            System.out.println("Sword : Not Have Shield");
        System.out.println("---------------------------------------------------");
    }

    public void setSword(){
        sword = new Sword(70);
        sword_equip = true;
        System.out.println("---------------------------------------------------");
        System.out.println("Hero : " + this.name);
        System.out.println("Equip a Sword ....");
        System.out.println("Sword Damage : " + sword.attackValue());
        System.out.println("---------------------------------------------------");
    }

    public void clearSword(){
        sword_equip = false;
        System.out.println("---------------------------------------------------");
        System.out.println("Hero : " + this.name);
        System.out.println("Now Not Have Sword");
        System.out.println("---------------------------------------------------");
    }

    public void swordLevelUp(){
        sword.levelUp(this);
        System.out.println("---------------------------------------------------");
        System.out.println("Hero : " + this.name);
        System.out.println("Sword LevelUp .....");
        System.out.println("Sword Damage : " + sword.attackValue());
        System.out.println("---------------------------------------------------");
    }

    public void setShield(){
        shield = new Shield(120);
        shield_equip = true;
        System.out.println("---------------------------------------------------");
        System.out.println("Hero : " + this.name);
        System.out.println("Equip a Shield ....");
        System.out.println("Shield Defense : " + shield.defenseValue());
        System.out.println("---------------------------------------------------");
    }

    public void clearShield(){
        shield_equip = false;
        System.out.println("---------------------------------------------------");
        System.out.println("Equip a Shield ....");
        System.out.println("Shield Defense : " + shield.defenseValue());
        System.out.println("---------------------------------------------------");
    }

    //อันนี้ลืมเพิ่ม
    public void shieldLevelUp(){
        shield.levelUp(this);
        System.out.println("---------------------------------------------------");
        System.out.println("Hero : " + this.name);
        System.out.println("Shield LevelUp .....");
        System.out.println("Shield Defense : " + shield.defenseValue());
        System.out.println("---------------------------------------------------");
    }

    public void setAllEquip(){
        setSword();
        setShield();
    }

    public void clearAllEquip(){
        clearSword();
        clearShield();
    }

    //เพิ่มให้
    public void levelUpAllEquip(){
        swordLevelUp();
        shieldLevelUp();
    }

    public static void main(String[] args) {
        Character a = new Character("PremX",2);
        Character b = new Character("Mrj",100);
        b.setSword();
        a.setShield();
        for (int i =0;i<20;i++){
            b.swordLevelUp();
        }
        a.status();
        b.status();
        b.attack(a);
        a.status();
        b.status();
        for (int i =0;i<20;i++){
            a.shieldLevelUp();
        }
        b.attack(a);
        a.status();
        b.status();
    }



}