public class Test {
    public static void main(String[] args) {
        BlueAstronaut bob = new BlueAstronaut("Bob",20,6,30);
        BlueAstronaut heath = new BlueAstronaut("Heath",30,3,21);
        BlueAstronaut albert = new BlueAstronaut("Albert",44,2,0);
        BlueAstronaut angel = new BlueAstronaut("Angel",0,1,0);
        RedAstronaut liam = new RedAstronaut("Liam",19,"experienced");
        RedAstronaut susp = new RedAstronaut("Suspicious Person", 100,"expert");
        liam.sabotage(bob);
        System.out.println(bob.toString());  // 1 pass
        liam.freeze(susp);
        System.out.println(susp.toString());  // 2 pass
        liam.freeze(albert);
        System.out.println(albert.toString());
        System.out.println(liam.toString()); // 3 pass
        albert.emergencyMeeting(); // 4 pass
        susp.emergencyMeeting(); // 5 pass
        System.out.println(susp.toString());
        bob.emergencyMeeting();
        System.out.println(susp.toString()); // 6 pass
        heath.completeTask();
        System.out.println(heath.getNumTasks()); // 7 pass
        heath.completeTask();
        System.out.println(heath.toString()); // 8 pass
        heath.completeTask(); // 9 pass
        liam.freeze(angel); // 10 pass
        System.out.println(liam.toString());
        System.out.println(angel.toString());
        liam.sabotage(bob);
        System.out.println(bob.toString());
        liam.sabotage(bob);
        System.out.println(bob.toString()); // 11 pass
        liam.freeze(bob);
        System.out.println(bob.toString()); // 12 pass
        //angel.emergencyMeeting();
        //System.out.println(liam.toString()); // 13 pass
        for (int i = 0; i < 5;i++){
            liam.sabotage(heath);
            System.out.println(heath.toString());
        }
        liam.freeze(heath);
        System.out.println(heath.toString());



    }
}
