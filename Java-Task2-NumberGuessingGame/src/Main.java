class Main {
    public static void main(String[] args) {
       Game game = new Game();

       int easyNumber = game.generateRandomNumber(1,50);
       int mediumNumber = game.generateRandomNumber(1,100);
       int hardNumber = game.generateRandomNumber(1,200);

        System.out.println("================================");
        System.out.println("   NUMBER GUESSING GAME - F01");
        System.out.println("================================");

        System.out.println("Easy Number   : " + easyNumber);
        System.out.println("Medium Number: " + mediumNumber);
        System.out.println("Hard Number  : " + hardNumber);

        System.out.println("================================");
    }
}