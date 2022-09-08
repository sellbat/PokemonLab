public class PokemonSpecies {
    public enum SpeciesChoices {Pikachu, Ivysaur, Charizard, Squirtle};

    public SpeciesChoices name;

    public int baseHp;
    public int baseAttack;
    public int baseDefense;

    public int hpEVDefeatYield;
    public int attackEVDefeatYield;
    public int defenseEVDefeatYield;

    PokemonSpecies(SpeciesChoices speciesChoice) {
        this.name = speciesChoice;

        switch(speciesChoice) {
            case Pikachu:
                setSpeciesStats(35, 55, 40, 0, 0, 0);
                break;

            case Ivysaur:
                setSpeciesStats(60, 62, 63, 0, 0, 0);
                break;

            case Charizard:
                setSpeciesStats(78, 84, 78, 0, 0, 0);
                break;

            case Squirtle:
                setSpeciesStats(44, 48, 65, 0, 0, 1);
                break;

            default:
                setSpeciesStats(40, 40, 40, 0, 0, 0);
                break;
        }
    }

    private void setSpeciesStats(int baseHp, int baseAttack, int baseDefense, int hpEVDefeatYield, int attackEVDefeatYield, int defenseEVDefeatYield) {
        this.baseHp = baseHp;
        this.baseAttack = baseAttack;
        this.baseDefense = baseDefense;

        this.hpEVDefeatYield = hpEVDefeatYield;
        this.attackEVDefeatYield = attackEVDefeatYield;
        this.defenseEVDefeatYield = defenseEVDefeatYield;
    }
}
