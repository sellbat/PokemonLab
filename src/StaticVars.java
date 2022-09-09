import java.util.Random;

public class StaticVars {
    public static final Random RANDOM = new Random();

    public static final Type NONE = new Type(Type.Types.None);
    public static final Type FIRE = new Type(Type.Types.Fire);
    public static final Type WATER = new Type(Type.Types.Water);
    public static final Type GRASS = new Type(Type.Types.Grass);
    public static final Type ELECTRIC = new Type(Type.Types.Electric);
    public static final Type ICE = new Type(Type.Types.Ice);
    public static final Type FIGHTING = new Type(Type.Types.Fighting);
    public static final Type POISON = new Type(Type.Types.Poison);
    public static final Type GROUND = new Type(Type.Types.Ground);
    public static final Type FLYING = new Type(Type.Types.Flying);

    public static final PokemonSpecies PIKACHU = new PokemonSpecies(PokemonSpecies.SpeciesChoices.Pikachu);
}
