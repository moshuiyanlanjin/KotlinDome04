package RecyclerView;

import android.app.Activity;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lf.javademo.R;

import java.util.List;

class DemoMainAdapter implements RecyclrView.Adapter {

    private Activity activity;
    private List<String> lists;

    LayoutInflater inflater;
    private int height;

    public DemoMainAdapter(Activity activity, List<String> lists) {
        this.activity = activity;
        this.lists = lists;
        inflater = LayoutInflater.from(activity);
        Resources resources = activity.getResources();
        height = 80;
    }

    @Override
    public View onCreatrViewHolder(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.item_recy,parent,false);
        TextView text = convertView.findViewById(R.id.text);
       text.setText(lists.get(position));
        return convertView;
    }

    @Override
    public View onBinderViewHolder(int position, View convertView, ViewGroup parent) {
     //   convertView = inflater.inflate(R.layout.item_recy,parent);
        TextView text = convertView.findViewById(R.id.text);
        text.setText(lists.get(position));
        return convertView;
    }

    @Override
    public int getItemViewType(int row) {
        if (row == 0){
            return 1;
        }
        return 0;
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public int getCount() {
        return lists.size();
    }

    @Override
    public int getHeight(int index) {
        return height;
    }
}
