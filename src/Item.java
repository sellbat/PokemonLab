public class Item {
    public int levelIncrease;
    public int healthIncrease;
    public boolean revive;
    public boolean maxRevive;
    public boolean pokeBall;
    public String name;
    public Item(int levelIncrease, int healthIncrease, boolean revive, boolean maxRevive, boolean pokeBall, String name){
        this.levelIncrease = levelIncrease;
        this.healthIncrease = healthIncrease;
        this.revive = revive;
        this.maxRevive = maxRevive;
        this.pokeBall = pokeBall;
        this.name = name;
    }



}
