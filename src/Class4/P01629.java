package Class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P01629 {

    static long C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        C = Long.parseLong(st.nextToken());

        System.out.print(pow(A,B));
    }

    static long pow(long A, long exponent){
        if(exponent==1){
            return A%C;
        }

        long temp = pow(A,exponent/2);

        if(exponent%2==1){
            return (temp * temp % C) *A %C;
        }

        return temp * temp % C;
    }
}
