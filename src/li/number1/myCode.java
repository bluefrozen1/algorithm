package li.number1;

/* package whatever; // don't place package name! */

import java.util.Scanner;

class myCode {
    public static int getArea(int width, int height){

        // 시간복잡도 : O(1)
        return width * height;
    }

    public static void main (String[] args) throws java.lang.Exception {
        Scanner scanner = new Scanner(System.in).useRadix(10);
        int width = scanner.nextInt();
        int height = scanner.nextInt();

        System.out.println(getArea(width, height));
    }
}
