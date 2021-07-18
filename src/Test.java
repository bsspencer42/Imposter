public class Test {
    public static void main(String[] args) {
        BlueAstronaut player1 = new BlueAstronaut("Brad");
        RedAstronaut player2 = new RedAstronaut("Tanner", 13, "experienced");
        RedAstronaut player3 = new RedAstronaut("Tanner", 13, "experienced");
        //RedAstronaut player3 = new RedAstronaut("Amor", 5, "experienced");
        //RedAstronaut player4 = new RedAstronaut("Paige", 12, "experienced");
        System.out.println("Brad is frozen: " + player1.isFrozen());
        player2.freeze(player1);
        System.out.println("Brad is frozen: " + player1.isFrozen());
        System.out.println(player1.getSusLevel());
        System.out.println(player2.equals(player3));
    }
}
