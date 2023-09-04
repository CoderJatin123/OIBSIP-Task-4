package com.example.quiz.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.quiz.Model.Question;

import java.util.ArrayList;
import java.util.List;

public class MainViewModel extends ViewModel {
    public List<Question> list;
    public MutableLiveData<Question> question;
    public ArrayList<String> ans;
    public int progress=0;


    public MainViewModel(List<Question> list) {
        this.list = list;
        progress=1;
        question=new MutableLiveData<>();
        question.setValue(list.get(progress-1));
        ans=new ArrayList<>(3);
        initAnsList();
    }

    private void initAnsList() {
        ans.add(0,"");
        ans.add(1,"");
        ans.add(2,"");
    }

    public LiveData<Question> getQuestion() {
        return question;
    }

    public void onSave(String answer){
        if(!answer.equals(null) ){
            ans.set(progress-1,answer);
        }

    }

    public void loadNext(){

        if(progress+1<=list.size()) {
            progress = progress + 1;
            question.setValue(list.get(progress - 1));
        }
    }

    public ArrayList<String> getAns() {
        return ans;
    }

    public int getProgress() {
        return progress;
    }

}
