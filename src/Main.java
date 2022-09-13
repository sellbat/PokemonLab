//Connor
public class Main {
    public static void main(String[] args) {
        BagItem[] myItems = {new BagItem(StaticVars.ITEM.POKEBALL, 5), new BagItem(StaticVars.ITEM.RARECANDY, 5)};
        Attack[][] myAttacks =
                {
                        {StaticVars.ATTACK.THUNDERSHOCK, StaticVars.ATTACK.SPARK, StaticVars.ATTACK.THUNDERBOLT, StaticVars.ATTACK.THUNDER},
                        {StaticVars.THUNDERSHOCK, StaticVars.SPARK, StaticVars.THUNDERBOLT, StaticVars.THUNDER},
                        {StaticVars.THUNDERSHOCK, StaticVars.SPARK, StaticVars.THUNDERBOLT, StaticVars.THUNDER},
                        {StaticVars.THUNDERSHOCK, StaticVars.SPARK, StaticVars.THUNDERBOLT, StaticVars.THUNDER},
                        {StaticVars.THUNDERSHOCK, StaticVars.SPARK, StaticVars.THUNDERBOLT, StaticVars.THUNDER},
                };

        Pokemon[] myPokemons = new Pokemon[5];
        myPokemons[0] = new Pokemon("myPikachu", StaticVars.SPECIES.PIKACHU, new PokemonStats(), myAttacks[0], -1);
        myPokemons[1] = new Pokemon("myCharizard", StaticVars.SPECIES.CHARIZARD, new PokemonStats(), myAttacks[1], -1);
        myPokemons[2] = new Pokemon("mySquirtle", StaticVars.SPECIES.SQUIRTLE, new PokemonStats(), myAttacks[2], -1);
        myPokemons[3] = new Pokemon("myIvysaur", StaticVars.SPECIES.IVYSAUR, new PokemonStats(), myAttacks[3], -1);
        myPokemons[4] = new Pokemon("myOverPoweredPokemon", StaticVars.SPECIES.PIKACHU, new PokemonStats(31, 31, 31, 170, 170, 170, new Nature(Nature.Natures.Hardy), true, 100), myAttacks[4], -1);

        PlayerTeam myTeam = new PlayerTeam(myPokemons, myItems);

        BagItem[] enemyItems = {new BagItem(StaticVars.ITEM.POKEBALL, 5), new BagItem(StaticVars.ITEM.RARECANDY, 5)};
        Attack[][] enemyAttacks =
                {
                        {StaticVars.ATTACK.THUNDERSHOCK, StaticVars.ATTACK.SPARK, StaticVars.ATTACK.THUNDERBOLT, StaticVars.ATTACK.THUNDER},
                        {StaticVars.THUNDERSHOCK, StaticVars.SPARK, StaticVars.THUNDERBOLT, StaticVars.THUNDER},
                        {StaticVars.THUNDERSHOCK, StaticVars.SPARK, StaticVars.THUNDERBOLT, StaticVars.THUNDER},
                        {StaticVars.THUNDERSHOCK, StaticVars.SPARK, StaticVars.THUNDERBOLT, StaticVars.THUNDER},
                        {StaticVars.THUNDERSHOCK, StaticVars.SPARK, StaticVars.THUNDERBOLT, StaticVars.THUNDER},
                };

        Pokemon[] enemyPokemons = new Pokemon[5];
        enemyPokemons[0] = new Pokemon("enemyPikachu", StaticVars.SPECIES.PIKACHU, new PokemonStats(), enemyAttacks[0], -1);
        enemyPokemons[1] = new Pokemon("enemyCharizard", StaticVars.SPECIES.CHARIZARD, new PokemonStats(), enemyAttacks[1], -1);
        enemyPokemons[2] = new Pokemon("enemySquirtle", StaticVars.SPECIES.SQUIRTLE, new PokemonStats(), enemyAttacks[2], -1);
        enemyPokemons[3] = new Pokemon("enemyIvysaur", StaticVars.SPECIES.IVYSAUR, new PokemonStats(), enemyAttacks[3], -1);
        enemyPokemons[4] = new Pokemon("enemyOP", StaticVars.SPECIES.PIKACHU, new PokemonStats(31, 31, 31, 170, 170, 170, new Nature(Nature.Natures.Hardy), true, 100), enemyAttacks[4], -1);

        ComputerTeam compTeam = new ComputerTeam(enemyPokemons, enemyItems);

        Game myGame = new Game(myTeam, compTeam);

        myGame.setup();

        while (!myGame.isGameOver) {
            myGame.nextTurn();
        }
    }
}
