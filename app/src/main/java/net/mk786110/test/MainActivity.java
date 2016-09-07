package net.mk786110.test;

import android.app.WallpaperManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import net.mk786110.test.Helper.DBHelper;
import net.mk786110.test.adaptor.ProfileAdaptore;
import net.mk786110.test.datasource.ProfileDatasource;
import net.mk786110.test.entity.Profile;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    Bitmap photo;
    Context context;
    DBHelper db;

    private int CAMERA_REQUEST = 200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new DBHelper(this);
        context = this;

        Profile p = new Profile();
        p.setName("Taha");
        p.setPhone("012343534");
        p.setEducation("About To Graduate");
        db.addProfile(p);

//        p.setName("Kumail");
//        p.setPhone("987654321");
//        p.setEducation("About To Die P ");
//        db.addProfile(p);

    }

    public void onclickListview(View view)

    {
        Intent intent = new Intent(this, ListActivity.class);
        startActivity(intent);
    }

    public void onclickcamera(View view)

    {
        imageView = (ImageView) findViewById(R.id.imageview);
        Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(cameraIntent, CAMERA_REQUEST);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CAMERA_REQUEST && resultCode == RESULT_OK) {
            photo = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(photo);
        }

      /*  if (requestCode == 200 && resultCode == RESULT_OK) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(photo);
        }*/

    }

    public void onclickwalpaper(View view)

    {
        try {

            WallpaperManager wallpaperManager = WallpaperManager.getInstance(context);
            wallpaperManager.setBitmap(photo);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
