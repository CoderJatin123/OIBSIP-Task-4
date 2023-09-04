package com.example.quiz.Activities;

import static com.example.quiz.Data.Data.getData;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Window;

import com.example.quiz.Adapter.SolutionAdapter;
import com.example.quiz.R;

public class Solution extends AppCompatActivity {

    RecyclerView recyclerView;
    SolutionAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solution);

        recyclerView=findViewById(R.id.solution_recyclerview);
        adapter=new SolutionAdapter(getData());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

    }
}