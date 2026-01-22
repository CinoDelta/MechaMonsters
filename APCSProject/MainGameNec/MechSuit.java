package MainGameNec;
import java.util.ArrayList;

public class MechSuit extends statClass {
    private int attackStat;
    private int defenseStat;
    private int speedStat;
    private int specialStat;
    private int healthStat;
    private int critRate;
    private String name;
    
    private String[] specialMoves = {"NONE", "NONE", "NONE", "NONE"};

   
    public MechSuit(int attackStat, int defenseStat, int speedStat, int specialStat, int healthStat, int critRate, String name) {
        super(attackStat, defenseStat, speedStat, specialStat, healthStat, critRate, name);
    };

    public String[] getSpecialMoves() {
        return specialMoves;
    }
    
}
