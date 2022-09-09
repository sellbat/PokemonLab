public class Main {
    public static void main(String[] args) {
        BagItem[] myItems = {null};
        Attack[] attacks = {null};

        Pokemon[] myPokemons = new Pokemon[5];
        myPokemons[0] = new Pokemon("myPikachu", StaticVars.PIKACHU, new PokemonStats(), attacks, -1);
        myPokemons[1] = new Pokemon("myCharizard", StaticVars.CHARIZARD, new PokemonStats(), attacks, -1);
        myPokemons[2] = new Pokemon("mySquirtle", StaticVars.SQUIRTLE, new PokemonStats(), attacks, -1);
        myPokemons[3] = new Pokemon("myIvysaur", StaticVars.IVYSAUR, new PokemonStats(), attacks, -1);
        myPokemons[4] = new Pokemon("myOverPoweredPokemonAKAtheMaxBound", StaticVars.PIKACHU, new PokemonStats(31, 31, 31, 170, 170, 170, new Nature(Nature.Natures.Hardy), true, 100), attacks, -1);

        PlayerTeam myTeam = new PlayerTeam(myPokemons, myItems);
    }
}
