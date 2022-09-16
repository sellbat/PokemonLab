/*Andrew and Connor*/

public class Menus {
    /*Connor*/
    private static int maxWidth(PlayerTeam team, ComputerTeam compTeam){
        int max=0;

        //finds the maximum string length that should be printed out

        for(int n=0; n<team.getPokemons().length; n++) {
            String currLine = ("*Lvl " + team.getPokemons()[n].getStats().getLevel() + " " + team.getPokemons()[n].getNickName()) + " (fainted)";
            //maximum pokemon menu line length

            int curr = currLine.length();
            if(curr>max){
                max = curr;
            }
        }
        for(int j=0 ; j<team.getPokemons().length ; j++) {
            for (int i = 0; i < team.getPokemons()[j].getAttacks().length; i++) {
                //maximum pokemon name length
                String currLine = ("*   -|-" + team.getPokemons()[j].getAttacks()[i].getName() + " Lvl 100");
                int curr = currLine.length();
                if (curr > max) {
                    max = curr;
                }
            }
        }
        for(int i=0 ; i<team.getBag().length; i++){

            //maximum bag menu line length

            String currLine = ("*" + team.getBag()[i].getNumOfItems() + "x " + team.getBag()[i].getItemType().getName());
            int curr = currLine.length();
            if(curr>max){
                max = curr;
            }
        }
        //repeats the process for the compTeam pokemon
        for(int n=0; n<compTeam.getPokemons().length; n++) {
            String currLine = ("*Lvl " + compTeam.getPokemons()[n].getStats().getLevel() + " " + compTeam.getPokemons()[n].getNickName()) + " (fainted)";
            int curr = currLine.length();
            if(curr>max){
                max = curr;
            }
        }
        for(int j=0 ; j<compTeam.getPokemons().length ; j++) {
            for (int i = 0; i < compTeam.getPokemons()[j].getAttacks().length; i++) {
                String currLine = ("*   -|-" + compTeam.getPokemons()[j].getAttacks()[i].getName() + " Lvl 100");
                int curr = currLine.length();
                if (curr > max) {
                    max = curr;
                }
            }
        }
        for(int i=0 ; i<compTeam.getBag().length; i++){
            String currLine = ("*" + compTeam.getBag()[i].getNumOfItems() + "x " + compTeam.getBag()[i].getItemType().getName());
            int curr = currLine.length();
            if(curr>max){
                max = curr;
            }
        }
        return max;
    }

    /*Connor*/
    public static void pokemonMenu(PlayerTeam team, ComputerTeam compTeam){
        //creates head
        String lineThree = "*";
        String lineOne = "*";
        String spaceLine = "*";
        int max = maxWidth(team, compTeam);
        for(int i=0; i<max; i++){
            lineOne += ("*");
            lineThree+="-";
            if(i < max-1){spaceLine += " ";}
        }
        lineThree = lineThree.substring(0,lineThree.length()-1);
        spaceLine += "*";
        lineThree +="*";
        String lineTwo = "*Pokemon";
        //pokemon title
        for(int i=0; i<max-8 ; i++){
            lineTwo+=" ";
        }
        lineTwo+="*";
        System.out.println(lineOne);
        System.out.println(lineTwo);
        System.out.println(lineThree);
        int n =0;
        //prints 12 lines for the pokemon
        for(int i=0; i<12; i++){
            if(n<team.getPokemons().length){
                String levelString = String.valueOf(team.getPokemons()[n].getStats().getLevel());
                if(team.getPokemons()[n].getFainted()) {
                    for (int k = 0; k < 3 - String.valueOf(team.getPokemons()[n].getStats().getLevel()).length(); k++) {
                        levelString = " " + levelString;
                    }
                    String currLine = ("*Lvl " + levelString + " " + team.getPokemons()[n].getNickName() + " (fainted)");
                    for (int j = currLine.length(); j < (max); j++) {
                        currLine += " ";
                    }
                    currLine += "*";
                    System.out.println(currLine); //prints out the pokemon line in the menu if it is fainted
                    n += 1;
                }
                else{//prints out the pokemon line in the menu if the pokemon is not fainted
                    for (int k = 0; k < 3 - String.valueOf(team.getPokemons()[n].getStats().getLevel()).length(); k++) {
                        levelString = " " + levelString;
                    }
                    String currLine = ("*Lvl " + levelString + " " + team.getPokemons()[n].getNickName() + " ");
                    for (int j = currLine.length(); j < (max); j++) {
                        currLine += " ";
                    }
                    currLine += "*";
                    System.out.println(currLine);
                    n += 1;
                }
            }
            else{
                System.out.println(spaceLine);
            }
        }
        System.out.println(lineOne);
    }

    /*Connor*/
    public static void attackMenu(Pokemon playerPokemon, PlayerTeam team, ComputerTeam compTeam){
        int max = maxWidth(team, compTeam);

        //creates header for the attack menu

        String lineThree = "*";
        String lineOne = "*";
        String spaceLine = "*";
        for(int i=0; i<max; i++){
            lineOne += ("*");
            lineThree+="-";
            if(i < max-1){spaceLine += " ";}
        }
        lineThree = lineThree.substring(0,lineThree.length()-1);

        spaceLine += "*";
        lineThree +="*";
        String lineTwo = "*Attacks";
        for(int i=0; i<max-8 ; i++){ //accounts for offset in Attacks title
            lineTwo+=" ";
        }
        lineTwo+="*";
        System.out.println(lineOne);
        System.out.println(lineTwo);
        System.out.println(lineThree);
        int n =0;
        for(int i=0; i<12; i++){
            if(n<playerPokemon.getAttacks().length){
                String currLine = ("*" + playerPokemon.getAttacks()[n].getName()); //prints out all the attacks
                for(int j = currLine.length(); j<max ; j++){ //accounts for difference in max
                    currLine += " ";
                }
                currLine+="*";
                System.out.println(currLine);
                n+=1;
            }
            else{
                System.out.println(spaceLine);
            }
        }
        System.out.println(lineOne);
    }

