package Misc;

import java.util.HashMap;
import java.util.HashSet;

public class Misc {

    //Find the smallest number whose sum of digits is N
    public static int smallestSumOfDigits(int N) {
        //int n = N/9;
        String s = N%9 + "9".repeat(N/9);
        return Integer.parseInt(s);
    }

    //modify string so that it is balanced where, As are on the left and Bs are on the right. return minimum number of deletions needed to do that
    public static int newBalancedString(String S) {
        int leftB[] = new int[S.length()];
        int rightA[] = new int[S.length()];

        //populate arrays to know number of A to the right and Bs to the left of an index
        int b = 0, a = 0;
        for (int i = 0, j = S.length() - 1; i < S.length(); i++, j--) {
            leftB[i] = b;
            rightA[j] = a;
            if (S.charAt(i) == 'B') b++;
            if (S.charAt(j) == 'A') a++;
        }

        int minLetters = S.length();
        for (int i = 0; i < S.length(); i++) {
            minLetters = Math.min(minLetters, leftB[i] + rightA[i]);
        }

        return minLetters;
    }

    //generate string with AA, BB, AB so that AAA, BBB sequence can not get generated where frequency of AA, BB and CC is given
    public static String newString(int AA, int BB, int AB) {
        String result = "";
        if (AA >= BB) {
            //Use all BB and as many AA possible
            while (BB > 0) {
                result+= "AABB";
                BB--;
                AA--;
            }
            while (AB > 0) {
                //As last char will be B we can add all ABs at the end
                result += "AB";
                AB--;
            }

            //Since there are AAs left and last char is B we can add one more AA at the end
            if (AA > 0) {
                result += "AA";
            }
        } else if (BB > AA) {
            //Use all AAs and as many BBs possible
            while (AA > 0) {
                result += "AABB";
                AA--;
                BB--;
            }
            while (AB > 0) {
                //As last character will be B we can consume all ABs
                result += "AB";
                AB--;
            }

            //Since there are BBs left and last char is B and first char is A we can add one more BB at the start
            if (BB > 0) {
                result = "BB" + result;
                BB--;
            }
        }
        return result;
    }

    //Check if arr2 is subset of arr1
    public static boolean IsSubset(int[] array1, int[] array2) {
        //HashMap<String,String> map = new HashMap<>();

        boolean ret = true;
        HashSet set = new HashSet();
        for(int a:array1) {
            set.add(a);
        }

        for(int a: array2) {
            if(!set.contains(a)) {
                ret = false;
                break;
            }
        }

        // Replace this placeholder return statement with your code
        return ret;
    }


    public static void main(String[] args) {
        //int[] arr1 = {42};
        //int[] arr2 = {42};
        //System.out.println(IsSubset(arr1,arr2));
        //System.out.println(newString(5,2,0));
        //System.out.println(newString(1,1,2));
        //System.out.println(newString(0,0,2));
        //System.out.println(newString(0,10,0));
        //System.out.println(newString(1,1,2));
        for (int i = 0; i < 51; i++) {
            System.out.println(i + " = " + smallestSumOfDigits(i));
        }

    }
}
