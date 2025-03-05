package e2;

import java.util.*;

public class LogicsImpl implements Logics {
	
	private final Pair<Integer,Integer> pawn;
	private Pair<Integer,Integer> knight;
	private final Random random = new Random();
	private final int size;
	KnightHit knightHit = new KnightHit(this);

    public LogicsImpl(final int size){
    	this.size = size;
        this.pawn = this.randomEmptyPosition();
        this.knight = this.randomEmptyPosition();

    }


	public LogicsImpl(final Pair<Integer,Integer> pawn, final Pair<Integer,Integer> knight, final int size){
		this.pawn = pawn;
		this.knight = knight;
		this.size = size;
	}
    
	private final Pair<Integer,Integer> randomEmptyPosition(){
    	Pair<Integer,Integer> pos = new Pair<>(this.random.nextInt(size),this.random.nextInt(size));
    	// the recursive call below prevents clash with an existing pawn
    	return this.pawn!=null && this.pawn.equals(pos) ? randomEmptyPosition() : pos;
    }
    
	@Override
	public boolean hit(int row, int col) {
		return knightHit.hit(row, col);
	}

	@Override
	public boolean hasKnight(int row, int col) {
		return this.knight.equals(new Pair<>(row,col));
	}

	@Override
	public boolean hasPawn(int row, int col) {
		return this.pawn.equals(new Pair<>(row,col));
	}

	@Override
	public Pair<Integer, Integer> getPawn() {
		return this.pawn;
	}

	@Override
	public Pair<Integer, Integer> getKnight() {
		return this.knight;
	}

	@Override
	public void setKnightPosition(int row, int col) {
		this.knight = new Pair<>(row,col);
	}

	@Override
	public int getSize() {
		return this.size;
	}
}
