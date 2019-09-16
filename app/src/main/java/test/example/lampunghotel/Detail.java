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
    public static final String EXTRA_NAME = "extra_name";
    public static final String EXTRA_DETAIL = "extra_detail";
    public static final String EXTRA_IMAGE = "extra_image";

    @SuppressLint("Assert")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView tvname = findViewById(R.id.tv_hotel_name);
        String name = getIntent().getStringExtra(EXTRA_NAME);
        tvname.setText(name);

        TextView tvdetail = findViewById(R.id.tv_hotel_detail);
        String detail = getIntent().getStringExtra(EXTRA_DETAIL);
        tvdetail.setText(detail);

        ImageView tvimg = findViewById(R.id.img_hotel_photo);
        String image = getIntent().getStringExtra(EXTRA_IMAGE);
        Glide.with(this)
                .load(image)
                .apply(new RequestOptions().override(200, 200))
                .into(tvimg);
    }
}
