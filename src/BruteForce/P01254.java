package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P01254 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input = br.readLine();

        int addIdx = 0;
        int size = input.length();
        int answer = 0;

        while(true){
            boolean isPalindrome = false;
            int addSize = size + addIdx;

            for(int i = 0; i<= addSize / 2;i++ ){
                if(addSize - i > size){
                    isPalindrome = true;
                }else{
                    if(input.charAt(i) == input.charAt(addSize - i - 1)){
                        isPalindrome = true;
                    }else{
                        isPalindrome = false;
                    }
                }

                if(!isPalindrome)break;
            }

            if(isPalindrome){
                answer = addSize;
                break;
            }
            addIdx++;
        }

        System.out.print(answer);
    }
}