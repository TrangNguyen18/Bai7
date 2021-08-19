import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class ThucHanh {
    public static void main(String[] args) {
        System.out.println("Bài 1: nhập vào phần tử X, kiểm tra x có thuộc mảng hay không");
        Scanner sc = new Scanner(System.in);
        int[][] a1 = inputMatrix();
        System.out.print("Nhap x: ");
        int x = sc.nextInt();

        if (hasElement(a1, x)) {
            System.out.format("Phan tu %d thuoc mang", x);
        } else System.out.format("Phan tu %d khong thuoc mang", x);
        System.out.println();

        // bai 2: kiểm tra mảng có phải là số nguyên tố hay không
        System.out.println("Bài 2: kiểm tra mảng có phải là số nguyên tố hay không");
        int[][] a2 = inputMatrix();
        if (isPrimeMatrix(a2)) {
            System.out.println(" Mang co tat ca cac phan tu deu la so nguyen to");
        } else
            System.out.println("Mang khong phai la mang nguyen to");

        //bài 3: Tìm số lớn nhất trong mảng
        System.out.println("bài 3: Tìm số lớn nhất trong mảng");
        System.out.print("Nhập vào số hàng của ma trận: ");
        int r = sc.nextInt();
        System.out.print("Nhập vào số cột của ma trận: ");
        int c = sc.nextInt();
        int[][] a3 = generateMatrix(r, c, 1, 10);
        printMatrix(a3);
        int max = findMax(a3);
        System.out.format("Gia tri lon nhat cua mang la %d: ", max);
        System.out.println();

        // Bai 4 a: Tính tổng các phần tử trên dòng d và cột c
        System.out.println("Bai 4 a: Tính tổng các phần tử trên dòng d và cột c");
        System.out.print("Nhập vào số hàng của ma trận: ");
        int r1 = sc.nextInt();
        System.out.print("Nhập vào số cột của ma trận: ");
        int c1 = sc.nextInt();
        int[][] a4 = generateMatrix(r1, c1, 1, 10);
        printMatrix(a4);

        System.out.print("Nhập d: ");
        int row = sc.nextInt();

        System.out.print("nhập c: ");
        int col = sc.nextInt();
        System.out.format("Tổng các phần tử trên dòng %d và cột %d là %d: ", row, col, sum1(row - 1, col - 1, a4));
        System.out.println();

        // Bài 4b: Tính tổng các phần tử trên đường chéo chính
        System.out.println("Bài 4b: Tính tổng trên ma trận vuông");
        System.out.print("Nhập vào số hàng/ cột của ma trận: ");
        int r2 = sc.nextInt();
        int c2 = r2;
        int[][] a5 = generateMatrix(r2, c2, 1, 5);
        printMatrix(a5);
        System.out.format("Tổng các phần tử trên đường chéo chính của ma trận là : %d", sumElementOnMainCross(a5));
        System.out.println();
        System.out.format("Tổng các phần tử trên đường chéo phụ của ma trận là : %d", sumElementOnSubCross(a5));
        System.out.println();
        System.out.format("Tổng các phần tử thuộc nửa trên đường chéo chính là %d", sumAboveElementOnMainCross(a5));
        System.out.println();
        System.out.format("Tổng các phần tử thuộc nửa dưới đường chéo chính là %d", sumBelowElementOnMainCross(a5));
        System.out.println();
        System.out.format("Tổng các phần tử thuộc nửa trên đường chéo phụ là %d", sumAboveElementOnSubCross(a5));
        System.out.println();
        System.out.format("Tổng các phần tử thuộc nửa dưới đường chéo phụ là %d", sumBelowElementOnSubCross(a5));
    }

    public static boolean hasElement(int[][] a, int x) {
        boolean ret = false;
        for (int i = 0, r = a.length; i < r; i++) {
            for (int j = 0, c = a[0].length; j < c; j++) {
                if (a[i][j] == x) {
                    return true;
                }
            }
        }
        return ret;
    }

    public static int[][] inputMatrix() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap vao so hang cua mang : ");
        int r = sc.nextInt();

        System.out.print("Nhap vao so cot cua mang: ");
        int c = sc.nextInt();
        int[][] ret = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.format("a[%d][%d] = ", i, j);
                ret[i][j] = sc.nextInt();
            }
        }
        return ret;
    }

    public static boolean isPrime(int a) {
        boolean ret = true;
        int squareRoot = (int) Math.sqrt(a);
        if (a < 2) {
            ret = false;
        } else {
            for (int i = 2; i <= squareRoot; i++) {
                if (a % i == 0) {
                    ret = false;
                    break;
                }
            }
        }
        return ret;
    }

    public static boolean isPrimeMatrix(int[][] a) {
        boolean ret = true;
        for (int i = 0, r = a.length; i < r; i++) {
            for (int j = 0, c = a[0].length; j < c; j++) {
                if (!isPrime(a[i][j])) {
                    ret = false;
                    break;
                }
            }
            if (!ret) {
                break;
            }
        }
        return ret;
    }

    public static int findMax(int[][] a) {
        int max = a[0][0];
        for (int i = 0, r = a.length; i < r; i++) {
            for (int j = 0, c = a[0].length; j < c; j++) {
                if (a[i][j] > max) {
                    max = a[i][j];
                }
            }

        }
        return max;
    }

    public static int sum1(int d, int c, int[][] a) {
        int sumRow = 0;
        int sumCol = 0;
        for (int i = 0; i < a.length; i++) {
            sumCol += a[i][c];
        }
        ;

        for (int j = 0; j < a[0].length; j++) {
            sumRow += a[d][j];
        }
        ;
        int sum = sumRow + sumCol - a[d][c];
        return sum;
    }

    public static int sumElementOnMainCross(int[][] a) {
        int sum = 0;
        for (int i = 0, r = a.length; i < r; i++) {
            sum += a[i][i];
        }
        return sum;
    }

    public static int sumElementOnSubCross(int[][] a) {
        int sum = 0;
        for (int i = 0, r = a.length - 1; i <= r; i++) {
            sum += a[i][r - i];
        }
        return sum;
    }

    public static int sumAboveElementOnMainCross(int[][] a) {
        int sum = 0;
        for (int i = 0, r = a.length; i < r; i++) {
            for (int j = i + 1, c = a[0].length; j < c; j++) {
                sum += a[i][j];
            }

        }
        return sum;
    }

    public static int sumBelowElementOnMainCross(int[][] a) {
        int sum = 0;
        int r = a.length;
        for (int i = 0; i < r - 1; i++) {
            for (int j = 0; j < r - i - 1; j++) {
                sum += a[i][j];
            }
        }
        return sum;
    }

    public static int sumAboveElementOnSubCross(int[][] a) {
        int sum = 0;
        int r = a.length;
        for (int i = 0; i < r - 1; i++) {
            for (int j = 0; j < r - i - 1; j++) {
                sum += a[i][j];
            }

        }
        return sum;
    }

    public static int sumBelowElementOnSubCross(int[][] a) {
        int sum = 0;
        int r = a.length;
        for (int i = 1; i < r; i++) {
            for (int j = r - i; j < r; j++) {
                sum += a[i][j];
            }

        }
        return sum;
    }

    public static void printMatrix(int[][] a) {
        for (int i = 0, r = a.length; i < r; i++) {
            for (int j = 0, c = a[0].length; j < c; j++) {
                System.out.format("%5d", a[i][j]);
            }
            System.out.println();
        }
    }

    public static int[][] generateMatrix(int r, int c, int min, int max) {
        int[][] ret = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                ret[i][j] = (int) Math.floor(Math.random() * (max - min) + min);
            }
        }
        return ret;
    }
}