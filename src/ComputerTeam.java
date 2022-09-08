public class ComputerTeam {
    public Pokemon[] pokemons;
    public BagItem[] bag;

    ComputerTeam(Pokemon[] pokemons, BagItem[] bag) {
        this.pokemons = pokemons;
        this.bag = bag;
    }

    public void addBagItem(Item item, int numOfItems) {
        BagItem[] newBag = new BagItem[bag.length+1];
        for (int i=0; i<bag.length; i++) {
            newBag[i] = bag[i];
        }
        newBag[bag.length] = new BagItem(item, numOfItems);

        this.bag = newBag;
    }


}
