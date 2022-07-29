public class SheetPokemon {

    private String name;
    private String item;
    private boolean gmax;
    private String ability;
    private int level;
    private int[] stats;
    private String[] moves;

    public String getName() {
        return name;
    }

    public String getItem() {
        return item;
    }

    public boolean getGmax() {
        return gmax;
    }

    public String getAbility() {
        return ability;
    }

    public int getLevel() {
        return level;
    }

    public int[] getStats() {
        return stats;
    }

    public String[] getMoves() {
        return moves;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public void setGmax(boolean gmax) {
        this.gmax = gmax;
    }

    public void setAbility(String ability) {
        this.ability = ability;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setStats(int[] stats) {
        this.stats = stats;
    }

    public void setMoves(String[] moves) {
        this.moves = moves;
    }

}
