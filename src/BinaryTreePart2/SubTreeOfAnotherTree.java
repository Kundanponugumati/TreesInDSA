package BinaryTreePart2;

public class SubTreeOfAnotherTree {

    static class Node
    {
        int data;
        Node left;
        Node right;
        public Node(int data)
        {
            this.data= data;
            this.left= null;
            this.right=null;
        }
    }

    static class BinaryTree
    {

    }

    public static boolean check(Node root1, Node root2)
    {
        if(root1 == null)
        {
            return false;
        }
        if(root1.data == root2.data)
        {
            if(isIdentical(root1,root2))
            {
                return true;
            }
        }

        boolean leftRes = check(root1.left,root2);
        boolean rightRes = check(root1.right,root2);
        return  leftRes || rightRes;
    }

    public static boolean isIdentical(Node node , Node subRoot)
    {
        if(node == null && subRoot == null)
        {
            return true;
        }
        else if(node == null || subRoot == null)
        {
            return false;
        }

        if(!isIdentical(node.left , subRoot.left))
        {
            return false;
        }
        if(!isIdentical(node.right,subRoot.right))
        {
            return false;
        }
        return true;
    }
    public static void main(String[] args)
    {
        Node newNode1 = new Node(1);
        newNode1.left = new Node(2);
        newNode1.right = new Node(3);
        newNode1.left.left = new Node(4);
        newNode1.left.right = new Node(5);
        newNode1.right.right = new Node(6);

        Node newNode2 = new Node(2);
        newNode2.left = new Node(4);
        newNode2.right = new Node(5);
//        newNode2.right.right = new Node(5);

        System.out.print(check(newNode1, newNode2));
    }
}
