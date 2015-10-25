package fisjava;

/**
 * @version 1.0
 * @author Admin
 *
 */
class ComplexNumber {

	double rePart;// real part of the complex number
	double imPart;// image part of the complex number
	double module;
	double arg;

	/**
	 * Constructor
	 */
	public ComplexNumber() {

	}

	public ComplexNumber(double x, double y) {
		this.rePart = x;
		this.imPart = y;
	}

	/**
	 * Add two complexs number
	 * 
	 * @param c
	 * @param d
	 */
	public static ComplexNumber addition(ComplexNumber c, ComplexNumber d) {
		ComplexNumber complex = new ComplexNumber();
		complex.rePart = c.rePart + d.rePart;
		complex.imPart = c.imPart + d.imPart;
		return complex;
	}

	/**
	 * Sub two complexs number
	 * 
	 * @param c
	 * @param d
	 */
	public static ComplexNumber subtraction(ComplexNumber c, ComplexNumber d) {
		ComplexNumber complex = new ComplexNumber();
		complex.rePart = c.rePart - d.rePart;
		complex.imPart = c.imPart - d.imPart;
		return complex;
	}

	/**
	 * Multi two complexs number
	 * 
	 * @param c
	 * @param d
	 */
	public static ComplexNumber multiplication(ComplexNumber c, ComplexNumber d) {
		ComplexNumber complex = new ComplexNumber();
		complex.rePart = c.rePart * d.rePart - c.imPart * d.imPart;
		complex.imPart = c.imPart * d.rePart + c.rePart * d.imPart;
		return complex;
	}

	/**
	 * Div two complexs number
	 * 
	 * @param c
	 * @param d
	 */
	public static ComplexNumber division(ComplexNumber c, ComplexNumber d) {
		ComplexNumber complex = new ComplexNumber();
		if (d.rePart != 0 | d.imPart != 0) {
			complex.rePart = (c.imPart * d.rePart + c.imPart * d.imPart)
					/ (d.rePart * d.rePart + d.imPart * d.imPart);
			complex.imPart = (c.rePart * d.rePart - c.rePart * d.imPart)
					/ (d.rePart * d.rePart + d.imPart * d.imPart);
		} else {
			System.out.print("Cant division by zero");
		}
		return complex;
	}

	/**
	 * Caculate module of complex number
	 * 
	 * @param complex
	 */
	public void calculateModul(ComplexNumber complex) {
		complex.module = Math
				.sqrt((complex.rePart * complex.rePart + complex.imPart
						* complex.imPart));
	}

	/**
	 * Caculate argument of complex number
	 * 
	 * @param complex
	 */
	public void caculateArgument(ComplexNumber complex) {
		if (complex.rePart > 0) {
			arg = Math.atan(complex.imPart / complex.rePart);
		} else if (complex.rePart < 0 && complex.imPart >= 0) {
			arg = Math.atan(complex.imPart / complex.rePart) + Math.PI;
		} else if (complex.rePart < 0 && complex.imPart < 0) {
			arg = Math.atan(complex.imPart / complex.rePart) - Math.PI;
		} else if (complex.rePart == 0 && complex.imPart > 0) {
			arg = Math.PI / 2;
		} else if (complex.rePart == 0 && complex.imPart > 0) {
			arg = -Math.PI / 2;
		} else {
			arg = 0;
		}
	}

	/**
	 * Compare 2 complex numbers
	 * 
	 * @param c
	 * @param d
	 * @return boolean
	 */
	public static boolean isEqual(ComplexNumber c, ComplexNumber d) {
		if (c.rePart == d.rePart && c.imPart == d.imPart) {
			return true;
		}
		return false;
	}

	public double getRePart() {
		return rePart;
	}

	public void setRePart(double rePart) {
		this.rePart = rePart;
	}

	public double getImPart() {
		return imPart;
	}

	public void setImPart(double imPart) {
		this.imPart = imPart;
	}

	public double getModule() {
		return module;
	}

	public void setModule(double module) {
		this.module = module;
	}

	public double getArg() {
		return arg;
	}

	public void setArg(double arg) {
		this.arg = arg;
	}
}

public class Bai6 {
	public static void main(String args[]) {
		ComplexNumber cn1 = new ComplexNumber(2.0, 5.0);
		ComplexNumber cn2 = new ComplexNumber(3.0, 4.0);
		ComplexNumber cn3 = new ComplexNumber();
		cn3 = ComplexNumber.addition(cn1, cn2);
		cn1.caculateArgument(cn1);
		cn1.calculateModul(cn1);
		System.out.println("cn3 = " + cn3.rePart + " + " + cn3.imPart + "i");
		System.out.println("arg(cn1) = " + cn1.arg);
		System.out.println("Trigonometric form of cn1 : " + (float) cn1.module
				+ "(" + "cos " + (float) cn1.arg + "+ i*sin " + (float) cn1.arg
				+ ")");
		System.out.println("module(cn1) = " + cn1.module);
	}
}
