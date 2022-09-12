public class Game {
    public boolean isGameOver;
    public boolean isPlayerTurn;
    enum Screen {Battle, AttackMenu, BagMenu, PokemonMenu}
    public Pokemon playerPokemon;
    public Pokemon compPokemon;

    public void setup(PlayerTeam myTeam, ComputerTeam compTeam){
        this.playerPokemon = myTeam.pokemons[0];
        this.compPokemon = compTeam.pokemons[0];

        StaticVars.SCANNER.useDelimiter("\n");
    }

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

    public int useItem(BagItem item, Pokemon target) {

    }

    public int calculateAttackDamage(Attack attack, Pokemon attacker, Pokemon defender) {
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

    public void nextTurn(PlayerTeam myTeam, ComputerTeam compTeam){
        this.isPlayerTurn = !this.isPlayerTurn;
        if (!isPlayerTurn){
            compTeam.randomMove();
        }
        else{
            switch(inputMenuChoice()){
                case AttackMenu:
                    Menus.attackMenu(myTeam);
                case BagMenu:
                    Menus.bagMenu(myTeam);
                case PokemonMenu:
                    Menus.pokemonMenu(myTeam);
            }
        }

    }
    public void input(){

    }


}
