package com.mcs.kalherath.playground;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;


public class SeriesAdapter extends RecyclerView.Adapter<SeriesAdapter.MyViewHolder> {

        private List<SeriesObject> seriesList;
        private Context mContext;

        public class MyViewHolder extends RecyclerView.ViewHolder {
            public TextView title;
            public TextView description;
            public ImageView poster;
            public LinearLayout parentLayout;

            public MyViewHolder(View view) {
                super(view);
                poster = view.findViewById(R.id.showPoster);
                title = view.findViewById(R.id.showTitle);
                description = view.findViewById(R.id.showDescription);
                parentLayout = view.findViewById(R.id.show_parent);
            }
        }


        public SeriesAdapter(Context context, List<SeriesObject> seriesList) {
            this.mContext = context;
            this.seriesList = seriesList;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.show_item, parent, false);


            return new MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {



            final SeriesObject series = seriesList.get(position);
            holder.title.setText(series.getTitle());
            Picasso.with(mContext).load(series.getImage()).into(holder.poster);
            holder.description.setText(series.getDesc());


        }

        @Override
        public int getItemCount() {
            return seriesList.size();
        }
    }

