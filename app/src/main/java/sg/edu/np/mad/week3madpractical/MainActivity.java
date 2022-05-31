package sg.edu.np.mad.week3madpractical;

import androidx.appcompat.app.AppCompatActivity;

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

        Button followButton = findViewById(R.id.follow);
        Button messageButton = findViewById(R.id.message);


        TextView helloWord = findViewById(R.id.textView);
        TextView randomText = findViewById(R.id.randomtext);

        //Receiving intent from the RecyclerView
        Intent receivedFromListActivity = getIntent();
        String name = receivedFromListActivity.getStringExtra("Username");
        String description = receivedFromListActivity.getStringExtra("Description");
        //Boolean followedStatus = receivedFromListActivity.getBooleanExtra("Follow Status", false);

        //Set Text to the String from Intent
        helloWord.setText(name);
        randomText.setText(description);

        User zheWei = new User();
        zheWei.name = "Zhe Wei";
        zheWei.description = "Week 2 Practical";
        zheWei.id = 23456;
        zheWei.followed = false;

        followButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (User.followed != true){
                    followButton.setText("Unfollow");
                    Toast.makeText(MainActivity.this, "Follow", Toast.LENGTH_SHORT).show();
                    User.followed = true;
                }
                else{
                    followButton.setText("Follow");
                    Toast.makeText(MainActivity.this, "Unfollow", Toast.LENGTH_SHORT).show();
                    User.followed = false;
                }
            }
        });

        messageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainActivity = new Intent(MainActivity.this, MessageGroup.class);
                startActivity(mainActivity);
            }
        });





    }




}