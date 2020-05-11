package com.sathya.qrscanner;
import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class OutputActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        final String link = intent.getStringExtra("URL");
        setContentView(R.layout.activity_output);
        EditText url = findViewById(R.id.url);
        Button button = findViewById(R.id.btnAction);
        try {
            url.setText(link);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_WEB_SEARCH);
                browserIntent.putExtra(SearchManager.QUERY,link);
                startActivity(browserIntent);
            }
        });
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(OutputActivity.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

}
