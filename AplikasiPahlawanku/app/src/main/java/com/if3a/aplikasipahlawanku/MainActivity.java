package com.if3a.aplikasipahlawanku;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.if3a.aplikasipahlawanku.AdapterCard;
import com.if3a.aplikasipahlawanku.AdapterGrid;
import com.if3a.aplikasipahlawanku.DataPahlawan;
import com.if3a.aplikasipahlawanku.ModelPahlawan;
import java.util.ArrayList;
public class MainActivity extends AppCompatActivity {
    private RecyclerView rvPahlawan;
    private ArrayList<ModelPahlawan> data = new
            ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Mode Card View");
        rvPahlawan = findViewById(R.id.rv_pahlawan);
        rvPahlawan.setHasFixedSize(true);
        data.addAll(DataPahlawan.ambilDataPahlawan());
        tampilDataCard();
    }
    private void tampilDataCard() {
        rvPahlawan.setLayoutManager(new
                LinearLayoutManager(this));
        AdapterCard colokanCard = new AdapterCard(data);
        rvPahlawan.setAdapter(colokanCard);
    }
    private void tampilDataGrid() {
        rvPahlawan.setLayoutManager(new
                GridLayoutManager(this, 2));
        AdapterGrid colokanGrid = new AdapterGrid(data);
        rvPahlawan.setAdapter(colokanGrid);
        colokanGrid.setOnItemClickCallBack(new AdapterGrid.OnItemClickCallBack() {
            @Override
            public void onItemClicked(ModelPahlawan data) {
                Toast.makeText(MainActivity.this, "Pahlawan : " + data.getNama(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_tampilan, menu);

//        int nightMode = AppCompatDelegate.getDefaultNightMode();
//        if (nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
//            AppCompatDelegate.setDefaultNightMode
//                    (AppCompatDelegate.MODE_NIGHT_NO);
//        } else {
//            AppCompatDelegate.setDefaultNightMode
//                    (AppCompatDelegate.MODE_NIGHT_YES);
//        }

        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        ubahModeTampilan(item.getItemId());
        return super.onOptionsItemSelected(item);
    }
    private void ubahModeTampilan(int modeYangDipilih) {
        switch (modeYangDipilih) {
            case R.id.menu_card:
                getSupportActionBar().setTitle("Mode Card View");
                        tampilDataCard();
                break;
            case R.id.menu_grid:
                getSupportActionBar().setTitle("Mode Grid View");
                        tampilDataGrid();
                break;
//            case R.id.menu_night:
//                setTitle("Mode Night");
//                int nightMode;
//                break;
//            case R.id.menu_help:
//                Intent intent = new Intent(Intent.ACTION_DIAL)
        }
    }
}
