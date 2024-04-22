package com.example.evoting;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText editTextCollegeID, editTextName, editTextPRN;
    Spinner spinnerBatch, spinnerCourse, spinnerTopic;
    RadioGroup radioGroupVote;
    Button buttonSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI elements
        editTextCollegeID = findViewById(R.id.editTextCollegeID);
        editTextName = findViewById(R.id.editTextName);
        editTextPRN = findViewById(R.id.editTextPRN);
        spinnerBatch = findViewById(R.id.spinnerBatch);
        spinnerCourse = findViewById(R.id.spinnerCourse);
        spinnerTopic = findViewById(R.id.spinnerTopic);
        radioGroupVote = findViewById(R.id.radioGroupVote);
        buttonSubmit = findViewById(R.id.buttonSubmit);

        // Set up spinners
        List<String> batches = new ArrayList<>();
        // Add batch options here
        ArrayAdapter<String> batchAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, batches);
        batchAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerBatch.setAdapter(batchAdapter);

        List<String> courses = new ArrayList<>();
        // Add course options here
        ArrayAdapter<String> courseAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, courses);
        courseAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCourse.setAdapter(courseAdapter);

        List<String> topics = new ArrayList<>();
        // Add topic options here
        ArrayAdapter<String> topicAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, topics);
        topicAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTopic.setAdapter(topicAdapter);

        // Set up button click listener
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get selected values
                String collegeID = editTextCollegeID.getText().toString();
                String name = editTextName.getText().toString();
                String prn = editTextPRN.getText().toString();
                String batch = spinnerBatch.getSelectedItem().toString();
                String course = spinnerCourse.getSelectedItem().toString();
                String topic = spinnerTopic.getSelectedItem().toString();
                int selectedVoteId = radioGroupVote.getCheckedRadioButtonId();
                RadioButton selectedVote = findViewById(selectedVoteId);
                String vote = selectedVote.getText().toString();

                // Validate inputs (e.g., check if any field is empty)

                // Perform voting submission (e.g., send data to server)

                // Show success message
                Toast.makeText(MainActivity.this, "Vote submitted successfully!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}