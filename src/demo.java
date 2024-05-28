import java.util.LinkedList;
import java.util.Queue;

public class demo {
    static class Node
    {
        int data;
        Node left;
        Node right;
        public Node(int data)
        {
            this.data= data;
            this.left= null;
            this.right= null;
        }
    }

    static class BinaryTree{
        static int idx=-1;
        public static Node buildTree(int[] nodes)
        {
            idx++;
            if(nodes[idx]==-1)
                return null;
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
        }

        // preOrder
        public static void preOrder(Node root)
        {

            if(root == null) // base condition.
                return;
            System.out.print(root.data+" ");
            preOrder(root.left);
            preOrder(root.right);
        }
        // inOrder
        public static void inOrder(Node root)
        {
            if(root == null)
                return;
            inOrder(root.left);
            System.out.print(root.data+" ");
            inOrder(root.right);
        }
        // postOrder
        public static void postOrder(Node root)
        {
            if(root == null)
                return;
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data+" ");
        }

        public static void levelOrder(Node root)
        {
            if(root==null) {
                return;
            }
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            queue.add(null);
            while(!queue.isEmpty())
            {
                Node currNode = queue.remove();
                if(currNode == null)
                {
                    System.out.println();
                    if(queue.isEmpty()) {
                        break;
                    }
                    else {
                        queue.add(null);
                    }
                }
                else {
                    System.out.print(currNode.data + " ");
                    if(currNode.left!=null) {
                        queue.add(currNode.left);
                    }
                    if(currNode.right!=null) {
                        queue.add(currNode.right);
                    }
                }
            }
        }

        public static int height(Node root)
        {
            if(root == null)
                return 0;
            int lh = height(root.left);
            int rh = height(root.right);
            return  Math.max(lh,rh)+1;
        }

        public static int count(Node root)
        {
            if(root == null)
                return 0;
            int ln = count(root.left);
            int rn = count(root.right);
            return ln+rn+1;
        }
        public static int sum(Node root)
        {
            if(root == null)
                return 0;
            int ls = sum(root.left);
            int rs = sum(root.right);
            return ls+rs+root.data;
        }
    }


    public static void main(String [] args)
    {
        int [] nodes = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        System.out.println(tree.sum(root));
//        tree.preOrder(root);
//        System.out.println();
//        tree.inOrder(root);
//        System.out.println();
//        tree.postOrder(root);
//        System.out.println();
//        tree.levelOrder(root);

    }
}
