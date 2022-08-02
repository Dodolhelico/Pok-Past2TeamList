import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CreateTeamList {

private static int[] kyogreBS = {100,100,90,150,140,90};
private static int[] zacianBS = {92,170,115,80,115,148};
private static int[] tornadusBS = {79,115,70,125,80,111};
private static int[] kartanaBS = {59,181,131,59,31,109};
private static int[] landorus_tBS = {89,145,90,105,80,91};
private static int[] amoongusBS = {114,85,70,85,80,30};

static final Pattern p1 = Pattern.compile("(.*)\\s@\\s(.*\\w)|Ability: (.*\\w)|Level: (.*\\w)|EVs: (.*\\w)|(.*\\w) Nature|IVs: (.*\\w)|- (.*\\w)|Gigantamax: (.*\\w)");
static final Pattern p2 = Pattern.compile("((\\d*) HP)?( / )?((\\d*) Atk)?( / )?((\\d*) Def)?( / )?((\\d*) SpA)?( / )?((\\d*) SpD)?( / )?((\\d*) Spe)?( / )?");

public static ArrayList<PastPokemon> readFile() throws IOException {
    ArrayList<PastPokemon> pokemonList = new ArrayList<PastPokemon>();

    File file = new File("C:\\Users\\hippo\\Documents\\teampaste.txt");
    BufferedReader br = new BufferedReader(new FileReader(file));

    String st;

    StringBuilder pasteIntoString = new StringBuilder();

    while ((st=br.readLine())!=null){
        pasteIntoString.append(st).append("\n");
    }
    String[] splitString = pasteIntoString.toString().split("\n\n");

    for (String s : splitString) {
        PastPokemon pokemon = new PastPokemon();
        pokemon.setIvs(new int[]{31, 31, 31, 31, 31, 31});
        pokemon.setEvs(new int[]{0, 0, 0, 0, 0, 0});
        pokemon.setMoves(new String[]{"", "", "", ""});
        pokemon.setLevel(100);
        pokemon.setGmax(false);

        String[] splitsplitString = s.split("\n");
        for (String str : splitsplitString) {
            Matcher matcher = p1.matcher(str);

            if (matcher.find()) {
                if (matcher.group(1) != null) {
                    pokemon.setName(matcher.group(1));
                }

                if (matcher.group(2) != null) {
                    pokemon.setItem(matcher.group(2));
                }

                if (matcher.group(3) != null) {
                    pokemon.setAbility(matcher.group(3));
                }

                if (matcher.group(4) != null) {
                    pokemon.setLevel(Integer.parseInt(matcher.group(4)));
                }

                if (matcher.group(5) != null) {
                    statsFromEVs(pokemon, pokemon.getEvs(), p2.matcher(matcher.group(5)));
                }

                if (matcher.group(6) != null) {
                    pokemon.setNature(matcher.group(6));
                }

                if (matcher.group(7) != null) {
                    statsFromIVs(pokemon, pokemon.getIvs(), p2.matcher(matcher.group(7)));
                }

                if (matcher.group(8) != null) {
                    checkMoves(pokemon, pokemon.getMoves(), matcher.group(8));
                }

                if (matcher.group(9) != null) {
                    pokemon.setGmax(matcher.group(9).contains("Yes"));
                }
            }
        }

        moveCount = 0;
        pokemonList.add(pokemon);
    }

    return pokemonList;
}
private static void statsFromIVs(PastPokemon pastPokemon1, int[] ivs, Matcher matcher_bs) {
    if(matcher_bs.find()){
        if(matcher_bs.group(2)!=null) {
            ivs[0] = Integer.parseInt(matcher_bs.group(2));
        }
        if(matcher_bs.group(5)!=null){
            ivs[1] = Integer.parseInt(matcher_bs.group(5));
        }
        if(matcher_bs.group(8)!=null){
            ivs[2] = Integer.parseInt(matcher_bs.group(8));
        }
        if(matcher_bs.group(11)!=null){
            ivs[3] = Integer.parseInt(matcher_bs.group(11));
        }
        if(matcher_bs.group(14)!=null){
            ivs[4] = Integer.parseInt(matcher_bs.group(14));
        }
        if(matcher_bs.group(17)!=null){
            ivs[5] = Integer.parseInt(matcher_bs.group(17));
        }
    }
    pastPokemon1.setIvs(ivs.clone());
}

private static void statsFromEVs(PastPokemon pastPokemon1, int[] evs, Matcher matcher_bs) {

    if(matcher_bs.find()){
        if(matcher_bs.group(2)!=null){
            evs[0] = Integer.parseInt(matcher_bs.group(2));
        }
        if(matcher_bs.group(5)!=null){
            evs[1] = Integer.parseInt(matcher_bs.group(5));
        }
        if(matcher_bs.group(8)!=null){
            evs[2] = Integer.parseInt(matcher_bs.group(8));
        }
        if(matcher_bs.group(11)!=null){
            evs[3] = Integer.parseInt(matcher_bs.group(11));
        }
        if(matcher_bs.group(14)!=null){
            evs[4] = Integer.parseInt(matcher_bs.group(14));
        }
        if(matcher_bs.group(17)!=null){
            evs[5] = Integer.parseInt(matcher_bs.group(17));
        }
    }
    pastPokemon1.setEvs(evs.clone());
}

static int moveCount = 0;

private static void checkMoves(PastPokemon pastPokemon1, String[] moves, String move){
        moves[moveCount] = move;
        moveCount++;
        pastPokemon1.setMoves(moves.clone());
}

public static int calcPV(int bs, int level, int ev, int iv){
    return (( iv + 2 * bs + (ev / 4) ) * level / 100 ) + level + 10;
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
    int[] bonus;
    nature = nature.toLowerCase(Locale.ROOT);
    bonus = switch (nature) {
        case "bold" -> new int[]{-1, 1, 0, 0, 0};
        case "brave" -> new int[]{1, 0, 0, 0, -1};
        case "calm" -> new int[]{-1, 0, 0, 1, 0};
        case "quiet" -> new int[]{0, 0, 1, 0, -1};
        case "mild" -> new int[]{0, -1, 1, 0, 0};
        case "rash" -> new int[]{0, 0, 1, -1, 0};
        case "gentle" -> new int[]{0, -1, 0, 1, 0};
        case "jolly" -> new int[]{0, 0, -1, 0, 1};
        case "lax" -> new int[]{0, 1, 0, -1, 0};
        case "impish" -> new int[]{0, 1, -1, 0, 0};
        case "sassy" -> new int[]{0, 0, 0, 1, -1};
        case "naughty" -> new int[]{1, 0, 0, -1, 0};
        case "modest" -> new int[]{-1, 0, 1, 0, 0};
        case "naive" -> new int[]{0, 0, 0, -1, 1};
        case "hasty" -> new int[]{0, -1, 0, 0, 1};
        case "careful" -> new int[]{0, 0, -1, 1, 0};
        case "relaxed" -> new int[]{0, 1, 0, 0, -1};
        case "adamant" -> new int[]{1, 0, -1, 0, 0};
        case "lonely" -> new int[]{1, -1, 0, 0, 0};
        case "timid" -> new int[]{-1, 0, 0, 0, 1};
        default -> new int[]{0, 0, 0, 0, 0};
    };

    return bonus;
}

public static void main(String[] args) throws IOException {

    ArrayList<PastPokemon> teamPaste = readFile();

    SheetPokemon sheetPokemon1 = new SheetPokemon();
    sheetPokemon1.setName(teamPaste.get(0).getName());
    sheetPokemon1.setAbility(teamPaste.get(0).getAbility());
    sheetPokemon1.setGmax(teamPaste.get(0).isGmax());
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

    SheetPokemon sheetPokemon2 = new SheetPokemon();

    sheetPokemon2.setName(teamPaste.get(1).getName());
    sheetPokemon2.setAbility(teamPaste.get(1).getAbility());
    sheetPokemon2.setGmax(teamPaste.get(1).isGmax());
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

    System.out.println("-----------------------------------------------------------------------------------");

    SheetPokemon sheetPokemon3 = new SheetPokemon();

    sheetPokemon3.setName(teamPaste.get(2).getName());
    sheetPokemon3.setAbility(teamPaste.get(2).getAbility());
    sheetPokemon3.setGmax(teamPaste.get(2).isGmax());
    sheetPokemon3.setItem(teamPaste.get(2).getItem());
    sheetPokemon3.setMoves(teamPaste.get(2).getMoves());
    sheetPokemon3.setLevel(teamPaste.get(2).getLevel());
    sheetPokemon3.setStats(new int[] {calcPV(tornadusBS[0], teamPaste.get(2).getLevel(), teamPaste.get(2).getEvs()[0], teamPaste.get(2).getIvs()[0]),
            calcStat(tornadusBS[1], teamPaste.get(2).getLevel(), teamPaste.get(2).getEvs()[1], teamPaste.get(2).getIvs()[1],calcNature(teamPaste.get(2).getNature())[0]),
            calcStat(tornadusBS[2], teamPaste.get(2).getLevel(), teamPaste.get(2).getEvs()[2], teamPaste.get(2).getIvs()[2],calcNature(teamPaste.get(2).getNature())[1]),
            calcStat(tornadusBS[3], teamPaste.get(2).getLevel(), teamPaste.get(2).getEvs()[3], teamPaste.get(2).getIvs()[3],calcNature(teamPaste.get(2).getNature())[2]),
            calcStat(tornadusBS[4], teamPaste.get(2).getLevel(), teamPaste.get(2).getEvs()[4], teamPaste.get(2).getIvs()[4],calcNature(teamPaste.get(2).getNature())[3]),
            calcStat(tornadusBS[5], teamPaste.get(2).getLevel(), teamPaste.get(2).getEvs()[5], teamPaste.get(2).getIvs()[5],calcNature(teamPaste.get(2).getNature())[4])});



    System.out.println("Name : " + sheetPokemon3.getName());
    System.out.println("Item : " + sheetPokemon3.getItem());
    System.out.println("Gigamax : " + sheetPokemon3.getGmax());
    System.out.println("Ability : " + sheetPokemon3.getAbility());
    System.out.println("Level : " + sheetPokemon3.getLevel());
    System.out.println("PV : " + sheetPokemon3.getStats()[0]);
    System.out.println("Atk : " + sheetPokemon3.getStats()[1]);
    System.out.println("Def : " + sheetPokemon3.getStats()[2]);
    System.out.println("AtkSpe : " + sheetPokemon3.getStats()[3]);
    System.out.println("DefSpe : " + sheetPokemon3.getStats()[4]);
    System.out.println("Vit : " + sheetPokemon3.getStats()[5]);
    System.out.println("Move 1 : " + sheetPokemon3.getMoves()[0]);
    System.out.println("Move 2 : " + sheetPokemon3.getMoves()[1]);
    System.out.println("Move 3 : " + sheetPokemon3.getMoves()[2]);
    System.out.println("Move 4 : " + sheetPokemon3.getMoves()[3]);

    System.out.println("-----------------------------------------------------------------------------------");

    SheetPokemon sheetPokemon4 = new SheetPokemon();

    sheetPokemon4.setName(teamPaste.get(3).getName());
    sheetPokemon4.setAbility(teamPaste.get(3).getAbility());
    sheetPokemon4.setGmax(teamPaste.get(3).isGmax());
    sheetPokemon4.setItem(teamPaste.get(3).getItem());
    sheetPokemon4.setMoves(teamPaste.get(3).getMoves());
    sheetPokemon4.setLevel(teamPaste.get(3).getLevel());
    sheetPokemon4.setStats(new int[] {calcPV(kartanaBS[0], teamPaste.get(3).getLevel(), teamPaste.get(3).getEvs()[0], teamPaste.get(3).getIvs()[0]),
            calcStat(kartanaBS[1], teamPaste.get(3).getLevel(), teamPaste.get(3).getEvs()[1], teamPaste.get(3).getIvs()[1],calcNature(teamPaste.get(3).getNature())[0]),
            calcStat(kartanaBS[2], teamPaste.get(3).getLevel(), teamPaste.get(3).getEvs()[2], teamPaste.get(3).getIvs()[2],calcNature(teamPaste.get(3).getNature())[1]),
            calcStat(kartanaBS[3], teamPaste.get(3).getLevel(), teamPaste.get(3).getEvs()[3], teamPaste.get(3).getIvs()[3],calcNature(teamPaste.get(3).getNature())[2]),
            calcStat(kartanaBS[4], teamPaste.get(3).getLevel(), teamPaste.get(3).getEvs()[4], teamPaste.get(3).getIvs()[4],calcNature(teamPaste.get(3).getNature())[3]),
            calcStat(kartanaBS[5], teamPaste.get(3).getLevel(), teamPaste.get(3).getEvs()[5], teamPaste.get(3).getIvs()[5],calcNature(teamPaste.get(3).getNature())[4])});



    System.out.println("Name : " + sheetPokemon4.getName());
    System.out.println("Item : " + sheetPokemon4.getItem());
    System.out.println("Gigamax : " + sheetPokemon4.getGmax());
    System.out.println("Ability : " + sheetPokemon4.getAbility());
    System.out.println("Level : " + sheetPokemon4.getLevel());
    System.out.println("PV : " + sheetPokemon4.getStats()[0]);
    System.out.println("Atk : " + sheetPokemon4.getStats()[1]);
    System.out.println("Def : " + sheetPokemon4.getStats()[2]);
    System.out.println("AtkSpe : " + sheetPokemon4.getStats()[3]);
    System.out.println("DefSpe : " + sheetPokemon4.getStats()[4]);
    System.out.println("Vit : " + sheetPokemon4.getStats()[5]);
    System.out.println("Move 1 : " + sheetPokemon4.getMoves()[0]);
    System.out.println("Move 2 : " + sheetPokemon4.getMoves()[1]);
    System.out.println("Move 3 : " + sheetPokemon4.getMoves()[2]);
    System.out.println("Move 4 : " + sheetPokemon4.getMoves()[3]);

    System.out.println("-----------------------------------------------------------------------------------");

    SheetPokemon sheetPokemon5 = new SheetPokemon();

    sheetPokemon5.setName(teamPaste.get(4).getName());
    sheetPokemon5.setAbility(teamPaste.get(4).getAbility());
    sheetPokemon5.setGmax(teamPaste.get(4).isGmax());
    sheetPokemon5.setItem(teamPaste.get(4).getItem());
    sheetPokemon5.setMoves(teamPaste.get(4).getMoves());
    sheetPokemon5.setLevel(teamPaste.get(4).getLevel());
    sheetPokemon5.setStats(new int[] {calcPV(landorus_tBS[0], teamPaste.get(4).getLevel(), teamPaste.get(4).getEvs()[0], teamPaste.get(4).getIvs()[0]),
            calcStat(landorus_tBS[1], teamPaste.get(4).getLevel(), teamPaste.get(4).getEvs()[1], teamPaste.get(4).getIvs()[1],calcNature(teamPaste.get(4).getNature())[0]),
            calcStat(landorus_tBS[2], teamPaste.get(4).getLevel(), teamPaste.get(4).getEvs()[2], teamPaste.get(4).getIvs()[2],calcNature(teamPaste.get(4).getNature())[1]),
            calcStat(landorus_tBS[3], teamPaste.get(4).getLevel(), teamPaste.get(4).getEvs()[3], teamPaste.get(4).getIvs()[3],calcNature(teamPaste.get(4).getNature())[2]),
            calcStat(landorus_tBS[4], teamPaste.get(4).getLevel(), teamPaste.get(4).getEvs()[4], teamPaste.get(4).getIvs()[4],calcNature(teamPaste.get(4).getNature())[3]),
            calcStat(landorus_tBS[5], teamPaste.get(4).getLevel(), teamPaste.get(4).getEvs()[5], teamPaste.get(4).getIvs()[5],calcNature(teamPaste.get(4).getNature())[4])});



    System.out.println("Name : " + sheetPokemon5.getName());
    System.out.println("Item : " + sheetPokemon5.getItem());
    System.out.println("Gigamax : " + sheetPokemon5.getGmax());
    System.out.println("Ability : " + sheetPokemon5.getAbility());
    System.out.println("Level : " + sheetPokemon5.getLevel());
    System.out.println("PV : " + sheetPokemon5.getStats()[0]);
    System.out.println("Atk : " + sheetPokemon5.getStats()[1]);
    System.out.println("Def : " + sheetPokemon5.getStats()[2]);
    System.out.println("AtkSpe : " + sheetPokemon5.getStats()[3]);
    System.out.println("DefSpe : " + sheetPokemon5.getStats()[4]);
    System.out.println("Vit : " + sheetPokemon5.getStats()[5]);
    System.out.println("Move 1 : " + sheetPokemon5.getMoves()[0]);
    System.out.println("Move 2 : " + sheetPokemon5.getMoves()[1]);
    System.out.println("Move 3 : " + sheetPokemon5.getMoves()[2]);
    System.out.println("Move 4 : " + sheetPokemon5.getMoves()[3]);

    System.out.println("-----------------------------------------------------------------------------------");

    SheetPokemon sheetPokemon6 = new SheetPokemon();

    sheetPokemon6.setName(teamPaste.get(5).getName());
    sheetPokemon6.setAbility(teamPaste.get(5).getAbility());
    sheetPokemon6.setGmax(teamPaste.get(5).isGmax());
    sheetPokemon6.setItem(teamPaste.get(5).getItem());
    sheetPokemon6.setMoves(teamPaste.get(5).getMoves());
    sheetPokemon6.setLevel(teamPaste.get(5).getLevel());
    sheetPokemon6.setStats(new int[] {calcPV(amoongusBS[0], teamPaste.get(5).getLevel(), teamPaste.get(5).getEvs()[0], teamPaste.get(5).getIvs()[0]),
            calcStat(amoongusBS[1], teamPaste.get(5).getLevel(), teamPaste.get(5).getEvs()[1], teamPaste.get(5).getIvs()[1],calcNature(teamPaste.get(5).getNature())[0]),
            calcStat(amoongusBS[2], teamPaste.get(5).getLevel(), teamPaste.get(5).getEvs()[2], teamPaste.get(5).getIvs()[2],calcNature(teamPaste.get(5).getNature())[1]),
            calcStat(amoongusBS[3], teamPaste.get(5).getLevel(), teamPaste.get(5).getEvs()[3], teamPaste.get(5).getIvs()[3],calcNature(teamPaste.get(5).getNature())[2]),
            calcStat(amoongusBS[4], teamPaste.get(5).getLevel(), teamPaste.get(5).getEvs()[4], teamPaste.get(5).getIvs()[4],calcNature(teamPaste.get(5).getNature())[3]),
            calcStat(amoongusBS[5], teamPaste.get(5).getLevel(), teamPaste.get(5).getEvs()[5], teamPaste.get(5).getIvs()[5],calcNature(teamPaste.get(5).getNature())[4])});



    System.out.println("Name : " + sheetPokemon6.getName());
    System.out.println("Item : " + sheetPokemon6.getItem());
    System.out.println("Gigamax : " + sheetPokemon6.getGmax());
    System.out.println("Ability : " + sheetPokemon6.getAbility());
    System.out.println("Level : " + sheetPokemon6.getLevel());
    System.out.println("PV : " + sheetPokemon6.getStats()[0]);
    System.out.println("Atk : " + sheetPokemon6.getStats()[1]);
    System.out.println("Def : " + sheetPokemon6.getStats()[2]);
    System.out.println("AtkSpe : " + sheetPokemon6.getStats()[3]);
    System.out.println("DefSpe : " + sheetPokemon6.getStats()[4]);
    System.out.println("Vit : " + sheetPokemon6.getStats()[5]);
    System.out.println("Move 1 : " + sheetPokemon6.getMoves()[0]);
    System.out.println("Move 2 : " + sheetPokemon6.getMoves()[1]);
    System.out.println("Move 3 : " + sheetPokemon6.getMoves()[2]);
    System.out.println("Move 4 : " + sheetPokemon6.getMoves()[3]);


}


}
