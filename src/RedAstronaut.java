import java.util.Arrays;
public class RedAstronaut extends Player implements Impostor {
    // Instance variables
    private String skill;

    // Constructor
    public RedAstronaut(String name) {
        this(name, 15,"experienced");
    }
    public RedAstronaut(String name, int susLevel,String skill) {
        super(name, susLevel);
        this.skill = skill;
    }

    // Super Class Abstract Method Definitions
    public void emergencyMeeting() {
        // Do not allow frozen player to call meeting
        if (this.isFrozen()) {
            return;
        }
        // Hold meeting

        // Sort players by suspicion greatest to least
        Arrays.sort(getPlayers());

        // Identify most suspicious player that is not player calling meeting
        int index = 0;
        Player[] suspects = new Player[2];

        // Loop through players and add suspects to suspect array
        for (int i = getPlayers().length-1; i >= 0; i--) {
            if (!getPlayers()[i].isFrozen() && getPlayers()[i].getName() != this.getName()) {
                suspects[index] = getPlayers()[i];
                index++;
            }
            if (index == 2) {
                break;
            }
        }

        if (suspects[0] != null) {
            if (suspects[1] == null || suspects[0].getSusLevel() != suspects[1].getSusLevel()) {
                suspects[0].setFrozen(true);
            }
        }
        gameOver();

    }

    // Imposter Method Definitions
    public void freeze(Player p) {
        return;
    }

    public void sabotage(Player p) {
        return;
    }
}
