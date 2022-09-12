/*Andrew*/
public class Nature {
    public enum Natures {Bashful, Docile, Hardy, Quirky, Serious, Adamant, Brave, Lonely, Naughty, Bold, Relaxed, Impish, Lax, Modest, Mild, Quiet, Rash, Calm, Gentle, Sassy, Careful, Timid, Hasty, Jolly, Naive};
    public Natures[] naturesList = {Natures.Bashful, Natures.Docile, Natures.Hardy, Natures.Quirky, Natures.Serious,
            Natures.Adamant, Natures.Brave, Natures.Lonely, Natures.Naughty,
            Natures.Bold, Natures.Relaxed, Natures.Impish, Natures.Lax,
            Natures.Modest, Natures.Mild, Natures.Quiet, Natures.Rash,
            Natures.Calm, Natures.Gentle, Natures.Sassy, Natures.Careful,
            Natures.Timid, Natures.Hasty, Natures.Jolly, Natures.Naive};

    Natures name;

    double attackMultiplier;
    double defenseMultiplier;

    Nature() {
        updateMultipliers(naturesList[StaticVars.RANDOM.nextInt(naturesList.length)]);
    }

    Nature(Natures natureChoice) {
        this.name = natureChoice;

        updateMultipliers(natureChoice);
    }

    private void updateMultipliers(Natures natureChoice) {
        switch(natureChoice) {
            //Null Natures
            case Bashful:
                attackMultiplier = 1;
                defenseMultiplier = 1;
                break;
            case Docile:
                attackMultiplier = 1;
                defenseMultiplier = 1;
                break;
            case Hardy:
                attackMultiplier = 1;
                defenseMultiplier = 1;
                break;
            case Quirky:
                attackMultiplier = 1;
                defenseMultiplier = 1;
                break;
            case Serious:
                attackMultiplier = 1;
                defenseMultiplier = 1;
                break;

            //Attack Increasing Natures
            case Adamant:
                attackMultiplier = 1.1;
                defenseMultiplier = 1;
                break;
            case Brave:
                attackMultiplier = 1.1;
                defenseMultiplier = 1;
                break;
            case Lonely:
                attackMultiplier = 1.1;
                defenseMultiplier = 0.9;
                break;
            case Naughty:
                attackMultiplier = 1.1;
                defenseMultiplier = 1;
                break;

            //Defense Increasing Natures
            case Bold:
                attackMultiplier = 0.9;
                defenseMultiplier = 1.1;
                break;
            case Relaxed:
                attackMultiplier = 1;
                defenseMultiplier = 1.1;
                break;
            case Impish:
                attackMultiplier = 1;
                defenseMultiplier = 1.1;
                break;
            case Lax:
                attackMultiplier = 1;
                defenseMultiplier = 1.1;
                break;

            //Special Attack Increasing Natures
            case Modest:
                attackMultiplier = 0.9;
                defenseMultiplier = 1;
                break;
            case Mild:
                attackMultiplier = 1;
                defenseMultiplier = 0.9;
                break;
            case Quiet:
                attackMultiplier = 1;
                defenseMultiplier = 1;
                break;
            case Rash:
                attackMultiplier = 1;
                defenseMultiplier = 1;
                break;

            //Special Defense Increasing Natures
            case Calm:
                attackMultiplier = 0.9;
                defenseMultiplier = 1;
                break;
            case Gentle:
                attackMultiplier = 1;
                defenseMultiplier = 0.9;
                break;
            case Sassy:
                attackMultiplier = 1;
                defenseMultiplier = 1;
                break;
            case Careful:
                attackMultiplier = 1;
                defenseMultiplier = 1;
                break;

            //Speed Increasing Natures
            case Timid:
                attackMultiplier = 0.9;
                defenseMultiplier = 1;
                break;
            case Hasty:
                attackMultiplier = 1;
                defenseMultiplier = 0.9;
                break;
            case Jolly:
                attackMultiplier = 1;
                defenseMultiplier = 1;
                break;
            case Naive:
                attackMultiplier = 1;
                defenseMultiplier = 1;
                break;

            //Default
            default:
                attackMultiplier = 1;
                defenseMultiplier = 1;
                break;
        }
    }
}
