/*Andrew*/

import java.util.Random;
import java.util.Scanner;

//A class that holds access to single instances of other variables (subdivided up more by what each variable is (e.g. type, species, item, etc.)
public class StaticVars {
    public static final Scanner SCANNER = new Scanner(System.in);

    public static final Random RANDOM = new Random();

    public static class TYPE {
        public static final Type NONE = new Type(Type.Types.None);
        public static final Type NORMAL = new Type(Type.Types.Normal);
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
    }

    public static class SPECIES {
        public static final PokemonSpecies PIKACHU = new PokemonSpecies(PokemonSpecies.SpeciesChoices.Pikachu);
        public static final PokemonSpecies IVYSAUR = new PokemonSpecies(PokemonSpecies.SpeciesChoices.Ivysaur);
        public static final PokemonSpecies CHARIZARD = new PokemonSpecies(PokemonSpecies.SpeciesChoices.Charizard);
        public static final PokemonSpecies SQUIRTLE = new PokemonSpecies(PokemonSpecies.SpeciesChoices.Squirtle);
        public static final PokemonSpecies PIDGEY = new PokemonSpecies(PokemonSpecies.SpeciesChoices.Pidgey);
        public static final PokemonSpecies JIGGLYPUFF = new PokemonSpecies(PokemonSpecies.SpeciesChoices.Jigglypuff);
    }

    public static class ITEM {
        public static final Item POTION = new Item(0, 20, false, false, false, "Potion");
        public static final Item SUPERPOTION = new Item(0, 50, false, false, false, "Super Potion");
        public static final Item HYPERPOTION = new Item(0, 200, false, false, false, "Hyper Potion");
        public static final Item REVIVE = new Item(0, 0, true, false, false, "Revive");
        public static final Item MAXREVIVE = new Item(0, 0, false, true, false, "Max Revive");
        public static final Item RARECANDY = new Item(1, 0, false, false, false, "Rare Candy");
        public static final Item POKEBALL = new Item(0, 0, false, false, true, "Pokeball");
    }

    public static class EFFECT {
        public static final Effect PARALYSIS = new Effect(Effect.Effects.Paralyzed, 3);
        public static final Effect POISONED = new Effect(Effect.Effects.Poisoned, 3);
        public static final Effect BURNED = new Effect(Effect.Effects.Burned, 3);
        public static final Effect FROZEN = new Effect(Effect.Effects.Frozen, 3);
        public static final Effect FLINCH = new Effect(Effect.Effects.Flinch, 3);
    }

    public static class ATTACK {
        public static final Attack THUNDERSHOCK = new Attack("Thunder Shock", 40, 1.00, EFFECT.PARALYSIS, 0.10, TYPE.ELECTRIC);
        public static final Attack SPARK = new Attack("Spark", 65, 1.00, EFFECT.PARALYSIS, 0.30, TYPE.ELECTRIC);
        public static final Attack THUNDERBOLT = new Attack("Thunderbolt", 90, 1.00, EFFECT.PARALYSIS, 0.10, TYPE.ELECTRIC);
        public static final Attack THUNDER = new Attack("Thunder", 110, 0.70, EFFECT.PARALYSIS, 0.30, TYPE.ELECTRIC);

        public static final Attack AIRSLASH = new Attack("Air Slash", 75, 0.95, EFFECT.FLINCH, 0.30, TYPE.FLYING);
        public static final Attack DRAGONCLAW = new Attack("Dragon Claw", 80, 1.00, null, 0.00, TYPE.DRAGON);
        public static final Attack HEATWAVE = new Attack("Heat Wave", 95, 0.90, EFFECT.BURNED, 0.10, TYPE.FIRE);
        public static final Attack INFERNO = new Attack("Inferno", 100, 0.50, EFFECT.BURNED, 1.00, TYPE.FIRE);

        public static final Attack TACKLE = new Attack("Tackle", 40, 1.00, null, 0.00, TYPE.NORMAL);
        public static final Attack WATERGUN = new Attack("Water Gun", 40, 1.00, null, 0.00, TYPE.WATER);
        public static final Attack BITE = new Attack("Bite", 60, 1.00, EFFECT.FLINCH, 0.30, TYPE.DARK);
        public static final Attack AQUATAIL = new Attack("Aqua Tail", 90, 0.90, null, 0.00, TYPE.WATER);

        public static final Attack VINEWHIP = new Attack("Vine Whip", 45, 1.00, null, 0.00, TYPE.GRASS);
        public static final Attack RAZORLEAF = new Attack("Razor Leaf", 55, 0.95, null, 0.00, TYPE.GRASS);
        public static final Attack SLUDGEBOMB = new Attack("Sludge Bomb", 90, 1.00, EFFECT.POISONED, 0.30, TYPE.POISON);

        public static final Attack GUST = new Attack("Gust", 40, 1.00, null, 0.00, TYPE.FLYING);
        public static final Attack QUICKATTACK = new Attack("Quick Attack", 40, 1.00, null, 0.00, TYPE.NORMAL);
        public static final Attack TWISTER = new Attack("Twister", 40, 1.00, EFFECT.FLINCH, 0.30, TYPE.DRAGON);

        public static final Attack DISARMINGVOICE = new Attack("Disarming Voice", 40, 1.00, null, 0.00, TYPE.FAIRY);
        public static final Attack POUND = new Attack("Pound", 40, 1.00, null, 0.00, TYPE.NORMAL);
        public static final Attack BODYSLAM = new Attack("Body Slam", 85, 1.00, EFFECT.PARALYSIS, 0.30, TYPE.NORMAL);
        public static final Attack HYPERVOICE = new Attack("Hyper Voice", 90, 1.00, null, 0.00, TYPE.NORMAL);
    }

}
