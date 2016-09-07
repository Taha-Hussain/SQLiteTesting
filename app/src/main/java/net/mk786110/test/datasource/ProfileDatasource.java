package net.mk786110.test.datasource;

import android.content.Context;

import net.mk786110.test.Helper.DBHelper;
import net.mk786110.test.entity.Profile;

import java.util.ArrayList;

/**
 * Created by mkumail on 9/7/16.
 */
public class ProfileDatasource {

//    Context context;
    DBHelper db;
    public ProfileDatasource(Context context)
    {
//     this.context = context;
     db = new DBHelper(context);
    }

    public ArrayList<Profile> getlist() {


        ArrayList<Profile> arrayList;

        arrayList = db.getProfile();

//        profile1.setName("kumail");
//        profile1.setPhone("01");
//        profile1.setEducation("ned");
//        arrayList.add(profile1);
//
//        profile2.setName("kumail");
//        profile2.setPhone("02");
//        profile2.setEducation("ned");
//        arrayList.add(profile2);
//
//        profile3.setName("kumail");
//        profile3.setPhone("05");
//        profile3.setEducation("ned");
//        arrayList.add(profile3);
//
//        profile3.setName("kumail");
//        profile3.setPhone("04");
//        profile3.setEducation("ned");
//        arrayList.add(profile4);
//
//
//        profile4.setName("kumail");
//        profile4.setPhone("01");
//        profile4.setEducation("ned");
//        arrayList.add(profile4);
//
//        profile5.setName("kumail");
//        profile5.setPhone("03");
//        profile5.setEducation("ned");
//        arrayList.add(profile5);



        return arrayList;
    }
}
