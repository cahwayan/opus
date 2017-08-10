package cahwayan.apps.opus.courses;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.LinearLayout;

import com.mikhaellopez.circularprogressbar.CircularProgressBar;

import javax.inject.Inject;

import cahwayan.apps.opus.OpusApplication;
import cahwayan.apps.opus.R;
import cahwayan.apps.opus.courses.coursemodel.modules.ModuleFragment;
import cahwayan.apps.opus.injection.component.application.ApplicationComponent;
import cahwayan.apps.opus.util.FragmentHelper;

import static cahwayan.apps.opus.R.drawable.abc_ic_ab_back_material;

public class CourseActivity extends AppCompatActivity {

    private final String MODULE_FRAGMENT_TAG = "moduleFragmentTag";

    private LinearLayout containerModule;

    @Inject ModuleFragment moduleFragment;

    @Inject
    public CourseActivity() {}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);
        setupActionBar();

        containerModule = findViewById(R.id.containerCardModule);

        ApplicationComponent applicationComponent = ((OpusApplication)getApplication()).getApplicationComponent();
        moduleFragment = applicationComponent.moduleFragment();
        applicationComponent.inject(this);

        FragmentHelper.addFragmentOnlyOnce(getSupportFragmentManager(), R.id.containerCardModule, moduleFragment, MODULE_FRAGMENT_TAG);

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
