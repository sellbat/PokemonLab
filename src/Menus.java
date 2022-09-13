import javax.swing.text.Style;

//Connor
public class Menus {
    public static int maxWidth(PlayerTeam team){
        int max=0;
        for(int n=0; n<team.pokemons.length; n++) {
            String currLine = ("*Lvl  " + team.pokemons[n].stats.level + "  " + team.pokemons[n].nickName);
            int curr = currLine.length();
            if(curr>max){
                max = curr;
            }
        }
        for(int i=0; i<team.pokemons[0].attacks.length; i++){
            String currLine = ("*" + team.pokemons[0].attacks[i].name);
            int curr = currLine.length();
            if(curr>max){
                max = curr;
            }
        }
        for(int i=0 ; i<team.bag.length; i++){
            String currLine = ("*" + team.bag[i].numOfItems + "x " + team.bag[i].itemType.name);
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
                String currLine = ("*Lvl  " + team.pokemons[n].stats.level +  "  " + team.pokemons[n].nickName);
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
                String currLine = ("*" + team.pokemons[0].attacks[n].name);
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
                String currLine = ("*" + team.bag[n].numOfItems + "x " + team.bag[n].itemType.name);
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
        int width = maxWidth(team);

        for (int i = 0; i < width; i++) {
            System.out.print("*");
        }

        String lineOne = "*" + game.compPokemon.nickName + " Lvl " + game.compPokemon.stats.level;
        System.out.print("\n" + lineOne);
        for (int i = 0; i < lineOne.length() - 1; i++) {
            System.out.print(" ");
        }
        System.out.print("*");

        String lineTwo = "*HP: " + game.compPokemon.currentHp;
        System.out.print("\n" + lineTwo);
        for (int i = 0; i < lineOne.length() - 1; i++) {
            System.out.print(" ");
        }
        System.out.print("*");

        System.out.print("\n*");
        for (int i = 0; i < width - 5; i++) {
            System.out.print(" ");
        }
        System.out.print("O    *");

        System.out.print("\n*");
        for (int i = 0; i < width - 6; i++) {
            System.out.print(" ");
        }
        System.out.print("-|-    *");

        System.out.print("\n*");
        for (int i = 0; i < width - 6; i++) {
            System.out.print(" ");
        }
        System.out.print("/ \\    *");

        System.out.print("\n*");
        for (int i = 0; i < width - 1; i++) {
            System.out.print(" ");
        }
        System.out.print("*");

        System.out.print("\n*    O");
        for (int i = 0; i < width - 5; i++) {
            System.out.print(" ");
        }
        System.out.print("*");

        System.out.print("\n*    -|-");
        for (int i = 0; i < width - 6 - game.playerPokemon.nickName.length(); i++) {
            System.out.print(" ");
        }
        System.out.print("" + game.playerPokemon.nickName + " Lvl " + game.playerPokemon.stats.level + "*");

        System.out.print("\n*    / \\");
        for (int i = 0; i < width - 12; i++) {
            System.out.print(" ");
        }
        System.out.print("HP:" + game.playerPokemon.currentHp + "*");

        System.out.print("*");
        for (int i = 0; i < width - 2; i++) {
            System.out.print("_");
        }
        System.out.print("*");

        String firstMessage = message.substring(0, width-8);
        System.out.print("\n" + firstMessage);
        for (int i = 0; i < width - 8 - firstMessage.length(); i++) {
            System.out.print(" ");
        }
        System.out.print("|Atk|Bag*");

        String secondMessage = message.substring(width-8, message.length());
        System.out.print("\n" + secondMessage);
        for (int i = 0; i < width - 8 - secondMessage.length(); i++) {
            System.out.print(" ");
        }
        System.out.print("|Pok|Run*");

        for (int i = 0; i < width; i++) {
            System.out.print("*");
        }
    }
}
