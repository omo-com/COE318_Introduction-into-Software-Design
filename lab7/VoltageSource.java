/*
 *@Author: Oliver Mo
 *Studen id: 500844905
 *
 */
package coe318.lab7;

public class VoltageSource {
    
    private int voltageIdNum;//Instance varible of voltage number
    private static int next =1;//Static varible of next voltage number
    double voltage;
    Node []  node = new Node[2];
    
    public VoltageSource(double voltage, Node node1, Node node2)
    {   
        this.voltage = voltage;
        if(node1 == null ||node2 == null)//Null nodes execption.
        {
          throw new IllegalArgumentException("Nodes cannot be null");
        }
        else
        {
            if(voltage <0)//If Voltage source is negative
             {
                this.voltage = -voltage;//Invert voltage to positive
                node[0] = node2;//Rearange the ordering of the nodes
                node[1] = node1;
            }
            else
            {
                node[0] = node1;
                node[1] = node2;
            }
        }
        voltageIdNum = next;//Set voltage number
        next = voltageIdNum + 1;//Set the next voltage number
       Circuit.getInstance().addVoltageSource(this);//Adds Voltage source to circuit. Possible because circuit is simpleton (instance).
    }
    
    /*
    getNodes() returns the node array of the newly created VoltageSource
    */
    public Node [] getNodes()
    {
        return node;
    }
    
    /*
    Prints the String of the Voltage Source in the format:
    ex. V1 0 1 DC 30.0
    - V stands for Voltage Source
    - Where first integer is voltage ID number
    - Second & Third integer: node id numbers
    - DC automatically printed
    - Magnitude of voltage 
    */
    @Override
    public String toString()
    {
        String out;
        out = "V" + Integer.toString(voltageIdNum);
        out += " " + getNodes()[0]+ " " + getNodes()[1];
        out += " DC " + Double.toString(voltage);// Voltage display
        return out;
    }
}
