public class Main {
    public static void main(String[] args) {
        Attack[] attacks = {null};

	    Pokemon myPokemon = new Pokemon("myPokemon", StaticVars.PIKACHU, new PokemonStats(), attacks, -1);

        System.out.print(myPokemon.species.type1.getEffectivenessAgainst(StaticVars.WATER));}
}
