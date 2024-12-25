package com.example.futbolquiz;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class QuestionAdapter extends RecyclerView.Adapter<QuestionAdapter.QuestionViewHolder> {

    private List<Question> questionList;
    private Context context;

    public QuestionAdapter(List<Question> questionList, Context context) {
        this.questionList = questionList;
        this.context = context;
    }

    @NonNull
    @Override
    public QuestionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_question, parent, false);
        return new QuestionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QuestionViewHolder holder, int position) {
        Question currentQuestion = questionList.get(position);
        holder.bind(currentQuestion);
    }

    @Override
    public int getItemCount() {
        return questionList.size();
    }

    public static class QuestionViewHolder extends RecyclerView.ViewHolder {
        private TextView questionText;
        private RadioGroup radioGroup;
        private RadioButton option1, option2, option3, option4;
        private TextView resultText;

        public QuestionViewHolder(View itemView) {
            super(itemView);
            questionText = itemView.findViewById(R.id.questionText);
            radioGroup = itemView.findViewById(R.id.radioGroup);
            option1 = itemView.findViewById(R.id.answerOption1);
            option2 = itemView.findViewById(R.id.answerOption2);
            option3 = itemView.findViewById(R.id.answerOption3);
            option4 = itemView.findViewById(R.id.answerOption4);
            resultText = itemView.findViewById(R.id.resultText);
        }

        public void bind(Question question) {
            questionText.setText(question.getQuestionText());
            option1.setText(question.getOption1());
            option2.setText(question.getOption2());
            option3.setText(question.getOption3());
            option4.setText(question.getOption4());

            radioGroup.setOnCheckedChangeListener((group, checkedId) -> {
                String selectedAnswer = "";

                if (checkedId == option1.getId()) {
                    selectedAnswer = option1.getText().toString();
                } else if (checkedId == option2.getId()) {
                    selectedAnswer = option2.getText().toString();
                } else if (checkedId == option3.getId()) {
                    selectedAnswer = option3.getText().toString();
                } else if (checkedId == option4.getId()) {
                    selectedAnswer = option4.getText().toString();
                }

                question.setSelectedAnswer(selectedAnswer);

                // Doğru veya yanlış cevabı göster
                if (question.isCorrect()) {
                    resultText.setText("Doğru!");
                    resultText.setTextColor(0xFF00FF00); // Yeşil
                } else {
                    resultText.setText("Yanlış!");
                    resultText.setTextColor(0xFFFF0000); // Kırmızı
                }

                resultText.setVisibility(View.VISIBLE);
            });
        }
    }
}
