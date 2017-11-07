package goel4607;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Copyright (c) 2017 CA.  All rights reserved.
 * <p>
 * This software and all information contained therein is confidential and
 * proprietary and shall not be duplicated, used, disclosed or disseminated in any
 * way except as authorized by the applicable license agreement, without the
 * express written permission of CA. All authorized reproductions must be marked
 * with this language.
 * <p>
 * EXCEPT AS SET FORTH IN THE APPLICABLE LICENSE AGREEMENT, TO THE
 * EXTENT PERMITTED BY APPLICABLE LAW, CA PROVIDES THIS SOFTWARE
 * WITHOUT WARRANTY OF ANY KIND, INCLUDING WITHOUT LIMITATION, ANY
 * IMPLIED WARRANTIES OF MERCHANTABILITY OR FITNESS FOR A PARTICULAR
 * PURPOSE.  IN NO EVENT WILL CA BE LIABLE TO THE END USER OR ANY
 * THIRD PARTY FOR ANY LOSS OR DAMAGE, DIRECT OR INDIRECT, FROM THE
 * USE OF THIS SOFTWARE, INCLUDING WITHOUT LIMITATION, LOST PROFITS,
 * BUSINESS INTERRUPTION, GOODWILL, OR LOST DATA, EVEN IF CA IS
 * EXPRESSLY ADVISED OF SUCH LOSS OR DAMAGE.
 */

/**
 * @author goera01 on 10/25/17.
 */
public class TestPalindrome {

    @Test
    public void testIsPalindrome() throws Exception {

    }

    @Test
    public void testFindAllPalindrome_one() throws Exception {
        final List<String> palindromes = Palindrome.findAllPalindrome("abcb".toCharArray());
        System.out.println("Number of Palindromes=" + palindromes.size());
        palindromes.stream().forEach(s -> System.out.println("\t" + s));
        Assert.assertTrue(palindromes.size()>0);
    }

    @Test
    public void testFindAllPalindrome_6() throws Exception {
        final String testString = "abcbbcbsrs";
        final List<String> expectedPalindromes = Arrays.asList("bcb", "cbbc", "bcbbcb", "bb", "srs");

        final List<String> palindromes = Palindrome.findAllPalindrome(testString.toCharArray());

        System.out.println("Number of Palindromes=" + palindromes.size());
        palindromes.stream().forEach(s -> System.out.println("\t" + s));

        Assert.assertEquals("expected number of palindromes=" + expectedPalindromes.size() + ", \nactual number=" + palindromes.size(),
            expectedPalindromes.size(),
            palindromes.size());
    }

    @Test
    public void testTestIsPalindrome() throws Exception {

    }
}
