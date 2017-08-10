package cahwayan.apps.opus.courses.coursemodel.modules;

import android.arch.lifecycle.LiveData;
import android.view.View;

import java.util.List;

import cahwayan.apps.opus.courses.coursemodel.CourseType;
import cahwayan.apps.opus.user.UserMVP;
import cahwayan.apps.opus.user.UserProgress;

/**
 * Created by felip on 03-Aug-17.
 */

public interface ModuleMVP {

    interface ModuleView {
        void setPresenter(ModulePresenter presenter);
        void setPresenter(UserMVP.UserPresenter userPresenter);
    }

    interface ModulePresenter {

        void init(CourseType courseType);

        void setCourseType(CourseType type);
        CourseType getCourseType();

        void loadModule(View rootView, Module module);

        LiveData<List<Module>> getModuleList();
        LiveData<Module> getActiveModule();

        void updateProgress(View rootView, UserProgress userProgress);
    }

    interface ModuleModel {
        void setModulePresenter(ModulePresenter modulePresenter);
        LiveData<List<Module>> getModuleList(String courseType);

    }


}
