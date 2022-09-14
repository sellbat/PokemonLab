public class PokemonSpecies {
    enum SpeciesChoices {Pikachu, Ivysaur, Charizard, Squirtle, Pidgey, Jigglypuff};

    private SpeciesChoices name;

    private Type type1;
    private Type type2;

    private int baseHp;
    private int baseAttack;
    private int baseDefense;

    private int baseSpeed;

    private int hpEVDefeatYield;
    private int attackEVDefeatYield;
    private int defenseEVDefeatYield;

    PokemonSpecies(SpeciesChoices speciesChoice) {
        this.name = speciesChoice;

        switch(speciesChoice) {
            case Pikachu:
                setSpeciesStats(StaticVars.TYPE.ELECTRIC, StaticVars.TYPE.NONE, 35, 55, 40, 90, 0, 0, 0);
                break;

            case Ivysaur:
                setSpeciesStats(StaticVars.TYPE.GRASS, StaticVars.TYPE.POISON, 60, 62, 63, 60, 0, 0, 0);
                break;

            case Charizard:
                setSpeciesStats(StaticVars.TYPE.FIRE, StaticVars.TYPE.FLYING, 78, 84, 78, 100, 0, 0, 0);
                break;

            case Squirtle:
                setSpeciesStats(StaticVars.TYPE.WATER, StaticVars.TYPE.NONE, 44, 48, 65, 43, 0, 0, 1);
                break;

            case Pidgey:
                setSpeciesStats(StaticVars.TYPE.NORMAL, StaticVars.TYPE.FLYING, 40, 45, 40, 56, 0, 0, 0);
                break;

            case Jigglypuff:
                setSpeciesStats(StaticVars.TYPE.NORMAL, StaticVars.TYPE.FAIRY, 115, 45, 20, 20, 2, 0, 0);
                break;

            default:
                setSpeciesStats(StaticVars.TYPE.NONE, StaticVars.TYPE.NONE,40, 40, 40, 40, 0, 0, 0);
                break;
        }
    }

    private void setSpeciesStats(Type type1, Type type2, int baseHp, int baseAttack, int baseDefense, int baseSpeed, int hpEVDefeatYield, int attackEVDefeatYield, int defenseEVDefeatYield) {
        this.type1 = type1;
        this.type2 = type2;

        this.baseHp = baseHp;
        this.baseAttack = baseAttack;
        this.baseDefense = baseDefense;

        this.baseSpeed = baseSpeed;

        this.hpEVDefeatYield = hpEVDefeatYield;
        this.attackEVDefeatYield = attackEVDefeatYield;
        this.defenseEVDefeatYield = defenseEVDefeatYield;
    }

    public SpeciesChoices getName() {
        return name;
    }

    public void setName(SpeciesChoices name) {
        this.name = name;
    }

    public Type getType1() {
        return type1;
    }

    public void setType1(Type type1) {
        this.type1 = type1;
    }

    public Type getType2() {
        return type2;
    }

    public void setType2(Type type2) {
        this.type2 = type2;
    }

    public int getBaseHp() {
        return baseHp;
    }

    public void setBaseHp(int baseHp) {
        this.baseHp = baseHp;
    }

    public int getBaseAttack() {
        return baseAttack;
    }

    public void setBaseAttack(int baseAttack) {
        this.baseAttack = baseAttack;
    }

    public int getBaseDefense() {
        return baseDefense;
    }

    public void setBaseDefense(int baseDefense) {
        this.baseDefense = baseDefense;
    }

    public int getBaseSpeed() {
        return baseSpeed;
    }

    public void setBaseSpeed(int baseSpeed) {
        this.baseSpeed = baseSpeed;
    }

    public int getHpEVDefeatYield() {
        return hpEVDefeatYield;
    }

    public void setHpEVDefeatYield(int hpEVDefeatYield) {
        this.hpEVDefeatYield = hpEVDefeatYield;
    }

    public int getAttackEVDefeatYield() {
        return attackEVDefeatYield;
    }

    public int getDefenseEVDefeatYield() {
        return defenseEVDefeatYield;
    }

    public void setDefenseEVDefeatYield(int defenseEVDefeatYield) {
        this.defenseEVDefeatYield = defenseEVDefeatYield;
    }
}
