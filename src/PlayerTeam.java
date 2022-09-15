/*Connor*/

public class PlayerTeam {
    private Pokemon[] pokemons;
    private BagItem[] bag;

    PlayerTeam(Pokemon[] pokemons, BagItem[] bag) {
        this.pokemons = pokemons;
        this.bag = bag;
    }

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

    public void addBagItem(int amount, Item item){
        for(int j=0 ; j<bag.length ; j++){
            if(bag[j].getItemType().getName().equals(item.getName())){ //if item already exists, the quantity is increased
                bag[j].setNumOfItems(bag[j].getNumOfItems() + amount);
                return;
            }
        }
        BagItem[] newBag = new BagItem[bag.length + 1]; //if it's a new item, create a bag that is larger by 1
        for(int i=0; i< newBag.length ; i++){
            newBag[i] = bag[i]; // set all items to new bag
        }
        newBag[bag.length] = new BagItem(item, amount); //final item is the new item
        this.bag = newBag;
    }
    public void addPokemon(Pokemon pokemon){
        Pokemon[] newPokemons = new Pokemon[pokemons.length+1]; //new array for the pokemon
        for(int i=0; i<pokemons.length ; i++){
            newPokemons[i] = pokemons[i]; //set all previous pokemon to the new array
        }
        newPokemons[pokemons.length] = pokemon; //set final value in the new array to the new pokemon
        this.pokemons = newPokemons;
    }


}
