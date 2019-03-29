package com.abualgait.abual.javamvvm.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.abualgait.abual.javamvvm.R;
import com.abualgait.abual.javamvvm.data.model.api.Movie;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {

    private List<Movie> mData;
    private LayoutInflater mInflater;

    // data is passed into the constructor
    public MovieAdapter(Context context, List<Movie> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
    }

    public void addtomovies(List<Movie> movies) {
        this.mData.addAll(movies);
        notifyDataSetChanged();
    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_movie, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.name.setText(mData.get(position).movie_title);
        holder.disc.setText(mData.get(position).movie_disc);
        holder.rate.setRating(Float.parseFloat(mData.get(position).movie_rate));
        Picasso.get().load(mData.get(position).movie_image).into(holder.image);

    }

    // total number of rows
    @Override
    public int getItemCount() {
        return mData.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView name;
        TextView disc;
        ImageView image;
        RatingBar rate;

        ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            disc = itemView.findViewById(R.id.disc);
            image = itemView.findViewById(R.id.image);
            rate = itemView.findViewById(R.id.rate);

        }

        @Override
        public void onClick(View view) {

        }
    }
}