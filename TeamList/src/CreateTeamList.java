import java.io.*;
import java.util.ArrayList;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CreateTeamList {

    private static int[] kyogreBS = {100,100,90,150,140,90};
    private static int[] zacianBS = {92,170,115,80,115,148};
    private static int[] tornadusBS = {79,115,70,125,80,111};
    private static int[] kartanaBS = {59,181,131,59,31,109};
    private static int[] landorus_tBS = {89,145,90,105,80,91};
    private static int[] amoongusBS = {114,85,70,85,80,30};


    public static ArrayList<PastPokemon> readFile() throws IOException {

        ArrayList<PastPokemon> teamList = new ArrayList<PastPokemon>();

        PastPokemon pastPokemon1 = new PastPokemon();
        PastPokemon pastPokemon2 = new PastPokemon();
        PastPokemon pastPokemon3 = new PastPokemon();
        PastPokemon pastPokemon4 = new PastPokemon();
        PastPokemon pastPokemon5 = new PastPokemon();
        PastPokemon pastPokemon6 = new PastPokemon();

        int nb_poke = 1;
        int nb_move = 1;
        String[] moves = new String[]{"","","","","",""};
        int[] evs = new int[]{0,0,0,0,0,0};
        int[] ivs = new int[]{0,0,0,0,0,0};

        Matcher matcher;
        Matcher matcher_bs;
        File file = new File(
                "C:\\Users\\d.lamarche\\Desktop\\past1.txt");

        BufferedReader br
                = new BufferedReader(new FileReader(file));

        String st;
        while ((st = br.readLine()) != null) {
            matcher = Pattern.compile("(.*)\\s@\\s(.*\\w)|Ability: (.*\\w)|Level: (.*\\w)|EVs: (.*\\w)|(.*\\w) Nature|IVs: (.*\\w)|- (.*\\w)").matcher(st);
            if (matcher.find()) {
                if(matcher.group(1)!=null) {
                    if(nb_poke==1){
                        pastPokemon1.setName(matcher.group(1));
                    }else if(nb_poke==2){
                        pastPokemon2.setName(matcher.group(1));
                    }else if(nb_poke==3){
                        pastPokemon3.setName(matcher.group(1));
                    }else if(nb_poke==4){
                        pastPokemon4.setName(matcher.group(1));
                    }else if(nb_poke==5){
                        pastPokemon5.setName(matcher.group(1));
                    }else if(nb_poke==6){
                        pastPokemon6.setName(matcher.group(1));
                    }
                }

                if(matcher.group(2)!=null) {
                    if (nb_poke == 1) {
                        pastPokemon1.setItem(matcher.group(2));
                    } else if (nb_poke == 2) {
                        pastPokemon2.setItem(matcher.group(2));
                    } else if (nb_poke == 3) {
                        pastPokemon3.setItem(matcher.group(2));
                    } else if (nb_poke == 4) {
                        pastPokemon4.setItem(matcher.group(2));
                    } else if (nb_poke == 5) {
                        pastPokemon5.setItem(matcher.group(2));
                    } else if (nb_poke == 6) {
                        pastPokemon6.setItem(matcher.group(2));
                    }
                }
                if(matcher.group(3)!=null){
                    if(nb_poke==1){
                        pastPokemon1.setAbility(matcher.group(3));
                    }else if(nb_poke==2){
                        pastPokemon2.setAbility(matcher.group(3));
                    }else if(nb_poke==3){
                        pastPokemon3.setAbility(matcher.group(3));
                    }else if(nb_poke==4){
                        pastPokemon4.setAbility(matcher.group(3));
                    }else if(nb_poke==5){
                        pastPokemon5.setAbility(matcher.group(3));
                    }else if(nb_poke==6){
                        pastPokemon6.setAbility(matcher.group(3));
                    }
                }
                if(matcher.group(4)!=null){
                    if(nb_poke==1){
                        pastPokemon1.setLevel(Integer.parseInt(matcher.group(4)));
                    }else if(nb_poke==2){
                        pastPokemon2.setLevel(Integer.parseInt(matcher.group(4)));
                    }else if(nb_poke==3){
                        pastPokemon3.setLevel(Integer.parseInt(matcher.group(4)));
                    }else if(nb_poke==4){
                        pastPokemon4.setLevel(Integer.parseInt(matcher.group(4)));
                    }else if(nb_poke==5){
                        pastPokemon5.setLevel(Integer.parseInt(matcher.group(4)));
                    }else if(nb_poke==6){
                        pastPokemon6.setLevel(Integer.parseInt(matcher.group(4)));
                    }
                }

                if(matcher.group(5)!=null){
                    if(nb_poke==1){
                        matcher_bs = Pattern.compile("\\D*(\\d*) HP|\\D*(\\d*) Atk|\\D*(\\d*) Def|\\D*(\\d*) SpA|\\D*(\\d*) SpD|\\D*(\\d*) Spe").matcher(matcher.group(5));
                        if(matcher_bs.find()){
                            if(matcher_bs.group(1)!=null){
                                evs[0] = Integer.parseInt(matcher_bs.group(1));
                            } else {
                              evs[0] = 0;
                            }
                            if(matcher_bs.group(2)!=null){
                                evs[1] = Integer.parseInt(matcher_bs.group(2));
                            } else {
                                evs[1] = 0;
                            }
                            if(matcher_bs.group(3)!=null){
                                evs[2] = Integer.parseInt(matcher_bs.group(3));
                            } else {
                                evs[2] = 0;
                            }
                            if(matcher_bs.group(4)!=null){
                                evs[3] = Integer.parseInt(matcher_bs.group(4));
                            } else {
                                evs[3] = 0;
                            }
                            if(matcher_bs.group(5)!=null){
                                evs[4] = Integer.parseInt(matcher_bs.group(5));
                            } else {
                                evs[4] = 0;
                            }
                            if(matcher_bs.group(6)!=null){
                                evs[5] = Integer.parseInt(matcher_bs.group(6));
                            } else {
                                evs[5] = 0;
                            }
                        }
                        pastPokemon1.setEvs(evs);
                    }else if(nb_poke==2){
                        matcher_bs = Pattern.compile("\\D*(\\d*) HP|\\D*(\\d*) Atk|\\D*(\\d*) Def|\\D*(\\d*) SpA|\\D*(\\d*) SpD|\\D*(\\d*) Spe").matcher(matcher.group(5));
                        if(matcher_bs.find()){
                            if(matcher_bs.group(1)!=null){
                                evs[0] = Integer.parseInt(matcher_bs.group(1));
                            } else {
                                evs[0] = 0;
                            }
                            if(matcher_bs.group(2)!=null){
                                evs[1] = Integer.parseInt(matcher_bs.group(2));
                            } else {
                                evs[1] = 0;
                            }
                            if(matcher_bs.group(3)!=null){
                                evs[2] = Integer.parseInt(matcher_bs.group(3));
                            } else {
                                evs[2] = 0;
                            }
                            if(matcher_bs.group(4)!=null){
                                evs[3] = Integer.parseInt(matcher_bs.group(4));
                            } else {
                                evs[3] = 0;
                            }
                            if(matcher_bs.group(5)!=null){
                                evs[4] = Integer.parseInt(matcher_bs.group(5));
                            } else {
                                evs[4] = 0;
                            }
                            if(matcher_bs.group(6)!=null){
                                evs[5] = Integer.parseInt(matcher_bs.group(6));
                            } else {
                                evs[5] = 0;
                            }
                        }
                        pastPokemon2.setEvs(evs);
                    }else if(nb_poke==3){
                        matcher_bs = Pattern.compile("\\D*(\\d*) HP|\\D*(\\d*) Atk|\\D*(\\d*) Def|\\D*(\\d*) SpA|\\D*(\\d*) SpD|\\D*(\\d*) Spe").matcher(matcher.group(5));
                        if(matcher_bs.find()){
                            if(matcher_bs.group(1)!=null){
                                evs[0] = Integer.parseInt(matcher_bs.group(1));
                            } else {
                                evs[0] = 0;
                            }
                            if(matcher_bs.group(2)!=null){
                                evs[1] = Integer.parseInt(matcher_bs.group(2));
                            } else {
                                evs[1] = 0;
                            }
                            if(matcher_bs.group(3)!=null){
                                evs[2] = Integer.parseInt(matcher_bs.group(3));
                            } else {
                                evs[2] = 0;
                            }
                            if(matcher_bs.group(4)!=null){
                                evs[3] = Integer.parseInt(matcher_bs.group(4));
                            } else {
                                evs[3] = 0;
                            }
                            if(matcher_bs.group(5)!=null){
                                evs[4] = Integer.parseInt(matcher_bs.group(5));
                            } else {
                                evs[4] = 0;
                            }
                            if(matcher_bs.group(6)!=null){
                                evs[5] = Integer.parseInt(matcher_bs.group(6));
                            } else {
                                evs[5] = 0;
                            }
                        }
                        pastPokemon3.setEvs(evs);
                    }else if(nb_poke==4){
                        matcher_bs = Pattern.compile("\\D*(\\d*) HP|\\D*(\\d*) Atk|\\D*(\\d*) Def|\\D*(\\d*) SpA|\\D*(\\d*) SpD|\\D*(\\d*) Spe").matcher(matcher.group(5));
                        if(matcher_bs.find()){
                            if(matcher_bs.group(1)!=null){
                                evs[0] = Integer.parseInt(matcher_bs.group(1));
                            } else {
                                evs[0] = 0;
                            }
                            if(matcher_bs.group(2)!=null){
                                evs[1] = Integer.parseInt(matcher_bs.group(2));
                            } else {
                                evs[1] = 0;
                            }
                            if(matcher_bs.group(3)!=null){
                                evs[2] = Integer.parseInt(matcher_bs.group(3));
                            } else {
                                evs[2] = 0;
                            }
                            if(matcher_bs.group(4)!=null){
                                evs[3] = Integer.parseInt(matcher_bs.group(4));
                            } else {
                                evs[3] = 0;
                            }
                            if(matcher_bs.group(5)!=null){
                                evs[4] = Integer.parseInt(matcher_bs.group(5));
                            } else {
                                evs[4] = 0;
                            }
                            if(matcher_bs.group(6)!=null){
                                evs[5] = Integer.parseInt(matcher_bs.group(6));
                            } else {
                                evs[5] = 0;
                            }
                        }
                        pastPokemon4.setEvs(evs);
                    }else if(nb_poke==5){
                        matcher_bs = Pattern.compile("\\D*(\\d*) HP|\\D*(\\d*) Atk|\\D*(\\d*) Def|\\D*(\\d*) SpA|\\D*(\\d*) SpD|\\D*(\\d*) Spe").matcher(matcher.group(5));
                        if(matcher_bs.find()){
                            if(matcher_bs.group(1)!=null){
                                evs[0] = Integer.parseInt(matcher_bs.group(1));
                            } else {
                                evs[0] = 0;
                            }
                            if(matcher_bs.group(2)!=null){
                                evs[1] = Integer.parseInt(matcher_bs.group(2));
                            } else {
                                evs[1] = 0;
                            }
                            if(matcher_bs.group(3)!=null){
                                evs[2] = Integer.parseInt(matcher_bs.group(3));
                            } else {
                                evs[2] = 0;
                            }
                            if(matcher_bs.group(4)!=null){
                                evs[3] = Integer.parseInt(matcher_bs.group(4));
                            } else {
                                evs[3] = 0;
                            }
                            if(matcher_bs.group(5)!=null){
                                evs[4] = Integer.parseInt(matcher_bs.group(5));
                            } else {
                                evs[4] = 0;
                            }
                            if(matcher_bs.group(6)!=null){
                                evs[5] = Integer.parseInt(matcher_bs.group(6));
                            } else {
                                evs[5] = 0;
                            }
                        }
                        pastPokemon5.setEvs(evs);
                    }else if(nb_poke==6){
                        matcher_bs = Pattern.compile("\\D*(\\d*) HP|\\D*(\\d*) Atk|\\D*(\\d*) Def|\\D*(\\d*) SpA|\\D*(\\d*) SpD|\\D*(\\d*) Spe").matcher(matcher.group(5));
                        if(matcher_bs.find()){
                            if(matcher_bs.group(1)!=null){
                                evs[0] = Integer.parseInt(matcher_bs.group(1));
                            } else {
                                evs[0] = 0;
                            }
                            if(matcher_bs.group(2)!=null){
                                evs[1] = Integer.parseInt(matcher_bs.group(2));
                            } else {
                                evs[1] = 0;
                            }
                            if(matcher_bs.group(3)!=null){
                                evs[2] = Integer.parseInt(matcher_bs.group(3));
                            } else {
                                evs[2] = 0;
                            }
                            if(matcher_bs.group(4)!=null){
                                evs[3] = Integer.parseInt(matcher_bs.group(4));
                            } else {
                                evs[3] = 0;
                            }
                            if(matcher_bs.group(5)!=null){
                                evs[4] = Integer.parseInt(matcher_bs.group(5));
                            } else {
                                evs[4] = 0;
                            }
                            if(matcher_bs.group(6)!=null){
                                evs[5] = Integer.parseInt(matcher_bs.group(6));
                            } else {
                                evs[5] = 0;
                            }
                        }
                        pastPokemon6.setEvs(evs);
                    }
                }

                if(matcher.group(6)!=null){
                    if(nb_poke==1){
                        pastPokemon1.setNature(matcher.group(6));
                    }else if(nb_poke==2){
                        pastPokemon2.setNature(matcher.group(6));
                    }else if(nb_poke==3){
                        pastPokemon3.setNature(matcher.group(6));
                    }else if(nb_poke==4){
                        pastPokemon4.setNature(matcher.group(6));
                    }else if(nb_poke==5){
                        pastPokemon5.setNature(matcher.group(6));
                    }else if(nb_poke==6){
                        pastPokemon6.setNature(matcher.group(6));
                    }
                }

                if(matcher.group(7)!=null){
                    if(nb_poke==1){
                        matcher_bs = Pattern.compile("\\D*(\\d*) HP|\\D*(\\d*) Atk|\\D*(\\d*) Def|\\D*(\\d*) SpA|\\D*(\\d*) SpD|\\D*(\\d*) Spe").matcher(matcher.group(7));
                        if(matcher_bs.find()){
                            if(matcher_bs.group(1)!=null){
                                ivs[0] = Integer.parseInt(matcher_bs.group(1));
                            } else {
                                ivs[0] = 31;
                            }
                            if(matcher_bs.group(2)!=null){
                                ivs[1] = Integer.parseInt(matcher_bs.group(2));
                            } else {
                                ivs[1] = 31;
                            }
                            if(matcher_bs.group(3)!=null){
                                ivs[2] = Integer.parseInt(matcher_bs.group(3));
                            } else {
                                ivs[2] = 31;
                            }
                            if(matcher_bs.group(4)!=null){
                                ivs[3] = Integer.parseInt(matcher_bs.group(4));
                            } else {
                                ivs[3] = 31;
                            }
                            if(matcher_bs.group(5)!=null){
                                ivs[4] = Integer.parseInt(matcher_bs.group(5));
                            } else {
                                ivs[4] = 31;
                            }
                            if(matcher_bs.group(6)!=null){
                                ivs[5] = Integer.parseInt(matcher_bs.group(6));
                            } else {
                                ivs[5] = 31;
                            }
                        }
                        pastPokemon1.setIvs(ivs);
                    }else if(nb_poke==2){
                        matcher_bs = Pattern.compile("\\D*(\\d*) HP|\\D*(\\d*) Atk|\\D*(\\d*) Def|\\D*(\\d*) SpA|\\D*(\\d*) SpD|\\D*(\\d*) Spe").matcher(matcher.group(7));
                        if(matcher_bs.find()){
                            if(matcher_bs.group(1)!=null){
                                ivs[0] = Integer.parseInt(matcher_bs.group(1));
                            } else {
                                ivs[0] = 31;
                            }
                            if(matcher_bs.group(2)!=null){
                                ivs[1] = Integer.parseInt(matcher_bs.group(2));
                            } else {
                                ivs[1] = 31;
                            }
                            if(matcher_bs.group(3)!=null){
                                ivs[2] = Integer.parseInt(matcher_bs.group(3));
                            } else {
                                ivs[2] = 31;
                            }
                            if(matcher_bs.group(4)!=null){
                                ivs[3] = Integer.parseInt(matcher_bs.group(4));
                            } else {
                                ivs[3] = 31;
                            }
                            if(matcher_bs.group(5)!=null){
                                ivs[4] = Integer.parseInt(matcher_bs.group(5));
                            } else {
                                ivs[4] = 31;
                            }
                            if(matcher_bs.group(6)!=null){
                                ivs[5] = Integer.parseInt(matcher_bs.group(6));
                            } else {
                                ivs[5] = 31;
                            }
                        }
                        pastPokemon2.setIvs(ivs);
                    }else if(nb_poke==3){
                        matcher_bs = Pattern.compile("\\D*(\\d*) HP|\\D*(\\d*) Atk|\\D*(\\d*) Def|\\D*(\\d*) SpA|\\D*(\\d*) SpD|\\D*(\\d*) Spe").matcher(matcher.group(7));
                        if(matcher_bs.find()){
                            if(matcher_bs.group(1)!=null){
                                ivs[0] = Integer.parseInt(matcher_bs.group(1));
                            } else {
                                ivs[0] = 31;
                            }
                            if(matcher_bs.group(2)!=null){
                                ivs[1] = Integer.parseInt(matcher_bs.group(2));
                            } else {
                                ivs[1] = 31;
                            }
                            if(matcher_bs.group(3)!=null){
                                ivs[2] = Integer.parseInt(matcher_bs.group(3));
                            } else {
                                ivs[2] = 31;
                            }
                            if(matcher_bs.group(4)!=null){
                                ivs[3] = Integer.parseInt(matcher_bs.group(4));
                            } else {
                                ivs[3] = 31;
                            }
                            if(matcher_bs.group(5)!=null){
                                ivs[4] = Integer.parseInt(matcher_bs.group(5));
                            } else {
                                ivs[4] = 31;
                            }
                            if(matcher_bs.group(6)!=null){
                                ivs[5] = Integer.parseInt(matcher_bs.group(6));
                            } else {
                                ivs[5] = 31;
                            }
                        }
                        pastPokemon3.setIvs(ivs);
                    }else if(nb_poke==4){
                        matcher_bs = Pattern.compile("\\D*(\\d*) HP|\\D*(\\d*) Atk|\\D*(\\d*) Def|\\D*(\\d*) SpA|\\D*(\\d*) SpD|\\D*(\\d*) Spe").matcher(matcher.group(7));
                        if(matcher_bs.find()){
                            if(matcher_bs.group(1)!=null){
                                ivs[0] = Integer.parseInt(matcher_bs.group(1));
                            } else {
                                ivs[0] = 31;
                            }
                            if(matcher_bs.group(2)!=null){
                                ivs[1] = Integer.parseInt(matcher_bs.group(2));
                            } else {
                                ivs[1] = 31;
                            }
                            if(matcher_bs.group(3)!=null){
                                ivs[2] = Integer.parseInt(matcher_bs.group(3));
                            } else {
                                ivs[2] = 31;
                            }
                            if(matcher_bs.group(4)!=null){
                                ivs[3] = Integer.parseInt(matcher_bs.group(4));
                            } else {
                                ivs[3] = 31;
                            }
                            if(matcher_bs.group(5)!=null){
                                ivs[4] = Integer.parseInt(matcher_bs.group(5));
                            } else {
                                ivs[4] = 31;
                            }
                            if(matcher_bs.group(6)!=null){
                                ivs[5] = Integer.parseInt(matcher_bs.group(6));
                            } else {
                                ivs[5] = 31;
                            }
                        }
                        pastPokemon4.setIvs(ivs);
                    }else if(nb_poke==5){
                        matcher_bs = Pattern.compile("\\D*(\\d*) HP|\\D*(\\d*) Atk|\\D*(\\d*) Def|\\D*(\\d*) SpA|\\D*(\\d*) SpD|\\D*(\\d*) Spe").matcher(matcher.group(7));
                        if(matcher_bs.find()){
                            if(matcher_bs.group(1)!=null){
                                ivs[0] = Integer.parseInt(matcher_bs.group(1));
                            } else {
                                ivs[0] = 31;
                            }
                            if(matcher_bs.group(2)!=null){
                                ivs[1] = Integer.parseInt(matcher_bs.group(2));
                            } else {
                                ivs[1] = 31;
                            }
                            if(matcher_bs.group(3)!=null){
                                ivs[2] = Integer.parseInt(matcher_bs.group(3));
                            } else {
                                ivs[2] = 31;
                            }
                            if(matcher_bs.group(4)!=null){
                                ivs[3] = Integer.parseInt(matcher_bs.group(4));
                            } else {
                                ivs[3] = 31;
                            }
                            if(matcher_bs.group(5)!=null){
                                ivs[4] = Integer.parseInt(matcher_bs.group(5));
                            } else {
                                ivs[4] = 31;
                            }
                            if(matcher_bs.group(6)!=null){
                                ivs[5] = Integer.parseInt(matcher_bs.group(6));
                            } else {
                                ivs[5] = 31;
                            }
                        }
                        pastPokemon5.setIvs(ivs);
                    }else if(nb_poke==6){
                        matcher_bs = Pattern.compile("\\D*(\\d*) HP|\\D*(\\d*) Atk|\\D*(\\d*) Def|\\D*(\\d*) SpA|\\D*(\\d*) SpD|\\D*(\\d*) Spe").matcher(matcher.group(7));
                        if(matcher_bs.find()){
                            if(matcher_bs.group(1)!=null){
                                ivs[0] = Integer.parseInt(matcher_bs.group(1));
                            } else {
                                ivs[0] = 31;
                            }
                            if(matcher_bs.group(2)!=null){
                                ivs[1] = Integer.parseInt(matcher_bs.group(2));
                            } else {
                                ivs[1] = 31;
                            }
                            if(matcher_bs.group(3)!=null){
                                ivs[2] = Integer.parseInt(matcher_bs.group(3));
                            } else {
                                ivs[2] = 31;
                            }
                            if(matcher_bs.group(4)!=null){
                                ivs[3] = Integer.parseInt(matcher_bs.group(4));
                            } else {
                                ivs[3] = 31;
                            }
                            if(matcher_bs.group(5)!=null){
                                ivs[4] = Integer.parseInt(matcher_bs.group(5));
                            } else {
                                ivs[4] = 31;
                            }
                            if(matcher_bs.group(6)!=null){
                                ivs[5] = Integer.parseInt(matcher_bs.group(6));
                            } else {
                                ivs[5] = 31;
                            }
                        }
                        pastPokemon6.setIvs(ivs);
                    }
                }

                if(matcher.group(8)!=null){
                    if(nb_poke==1){
                        moves[nb_move-1] = matcher.group(8);
                        nb_move++;
                        if(nb_move==5){
                            pastPokemon1.setMoves(moves);
                            nb_move = 1;
                        }
                    }else if(nb_poke==2){
                        moves[nb_move-1] = matcher.group(8);
                        nb_move++;
                        if(nb_move==5){
                            pastPokemon1.setMoves(moves);
                            nb_move = 1;
                        }
                    }else if(nb_poke==3){
                        moves[nb_move-1] = matcher.group(8);
                        nb_move++;
                        if(nb_move==5){
                            pastPokemon1.setMoves(moves);
                            nb_move = 1;
                        }
                    }else if(nb_poke==4){
                        moves[nb_move-1] = matcher.group(8);
                        nb_move++;
                        if(nb_move==5){
                            pastPokemon1.setMoves(moves);
                            nb_move = 1;
                        }
                    }else if(nb_poke==5){
                        moves[nb_move-1] = matcher.group(8);
                        nb_move++;
                        if(nb_move==5){
                            pastPokemon1.setMoves(moves);
                            nb_move = 1;
                        }
                    }else if(nb_poke==6){
                        moves[nb_move-1] = matcher.group(8);
                        nb_move++;
                        if(nb_move==5){
                            pastPokemon1.setMoves(moves);
                            nb_move = 1;
                        }
                    }
                }

            }
            if(!st.contains(" ")) {
                nb_poke++;
            }
        }

        teamList.add(pastPokemon1);
        teamList.add(pastPokemon2);
        teamList.add(pastPokemon3);
        teamList.add(pastPokemon4);
        teamList.add(pastPokemon5);
        teamList.add(pastPokemon6);

        return teamList;
    }

    public static int calcPV(int bs, int level, int ev, int iv){
        int pv = (( iv + 2 * bs + (ev / 4) ) * level / 100 ) + level + 10;
        return pv;
    }

    public static int calcStat(int bs, int level, int ev, int iv, int nature){
        int stat = (( iv + 2 * bs + (ev / 4) ) * level / 100 ) + 5;
        if (nature==1)
            stat += stat*0.1;
        else if (nature==-1)
            stat-= stat*0.1;

        return stat;
    }

    public static int[] calcNature(String nature){
        int[] bonus = new int[5];
        nature = nature.toLowerCase(Locale.ROOT);
        switch (nature){
            case "bold":
                bonus = new int[]{-1, 1, 0, 0, 0};
                break;
            case "quirky":
            case "serious":
            case "bashful":
            case "hardy":
            case "docile":
                bonus = new int[]{0, 0, 0, 0, 0};
                break;
            case "brave":
                bonus = new int[]{1, 0, 0, 0, -1};
                break;
            case "calm":
                bonus = new int[]{-1, 0, 0, 1, 0};
                break;
            case "quiet":
                bonus = new int[]{0, 0, 1, 0, -1};
                break;
            case "mild":
                bonus = new int[]{0, -1, 1, 0, 0};
                break;
            case "rash":
                bonus = new int[]{0, 0, 1, -1, 0};
                break;
            case "gentle":
                bonus = new int[]{0, -1, 0, 1, 0};
                break;
            case "jolly":
                bonus = new int[]{0, 0, -1, 0, 1};
                break;
            case "lax":
                bonus = new int[]{0, 1, 0, -1, 0};
                break;
            case "impish":
                bonus = new int[]{0, 1, -1, 0, 0};
                break;
            case "sassy":
                bonus = new int[]{0, 0, 0, 1, -1};
                break;
            case "naughty":
                bonus = new int[]{1, 0, 0, -1, 0};
                break;
            case "modest":
                bonus = new int[]{-1, 0, 1, 0, 0};
                break;
            case "naive":
                bonus = new int[]{0, 0, 0, -1, 1};
                break;
            case "hasty":
                bonus = new int[]{0, -1, 0, 0, 1};
                break;
            case "careful":
                bonus = new int[]{0, 0, -1, 1, 0};
                break;
            case "relaxed":
                bonus = new int[]{0, 1, 0, 0, -1};
                break;
            case "adamant":
                bonus = new int[]{1, 0, -1, 0, 0};
                break;
            case "lonely":
                bonus = new int[]{1, -1, 0, 0, 0};
                break;
            case "timid":
                bonus = new int[]{-1, 0, 0, 0, 1};
                break;

            default:
                bonus = new int[]{0,0,0,0,0};
        }

        return bonus;
    }

    public static void main(String[] args) throws IOException {

        ArrayList<PastPokemon> teamPaste = readFile();
//
//        PastPokemon pastPokemon1 = new PastPokemon();
//
//        pastPokemon1.setName("Kyogre");
//        pastPokemon1.setItem("Mystic Water");
//        pastPokemon1.setAbility("Drizzle");
//        pastPokemon1.setLevel(50);
//        pastPokemon1.setEvs(new int[]{108, 0, 52, 116, 4, 228});
//        pastPokemon1.setIvs(new int[]{31,0,31,31,31,31});
//        pastPokemon1.setNature("Modest");
//        pastPokemon1.setMoves(new String[]{"Water Spout", "Origin Pulse", "Ice Beam", "Protect"});
//
        SheetPokemon sheetPokemon1 = new SheetPokemon();
        sheetPokemon1.setName(teamPaste.get(0).getName());
        sheetPokemon1.setAbility(teamPaste.get(0).getAbility());
        sheetPokemon1.setGmax(false);
        sheetPokemon1.setItem(teamPaste.get(0).getItem());
        sheetPokemon1.setMoves(teamPaste.get(0).getMoves());
        sheetPokemon1.setLevel(teamPaste.get(0).getLevel());
        sheetPokemon1.setStats(new int[] {calcPV(kyogreBS[0], teamPaste.get(0).getLevel(), teamPaste.get(0).getEvs()[0], teamPaste.get(0).getIvs()[0]),
                calcStat(kyogreBS[1], teamPaste.get(0).getLevel(), teamPaste.get(0).getEvs()[1], teamPaste.get(0).getIvs()[1],calcNature(teamPaste.get(0).getNature())[0]),
                calcStat(kyogreBS[2], teamPaste.get(0).getLevel(), teamPaste.get(0).getEvs()[2], teamPaste.get(0).getIvs()[2],calcNature(teamPaste.get(0).getNature())[1]),
                calcStat(kyogreBS[3], teamPaste.get(0).getLevel(), teamPaste.get(0).getEvs()[3], teamPaste.get(0).getIvs()[3],calcNature(teamPaste.get(0).getNature())[2]),
                calcStat(kyogreBS[4], teamPaste.get(0).getLevel(), teamPaste.get(0).getEvs()[4], teamPaste.get(0).getIvs()[4],calcNature(teamPaste.get(0).getNature())[3]),
                calcStat(kyogreBS[5], teamPaste.get(0).getLevel(), teamPaste.get(0).getEvs()[5], teamPaste.get(0).getIvs()[5],calcNature(teamPaste.get(0).getNature())[4])});

        System.out.println("Name : " + sheetPokemon1.getName());
        System.out.println("Item : " + sheetPokemon1.getItem());
        System.out.println("Gigamax : " + sheetPokemon1.getGmax());
        System.out.println("Ability : " + sheetPokemon1.getAbility());
        System.out.println("Level : " + sheetPokemon1.getLevel());
        System.out.println("PV : " + sheetPokemon1.getStats()[0]);
        System.out.println("Atk : " + sheetPokemon1.getStats()[1]);
        System.out.println("Def : " + sheetPokemon1.getStats()[2]);
        System.out.println("AtkSpe : " + sheetPokemon1.getStats()[3]);
        System.out.println("DefSpe : " + sheetPokemon1.getStats()[4]);
        System.out.println("Vit : " + sheetPokemon1.getStats()[5]);
        System.out.println("Move 1 : " + sheetPokemon1.getMoves()[0]);
        System.out.println("Move 2 : " + sheetPokemon1.getMoves()[1]);
        System.out.println("Move 3 : " + sheetPokemon1.getMoves()[2]);
        System.out.println("Move 4 : " + sheetPokemon1.getMoves()[3]);

        System.out.println("-----------------------------------------------------------------------------------");
//
//        PastPokemon pastPokemon2 = new PastPokemon();
//
//        pastPokemon2.setName("Zacian-Crowned");
//        pastPokemon2.setItem("Rusted Sword");
//        pastPokemon2.setAbility("Intrepid Sword");
//        pastPokemon2.setLevel(50);
//        pastPokemon2.setEvs(new int[]{252, 76, 4, 0, 36, 140});
//        pastPokemon2.setIvs(new int[]{31,31,31,31,31,31});
//        pastPokemon2.setNature("Adamant");
//        pastPokemon2.setMoves(new String[]{"Behemoth Blade", "Play Rough", "Sacred Sword", "Protect"});
//
        SheetPokemon sheetPokemon2 = new SheetPokemon();

        sheetPokemon2.setName(teamPaste.get(1).getName());
        sheetPokemon2.setAbility(teamPaste.get(1).getAbility());
        sheetPokemon2.setGmax(false);
        sheetPokemon2.setItem(teamPaste.get(1).getItem());
        sheetPokemon2.setMoves(teamPaste.get(1).getMoves());
        sheetPokemon2.setLevel(teamPaste.get(1).getLevel());
        sheetPokemon2.setStats(new int[] {calcPV(zacianBS[0], teamPaste.get(1).getLevel(), teamPaste.get(1).getEvs()[0], teamPaste.get(1).getIvs()[0]),
                calcStat(zacianBS[1], teamPaste.get(1).getLevel(), teamPaste.get(1).getEvs()[1], teamPaste.get(1).getIvs()[1],calcNature(teamPaste.get(1).getNature())[0]),
                calcStat(zacianBS[2], teamPaste.get(1).getLevel(), teamPaste.get(1).getEvs()[2], teamPaste.get(1).getIvs()[2],calcNature(teamPaste.get(1).getNature())[1]),
                calcStat(zacianBS[3], teamPaste.get(1).getLevel(), teamPaste.get(1).getEvs()[3], teamPaste.get(1).getIvs()[3],calcNature(teamPaste.get(1).getNature())[2]),
                calcStat(zacianBS[4], teamPaste.get(1).getLevel(), teamPaste.get(1).getEvs()[4], teamPaste.get(1).getIvs()[4],calcNature(teamPaste.get(1).getNature())[3]),
                calcStat(zacianBS[5], teamPaste.get(1).getLevel(), teamPaste.get(1).getEvs()[5], teamPaste.get(1).getIvs()[5],calcNature(teamPaste.get(1).getNature())[4])});



        System.out.println("Name : " + sheetPokemon2.getName());
        System.out.println("Item : " + sheetPokemon2.getItem());
        System.out.println("Gigamax : " + sheetPokemon2.getGmax());
        System.out.println("Ability : " + sheetPokemon2.getAbility());
        System.out.println("Level : " + sheetPokemon2.getLevel());
        System.out.println("PV : " + sheetPokemon2.getStats()[0]);
        System.out.println("Atk : " + sheetPokemon2.getStats()[1]);
        System.out.println("Def : " + sheetPokemon2.getStats()[2]);
        System.out.println("AtkSpe : " + sheetPokemon2.getStats()[3]);
        System.out.println("DefSpe : " + sheetPokemon2.getStats()[4]);
        System.out.println("Vit : " + sheetPokemon2.getStats()[5]);
        System.out.println("Move 1 : " + sheetPokemon2.getMoves()[0]);
        System.out.println("Move 2 : " + sheetPokemon2.getMoves()[1]);
        System.out.println("Move 3 : " + sheetPokemon2.getMoves()[2]);
        System.out.println("Move 4 : " + sheetPokemon2.getMoves()[3]);

    }


}
