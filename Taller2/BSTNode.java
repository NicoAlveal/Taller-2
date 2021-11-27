/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Taller2;

/**
 *
 * @author nicoa
 */
public class BSTNode {
    
 
    private String key;
    private BSTNode parent;
    private BSTNode leftChild;
    private BSTNode rightChild;

    public String getKey() {
        return key;
    }
    public void setKey(String key) {
        this.key = key;
    }

    public BSTNode getParent() {
        return parent;
    }
    public void setParent(BSTNode parent) {
        this.parent = parent;
    }

    public BSTNode getLeftChild() {
        return leftChild;
    }
    public void setLeftChild(BSTNode leftChild) {
        this.leftChild = leftChild;
    }

    public BSTNode getRightChild() {
        return rightChild;
    }
    public void setRightChild(BSTNode rightChild) {
        this.rightChild = rightChild;
    }
}
    


