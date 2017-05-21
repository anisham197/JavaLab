import java.util.ArrayList;
import java.util.Scanner;

public class VowelThread extends Thread {

	ArrayList<Character> vowels = new ArrayList<>();
	public VowelThread() {
		// TODO Auto-generated constructor stub
		vowels.add('a');
		vowels.add('e');
		vowels.add('i');
		vowels.add('o');
		vowels.add('u');
	}
	
	public void run(){
		System.out.println("Enter a word: ");
		Scanner sc = new Scanner(System.in);
		String word = sc.next();
		word = word.toLowerCase();
		
		int v = 0,c = 0;
		for(int i = 0;i < word.length();i++){
			char ch = word.charAt(i);
			if(vowels.contains(ch))
				v++;
			else
				c++;
		}
		System.out.println("Vowels: "+v);
		System.out.println("Consonants: "+c);
	}

}
