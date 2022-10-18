package TT;

public class Tmp {
    public static void main(String[] args) {
        Tmp tmp = new Tmp();
        int result = tmp.numDecodings("102");
        System.out.println(result);
    }

    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int length = s.length();
        int[] pathNum = new int[length];
        int[] numArr = new int[length];
        for (int i = 0; i < length; i++) {
            numArr[i] = Character.getNumericValue(s.charAt(i));
            if (i == 0 && numArr[0] == 0) {
                return 0;
            }

            if (numArr[i] == 0 && (numArr[i-1] < 1 || numArr[i-1] > 2)) {
                return 0;
            }
        }

        if (length == 1) {
            return 1;
        }

        if (length > 2 && numArr[1] == 0) {
            pathNum[0] = 0;
        } else {
            pathNum[0] = 1;
        }

        for (int i = 1; i < length; i++) {
            if (i+1 < length && 0 == numArr[i+1]) {
                pathNum[i] = pathNum[i-1];
                pathNum[i+1] = pathNum[i];
                i++;
            } else {
                int numTmp2 = numArr[i-1] * 10 + numArr[i];
                if (10 < numTmp2 && numTmp2 <=26) {
                    if (i == 1) {
                        pathNum[i] = pathNum[i-1] + 1;
                    } else {
                        pathNum[i] = pathNum[i-2] + pathNum[i-1];
                    }
                } else {
                    pathNum[i] = pathNum[i-1];
                }
            }
        }

        return pathNum[length - 1];
    }
}
