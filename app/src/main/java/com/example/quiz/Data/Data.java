package com.example.quiz.Data;

import com.example.quiz.Model.Question;

import java.util.ArrayList;
import java.util.List;

public class Data {
    public static List<Question> getData(){
        List<Question> list=new ArrayList<>();
        list.add(new Question("Who was the first President of India","B","Narendra Modi","Dr. Rajendra Prasad","Mahatma Gandhi","Sardar Patel"));
        list.add(new Question("Who was the last Mughal ruler?","C","Akbar","Salim sah","Bahadur Shah Zafar","Aurang zeb"));
        list.add(new Question("Name the National animal of India?","A","Tiger","Snake","Cow","Cat"));
        return list;
    }
}
