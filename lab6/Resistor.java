/*
 *@Author: Oliver Mo
 *Studen id: 500844905
 *
 */
package coe318.lab6;

public class Resistor {
    
    private int resistIdNum;//Private instance varible of resistor number
    private static int next =1;//Private static varible of next reistor number
    double resistance;
    private Node []  node = new Node[2];
    
    
    public Resistor(double resistance, Node node1, Node node2)
    {

        if(resistance >= 0)
        {
        this.resistance = resistance;
            if(node1 == null ||node2 == null)//Null nodes execption.
            {
            throw new IllegalArgumentException("Resistance can not be negative");
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
        Circuit.getInstance().add(this);//Adds the resistor to the instance circuit. This is allowed because Circuit is simpleton (instance).
    }
    public Node [] getNodes()
    {
        return node;
    }
    @Override
    public String toString()
    {
        String out;
        out = "R" + Integer.toString(resistIdNum);
        out += " " + getNodes()[0]+ " " + getNodes()[1];
        out += " " + Double.toString(resistance) + "\u2126";// Reistor display and symbol
        return out;
    }
    
    //Sample Main for testing
    
    public static void main (String[]args)
    {   
       Node n1, n2, n3, n4;
        n1 = new Node();
        n2 = new Node();
        n3 = new Node();
        n4 = new Node();
        
        Resistor r1,r2,r3;
        r1 = new Resistor(30.1, n1, n2);
        r2 = new Resistor(1012.234, n2,n3);
        r3 = new Resistor(50, n4, n2);
        System.out.println(r1 + "\n" + r2 +"\n"+r3);
    }
    
    
}
