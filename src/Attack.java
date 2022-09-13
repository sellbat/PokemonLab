public class Attack {
    public int power;
    public double accuracy;

    public Effect effect;
    public double effectChance;

    public Type type;

    public Attack(int power, double accuracy, Effect effect, double effectChance, Type type){
        this.power = power;
        this.accuracy = accuracy;

        this.effect = effect;
        this.effectChance = effectChance;

        this.type = type;
    }
}
