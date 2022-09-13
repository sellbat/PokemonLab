import java.util.Random;
import java.util.Scanner;

public class StaticVars {
    public static final Scanner SCANNER = new Scanner(System.in);

    public static final Random RANDOM = new Random();

    public static final PokemonSpecies PIKACHU = new PokemonSpecies(PokemonSpecies.SpeciesChoices.Pikachu);
    public static final PokemonSpecies IVYSAUR = new PokemonSpecies(PokemonSpecies.SpeciesChoices.Ivysaur);
    public static final PokemonSpecies CHARIZARD = new PokemonSpecies(PokemonSpecies.SpeciesChoices.Charizard);
    public static final PokemonSpecies SQUIRTLE = new PokemonSpecies(PokemonSpecies.SpeciesChoices.Squirtle);

    public static final Item POTION = new Item(0, 20,false,false, false, "Potion");
    public static final Item SUPERPOTION = new Item(0, 50,false,false, false, "Super Potion");
    public static final Item HYPERPOTION = new Item(0, 200,false,false, false, "Hyper Potion");
    public static final Item REVIVE = new Item(0, 0,true,false, false, "Revive");
    public static final Item MAXREVIVE = new Item(0, 0,false,true, false, "Max Revive");
    public static final Item RARECANDY = new Item(1, 0,false,false, false, "Rare Candy");
    public static final Item POKEBALL = new Item(0, 0,false,false, true, "Pokeball");

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
    public static final Type PSYCHIC = new Type(Type.Types.Psychic);
    public static final Type BUG = new Type(Type.Types.Bug);
    public static final Type ROCK = new Type(Type.Types.Rock);
    public static final Type GHOST = new Type(Type.Types.Ghost);
    public static final Type DARK = new Type(Type.Types.Dark);
    public static final Type DRAGON = new Type(Type.Types.Dragon);
    public static final Type STEEL = new Type(Type.Types.Steel);
    public static final Type FAIRY = new Type(Type.Types.Fairy);

    public static final Effect PARALYSIS = new Effect(Effect.Effects.Paralyzed, 5);

    public static final Attack THUNDERSHOCK = new Attack("Thunder Shock", 40, 100, PARALYSIS, 0.10, ELECTRIC);
    public static final Attack SPARK = new Attack("Spark", 65, 100, PARALYSIS, 0.30, ELECTRIC);
    public static final Attack DISCHARGE = new Attack("Discharge", 80, 100, PARALYSIS, 0.30, ELECTRIC);
    public static final Attack THUNDERBOLT = new Attack("Thunderbolt", 90, 100, PARALYSIS, 0.10, ELECTRIC);
    public static final Attack THUNDER = new Attack("Thunder", 110, 70, PARALYSIS, 0.30, ELECTRIC);


}
