package e2;

public class KnightHit{

    Logics logics;

    public KnightHit(Logics logics) {
        this.logics = logics;
    }

    public boolean hit(int row, int col) {
        if (row < 0 || col < 0 || row >= logics.getSize() || col >= logics.getSize()) {
            throw new IndexOutOfBoundsException();
        }
        // Below a compact way to express allowed moves for the knight
        int x = row - logics.getKnight().getX();
        int y = col - logics.getKnight().getY();
        if (x != 0 && y != 0 && Math.abs(x) + Math.abs(y) == 3) {
            logics.setKnightPosition(row, col);
            return logics.getPawn().equals(logics.getKnight());
        }
        return false;
    }
}
