package com.game.service;

import org.springframework.stereotype.Service;

@Service
public class ProgressService {

    public String generateProgressBar(double progressPercentage) {
        int totalBlocks = 10;
        int filledBlocks = (int) (progressPercentage / 10);

        StringBuilder progressBar = new StringBuilder("[");
        for (int i = 0; i < totalBlocks; i++) {
            if (i < filledBlocks) {
                progressBar.append("■");
            } else {
                progressBar.append("-");
            }
        }
        progressBar.append("]");

        return progressBar.toString();
    }

    public double calculateProgressPercentage(int totalDays, int remainingDays) {
        if (totalDays > 0) {
            return 100.0 * (totalDays - remainingDays) / totalDays;
        }
        return 0.0;
    }
}
