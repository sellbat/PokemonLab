public class Pokemon {
    public String name;

    public int baseHp;
    public int baseAttack;
    public int baseDefense;

    public int hpIV;
    public int attackIV;
    public int defenseIV;

    public int hpEV;
    public int attackEV;
    public int defenseEV;

    public int hpEVDefeatYield;
    public int attackEVDefeatYield;
    public int defenseEVDefeatYield;

    public Attack[] attacks;

    public int currentHp;
    public int maxHp;

    public int level;

    public boolean fainted;

    Pokemon(String name, int baseHp, int baseAttack, int baseDefense, int hpIV, int attackIV, int defenseIV, int hpEV, int attackEV, int defenseEV, int hpEVDefeatYield, int attackEVDefeatYield, int defenseEVDefeatYield, Attack[] attacks, int currentHp, int level) {
        this.name = name;

        this.baseHp = baseHp;
        this.baseAttack = baseAttack;
        this.baseDefense = baseDefense;

        this.hpIV = hpIV;
        this.attackIV = attackIV;
        this.defenseIV = defenseIV;

        this.hpEV = hpEV;
        this.attackEV = attackEV;
        this.defenseEV = defenseEV;

        this.hpEVDefeatYield = hpEVDefeatYield;
        this.attackEVDefeatYield = attackEVDefeatYield;
        this.defenseEVDefeatYield = defenseEVDefeatYield;

        this.attacks = attacks;

        this.level = level;

        this.maxHp =  (int) ((0.01 * (2 * baseHp + hpIV + (int)(0.25 * hpEV)) * level) + level + 10);

        this.currentHp = currentHp;

        this.fainted = !(currentHp > 0);

    }
}
