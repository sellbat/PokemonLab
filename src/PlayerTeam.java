public class PlayerTeam {
    public Pokemon[] pokemons;
    public BagItem[] bag;

    PlayerTeam(Pokemon[] pokemons, BagItem[] bag) {
        this.pokemons = pokemons;
        this.bag = bag;
    }

    public void addBagItem(int amount, Item item){
        BagItem[] newBag = new BagItem[bag.length + 1];
        for(int i=0; i< newBag.length ; i++){
            newBag[i] = bag[i];
        }
        newBag[bag.length] = new BagItem(item, amount);
        this.bag = newBag;
    }

}
