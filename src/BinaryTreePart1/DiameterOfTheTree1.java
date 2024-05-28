package BinaryTreePart1;

public class DiameterOfTheTree1 {
    static class Node
    {
        int data;
        Node left;
        Node right;
        public Node(int data)
        {
            this.data = data;
            this.left = null;
            this.right= null;
        }
    }

    public static int height(Node root)
    {
        if(root == null)
            return 0;
        int lh = height(root.left);
        int rh = height(root.right);
        return Math.max(lh,rh)+1;
    }

    public static int diameter(Node root)
    {
        if(root==null)
            return 0;
        int ld = diameter(root.left);
        int rd = diameter(root.right);
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        int self = leftHeight+rightHeight+1;
        int max = Math.max(ld,rd);
        return Math.max(max,self);

    }

    public static void main(String[] args)
    {
        Node newNode = new Node(1);
        newNode.left = new Node(2);
        newNode.right = new Node(3);
        newNode.left.left = new Node(4);
        newNode.left.right = new Node(5);
        newNode.right.right = new Node(6);
        System.out.print(diameter(newNode));
    }
}
