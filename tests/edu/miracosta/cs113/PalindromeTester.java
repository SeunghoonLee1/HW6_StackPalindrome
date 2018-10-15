package edu.miracosta.cs113;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;


import org.junit.Test;

public class PalindromeTester {

    /**
     * Checks if parameter is a palindrome using stacks and
     * ignores whitespace + case sensitivity; doesn't ignore digits/symbols
     *
     * @param s any chars allowed,
     * @return returns true if a palindrome (ignoring whitespace and case sensitivity), false otherwise
     */
    private boolean isPalindrome(String s) {
        if(s == null){
            throw new IllegalArgumentException();
        }


        ArrayListStack<String> stack1 = new ArrayListStack<String>();
        ArrayListStack<String> stack2 = new ArrayListStack<String>();
        String frontPart = "";
        String backPart = "";
        String withoutWhiteSpace = "";
        boolean isPalindrome = false;

        withoutWhiteSpace = s.replaceAll("\\s", "");

        if(withoutWhiteSpace.length() == 1 || withoutWhiteSpace.length() == 0){
            isPalindrome = true;
            return isPalindrome;
        }

        if(withoutWhiteSpace.length() % 2 == 0){//when the input length is even.
           //System.out.println(s + "  is even number of charactors!");
            frontPart = withoutWhiteSpace.substring(0, withoutWhiteSpace.length() / 2);
            backPart = withoutWhiteSpace.substring(withoutWhiteSpace.length() / 2);
            //System.out.println("Front part : " + frontPart + " Back part : " + backPart);

            for(int i = 0; i < frontPart.length(); i ++){
                stack1.push(frontPart.charAt(i) + "");
                stack2.push(backPart.charAt(backPart.length() -1 - i) + "");
            }

        }else if(withoutWhiteSpace.length() % 2 == 1){//when the input length is odd.
            frontPart = withoutWhiteSpace.substring(0, withoutWhiteSpace.length() / 2);
            backPart = withoutWhiteSpace.substring((withoutWhiteSpace.length() / 2) + 1);

            for(int i = 0; i < frontPart.length(); i ++){
                stack1.push(frontPart.charAt(i) + "");
                stack2.push(backPart.charAt(backPart.length() - 1 - i) + "");
            }
        }

        //Now compare two stacks and check if they are palindromes
        while(!(stack1.empty())){
            isPalindrome = stack1.pop().equalsIgnoreCase(stack2.pop());
            if(isPalindrome == false){
                return isPalindrome;
            }
        }



        return isPalindrome;
    }


    @Test
    public void testErrors() {
        try {
            isPalindrome(null);
            fail("Checking null to see if it's a palindrome should throw IllegalArgumentException!");
        } catch (IllegalArgumentException iae) { /* Test Passed! */ }
    }

    @Test
    public void testSimpleTrueCases() {
        assertTrue("This test is a palindrome", isPalindrome(""));
        assertTrue("This test is a palindrome", isPalindrome(" "));
        assertTrue("This test is a palindrome", isPalindrome("A"));
        assertTrue("This test is a palindrome", isPalindrome("7"));
        assertTrue("This test is a palindrome", isPalindrome("%"));

        assertTrue("This test is a palindrome", isPalindrome("  "));
        assertTrue("This test is a palindrome", isPalindrome("BB"));
        assertTrue("This test is a palindrome", isPalindrome("33"));
        assertTrue("This test is a palindrome", isPalindrome("**"));
    }

    @Test
    public void testSimpleFalseCases() {
        assertFalse("This test is NOT a palindrome", isPalindrome("AC"));
        assertFalse("This test is NOT a palindrome", isPalindrome("71"));
        assertFalse("This test is NOT a palindrome", isPalindrome("@+"));
    }

    @Test
    public void testWhitespaceCases() {
        assertTrue("This test is a palindrome", isPalindrome(" x "));
        assertTrue("This test is a palindrome", isPalindrome(" t   t  "));
        assertTrue("This test is a palindrome", isPalindrome(" 5 5"));
        assertTrue("This test is a palindrome", isPalindrome(" #      # "));

        assertFalse("This test is NOT a palindrome", isPalindrome("m   n  "));
        assertFalse("This test is NOT a palindrome", isPalindrome("   8  7 "));
        assertFalse("This test is NOT a palindrome", isPalindrome("  ^      &  "));
    }

    @Test
    public void testCaseSensitivityCases() {
        assertTrue("This test is a palindrome", isPalindrome("ABba"));
        assertTrue("This test is a palindrome", isPalindrome("roTOR"));
        assertTrue("This test is a palindrome", isPalindrome("rAceCaR"));
    }

    @Test
    public void testComplexCases() {
        assertTrue("This test is a palindrome", isPalindrome("fOO race CAR ooF"));
        assertTrue("This test is a palindrome", isPalindrome("AbBa ZaBba"));
        assertTrue("This test is a palindrome", isPalindrome("1 3 3 7  331"));
        assertTrue("This test is a palindrome", isPalindrome("sT RJKLEeE R#@ $A$ @# REeEL K  JRT s"));

    }

}
