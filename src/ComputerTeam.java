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

    public void addBagItem(Item item, int numOfItems) {
        for (int i=0; i<bag.length; i++) {
            if (item.getName().equals(bag[i].getItemType().getName())) {
                bag[i].setNumOfItems(bag[i].getNumOfItems() + numOfItems);
                return;
            }
        }

        BagItem[] newBag = new BagItem[bag.length+1];
        for (int i=0; i<bag.length; i++) {
            newBag[i] = bag[i];
        }
        newBag[bag.length] = new BagItem(item, numOfItems);

        this.bag = newBag;
    }

    public void addPokemon(Pokemon pokemon) { //connor
        Pokemon[] newPokemons = new Pokemon[pokemons.length+1];
        for (int i=0; i<pokemons.length; i++) {
            newPokemons[i] = pokemons[i];
        }
        newPokemons[pokemons.length] = pokemon;

        this.pokemons = newPokemons;
    }
    public void randomMove(Game game) { //connor
        int n = StaticVars.RANDOM.nextInt(256);
        if (n%256 == 0) {
            //Run
            game.runAway(true);
        }
        else if (n%32 == 0) {
            //Switch Pokemon
            int p = -1;

            int originalP = -1;
            for (int i=0; i<pokemons.length; i++) {
                if (pokemons[i] == game.getCompPokemon()) {
                    originalP = i;
                }
            }

            while (p != originalP) {
                p = StaticVars.RANDOM.nextInt(pokemons.length);
            }

            game.switchPokemon(true, this.pokemons[p]);
        }
        else if (n%8 == 0) {
            //Use Item
            BagItem randomItem = bag[StaticVars.RANDOM.nextInt(bag.length)];
            Pokemon randomTarget;

            if (randomItem.getItemType() != StaticVars.ITEM.POKEBALL) {
                randomTarget = pokemons[StaticVars.RANDOM.nextInt(pokemons.length)];
            }
            else {
                randomTarget = game.getPlayerPokemon();
            }

            game.useItem(randomItem, randomTarget, this, game.getPlayerTeam());

        }
        else {
            //Attack
            Pokemon attacker = game.getCompPokemon();
            Pokemon defender = game.getPlayerPokemon();
            Attack randomAttack = attacker.getAttacks()[StaticVars.RANDOM.nextInt(attacker.getAttacks().length)];
            game.useAttack(randomAttack,attacker,defender);
        }

    }
}