/*
 *@Author: Oliver Mo
 *Studen id: 500844905
 *
 */

package coe318.lab7;

//Most of the following Class was adopted from coe318 lab 6 by the same Author

import java.util.ArrayList;

public class Circuit {
    

    ArrayList<Resistor> resistors;//Intialize Arraylist of Resistors
    ArrayList<VoltageSource> voltages;//Intialize Arraylist of VoltageSources
    private static Circuit instance = null;
    
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
        voltages = new ArrayList();//Set voltages to ArrayList.
    }
    /*
    Adds resistor to circuit.
    */
    public void addResistor(Resistor r)
    {
        resistors.add(r);//Add resistor to ArrayList
    }
    /*
    Adds voltage source to circuit.
    */
    public void addVoltageSource(VoltageSource v)
    {
        voltages.add(v);//Add voltage source to ArrayList
    }
    /*
    Displays the to string of the Voltage Sotuces and Resistors in order.
    */
    @Override
    public String toString()//Output all the resistors & voltage sources and their properties in the circuit.
    {
        int i =0;
        String out = "";
        while(i<voltages.size()||i<resistors.size())//Checks if there is a resistor/voltage to output by checking max size.
        {
            if(i<voltages.size())//Checks if there is a voltage source at index i
            {
                out += voltages.get(i) + "\n";//Adds voltage source to the output by calling toString()
            }
            if(i<resistors.size())//Checks if there is a resistor at index i
            {
                out += resistors.get(i) + "\n";//Adds resistor to the output by calling toString()
            }
            i++;
        }
        return out;//Auto outputs the circuit information and a new line.
    }
    
    
    //Sample Main used for testing Circuit outputs.
    /*
    public static void main(String[]args)
    {
        Node n1, n2, n3, n4;
        n1 = new Node();
        n2 = new Node();
        n3 = new Node();
        n4 = new Node();
        
        Resistor r1,r2,r3,r4;

        VoltageSource v1,v2,v3;
        
        Circuit cir = Circuit.getInstance();
        r1 = new Resistor(30.1, n1, n2);
        r2 = new Resistor(1012.234, n2, n3);
        v1 = new VoltageSource(10,n1,n2);
        
        System.out.println(cir+"\n");//Output of circuit cir with resistors r1, r2.
        
        Circuit c =  Circuit.getInstance();//Creating new Circuit c with getInstance() method.
        r3 = new Resistor(50, n4, n2);//Add r3 resistor to the circuit of C
        v2 = new VoltageSource(-8,n4,n3);//Note, if voltage was positive, would be (8, n2, n4)
        System.out.println("Circuit c Output after adding r3\n"+c);//Outputs the combined circuit of cir & c with resistors r1, r2, r3.
        System.out.println("Circuit cir Output after adding r3 to Circuit c:\n" + cir);
        
        Circuit cNew = new Circuit();//Creating new Circuit without getInstance() method.
        r4 = new Resistor(20,n3,n4);
        v3 = new VoltageSource(12,n3,n4);//Add voltage source 3.
        System.out.println("New Circuit without getInstance()\n"+cNew);//Output a new Circuit seperate from cir & c
        System.out.println("New Circuit with getInstance()\n"+cir);//Output of instance Circuit
    }
*/
}
