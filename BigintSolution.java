package testing;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class BigintSolution {   // change class name to Solution

	 // defining my own compare class that will override compare logic
    static class MyCompareClass implements Comparator<String> {
        
        // giving our own logic to the by overriding compare to method
        @Override
        public int compare(String s1, String s2) { //taking two strings
            //sorting based on length of two string 
            //if num is small then its length will also be small
            if (s1.length() < s2.length())
                return -1;
            if (s1.length() > s2.length())
                return 1;
            
            // if two strings having same length ... then compare char by char
            // means digit by digit
            for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i) < s2.charAt(i))
                    return -1;
                if (s1.charAt(i) > s2.charAt(i))
                    return 1;
            }
            // if both strings are replica of each other
            return 0;
        }
    }

    public static String[] bigSorting(String[] unsorted) {
        
        //invoking overloaded sort method and passing our own comparator logic
        Arrays.sort(unsorted, new MyCompareClass());
        return unsorted;

    }

    public static void main(String[] args) {        
        
    	try(Scanner sc = new Scanner(System.in)){
    		int n = sc.nextInt();
    		String[] unsorted = new String[n];
    		for(int i = 0; i < n; i++) unsorted[i] = sc.next();
    		bigSorting(unsorted);
    		for(String s : unsorted){
    			System.out.println(s);
    		}
    	}
       
    }

}
