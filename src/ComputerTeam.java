public class ComputerTeam {
    public Pokemon[] pokemons;
    public BagItem[] bag;

    ComputerTeam(Pokemon[] pokemons, BagItem[] bag) {
        this.pokemons = pokemons;
        this.bag = bag;
    }

    public void addBagItem(Item item, int numOfItems) {
        for (int i=0; i<bag.length; i++) {
            if (item.name.equals(bag[i].itemType.name)) {
                bag[i].numOfItems += numOfItems;
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
                if (pokemons[i] == game.compPokemon) {
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

            if (randomItem.itemType != StaticVars.ITEM.POKEBALL) {
                randomTarget = pokemons[StaticVars.RANDOM.nextInt(pokemons.length)];
            }
            else {
                randomTarget = game.playerPokemon;
            }

            game.useItem(randomItem, randomTarget, this, game.playerTeam);

        }
        else {
            //Attack
            Pokemon attacker = game.compPokemon;
            Pokemon defender = game.playerPokemon;
            Attack randomAttack = attacker.attacks[StaticVars.RANDOM.nextInt(attacker.attacks.length)];
            game.useAttack(randomAttack,attacker,defender);
        }

    }
}