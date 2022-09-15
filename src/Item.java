/*Andrew*/

public class Item {
    private int levelIncrease;
    private int healthIncrease;
    private boolean revive;
    private boolean maxRevive;
    private boolean pokeBall;
    private String name;

    public Item(int levelIncrease, int healthIncrease, boolean revive, boolean maxRevive, boolean pokeBall, String name){
        this.levelIncrease = levelIncrease;
        this.healthIncrease = healthIncrease;
        this.revive = revive;
        this.maxRevive = maxRevive;
        this.pokeBall = pokeBall;
        this.name = name;
    }


    public int getLevelIncrease() {
        return levelIncrease;
    }

    public void setLevelIncrease(int levelIncrease) {
        this.levelIncrease = levelIncrease;
    }

    public int getHealthIncrease() {
        return healthIncrease;
    }

    public void setHealthIncrease(int healthIncrease) {
        this.healthIncrease = healthIncrease;
    }

    public boolean getRevive() {
        return revive;
    }

    public void setRevive(boolean revive) {
        this.revive = revive;
    }

    public boolean getMaxRevive() {
        return maxRevive;
    }

    public void setMaxRevive(boolean maxRevive) {
        this.maxRevive = maxRevive;
    }

    public boolean getPokeBall() {
        return pokeBall;
    }

    public void setPokeBall(boolean pokeBall) {
        this.pokeBall = pokeBall;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
