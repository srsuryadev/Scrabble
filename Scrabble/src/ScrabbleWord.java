
public class ScrabbleWord {

	private Integer[] pointsArray = {9, 2, 2, 4, 12, 2, 3, 2, 9, 1, 1, 4, 2, 6, 8, 2, 1, 6, 6, 6, 4, 2, 2, 1, 2, 1};
	
	public Integer calculatePoints(String word){
		Integer points = 0;
		for(int i =0;i<word.length(); i++){
			points = points + pointsArray[(int)word.charAt(i)-(int)'a'];
		}
		return points;
	}
}
