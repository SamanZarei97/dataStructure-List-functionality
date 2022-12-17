/**
 * Name: Saman Zarei
 */

/**
 * This class chooses all the String variables that their length is more than 5
 * @author saman
 *
 */
class LongWordChooser implements MyChooser<String> {

	@Override
	public boolean chooseElement(String s) {
		return s.length() > 5;
	}

} 

/**
 * This class chooses all the String variables that their 
 * first character is "M"
 * @author saman
 *
 */
class firstLetterIsM implements MyChooser<String>{
	
	public boolean chooseElement(String s) {
		
		return Character.toString(s.charAt(0)).equals("M");
	}
}

/**
 * This class chooses all the Integer variable that are equals to 12
 * @author saman
 *
 */
class myCertainNumber implements MyChooser<Integer>{
	
	public boolean chooseElement(Integer number) {
		
		if(number.equals(12)) {
			return true;
		}
		
		else {
			return false;
		}
	}
}