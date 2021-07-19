import java.util.Arrays;

public class BlueAstronaut extends Player implements Crewmate {
    // Instance variables
    private int numTasks;
    private int taskSpeed;

    // Constructor
    public BlueAstronaut(String name) {
        this(name, 15, 6, 10);
    }

    public BlueAstronaut(String name, int susLevel, int numTasks, int taskSpeed) {
        super(name, susLevel);
        this.numTasks = numTasks;
        this.taskSpeed = taskSpeed;
    }

    // Getters
    public int getNumTasks() {
        return numTasks;
    }

    public int getTaskSpeed(){
        return taskSpeed;
    }

    // Super Class Abstract Method Definitions
    public void emergencyMeeting() {
        // Frozen player cannot call meeting
        if (this.isFrozen()) {
            return;
        }
        // Sort players by suspicion greatest to least
        Arrays.sort(getPlayers());

        // Identify most suspicious player that is not player calling meeting
        int index = 0;
        Player[] suspects = new Player[2];

        // Loop through players and add suspects to suspect array
        for (int i = getPlayers().length - 1; i >= 0; i--) {
            if (!getPlayers()[i].isFrozen()) {
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

    // Crewmate method definitions
    public void completeTask() {
        // Frozen astronaut cannot complete tasks
        // All tasks complete
        if (isFrozen() || numTasks == 0) {
            return;
        }
        // Complete tasks
        if (taskSpeed > 20) {
            numTasks -= 2;
        } else {
            numTasks -= 1;
        }
        if (numTasks <= 0) {
            numTasks = 0;
            System.out.println("I have completed all my tasks");
            setSusLevel((int) (getSusLevel() * 0.5));
        }
    }

    // Overrides
    @Override
    public boolean equals(Object o) {
        if (o instanceof BlueAstronaut) {
            BlueAstronaut compareBlue = (BlueAstronaut) o;
            if (compareBlue.getName() == this.getName() && compareBlue.getSusLevel() == this.getSusLevel() && compareBlue.isFrozen() == this.isFrozen() && this.getNumTasks() == compareBlue.getNumTasks() && this.getTaskSpeed() == compareBlue.getTaskSpeed()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        String myString = super.toString();
        myString += " I have " + numTasks + " tasks left over.";
        return getSusLevel() <= 15 ? myString : myString.toUpperCase();
    }

}
