package cahwayan.apps.opus.courses.coursemodel.modules;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.view.View;
import android.widget.ImageView;

import com.mikhaellopez.circularprogressbar.CircularProgressBar;

import java.util.List;

import cahwayan.apps.opus.R;
import cahwayan.apps.opus.courses.coursemodel.CourseType;
import cahwayan.apps.opus.courses.coursemodel.modules.Module;
import cahwayan.apps.opus.custom.SublimeTextView;
import cahwayan.apps.opus.user.UserProgress;

import static cahwayan.apps.opus.courses.coursemodel.modules.ModuleMVP.*;

/**
 * Created by felip on 07-Aug-17.
 */

public class ModulePresenterImpl implements ModulePresenter {

    private String courseType;

    private ModuleView moduleView;
    private ModuleModel moduleModel;

    private LiveData<List<Module>> moduleList;
    private MutableLiveData<Module> activeModule;

    public ModulePresenterImpl() {}

    @Override
    public void setCourseType(CourseType type) {
        this.courseType = type.name();
    }

    @Override
    public CourseType getCourseType() {
        return CourseType.valueOf(courseType);
    }

    @Override
    public void loadModule(View rootView, Module module) {

        if(rootView != null && module != null) {
            SublimeTextView tvTitleModule = rootView.findViewById(R.id.tvTitleModule);

            SublimeTextView tvEnterModule = rootView.findViewById(R.id.tvEnterModule);


            ImageView ivModule = rootView.findViewById(R.id.ivModule);

            tvTitleModule.setText(module.getTitle());
        }
    }

    @Override
    public void updateProgress(View rootView, UserProgress userProgress) {

        if(rootView != null && userProgress != null) {
            SublimeTextView tvModuleIndicatorTitle = rootView.findViewById(R.id.tvModuleIndicatorTitle);
            SublimeTextView tvProgress = rootView.findViewById(R.id.tvProgress);
            CircularProgressBar pbModule = rootView.findViewById(R.id.pbModule);

            // TODO: change module id for user progress when available
            tvModuleIndicatorTitle.setText("Capítulo " + userProgress.getModuleProgress() +":");
            tvProgress.setText(userProgress.getCurrentStageProgress() + "/X etapas concluídas");
            pbModule.setProgressWithAnimation(userProgress.getCurrentStageProgress());
        }

    }

    /**
     * TODO: Inject executor if crash bcuz main thread
     * */
    @Override
    public void init(CourseType courseType) {
        if(moduleList.getValue() == null) {
            moduleList = moduleModel.getModuleList(courseType.name());
        }
    }

    public MutableLiveData<Module> getActiveModule() {
        if(activeModule.getValue() != null) {
            activeModule.setValue(moduleList.getValue().get(0));
        }

        return activeModule;
    }

    public LiveData<List<Module>> getModuleList() {
        return moduleList;
    }
}
