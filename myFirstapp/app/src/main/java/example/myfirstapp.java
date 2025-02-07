package example;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the TextView and set dummy content
        TextView textView = findViewById(R.id.dummyText);
        textView.setText("Hello, this is some dummy content!");
    }
}
