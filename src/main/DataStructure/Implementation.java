public class Implementation {
    public static void main(String[] args) {
        System.out.println(replaceSpace("Ms Jane Smooth       ", 14));
        System.out.println(isPalindromePermuation("Tacty Coa"));
    }

    private static String replaceSpace(final String string, final int trueLength) {
        char[] chars = string.toCharArray();
        int spaces = 0;
        for(int i=0; i < trueLength; i++) {
            if(chars[i] == ' ') {
                spaces++;
            }
        }
        int currentIndex = trueLength + spaces * 2;
        // work back to front of string from the end of the
        // new string and copy array elements to the position
        // there will never be an overlap in copying elements as
        // we first check new string length before copying elements
        for(int i=trueLength-1; i>=0; i--) {
            if(chars[i] == ' ') {
                chars[currentIndex - 1] = '0';
                chars[currentIndex - 2] = '2';
                chars[currentIndex - 3] = '%';
                currentIndex = currentIndex -3;
            } else {
                chars[currentIndex - 1] = chars[i];
                currentIndex--;
            }
        }
        return String.valueOf(chars);
    }

    private static boolean isPalindromePermuation(final String string) {
        int[] table = buildCharFrequency(string);
        int currentOddCount = 0;

        for(int i: table) {
            if (i % 2 !=0 && i !=0) {
                currentOddCount++;
            }
        }
        return currentOddCount <= 1;
    }

    private static int[] buildCharFrequency(final String string) {
        int[] table = new int[Character.getNumericValue('z') -
                Character.getNumericValue('a') + 1];
        for(char i: string.toCharArray()) {
            int value = getNumberValue(i);
            if (value != -1) {
                table[value] ++;
            }
        }
        return  table;
    }

    private static int getNumberValue(final char character) {
        int numericValue = Character.getNumericValue(character);
        int aNumeric = Character.getNumericValue('a');
        int zNumeric = Character.getNumericValue('z');
        if (aNumeric <= numericValue && zNumeric >= numericValue) {
            return numericValue - aNumeric;
        } else {
            return-1;
        }
    }

}
