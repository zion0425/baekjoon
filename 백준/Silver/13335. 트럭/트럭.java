import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int inputTruckCount = Integer.parseInt(st.nextToken());
        int inputBridgeWidth = Integer.parseInt(st.nextToken());
        int inputBridgeWeight = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] waitingTrucks = new int[inputTruckCount];
        Queue<Integer> trucksOnBridge = new LinkedList<>();
        for (int i = 0; i < inputTruckCount; i++) {
            waitingTrucks[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < inputBridgeWidth; i++) {
            trucksOnBridge.offer(0);
        }

        int time = 0;
        int totalWeight = 0;
        int waitingTruckIndex = 0;
        while (waitingTruckIndex < inputTruckCount) {
            ++time;
            totalWeight -= trucksOnBridge.poll();
            if (totalWeight + waitingTrucks[waitingTruckIndex] <= inputBridgeWeight) {
                totalWeight += waitingTrucks[waitingTruckIndex];
                trucksOnBridge.offer(waitingTrucks[waitingTruckIndex++]);
                continue;
            }
            trucksOnBridge.add(0);
        }
        System.out.println(time + inputBridgeWidth);
    }
}
