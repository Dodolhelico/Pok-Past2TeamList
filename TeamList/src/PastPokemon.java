public class PastPokemon {
    private String name;
    private String item;
    private String ability;
    private int level;
    private int[] evs;
    private int[] ivs;
    private String nature;
    private String[] moves;

    public void setName(String name) {
        this.name = name;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public void setAbility(String ability) {
        this.ability = ability;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setEvs(int[] evs) {
        this.evs = evs;
    }

    public void setIvs(int[] ivs) {
        this.ivs = ivs;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    public void setMoves(String[] moves) {
        this.moves = moves;
    }

    public String getName() {
        return name;
    }

    public String getItem() {
        return item;
    }

    public String getAbility() {
        return ability;
    }

    public int getLevel() {
        return level;
    }

    public int[] getEvs() {
        return evs;
    }

    public int[] getIvs() {
        return ivs;
    }

    public String getNature() {
        return nature;
    }

    public String[] getMoves() {
        return moves;
    }
}

