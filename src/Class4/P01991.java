package Class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P01991 {

    static int N;
    static List<List<Node>> list;
    static StringBuilder sb = new StringBuilder();

    static class Node{
        int left;
        int right;

        public Node(int left, int right){
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N  = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        for(int i=0;i<=N;i++){
            list.add(new ArrayList<>());
        }

        for(int i=1;i<=N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int data = st.nextToken().charAt(0) - 'A' + 1;
            int left = st.nextToken().charAt(0) - 'A' + 1;
            int right = st.nextToken().charAt(0) -'A' + 1;

            list.get(data).add(new Node(left, right));
        }

        preorder(1);
        sb.append("\n");
        inorder(1);
        sb.append("\n");
        postorder(1);
        sb.append("\n");

        System.out.print(sb);
    }

    static void preorder(int start){
        for(Node node : list.get(start)){
            int l = node.left;
            int r = node.right;

            sb.append((char)(start + 'A' -1));
            if(l != -18) preorder(l);
            if(r != -18) preorder(r);
        }
    }

    static void inorder(int start){
        for(Node node : list.get(start)){
            int l = node.left;
            int r = node.right;

            if(l != -18)inorder(l);
            sb.append((char)(start+'A'-1));
            if(r!=-18)inorder(r);
        }
    }

    static void postorder(int start){
        for(Node node : list.get(start)){
            int l = node.left;
            int r = node.right;

            if(l != -18)postorder(l);
            if(r!=-18)postorder(r);
            sb.append((char)(start+'A'-1));
        }
    }
}
