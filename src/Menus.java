import javax.swing.text.Style;

//Connor
public class Menus {
    public static int maxWidth(PlayerTeam team){
        int max=0;
        for(int n=0; n<team.pokemons.length; n++) {
            String currLine = ("*Lvl " + team.pokemons[n].stats.level + " " + team.pokemons[n].nickName) + " ";
            int curr = currLine.length();
            if(curr>max){
                max = curr;
            }
        }
        for(int i=0; i<team.pokemons[0].attacks.length; i++){
            String currLine = ("*" + team.pokemons[0].attacks[i].getName());
            int curr = currLine.length();
            if(curr>max){
                max = curr;
            }
        }
        for(int i=0 ; i<team.bag.length; i++){
            String currLine = ("*" + team.bag[i].getNumOfItems() + "x " + team.bag[i].getItemType().name);
            int curr = currLine.length();
            if(curr>max){
                max = curr;
            }
        }
        return max;

    }
    public static void pokemonMenu(PlayerTeam team){
        String lineThree = "*";
        String lineOne = "*";
        String spaceLine = "*";
        int max = maxWidth(team);
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
            if(n<team.pokemons.length){
                String levelString = String.valueOf(team.pokemons[n].stats.level);
                for (int k=0; k<3-String.valueOf(team.pokemons[n].stats.level).length(); k++) {
                    levelString = " " + levelString;
                }
                String currLine = ("*Lvl " + levelString +  " " + team.pokemons[n].nickName + " ");
                for (int j = currLine.length(); j < (max); j++) {
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
    public static void attackMenu(PlayerTeam team){
        int max = maxWidth(team);
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
            if(n<team.pokemons[0].attacks.length){
                String currLine = ("*" + team.pokemons[0].attacks[n].getName());
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
    public static void bagMenu(PlayerTeam team){
        int max = maxWidth(team);
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
            if(n<team.bag.length){
                String currLine = ("*" + team.bag[n].getNumOfItems() + "x " + team.bag[n].getItemType().name);
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
        int width = maxWidth(game.getPlayerTeam());

        for (int i = 0; i < width; i++) {
            System.out.print("*");
        }

        String lineOne = "*" + game.getCompPokemon().nickName + " Lvl " + game.getCompPokemon().stats.level;
        System.out.print("\n" + lineOne);
        for (int i = 0; i < width - lineOne.length() - 1; i++) {
            System.out.print(" ");
        }
        System.out.print("*");

        String lineTwo = "*HP: " + game.getCompPokemon().currentHp;
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
        for (int i = 0; i < width - 13 - game.getPlayerPokemon().nickName.length() - String.valueOf(game.getPlayerPokemon().stats.level).length(); i++) {
            System.out.print(" ");
        }
        System.out.print("" + game.getPlayerPokemon().nickName + " Lvl " + game.getPlayerPokemon().stats.level + "*");

        System.out.print("\n*   / \\");
        for (int i = 0; i < width - 12 - String.valueOf(game.getPlayerPokemon().currentHp).length(); i++) {
            System.out.print(" ");
        }
        System.out.print("HP: " + game.getPlayerPokemon().currentHp + "*");

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
