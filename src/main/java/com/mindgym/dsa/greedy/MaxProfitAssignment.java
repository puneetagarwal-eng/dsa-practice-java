/**
 * Problem: Most Profit Assigning Work
 * Source: LeetCode 826
 *
 * Given jobs with difficulty and profit, and workers with abilities,
 * assign at most one job to each worker to maximize total profit.
 *
 * Jobs can be repeated.
 *
 * Time Complexity: O(n log n + m log m)
 * Space Complexity: O(n)
 */
package com.mindgym.dsa.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class MaxProfitAssignment {

  public static void main(String[] args) {
    int[] difficulty = {2,4,6,8,10};
    int[] profit = {10,20,30,40,50};
    int[] worker = {4,5,6,7};
    System.out.println(maxProfitAssignment(difficulty, profit,worker));
  }

  public static int maxProfitAssignment(int[] difficulty, int[] profit, int[] workers) {
    int[][] jobs = new int[difficulty.length][2];
    for(int i=0 ; i<difficulty.length ; i++) {
      jobs[i][0] = difficulty[i];
      jobs[i][1] = profit[i];
    }

    Arrays.sort(jobs, Comparator.comparingInt(job -> job[0]));
    Arrays.sort(workers);

    int totalProfit = 0;
    int j = 0;
    int maxProfitSoFar = 0;

    for(int worker: workers) {
      for(; j < jobs.length && jobs[j][0] <= worker ; j++) {
        maxProfitSoFar = Math.max(maxProfitSoFar, jobs[j][1]);
      }
      totalProfit += maxProfitSoFar;
    }
    return totalProfit;
  }
}
