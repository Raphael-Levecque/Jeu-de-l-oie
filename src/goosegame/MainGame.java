package goosegame;

public class MainGame {

    public static void usage(){
        System.out.println("Use : java -classpath classes goosegame <player1> <player2>");
        System.exit(0);
    }

    public static void main(String[] args) {
        Player player1;
        Player player2;


        if (args.length < 2) {
            MainGame.usage();
        }

        player1 = new Player(args[0]);
        player2 = new Player(args[1]);            
        
        Board cBoard = new ClassicalBoard();
        Game game = new Game(cBoard);


        game.addPlayer(player1);
        game.addPlayer(player2);

        game.play();
    }
}
