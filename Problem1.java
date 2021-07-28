import java.util.Arrays;
// import java.util.ArrayList;

public class Problem1 {
    public static void main(String[] args) {
        easyMethod("NguyenHaiMINHTrang");
        mediumMethod("NguyenHaiMINHTrang");
        hardMethod("NGUYENHaiMinhTRAng");
    }

    public static int[] easyMethod(String s) {
        int lowerCase = 0;
        int upperCase = 0;
        int[] arr = new int[2];
        // loop through all the letters
        for (int i = 0; i < s.length(); i++) {
            // if the letter is lower case then add 1 to the variable "lowerCase"
            if (Character.isLowerCase(s.charAt(i))) {
                lowerCase++;
                // else add 1 to the variable "upperCase"
            } else {
                upperCase++;
            }
        }
        // Add two element to the array
        arr[0] = lowerCase;
        arr[1] = upperCase;

        System.out.println(Arrays.toString(arr));
        return arr;
    }

    public static int[] mediumMethod(String s) {
        int lowerCaseSequence = 0;
        int upperCaseSequence = 0;
        int[] arr = new int[2];
        for (int i = 0; i < s.length() - 1; i++) {
            // if the letter is lower case
            if (Character.isLowerCase(s.charAt(i))) {
                // then check if the next letter is also lower case
                if (Character.isLowerCase(s.charAt(i + 1))) {
                    lowerCaseSequence++;
                }
            }
            // if the letter is upper case
            if (Character.isUpperCase(s.charAt(i))) {
                // then check if the next letter is also upper case
                if (Character.isUpperCase(s.charAt(i + 1))) {
                    upperCaseSequence++;
                }
            }
        }
        // add two elements to the array
        arr[0] = lowerCaseSequence;
        arr[1] = upperCaseSequence;

        System.out.println(Arrays.toString(arr));
        return arr;
    }

    public static int[] hardMethod(String s) {
        int lowerCase = 0;
        int upperCase = 0;

        // the longest sequence of lower case letters
        int lowerCaseMax = 0;
        // the longest sequence of upper case letters
        int upperCaseMax = 0;

        int[] arr = new int[2];

        for (int i = 0; i < s.length(); i++) {
            // if the letter is lower case, then we add 1 to the variable "lowerCase" and set "upperCase" back to 0
            if (Character.isLowerCase(s.charAt(i))) {
                lowerCase++;
                upperCase = 0;
                // if the current lower case sequence is larger than "lowerCaseMax", we assign it to "lowerCaseMax"
                if (lowerCase > lowerCaseMax) {
                    lowerCaseMax = lowerCase;
                }
                // if the letter is upper case, then we add 1 to the variable "upperCase" and set "lowerCase" back to 0
            } else if (Character.isUpperCase(s.charAt(i))) {
                lowerCase = 0;
                upperCase++;
                // if the current upper case sequence is larger than "upperCaseMax", we assign it to "upperCaseMax"
                if (upperCase > upperCaseMax) {
                    upperCaseMax = upperCase;
                }
            } 
        }

        // assign the elements to the array
        arr[0] = lowerCaseMax;
        arr[1] = upperCaseMax;

        System.out.println(Arrays.toString(arr));
        return arr;
    }
}
