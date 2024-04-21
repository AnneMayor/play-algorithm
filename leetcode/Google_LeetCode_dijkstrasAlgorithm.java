package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

import leetcode.Google_LeetCode_dijkstrasAlgorithm.Item;

public class Google_LeetCode_dijkstrasAlgorithm {

    public int[] dijkstrasAlgorithm(int start, int[][][] edges) {
        int n = edges.length;

        Queue<Item> itemOrders = new PriorityQueue<>(Comparator.comparingInt(object -> (object.totalDistance)));
        boolean[] isVisited = new boolean[n];
        int[] result = new int[n];
        Arrays.fill(result, -1);

        isVisited[start] = true;
        result[start] = 0;

        for(int[] destinations : edges[start]) {
            itemOrders.add(new Item(destinations[0], destinations[1], destinations[1]));
        }

        while (!itemOrders.isEmpty()) {
            Item currentPosition = itemOrders.poll();

            if (isVisited[currentPosition.id]) continue;

            isVisited[currentPosition.id] = true;
            result[currentPosition.id] = currentPosition.totalDistance;

            for(int[] nextPosition : edges[currentPosition.id]) {
                itemOrders.add(new Item(nextPosition[0], nextPosition[1], nextPosition[1] + currentPosition.totalDistance));
            }
        }

        return result;
    }

    static class Item {
        private int id;
        private int distance;
        private int totalDistance;

        public Item(int id, int distnace, int totalDistance) {
            this.id = id;
            this.distance = distnace;
            this.totalDistance = totalDistance;
        }
    }
}
