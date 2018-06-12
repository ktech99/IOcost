import java.util.Scanner;

public class IOCost {
  public static void main(String args[]) {
    // Taking inputs
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter Tuples of 1:");
    int T1 = sc.nextInt();
    System.out.println("Enter Tuples of 2:");
    int T2 = sc.nextInt();
    System.out.println("Enter Blocks of 1:");
    int B1 = sc.nextInt();
    System.out.println("Enter Blocks of 2:");
    int B2 = sc.nextInt();
    if (B1 > B2) {
      // Swapping numbers for calculations
      T1 = T1 + T2;
      T2 = T1 - T2;
      T1 = T1 - T2;
      B1 = B1 + B2;
      B2 = B1 - B2;
      B1 = B1 - B2;
    }
  }
}
