package com.example.notes.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.notes.R;
import com.example.notes.database.Note;
import com.example.notes.viewmodel.NoteViewModel;

public class MainActivity extends AppCompatActivity {
    private NoteViewModel viewModel;
    private EditText inputTitle;
    private static final String KEY_DRAFT = "note_draft";
    private Note noteToUpdate = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputTitle = findViewById(R.id.edit_text_title);
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        final NoteAdapter adapter = new NoteAdapter();
        recyclerView.setAdapter(adapter);

        if (savedInstanceState != null) {
            inputTitle.setText(savedInstanceState.getString(KEY_DRAFT));
        }

        viewModel = new ViewModelProvider(this).get(NoteViewModel.class);
        viewModel.getAllNotes().observe(this, adapter::setNotes);

        adapter.setOnNoteClickListener(new NoteAdapter.OnNoteClickListener() {
            @Override
            public void onNoteClick(Note note) {
                noteToUpdate = note;
                inputTitle.setText(note.getTitle());
            }

            @Override
            public void onDeleteClick(Note note) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Delete Note")
                        .setMessage("Are you sure?")
                        .setPositiveButton("Delete", (dialog, which) -> viewModel.delete(note))
                        .setNegativeButton("Cancel", null)
                        .show();
            }
        });

        findViewById(R.id.button_add).setOnClickListener(v -> {
            String title = inputTitle.getText().toString();
            if (!title.isEmpty()) {
                if (noteToUpdate != null) {
                    noteToUpdate.setId(noteToUpdate.getId()); // Keep existing ID
                    // Actually, update logic:
                    Note updatedNote = new Note(title);
                    updatedNote.setId(noteToUpdate.getId());
                    viewModel.update(updatedNote);
                    noteToUpdate = null;
                } else {
                    viewModel.insert(new Note(title));
                }
                inputTitle.setText("");
            }
        });

        findViewById(R.id.button_start_quiz).setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, QuizActivity.class);
            startActivity(intent);
        });
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(KEY_DRAFT, inputTitle.getText().toString());
    }
}