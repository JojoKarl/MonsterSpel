package com.company;

import com.googlecode.lanterna.*;
        import com.googlecode.lanterna.input.Key;
        import com.googlecode.lanterna.terminal.Terminal;
        import java.nio.charset.Charset;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Terminal terminal = TerminalFacade.createTerminal(System.in,
                System.out, Charset.forName("UTF8"));
        terminal.enterPrivateMode();
        terminal.setCursorVisible(false);

        Player player = new Player(10, 10);
        Enemy enemy = new Enemy(5, 5);
        printScreen("Press any key to start!", terminal);
        do {

            movePlayer(player, terminal);
            gameLogic(player, enemy);
            updateScreen(player, terminal, enemy);

        } while (!gameOver(player, enemy));

        terminal.applyForegroundColor(112,200,169);
        printScreen("Game Over!", terminal);

        System.out.println("GAme Over");
    }


    private static void movePlayer(Player player, Terminal terminal) throws InterruptedException {
        Key key;
        do {
            Thread.sleep(5);
            key = terminal.readInput();
        }
        while (key == null);
        System.out.println(key.getCharacter() + " " + key.getKind());

        char knappNr = key.getCharacter();

        switch (knappNr) {
            case 'U':
            case '8':
                if (player.getYposition() > 0) {
                    player.changeYPosition(-1);
                }
                break;
            case 'R':
            case '6':
                if (player.getXposition() < 20) {
                    player.changeXPosition(1);
                }
                break;
            case 'D':
            case '2':
                if (player.getYposition() < 20) {
                    player.changeYPosition(1);
                }
                break;
            case 'L':
            case '4':
                if (player.getXposition() > 0) {
                    player.changeXPosition(-1);
                }
                break;
        }
    }


    private static void updateScreen(Player player, Terminal terminal, Enemy enemy) {
        terminal.clearScreen();
        terminal.moveCursor(player.x, player.y);
        terminal.putCharacter('Å');
        terminal.moveCursor(enemy.getX(), enemy.getY());
        terminal.putCharacter('X');
    }

    private static void gameLogic(Player player, Enemy enemy){
    if (enemy.getX()>player.getXposition()){
        enemy.changeXPosition(-1);
    }
        else{
        enemy.changeXPosition(1);
    }
        if (enemy.getY()>player.getYposition()){
            enemy.changeYPosition(-1);
        }
        else{
            enemy.changeYPosition(1);
        }

    }
    private static boolean gameOver(Player player, Enemy enemy){
        if(player.x==enemy.x && player.y ==enemy.y){
            return true;
        }
        else{
            return false;
        }
    }

    private static void printScreen( String text, Terminal terminal){
        terminal.moveCursor(5,3 );
        for (int i =0;i< text.length();i++){
//            terminal.moveCursor(5+i, 10); putCharacter fyttar själv
            terminal.moveCursor(5+i, 3+i);
            terminal.putCharacter(text.charAt(i));

        }
    }
}







