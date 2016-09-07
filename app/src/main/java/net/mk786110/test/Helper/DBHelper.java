package net.mk786110.test.Helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import net.mk786110.test.entity.Profile;

import java.util.ArrayList;

/**
 * Created by mkumail on 9/7/16.
 */
public class DBHelper extends SQLiteOpenHelper {


    private static String DATABASE_NAME = "profile";
    private static String TABLE_NAME = "bioData";
    private static String KEY_ID = "id";
    private static String KEY_NAME = "name";
    private static String KEY_PHONE = "phone";
    private static String KEY_EDUCATION = "education";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        Log.d("Query ", "Query is Empty");
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String CreateTable = "CREATE TABLE " + TABLE_NAME + " ( " +
                " " + KEY_ID + " INTEGER PRIMARY KEY," +
                " " + KEY_NAME + " TEXT , " +
                " " + KEY_PHONE + " TEXT, " +
                " " + KEY_EDUCATION + " TEXT )";

//         Toast.makeText(DBHelper.this, " "+ CreateTable, Toast.LENGTH_SHORT).show();

//        Log.d("Query ", CreateTable);
        sqLiteDatabase.execSQL(CreateTable);

    }

    public void addProfile(Profile p) {

        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(KEY_NAME, p.getName());
        cv.put(KEY_PHONE, p.getPhone());
        cv.put(KEY_EDUCATION, p.getEducation());
        db.insert(TABLE_NAME,null,cv);

    }

    public ArrayList<Profile> getProfile() {

        ArrayList<Profile> profileArrayList = new ArrayList<>();

        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor =  db.rawQuery("Select * from " + TABLE_NAME,null);
        if(cursor.moveToFirst())
        {
            do{
                Profile profile = new Profile();
                profile.setId(cursor.getString(0));
                profile.setName(cursor.getString(1));
                profile.setPhone(cursor.getString(2));
                profile.setEducation(cursor.getString(3));
                profileArrayList.add(profile);
            }
            while (cursor.moveToNext());

        }
//        ContentValues cv = new ContentValues();
//        cv.put(KEY_NAME, p.getName());
//        cv.put(KEY_PHONE, p.getPhone());
//        cv.put(KEY_EDUCATION, p.getEducation());
//        db.insert(TABLE_NAME,null,cv);

        return profileArrayList;

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
