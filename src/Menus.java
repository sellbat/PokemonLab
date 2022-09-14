import javax.swing.text.Style;

//Connor
public class Menus {
    private static int maxWidth(PlayerTeam team, ComputerTeam compTeam){
        int max=0;
        for(int n=0; n<team.getPokemons().length; n++) {
            String currLine = ("*Lvl " + team.getPokemons()[n].getStats().getLevel() + " " + team.getPokemons()[n].getNickName()) + " (fainted)";
            int curr = currLine.length();
            if(curr>max){
                max = curr;
            }
        }
        for(int j=0 ; j<team.getPokemons().length ; j++) {
            for (int i = 0; i < team.getPokemons()[j].getAttacks().length; i++) {
                String currLine = ("*   -|-" + team.getPokemons()[j].getAttacks()[i].getName() + " Lvl 100");
                int curr = currLine.length();
                if (curr > max) {
                    max = curr;
                }
            }
        }
        for(int i=0 ; i<team.getBag().length; i++){
            String currLine = ("*" + team.getBag()[i].getNumOfItems() + "x " + team.getBag()[i].getItemType().getName());
            int curr = currLine.length();
            if(curr>max){
                max = curr;
            }
        }
        for(int n=0; n<compTeam.getPokemons().length; n++) {
            String currLine = ("*Lvl " + team.getPokemons()[n].getStats().getLevel() + " " + team.getPokemons()[n].getNickName()) + " (fainted)";
            int curr = currLine.length();
            if(curr>max){
                max = curr;
            }
        }
        for(int j=0 ; j<compTeam.getPokemons().length ; j++) {
            for (int i = 0; i < team.getPokemons()[j].getAttacks().length; i++) {
                String currLine = ("*   -|-" + team.getPokemons()[j].getAttacks()[i].getName() + " Lvl 100");
                int curr = currLine.length();
                if (curr > max) {
                    max = curr;
                }
            }
        }
        for(int i=0 ; i<compTeam.getBag().length; i++){
            String currLine = ("*" + team.getBag()[i].getNumOfItems() + "x " + team.getBag()[i].getItemType().getName());
            int curr = currLine.length();
            if(curr>max){
                max = curr;
            }
        }
        return max;
    }

    public static void pokemonMenu(PlayerTeam team, ComputerTeam compTeam){
        //NEED TO ADD " (fainted)"
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
        for(int i=0; i<max-8 ; i++){
            lineTwo+=" ";
        }
        lineTwo+="*";
        System.out.println(lineOne);
        System.out.println(lineTwo);
        System.out.println(lineThree);
        int n =0;
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
                    System.out.println(currLine);
                    n += 1;
                }
                else{
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
    public static void attackMenu(PlayerTeam team, ComputerTeam compTeam){
        int max = maxWidth(team, compTeam);
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
        for(int i=0; i<max-8 ; i++){
            lineTwo+=" ";
        }
        lineTwo+="*";
        System.out.println(lineOne);
        System.out.println(lineTwo);
        System.out.println(lineThree);
        int n =0;
        for(int i=0; i<12; i++){
            if(n<team.getPokemons()[0].getAttacks().length){
                String currLine = ("*" + team.getPokemons()[0].getAttacks()[n].getName());
                for(int j = currLine.length(); j<max ; j++){
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
    public static void bagMenu(PlayerTeam team, ComputerTeam compTeam){
        int max = maxWidth(team, compTeam);
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
                for(int j = currLine.length(); j<max; j++){
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

        for (int i = 0; i < width; i++) {
            System.out.print("*");
        }

        String lineOne = "*" + game.getCompPokemon().getNickName() + " Lvl " + game.getCompPokemon().getStats().getLevel();
        System.out.print("\n" + lineOne);
        for (int i = 0; i < width - lineOne.length() - 1; i++) {
            System.out.print(" ");
        }
        System.out.print("*");

        String lineTwo = "*HP: " + game.getCompPokemon().getCurrentHp();
        System.out.print("\n" + lineTwo);
        for (int i = 0; i < width - lineTwo.length() - 1; i++) {
            System.out.print(" ");
        }
        System.out.print("*");

        System.out.print("\n*");
        for (int i = 0; i < width - 7; i++) {
            System.out.print(" ");
        }
        System.out.print("O    *");

        System.out.print("\n*");
        for (int i = 0; i < width - 8; i++) {
            System.out.print(" ");
        }
        System.out.print("-|-   *");

        System.out.print("\n*");
        for (int i = 0; i < width - 8; i++) {
            System.out.print(" ");
        }
        System.out.print("/ \\   *");

        System.out.print("\n*");
        for (int i = 0; i < width - 2; i++) {
            System.out.print(" ");
        }
        System.out.print("*");

        System.out.print("\n*    O");
        for (int i = 0; i < width - 7; i++) {
            System.out.print(" ");
        }
        System.out.print("*");

        System.out.print("\n*   -|-");
        for (int i = 0; i < width - 13 - game.getPlayerPokemon().getNickName().length() - String.valueOf(game.getPlayerPokemon().getStats().getLevel()).length(); i++) {
            System.out.print(" ");
        }
        System.out.print("" + game.getPlayerPokemon().getNickName() + " Lvl " + game.getPlayerPokemon().getStats().getLevel() + "*");

        System.out.print("\n*   / \\");
        for (int i = 0; i < width - 12 - String.valueOf(game.getPlayerPokemon().getCurrentHp()).length(); i++) {
            System.out.print(" ");
        }
        System.out.print("HP: " + game.getPlayerPokemon().getCurrentHp() + "*");

        System.out.print("\n*");
        for (int i = 0; i < width - 2; i++) {
            System.out.print("_");
        }
        System.out.print("*");


        for (int i=0; i<(2*(width-9)) - message.length(); i++) {
            message += "";
        }

        String firstMessage = "*" + message.substring(0, Math.min(message.length(), width-10));
        System.out.print("\n" + firstMessage);
        for (int i = 0; i < width - 9 - firstMessage.length(); i++) {
            System.out.print(" ");
        }
        System.out.print("|Atk|Bag*");

        String secondMessage = "*" + message.substring(Math.min(message.length(), width-10), Math.min(message.length(), 2*width-20));
        System.out.print("\n" + secondMessage);
        for (int i = 0; i < width - 9 - secondMessage.length(); i++) {
            System.out.print(" ");
        }
        System.out.print("|Pok|Run*\n");

        for (int i = 0; i < width; i++) {
            System.out.print("*");
        }
        System.out.print("\n");
    }
}
