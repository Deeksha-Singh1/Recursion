package RecursionPractice;

import java.util.HashSet;

public class Recursion {


    public static void printDecreasing(int n) {
        if (n == 0) {

            return;
        }

        printDecreasing(n - 1);
        System.out.println(n);

    }

    public static int fact(int n) {
        if (n == 2) {
            return 1;
        }
        return n * fact(n - 1);
    }

    public static void fib(int a, int b, int n) {
        if (n == 0) {
            return;
        }
        int c = a + b;
        System.out.println(c);
        fib(b, c, n - 1);
    }

    public static int pow(int n, int x) {
        if (x == 0) {
            return 1;
        }
        return n * pow(n, x - 1);
    }

    public static int powInLog(int n, int x) {
        if (n == 0) {
            return 0;
        }
        if (x == 0) {
            return 1;
        }
        //if power is even
        if (x % 2 == 0) {
            return powInLog(n, x / 2) * powInLog(n, x / 2);
        }
        //if power is odd
        else {
            return powInLog(n, x / 2) * powInLog(n, x / 2) * n;
        }
    }

    public static void TOH(int n, String src, String helper, String dest) {
        if (n == 1) {
            System.out.println("Disk number " + n + " transfered from " + src + " to " + dest);
            return;
        }

        TOH(n - 1, src, dest, helper);
        System.out.println("Disk number " + n + " transfered from " + src + " to " + dest);
        TOH(n - 1, helper, src, dest);


    }

    public static void reverseString(String s, int index) {
        if (index == s.length() - 1) {
            System.out.print(s.charAt(index));
            return;
        }
        reverseString(s, index + 1);
        System.out.print(s.charAt(index));
    }

    public static int firstOcc = -1;
    public static int lastOcc = -1;

    public static void FirstLastOccurrence(String str, int index, char ele) {

        if (index == str.length()) {
            System.out.println(firstOcc);
            System.out.println(lastOcc);
            return;
        }
        char currOcc = str.charAt(index);
        if (currOcc == ele) {
            if (firstOcc == -1) {
                firstOcc = index;
            } else
                lastOcc = index;
        }

        FirstLastOccurrence(str, index + 1, ele);
    }

    public static boolean isSorted(int[] arr, int idx) {
        if (arr.length == 1 || idx == arr.length - 1) {
            return true;
        }

        if (arr[idx] <= arr[idx + 1]) {
            return isSorted(arr, idx + 1);
        } else
            return false;
    }

    //Move all x to the end of the string
    public static void moveX(String str, int idx, int countOfx, String resStr) {

        if (idx == str.length()) {
            for (int i = 0; i < countOfx; i++) {
                resStr += 'x';
            }
            System.out.println(resStr);
            return;
        }

        char currChar = str.charAt(idx);
        if (currChar == 'x') {
            countOfx++;
            moveX(str, idx + 1, countOfx, resStr);
        } else {
            resStr = resStr + currChar;
            moveX(str, idx + 1, countOfx, resStr);

        }
    }

    public static boolean[] map = new boolean[26];

    public static void removeDuplicates(String str, int idx, String resStr) {

        if (idx == str.length()) {
            System.out.println(resStr);
            return;
        }
        char currChar = str.charAt(idx);

        if (!map[currChar - 'a']) {
            resStr += currChar;
            map[currChar - 'a'] = true;
        }
        removeDuplicates(str, idx + 1, resStr);
    }

    public static void subsequences(String str, int idx, String newStr) {

        if (idx == str.length()) {
            System.out.println(newStr);
            return;
        }

        //call1: char wants to be added
        subsequences(str, idx + 1, newStr + str.charAt(idx));

        //call2: char dont want to be added
        subsequences(str, idx + 1, newStr);
    }

    //unique subsequences of string

    public static void uniqueSubsequences(String str, int idx, String newStr, HashSet<String> set) {

        if (idx == str.length()) {
            if (!set.contains(newStr)) {
                System.out.println(newStr);
                set.add(newStr);
            }
            return;
        }

        //call1: char wants to be added
        uniqueSubsequences(str, idx + 1, newStr + str.charAt(idx), set);

        //call2: char dont want to be added
        uniqueSubsequences(str, idx + 1, newStr, set);
    }

    //keypad combinations
    public static String[] keypad = {".", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"};

    public static void keypadCombinations(String str, int idx, String combination) {

        if (idx == str.length()) {
            System.out.println(combination);
            return;
        }

        char currChar = str.charAt(idx);
        String mapping = keypad[currChar - '0'];

        for (int i = 0; i < mapping.length(); i++) {
            keypadCombinations(str, idx + 1, combination + mapping.charAt(i));
        }
    }

    //permutation
    public static void permutations(String str, String perm) {

        if (str.length() == 0) {
            System.out.println(perm);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            char currChar = str.charAt(i);// "a"
            String newStr = str.substring(0, i) + str.substring(i + 1);//"bc"
            permutations(newStr, perm + currChar);
        }
    }


    //mazePath -> can only move downward and right
    public static int countPathsOfMaze(int i, int j, int n, int m){

        if(i==m || j==n){
            return 0;
        }

        if(i==m-1 && j==n-1 ){
            return 1;
        }

        int downwards=countPathsOfMaze(i+1,j,m,n);
        int right= countPathsOfMaze(i,j+1,m,n);
        return  downwards+right;
    }

    //place tiles of size 1xm ina floor of size nxm


    //Driver function
    public static void main(String[] args) {
        //      int n=7;
        //        int a=0;
        //        int b=1;
        //        System.out.println(a);
        //        System.out.println(b);
        //        fib(a,b,n-2);

        //
        //        System.out.println(pow(2, 3));
        //
        //        System.out.println(powInLog(2, 3));
        //
        //
        //        TOH(3,"src","helper"," destination");
        //
        //        FirstLastOccurrence("hello deeksha",0,'e');

        //        int [] arr={1,2,2,4,5};
        //        System.out.println(isSorted(arr, 0));
        //
        //        moveX(axbcxxd,0,0,"");
        //        removeDuplicates("abbccda",0,"");

        //        subsequences("aaa",0,"");
        //        System.out.println("---------------");
        //        uniqueSubsequences("aaa",0,"",new HashSet<String>());
        //        keypadCombinations("23",0,"");
        //        permutations("abc","");
        System.out.println(countPathsOfMaze(0, 0, 3, 3));


    }

}
