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

    /*Andrew*/
    public void setup() {
        this.isPlayerTurn = false;

        this.playerPokemon = this.playerTeam.getPokemons()[0];
        this.compPokemon = this.compTeam.getPokemons()[0];

        StaticVars.SCANNER.useDelimiter("\n");

        Menus.battleMenu(this, "You have entered the battle!");
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
        ErrorHandlingLoop:
        while (true) {
            try {
                choiceString = StaticVars.SCANNER.next();
            }
            catch (Exception e) {
                StaticVars.SCANNER.nextLine();
            }
            for (int i=0; i<playerTeam.getPokemons().length; i++) {
                if (choiceString.equals(playerTeam.getPokemons()[i].getNickName())) {
                    if (!playerTeam.getPokemons()[i].getFainted()) {
                        break ErrorHandlingLoop;
                    }
                }
            }
            System.out.print("\nPlease Try Again!\nInput Your Pokemon Choice: ");
        }

        for (int i=0; i<playerTeam.getPokemons().length; i++) {
            if (playerTeam.getPokemons()[i].getNickName().equals(choiceString)) {
                choice = playerTeam.getPokemons()[i];
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
            if (choiceString.equals(playerPokemon.getAttacks()[0].getName()) || choiceString.equals(playerPokemon.getAttacks()[1].getName()) || choiceString.equals(playerPokemon.getAttacks()[2].getName()) || choiceString.equals(playerPokemon.getAttacks()[3].getName())) {
                break;
            }
            System.out.print("\nPlease Try Again!\nInput Your Attack Choice: ");
        }

        for (int i=0; i<playerPokemon.getAttacks().length; i++) {
            if (playerPokemon.getAttacks()[i].getName().equals(choiceString)) {
                choice = playerPokemon.getAttacks()[i];
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
        if ((attacker.getEffect() == null) || (rand > attacker.getEffect().getIncapacitateChance())) {
            rand = Math.random();
            if (rand < attack.getAccuracy()) {
                defender.setCurrentHp(defender.getCurrentHp() - calculateAttackDamage(attack, attacker, defender));
                rand = Math.random();
                if ((attack.getEffect() != null) && (rand < attack.getEffectChance())) {
                    defender.setEffect(attack.getEffect());
                }
            }
        }
    }

    /*Andrew*/
    public void useItem(BagItem item, Pokemon target, ComputerTeam compTeam, PlayerTeam playerTeam) {
        item.setNumOfItems(item.getNumOfItems() - 1);

        target.setCurrentHp(target.getCurrentHp() + item.getItemType().getHealthIncrease());
        target.getStats().setLevel(target.getStats().getLevel() + item.getItemType().getLevelIncrease());

        if (target.getCurrentHp() > target.getMaxHp()) {
            target.setCurrentHp(target.getMaxHp());
        }
        if (target.getStats().getLevel() > 100) {
            target.getStats().setLevel(100);
        }

        if (target.getFainted()) {
            if (item.getItemType().getRevive()) {
                target.setCurrentHp(target.getMaxHp() / 2);
                target.setFainted(false);
            }
            else if (item.getItemType().getMaxRevive()) {
                target.setCurrentHp(target.getMaxHp());
                target.setFainted(false);
            }
        }

        if (item.getItemType().getPokeBall()) {
            if (compTeam != null) {
                for (int i=0; i<compTeam.getPokemons().length; i++) {
                    if (playerTeam.getPokemons()[i] == target) {
                        Pokemon[] newCompPokemons = new Pokemon[compTeam.getPokemons().length+1];
                        for (int j=0; j<compTeam.getPokemons().length; j++) {
                            newCompPokemons[j] = compTeam.getPokemons()[j];
                        }
                        newCompPokemons[compTeam.getPokemons().length] = target;
                        compTeam.setPokemons(newCompPokemons);
                        break;
                    }
                }

                Pokemon[] newPlayerPokemons = new Pokemon[playerTeam.getPokemons().length-1];
                int index = -1;
                for (int i=0; i<playerTeam.getPokemons().length; i++) {
                    if (playerTeam.getPokemons()[i] == target) {
                        index = i;
                        break;
                    }
                }
                for (int i=0; i<index; i++) {
                    newPlayerPokemons[i] = playerTeam.getPokemons()[i];
                }
                for (int i=index+1; i<playerTeam.getPokemons().length-1; i++) {
                    newPlayerPokemons[i] = playerTeam.getPokemons()[i];
                }
                playerTeam.setPokemons(newPlayerPokemons);
            }

            else {
                for (int i=0; i<playerTeam.getPokemons().length; i++) {
                    if (compTeam.getPokemons()[i] == target) {
                        Pokemon[] newPlayerPokemons = new Pokemon[playerTeam.getPokemons().length+1];
                        for (int j=0; j<playerTeam.getPokemons().length; j++) {
                            newPlayerPokemons[j] = playerTeam.getPokemons()[j];
                        }
                        newPlayerPokemons[playerTeam.getPokemons().length] = target;
                        playerTeam.setPokemons(newPlayerPokemons);
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
        if (StaticVars.RANDOM.nextInt(256) < ((int)(attacker.getSpecies().getBaseSpeed()/2))) {
            criticalHitBonus = 2.0;
        }

        double STABBonus = 1.0;
        if ((attack.getType() == attacker.getSpecies().getType1()) || (attack.getType() == attacker.getSpecies().getType2())) {
            STABBonus = 1.5;
        }

        double damage = (((((2.0 * attacker.getStats().getLevel() * criticalHitBonus)/5.0) + 2.0) * attack.getPower() * ((double)attacker.getAttackPower()/(double)defender.getDefensePower()))/50.0);
        damage = damage * STABBonus * attack.getType().getEffectivenessAgainst(defender.getSpecies().getType1()) * attack.getType().getEffectivenessAgainst(defender.getSpecies().getType2());
        if (!((int) damage == 1)) {
            damage = damage * (StaticVars.RANDOM.nextInt(256-217) + 217);
        }

        return ((int) damage/255);
    }

    /*Andrew*/
    public void applyEffects(Pokemon[] pokemons) {
        for (int i=0; i<pokemons.length; i++) {
            if ((pokemons[i] != null) && (pokemons[i].getEffect() != null)) {
                applyEffects(pokemons[i]);
            }
        }
    }
    /*Andrew*/
    public void applyEffects(Pokemon pokemon) {
        pokemon.getEffect().setRoundsLeft(pokemon.getEffect().getRoundsLeft() - 1);
        pokemon.setCurrentHp((int) (pokemon.getCurrentHp() - (pokemon.getEffect().getScalingDamage() * pokemon.getCurrentHp())));
        pokemon.setCurrentHp(pokemon.getCurrentHp() - pokemon.getEffect().getDamage());
    }

    /*Andrew*/
    public void updateIfFainted(Pokemon[] pokemons) {
        for (int i=0; i<pokemons.length; i++) {
            if ((pokemons[i] != null) && (pokemons[i].getCurrentHp() <= 0)) {
                pokemons[i].setFainted(true);
            }
        }
    }

    private void checkGameOver() {
        int count = 0;
        for (Pokemon compPokemon : compTeam.getPokemons()) {
            if (compPokemon.getFainted()) {
                count++;
            }
        }
        if (count == compTeam.getPokemons().length) {
            isGameOver = true;
            System.out.print("The enemy team has lost!\nYou win! Game over!");
            return;
        }

        count = 0;
        for (Pokemon playerPokemon : playerTeam.getPokemons()) {
            if (playerPokemon.getFainted()) {
                count++;
            }
        }
        if (count == playerTeam.getPokemons().length) {
            isGameOver = true;
            System.out.print("Your team has lost!\nThe enemy wins! Game over!");
            return;
        }
    }

    /*Andrew*/
    public void nextTurn(){
        this.isPlayerTurn = !this.isPlayerTurn;

        applyEffects(this.playerTeam.getPokemons());
        applyEffects(this.compTeam.getPokemons());

        if (!isPlayerTurn){
            if (compPokemon.getFainted()) {
                compTeam.randomSwitchPokemon(this);
                Menus.battleMenu(this, compPokemon.getNickName() + " has entered the battle");
            }
            else {
                compTeam.randomMove(this);
            }
        }

        else{
            if (playerPokemon.getFainted()) {
                Menus.pokemonMenu(this.playerTeam);
                Pokemon newPlayerPokemon = inputPlayerPokemon();
                switchPokemon(false, newPlayerPokemon);
                Menus.battleMenu(this, newPlayerPokemon.getNickName() + " has entered the battle");
            }
            else {
                switch (inputMenuChoice()) {
                    case Atk:
                        Menus.attackMenu(this.playerTeam);
                        Attack attackChoice = inputAttackChoice();
                        useAttack(attackChoice, this.playerPokemon, this.compPokemon);
                        Menus.battleMenu(this, this.playerPokemon.getNickName() + " used " + attackChoice.getName());
                        break;
                    case Bag:
                        Menus.bagMenu(this.playerTeam);
                        break;
                    case Pok:
                        Menus.pokemonMenu(this.playerTeam);
                        Pokemon newPlayerPokemon = inputPlayerPokemon();
                        switchPokemon(false, newPlayerPokemon);
                        Menus.battleMenu(this, newPlayerPokemon.getNickName() + " has entered the battle");
                        break;
                    case Run:
                        runAway(false);

                }
            }
        }
        updateIfFainted(this.playerTeam.getPokemons());
        updateIfFainted(compTeam.getPokemons());

        checkGameOver();
    }
}
