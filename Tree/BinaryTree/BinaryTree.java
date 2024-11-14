package Tree.BinaryTree;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

    Node root;
    // int size; Will include this prolly
    
    public BinaryTree()
    {
        root = null; 
    }

    public void insert(int data)
    {
        
        {
            root = insertNode(root, data);
        }
    }

    public Node insertNode(Node root, int data)
    {
        if(root==null)
        {
            root = new Node(data);
        }
        else
        {
            if(data<root.data)
            {
                root.left = insertNode(root.left, data);
            }
            else if (data>root.data)
            {
                root.right = insertNode(root.right, data);
            }
        }
        return root;
    }

    public int[] get_current_node(Node root) //Returns left, root, right values of the current node
    {
        int values[] = {root.left.data,root.data,root.right.data};
        return values;
    }

    public void inorderTraversal(Node root)
    {
        if(root==null)
        {
            return;
        }
        inorderTraversal(root.left);
        System.out.println(root.data);
        inorderTraversal(root.right);
    }
    
    public void preorderTraversal(Node root)
    {
        if(root==null)
        {
            return;
        }
        System.out.println(root.data);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }

    public void postorderTraversal(Node root)
    {
        if(root==null)
        {
            return;
        }
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        System.out.println(root.data);
    }

    public void levelorderTraversal(Node root)
    {
        if(root == null)
        {
            return;
        }
        Queue<Node> binTree = new LinkedList<>();
        binTree.add(root);
        while (!binTree.isEmpty())
        {
            Node currentNode = binTree.poll();
            System.out.println(currentNode.data);
            if(currentNode.left != null)
            {
                binTree.add(currentNode.left);
            }
            if(currentNode.right != null)
            {
                binTree.add(currentNode.right);
            }
        }
    }
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        // Insert nodes
        tree.insert(5);
        tree.insert(3);
        tree.insert(7);
        tree.insert(2);
        tree.insert(4);
        tree.insert(6);
        tree.insert(8);

        System.out.println("Inorder Traversal:");
        tree.inorderTraversal(tree.root); // Expected output: 2 3 4 5 6 7 8
        System.out.println();

        System.out.println("Preorder Traversal:");
        tree.preorderTraversal(tree.root); // Expected output: 5 3 2 4 7 6 8
        System.out.println();

        System.out.println("Postorder Traversal:");
        tree.postorderTraversal(tree.root); // Expected output: 2 4 3 6 8 7 5
        System.out.println();

        System.out.println("Level Order Traversal:");
        tree.levelorderTraversal(tree.root); // Expected output: 5 3 7 2 4 6 8
        System.out.println();

        // Testing get_current_node method
        int[] currentNodeValues = tree.get_current_node(tree.root); // Get values of root node
        System.out.println("Current node (left, root, right): " + 
                           currentNodeValues[0] + ", " + 
                           currentNodeValues[1] + ", " + 
                           currentNodeValues[2]);
    }
}
