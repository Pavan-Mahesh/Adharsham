import java.util.Scanner;
public class FindRegions {
    static int[][] val;
    static int[][] initialize(int rows, int columns) {
        Scanner take = new Scanner(System.in);
        System.out.println("Enter the elements of the matrix: ");
        int[][] matrix = new int[1+rows+1][1+columns+1];
        for (int r = 1; r <= rows; r++)
            for (int c = 1; c <= columns; c++)
                matrix[r][c] = take.nextInt();
        return matrix;
    }
    static void fillZeroes(int r, int c) {
        if(r== val.length || c== val[0].length)
            return;
        // top
        if(val[r+1][c] == 1) {
            val[r+1][c] = 0;
            fillZeroes(r+1, c);
        }
        // right
        if(val[r][c+1] == 1) {
            val[r][c+1] = 0;
            fillZeroes(r, c+1);
        }
        // down
        if(val[r-1][c] == 1) {
            val[r-1][c] = 0;
            fillZeroes(r-1, c);
        }
        // left
        if(val[r][c-1] == 1) {
            val[r][c-1] = 0;
            fillZeroes(r, c-1);
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("rows: "); int rows = input.nextInt();
        System.out.print("columns: "); int columns = input.nextInt();
        val = initialize(rows, columns);
        int regions = 0;
        for(int r=1; r<=rows; r++) {
            for(int c=1; c<=columns; c++) {
                if(val[r][c] == 1) {
                    regions++;
                    fillZeroes(r, c);
                }
            }
        }
        System.out.println("regions: " + regions);
    }
}
