public class Screen {
    public void pokemonMenu(PlayerTeam team){
        String lineThree = "*";
        String lineOne = "";
        for(int i=0; i<30; i++){
            lineOne += ("*");
            lineThree+="-";
        }
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
        }
        System.out.println(lineOne);
    }
    public void attackMenu(PlayerTeam team){
        String lineThree = "*";
        String lineOne = "";
        for(int i=0; i<30; i++){
            lineOne += ("*");
            lineThree+="-";
        }
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
                String currLine = ("*" + team.pokemons[0].attacks[n].name );
                for(int j = 0; j<30-len ; j++){
                    currLine += " ";
                }
                currLine+="*";
                System.out.println(currLine);
                n+=1;
            }
        }
        System.out.println(lineOne);
    }
    public void bagMenu(){

    }








    

}
