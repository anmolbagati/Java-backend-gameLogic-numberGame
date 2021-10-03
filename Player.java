
import java.util.Arrays;

public class Player {

	public String name;
	public int score;
	public Tile tiles[];
	public Tile lastTilePlayed;
	public int roundsWon;
	public Tile playableTiles[];
	
	
	public Tile[] getPlayableTiles() {
		return playableTiles;
	}
	public void setPlayableTiles(Tile[] playableTiles) {
		this.playableTiles = playableTiles;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public Tile[] getTiles() {
		return tiles;
	}
	public void setTiles(Tile[] tiles) {
		this.tiles = tiles;
	}
	public Tile getLastTilePlayed() {
		return lastTilePlayed;
	}
	public void setLastTilePlayed(Tile lastTilePlayed) {
		this.lastTilePlayed = lastTilePlayed;
	}
	public int getRoundsWon() {
		return roundsWon;
	}
	public void setRoundsWon(int roundsWon) {
		this.roundsWon = roundsWon;
	}
	
	@Override
	public String toString() {
		return "Player [name=" + name + ", score=" + score + ", tiles=" + Arrays.toString(tiles) + ", lastTilePlayed="
				+ lastTilePlayed + ", roundsWon=" + roundsWon + "]";
	}
	
	public Player()
	{
		this.score = 0;
		this.roundsWon=0;
	
		
	}
	
	public Player(String name)
	{
		this.name = name;
		this.score = 0;
		this.roundsWon=0;
	}

	
	
	
	
}
