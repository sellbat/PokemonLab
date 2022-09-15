/*Connor*/

public class Main {
    public static void main(String[] args) {
        //Creates an array of items in the player's bag
        BagItem[] myItems = {
                new BagItem(StaticVars.ITEM.POTION, 20),
                new BagItem(StaticVars.ITEM.SUPERPOTION, 15),
                new BagItem(StaticVars.ITEM.HYPERPOTION, 10),
                new BagItem(StaticVars.ITEM.REVIVE, 2),
                new BagItem(StaticVars.ITEM.MAXREVIVE, 1),
                new BagItem(StaticVars.ITEM.RARECANDY, 10),
                new BagItem(StaticVars.ITEM.POKEBALL, 5)
        };

        //Creates a 2D array of attacks that the player's pokemons will each use
        Attack[][] myAttacks =
                {
                        {StaticVars.ATTACK.THUNDERSHOCK, StaticVars.ATTACK.SPARK, StaticVars.ATTACK.THUNDERBOLT, StaticVars.ATTACK.THUNDER},
                        {StaticVars.ATTACK.AIRSLASH, StaticVars.ATTACK.DRAGONCLAW, StaticVars.ATTACK.HEATWAVE, StaticVars.ATTACK.INFERNO},
                        {StaticVars.ATTACK.TACKLE, StaticVars.ATTACK.WATERGUN, StaticVars.ATTACK.BITE, StaticVars.ATTACK.AQUATAIL},
                        {StaticVars.ATTACK.TACKLE, StaticVars.ATTACK.VINEWHIP, StaticVars.ATTACK.RAZORLEAF, StaticVars.ATTACK.SLUDGEBOMB},
                        {StaticVars.ATTACK.TACKLE, StaticVars.ATTACK.GUST, StaticVars.ATTACK.QUICKATTACK, StaticVars.ATTACK.TWISTER},
                        {StaticVars.ATTACK.DISARMINGVOICE, StaticVars.ATTACK.POUND, StaticVars.ATTACK.BODYSLAM, StaticVars.ATTACK.HYPERVOICE}
                };

        //6 Length array for the 6 Pokemon in this player's team
        Pokemon[] myPokemons = new Pokemon[6];
        myPokemons[0] = new Pokemon("myPikachu", StaticVars.SPECIES.PIKACHU, new PokemonStats(), myAttacks[0], -1);
        myPokemons[1] = new Pokemon("myCharizard", StaticVars.SPECIES.CHARIZARD, new PokemonStats(), myAttacks[1], -1);
        myPokemons[2] = new Pokemon("mySquirtle", StaticVars.SPECIES.SQUIRTLE, new PokemonStats(), myAttacks[2], -1);
        myPokemons[3] = new Pokemon("myIvysaur", StaticVars.SPECIES.IVYSAUR, new PokemonStats(), myAttacks[3], -1);
        myPokemons[4] = new Pokemon("myPidgey", StaticVars.SPECIES.PIKACHU, new PokemonStats(), myAttacks[4], -1);
        myPokemons[5] = new Pokemon("myJigglypuff", StaticVars.SPECIES.PIKACHU, new PokemonStats(), myAttacks[5], -1);

        //Create the player's team
        PlayerTeam myTeam = new PlayerTeam(myPokemons, myItems);


        //Creates an array of items in the enemy's bag
        BagItem[] enemyItems = {
                new BagItem(StaticVars.ITEM.POTION, 5),
                new BagItem(StaticVars.ITEM.SUPERPOTION, 2),
                new BagItem(StaticVars.ITEM.HYPERPOTION, 1),
                new BagItem(StaticVars.ITEM.RARECANDY, 2),
                new BagItem(StaticVars.ITEM.POKEBALL, 1)
        };

        //Creates a 2D array of attacks that the enemy's pokemons will each use
        Attack[][] enemyAttacks =
                {
                        {StaticVars.ATTACK.THUNDERSHOCK, StaticVars.ATTACK.SPARK, StaticVars.ATTACK.THUNDERBOLT, StaticVars.ATTACK.THUNDER},
                        {StaticVars.ATTACK.AIRSLASH, StaticVars.ATTACK.DRAGONCLAW, StaticVars.ATTACK.HEATWAVE, StaticVars.ATTACK.INFERNO},
                        {StaticVars.ATTACK.TACKLE, StaticVars.ATTACK.WATERGUN, StaticVars.ATTACK.BITE, StaticVars.ATTACK.AQUATAIL},
                        {StaticVars.ATTACK.TACKLE, StaticVars.ATTACK.VINEWHIP, StaticVars.ATTACK.RAZORLEAF, StaticVars.ATTACK.SLUDGEBOMB},
                        {StaticVars.ATTACK.TACKLE, StaticVars.ATTACK.GUST, StaticVars.ATTACK.QUICKATTACK, StaticVars.ATTACK.TWISTER},
                        {StaticVars.ATTACK.DISARMINGVOICE, StaticVars.ATTACK.POUND, StaticVars.ATTACK.BODYSLAM, StaticVars.ATTACK.HYPERVOICE}
                };

        //6 Length array for the 6 Pokemon in the enemy's team
        Pokemon[] enemyPokemons = new Pokemon[6];
        enemyPokemons[0] = new Pokemon("enemyPikachu", StaticVars.SPECIES.PIKACHU, new PokemonStats(), enemyAttacks[0], -1);
        enemyPokemons[1] = new Pokemon("enemyCharizard", StaticVars.SPECIES.CHARIZARD, new PokemonStats(), enemyAttacks[1], -1);
        enemyPokemons[2] = new Pokemon("enemySquirtle", StaticVars.SPECIES.SQUIRTLE, new PokemonStats(), enemyAttacks[2], -1);
        enemyPokemons[3] = new Pokemon("enemyIvysaur", StaticVars.SPECIES.IVYSAUR, new PokemonStats(), enemyAttacks[3], -1);
        enemyPokemons[4] = new Pokemon("enemyPidgey", StaticVars.SPECIES.PIDGEY, new PokemonStats(), enemyAttacks[4], -1);
        enemyPokemons[5] = new Pokemon("enemyJigglypuff", StaticVars.SPECIES.JIGGLYPUFF, new PokemonStats(), enemyAttacks[5], -1);

        //Create the enemy's team
        ComputerTeam compTeam = new ComputerTeam(enemyPokemons, enemyItems);

        //Create the game
        Game myGame = new Game(myTeam, compTeam);

        //Setup the variables in the game
        myGame.setup();

        //Loop game turns until the game is over
        while (!myGame.getIsGameOver()) {
            myGame.nextTurn();
        }
    }
}
