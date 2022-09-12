import java.util.Arrays;

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
    public void randomMove(){ //connor
        int n = StaticVars.RANDOM.nextInt(0, 4);
        switch(n){
            //Switch Pokemon
            case 0:
                int p = -1;

                int originalP = -1;
                for (int i=0; i<pokemons.length; i++) {
                    if (pokemons[i] == Game.compPokemon) {
                        originalP = i;
                    }
                }

                while (p != originalP) {
                    p = StaticVars.RANDOM.nextInt(pokemons.length);
                }

                Game.switchPokemon(true, this.pokemons[p]);
                break;

            case 1:
                int p = StaticVars.RANDOM.nextInt(0, Attack.length)
                //add attacks
            case 2:
            case 3:
        }
    }



}
