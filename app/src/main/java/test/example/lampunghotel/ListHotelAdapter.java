package test.example.lampunghotel;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;


public class ListHotelAdapter extends RecyclerView.Adapter<ListHotelAdapter.ListViewHolder> {
    private ArrayList<Hotel> listHotel;
    private OnItemClickCallback onItemClickCallback;

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    public ListHotelAdapter(ArrayList<Hotel> list) {
        this.listHotel = list;
    }

    @NonNull
    @Override
    public ListHotelAdapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_hotel, viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListHotelAdapter.ListViewHolder holder, int position) {
        Hotel hotel = listHotel.get(position);
        Glide.with(holder.itemView.getContext())
                .load(hotel.getPhoto())
                .apply(new RequestOptions().override(200, 200))
                .into(holder.imgPhoto);
        holder.tvName.setText(hotel.getName());
        holder.tvDetail.setText(hotel.getDetail());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickCallback.onItemClicked(listHotel.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return listHotel.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvDetail;
        ListViewHolder(View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_hotel_photo);
            tvName = itemView.findViewById(R.id.tv_hotel_name);
            tvDetail = itemView.findViewById(R.id.tv_hotel_detail);
        }
    }

    public interface OnItemClickCallback {
        void onItemClicked(Hotel data);
    }
}
