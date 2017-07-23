package rmutsv.alisa.yusuf.mynavigater;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private MyManage myManage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Create SQLite
        createSQLite();

        // Add Maps Controller
        addMapsController();

        //Create ListView
        createListView();


    } // main method

    private void createListView() {
        ListView listView = (ListView) findViewById(R.id.livMap);

        try {

            SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(MyOpenHelper.databaseName,
                    MODE_PRIVATE, null);
            Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM navigateTABLE", null);
            cursor.moveToFirst();

            String[] idStrings = new String[cursor.getCount()];
            String[] nameStrings = new String[cursor.getCount()];
            String[] dateStrings = new String[cursor.getCount()];
            String[] distanceStrings = new String[cursor.getCount()];
            String[] latStrings = new String[cursor.getCount()];
            String[] lngStrings = new String[cursor.getCount()];

            for (int i = 0; i < cursor.getCount(); i += 1) {

                idStrings[i] = cursor.getString(0);
                nameStrings[i] = cursor.getString(1);
                dateStrings[i] = cursor.getString(2);
                distanceStrings[i] = cursor.getString(3);
                latStrings[i] = cursor.getString(4);
                lngStrings[i] = cursor.getString(5);

                Log.d("23JulyV3", "Name[" + i + "] ==> " + nameStrings[i]);

                cursor.moveToNext();
            }   // for

            cursor.close();

            MyAdapter myAdapter = new MyAdapter(MainActivity.this,
                    nameStrings, dateStrings, distanceStrings);
            listView.setAdapter(myAdapter);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }   // createListView

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //ToDo
        Log.d("23JulyV3", "ActivityResult Work");

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