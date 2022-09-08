public class PlayerTeam {
    public Pokemon[] pokemons;
    public BagItem[] bag;

    public void addBagItem(int amount, Item item){
        BagItem[] newBag = new BagItem[bag.length + 1];
        for(int i=0; i< newBag.length ; i++){
            newBag[i] = bag[i];
        }
        newBag[newBag.length] = new BagItem(item, amount);
        this.bag = newBag;
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




}
