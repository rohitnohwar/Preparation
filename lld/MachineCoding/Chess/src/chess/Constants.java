package chess;

import chess.piece.*;

import java.util.HashMap;
import java.util.Map;

public class Constants {
    public static final Map<Piece, int[][]> initalPositions = new HashMap<>() {{
        put(new Camel(), new int[][]{{0, 1}, {0,6}});
        put(new Elephant(), new int[][]{{0, 0}, {0,7}});
        put(new Horse(), new int[][]{{0, 2}, {0, 3}});
        put(new Queen(), new int[][]{{0, 4}});
        put(new King(), new int[][]{{0, 5}});
    }};

}
