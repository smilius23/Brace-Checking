package home.made;

import org.junit.Test;

import static org.junit.Assert.*;

public class BraceCheckingTest {
    BraceChecking checker = new BraceChecking();
    @Test
    public void testValid() {
        assertEquals(true, checker.isValid("()"));
    }
    @Test
    public void testValid0() {
        assertEquals(true, checker.isValid("()[]{}"));
    }
    @Test
    public void testValid1() {
        assertEquals(true, checker.isValid("({[]})"));
    }
    @Test
    public void testValid2() {
        assertEquals(true, checker.isValid("({}[])({}[])"));
    }
    @Test
    public void testInvalid() {
        assertEquals(false, checker.isValid("[(])"));
    }
    @Test
    public void testInvalid1() {
        assertEquals(false, checker.isValid("])"));
    }
    @Test
    public void testInvalid2() {
        assertEquals(false, checker.isValid("[(})]"));
    }
    @Test
    public void testInvalid3() {
        assertEquals(false, checker.isValid("[]()}{"));
    }
}