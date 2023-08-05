package leetcode;

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