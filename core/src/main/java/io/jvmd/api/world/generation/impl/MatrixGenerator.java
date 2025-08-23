package io.jvmd.api.world.generation.impl;

import io.jvmd.api.world.generation.Generator;

import java.util.Random;

public class MatrixGenerator implements Generator<int[][], Integer> {


    @Override
    public int[][] generate(Integer size) {
        int[][] worldMatrix = new int[size][size];

        Random random = new Random();
        int skipCountX = getSkipCountX(size, random);
        int gorizontalRoadLenght = random.nextInt(2, 3);
        int gtemp = gorizontalRoadLenght;
        int temp = 0;
        boolean isRoad = false;
        int counter = 0;

        for (int i = 0; i < size; i++) {
            if (isRoad) {
                for (int j = 0; j < size; j++) {
                    worldMatrix[i][j] = 1;
                }
                isRoad = false;
            } else {
                while (gorizontalRoadLenght > 0) {
                    gorizontalRoadLenght--;
                    while (temp < size) {
                        worldMatrix[i][temp] = 2;
                        temp += skipCountX;
                    }
                    temp = 0;
                    i++;
                }
                isRoad = true;
            }
            gorizontalRoadLenght = gtemp;
            skipCountX = getSkipCountX(size, random);
        }


        return worldMatrix;
    }

    private static int getSkipCountX(int size, Random random) {
        return random.nextInt(size - (size / 2));
    }

}
