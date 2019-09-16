package test.example.lampunghotel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvHotels;
    private ArrayList<Hotel> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvHotels = findViewById(R.id.rv_hotel);
        rvHotels.setHasFixedSize(true);

        list.addAll(HotelData.getListData());
        showRecyclerList();
    }

    private void showRecyclerList(){
        //    rvHeroes.setLayoutManager(new LinearLayoutManager(this));
        rvHotels.setLayoutManager(new LinearLayoutManager(this));
        ListHotelAdapter listHeroAdapter = new ListHotelAdapter(list);
        rvHotels.setAdapter(listHeroAdapter);

        listHeroAdapter.setOnItemClickCallback(new ListHotelAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Hotel data) {
                showSelectedHotel(data);
            }
        });
    }

    private void showSelectedHotel(Hotel hotel) {
        Toast.makeText(this, "Kamu memilih " + hotel.getName(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, Detail.class);
        intent.putExtra(Detail.EXTRA_NAME, hotel.getName());
        intent.putExtra(Detail.EXTRA_DETAIL,hotel.getDetail());
        intent.putExtra(Detail.EXTRA_IMAGE,hotel.getPhoto());
        startActivity(intent);
    }

    private void setActionBarTitle(String title) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent = new Intent(this, Account.class);
        startActivity(intent);
        return super.onOptionsItemSelected(item);
    }
}
