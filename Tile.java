
/**
 * Write a description of class Player here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public class Tile {

	public int value;
	public int score;
	public int notPlayScore;
	public int isPlayed;
	
	
	
	public int getIsPlayed() {
		return isPlayed;
	}
	public void setIsPlayed(int isPlayed) {
		this.isPlayed = isPlayed;
	}
	public int getNotPlayScore() {
		return notPlayScore;
	}
	public void setNotPlayScore(int notPlayScore) {
		this.notPlayScore = notPlayScore;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	@Override
	public String toString() {
		return "Tile [value=" + value + ", score=" + score + "]";
	}
	
	
}
