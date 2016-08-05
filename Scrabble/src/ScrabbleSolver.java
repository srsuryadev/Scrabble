import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ScrabbleSolver {

	
	public static long primeValue(String str) {
		
		int[] primes = {2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97,101};
		long product=1;
		for(int i=0; i< str.length();i++) {
			product *= primes[(int)str.charAt(i)-(int)'a'];
		}
		return product;
	}
	
	
	public static void main(String args[]) throws IOException {
		String largestWord = getPossibleHighestMove("abcdefg");
	}
	
	

	private static String getPossibleHighestMove(String string) throws IOException {
		
		ScrabbleWord S = new ScrabbleWord();
		long rackValue = primeValue(string);
		long highest = 0;
		String highestStr = "";
		System.out.println(rackValue);
		File file = new File("sowpods.txt");
		FileInputStream fis = new FileInputStream(file);
		BufferedReader br = new BufferedReader(new InputStreamReader(fis));
		String line = null;
		while ((line = br.readLine()) != null) {
			if(line.length() <= 7) {
				long wordPrime = primeValue(line);
				if(rackValue % wordPrime==0) {
					long wordPoints = S.calculatePoints(line);
					if(wordPoints > highest) {
						highest = wordPoints;
						highestStr = line;
					}
				}
			}
				
		}
		br.close();
		return highestStr;
	}
}
