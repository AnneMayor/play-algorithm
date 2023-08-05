package leetcode;

<<<<<<< HEAD
import java.util.LinkedList;
import java.util.Queue;

public class Google_LeetCode_WaterfallStreams {

  static class Waterfall {
    int x;
    int y;
    double remain;

    public Waterfall(int x, int y, double remain) {
      this.x = x;
      this.y = y;
      this.remain = remain;
    }
  }

    public double[] waterfallStreams(double[][] array, int source) {

        double[][] waterSpaces = new double[array.length][array[0].length];

        trackWaterfallStreams(array, source, waterSpaces);
        
        return waterSpaces[array.length-1];
      }

      private void trackWaterfallStreams(double[][] array, int source, double[][] waterSpaces) {
        Queue<Waterfall> waterFalls = new LinkedList<>();

        waterFalls.add(new Waterfall(0, source, 100));

        while(!waterFalls.isEmpty()) {
          Waterfall currenWaterfall = waterFalls.poll();

          waterSpaces[currenWaterfall.x][currenWaterfall.y] += currenWaterfall.remain;

          if(currenWaterfall.x == array.length && currenWaterfall.y == array[0].length) return;

          int nextX = currenWaterfall.x + 1;
          int nextY = currenWaterfall.y;

          if(array[nextX][nextY] == 1) {
            if(nextY < 0) {
              waterFalls.add(new Waterfall(nextX, nextY + 1, currenWaterfall.remain));
            } else if(nextY >= array[0].length) {
              waterFalls.add(new Waterfall(nextX, nextY - 1, currenWaterfall.remain));
            } else {
              waterFalls.add(new Waterfall(nextX, nextY - 1, currenWaterfall.remain / 2));
              waterFalls.add(new Waterfall(nextX, nextY + 1, currenWaterfall.remain / 2));
            }
          } else {
            waterFalls.add(new Waterfall(nextX, nextY, currenWaterfall.remain));            
          }

        }
      }
} 
=======
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
>>>>>>> 8e71212096a2ca42d46588d4abf3c3b544ede6f2
