/*
 *@Author: Oliver Mo
 *Studen id: 500844905
 *
 */
package coe318.lab6;

import java.util.*;

public class Circuit {
    
    ArrayList<Resistor> resistors;
    private static Circuit instance = null;
    /*
    [Note to Self]: getInstance() method is used to make only 1 circuit. Creating a new circuit 
          by using Circuit.getInstance() and addign new resistors will contribut to 
          the fist circuit that used the method. 
            Ex. Circuit C1 = Circuit.getInstance();
                Circuit helloWorld = Circuit.getInstance();
                    //The following is actually the combination of both circuits. 
                    //Referencing either circuit will reference the other. Essentially,
                    //the 1 circuit now has 2 varible names, while using getInstance().
    */
    public static Circuit getInstance()
    {
        if(instance == null)
        {
            instance = new Circuit();
        }
        return instance;
    }
    private Circuit() 
    {
        resistors = new ArrayList();//Set resistors to ArrayList.
    }
    public void add(Resistor r)
    {
        resistors.add(r);//Add resistor to ArrayList
    }
    @Override
    public String toString()//Output all the resistors and their properties in the circuit.
    {
        String out = "";
        for(Resistor i : resistors)
        {
            out += i +"\n";
        }
        return out+"\n";//Auto outputs the circuit information and a new line.
    }
    //Sample Main testing for Circuit functionality
    
    public static void main(String[]args)
    {
         Node n1, n2, n3, n4;
        n1 = new Node();
        n2 = new Node();
        n3 = new Node();
        n4 = new Node();
        
        Resistor r1,r2,r3,r4;
        r1 = new Resistor(30.1, n1, n2);
        r2 = new Resistor(1012.234, n2,n3);

        Circuit cir = Circuit.getInstance();
        
        System.out.println(cir);//Output of circuit cir with resistors r1, r2.
        
        Circuit c =  Circuit.getInstance();//Creating new Circuit c with getInstance() method.
        r3 = new Resistor(50, n4, n2);
        System.out.println("Circuit c Output after adding r3\n"+c);//Outputs the combined circuit of cir & c with resistors r1, r2, r3.
        System.out.println("Circuit cir Output after adding r3 to Circuit c:\n" + cir);
   
        
        Circuit cNew = new Circuit();//Creating new Circuit without getInstance() method.
        r4 = new Resistor(20,n3,n4);
        System.out.println("New Circuit without getInstance()\n"+cNew);//Output a new resistor seperate from cir & c
        System.out.println("Circuit with getInstance()\n"+cir);//Output of instance Circuit
       
    }
}
