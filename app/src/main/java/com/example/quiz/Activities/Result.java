package com.example.quiz.Activities;

import static com.example.quiz.Data.Data.getData;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quiz.MainActivity;
import com.example.quiz.Model.Question;
import com.example.quiz.R;

import java.util.ArrayList;
import java.util.List;

public class Result extends AppCompatActivity {

    TextView correct_view,incorrect_view;
    Button sol_btn,retake_btn;
    List<Question> ans_list;
    int correct_ans=0,incorrect_ans=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        init();

        Intent x =getIntent();

        if(x!=null){
             ans_list=getData();
            ArrayList<String> ans= x.getStringArrayListExtra("ANSWER_LIST");
            if(ans!=null);

            for(int i=0; i<ans_list.size(); i++){
                if(ans.get(i).equals(ans_list.get(i).getAnswer())){
                    correct_ans++;
                }
                else
                    incorrect_ans++;
            }
        }
        showResult();
        retake_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent x=new Intent(getBaseContext(), MainActivity.class);
                startActivity(x);
            }
        });

        sol_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent x=new Intent(getBaseContext(), Solution.class);
                startActivity(x);
            }
        });

    }
    private void init(){

        correct_view=findViewById(R.id.correct_view);
        incorrect_view=findViewById(R.id.incorrect_view);
        sol_btn=findViewById(R.id.soln_btn);
        retake_btn=findViewById(R.id.retake_btn);
    }

    void showResult(){
        correct_view.setText(String.valueOf(correct_ans)+'/'+ans_list.size()+" Correct");
        incorrect_view.setText(String.valueOf(incorrect_ans)+'/'+ans_list.size()+" Wrong");
    }
}