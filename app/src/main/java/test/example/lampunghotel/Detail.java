package test.example.lampunghotel;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import static android.net.Uri.parse;

public class Detail extends AppCompatActivity {
    public static final String EXTRA_DATA = "extra_data";

    @SuppressLint("Assert")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Hotel hotel = getIntent().getParcelableExtra(EXTRA_DATA);
        TextView tvname = findViewById(R.id.tv_hotel_name_detail);
//        String name = getIntent().getStringExtra(EXTRA_NAME);
        tvname.setText(hotel.getName());

        TextView tvdetail = findViewById(R.id.tv_item_detail);
        String detail = hotel.getDetail();
//        if (detail == null) {
//            detail = "Detail Hotel cannot null";
//        }
        tvdetail.setText(detail);

        ImageView tvimg = findViewById(R.id.img_hotel_photo_detail);
        String image = hotel.getPhoto();
        Glide.with(this)
                .load(image)
                .apply(new RequestOptions().override(55, 55))
                .into(tvimg);
    }
}
