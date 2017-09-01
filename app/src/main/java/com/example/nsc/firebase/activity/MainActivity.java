package com.example.nsc.firebase.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.nsc.firebase.R;
import com.example.nsc.firebase.adapter.CommentAdapter;
import com.example.nsc.firebase.model.Comment;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    CommentAdapter adapter;
    FirebaseDatabase database;
    DatabaseReference myRef;
    EditText edtComment;
    Button btnCommit;
    Button btnCancel;
    RecyclerView rvComment;
    ArrayList<Comment> commentArrayList = new ArrayList<>();
    DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
    Date today = Calendar.getInstance().getTime();
    String date = df.format(today);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.e("date", "onCreate: "+date);

        bindUI();
        setAdapter();
        initInstance();
    }

    private void bindUI() {
        rvComment = (RecyclerView) findViewById(R.id.rvComment);
        edtComment = (EditText) findViewById(R.id.edtComment);
        btnCancel = (Button) findViewById(R.id.btnCancel);
        btnCommit = (Button) findViewById(R.id.btnCommit);
    }

    private void setAdapter() {
        rvComment.setLayoutManager(new LinearLayoutManager(this));
        adapter = new CommentAdapter(getApplicationContext(),commentArrayList);
        rvComment.setAdapter(adapter);

    }

    private void initInstance() {

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("Channel1");

        showData();

        btnCommit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textComment = edtComment.getText().toString();
                String name = "Chakhrit Supapol";

                Comment comment1 = new Comment(name, date , textComment);

                if (!textComment.isEmpty()) {

                    myRef.push().setValue(comment1);
                }

                edtComment.setText("");
            }
        });
    }

    private void showData() {
        myRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                commentArrayList.add(dataSnapshot.getValue(Comment.class));
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(MainActivity.this, "onCancel", Toast.LENGTH_SHORT).show();
            }
        });
    }


}
