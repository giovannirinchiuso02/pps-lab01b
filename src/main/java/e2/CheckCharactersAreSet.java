package e2;

public class CheckCharactersAreSet implements CheckCaracters{

    Logics logics;

    public CheckCharactersAreSet(Logics logics) {
        this.logics = logics;
    }

    public boolean hasKnight(int row, int col) {
        return this.logics.getKnight().equals(new Pair<>(row, col));
    }


    public boolean hasPawn(int row, int col) {
        return this.logics.getPawn().equals(new Pair<>(row, col));
    }



}
