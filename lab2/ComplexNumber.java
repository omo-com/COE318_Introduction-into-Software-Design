package coe318.lab2;
/**
* ComplexNumber models a complex number expressed
* in rectangular form (real and imaginary parts).
* * It is an <em>immutable</em> object.
*
* @author Oliver Mo
* Student id 500844905
*/
public class ComplexNumber {
//Instance variable declarations
double real;
double imag;    
/**
* Construct a ComplexNumber given its
* real and imaginary parts.
* @param re The real component
* @param im The imaginary component
*/
public ComplexNumber(double re, double im) {
real = re;
imag = im;
}
/**
* Returns the real component.
* @return the real
*/
public double getReal() {
return real;
}
/**
* Returns the imaginary component.
* @return the imaginary
*/
public double getImaginary() {
return imag;
}
/**
* Returns a new ComplexNumber number that is
* the negative of <em>this</em>.  Note: the
* original ComplexNumber is <b>NOT</b>
* modified.
* @return 
-
this
*/
public ComplexNumber negate() {
ComplexNumber nNum = new ComplexNumber(real, imag);
nNum.real = -real;
nNum.imag = -imag;
return nNum;
}
/**
* Returns a new ComplexNumber that is the
* sum of <em>this</em>  and <em>z</em>.
* Note: the  original ComplexNumber is
* <b>NOT</b>
modified.
* @param z
* @return this + z
*/
public ComplexNumber add(ComplexNumber z) {
ComplexNumber aNum = new ComplexNumber(real, imag);
aNum.real = aNum.real + z.real;
aNum.imag = aNum.imag + z.imag;
return aNum;  
}
/**
* Returns a new ComplexNumber that is the
* difference of <em>this</em>  and <em>z</em>.
* * Note: the  original ComplexNumber is
* <b>NOT</b> modified.
* @param z
* @return this + z
*/
public ComplexNumber subtract(ComplexNumber z) {
ComplexNumber sNum = new ComplexNumber(real, imag);
sNum.real = sNum.real - z.real;
sNum.imag = sNum.imag - z.imag;
return sNum;  
}
/**
* Returns a new ComplexNumber that is the
* product of <em>this</em> and <em>z</em>.
* Note: the original ComplexNumber is
* <b>NOT</b> modified.
* @param z
* @return this * z
*/
public ComplexNumber multiply(ComplexNumber z) {
ComplexNumber mNum = new ComplexNumber(real, imag);
mNum.real = (real)*(z.real) - (imag)*(z.imag);
mNum.imag = (real)*(z.imag) + (imag)*(z.real);
return mNum;  
}
/**
* Returns a new ComplexNumber that is
* the reciprocal of <em>this</em>.
* Note: the original ComplexNumber is
* <b>NOT</b> modified.
* @return 1.0 / this
*/
public ComplexNumber reciprocal() {
ComplexNumber rNum = new ComplexNumber(real, imag);
rNum.real = real/(Math.pow(real, 2) + Math.pow(imag, 2));//complex reciprical for real number
rNum.imag = -imag/(Math.pow(real, 2) + Math.pow(imag, 2));//complex reciprical for imaginery number
return rNum;  
}
/**
* Returns a new ComplexNumber that is
* <em>this</em> divided by <em>z</em>.
* Note: the original ComplexNumber is
* <b>NOT</b> modified.
* @param z
* @return this / z
*/
public ComplexNumber divide(ComplexNumber z) {
return this.multiply(z.reciprocal());  //Uses multiply method and reciprical method
}
/**
* Returns a String representation of
* <em>this</em> in the format:
* <pre>
* real +-(optional) i imaginary
* </pre>
* If the imaginary part is zero, only the
* real part is converted to a String.
* A "+" or "-" is placed between the real
* and imaginary parts depending on the
* the sign of the imagrinary part.
* <p>
* Examples:
* <pre>
*  ..println(new ComplexNumber(0,0); ->"0.0"
* *  ..println(new ComplexNumber(1,1); -> "1.0 + i1.0"
*  ..println(new ComplexNumber(1,-1); -> "1.0 -i1.0"
* </pre>
* @return the String representation.
*/
@Override
public String toString() {
    //DO NOT MODIFY THIS CODE!
    String str = "" + this.getReal();
    if (this.getImaginary() == 0.0) {
    return str;
    }
    if (this.getImaginary() > 0) {
    return str + " + i" + this.getImaginary();
    } else {
    return str + " -i" + -this.getImaginary();
    }
    }
       


}