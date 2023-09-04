package com.example.quiz;

import static com.example.quiz.Data.Data.getData;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quiz.Activities.Result;
import com.example.quiz.Model.Question;
import com.example.quiz.ViewModel.MainViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MainViewModel viewModel;
    private RadioGroup ans_group;
    private RadioButton op_a,op_b,op_c,op_d;
    private TextView question,no;
    private Button save_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        save_btn.setEnabled(false);
        viewModel.getQuestion().observe(this, new Observer<Question>() {
            @Override
            public void onChanged(Question que) {
                no.setText("Question "+String.valueOf(viewModel.getProgress()));
                question.setText(que.getQuestion());
                op_a.setText(que.getOp1());
                op_a.setTag("A");
                op_b.setText(que.getOp2());
                op_b.setTag("B");
                op_c.setText(que.getOp3());
                op_c.setTag("C");
                op_d.setText(que.getOp4());
                op_d.setTag("D");
            }
        });

        save_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(viewModel.getProgress()<3) {
                    viewModel.loadNext();
                    save_btn.setEnabled(false);
                    ans_group.clearCheck();
                }
                else {
                    Intent x=new Intent(getBaseContext(), Result.class);
                    Bundle b=new Bundle();
                    b.putStringArrayList("ANSWER_LIST",viewModel.getAns());
                    x.putExtras(b);
                    startActivity(x);
                    finish();
                }
            }
        });

        ans_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                RadioButton x = radioGroup.findViewById(i);
                if(x != null && x.getTag()!=null){
                     viewModel.onSave(x.getTag().toString());
                     save_btn.setEnabled(true);

                     if(viewModel.getProgress()==3){
                         save_btn.setText("Submit");
                     }
                }
            }
        });

    }

    private void init(){
        viewModel=new MainViewModel(getData());
        ans_group=findViewById(R.id.ans_group);
        op_a=findViewById(R.id.op_a);
        op_b=findViewById(R.id.op_b);
        op_c=findViewById(R.id.op_c);
        op_d=findViewById(R.id.op_d);
        question=findViewById(R.id.que_view);
        no=findViewById(R.id.que_no);
        save_btn=findViewById(R.id.save_btn);
    }

}