public class Game {
    public boolean isGameOver;
    public boolean isPlayerTurn;
    enum Screen {Battle, AttackMenu, BagMenu, PokemonMenu}
    public Pokemon playerPokemon;
    public Pokemon compPokemon;
    public PlayerTeam playerTeam;
    public ComputerTeam compTeam;

    public Game(PlayerTeam playerTeam, ComputerTeam compTeam) {
        this.isGameOver = false;
        this.isPlayerTurn = true;
        this.playerPokemon = playerTeam.pokemons[0];
        this.compPokemon = compTeam.pokemons[0];
        this.playerTeam = playerTeam;
        this.compTeam = compTeam;
    }

    /*Connor*/
    public void setup(PlayerTeam myTeam, ComputerTeam compTeam){
        this.playerPokemon = myTeam.pokemons[0];
        this.compPokemon = compTeam.pokemons[0];

        StaticVars.SCANNER.useDelimiter("\n");
    }

    /*Connor*/
    private Screen inputMenuChoice() {
        String choiceString;
        Screen choice;

        System.out.print("Input Your Menu Choice (Atk, Bag, Pok, Run): ");
        while (true) {
            try {
                choiceString = StaticVars.SCANNER.next();
                choice = Screen.valueOf(choiceString);
                break;
            }
            catch (Exception e) {
                StaticVars.SCANNER.nextLine();
            }
            System.out.print("\nPlease Try Again!\nInput Your Menu Choice: ");
        }
        return choice;
    }

    public void runAway(boolean isCompTeam) {
        this.isGameOver = true;

        if (isCompTeam) {
            System.out.print("The enemy team has run away!\nGame over!");
        }
        else {
            System.out.print("Your team has run away!\nGame over!");
        }
    }

    public void switchPokemon(boolean isCompTeam, Pokemon choice) {
        if (isCompTeam) {
            compPokemon = choice;
        }
        else {
            playerPokemon = choice;
        }
    }

    /*Andrew*/
    public static void useAttack(Attack attack, Pokemon attacker, Pokemon defender) {
        double rand = Math.random();
        if ((attacker.effect == null) || (rand > attacker.effect.incapacitateChance)) {
            defender.currentHp -= calculateAttackDamage(attack, attacker, defender);
            if (defender.currentHp <= 0) {
                defender.fainted = true;
            }
        }
    }

    /*Andrew*/
    public void useItem(BagItem item, Pokemon target, ComputerTeam compTeam, PlayerTeam playerTeam) {
        item.numOfItems -= 1;

        target.currentHp += item.itemType.healthIncrease;
        target.stats.level += item.itemType.levelIncrease;

        if (item.itemType.revive) {
            target.currentHp = target.maxHp/2;
            target.fainted = false;
        }

        else if (item.itemType.maxRevive) {
            target.currentHp = target.maxHp;
            target.fainted = false;
        }

        else if (item.itemType.pokeBall) {
            if (compTeam != null) {
                for (int i=0; i<compTeam.pokemons.length; i++) {
                    if (playerTeam.pokemons[i] == target) {
                        Pokemon[] newCompPokemons = new Pokemon[compTeam.pokemons.length+1];
                        for (int j=0; j<compTeam.pokemons.length; j++) {
                            newCompPokemons[j] = compTeam.pokemons[j];
                        }
                        newCompPokemons[compTeam.pokemons.length] = target;
                        compTeam.pokemons = newCompPokemons;
                        break;
                    }
                }

                Pokemon[] newPlayerPokemons = new Pokemon[playerTeam.pokemons.length-1];
                int index = -1;
                for (int i=0; i<playerTeam.pokemons.length; i++) {
                    if (playerTeam.pokemons[i] == target) {
                        index = i;
                        break;
                    }
                }
                for (int i=0; i<index; i++) {
                    newPlayerPokemons[i] = playerTeam.pokemons[i];
                }
                for (int i=index+1; i<playerTeam.pokemons.length-1; i++) {
                    newPlayerPokemons[i] = playerTeam.pokemons[i];
                }
                playerTeam.pokemons = newPlayerPokemons;
            }

            else {
                for (int i=0; i<playerTeam.pokemons.length; i++) {
                    if (compTeam.pokemons[i] == target) {
                        Pokemon[] newPlayerPokemons = new Pokemon[playerTeam.pokemons.length+1];
                        for (int j=0; j<playerTeam.pokemons.length; j++) {
                            newPlayerPokemons[j] = playerTeam.pokemons[j];
                        }
                        newPlayerPokemons[playerTeam.pokemons.length] = target;
                        playerTeam.pokemons = newPlayerPokemons;
                        break;
                    }
                }

                Pokemon[] newCompPokemons = new Pokemon[compTeam.pokemons.length-1];
                int index = -1;
                for (int i=0; i<compTeam.pokemons.length; i++) {
                    if (compTeam.pokemons[i] == target) {
                        index = i;
                        break;
                    }
                }
                for (int i=0; i<index; i++) {
                    newCompPokemons[i] = compTeam.pokemons[i];
                }
                for (int i=index+1; i<compTeam.pokemons.length-1; i++) {
                    newCompPokemons[i] = compTeam.pokemons[i];
                }
                playerTeam.pokemons = newCompPokemons;
            }
        }
    }

    /*Andrew*/
    public static int calculateAttackDamage(Attack attack, Pokemon attacker, Pokemon defender) {
        double criticalHitBonus = 1.0;
        if (StaticVars.RANDOM.nextInt(256) < ((int)(attacker.species.baseSpeed/2))) {
            criticalHitBonus = 2.0;
        }

        double STABBonus = 1.0;
        if ((attack.type == attacker.species.type1) || (attack.type == attacker.species.type2)) {
            STABBonus = 1.5;
        }

        double damage = (((((2.0 * attacker.stats.level * criticalHitBonus)/5.0) + 2.0) * attack.power * ((double)attacker.attackPower/(double)defender.defensePower))/50.0);
        damage = damage * STABBonus * attack.type.getEffectivenessAgainst(defender.species.type1) * attack.type.getEffectivenessAgainst(defender.species.type2);
        if (!((int) damage == 1)) {
            damage = damage * (StaticVars.RANDOM.nextInt(256-217) + 217);
        }

        return ((int) damage/255);
    }

    /*Connor*/
    public void nextTurn(PlayerTeam myTeam, ComputerTeam compTeam){
        this.isPlayerTurn = !this.isPlayerTurn;
        if (!isPlayerTurn){
            compTeam.randomMove(this);
        }
        else{
            switch(inputMenuChoice()){
                case AttackMenu:
                    Menus.attackMenu(myTeam);
                    break;
                case BagMenu:
                    Menus.bagMenu(myTeam);
                    break;
                case PokemonMenu:
                    Menus.pokemonMenu(myTeam);
                    break;
            }
        }

    }

    public void input(){

    }


}
