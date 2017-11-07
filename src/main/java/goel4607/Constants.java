package goel4607;

/**
 * @author goera01 on 10/24/17.
 */
public class Constants {
    public static int UNMARKED = -1;

    public static void initMatrix(final int[] dynProgMatrix) {
        for (int i=0; i<dynProgMatrix.length; i++) {
            dynProgMatrix[i] = Constants.UNMARKED;
        }
    }

}
