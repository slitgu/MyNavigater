package rmutsv.alisa.yusuf.mynavigater;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private MyManage myManage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create SQLite
        createSQLite();

        // Add Maps Controller
        addMapsController();





    } // main method

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //ToDo
        Log.d("23julyV3","ActivityResult Work");

    }

    private void createSQLite() {
        myManage = new MyManage(MainActivity.this);
    }

    private void addMapsController() {
        ImageView imageView = (ImageView) findViewById(R.id.imvAddMaps);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddMapsActivity.class);
                startActivityForResult(intent, 100);

            }
        });
    }
}  // main class
