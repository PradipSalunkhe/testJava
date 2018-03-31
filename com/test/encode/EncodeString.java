
package com.test.encode;

public class EncodeString {

	public static final String alphabets = "abcdefghijklmnopqrstuvwxyz";
	
	/**
	 * main method to test the execution
	 * @param args
	 */
	public static void main(String[] args) {
		EncodeString objEncode = new EncodeString();
		String strInput = "abc5ft$z";
		String encrypted = objEncode.encode(-1, strInput);
		System.out.println("String after encryption is : " + encrypted);
	}
	/**
	 * Method to encode a string based on given offset (-1 or 1)
	 * @param int offset
	 * @param String original - original String to encode
	 * @return encoded String
	 */
	public String encode(int offset, String original) {
	
		int newIndex;
		String result = "";
		
		original = original.toLowerCase();
		for(int i=0; i < original.length(); i++){
			int charIndex = alphabets.indexOf(original.charAt(i));
			if(charIndex >= 0){
				
				if(offset < 0)
					newIndex = charIndex -  1;
				else
					newIndex = (offset+charIndex) % 26;
				//index checked to avoid index out of bound exception
				newIndex = (newIndex == -1) ? 25 : newIndex;
				char newCharacter = alphabets.charAt(newIndex);
				result = result + newCharacter;
			}else
				result = result + original.charAt(i);
		}
		//in case original String contains all non char
		if("".equals(result))
			result = original;
		
		return result;
	}
}
