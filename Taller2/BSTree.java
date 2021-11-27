/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Taller2;

/**
 *
 * @author nicoa
 */
public class BSTree {
    
    private BSTNode root; 

    
    public BSTree() { this.root = null; }
    public void setRoot(BSTNode root) { this.root = root; }
    public BSTNode getRoot() { return this.root; }

    
    public void inorderTreeWalk(BSTNode node) {
        if(node == null) {
            return;
        }
        inorderTreeWalk(node.getLeftChild());
        System.out.print(node.getKey() + " ");
        inorderTreeWalk(node.getRightChild());
    }

    

   

    
    public BSTNode searchNode(String key) {
        BSTNode temp = this.root;
        while(temp != null && !temp.getKey().equals(key)) {
            if(key.compareTo(temp.getKey()) <= 0) {
                temp = temp.getLeftChild();
            } else {
                temp = temp.getRightChild();
            }
        }
        return temp;
    }
    

    
    private BSTNode helpFindSuccessor(BSTNode node) {
        if(node == null) {
            return null;
        }
        while(node.getLeftChild() != null) {
            node = node.getLeftChild();
        }
        return node;
    }

    
    public BSTNode getSuccessor(String key) {
        BSTNode node = searchNode(key);
        if(node == null) {
            return null;
        }
        if(node.getRightChild() != null) {
            return helpFindSuccessor(node.getRightChild());
        }
        BSTNode successorNode = node.getParent();
        while(successorNode != null && successorNode.getLeftChild() != node) {
            node = successorNode;
            successorNode = successorNode.getParent();
        }
        return successorNode;
    }

  
    private BSTNode helpFindPredecessor(BSTNode node) {
        if(node == null) {
            return null;
        }
        while(node.getRightChild() != null) {
            node = node.getRightChild();
        }
        return node;
    }

    
    public BSTNode getPredecessor(String key) {
        BSTNode node = searchNode(key);
        if(node == null) {
            return null;
        }
        if(node.getLeftChild() != null) {
            return helpFindPredecessor(node.getLeftChild());
        }
        BSTNode predecessorNode = node.getParent();
        while(predecessorNode != null && node != predecessorNode.getRightChild()) {
            node = predecessorNode;
            predecessorNode = predecessorNode.getParent();
        }
        return predecessorNode;
    }

    
    public void insertNode(String value) {
       
        BSTNode node = new BSTNode();
        node.setKey(value);
        node.setParent(null);
        node.setLeftChild(null);
        node.setRightChild(null);

        
        if(this.root == null) {
            this.root = node;
        } else {
            BSTNode parentNode = null;
            BSTNode temp = this.root;
            while(temp != null) {
                parentNode = temp;
                int compareValue = node.getKey().compareTo(temp.getKey());
                if(compareValue <= 0) {
                    temp = temp.getLeftChild();
                } else {
                    temp = temp.getRightChild();
                }
            }

           
            node.setParent(parentNode);
            if(node.getKey().compareTo(parentNode.getKey()) <= 0) {
                parentNode.setLeftChild(node);
            } else {
                parentNode.setRightChild(node);
            }
        }
    }

    
    public void deleteNode(BSTNode node) {
       
        if(node == null) {
            return;
        }

       
        if(node.getLeftChild() == null && node.getRightChild() == null) {
            BSTNode parentNode = node.getParent();
           
            if(parentNode == null) {
                this.root = null;
            } else if (parentNode.getLeftChild() == node) {
                parentNode.setLeftChild(null );
            } else {
                parentNode.setRightChild(null);
            }
            node.setParent(null);
        }

        
        if(node.getLeftChild() != null && node.getRightChild() == null) {
            BSTNode parentNode = node.getParent();
            
            if(parentNode == null) {
                this.root = node.getLeftChild();
            } else {
               
                if(parentNode.getLeftChild() == node) {
                    parentNode.setLeftChild(node.getLeftChild());
                } else {
                    parentNode.setRightChild(node.getLeftChild());
                }
            }
            node.getLeftChild().setParent(parentNode);
            node.setParent(null);
            node.setLeftChild(null);
        }

        if(node.getLeftChild() == null && node.getRightChild() != null) {
            BSTNode parentNode = node.getParent();
            
            if(parentNode == null) {
                this.root = node.getRightChild();
            } else {
                
                if(parentNode.getLeftChild() == node) {
                    parentNode.setLeftChild(node.getRightChild());
                } else {
                    parentNode.setRightChild(node.getRightChild());
                }
            }
            node.getRightChild().setParent(parentNode);
            node.setParent(null);
            node.setRightChild(null);
        }

       
        if(node.getLeftChild() != null && node.getRightChild() != null) {
            BSTNode parentNode = node.getParent();

            
            BSTNode successorNode = getSuccessor(node.getKey());
            BSTNode successorParent = successorNode.getParent();
            BSTNode successorRightChild = successorNode.getRightChild();

            
            if(successorRightChild == null) {
                node.setKey(successorNode.getKey());
                if(successorParent.getRightChild() == successorNode) {
                    successorParent.setRightChild(null);
                } else {
                    successorParent.setLeftChild(null);
                }
                return;
            } else {
                node.setKey(successorNode.getKey());
                if(successorParent.getRightChild() == successorNode) {
                    successorParent.setRightChild(successorRightChild);
                } else {
                    successorParent.setLeftChild(successorRightChild);
                }
            }
            successorRightChild.setParent(successorParent);
            successorNode.setParent(null);
            successorNode.setLeftChild(null);
            successorNode.setRightChild(null);
        }
    }
}

