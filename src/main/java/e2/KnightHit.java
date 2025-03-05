package e2;

public interface KnightHit {

    /**
     * attempt to move Knight on position row,col, if possible
     *
     * @param row
     * @param col
     * @return whether the pawn has been hit
     */
    boolean hit(int row, int col);
}
