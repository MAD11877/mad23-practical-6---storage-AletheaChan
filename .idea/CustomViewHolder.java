package sg.edu.np.mad.practical6;

import android.media.Image;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class CustomViewHolder extends RecyclerView.ViewHolder {
    ImageView image;
    TextView txt;
    TextView txtDesc;

    public ViewHolder(View itemView){
        super(itemView);
        image = itemView.findViewById(R.id.imageView3);
        txt = itemView.findViewById(R.id.textView3);
        txtDesc = itemView.findViewById(R.id.textView4);
    }
}

