import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;


public class Runner {
	static ArrayList<String> words = new ArrayList<String>();
	
		public static void consecutiveWords(String word) {
			words = new ArrayList<String>();
			Scanner scanner;
			File f = new File("ToKillAMockingbird.txt");
			try {
				scanner = new Scanner(f);
			
				for(int i = 0; i < 11; i++) {
					scanner.nextLine();
				}
				int c = 0;
				while(scanner.hasNextLine()) {
					String currLine = scanner.nextLine();
					String[] line = currLine.split(" ");
					//System.out.println(currLine);
					for(int i = 0; i < line.length; i++) {

						String temp = line[i];
						temp = temp.replaceAll("[^a-zA-Z]+$", "");
						temp = temp.replaceFirst("^[^a-zA-Z]+", "");
						temp = temp.toLowerCase();
						//System.out.println(temp);
						if(temp.equals(word)) {
							String t = "";
							if(i == line.length-1) {
								String tempLine = scanner.nextLine();
								String[] arline = tempLine.split(" ");
								t = arline[0];
							} else {
								t = line[i+1];
							}
							t = t.replaceAll("[^a-zA-Z]+$", "");
							t = t.replaceFirst("^[^a-zA-Z]+", "");
							words.add(t);
						}



					}
					c++;
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//creating File instance to reference text file in Java
		String word = "he";
		for(int i = 0; i < words.size(); i++) {
			//System.out.println(words.get(i));
		}
		//System.out.println(findFrequentWord(words));
		//System.out.println(sentence());
		
		String sentence = "";
		
		
//		consecutiveWords("was");
//		int ran4 = (int)(Math.random()*words.size());
//		sentence += words.get(ran4) +" ";
//		consecutiveWords("the");
//		int ran = (int)(Math.random()*words.size());
//		sentence += words.get(ran) +" ";
//		
//		consecutiveWords("she");
//		int ran2 = (int)(Math.random()*words.size());
//		sentence += words.get(ran2) +" ";
//		
//		consecutiveWords("a");
//		int ran3 = (int)(Math.random()*words.size());
//		sentence += words.get(ran3) +" ";
//		System.out.println(sentence);
		
		//consecutiveWords(word);
		/**/
		Scanner scanner;
		File f = new File("ToKillAMockingbird.txt");
		try {
			scanner = new Scanner(f);
			
			for(int i = 0; i < 11; i++) {
				scanner.nextLine();
			}
			int end = (int)(Math.random()*10 + 2);
			int c = 0;
			while(scanner.hasNextLine() && c < end) {
				int random = (int)(Math.random()*20);
				for(int i = 0; i < random; i++) {
					scanner.nextLine();
				}
				String currLine = scanner.nextLine();
				String[] line = currLine.split(" ");
				//System.out.println(currLine);
				
				int ran = (int)(Math.random()*line.length-1);
				int r = (int)(Math.random()*3);
//				sentence += words.get(ran) +" ";
				String s = "";
				for(int i = 0; i < line.length; i++) {
					int j = 0;
					s = line[ran];
					s = s.replaceFirst("^[^a-zA-Z]+", "");
					s = s.replaceAll("[^a-zA-Z]+$", "");
					while(j < r && r < line.length) {
						
						j++;
					}
				}
				sentence += s+" ";
				
				c ++;

			}
			
			System.out.println(sentence);

			//String str = "...Welcome???@@##$ to#$% Geeks%$^for$%^&Geek's";

	        // similar to Matcher.replaceAll
	        //str = str.replaceAll("\\p{Punct}","");
	        //System.out.println(str);
			//System.out.println(str.replaceFirst("^[^a-zA-Z]+", "")); // ^ means !=
		    //System.out.println(str.replaceAll("[^a-zA-Z]+$", "")); //$ means at the end of the string

	        
				
			

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static String sentence() {
		String sentence = "";
		
		int length = (int)(Math.random()*9+2);
		for(int i = 0; i < length; i++) {
			int ran = (int)(Math.random()*words.size());
			sentence += words.get(ran) +" ";
		}
		
		return sentence;
	}
	
	
	private static String findFrequentWord(ArrayList<String> list) {

        //create a hashmap to store the count of each element . key is number and value is count for the number
        HashMap<String, Integer> wordsMap = new HashMap<>();
        String result = ""; //result will hold the most frequent element for the given array
        int frequency = -1; //frequency is the count for the most frequent element

        int value;

        for (int i = 0; i < list.size(); i++) { //scan all elements of the array one by one
	        	value = -1;
            // set value as -1
            if (wordsMap.containsKey(list.get(i))) {
                value = wordsMap.get(list.get(i)); // if the element is in the map, get the count
            }
            if (value != -1) {
	                // value is not -1 , that means the element is in the map. Increment the value and 
	            	//check if it is greater than the maximum
                value += 1;
                if (value > frequency) {
                    //if the value is greater than frequency, it means it is the maximum value
                    // till now. store it
                    frequency = value;
                    result = list.get(i);
                }
	                wordsMap.put(list.get(i), value); // put the updated value in the map
	         } else {
                //element is not in the map. put it with value or count as 1
            	wordsMap.put(list.get(i), 1);
            }

         }

         if (frequency == 1) {
        	 return "none are the most common";
         }
         return result;
    }


}



			



