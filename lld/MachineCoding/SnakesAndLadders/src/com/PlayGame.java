package com;

import java.util.*;

public class PlayGame {
    Map<Integer, Player> players;
    Board board;

    public void initialiseGame() {
        board = new Board();

        System.out.println("Enter number of players");
        Scanner sc = new Scanner(System.in);
        int noOfPlayers = sc.nextInt();

        players = new HashMap<>();
        for (int i = 0; i < noOfPlayers; i++) {
            Player player = new Player(i, board.getBoard()[0][0]);
            players.put(i, player);
            board.getBoard()[0][0].getPlayers().add(i);
        }

        System.out.println("Enter number of snakes");
        int noOfSnakes = sc.nextInt();
        for (int i = 0; i < noOfSnakes; i++) {
            System.out.println("Enter startX of snake");
            int startX = sc.nextInt();
            System.out.println("Enter startY of snake");
            int startY = sc.nextInt();
            System.out.println("Enter endX of snake");
            int endX = sc.nextInt();
            System.out.println("Enter endY of snake");
            int endY = sc.nextInt();

            Snake snake = new Snake(board.getBoard()[startX][startY], board.getBoard()[endX][endY]);
            board.getBoard()[startX][startY].setSnake(snake);

        }

        System.out.println("Enter number of ladders");
        int noOfLadders = sc.nextInt();
        for (int i = 0; i < noOfLadders; i++) {
            System.out.println("Enter startX of ladder");
            int startX = sc.nextInt();
            System.out.println("Enter startY of ladder");
            int startY = sc.nextInt();
            System.out.println("Enter endX of ladder");
            int endX = sc.nextInt();
            System.out.println("Enter endX of ladder");
            int endY = sc.nextInt();

            Ladder ladder = new Ladder(board.getBoard()[startX][startY], board.getBoard()[endX][endY]);
            board.getBoard()[startX][startY].setLadder(ladder);
        }


        int playerTurnIndex = 0;
        DiceService diceService = DiceService.returnDiceService();

        while (true) {

            int diceNumber = diceService.rollDice();
            Cell currentCell = players.get(playerTurnIndex).getCurrentCell();

            int newX = currentCell.getxCord();
            int newY;
            if (currentCell.getyCord() + diceNumber >= board.getDimension()) {
                newX = currentCell.getxCord() + 1;
                newY = (currentCell.getyCord() + diceNumber) % board.getDimension();
            }
            else newY = currentCell.getyCord() + diceNumber;

            if ((newX == 9 && newY == 9) || newX == 10) {
                System.out.println("Player " + playerTurnIndex + " won");
                break;
            }


            int newXTemp = newX;
            if (board.getBoard()[newX][newY].getLadder() != null) {
                newX = board.getBoard()[newX][newY].getLadder().getEndPosition().getxCord();
                newY = board.getBoard()[newXTemp][newY].getLadder().getEndPosition().getyCord();
            }
            else if (board.getBoard()[newX][newY].getSnake() != null) {
                newX = board.getBoard()[newX][newY].getSnake().getEndPosition().getxCord();
                newY = board.getBoard()[newXTemp][newY].getSnake().getEndPosition().getyCord();
            }

            Player player = players.get(playerTurnIndex);
            player.setCurrentCell(board.getBoard()[newX][newY]);
            board.getBoard()[newX][newY].getPlayers().add(playerTurnIndex);
            currentCell.getPlayers().remove(playerTurnIndex);

            playerTurnIndex = (playerTurnIndex + 1) % noOfPlayers;

        }
    }
}
