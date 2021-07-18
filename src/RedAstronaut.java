import java.util.Arrays;
import java.util.Locale;

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

    // Getters
    public String getSkill(){
        return this.skill;
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
        // Do not freeze if is an imposter or player already frozen or attacking player is frozen
        if (p instanceof RedAstronaut || p.isFrozen() || this.isFrozen()) {
            return;
        }
        // Attempt to freeze
        // Successful freeze
        if (this.getSusLevel() < p.getSusLevel()) {
            p.setFrozen(true);
            return;
        }
        else {
            this.setSusLevel(this.getSusLevel()*2);
        }
        gameOver();
    }

    public void sabotage(Player p) {
        double multiplier;
        // Check if possible to sabotage
        if (p instanceof RedAstronaut || p.isFrozen() || this.isFrozen()) {
            return;
        }
        // Commit sabotage
        if (this.getSusLevel() < 20) {
            multiplier = 0.5;
        }
        else {
            multiplier = 0.25;
        }
        p.setSusLevel((int) (p.getSusLevel()*(1+multiplier)));
    }

    // Overrides
    public boolean equals(Object o) {
        if (o instanceof RedAstronaut) {
            RedAstronaut compareRed = (RedAstronaut) o;
            if (compareRed.getName() == this.getName() && compareRed.getSusLevel() == this.getSusLevel() && compareRed.getSkill() == this.getSkill()) {
                return true;
            }
        }
        return false;
    }

    public String toString(){
        String myString = super.toString();
        myString += " I am an " + getSkill() + " player!";
        return getSusLevel() > 20 ? myString : myString.toUpperCase(Locale.ROOT);
    }
}
