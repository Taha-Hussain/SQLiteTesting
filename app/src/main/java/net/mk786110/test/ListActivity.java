package net.mk786110.test;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import net.mk786110.test.adaptor.ProfileAdaptore;
import net.mk786110.test.datasource.ProfileDatasource;
import net.mk786110.test.entity.Profile;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    ProfileDatasource profileDatasource;
    ProfileAdaptore profileAdaptore;
    ArrayList<Profile> arrayList;
    ListView listView;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        context = this;
        String ename = "ned";

        listView = (ListView) findViewById(R.id.listview);


        profileDatasource = new ProfileDatasource(this);
        arrayList = profileDatasource.getlist();
        profileAdaptore = new ProfileAdaptore(context, R.layout.activity_row, arrayList);

            listView.setAdapter(profileAdaptore);

    }
}
