package MainGameNec;
import java.util.ArrayList;

public class mechSuit {
    private int attackStat;
    private int defenseStat;
    private String color;
    private String name;
    private String[] specialMoves = {"NONE", "NONE", "NONE", "NONE"};

    mechSuit(int attackStat, int defenseStat, String color, String name, String[] specialMoves) {
        this.attackStat = attackStat;
        this.defenseStat = defenseStat;
        this.color = color;
        this.name = name;
        this.specialMoves = specialMoves;
    }
}
