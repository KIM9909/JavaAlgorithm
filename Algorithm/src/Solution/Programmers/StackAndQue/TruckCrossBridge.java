package Solution.Programmers.StackAndQue;
// Lv.2 다리를 지나는 트럭

import java.util.*;
class TruckCrossBridge {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> trucks = new LinkedList<>();
        Queue<Integer> bridge = new LinkedList<>();
        int onBridgeW = 0;
        int time = 0;

        for (int i=0; i<truck_weights.length; i++) {
            trucks.offer(truck_weights[i]);
        }

        for (int i=0; i<bridge_length; i++) {
            bridge.offer(0);
        }

        while (!bridge.isEmpty()) {
            time ++;
            onBridgeW -= bridge.poll();
            if (!trucks.isEmpty()) {
                if (onBridgeW + trucks.peek() <= weight) {
                    int truck = trucks.poll();
                    onBridgeW += truck;
                    bridge.offer(truck);
                } else {
                    bridge.offer(0);
                }
            }
        }

        return time;
    }
}