    /*Connor*/
    public static void bagMenu(PlayerTeam team, ComputerTeam compTeam){
        int max = maxWidth(team, compTeam);

        //creates header for bag menu

        String lineThree = "*";
        String lineOne = "*";
        String spaceLine = "*";
        for(int i=0; i<max; i++){
            lineOne += ("*");
            lineThree+="-";
            if(i < max-1){spaceLine += " ";}
        }
        lineThree = lineThree.substring(0,lineThree.length()-1);
        lineThree +="*";
        String lineTwo = "*Bag";
        for(int i=0; i<max-4 ; i++){
            lineTwo+=" ";
        }
        spaceLine += "*";
        lineTwo+="*";
        System.out.println(lineOne);
        System.out.println(lineTwo);
        System.out.println(lineThree);
        int n =0;
        for(int i=0; i<12; i++){
            if(n<team.getBag().length){
                String currLine = ("*" + team.getBag()[n].getNumOfItems() + "x " + team.getBag()[n].getItemType().getName());
                for(int j = currLine.length(); j<max; j++){ //offset spaces by max
                    currLine += " ";
                }
                currLine+="*";
                System.out.println(currLine);
                n+=1;
            }
            else{
                System.out.println(spaceLine);
            }
        }
        
        System.out.println(lineOne);
    }

    /*Andrew*/
    public static void battleMenu(Game game, String message) {
        int width = maxWidth(game.getPlayerTeam(), game.getCompTeam());

        //Top Row of *
        for (int i = 0; i < width+1; i++) {
            System.out.print("*");
        }

        //First Line that has *[Name] Lvl [Level]             *
        String lineOne = "*" + game.getCompPokemon().getNickName() + " Lvl " + game.getCompPokemon().getStats().getLevel();
        System.out.print("\n" + lineOne);
        for (int i = 0; i < width - lineOne.length(); i++) {
            System.out.print(" ");
        }
        System.out.print("*");

        //HP Line
        String lineTwo = "*HP: " + game.getCompPokemon().getCurrentHp();
        System.out.print("\n" + lineTwo);
        for (int i = 0; i < width - lineTwo.length(); i++) {
            System.out.print(" ");
        }
        System.out.print("*");

        //Head Line
        System.out.print("\n*");
        for (int i = 0; i < width - 6; i++) {
            System.out.print(" ");
        }
        System.out.print("O    *");

        //Body Line
        System.out.print("\n*");
        for (int i = 0; i < width - 7; i++) {
            System.out.print(" ");
        }
        System.out.print("-|-   *");

        //Legs Line
        System.out.print("\n*");
        for (int i = 0; i < width - 7; i++) {
            System.out.print(" ");
        }
        System.out.print("/ \\   *");

        //Blank Line
        System.out.print("\n*");
        for (int i = 0; i < width - 1; i++) {
            System.out.print(" ");
        }
        System.out.print("*");

        //Head Line
        System.out.print("\n*    O");
        for (int i = 0; i < width - 6; i++) {
            System.out.print(" ");
        }
        System.out.print("*");

        //Body Line
        System.out.print("\n*   -|-");
        for (int i = 0; i < width - 12 - game.getPlayerPokemon().getNickName().length() - String.valueOf(game.getPlayerPokemon().getStats().getLevel()).length(); i++) {
            System.out.print(" ");
        }
        System.out.print("" + game.getPlayerPokemon().getNickName() + " Lvl " + game.getPlayerPokemon().getStats().getLevel() + "*");

        //Legs Line
        System.out.print("\n*   / \\");
        for (int i = 0; i < width - 11 - String.valueOf(game.getPlayerPokemon().getCurrentHp()).length(); i++) {
            System.out.print(" ");
        }
        System.out.print("HP: " + game.getPlayerPokemon().getCurrentHp() + "*");

        //*______________* Line
        System.out.print("\n*");
        for (int i = 0; i < width - 1; i++) {
            System.out.print("_");
        }
        System.out.print("*");

        //Make all messages at least long enough
        for (int i=0; i<(2*(width-8)) - message.length(); i++) {
            message += " ";
        }

        String firstMessage = "*" + message.substring(0, Math.min(message.length(), width-9));
        System.out.print("\n" + firstMessage);
        for (int i = 0; i < width - 8 - firstMessage.length(); i++) {
            System.out.print(" ");
        }
        System.out.print("|Atk|Bag*");

        String secondMessage = "*" + message.substring(Math.min(message.length(), width-9), Math.min(message.length(), 2*width-18));
        System.out.print("\n" + secondMessage);
        for (int i = 0; i < width - 8 - secondMessage.length(); i++) {
            System.out.print(" ");
        }
        System.out.print("|Pok|Run*\n");

        for (int i = 0; i < width+1; i++) {
            System.out.print("*");
        }
        System.out.print("\n");
    }
}










































































