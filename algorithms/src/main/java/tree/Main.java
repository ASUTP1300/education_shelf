package src.main.java.tree;

public class Main {

    //20, 1, 4,12, 88, 30, 32, 20, 11, 8


    //
    //  .20
    // /.  \
    //1.    88
    //  \
    //   4
    //     \
    //      12
    public static void main(String[] args) {
        int[] arr = {20, 1, 4,12, 88, 30, 32, 20, 11, 8, -1};

        Node node0 = new Node(0);

        for (int j : arr) {

            setApple(new Node(j), node0);
        }

        System.out.println(node0);
    }

    static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return  "Node{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}' + "\n";
        }
    }

    static void setApple(Node newer, Node current) {
         if (newer.val > current.val){
             if (current.right == null) {
                 current.right = newer;
             } else {
                 setApple(newer, current.right);
             }
            } else  {
                if (current.left == null) {
                    current.left = newer;
                } else {
                    setApple(newer, current.left);
                }
            }

        }

}
