package com.test.encode;

import org.junit.Test;
import junit.framework.TestCase;

public class EncodeStringTest extends TestCase {

	EncodeString objEncode = new EncodeString();

	@Test
	public void testPlaintext() {

		String encode = "abcdef";
		assertEquals("bcdefg", objEncode.encode(1, encode));

	}

	@Test
	public void testPlaintextBoundary() {
		String encode = "uvwxyz";
		assertEquals("vwxyza", objEncode.encode(1, encode));
	}

	@Test
	public void testPlaintextNonChar() {
		String encode = "d4f5g6";
		assertEquals("e4g5h6", objEncode.encode(1, encode));
	}

	@Test
	public void testPlaintextOtherChar() {
		String encode = "z&*dj@7";
		assertEquals("a&*ek@7", objEncode.encode(1, encode));
	}

	@Test
	public void testPlaintextNegativeOffset() {
		String encode = "abc5ft$z";
		assertEquals("zab5es$y", objEncode.encode(-1, encode));
	}
	
	@Test
	public void testallNonChar() {
		String encode = "15*&65";
		assertEquals("15*&65", objEncode.encode(1, encode));
		assertEquals("15*&65", objEncode.encode(-1, encode));
	}
}
