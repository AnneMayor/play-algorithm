package leetcode;

import java.util.*;

public class Google_LeetCode_WaterfallStreams {
  public double[] waterfallStreams(double[][] array, int source) {
    return waterFlow(array, 0, source, 100.0, 0, new double[array.length][array[0].length]); 
  }
  
  private double[] waterFlow(double[][] array, int x, int y, double percentage, int direction, double[][] res) {
    if(x == array.length - 1) {
      res[x][y] += percentage;
      return res[x];
    }
    
    if (x < 0 || y < 0 || x >= array.length || y >= array[0].length || array[x][y] == 1) return res[x];
    
    if(array[x+1][y] == 0) {
      res[x] = waterFlow(array, x + 1, y, percentage, 0, res); 
    }
    if(array[x+1][y] == 1) {
      switch(direction) {
        case 0:
          res[x] = waterFlow(array, x, y - 1, percentage / 2, 1, res);
          res[x] = waterFlow(array, x, y + 1, percentage / 2, 2, res);
          break;
          
        case 1:
          res[x] = waterFlow(array, x, y - 1, percentage, 1, res);
          break;
          
        case 2:
          res[x] = waterFlow(array, x, y + 1, percentage, 2, res);
          break;
      }
    }
    
    return res[x];
  }
}
