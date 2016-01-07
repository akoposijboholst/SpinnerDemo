package android.boholstjy.solarsystem;

import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    ArrayAdapter<CharSequence> adapter;
    private TypedArray planetsImage;
    ImageView imgPlanet;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        planetsImage = getResources().obtainTypedArray(R.array.planets_img);
        imgPlanet = (ImageView)findViewById(R.id.planet_image);

        spinner = (Spinner)findViewById(R.id.planets_spinner);
        adapter = ArrayAdapter.createFromResource(this,
                R.array.planets_array,
                android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                imgPlanet.setImageResource(planetsImage.getResourceId(position, -1));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}