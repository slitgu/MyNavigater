package rmutsv.alisa.yusuf.mynavigater;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Add Maps Controller
        addMapsController();





    } // main method

    private void addMapsController() {
        ImageView imageView = (ImageView) findViewById(R.id.imvAddMaps);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, AddMapsActivity.class));

            }
        });
    }
}  // main class
