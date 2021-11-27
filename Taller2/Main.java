/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Taller2;
import java.io.*;
import java.util.*;
import java.util.Scanner;

/**
 *
 * @author nicoa
 */
 class BinarySearchTree {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int value;
       
        BSTree tree = new BSTree();
        tree.insertNode("D");
        tree.insertNode("B");
        tree.insertNode("C");
        tree.insertNode("A");
        tree.insertNode("F");
        tree.insertNode("G");
        tree.insertNode("E");
        tree.insertNode("I");
        tree.insertNode("H");
        tree.insertNode("J");
        tree.insertNode("L");
        tree.insertNode("K");
        tree.insertNode("M");
        tree.insertNode("N");
        tree.insertNode("Ñ");
        tree.insertNode("O");
        tree.insertNode("P");
        tree.insertNode("Q");
        tree.insertNode("R");
        tree.insertNode("S");
        tree.insertNode("T");
        tree.insertNode("U");
        tree.insertNode("V");
        tree.insertNode("W");
        tree.insertNode("X");
        tree.insertNode("Y");
        tree.insertNode("Z");
        System.out.println("");
        
         
            {
            
        
        
        
        while(true)
         {
         System.out.print("Introduzca la letra de la accion, ");
         System.out.print("mostrar, buscar, eliminar, o InOrder ");
         int choice = getChar();
         switch(choice)
         {
              case 'i':
                  System.out.println("Inorder : ");
                  tree.inorderTreeWalk(tree.getRoot());
                  System.out.println();
                  break;
                   case 'e':
                       System.out.print("Elija la letra que quiera eliminar");
                       tree.deleteNode(tree.searchNode(""));
                       System.out.println("Orden despues de ya eliminada la letra : ");
                       tree.inorderTreeWalk(tree.getRoot());
                       System.out.println();
                       break;
                   case 'b':
                       System.out.print("Nombre:   ");
                       System.out.println("Significado:  ");
                       System.out.println("Clasificacion: ");
                       break;
                   default:
                       System.out.println("Ingrese otro por favor");
                       
                       
         }
                       
            {
               
    }
         }
            }
    }

    private static int getChar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
 }
       
    
