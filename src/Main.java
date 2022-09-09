public class Main {

    public static void main(String[] args) {
        Attack[] attacks = {null};

	    Pokemon myPokemon = new Pokemon("myPokemon", new PokemonSpecies(PokemonSpecies.SpeciesChoices.Pikachu), new PokemonStats(), attacks, -1);

        System.out.print(myPokemon.attackPower);

        Type myType = new Type(Type.Types.Fire);
        System.out.print("\n" + myType.getTypeEffectivenessAgainst(new Type(Type.Types.Water)));
    }
}
