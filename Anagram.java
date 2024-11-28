/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.

		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
		System.out.println(randomAnagram("hellowhat"));
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2){
		String a = preProcess(str1);
		String b = preProcess(str2);
		String newA = "";
		String newB = "";
		for (int i = 0; i < a.length(); i++){
			if(a.charAt(i) != ' ')
			newA += a.charAt(i);
		}
		//System.out.println(newA);
		for (int i = 0; i < b.length(); i++){
			if(b.charAt(i) != ' ')
			newB += b.charAt(i);
		}
		//System.out.println(newB);
		if (newA.length() != newB. length())
		return false;

		for (int i = 0; i < newA.length(); i++){
			if (newB.indexOf(newA.charAt(i)) == -1){
			return false; 
			}
	}
	return true;
}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		String str1 = str.toLowerCase();
		String str2 = "";
		for (int i = 0; i < str.length(); i++){
			if ((str1.charAt(i) >= 97 && str1.charAt(i) <= 122) || str1.charAt(i) == ' '){
				str2 += str1.charAt(i);
			}
		}
		return str2;	
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		String str1 = preProcess(str);
		System.out.println("the preprocess " + str1);
		String anagram = "";
		int length = str1.length();
		while(length > 0){
			int random = (int)(Math.random() *(str1.length()));
			anagram += str1.charAt(random);
			String left = "";
			String right = "";
			for (int i = 0; i < random; i++){
				left += str1.charAt(i);
			}
			for (int j = random + 1; j < length; j++){
				right += str1.charAt(j);
			}
				str1 = left + right;
				length--;
	}
	return anagram;
	}
}
