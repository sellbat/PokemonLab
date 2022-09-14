public class PlayerTeam {
    public Pokemon[] pokemons;
    public BagItem[] bag;

    PlayerTeam(Pokemon[] pokemons, BagItem[] bag) {
        this.pokemons = pokemons;
        this.bag = bag;
    }

    public void addBagItem(int amount, Item item){
        for(int j=0 ; j<bag.length ; j++){
            if(bag[j].getItemType().name.equals(item.name)){
                bag[j].setNumOfItems(bag[j].getNumOfItems() + amount);
                return;
            }
        }
        BagItem[] newBag = new BagItem[bag.length + 1];
        for(int i=0; i< newBag.length ; i++){
            newBag[i] = bag[i];
        }
        newBag[bag.length] = new BagItem(item, amount);
        this.bag = newBag;
    }
    public void addPokemon(Pokemon pokemon){
        Pokemon[] newPokemons = new Pokemon[pokemons.length+1];
        for(int i=0; i<pokemons.length ; i++){
            newPokemons[i] = pokemons[i];
        }
        newPokemons[pokemons.length] = pokemon;
        this.pokemons = newPokemons;
    }


}
