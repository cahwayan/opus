package cahwayan.apps.opus.modules;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.mikhaellopez.circularprogressbar.CircularProgressBar;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import cahwayan.apps.opus.R;

import static cahwayan.apps.opus.R.drawable.abc_ic_ab_back_material;

public class ModulesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modules);
        setupActionBar();

    }

    public void onResume() {
        super.onResume();
        final CircularProgressBar pb = findViewById(R.id.pbModule);

        new Handler().post(new Runnable() {
            @Override
            public void run() {
                pb.setProgressWithAnimation(90f);
            }
        });



    }

    private void setupActionBar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final Drawable upArrow = ContextCompat.getDrawable(this, abc_ic_ab_back_material);
        upArrow.setColorFilter(ContextCompat.getColor(this, android.R.color.white), PorterDuff.Mode.SRC_ATOP);


        if(getSupportActionBar() != null) {
            getSupportActionBar().setHomeAsUpIndicator(upArrow);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }
}
