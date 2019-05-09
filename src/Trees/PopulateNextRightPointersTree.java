package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class PopulateNextRightPointersTree {

    public static void main(String[] args) {

    }

    static void connect(TreeLinkNode root) {

        Queue<TreeLinkNode> queue = new LinkedList<>();
        Queue<TreeLinkNode> queueTwo = new LinkedList<>();

        queue.add(root);

        while(!queue.isEmpty() || !queueTwo.isEmpty()){

            while(!queue.isEmpty()){
                TreeLinkNode node = queue.poll();
                if(node.left != null)
                    queueTwo.add(node.left);
                if(node.right != null)
                    queueTwo.add(node.right);

                if(!queue.isEmpty())
                    node.next = queue.peek();

            }

            while(!queueTwo.isEmpty()){
                TreeLinkNode node = queueTwo.poll();
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);

                if(!queueTwo.isEmpty())
                    node.next = queueTwo.peek();
            }
        }

    }
}
