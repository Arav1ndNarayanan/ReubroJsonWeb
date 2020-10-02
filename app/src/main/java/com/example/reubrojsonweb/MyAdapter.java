package com.example.reubrojsonweb;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {


    String[] id;
    String[] name;
    String[] gender;
    String[] mail;
    String[] phoneH;
    String[] phoneO;
    String[] mobile;
            int count ;

            Context context;

            public MyAdapter(Context ct, String[] jid, String[] jname, String[] jgender, String[] jmail, String[] jphoneh, String[] jphoneo, String[] jmobile,int c){


                context=ct;
                id=jid;
                name=jname;
                gender=jgender;
                mail=jmail;
                phoneH=jphoneh;
                phoneO=jphoneo;
                mobile=jmobile;
               count=c;

            }

            @NonNull
            @Override
            public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {

                LayoutInflater inflater=LayoutInflater.from(context);
                View view = inflater.inflate(R.layout.my_row, parent , false);
                return new MyViewHolder(view);
            }

            @Override
            public void onBindViewHolder(@NonNull MyViewHolder holder, int i) {
                holder.mytext1.setText(id[i]);
                holder.mytext2.setText(name[i]);
                holder.mytext3.setText(gender[i]);
                holder.mytext4.setText(mail[i]);
                holder.mytext5.setText(phoneH[i]);
                holder.mytext6.setText(phoneO[i]);
                holder.mytext7.setText(mobile[i]);
                Toast.makeText(context, String.valueOf(count), Toast.LENGTH_SHORT).show();
            }

            @Override
            public int getItemCount() {
                return count;
            }

            public static class MyViewHolder extends RecyclerView.ViewHolder {

                TextView mytext1,mytext2,mytext3,mytext4,mytext5,mytext6,mytext7,mytext8,mytext9;
               // ImageView myimage;
                public MyViewHolder(@NonNull View itemView) {
                    super(itemView);

                    mytext1=itemView.findViewById(R.id.textView);
                    mytext2=itemView.findViewById(R.id.textView2);
                    mytext3=itemView.findViewById(R.id.textView3);
                    mytext4=itemView.findViewById(R.id.textView4);
                    mytext5=itemView.findViewById(R.id.textView5);
                    mytext6=itemView.findViewById(R.id.textView6);
                    mytext7=itemView.findViewById(R.id.textView7);

                }
            }



}
