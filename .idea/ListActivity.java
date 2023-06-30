package sg.edu.np.mad.practical6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.Random;

public class ListActivity extends AppCompatActivity {
    int count = 1;
    private static final String TAG = "ListActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        DBHandler db = new DBHandler(this);

        // List User objects
        ArrayList<User> userlist = new ArrayList<>();
        if (db.Count() == 0){
            for (int i = 0; i < 20; i++){
                User newUser = createUser();
                db.addUser(newUser);
            }
        }
        userlist = db.getUsers();

        // Recycler View
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        CustomAdapter custAdapter = new CustomAdapter(ListActivity.this,userlist);
        LinearLayoutManager mylayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mylayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(custAdapter);
    }

    private int randomInt() {
        Random ran = new Random();
        int myRandomNumber = ran.nextInt(100000);
        return myRandomNumber;
    }

    private User createUser(){
        int random1 = randomInt();
        int random2 = randomInt();
        String userName = "Name" + random1;
        String userDescription = "Description " + random2;
        int userID = count;
        boolean userFollowed = false;
        count++;
        User newUser = new User(userName, userDescription, userID, false);
        return newUser;
    }
}