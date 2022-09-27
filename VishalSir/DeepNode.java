/*
To ask*/

import java.io.*; // for handling input/output
import java.util.*; // contains Collections framework

// don't change the name of this class
// you can add inner classes if needed
class Main {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
        }
    }

    private static void DepthPrint(Node rootNode,int D){
        if(rootNode==null){
            while(D-->0){
                System.out.print(0+" ");
            }
            return;
        }
        Queue<Node> qu= new LinkedList<>();
        int countCompleted=0;
        qu.add(rootNode);
        while(!qu.isEmpty()){
            System.out.print(qu.size()+" ");
            countCompleted++;
            for(int i=0;i<qu.size();i++){
                Node temp=qu.poll();
                if(temp.left!=null){
                    qu.offer(temp.left);
                }
                if(temp.right!=null){
                    qu.offer(temp.right);
                }
            }
        }
        while(countCompleted++<=D){
            System.out.print(0+" ");
        }
    }
    private static void inorder(Node currentNode){
        if(currentNode==null){
            return ;
        }
        inorder(currentNode.left);
        System.out.print(currentNode.data+" ");
        inorder(currentNode.right);
    }
    public static void main (String[] args) {
        Scanner sc= new Scanner(System.in);
        HashMap<Integer,Node> hm= new HashMap<>();
        int n=sc.nextInt();
        for(int i=1;i<=n;i++){
            Node currentNode;
            if(hm.containsKey(i)){
                currentNode=hm.get(i);
            }else{
                currentNode=new Node(i);
                hm.put(i,currentNode);
            }

            int leftNode=sc.nextInt();
            int rightNode=sc.nextInt();
            if(leftNode!=-1){
                if(!hm.containsKey(leftNode)){
                    currentNode.left=new Node(leftNode);
                    hm.put(leftNode,currentNode.left);
                }else{
                    currentNode.left=hm.get(leftNode);
                }
            }
            if(rightNode!=-1){
                if(!hm.containsKey(rightNode)){
                    currentNode.right=new Node(rightNode);
                    hm.put(rightNode,currentNode.right);
                }else{
                    currentNode.right=hm.get(rightNode);
                }
            }
        }
        //inorder(hm.get(1));
        //System.out.println();
        DepthPrint(hm.get(1),n);
    }
}
