package sg.edu.np.mad.week3madpractical;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

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
        User userObject = (User) receivedFromListActivity.getSerializableExtra("User Object");


        //Set Text to the String from Intent
        helloWord.setText(userObject.name);
        randomText.setText(userObject.description);


        followButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!userObject.followed){
                    followButton.setText("Unfollow");
                    Toast.makeText(MainActivity.this, "Follow", Toast.LENGTH_SHORT).show();
                    userObject.followed= true;
                }
                else{
                    followButton.setText("Follow");
                    Toast.makeText(MainActivity.this, "Unfollow", Toast.LENGTH_SHORT).show();
                    userObject.followed = false;
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