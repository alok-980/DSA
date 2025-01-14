import java.util.*;

public class Main {

    public static int trappedRainWater(int height[]) {
        // calculate max left boundry
        int leftmax[] = new int[height.length];
        leftmax[0] = height[0];

        for(int i=1; i<height.length; i++) {
            leftmax[i] = Math.max(leftmax[i-1], height[i]);
        }

        // calculate max right boundry
        int rightmax[] = new int[height.length];
        rightmax[height.length - 1] = height[height.length - 1];

        for(int i = height.length - 2; i>= 0; i--) {
            rightmax[i] = Math.max(rightmax[i + 1], height[i]);
        }

        //loop
        int trappedWater = 0;
        for(int i=0; i<height.length; i++) {

            //waterlevel = min(leftmax boundry, rightmax boundry)
            int waterLevel = Math.min(leftmax[i], rightmax[i]);

            //trappedwater = waterlevel - height[i]
            trappedWater += waterLevel - height[i];
        }
        return trappedWater;
    }

    public static void main(String args[]) {
        int height[] = {4, 2, 0, 6, 3, 2, 5};

        int trappedWater = trappedRainWater(height);

        System.out.println("Total trapped rain water = " + trappedWater);
    }
}