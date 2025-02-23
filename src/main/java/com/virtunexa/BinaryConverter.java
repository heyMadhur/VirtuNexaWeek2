package com.virtunexa;

public class BinaryConverter {
    public static int toDecimel(String binary) {
        if(binary==null || !binary.matches("[01]+")) {
            throw new IllegalArgumentException("Input is not a valid binary number.");
        }

        int decimel=0;
        int base=1;

        for(int i = binary.length()-1; i>= 0; i--) {
            char bit = binary.charAt(i);
            if(bit =='1') {
                decimel+=base;
            }
            base*=2;
        }
        return decimel;
    }
}
