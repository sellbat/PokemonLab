/*Connor*/
public class Attack {

    private String name;
    private int power;
    private double accuracy;
    private Effect effect;
    private double effectChance;
    private Type type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public double getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(double accuracy) {
        this.accuracy = accuracy;
    }

    public Effect getEffect() {
        return effect;
    }

    public void setEffect(Effect effect) {
        this.effect = effect;
    }

    public double getEffectChance() {
        return effectChance;
    }

    public void setEffectChance(double effectChance) {
        this.effectChance = effectChance;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
    public Attack(String name, int power, double accuracy, Effect effect, double effectChance, Type type) {
        this.name = name;
        this.power = power;
        this.accuracy = accuracy;

        this.effect = effect;
        this.effectChance = effectChance;

        this.type = type;
    }
}
