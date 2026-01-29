
import java.util.ArrayList;

public class MechSuit extends statClass {
    
    private String[] specialMoves = {"NONE", "NONE", "NONE", "NONE"};

   
    public MechSuit(int attackStat, int defenseStat, int speedStat, int specialStat, int healthStat, int critRate, String name) {
        super(attackStat, defenseStat, speedStat, specialStat, healthStat, critRate, name);
    };

    public String[] getSpecialMoves() {
        return specialMoves;
    }
    
}
