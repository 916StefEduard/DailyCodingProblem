import java.util.HashMap;
import java.util.Vector;

class Program{
    public static class Tree{
        int val;
        Tree left, right;
        public Tree(int val){
            this.val = val;
            this.right = null;
            this.left = null;
        }
    }

    public static void preorder(Tree start){
        if(start == null)
            return;
        System.out.print(start.val + " ");
        preorder(start.left);
        preorder(start.right);
    }

    public static int height(Tree start){
        if(start == null)
            return 0;
        return 1 + Math.max(height(start.left),height(start.right));
    }

    public static boolean balanced(Tree start){
        if(start == null)
            return true;
        int left, right;
        left = height(start.left);
        right = height(start.right);
        if(Math.abs(left - right) <= 1 && balanced(start.left) && balanced(start.right)){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        var root = new Tree(1);
        root.left = new Tree(2);
        root.left.right = new Tree(5);
        var balance = balanced(root);
        System.out.print(balance);
    }
}