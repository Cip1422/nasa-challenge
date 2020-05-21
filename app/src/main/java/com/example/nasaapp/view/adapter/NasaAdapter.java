package com.example.nasaapp.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.nasaapp.R;
import com.example.nasaapp.model.Item;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class NasaAdapter extends RecyclerView.Adapter<NasaAdapter.NasaImageViewHolder> {
    private List<Item> dataSet;

    public NasaAdapter(List<Item> dataSet) {
        this.dataSet = dataSet;
    }

    public void setDataSet(List<Item> dataSet) {
        this.dataSet = dataSet;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public NasaImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.nasa_item_layout, parent, false);
        return new NasaImageViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull NasaImageViewHolder holder, int position) {
        holder.bindView(dataSet.get(position));
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    class NasaImageViewHolder extends RecyclerView.ViewHolder {

        private final int FIRST_POSITION = 0;

        private ImageView nasaPicImageView;
        private TextView picTitleTextView;
        private TextView picDateTextView;

        NasaImageViewHolder(@NonNull View itemView) {
            super(itemView);

            nasaPicImageView = itemView.findViewById(R.id.nasa_pic_imageview);
            picTitleTextView = itemView.findViewById(R.id.pic_title_textview);
            picDateTextView = itemView.findViewById(R.id.pic_date_textview);
        }

        public void bindView(Item currentItem) {

            Glide.with(itemView.getContext())
                    .setDefaultRequestOptions(RequestOptions.centerCropTransform())
                    .load(currentItem.getLinks().get(FIRST_POSITION).getHref())
                    .into(nasaPicImageView);

            picTitleTextView.setText(currentItem
                    .getData().get(FIRST_POSITION)
                    .getTitle());

            String date = currentItem.getData()
                    .get(FIRST_POSITION)
                    .getDateCreated().substring(0, 10);//To remove zone
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
                Date newDate = sdf.parse(date);
                sdf.applyPattern("MM-dd-yyyy");
                //make sure date is in appropriate format
                picDateTextView.setText(sdf.format(newDate));

            } catch (ParseException e) {
                e.printStackTrace();
            }

        }
    }
}
