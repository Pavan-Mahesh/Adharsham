public class ExcelNumbers {
    static void printAlpha(int[] bits) {
        // ASCII from A-Z : 65-90
        for(int bit: bits)
            System.out.format("%c", bit==0 ? 90 : 65+bit-1); // If 0 then 'Z'
        System.out.println();
    }
    static void convertToAlpha(int deci) {
        if(deci <= 0 ) {
            System.out.println("No Possible answer!");
            return;
        }
        // to find the count of bits (starting from 0)
        int n_bits = 1, check_value = (int)Math.pow(26, n_bits);
        while(deci > check_value) {
            n_bits++;
            check_value += (int)Math.pow(26, n_bits);
        }
        // getting the bits in order
        int[] bits = new int[n_bits];
        for(int i=n_bits-1; i>=0; i--) {
            bits[i] = deci%26;
            deci = (deci/26) - (deci% 26 == 0 ? 1 : 0);
        }
        printAlpha(bits);
    }
    public static void main(String[] args) {
        convertToAlpha(2730);
    }
}