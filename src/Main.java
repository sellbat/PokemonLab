//Connor
public class Main {
    public static void main(String[] args) {
        BagItem[] myItems = {
                new BagItem(StaticVars.ITEM.POTION, 20),
                new BagItem(StaticVars.ITEM.SUPERPOTION, 15),
                new BagItem(StaticVars.ITEM.HYPERPOTION, 10),
                new BagItem(StaticVars.ITEM.REVIVE, 2),
                new BagItem(StaticVars.ITEM.MAXREVIVE, 1),
                new BagItem(StaticVars.ITEM.RARECANDY, 10),
                new BagItem(StaticVars.ITEM.POKEBALL, 5)
        };

        Attack[][] myAttacks =
                {
                        {StaticVars.ATTACK.THUNDERSHOCK, StaticVars.ATTACK.SPARK, StaticVars.ATTACK.THUNDERBOLT, StaticVars.ATTACK.THUNDER},
                        {StaticVars.ATTACK.AIRSLASH, StaticVars.ATTACK.DRAGONCLAW, StaticVars.ATTACK.HEATWAVE, StaticVars.ATTACK.INFERNO},
                        {StaticVars.ATTACK.TACKLE, StaticVars.ATTACK.WATERGUN, StaticVars.ATTACK.BITE, StaticVars.ATTACK.AQUATAIL},
                        {StaticVars.ATTACK.TACKLE, StaticVars.ATTACK.VINEWHIP, StaticVars.ATTACK.RAZORLEAF, StaticVars.ATTACK.SLUDGEBOMB},
                        {StaticVars.ATTACK.TACKLE, StaticVars.ATTACK.GUST, StaticVars.ATTACK.QUICKATTACK, StaticVars.ATTACK.TWISTER},
                        {StaticVars.ATTACK.DISARMINGVOICE, StaticVars.ATTACK.POUND, StaticVars.ATTACK.BODYSLAM, StaticVars.ATTACK.HYPERVOICE}
                };

        Pokemon[] myPokemons = new Pokemon[6];
        myPokemons[0] = new Pokemon("myPikachu", StaticVars.SPECIES.PIKACHU, new PokemonStats(), myAttacks[0], -1);
        myPokemons[1] = new Pokemon("myCharizard", StaticVars.SPECIES.CHARIZARD, new PokemonStats(), myAttacks[1], -1);
        myPokemons[2] = new Pokemon("mySquirtle", StaticVars.SPECIES.SQUIRTLE, new PokemonStats(), myAttacks[2], -1);
        myPokemons[3] = new Pokemon("myIvysaur", StaticVars.SPECIES.IVYSAUR, new PokemonStats(), myAttacks[3], -1);
        myPokemons[4] = new Pokemon("myPidgey", StaticVars.SPECIES.PIKACHU, new PokemonStats(), myAttacks[4], -1);
        myPokemons[5] = new Pokemon("myJigglypuff", StaticVars.SPECIES.PIKACHU, new PokemonStats(), myAttacks[5], -1);

        PlayerTeam myTeam = new PlayerTeam(myPokemons, myItems);



        BagItem[] enemyItems = {
                new BagItem(StaticVars.ITEM.POTION, 5),
                new BagItem(StaticVars.ITEM.SUPERPOTION, 2),
                new BagItem(StaticVars.ITEM.HYPERPOTION, 1),
                new BagItem(StaticVars.ITEM.RARECANDY, 2),
                new BagItem(StaticVars.ITEM.POKEBALL, 1)
        };

        Attack[][] enemyAttacks =
                {
                        {StaticVars.ATTACK.THUNDERSHOCK, StaticVars.ATTACK.SPARK, StaticVars.ATTACK.THUNDERBOLT, StaticVars.ATTACK.THUNDER},
                        {StaticVars.ATTACK.AIRSLASH, StaticVars.ATTACK.DRAGONCLAW, StaticVars.ATTACK.HEATWAVE, StaticVars.ATTACK.INFERNO},
                        {StaticVars.ATTACK.TACKLE, StaticVars.ATTACK.WATERGUN, StaticVars.ATTACK.BITE, StaticVars.ATTACK.AQUATAIL},
                        {StaticVars.ATTACK.TACKLE, StaticVars.ATTACK.VINEWHIP, StaticVars.ATTACK.RAZORLEAF, StaticVars.ATTACK.SLUDGEBOMB},
                        {StaticVars.ATTACK.TACKLE, StaticVars.ATTACK.GUST, StaticVars.ATTACK.QUICKATTACK, StaticVars.ATTACK.TWISTER},
                        {StaticVars.ATTACK.DISARMINGVOICE, StaticVars.ATTACK.POUND, StaticVars.ATTACK.BODYSLAM, StaticVars.ATTACK.HYPERVOICE}
                };

        Pokemon[] enemyPokemons = new Pokemon[6];
        enemyPokemons[0] = new Pokemon("enemyPikachu", StaticVars.SPECIES.PIKACHU, new PokemonStats(), enemyAttacks[0], -1);
        enemyPokemons[1] = new Pokemon("enemyCharizard", StaticVars.SPECIES.CHARIZARD, new PokemonStats(), enemyAttacks[1], -1);
        enemyPokemons[2] = new Pokemon("enemySquirtle", StaticVars.SPECIES.SQUIRTLE, new PokemonStats(), enemyAttacks[2], -1);
        enemyPokemons[3] = new Pokemon("enemyIvysaur", StaticVars.SPECIES.IVYSAUR, new PokemonStats(), enemyAttacks[3], -1);
        enemyPokemons[4] = new Pokemon("enemyPidgey", StaticVars.SPECIES.PIDGEY, new PokemonStats(), enemyAttacks[4], -1);
        enemyPokemons[5] = new Pokemon("enemyJigglypuff", StaticVars.SPECIES.JIGGLYPUFF, new PokemonStats(), enemyAttacks[5], -1);

        ComputerTeam compTeam = new ComputerTeam(enemyPokemons, enemyItems);

        Game myGame = new Game(myTeam, compTeam);

        myGame.setup();

        while (!myGame.getIsGameOver()) {
            myGame.nextTurn();
        }
    }
}
