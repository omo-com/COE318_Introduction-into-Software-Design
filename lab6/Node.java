/*
 *@Author: Oliver Mo
 *Studen id: 500844905
 *
 */
package coe318.lab6;

public class Node {
    
    private int idNum;//private instance varible of node id
    private static int next;//private static instance varible of the next node
    public Node()
    {
        idNum = next;//Since next was not set a value, is automatically 0;
        next = idNum+1;/*Next is incremented by 1. This keeps track of node 
                         number per new node created*/
    }
    @Override
    public String toString()
    {
        return  Integer.toString(idNum);// Outputs the String of the integer node iD
    }
 
    //Sample Main class used to test incrementing nodes.
    public static void main(String[] args)
    {
        Node n1, n2, n3, n4;
        n1 = new Node();
        n2 = new Node();
        n3 = new Node();
        n4 = new Node();
        System.out.println(n1 + "\n" + n2 + "\n" + n3 + "\n" + n4);
    }
}
