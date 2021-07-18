public class BlueAstronaut extends Player implements Crewmate {
    // Instance variables
    private int numTasks;
    private int taskSpeed;

    // Constructor
    public BlueAstronaut(String name) {
        this(name, 15,6,10);
    }
    public BlueAstronaut(String name, int susLevel,int numTasks, int taskSpeed) {
        super(name, susLevel);
        this.numTasks = numTasks;
        this.taskSpeed = taskSpeed;
    }
    // Super Class Abstract Method Definitions
    public void emergencyMeeting() {
        return;
    }

    // Crewmate method definitions
    public void completeTask(){
        return;
    }
}
