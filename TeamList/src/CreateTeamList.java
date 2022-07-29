import java.util.Locale;

public class CreateTeamList {

    private static int[] kyogreBS = {100,100,90,150,140,90};
    private static int[] zacianBS = {92,170,115,80,115,148};


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

    public static void main(String[] args) {

        PastPokemon pastPokemon1 = new PastPokemon();

        pastPokemon1.setName("Kyogre");
        pastPokemon1.setItem("Mystic Water");
        pastPokemon1.setAbility("Drizzle");
        pastPokemon1.setLevel(50);
        pastPokemon1.setEvs(new int[]{108, 0, 52, 116, 4, 228});
        pastPokemon1.setIvs(new int[]{31,0,31,31,31,31});
        pastPokemon1.setNature("Modest");
        pastPokemon1.setMoves(new String[]{"Water Spout", "Origin Pulse", "Ice Beam", "Protect"});

        SheetPokemon sheetPokemon1 = new SheetPokemon();

        sheetPokemon1.setName(pastPokemon1.getName());
        sheetPokemon1.setAbility(pastPokemon1.getAbility());
        sheetPokemon1.setGmax(false);
        sheetPokemon1.setItem(pastPokemon1.getItem());
        sheetPokemon1.setMoves(pastPokemon1.getMoves());
        sheetPokemon1.setLevel(pastPokemon1.getLevel());
        sheetPokemon1.setStats(new int[] {calcPV(kyogreBS[0], pastPokemon1.getLevel(), pastPokemon1.getEvs()[0], pastPokemon1.getIvs()[0]),
                calcStat(kyogreBS[1], pastPokemon1.getLevel(), pastPokemon1.getEvs()[1], pastPokemon1.getIvs()[1],calcNature(pastPokemon1.getNature())[0]),
                calcStat(kyogreBS[2], pastPokemon1.getLevel(), pastPokemon1.getEvs()[2], pastPokemon1.getIvs()[2],calcNature(pastPokemon1.getNature())[1]),
                calcStat(kyogreBS[3], pastPokemon1.getLevel(), pastPokemon1.getEvs()[3], pastPokemon1.getIvs()[3],calcNature(pastPokemon1.getNature())[2]),
                calcStat(kyogreBS[4], pastPokemon1.getLevel(), pastPokemon1.getEvs()[4], pastPokemon1.getIvs()[4],calcNature(pastPokemon1.getNature())[3]),
                calcStat(kyogreBS[5], pastPokemon1.getLevel(), pastPokemon1.getEvs()[5], pastPokemon1.getIvs()[5],calcNature(pastPokemon1.getNature())[4])});

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

        PastPokemon pastPokemon2 = new PastPokemon();

        pastPokemon2.setName("Zacian-Crowned");
        pastPokemon2.setItem("Rusted Sword");
        pastPokemon2.setAbility("Intrepid Sword");
        pastPokemon2.setLevel(50);
        pastPokemon2.setEvs(new int[]{252, 76, 4, 0, 36, 140});
        pastPokemon2.setIvs(new int[]{31,31,31,31,31,31});
        pastPokemon2.setNature("Adamant");
        pastPokemon2.setMoves(new String[]{"Behemoth Blade", "Play Rough", "Sacred Sword", "Protect"});

        SheetPokemon sheetPokemon2 = new SheetPokemon();

        sheetPokemon2.setName(pastPokemon2.getName());
        sheetPokemon2.setAbility(pastPokemon2.getAbility());
        sheetPokemon2.setGmax(false);
        sheetPokemon2.setItem(pastPokemon2.getItem());
        sheetPokemon2.setMoves(pastPokemon2.getMoves());
        sheetPokemon2.setLevel(pastPokemon2.getLevel());
        sheetPokemon2.setStats(new int[] {calcPV(zacianBS[0], pastPokemon2.getLevel(), pastPokemon2.getEvs()[0], pastPokemon2.getIvs()[0]),
                calcStat(zacianBS[1], pastPokemon2.getLevel(), pastPokemon2.getEvs()[1], pastPokemon2.getIvs()[1],calcNature(pastPokemon2.getNature())[0]),
                calcStat(zacianBS[2], pastPokemon2.getLevel(), pastPokemon2.getEvs()[2], pastPokemon2.getIvs()[2],calcNature(pastPokemon2.getNature())[1]),
                calcStat(zacianBS[3], pastPokemon2.getLevel(), pastPokemon2.getEvs()[3], pastPokemon2.getIvs()[3],calcNature(pastPokemon2.getNature())[2]),
                calcStat(zacianBS[4], pastPokemon2.getLevel(), pastPokemon2.getEvs()[4], pastPokemon2.getIvs()[4],calcNature(pastPokemon2.getNature())[3]),
                calcStat(zacianBS[5], pastPokemon2.getLevel(), pastPokemon2.getEvs()[5], pastPokemon2.getIvs()[5],calcNature(pastPokemon2.getNature())[4])});



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
