package com.example.awos.finalproject_jingyuepim;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by awos on 2018/2/13.
 */

public class Question implements Serializable {
    private int textResId;
    private int answerNumber;


    public Question(int textResId, int answerNumber) {
        this.answerNumber = answerNumber;
        this.textResId = textResId;
    }

    public int getTextResId() {
        return textResId;
    }

    public void setTextResId(int textResId) {
        this.textResId = textResId;
    }

    public int getAnswerNumber() {
        return answerNumber;
    }

    public void setAnswerNumber(int answerNumber) {
        this.answerNumber = answerNumber;
    }
}