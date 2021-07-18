public class Test {
    public static void main(String[] args) {
        RedAstronaut player1 = new RedAstronaut("Brad", 15, "experienced");
        RedAstronaut player2 = new RedAstronaut("Tanner", 13, "experienced");
        //RedAstronaut player3 = new RedAstronaut("Amor", 5, "experienced");
        //RedAstronaut player4 = new RedAstronaut("Paige", 12, "experienced");
        System.out.println("Tanner is frozen: " + player2.isFrozen());
        player2.emergencyMeeting();
        System.out.println("Tanner is frozen: " + player2.isFrozen());
        System.out.println("Brad is frozen: " + player1.isFrozen());
    }
}
