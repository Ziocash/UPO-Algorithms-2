package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import upo.progdin20025432.LongestCommonSubsequence;

public class LCSTest {
    @Test
    public void testLCS(){
        String s1 = "ATCBAB";
		String s2 = "BACATBA";
		String sol = "ACAB";
		String resFunction = LongestCommonSubsequence.getSubsequence(s1, s2);
		
		assertEquals(sol, resFunction);
    }
}
