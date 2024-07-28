package Arboles;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree<E> {

    private BinaryTreeNode<E> root;

    public BinaryTree(E rootContent) {
        this.root = new BinaryTreeNode<>(rootContent);
    }

    public E getRootContent() {
        return this.root.getContent();
    }

    @Override
    public String toString() {
        return ""+ root + "";
    }

    
    public BinaryTree() {
        this.root = null;
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    public void setRootContent(E content) {
        this.root = new BinaryTreeNode<>(content);
    }

    public BinaryTreeNode<E> getRoot() {
        return root;
    }

    private void setRoot(BinaryTreeNode<E> root) {
        this.root = root;
    }
    
    public boolean isLeaf(){
        if(this.isEmpty()) return false;
        else if(this.getRootContent()!=null && this.getRight()== null && this.getLeft() == null) return true;
        return false;
    }

    public void setLeft(BinaryTree<E> tree) {
        this.root.setLeft(tree);
    }

    public void setRight(BinaryTree<E> tree) {
        this.root.setRight(tree);
    }

    public BinaryTree<E> getLeft() {
        return this.root.getLeft();
    }

    public BinaryTree<E> getRight() {
        return this.root.getRight();
    }

    public LinkedList<E> preOrderTraversalRecursive() {
        LinkedList<E> traversal = new LinkedList<>();
        if (!this.isEmpty()) {
            traversal.add(this.getRootContent());
        }
        if (this.getLeft() != null) {
            traversal.addAll(this.getLeft().preOrderTraversalRecursive());
        }
        if (this.getRight() != null) {
            traversal.addAll(this.getRight().preOrderTraversalRecursive());
        }
        return traversal;
    }

    public LinkedList<E> preOrderTraversalIterative() {
        LinkedList<E> traversal = new LinkedList<>();
        Stack<BinaryTree<E>> s = new Stack<>();
        s.push(this);
        while (!s.isEmpty()) {
            BinaryTree<E> tree = s.pop();
            if (!tree.isEmpty()) {
                traversal.add(tree.getRootContent());
            }
            if (tree.getRight()!= null && !tree.getRight().isEmpty()) {
                s.push(tree.getRight());
            }
            if (tree.getLeft() != null && !tree.getLeft().isEmpty()) {
                s.push(tree.getLeft());
            }
        }
        return traversal;
    }
    
    
    public LinkedList<E> breadthTraversal() {
        LinkedList<E> traversal = new LinkedList<>();
        Queue<BinaryTree<E>> q = new LinkedList<>();
        q.offer(this);
        while (!q.isEmpty()) {
            BinaryTree<E> tree = q.poll();
            if (!tree.isEmpty()) {
                traversal.add(tree.getRootContent());
            }
            if (tree.getLeft() != null && !tree.getLeft().isEmpty()) {
                q.offer(tree.getLeft());
            }
            if (tree.getRight()!= null && !tree.getRight().isEmpty()) {
                q.offer(tree.getRight());
            }
        }
        return traversal;
    }
    
    public int countLevelsRecursive(){
        if(isEmpty()){
            return 0;
        }
        if(isLeaf()){
            return 1;
        }
        int maxLevelLeft=0;
        int maxLevelRight=0;
        
        if(getLeft()!=null){
            maxLevelLeft=getLeft().countLevelsRecursive();
        }
        if(getRight()!=null){
            maxLevelRight=getRight().countLevelsRecursive();
        }
        return Math.max(maxLevelLeft,maxLevelRight)+1;
    }
    
    public String showLeaf(){
        if(this.isLeaf()){
            System.out.println(this.getRootContent());
            return this.getRootContent().toString();
        }else
            if(this.root.getLeft() !=null){
                this.root.getLeft().showLeaf();
            }
            if(this.root.getRight() !=null){
                this.root.getRight().showLeaf();
            }
        return null;
    }
    
    public LinkedList<E> showListLeaf(){
        LinkedList<E> hojas = new LinkedList<>();
        
        if(this.isLeaf()){
            hojas.add(this.getRootContent());
        }
        if(this.root.getLeft() !=null){
            this.root.getLeft().showListLeaf();
        }
        if(this.root.getRight() !=null){
             this.root.getRight().showListLeaf();
            }
        return hojas;
    }
    public void showLeaft(){
        if(this.isLeaf()){
            System.out.println(this.getRootContent());
        }else
            if(this.root.getLeft() !=null){
                this.root.getLeft().showLeaf();
            }
            if(this.root.getRight() !=null){
                this.root.getRight().showLeaf();
            }
    }
}
