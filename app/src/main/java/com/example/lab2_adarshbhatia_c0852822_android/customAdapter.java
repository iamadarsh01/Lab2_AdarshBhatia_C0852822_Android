package com.example.lab2_adarshbhatia_c0852822_android;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class customAdapter extends RecyclerView.Adapter<customAdapter.MyViewHolder> {

   private Context context;
   //Need to refresh the page in order to see updated changes
   Activity activity;
  private ArrayList book_id, book_title, book_author, book_price, book_genre;
  int position;



    customAdapter(Activity activity,
                  Context context,
                  ArrayList book_id,
                  ArrayList book_title,
                  ArrayList book_author,
                  ArrayList book_price,
                  ArrayList book_genre){
        this.activity = activity;
        this.context = context;
        this.book_id = book_id;
        this.book_title = book_title;
        this.book_author = book_author;
        this.book_price = book_price;
        this.book_genre = book_genre;


    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
       View view = inflater.inflate(R.layout.my_row, parent, false);
return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {



        holder.book_id_text.setText(String.valueOf(book_id.get(position)));
        holder.book_title_text.setText(String.valueOf(book_title.get(position)));
        holder.book_author_text.setText(String.valueOf(book_author.get(position)));
        holder.book_price_text.setText(String.valueOf(book_price.get(position)));
        holder.book_genre_text.setText(String.valueOf(book_genre.get(position)));
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context, UpdateActivity.class);
                intent.putExtra("id",String.valueOf(book_id.get(holder.getAdapterPosition())));
                intent.putExtra("title",String.valueOf(book_title.get(holder.getAdapterPosition())));
                intent.putExtra("author",String.valueOf(book_author.get(holder.getAdapterPosition())));
                intent.putExtra("price",String.valueOf(book_price.get(holder.getAdapterPosition())));
                intent.putExtra("genre",String.valueOf(book_genre.get(holder.getAdapterPosition())));




                activity.startActivityForResult(intent, 1);
            }
        });


    }

    @Override
    public int getItemCount() {
        return book_id.size();
    }

    public  class  MyViewHolder extends RecyclerView.ViewHolder {

        TextView book_id_text, book_title_text, book_author_text, book_price_text, book_genre_text;
        LinearLayout mainLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            book_id_text = itemView.findViewById(R.id.book_id_text);
            book_title_text = itemView.findViewById(R.id.book_title_text);
            book_author_text = itemView.findViewById(R.id.book_author_text);
            book_price_text = itemView.findViewById(R.id.book_price_text);
            book_genre_text = itemView.findViewById(R.id.book_genre_text);
            mainLayout = itemView.findViewById(R.id.mainLayout);




        }
    }


}
