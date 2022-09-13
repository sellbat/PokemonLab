import javax.swing.text.Style;

//Connor
public class Menus {
    public static void pokemonMenu(PlayerTeam team){
        String lineThree = "*";
        String lineOne = "";
        String spaceLine = "*";
        for(int i=0; i<30; i++){
            lineOne += ("*");
            lineThree+="-";
            if(i < 29){spaceLine += " ";}
        }
        spaceLine += "*";
        lineThree +="*";
        String lineTwo = "*Pokemon";
        for(int i=0; i<=21 ; i++){
            lineTwo+=" ";
        }
        lineTwo+="*";
        System.out.println(lineTwo);
        System.out.println(lineThree);
        int n =0;
        for(int i=0; i<12; i++){
            if(n<team.pokemons.length){
                int len = 8 + String.valueOf(team.pokemons[n].stats.level).length() + team.pokemons[n].nickName.length();
                System.out.println();
                String currLine = ("*Lvl  " + team.pokemons[n].stats.level +  "  " + team.pokemons[n].nickName);
                for(int j = 0; j<30-len ; j++){
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
        String lineThree = "*";
        String lineOne = "";
        String spaceLine = "*";
        for(int i=0; i<30; i++){
            lineOne += ("*");
            lineThree+="-";
            if(i < 29){spaceLine += " ";}
        }
        spaceLine += "*";
        lineThree +="*";
        String lineTwo = "*Attacks";
        for(int i=0; i<=21 ; i++){
            lineTwo+=" ";
        }
        lineTwo+="*";
        System.out.println(lineTwo);
        System.out.println(lineThree);
        int n =0;
        for(int i=0; i<12; i++){
            if(n<team.pokemons[0].attacks.length){
                int len = 1+String.valueOf(team.pokemons[0].attacks[n]).length();
                System.out.println();
                String currLine = ("*" + team.pokemons[0].attacks[n].name);
                for(int j = 0; j<30-len ; j++){
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
        String lineThree = "*";
        String lineOne = "";
        String spaceLine = "*";
        for(int i=0; i<30; i++){
            lineOne += ("*");
            lineThree+="-";
            if(i < 29){spaceLine += " ";}
        }
        lineThree +="*";
        String lineTwo = "*Bag";
        for(int i=0; i<=25 ; i++){
            lineTwo+=" ";
        }
        spaceLine += "*";
        lineTwo+="*";
        System.out.println(lineTwo);
        System.out.println(lineThree);
        int n =0;
        for(int i=0; i<12; i++){
            if(n<team.bag.length){
                int len = 2+ String.valueOf(team.bag[n].numOfItems).length() + team.bag[n].itemType.name.length();
                System.out.println();
                String currLine = ("*" + team.bag[n].numOfItems + "x " + team.bag[n].itemType.name);
                for(int j = 0; j<30-len ; j++){
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
