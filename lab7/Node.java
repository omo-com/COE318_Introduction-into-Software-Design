/*
 *@Author: Oliver Mo
 *Studen id: 500844905
 *
 */

package coe318.lab7;

//The following Class was adopted from coe318 lab 6 by the same Author

public class Node {
    
    private int idNum;//private instance varible of node id
    private static int next;//private static instance varible of the next node
    public Node()
    {
        idNum = next;//Since next was not set a value, is automatically 0;
        next = idNum+1;/*Next is incremented by 1. This keeps track of node 
                         number per new node created*/
    }
    
    /*
    Displays the node id number
    */
    @Override
    public String toString()
    {
        return  Integer.toString(idNum);// Outputs the Strign of the integer node iD
    }
 
}
