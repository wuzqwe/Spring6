package com.szq.spring6.bean;

import java.util.Arrays;

public class QianDaYe {
    private String[] aiHaos;

    private Woman[] women;

    public void setWomen(Woman[] women) {
        this.women = women;
    }

    public void setAiHaos(String[] aiHaos) {
        this.aiHaos = aiHaos;
    }

    // TODO: 2023/2/5

    @Override
    public String toString() {
        return "QianDaYe{" +
                "aiHaos=" + Arrays.toString(aiHaos) +
                ", women=" + Arrays.toString(women) +
                '}';
    }
}
