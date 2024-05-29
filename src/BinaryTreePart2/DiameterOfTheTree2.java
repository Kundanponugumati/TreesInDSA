package BinaryTreePart2;

public class DiameterOfTheTree2 {
    static class Node
    {
        int data;
        Node left;
        Node right;
        public Node(int data)
        {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    static class Info
    {
        int dia;
        int height;
        public Info(int dia,int height)
        {
            this.dia = dia;
            this.height= height;
        }
    }

    public static Info diameter(Node root)
    {
        if(root==null)
            return new Info(0,0);
        Info linfo = diameter(root.left);
        Info rinfo = diameter(root.right);
        int self = linfo.height+rinfo.height+1;
        int ldia = linfo.dia;
        int rdia = rinfo.dia;
        int dia = Math.max(self,Math.max(ldia,rdia));
        int height = Math.max(linfo.height,rinfo.height)+1;
        return new Info(dia,height);

    }

    public static void main(String[] args)
    {
        Node newNode = new Node(1);
        newNode.left = new Node(2);
        newNode.right = new Node(3);
        newNode.left.left = new Node(4);
        newNode.left.right = new Node(5);
        newNode.right.right = new Node(6);
        System.out.println(diameter(newNode).dia);
    }
}
