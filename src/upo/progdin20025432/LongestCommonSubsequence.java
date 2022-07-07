package upo.progdin20025432;

import java.util.Arrays;

public class LongestCommonSubsequence {

    private LongestCommonSubsequence() {

    }

    private static void init(String[][] matrixLCS, int[][] matrixL) {
        for(int[] row : matrixL)
            Arrays.fill(row, 0);
        for(String[] row : matrixLCS)
            Arrays.fill(row, "");
    }

    public static String getSubsequence(String string1, String string2) {
        String[][] matrixLCS = new String[string1.length() + 1][string2.length() + 1];
        int[][] matrixL = new int[string1.length() + 1][string2.length() + 1];
        
        init(matrixLCS, matrixL);

        for (int i = 1; i <= string1.length(); i++) {
            for (int j = 1; j <= string2.length(); j++) {
                if (string1.charAt(i - 1) == string2.charAt(j - 1)) {
                    matrixLCS[i][j] = matrixLCS[i - 1][j - 1] + string1.charAt(i - 1);
                    matrixL[i][j] = matrixL[i - 1][j - 1] + 1;
                } else if (matrixL[i - 1][j] > matrixL[i][j - 1]) {
                    matrixLCS[i][j] = matrixLCS[i - 1][j];
                    matrixL[i][j] = matrixL[i - 1][j];
                } else {
                    matrixLCS[i][j] = matrixLCS[i][j - 1];
                    matrixL[i][j] = matrixL[i][j - 1];
                }
            }
        }

        return matrixLCS[string1.length()][string2.length()];
    }
}
