/**
 * @author Oliver Mo
 * Student id 500844905
 */
package coe318.lab3;
public class Counter {
    int mod, dig;
    Counter lef;
    public Counter(int modulus, Counter left)//Creating Object of Modulus and counter.
    {
        this.mod = modulus;
        this.lef = left;
    }
    /**
     * @return the modulus
     */
    public int getModulus()//returns the modulus
    {
        return this.mod;
    }
    /**
     * Returns the Counter to the left attached to this
     * Counter.  Returns null if there is no Counter
     * to the left.
     * @return the left
     */
    public Counter getLeft()//returns the left counter
    {
        return this.lef;
    }
    /**
     * @return the digit
     */
    public int getDigit() {
        return this.dig;
    }
    /**
     * @param digit the digit to set
     */
    public void setDigit(int digit)//Sets the digit 
    {
        this.dig = digit;
    }
    /**
     * Increment this counter.  If it rolls over,
     * its left Counter is also incremented if it
     * exists.
     */
    public void increment() 
    {
        setDigit(this.dig+1);//Increases digit by 1. Note: I only did this to use the set digit method...
        if(getDigit() == getModulus())
        {
            this.dig = 0;
            if(this.getLeft() != null)//Checks if the Counter is not null, then Increments that left counter
            {
                this.lef.increment();
            }  
        }
    }
    /** Return the count of this Counter combined
     * with any Counter to its left.
     *
     * @return the count
     */
    public int getCount() 
    {
        if(this.getLeft() != null)//Checks if the counter is not null. (if it contains another counter, then true)
        {
            return getDigit()+ (getModulus())*(this.lef.getCount());//returns the digit, + Modulus times the count of the other counter, resulting in just counting form 0 - limit... in for loop
        }else
        {
            return getDigit();//if No left counter is found, returns the digit within the original object.
        }
    }
    /** Returns a String representation of the Counter's
     * total count (including its left neighbour).
     * @return the String representation
     */
    @Override
    public String toString() {
        //DO NOT MODIFY THIS CODE
        return "" + getCount();
    }
}