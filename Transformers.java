/**
 * Name: Saman Zarei
 */

/**
 * This class transforms all the String variable into uppercase
 * @author saman
 *
 */
class UpperCaseTransformer implements MyTransformer<String> {

	public String transformElement(String s) {
		return s.toUpperCase();
	}
}

/**
 * This class transforms all the integer variable by double
 * @author saman
 *
 */
class DoubleNumber implements MyTransformer<Integer>{
	
	public Integer transformElement(Integer myNumber) {
	
		return myNumber * 2;
	}
}

/**
 * This class shows all the the first character of each String variable
 * @author saman
 *
 */
class showLetterAtFirstIndex implements MyTransformer<String>{
	
	public String transformElement(String name) {
		
		return Character.toString(name.charAt(0));
	}
}

