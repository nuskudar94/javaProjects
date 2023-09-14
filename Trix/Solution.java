class Solution {
    public static boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        System.out.println(s);
        String s1="";
        for(int i=s.length()-1;i>=0;i--){
         s1=s1 + s.charAt(i);
        }
        System.out.println(s1);
        boolean bool=true;

        // if(x > 10 ){
        //     if(s.equals(s1)){
        //         bool=true;
        //     }
        // }else if(x>=0 && x<=9){
        //         if (s==s1){
        //         bool=true;
        //         }   
        // }else{
        //         bool=false;
        // }

        if(s.equals(s1)){
            bool=true;
        }else{
            bool=false;
        }

        return bool;
    }

    public static void main(String[] args){

        System.out.println(isPalindrome(100));
    }
}