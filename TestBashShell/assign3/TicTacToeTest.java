//package ProgAssignment3;
import static org.junit.Assert.assertEquals;
import org.junit.Test;


public class TicTacToeTest {

  
  @Test
  public void setCellTest() {
    TicTacToe game = new TicTacToe();

    boolean first = game.setCell(0, 0, TicTacToe.Cell.X);
    boolean second = game.setCell(0, 0, TicTacToe.Cell.O);
    boolean third = game.setCell(1, 1, TicTacToe.Cell.EMPTY);
    assertEquals(true, first);
    assertEquals(false, second);
    assertEquals(false, third);
    
  }

  

  @Test
  public void getCellTest() {
    TicTacToe game = new TicTacToe();
    boolean first = game.setCell(0, 0, TicTacToe.Cell.X);
    boolean second = game.setCell(0, 0, TicTacToe.Cell.O);
    boolean third = game.setCell(1, 1, TicTacToe.Cell.EMPTY);
    TicTacToe.Cell firstCell = game.getCell(0 ,0);
    TicTacToe.Cell secondCell = game.getCell(1 ,1);
    assertEquals(TicTacToe.Cell.X, firstCell);
    assertEquals(TicTacToe.Cell.EMPTY, secondCell);
  }

  
  @Test
  public void getCellTest2() {
    TicTacToe game = new TicTacToe();
    boolean first = game.setCell(0, 0, TicTacToe.Cell.X);
    boolean second = game.setCell(0, 0, TicTacToe.Cell.O);
    boolean third = game.setCell(1, 1, TicTacToe.Cell.EMPTY);
    TicTacToe.Cell[][] board = game.getCell();
    assertEquals(5, board.length);
    assertEquals(5, board[0].length);
    assertEquals(TicTacToe.Cell.EMPTY, board[1][1]);
  }

  @Test
  public void isEmptyTest() {
    TicTacToe game = new TicTacToe();
    boolean first = game.setCell(0, 0, TicTacToe.Cell.X);
    boolean second = game.setCell(0, 0, TicTacToe.Cell.O);
    boolean third = game.setCell(1, 1, TicTacToe.Cell.EMPTY);
    assertEquals(false, game.isEmpty(0, 0));
    assertEquals(true, game.isEmpty(1, 1));
  }

  

  @Test
  public void clearBoardTest() {
    TicTacToe game = new TicTacToe();
    boolean first = game.setCell(0, 0, TicTacToe.Cell.X);
    boolean second = game.setCell(0, 0, TicTacToe.Cell.O);
    boolean third = game.setCell(1, 1, TicTacToe.Cell.EMPTY);
    game.clearBoard();
    assertEquals(TicTacToe.Cell.EMPTY, game.getCell(0, 0));
  }

  

  @Test
  public void moveByRandomTest() {
    TicTacToe game = new TicTacToe();
    game.setCell(0, 0, TicTacToe.Cell.X);
    game.setCell(1, 0, TicTacToe.Cell.X);
    game.setCell(2, 0, TicTacToe.Cell.X);
    game.setCell(3, 0, TicTacToe.Cell.X);
    game.setCell(4, 0, TicTacToe.Cell.O);

    game.setCell(0, 1, TicTacToe.Cell.O);
    game.setCell(1, 1, TicTacToe.Cell.O);
    game.setCell(2, 1, TicTacToe.Cell.O);
    game.setCell(3, 1, TicTacToe.Cell.O);
    game.setCell(4, 1, TicTacToe.Cell.X);

    game.setCell(0, 2, TicTacToe.Cell.X);
    game.setCell(1, 2, TicTacToe.Cell.X);
    game.setCell(2, 2, TicTacToe.Cell.X);
    game.setCell(3, 2, TicTacToe.Cell.X);
    game.setCell(4, 2, TicTacToe.Cell.O);

    game.setCell(0, 3, TicTacToe.Cell.O);
    game.setCell(1, 3, TicTacToe.Cell.O);
    game.setCell(2, 3, TicTacToe.Cell.O);
    game.setCell(3, 3, TicTacToe.Cell.O);
    game.setCell(4, 3, TicTacToe.Cell.X);

    game.setCell(0, 4, TicTacToe.Cell.X);
    game.setCell(1, 4, TicTacToe.Cell.X);
    game.setCell(2, 4, TicTacToe.Cell.O);
    game.setCell(3, 4, TicTacToe.Cell.X);

    int[] index = game.moveByRandom();
    int xPos = index[0];
    int yPos = index[1];
    assertEquals(4, xPos);
    assertEquals(4, yPos);
    
    
  }
  /*
  example game:
0  XXXXX
1  
2  
3
4  OOOO
  */

