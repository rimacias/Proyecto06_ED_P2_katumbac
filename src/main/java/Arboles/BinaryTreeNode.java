package Arboles;

public class BinaryTreeNode<E> {
    
    private E content;
    private BinaryTree<E> left;
    private BinaryTree<E> right;
    private boolean isVisited;

    public BinaryTreeNode(E content) {
        this.content = content;
        this.left = null;
        this.right = null;
    }

    public BinaryTreeNode(E content, BinaryTree<E> left, BinaryTree<E> right) {
        this.content = content;
        this.left = left;
        this.right = right;
        isVisited = false;
    }

    public E getContent() {
        return content;
    }

    public void setContent(E content) {
        this.content = content;
    }

    public BinaryTree<E> getLeft() {
        return left;
    }

    public void setLeft(BinaryTree<E> left) {
        this.left = left;
    }

    public BinaryTree<E> getRight() {
        return right;
    }

    public void setRight(BinaryTree<E> right) {
        this.right = right;
    }
    
    public boolean getIsVisited() {
        return isVisited;
    }

    public void setIsVisited(boolean isVisited) {
        this.isVisited = isVisited;
    }
    
}
