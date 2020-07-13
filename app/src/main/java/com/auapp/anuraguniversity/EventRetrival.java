package com.auapp.anuraguniversity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class EventRetrival extends AppCompatActivity {
    RecyclerView eventslist;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_retrival);
        eventslist = (RecyclerView) findViewById(R.id.recyclerviewevent);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setReverseLayout(true);
        linearLayoutManager.setStackFromEnd(true);
        eventslist.setLayoutManager(linearLayoutManager);
        validateeventslist();
    }

    private void validateeventslist() {
        reference = FirebaseDatabase.getInstance().getReference().child("Events");
        FirebaseRecyclerAdapter<Events, EventRetrival.ViewHolder123> firebaseRecyclerAdapter =
                new FirebaseRecyclerAdapter<Events, ViewHolder123>(
                        Events.class, R.layout.events_info, ViewHolder123.class, reference
                ) {
                    @Override
                    protected void populateViewHolder(ViewHolder123 viewHolder123, Events events, int i) {
                        final String key = getRef(i).getKey();
                        viewHolder123.setEname(events.getEventname());
                        viewHolder123.setDate(events.getData());
                        viewHolder123.setImage(events.getImg());
                        viewHolder123.setInfo(events.getProfil());
                        viewHolder123.setStudents(events.getTstudent());
                        viewHolder123.setClub(events.getName());
                        viewHolder123.setLink(events.getLink());
                        viewHolder123.setOlink(events.getOlink());
//                        final String s1 = events.getEventname();
//                        final String s2 = events.getData();
//                        final String s3 = events.getImg();
//                        final String s4 = events.getProfil();
//                        final String s5 = events.getTstudent();
//                        final String s6 = events.getName();
//                        final String s7 = events.getLink();

                        viewHolder123.mview.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(EventRetrival.this,Android_details_student.class);
                                intent.putExtra("key",key);
//                                intent.putExtra("a1",s1);
//                                intent.putExtra("a2",s2);
//                                intent.putExtra("a3",s3);
//                                intent.putExtra("a4",s4);
//                                intent.putExtra("a5",s5);
//                                intent.putExtra("a6",s6);
//                                intent.putExtra("a7",s7);
                                startActivity(intent);
                            }
                        });
                    }
                };
        eventslist.setAdapter(firebaseRecyclerAdapter);
    }

    public static class ViewHolder123 extends RecyclerView.ViewHolder {
        View mview;

        public ViewHolder123(@NonNull View itemView) {
            super(itemView);
            mview = itemView;
        }

        public void setEname(String ename) {
            TextView t1 = mview.findViewById(R.id.retrivalevent);
            t1.setText(ename);
        }

        public void setDate(String date) {
            TextView t1 = mview.findViewById(R.id.retrivalbranch);
            t1.setText(date);
        }

        public void setImage(String image) {
            {
                ImageView imageView = mview.findViewById(R.id.retrivalimg);
                Picasso.get().load(image).into(imageView);
            }

        }

        public void setInfo(String info) {
            TextView t2 = mview.findViewById(R.id.retrivalt1);
            t2.setText(info);
        }

        public void setStudents(String students) {
            TextView t2 = mview.findViewById(R.id.retrivalt2);
            t2.setText(students);
        }

        public void setLink(String link) {
            TextView t4 = mview.findViewById(R.id.retrivallink);
            if (!TextUtils.isEmpty(link)) {
                t4.setVisibility(View.VISIBLE);
                t4.setText(link);
            }
        }
        public void setClub(String clch){
            TextView t5 = mview.findViewById(R.id.chorcl);
            t5.setText(clch);
        }
        public void setOlink(String olink){
            TextView t6 = mview.findViewById(R.id.oplink);
            t6.setText(olink);
        }
    }
}