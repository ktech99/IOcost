// Program to calculate IO cost of a given Query
// T1 is tuples of R
// T2 is tubles of S
// B1 is Blocks of R
// B2 is blocks of S
// M is available memory

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
    System.out.println("Memory available:");
    int M = sc.nextInt();
    System.out.println("Enter unique tuples of 1");
    int v1 = sc.nextInt();
    System.out.println("Enter unique tuples of 2");
    int v2 = sc.nextInt();
    if (B1 < B2) {
      // Swapping numbers if B(R) < B(S)
      T1 = T1 + T2;
      T2 = T1 - T2;
      T1 = T1 - T2;
      B1 = B1 + B2;
      B2 = B1 - B2;
      B1 = B1 - B2;
      v1 = v1 + v2;
      v2 = v1 - v2;
      v1 = v1 - v2;
    }
    nestedLoopJoin(T1, T2, B1, B2, M);
    hashJoin(B1, B2, M);
    sortMergeJoin(B1, B2, M);
  }

  public static void nestedLoopJoin(int T1, int T2, int B1, int B2, int M) {
    System.out.println("Nested Loop Join:");
    int multiPass = B1 + T1 * B2;
    System.out.println("\tMulti pass: " + multiPass);
    int pageAtATime = B1 + B1 * B2;
    System.out.println("\tPage at a time pass: " + pageAtATime);
    int BlockNested = B1 + (B1 * B2) / (M - 1);
    System.out.println("\tBlock Nested Loop Join: " + BlockNested);
  }

  public static void hashJoin(int B1, int B2, int M) {
    if (B1 > M) {
      System.out.println("Hash Join not suitable as B(R) > M");
    } else {
      System.out.println("Hash Join:" + (B1 + B2));
    }
  }

  public static void sortMergeJoin(int B1, int B2, int M) {
    if (B1 + B2 > M) {
      System.out.println("Sort Merge Join not suitable as B(R) + B(S) > M");
    } else {
      System.out.println("Sort Merge Join:" + (B1 + B2));
    }
  }

  public static void indexJoin(int T1, int B1, int B2, int v2) {
    System.out.println("Index Join:");
    int clustered = B1 + T1 * (B2 / V2);
    int unclustered = B1 + T1 * (T2 / V2);
    System.out.println("\tClustered index on S:" + clustered);
    System.out.println("\tUnclustered index on S:" + unclustered);
  }
}
