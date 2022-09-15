/*Andrew and Connor*/

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

    public ComputerTeam getCompTeam() {
        return compTeam;
    }

    public void setCompTeam(ComputerTeam compTeam) {
        this.compTeam = compTeam;
    }

    /*Connor*/
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
                choiceString = StaticVars.SCANNER.next(); //inputs the string
            }
            catch (Exception e) {
                StaticVars.SCANNER.nextLine(); //catches exception
            }
            if (choiceString.equals("Atk") || choiceString.equals("Bag") || choiceString.equals("Pok") || choiceString.equals("Run")) { //4 choices for the menu
                break;
            }
            System.out.print("\nPlease Try Again!\nInput Your Menu Choice: ");
        }
        choice = Screen.valueOf(choiceString);

        return choice; //returns choice as an enum
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
                StaticVars.SCANNER.nextLine(); //catches exception
            }
            for (int i=0; i<playerTeam.getPokemons().length; i++) {
                if (choiceString.equals(playerTeam.getPokemons()[i].getNickName())) {
                    if (!playerTeam.getPokemons()[i].getFainted()) { //looks through all pokemon in playerTeam and makes sure they are not fainted
                        break ErrorHandlingLoop;
                    }
                }
            }
            System.out.print("\nPlease Try Again!\nInput Your Pokemon Choice: "); //prints error since pokemon not found in playerTeam
        }

        for (int i=0; i<playerTeam.getPokemons().length; i++) {
            if (playerTeam.getPokemons()[i].getNickName().equals(choiceString)) {
                choice = playerTeam.getPokemons()[i];
                break;
            }
        }

        return choice; //returns pokemon selected
    }

    /*Andrew*/
    private Pokemon inputFaintedPlayerPokemon() {
        //same as above method but used for revives
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
                    if (playerTeam.getPokemons()[i].getFainted()) {
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
                //makes sure the attack is one of the four options
                break;
            }
            System.out.print("\nPlease Try Again!\nInput Your Attack Choice: ");
        }
        //once attack is found in pokemon attacks, return the attack
        for (int i=0; i<playerPokemon.getAttacks().length; i++) {
            if (playerPokemon.getAttacks()[i].getName().equals(choiceString)) {
                choice = playerPokemon.getAttacks()[i];
                break;
            }
        }

        return choice;
    }

    /*Andrew*/
    private BagItem inputItemChoice() {
        String choiceString = "";
        BagItem choice = null;

        System.out.print("Input Your Item Choice: ");
        ErrorHandlingLoop:
        while (true) {
            try {
                choiceString = StaticVars.SCANNER.next();
            }
            catch (Exception e) {
                StaticVars.SCANNER.nextLine();
            }
            for (int i=0; i<playerTeam.getBag().length; i++) {
                if (choiceString.equals(playerTeam.getBag()[i].getItemType().getName())) {
                    //makes sure bag contains the desired item and the quantity of that item > 0
                    if (playerTeam.getBag()[i].getNumOfItems() > 0) {
                        break ErrorHandlingLoop;
                    }
                }
            }
            System.out.print("\nPlease Try Again!\nInput Your Item Choice: ");
        }

        for (int i=0; i<playerTeam.getBag().length; i++) {
            if (playerTeam.getBag()[i].getItemType().getName().equals(choiceString)) {
                choice = playerTeam.getBag()[i];
                break;
            }
        }

        return choice;
    }

    /*Connor*/
    public void runAway(boolean isCompTeam) {
        this.isGameOver = true;

        if (isCompTeam) {
            System.out.print("The enemy team has run away!\nGame over!");
        }
        else {
            System.out.print("Your team has run away!\nGame over!");
        }
    }

    /*Connor*/
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
        if ((attacker.getEffect() == null) || (rand > attacker.getEffect().getIncapacitateChance())) { //random chance being stunned
            rand = Math.random();
            if (rand < attack.getAccuracy()) { //random chance of attack landing
                defender.setCurrentHp(defender.getCurrentHp() - calculateAttackDamage(attack, attacker, defender));
                rand = Math.random();
                if ((attack.getEffect() != null) && (rand < attack.getEffectChance())) { //random chance of attack effect working
                    defender.setEffect(attack.getEffect());
                }
            }
        }

        if (defender.getCurrentHp() < 0) { //sets to 0 instead of negative hp
            defender.setCurrentHp(0);
        }
    }

    /*Andrew*/
    public void useItem(BagItem item, Pokemon target, boolean isCompTeam) {
        item.setNumOfItems(item.getNumOfItems() - 1);
        //adds the items hp boost and level boosts

        target.setCurrentHp(target.getCurrentHp() + item.getItemType().getHealthIncrease());
        target.getStats().setLevel(target.getStats().getLevel() + item.getItemType().getLevelIncrease());

        if (target.getCurrentHp() > target.getMaxHp()) { //doesnt go over max hp
            target.setCurrentHp(target.getMaxHp());
        }
        if (target.getStats().getLevel() > 100) { // max lvl 100
            target.getStats().setLevel(100);
        }

        if (target.getFainted()) {
            if (item.getItemType().getRevive()) {
                target.setCurrentHp(target.getMaxHp() / 2); //if it is regular revive, it gets half its health back
                target.setFainted(false);
            }
            else if (item.getItemType().getMaxRevive()) {
                //if max revive, it gets full health back
                target.setCurrentHp(target.getMaxHp());
                target.setFainted(false);
            }
        }

        if (item.getItemType().getPokeBall()) {
            if (isCompTeam == true) {
                for (int i=0; i<compTeam.getPokemons().length; i++) {
                    if (playerTeam.getPokemons()[i] == target) {
                        Pokemon[] newCompPokemons = new Pokemon[compTeam.getPokemons().length+1];
                        for (int j=0; j<compTeam.getPokemons().length; j++) {
                            newCompPokemons[j] = compTeam.getPokemons()[j]; //moves pokemon to other team
                        }
                        newCompPokemons[compTeam.getPokemons().length] = target;
                        compTeam.setPokemons(newCompPokemons);
                        break;
                    }
                }

                Pokemon[] newPlayerPokemons = new Pokemon[playerTeam.getPokemons().length-1];

                int index = -1;
                for (int i=0; i<playerTeam.getPokemons().length; i++) {

                    //finds index of pokemon on player team

                    if (playerTeam.getPokemons()[i] == target) {
                        index = i;
                        break;
                    }
                }

                int j = 0;
                for (int i = 0; i < index; i++) {
                    newPlayerPokemons[j] = playerTeam.getPokemons()[i];
                    j++;
                }

                //sets new array to all the old pokemons

                for (int i = index + 1; i < playerTeam.getPokemons().length; i++) {
                    newPlayerPokemons[j] = playerTeam.getPokemons()[i];
                    j++;
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

                int j = 0;
                for (int i = 0; i < index; i++) {
                    newCompPokemons[j] = compTeam.getPokemons()[i];
                    j++;
                }
                for (int i = index + 1; i < compTeam.getPokemons().length; i++) {
                    newCompPokemons[j] = compTeam.getPokemons()[i];
                    j++;
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

    /*Connor*/
    public void applyEffects(Pokemon[] pokemons) {
        for (int i=0; i<pokemons.length; i++) {
            if ((pokemons[i] != null) && (pokemons[i].getEffect() != null)) {
                applyEffects(pokemons[i]);
            }
        }
    }
    /*Connor*/
    public void applyEffects(Pokemon pokemon) {
        pokemon.getEffect().setRoundsLeft(pokemon.getEffect().getRoundsLeft() - 1);
        pokemon.setCurrentHp((int) (pokemon.getCurrentHp() - (pokemon.getEffect().getScalingDamage() * pokemon.getCurrentHp())));
        pokemon.setCurrentHp(pokemon.getCurrentHp() - pokemon.getEffect().getDamage());
    }

    /*Connor*/
    public void updateIfFainted(Pokemon[] pokemons) {
        for (int i=0; i<pokemons.length; i++) {
            if ((pokemons[i] != null) && (pokemons[i].getCurrentHp() <= 0)) {
                pokemons[i].setCurrentHp(0);
                pokemons[i].setFainted(true);
            }
        }
    }

    /*Connor*/
    private void checkGameOver() {
        int count = 0;
        for (int i=0; i<compTeam.getPokemons().length; i++) {
            if (compTeam.getPokemons()[i].getFainted()) {
                count++;
            }
        }
        if (count == compTeam.getPokemons().length) {
            isGameOver = true;
            System.out.print("The enemy team has lost!\nYou win! Game over!");
            return;
        }

        count = 0;
        for (int i=0; i<playerTeam.getPokemons().length; i++) {
            if (playerTeam.getPokemons()[i].getFainted()) {
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
            }
            else {
                compTeam.randomMove(this);
            }
        }

        else{
            if (playerPokemon.getFainted() || (playerPokemon == compTeam.getPokemons()[compTeam.getPokemons().length-1])) {
                Menus.pokemonMenu(this.playerTeam, this.compTeam);
                Pokemon newPlayerPokemon = inputPlayerPokemon();
                switchPokemon(false, newPlayerPokemon);
                Menus.battleMenu(this, newPlayerPokemon.getNickName() + " has entered the battle");
            }
            else {
                switch (inputMenuChoice()) {
                    case Atk:
                        Menus.attackMenu(this.playerTeam, this.compTeam);
                        Attack attackChoice = inputAttackChoice();
                        useAttack(attackChoice, this.playerPokemon, this.compPokemon);
                        Menus.battleMenu(this, this.playerPokemon.getNickName() + " used " + attackChoice.getName());
                        break;
                    case Bag:
                        Menus.bagMenu(this.playerTeam, this.compTeam);
                        BagItem itemChoice = inputItemChoice();
                        if (itemChoice.getItemType().getPokeBall()) {
                            useItem(itemChoice, compPokemon, false);
                            Menus.battleMenu(this, "You threw a pokeball and captured " + this.getCompPokemon().getNickName());
                            compTeam.randomSwitchPokemon(this);
                            this.isPlayerTurn = !this.isPlayerTurn; //DONT DELETE ACTUALLY USEFUL
                        }
                        else {
                            Menus.pokemonMenu(this.playerTeam, this.compTeam);
                            if (itemChoice.getItemType().getMaxRevive() || itemChoice.getItemType().getRevive()) {
                                Pokemon pokemonChoice = inputFaintedPlayerPokemon();
                                useItem(itemChoice, pokemonChoice, false);
                                Menus.battleMenu(this, "You used " + itemChoice.getItemType().getName() + " on " + pokemonChoice.getNickName());
                            }
                            else {
                                Pokemon pokemonChoice = inputPlayerPokemon();
                                useItem(itemChoice, pokemonChoice, false);
                                Menus.battleMenu(this, "You used " + itemChoice.getItemType().getName() + " on " + pokemonChoice.getNickName());
                            }
                        }
                        break;
                    case Pok:
                        Menus.pokemonMenu(this.playerTeam, this.compTeam);
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
