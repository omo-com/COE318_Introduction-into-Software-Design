/*
 *@Author: Oliver Mo
 *Studen id: 500844905
 *
 */
package coe318.lab7;

import java.util.Scanner;
import java.util.ArrayList;

public class UI implements UserInterface {
    //Instance variable for the circuit.
    Circuit c = Circuit.getInstance();
     //Take user input
    private Scanner user = new Scanner(System.in);
    
    //Instance varibles to keep track of user inputs
    private String component;
    private double magnitude;
    private int n1,n2;
    private boolean isDone = false;//Boolean varible to end the program.
    
    //ArrayList to add nodes as the program runs.
    ArrayList<Node> node = new ArrayList();
    @Override
    public void promptUser()
    {
        System.out.println("Add Component to circuit by using [v] as voltage or [r] as resistor followed by magnitude and two nodes:\nEx: v 0 1 -30.0");
        System.out.println("Display Circuit: [spice]\nEnd Program: [end]");
        do{
            /*Takes first input form user.
              Make the input lowercase for more dynamic and forgiving inputs.
            */
            component = user.next().toLowerCase();
            /*
              Checks if the user is making input for resistor or voltage source.
            */
            if((component.equals("v"))||(component.equals("r")))
            {
                n1 = user.nextInt();
                n2 = user.nextInt();
                magnitude = user.nextDouble();
                if(n1<0 ||n2<0)//Null nodes execption.
            {
                throw new IllegalArgumentException("Nodes cannot be negative");
            }
               /*Creates new nodes equal to the high node inputed by the user in n1 or n2.
                 This allows the user to input the nodes in any order they would like, instead of incremental nodes 
                 from 0 to the limit.
                 Ex. V 30 3 0
                    The following can be implemented as the first voltage source. This results in creating 4 nodes, 
                    0 to 3 because n1 was initialized as 3.
                */
                while(node.size()<=n1||node.size()<=n2)
                {
                    node.add(new Node());
                }
                /*Compares the first component the user inputed. 
                  Adds voltage source to circuit if v.
                  Adds resistor to circuit if r.
                */
                if(component.equals("v"))
                {
                    //Adds voltage source to circuit using inputed magnitude, and nodes at index n1 and n2.
                    new VoltageSource(magnitude,node.get(n1),node.get(n2));
                }
                else if(component.equals("r"))
                {
                    //Adds resistor to circuit using inputed magnitude, and nodes at index n1 and n2.
                    new Resistor(magnitude,node.get(n1),node.get(n2));
                }
            }
            //If user inputed spice, runs spice method.
            else if(component.equals("spice"))
            {
                spice();
            }
            //If user inputed End.
            else if(component.equals("end"))
            {
                    //When user inputs end, displays nothing. 
                end();
            }
            //if User does not input spice, end, v or r. Displays error message and ask user for input again once loop runs.
            else
            {
                System.out.println("Please enter something valid!");
            }
        }while(!isDone);//Continues to run while loop until user wishes for program to end.
    }
    //Displays the whole circuit.
    @Override
    public void spice()
    {
        System.out.print(c);
    }
    //Displays All Done when user wants program to end.
    @Override
    public void end()
    {
        System.out.println("All Done");
        isDone = true;
    }
}
