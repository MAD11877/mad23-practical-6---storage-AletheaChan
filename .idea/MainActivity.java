package sg.edu.np.mad.practical6;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DBHandler db = new DBHandler(this);

        Button Follow = findViewById(R.id.follow);
        Button Message = findViewById(R.id.message);
        TextView userN = findViewById(R.id.textView2);
        TextView userDesc = findViewById(R.id.textView);

        User user1 = (User) getIntent().getSerializableExtra("key");
        userN.setText(user1.userName);
        userDesc.setText(user1.userDescription);
        Follow.setText(user1.userFollowed ? "Unfollow" : "Follow");

        Follow.setOnClickListener(new View.OnClickListener(){
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view){
                if (!user1.userFollowed){
                    Follow.setText("Unfollow");
                    user1.userFollowed = true;
                    db.updateUser(user1);
                    Toast.makeText(getApplicationContext(), "Follow", Toast.LENGTH_SHORT).show(); }
                else {
                    Follow.setText("Follow");
                    user1.userFollowed = false;
                    db.updateUser(user1);
                }
            }
        });
    }
}