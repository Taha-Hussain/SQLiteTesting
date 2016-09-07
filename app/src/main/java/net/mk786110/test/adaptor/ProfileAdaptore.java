package net.mk786110.test.adaptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

import net.mk786110.test.R;
import net.mk786110.test.entity.Profile;

import java.util.ArrayList;

/**
 * Created by mkumail on 9/7/16.
 */
public class ProfileAdaptore extends ArrayAdapter<Profile> {
    View rowView;
    Context context;
    String ename;

    public ProfileAdaptore(Context context, int resource, ArrayList<Profile> object) {
        super(context, resource, object);


        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Profile item = getItem(position);



            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView = inflater.inflate(R.layout.activity_row, parent, false);
            TextView name = (TextView) rowView.findViewById(R.id.name);
            RatingBar rate = (RatingBar) rowView.findViewById(R.id.rate);
            TextView education = (TextView) rowView.findViewById(R.id.education);

            name.setText(item.getName());
            rate.setRating(Integer.parseInt(item.getPhone()));
            education.setText(item.getEducation());


        return rowView;


    }
}
