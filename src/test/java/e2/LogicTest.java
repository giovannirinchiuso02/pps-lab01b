package e2;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class LogicTest {

  private static final int SIZE_BOARD = 5;
  private static final int LONG_DIRECTION_MOVE = 2;
  private static final int SHORT_DIRECTION_MOVE = 1;
  Logics logic;

  private boolean isPositionInTheMap(Pair<Integer, Integer> pos) {
    return pos.getX() >= 0 && pos.getX() < SIZE_BOARD && pos.getY() >= 0 && pos.getY() < SIZE_BOARD;
  }


  @BeforeEach
          void setUp() {
  logic = new LogicsImpl(SIZE_BOARD);
  }


  @Test
  public void testKnightAndPawnAreBothPresentOnTheBoard() {
    Pair<Integer, Integer> pawn = logic.getPawn();
    Pair<Integer, Integer> knight = logic.getKnight();
    assertTrue(this.isPositionInTheMap(pawn));
    assertTrue(this.isPositionInTheMap(knight));
  }

  @Test
  public void testKnightAndPawnAreInDifferentPositions() {
    Pair<Integer, Integer> pawn = logic.getPawn();
    Pair<Integer, Integer> knight = logic.getKnight();
      assertNotEquals(pawn, knight);
  }

  @Test
  public void testHasKnight() {
    Pair<Integer, Integer> knight = logic.getKnight();
    assertTrue(logic.hasKnight(knight.getX(), knight.getY()));
  }

  @Test
  public void testHasPawn() {
    Pair<Integer, Integer> pawn = logic.getPawn();
    assertTrue(logic.hasPawn(pawn.getX(), pawn.getY()));
  }

  @Test
  public void testKnightCanHitNewPosition() {
    Pair<Integer, Integer> knightInitialPosition = logic.getKnight();
    Pair<Integer, Integer> knightFinalPosition = new Pair<Integer, Integer>(knightInitialPosition.getX() + SHORT_DIRECTION_MOVE, knightInitialPosition.getY() + LONG_DIRECTION_MOVE);
    if (this.isPositionInTheMap(knightFinalPosition)) {
      if(knightFinalPosition == logic.getPawn()) {
        assertTrue(logic.hit(knightFinalPosition.getX(), knightFinalPosition.getY()));
      }
      assertFalse(logic.hit(knightFinalPosition.getX(), knightFinalPosition.getY()));
      assertEquals(knightFinalPosition, logic.getKnight());
    }
    else {
      assertEquals(knightInitialPosition, logic.getKnight());
    }
  }

  @Test
  public void testKnightCanNotHitNewPositionOutOfBoard() {
    Pair<Integer, Integer> knightInitialPosition = logic.getKnight();
    assertThrows(IndexOutOfBoundsException.class, () -> logic.hit(knightInitialPosition.getX() + SIZE_BOARD, knightInitialPosition.getY() + SIZE_BOARD));
  }

  @Test
  public void testKnightInvalidMoveInBoard() {
    Pair<Integer, Integer> knightInitialPosition = logic.getKnight();
    Pair<Integer, Integer> knightFinalPosition = new Pair<Integer, Integer>(knightInitialPosition.getX() + SHORT_DIRECTION_MOVE, knightInitialPosition.getY() + SHORT_DIRECTION_MOVE);
    if (this.isPositionInTheMap(knightFinalPosition)) {
      logic.hit(knightFinalPosition.getX(), knightFinalPosition.getY());
      assertEquals(knightInitialPosition, logic.getKnight());
    }
  }

}
