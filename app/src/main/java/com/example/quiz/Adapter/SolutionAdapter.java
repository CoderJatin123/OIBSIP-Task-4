package com.example.quiz.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quiz.Model.Question;
import com.example.quiz.R;

import java.util.List;

public class SolutionAdapter extends RecyclerView.Adapter<SolutionAdapter.ViewHolder> {
    private List<Question> list;

    public SolutionAdapter(List<Question> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public SolutionAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View x = LayoutInflater.from(parent.getContext()).inflate(R.layout.solution_item,parent,false);
        return new ViewHolder(x);
    }

    @Override
    public void onBindViewHolder(@NonNull SolutionAdapter.ViewHolder holder, int position) {
        holder.question.setText("Question "+(position+1)+" : " +list.get(position).getQuestion());
        holder.radioButton.setText(list.get(position).getAnswer()+". "+getText(list.get(position).getAnswer(),position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder{

        private TextView question;
        private RadioButton radioButton;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            question=itemView.findViewById(R.id.item_question);
            radioButton=itemView.findViewById(R.id.item_radio_btn);
        }
    }
    public String getText(String x,int index){
        String ans="";
        switch (x){
            case "A": ans=list.get(index).getOp1();
            break;
            case "B": ans=list.get(index).getOp2();
                break;
            case "C": ans=list.get(index).getOp3();
                break;
            case "D": ans=list.get(index).getOp4();
                break;
        }
        return ans;
    }
}
