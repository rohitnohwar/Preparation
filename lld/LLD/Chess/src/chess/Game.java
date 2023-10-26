package chess;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private static List<Move> moves = new ArrayList<>();
    private static Player[] players = new Player[2];
    private static Board board;
    private static Player turn;
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        board = new Board();

        Player player1 = new Player();
        player1.setIsWhite(true);

        Player player2 = new Player();
        player2.setIsWhite(false);

        players[0] = player1;
        players[1] = player2;

        turn = players[0];

        moves.add(new Move(players[0], board.get(1, 0), board.get(2, 0)););
    }
}
