public class Attack {
    public String name;

    public int power;
    public double accuracy;

    public Effect effect;
    public double effectChance;

    public Type type;

    public Attack(String name, int power, double accuracy, Effect effect, double effectChance, Type type) {
        this.name = name;

        this.power = power;
        this.accuracy = accuracy;

        this.effect = effect;
        this.effectChance = effectChance;

        this.type = type;
    }
}
