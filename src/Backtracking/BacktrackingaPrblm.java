package Backtracking;

public class BacktrackingaPrblm {

    public static  void permutations(String str,String permStr, int idx){

       if(str.length()==0 || idx==str.length()){
           System.out.println(permStr);
           return;
       }

        for (int i = 0; i < str.length(); i++) {
            char currChar =  str.charAt(i);
            String newStr =  str.substring(0,i)+ str.substring(i+1);
            permutations(newStr,permStr+currChar,idx+1);

        }

        //n-Queens problem
    }
}
