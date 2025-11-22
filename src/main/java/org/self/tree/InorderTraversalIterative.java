package org.self.tree;

import java.util.Stack;

public class InorderTraversalIterative {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(6);
        root.left.right.right = new Node(7);
        root.right = new Node(3);

        inOrderTraversal(root);
    }

    public static void inOrderTraversal(Node node){

        Stack<Node> s = new Stack<>();
//        s.push(node);

        while(node != null || !s.isEmpty()){

            while(node != null){
                s.push(node);
                node = node.left;
            }

            node = s.pop();
            System.out.println(node.data);
            node = node.right;
        }




    }
}
