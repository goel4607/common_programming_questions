package goel4607;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author goera01 on 10/24/17.
 */
public class Palindrome {
    public static boolean isPalindrome(final char[] word) {
        boolean isP = false;
        final int mid = word.length / 2;
        for (int i=0, j=word.length-1; i<mid; i++, j--) {
            if (word[i] != word[j]) {
                isP = false;
                break;
            }
            else {
                isP = true;
            }
        }

        return isP;
    }

    public static List<String> findAllPalindrome(final char[] word) {
        System.out.println("Input String=" + Arrays.toString(word));
        final int[][] dynProgMatrix = new int[word.length][word.length];
        //printMatrix(dynProgMatrix);

        for (int numChars=0; numChars<dynProgMatrix.length; ++numChars) {

            for (int r=0, c=numChars; c < word.length; ++r, ++c) {
                final boolean isP;
                if (r==c) { // same char
                    isP = true;
                }
                else if (numChars == 1) { //two chars only
                    isP = (word[r] == word[c]);
                } else {
                    isP = word[r] == word[c] && word[r + 1] == word[c - 1];
                }

                dynProgMatrix[r][c] = (isP ? 1 : 0);
            }
        }

        //printMatrix(dynProgMatrix);

        final Set<String> palindromes = new TreeSet<>();
        final String inputWord = new String(word);
        for (int i=0; i<dynProgMatrix.length; i++) {

            for (int j=0; j<dynProgMatrix.length; j++) {

                if (i != j // avoid single char palindromes
                    && dynProgMatrix[i][j]==1) {

                    palindromes.add(inputWord.substring(i, j+1));
                }
            }
        }

        return new ArrayList<>(palindromes);
    }

    public static void testIsPalindrome() {
        String[] testWords = {"aa", "aba", "zboz", "aabbaaa"};
        for (final String word : testWords) {
            System.out.println(" isPalindrome? " + word + " -> " + isPalindrome(word.toCharArray()));
        }
    }

    private static void initMatrix(final int[][] dynProgMatrix) {
        for (int i=0; i<dynProgMatrix.length; i++) {

            for (int j=0; j<dynProgMatrix[i].length; j++) {
                if (i==j) {
                    dynProgMatrix[i][j] = 1;
                }
                else {
                    dynProgMatrix[i][j] = Constants.UNMARKED;
                }
            }
        }
    }

    private static void printMatrix(final int[][] dynProgMatrix) {
        System.out.println("matrix size [" + dynProgMatrix.length + " x " + dynProgMatrix[0].length + "]: ");
        System.out.print("columns: ");
        for (int i=0; i<dynProgMatrix.length; i++) {
            if (i == 0) {
                System.out.print("\t");
            }
            else {
                System.out.print("\t\t");
            }

            System.out.print("[" + i + "]");
        }

        System.out.println();

        for (int i=0; i<dynProgMatrix.length; i++) {
            System.out.print("[r=" + i + "] ");
            printMatrix(dynProgMatrix[i]);
            System.out.println("\n");
        }
    }

    private static void printMatrix(final int[] dynProgMatrix) {
        for (int aDynProgMatrix : dynProgMatrix) {
            System.out.print("\t\t" + aDynProgMatrix + " ");
        }
    }
}