  @Test
  public void gameEndTest() {
    TicTacToe game = new TicTacToe();
    assertEquals(false, game.gameEnd());
    game.setCell(0, 0, TicTacToe.Cell.X);
    game.setCell(4, 0, TicTacToe.Cell.O);
    game.setCell(0, 1, TicTacToe.Cell.X);
    game.setCell(4, 1, TicTacToe.Cell.O);
    game.setCell(0, 2, TicTacToe.Cell.X);
    game.setCell(4, 2, TicTacToe.Cell.O);
    game.setCell(0, 3, TicTacToe.Cell.X);
    game.setCell(4, 3, TicTacToe.Cell.O);
    game.setCell(0, 4, TicTacToe.Cell.X);
    assertEquals(true, game.gameEnd());

  }

  @Test
  /*
  example game:
  XXXXO
  OOOOX
  XXXXO
  OOOOX
  XXOXO
  Score of Random (X): 6
  Score of Human (O): 6
  */
  public void scoreOfRandomTest() {
    TicTacToe game = new TicTacToe();
    assertEquals(0, game.scoreOfRandom());
    game.setCell(0, 0, TicTacToe.Cell.X);
    game.setCell(1, 0, TicTacToe.Cell.X);
    game.setCell(2, 0, TicTacToe.Cell.X);
    game.setCell(3, 0, TicTacToe.Cell.X);
    game.setCell(4, 0, TicTacToe.Cell.O);

    game.setCell(0, 1, TicTacToe.Cell.O);
    game.setCell(1, 1, TicTacToe.Cell.O);
    game.setCell(2, 1, TicTacToe.Cell.O);
    game.setCell(3, 1, TicTacToe.Cell.O);
    game.setCell(4, 1, TicTacToe.Cell.X);

    game.setCell(0, 2, TicTacToe.Cell.X);
    game.setCell(1, 2, TicTacToe.Cell.X);
    game.setCell(2, 2, TicTacToe.Cell.X);
    game.setCell(3, 2, TicTacToe.Cell.X);
    game.setCell(4, 2, TicTacToe.Cell.O);

    game.setCell(0, 3, TicTacToe.Cell.O);
    game.setCell(1, 3, TicTacToe.Cell.O);
    game.setCell(2, 3, TicTacToe.Cell.O);
    game.setCell(3, 3, TicTacToe.Cell.O);
    game.setCell(4, 3, TicTacToe.Cell.X);

    game.setCell(0, 4, TicTacToe.Cell.X);
    game.setCell(1, 4, TicTacToe.Cell.X);
    game.setCell(2, 4, TicTacToe.Cell.O);
    game.setCell(3, 4, TicTacToe.Cell.X);
    game.setCell(4, 4, TicTacToe.Cell.O);
    assertEquals(6, game.scoreOfRandom());
  }

  

  @Test
  public void scoreOfHumanTest() {
    TicTacToe game = new TicTacToe();
    assertEquals(0, game.scoreOfHuman());
    
    game.setCell(0, 0, TicTacToe.Cell.X);
    game.setCell(1, 0, TicTacToe.Cell.X);
    game.setCell(2, 0, TicTacToe.Cell.X);
    game.setCell(3, 0, TicTacToe.Cell.X);
    game.setCell(4, 0, TicTacToe.Cell.O);

    game.setCell(0, 1, TicTacToe.Cell.O);
    game.setCell(1, 1, TicTacToe.Cell.O);
    game.setCell(2, 1, TicTacToe.Cell.O);
    game.setCell(3, 1, TicTacToe.Cell.O);
    game.setCell(4, 1, TicTacToe.Cell.X);

    game.setCell(0, 2, TicTacToe.Cell.X);
    game.setCell(1, 2, TicTacToe.Cell.X);
    game.setCell(2, 2, TicTacToe.Cell.X);
    game.setCell(3, 2, TicTacToe.Cell.X);
    game.setCell(4, 2, TicTacToe.Cell.O);

    game.setCell(0, 3, TicTacToe.Cell.O);
    game.setCell(1, 3, TicTacToe.Cell.O);
    game.setCell(2, 3, TicTacToe.Cell.O);
    game.setCell(3, 3, TicTacToe.Cell.O);
    game.setCell(4, 3, TicTacToe.Cell.X);

    game.setCell(0, 4, TicTacToe.Cell.X);
    game.setCell(1, 4, TicTacToe.Cell.X);
    game.setCell(2, 4, TicTacToe.Cell.O);
    game.setCell(3, 4, TicTacToe.Cell.X);
    game.setCell(4, 4, TicTacToe.Cell.O);
    assertEquals(6, game.scoreOfHuman());

  }



  @Test
  public void showBoardTest() {
    TicTacToe game = new TicTacToe();
    game.setCell(0, 1, TicTacToe.Cell.X);
    game.setCell(3, 3, TicTacToe.Cell.O);
    game.showBoard();

  }
}
