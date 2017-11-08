package bt.gov.rsta.safejourney;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by user on 11/8/2017.
 */

class CustomAdapter extends ArrayAdapter<String>{

    CustomAdapter(Context context, String [] list) {

        super(context, R.layout.custom_home1, list);
    }

    @Override
    public View getView(int position, View convertVIew, ViewGroup parent) {
        LayoutInflater viewInflater = LayoutInflater.from(getContext());
        View customView = viewInflater.inflate(R.layout.custom_home1, parent, false);

        String singleListItem = getItem(position);
        TextView tView = customView.findViewById(R.id.textView4);
        ImageView iView = customView.findViewById(R.id.imageView3);

        tView.setText(singleListItem);
        iView.setImageResource(R.drawable.emer);
        return customView;


    }
}
