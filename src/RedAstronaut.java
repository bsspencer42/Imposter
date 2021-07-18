public class RedAstronaut extends Player implements Impostor {
    // Instance variables
    private String skill;

    // Constructor
    public RedAstronaut(String name, int susLevel,String skill) {
        super(name, susLevel);
        this.skill = skill;
    }

    // Super Class Abstract Method Definitions
    public void emergencyMeeting() {
        return;
    }

    // Imposter Method Definitions
    public void freeze(Player p) {
        return;
    }

    public void sabotage(Player p) {
        return;
    }
}
