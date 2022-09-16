/*Andrew and Connor*/

public class ComputerTeam {
    private Pokemon[] pokemons;
    private BagItem[] bag;

    public Pokemon[] getPokemons() {
        return pokemons;
    }

    public void setPokemons(Pokemon[] pokemons) {
        this.pokemons = pokemons;
    }

    public BagItem[] getBag() {
        return bag;
    }

    public void setBag(BagItem[] bag) {
        this.bag = bag;
    }

    ComputerTeam(Pokemon[] pokemons, BagItem[] bag) {
        this.pokemons = pokemons;
        this.bag = bag;
    }

    /*Connor*/
    public void addBagItem(Item item, int numOfItems) {
        for (int i=0; i<bag.length; i++) {
            if (item.getName().equals(bag[i].getItemType().getName())) { //if item already exists, the quantity is increased
                bag[i].setNumOfItems(bag[i].getNumOfItems() + numOfItems);
                return;
            }
        }

        BagItem[] newBag = new BagItem[bag.length+1]; //if it's a new item, create a bag that is larger by 1
        for (int i=0; i<bag.length; i++) {
            newBag[i] = bag[i]; // set all items to new bag
        }
        newBag[bag.length] = new BagItem(item, numOfItems); //final item is the new item
        this.bag = newBag;
    }

    /*Connor*/
    public void addPokemon(Pokemon pokemon) { //connor
        Pokemon[] newPokemons = new Pokemon[pokemons.length+1]; //new array for the pokemon
        for (int i=0; i<pokemons.length; i++) {
            newPokemons[i] = pokemons[i]; //set all previous pokemon to the new array
        }
        newPokemons[pokemons.length] = pokemon; //set final value in the new array to the new pokemon

        this.pokemons = newPokemons;
    }

    /*Connor*/
    public void randomMove(Game game) {
        int n = StaticVars.RANDOM.nextInt(256);
        if (n%256 == 0) { // 1 in 256 chance of the computer team running away
            //Run
            game.runAway(true);
        }
        else if (n%32 == 0) { //1 in 32 chance of switching pokemon
            randomSwitchPokemon(game);
        }
        else if (n%8 == 0) { // 1 in 8 chance of using a random item
            //Use Item
            BagItem randomItem = bag[StaticVars.RANDOM.nextInt(bag.length)];
            Pokemon randomTarget;

            if (randomItem.getItemType() != StaticVars.ITEM.POKEBALL) {
                randomTarget = pokemons[StaticVars.RANDOM.nextInt(pokemons.length)];
            }
            else {
                randomTarget = game.getPlayerPokemon();
            }

            game.useItem(randomItem, randomTarget, true);

            if (randomItem.getItemType() != StaticVars.ITEM.POKEBALL) {
                Menus.battleMenu(game, "The enemy used " + randomItem.getItemType().getName() + " on " + randomTarget.getNickName());
            }
            else {
                Menus.battleMenu(game, "The enemy threw a pokeball and captured " + game.getPlayerPokemon().getNickName());

                Menus.pokemonMenu(game.getPlayerTeam(), game.getCompTeam());
                Pokemon newPlayerPokemon = game.inputPlayerPokemon();
                game.switchPokemon(false, newPlayerPokemon);
                Menus.battleMenu(game, newPlayerPokemon.getNickName() + " has entered the battle");

                game.setIsPlayerTurn(!game.getIsPlayerTurn());
            }

        }
        else { //use attack if none of the other statements above are satisfied
            //Attack
            Pokemon attacker = game.getCompPokemon();
            Pokemon defender = game.getPlayerPokemon();
            Attack randomAttack = attacker.getAttacks()[StaticVars.RANDOM.nextInt(attacker.getAttacks().length)];
            game.useAttack(randomAttack,attacker,defender);

            Menus.battleMenu(game, attacker.getNickName() + " used " + randomAttack.getName());
        }

    }

    /*Andrew*/
    public void randomSwitchPokemon(Game game) {
        //Switch Pokemon
        int originalP = -1;
        for (int i=0; i<pokemons.length; i++) {
            if (pokemons[i] == game.getCompPokemon()) {
                originalP = i; //finds the index of the pokemon on the compTeam being used in the game
            }
        }

        int p = originalP;
        while ((p == originalP) || (pokemons[p].getFainted())) {
            p = StaticVars.RANDOM.nextInt(pokemons.length);
        }

        game.switchPokemon(true, this.pokemons[p]); //switches the pokemon

        Menus.battleMenu(game, game.getCompPokemon().getNickName() + " has entered the battle");
    }
}