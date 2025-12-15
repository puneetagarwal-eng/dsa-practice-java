package com.mindgym.dsa.greedy;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class NonOverlappingIntervals {

  public static void main(String[] args) {

    int[][] intervals = {{1,2},{2,3},{3,4},{1,3}};
    System.out.println(eraseOverlapIntervals(intervals));
  }
  private static List<int[]> eraseOverlapIntervals(int[][] intervals) {
    Arrays.sort(intervals, Comparator.comparingInt((interval) -> interval[0]));
    List<int[]> listOfIntervals = new ArrayList<>();
    listOfIntervals.add(intervals[0]);
    int[] cur;
    int index = 1;
    for(int i=1 ; i<intervals.length ; i++) {
      cur = intervals[i];
      if(doesOverlap(intervals[index], cur)) {
        listOfIntervals.add(cur);
      } else {
        index++;
      }
    }
    return listOfIntervals;
  }

  private static boolean doesOverlap(int[] interval1, int[] interval2) {
    return interval1[0] <= interval2[0] && interval1[1]  >= interval2[1];
  }
}
