package com.example.futbolquiz;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private QuestionAdapter questionAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<Question> questions = new ArrayList<>();
        questions.add(new Question("Cristiano Ronaldo'nun doğum yeri?", "Portekiz", "Brezilya", "Arjantin", "İspanya", "Portekiz"));
        questions.add(new Question("Messi'nin oynadığı ilk kulüp?", "Barcelona", "PSG", "Newell's Old Boys", "Manchester City", "Newell's Old Boys"));
        questions.add(new Question("2022 Dünya Kupası'nı kazanan ülke?", "Fransa", "Arjantin", "Brezilya", "Hırvatistan", "Arjantin"));
        questions.add(new Question("FIFA Dünya Kupası en çok kazanan ülke?", "Brezilya", "Almanya", "Arjantin", "İtalya", "Brezilya"));

        questionAdapter = new QuestionAdapter(questions, this);
        recyclerView.setAdapter(questionAdapter);
    }
}
