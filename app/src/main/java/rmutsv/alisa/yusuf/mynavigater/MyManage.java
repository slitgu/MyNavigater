package rmutsv.alisa.yusuf.mynavigater;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Sareena on 23/07/2017.
 */

public class MyManage {

    private Context context;
    private MyOpenHelper myOpenHelper;
    private SQLiteDatabase sqLiteDatabase;


    public MyManage(Context context) {
        this.context = context;
        myOpenHelper = new MyOpenHelper(context);
        sqLiteDatabase = myOpenHelper.getWritableDatabase();
    }

    public long addValuToSQLite(String strName,
                                String strDate,
                                String strDistance,
                                String strLat,
                                String strLng){


        ContentValues contentValues =new ContentValues();
        contentValues.put("NameMap" , strName);
        contentValues.put("MyDate" , strDate);
        contentValues.put("Distance" , strDistance);
        contentValues.put("Lat" , strLat);
        contentValues.put("Lng" , strLng);

        return sqLiteDatabase.insert("navigateTABLE", null, contentValues);
    }

} // main class
