public class PokemonSpecies {
    public enum SpeciesChoices {Pikachu, Ivysaur, Charizard, Squirtle};

    public SpeciesChoices name;

    public Type type1;
    public Type type2;

    public int baseHp;
    public int baseAttack;
    public int baseDefense;

    public int baseSpeed;

    public int hpEVDefeatYield;
    public int attackEVDefeatYield;
    public int defenseEVDefeatYield;

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
}
