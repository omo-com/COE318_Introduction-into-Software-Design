/*
 *@Author: Oliver Mo
 *Studen id: 500844905
 *
 */

package coe318.lab7;

//The following Class was adopted from coe318 lab 6 by the same Author

public class Resistor {

    private int resistIdNum;//Private instance varible of resistor number
    private static int next =1;//Private static varible of next reistor number
    double resistance;
    Node []  node = new Node[2];
    
    public Resistor(double resistance, Node node1, Node node2)
    {
        if(resistance >= 0)
        {
        this.resistance = resistance;
            if(node1 == null ||node2 == null)//Null nodes execption.
            {
            throw new IllegalArgumentException("Nodes can not be null");
            }else
            {
            node[0] = node1;
            node[1] = node2;
            }
        resistIdNum = next;//Set resistance number
        next = resistIdNum + 1;//Set the next resistance number
        }
        else//Negative resistance exception.
        {
            throw new IllegalArgumentException("Resistance can not be negative");
        }
        Circuit.getInstance().addResistor(this);//Adds the resistor to the instance circuit. This is allowed because Circuit is simpleton (instance).
    }
    
    /*
    getNodes() returns the node array of the newly created Resistor
    */
    public Node [] getNodes()
    {
        return node;
    }
    
    /*
    Prints the String of the Resistor in the format:
    ex. R1 0 1 30.0(Ohm Symbol)
    - R stands for Resistor
    - Where first integer is Resistor ID number
    - Second & Third integer: node id numbers
    - Magnitude of voltage 
    - Ohms Symbole autmatically printed
    */
    @Override
    public String toString()
    {
        String out;
        out = "R" + Integer.toString(resistIdNum);
        out += " " + getNodes()[0]+ " " + getNodes()[1];
        out += " " + Double.toString(resistance) + "\u2126";// Reistor display and symbol
        return out;
    }
}