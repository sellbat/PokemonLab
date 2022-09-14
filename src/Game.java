public class Game {
    enum Screen {Battle, Atk, Bag, Pok, Run}

    private boolean isGameOver;
    private boolean isPlayerTurn;
    private Pokemon playerPokemon;
    private Pokemon compPokemon;
    private PlayerTeam playerTeam;
    private ComputerTeam compTeam;

    public Game(PlayerTeam playerTeam, ComputerTeam compTeam) {
        this.isGameOver = false;
        this.isPlayerTurn = true;
        this.playerPokemon = playerTeam.pokemons[0];
        this.compPokemon = compTeam.getPokemons()[0];
        this.playerTeam = playerTeam;
        this.compTeam = compTeam;
    }

    public boolean getIsGameOver() {
        return isGameOver;
    }

    public void setIsGameOver(boolean gameOver) {
        isGameOver = gameOver;
    }

    public Pokemon getPlayerPokemon() {
        return playerPokemon;
    }

    public void setPlayerPokemon(Pokemon playerPokemon) {
        this.playerPokemon = playerPokemon;
    }

    public Pokemon getCompPokemon() {
        return compPokemon;
    }

    public void setCompPokemon(Pokemon compPokemon) {
        this.compPokemon = compPokemon;
    }

    public PlayerTeam getPlayerTeam() {
        return playerTeam;
    }

    public void setPlayerTeam(PlayerTeam playerTeam) {
        this.playerTeam = playerTeam;
    }

    /*Connor*/
    public void setup(){
        this.playerPokemon = this.playerTeam.pokemons[0];
        this.compPokemon = this.compTeam.getPokemons()[0];

        StaticVars.SCANNER.useDelimiter("\n");
    }

    /*Andrew*/
    private Screen inputMenuChoice() {
        String choiceString = "";
        Screen choice;

        System.out.print("Input Your Menu Choice (Atk, Bag, Pok, Run): ");
        while (true) {
            try {
                choiceString = StaticVars.SCANNER.next();
            }
            catch (Exception e) {
                StaticVars.SCANNER.nextLine();
            }
            if (choiceString.equals("Atk") || choiceString.equals("Bag") || choiceString.equals("Pok") || choiceString.equals("Run")) {
                break;
            }
            System.out.print("\nPlease Try Again!\nInput Your Menu Choice: ");
        }
        choice = Screen.valueOf(choiceString);

        return choice;
    }

    /*Andrew*/
    private Pokemon inputPlayerPokemon() {
        String choiceString = "";
        Pokemon choice = null;

        System.out.print("Input Your Pokemon Choice: ");
        while (true) {
            try {
                choiceString = StaticVars.SCANNER.next();
            }
            catch (Exception e) {
                StaticVars.SCANNER.nextLine();
            }
            if (choiceString.equals(playerTeam.pokemons[0].nickName) || choiceString.equals(playerTeam.pokemons[1].nickName) || choiceString.equals(playerTeam.pokemons[2].nickName) || choiceString.equals(playerTeam.pokemons[3].nickName) || choiceString.equals(playerTeam.pokemons[4].nickName) || choiceString.equals(playerTeam.pokemons[5].nickName)) {
                break;
            }
            System.out.print("\nPlease Try Again!\nInput Your Pokemon Choice: ");
        }

        for (int i=0; i<playerTeam.pokemons.length; i++) {
            if (playerTeam.pokemons[i].nickName.equals(choiceString)) {
                choice = playerTeam.pokemons[i];
                break;
            }
        }

        return choice;
    }

    /*Andrew*/
    private Attack inputAttackChoice() {
        String choiceString = "";
        Attack choice = null;

        System.out.print("Input Your Attack Choice: ");
        while (true) {
            try {
                choiceString = StaticVars.SCANNER.next();
            }
            catch (Exception e) {
                StaticVars.SCANNER.nextLine();
            }
            if (choiceString.equals(playerPokemon.attacks[0].getName()) || choiceString.equals(playerPokemon.attacks[1].getName()) || choiceString.equals(playerPokemon.attacks[2].getName()) || choiceString.equals(playerPokemon.attacks[3].getName())) {
                break;
            }
            System.out.print("\nPlease Try Again!\nInput Your Attack Choice: ");
        }

        for (int i=0; i<playerPokemon.attacks.length; i++) {
            if (playerPokemon.attacks[i].getName().equals(choiceString)) {
                choice = playerPokemon.attacks[i];
                break;
            }
        }

        return choice;
    }

    /*Andrew*/
    public void runAway(boolean isCompTeam) {
        this.isGameOver = true;

        if (isCompTeam) {
            System.out.print("The enemy team has run away!\nGame over!");
        }
        else {
            System.out.print("Your team has run away!\nGame over!");
        }
    }

    /*Andrew*/
    public void switchPokemon(boolean isCompTeam, Pokemon choice) {
        if (isCompTeam) {
            compPokemon = choice;
        }
        else {
            playerPokemon = choice;
        }
    }

    /*Andrew*/
    public void useAttack(Attack attack, Pokemon attacker, Pokemon defender) {
        double rand = Math.random();
        if ((attacker.effect == null) || (rand > attacker.effect.getIncapacitateChance())) {
            rand = Math.random();
            if (rand < attack.getAccuracy()) {
                defender.currentHp -= calculateAttackDamage(attack, attacker, defender);
                rand = Math.random();
                if ((attack.getEffect() != null) && (rand < attack.getEffectChance())) {
                    defender.effect = attack.getEffect();
                }
            }
        }
    }

    /*Andrew*/
    public void useItem(BagItem item, Pokemon target, ComputerTeam compTeam, PlayerTeam playerTeam) {
        item.setNumOfItems(item.getNumOfItems() - 1);

        target.currentHp += item.getItemType().healthIncrease;
        target.stats.level += item.getItemType().levelIncrease;

        if (target.currentHp > target.maxHp) {
            target.currentHp = target.maxHp;
        }
        if (target.stats.level > 100) {
            target.stats.level = 100;
        }

        if (target.fainted) {
            if (item.getItemType().revive) {
                target.currentHp = target.maxHp / 2;
                target.fainted = false;
            }
            else if (item.getItemType().maxRevive) {
                target.currentHp = target.maxHp;
                target.fainted = false;
            }
        }

        if (item.getItemType().pokeBall) {
            if (compTeam != null) {
                for (int i=0; i<compTeam.getPokemons().length; i++) {
                    if (playerTeam.pokemons[i] == target) {
                        Pokemon[] newCompPokemons = new Pokemon[compTeam.getPokemons().length+1];
                        for (int j=0; j<compTeam.getPokemons().length; j++) {
                            newCompPokemons[j] = compTeam.getPokemons()[j];
                        }
                        newCompPokemons[compTeam.getPokemons().length] = target;
                        compTeam.setPokemons(newCompPokemons);
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
                    if (compTeam.getPokemons()[i] == target) {
                        Pokemon[] newPlayerPokemons = new Pokemon[playerTeam.pokemons.length+1];
                        for (int j=0; j<playerTeam.pokemons.length; j++) {
                            newPlayerPokemons[j] = playerTeam.pokemons[j];
                        }
                        newPlayerPokemons[playerTeam.pokemons.length] = target;
                        playerTeam.pokemons = newPlayerPokemons;
                        break;
                    }
                }

                Pokemon[] newCompPokemons = new Pokemon[compTeam.getPokemons().length-1];
                int index = -1;
                for (int i=0; i<compTeam.getPokemons().length; i++) {
                    if (compTeam.getPokemons()[i] == target) {
                        index = i;
                        break;
                    }
                }
                for (int i=0; i<index; i++) {
                    newCompPokemons[i] = compTeam.getPokemons()[i];
                }
                for (int i=index+1; i<compTeam.getPokemons().length-1; i++) {
                    newCompPokemons[i] = compTeam.getPokemons()[i];
                }
                compTeam.setPokemons(newCompPokemons);
            }
        }
    }

    /*Andrew*/
    public int calculateAttackDamage(Attack attack, Pokemon attacker, Pokemon defender) {
        double criticalHitBonus = 1.0;
        if (StaticVars.RANDOM.nextInt(256) < ((int)(attacker.species.baseSpeed/2))) {
            criticalHitBonus = 2.0;
        }

        double STABBonus = 1.0;
        if ((attack.getType() == attacker.species.type1) || (attack.getType() == attacker.species.type2)) {
            STABBonus = 1.5;
        }

        double damage = (((((2.0 * attacker.stats.level * criticalHitBonus)/5.0) + 2.0) * attack.getPower() * ((double)attacker.attackPower/(double)defender.defensePower))/50.0);
        damage = damage * STABBonus * attack.getType().getEffectivenessAgainst(defender.species.type1) * attack.getType().getEffectivenessAgainst(defender.species.type2);
        if (!((int) damage == 1)) {
            damage = damage * (StaticVars.RANDOM.nextInt(256-217) + 217);
        }

        return ((int) damage/255);
    }

    /*Andrew*/
    public void applyEffects(Pokemon[] pokemons) {
        for (int i=0; i<pokemons.length; i++) {
            if ((pokemons[i] != null) && (pokemons[i].effect != null)) {
                applyEffects(pokemons[i]);
            }
        }
    }
    /*Andrew*/
    public void applyEffects(Pokemon pokemon) {
        pokemon.effect.setRoundsLeft(pokemon.effect.getRoundsLeft() - 1);
        pokemon.currentHp -= pokemon.effect.getScalingDamage() * pokemon.currentHp;
        pokemon.currentHp -= pokemon.effect.getDamage();
    }

    public void updateIfFainted(Pokemon[] pokemons) {
        for (int i=0; i<pokemons.length; i++) {
            if ((pokemons[i] != null) && (pokemons[i].currentHp <= 0)) {
                pokemons[i].fainted = true;
            }
        }
    }

    /*Connor*/
    public void nextTurn(){
        applyEffects(this.playerTeam.pokemons);
        applyEffects(this.compTeam.getPokemons());

        updateIfFainted(this.playerTeam.pokemons);
        updateIfFainted(compTeam.getPokemons());

        this.isPlayerTurn = !this.isPlayerTurn;
        if (!isPlayerTurn){
            compTeam.randomMove(this);
        }

        else{
            switch(inputMenuChoice()){
                case Atk:
                    Menus.attackMenu(this.playerTeam);
                    Attack attackChoice = inputAttackChoice();
                    useAttack(attackChoice, this.playerPokemon, this.compPokemon);
                    Menus.battleMenu(this, this.playerPokemon.nickName + " used " + attackChoice.getName());
                    break;
                case Bag:
                    Menus.bagMenu(this.playerTeam);
                    break;
                case Pok:
                    Menus.pokemonMenu(this.playerTeam);
                    Pokemon newPlayerPokemon = inputPlayerPokemon();
                    switchPokemon(false, newPlayerPokemon);
                    Menus.battleMenu(this, newPlayerPokemon.nickName + " has entered the battle");
                    break;
                case Run:
                    runAway(false);

            }
        }
    }
}
