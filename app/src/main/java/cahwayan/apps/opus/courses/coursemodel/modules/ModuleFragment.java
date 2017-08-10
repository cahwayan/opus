package cahwayan.apps.opus.courses.coursemodel.modules;

import android.arch.lifecycle.LifecycleFragment;
import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.mikhaellopez.circularprogressbar.CircularProgressBar;

import cahwayan.apps.opus.R;
import cahwayan.apps.opus.courses.coursemodel.CourseType;
import cahwayan.apps.opus.courses.coursemodel.modules.ModuleMVP.ModulePresenter;
import cahwayan.apps.opus.custom.SublimeTextView;
import cahwayan.apps.opus.user.User;
import cahwayan.apps.opus.user.UserMVP;
import cahwayan.apps.opus.user.UserProgress;

/**
 * Created by felip on 02-Aug-17.
 */

public class ModuleFragment extends LifecycleFragment implements ModuleMVP.ModuleView, UserMVP.UserView {

    private ModulePresenter modulePresenter;
    private UserMVP.UserPresenter userPresenter;

    private View rootView;

    private SublimeTextView tvModuleIndicatorTitle;
    private SublimeTextView tvTitleModule;
    private SublimeTextView tvProgress;
    private SublimeTextView tvEnterModule;

    private CircularProgressBar pbModule;

    private ImageView ivModule;

    public static ModuleFragment newInstance(ModulePresenter modulePresenter, UserMVP.UserPresenter userPresenter) {
        ModuleFragment moduleFragment = new ModuleFragment();
        moduleFragment.setPresenter(modulePresenter);
        moduleFragment.setPresenter(userPresenter);
        return moduleFragment;
    }

    @Override
    public void setPresenter(ModulePresenter modulePresenter) {
        this.modulePresenter = modulePresenter;
    }

    @Override
    public void setPresenter(UserMVP.UserPresenter presenter) {
        this.userPresenter = presenter;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_module, container, false);

        tvModuleIndicatorTitle = rootView.findViewById(R.id.tvModuleIndicatorTitle);
        tvTitleModule = rootView.findViewById(R.id.tvTitleModule);
        tvProgress = rootView.findViewById(R.id.tvProgress);
        tvEnterModule = rootView.findViewById(R.id.tvEnterModule);

        pbModule = rootView.findViewById(R.id.pbModule);

        ivModule = rootView.findViewById(R.id.ivModule);

        initPresenter();


        return rootView;
    }

    private void initPresenter() {
        modulePresenter.init(CourseType.FOUNDATION);

        modulePresenter.getActiveModule().observe(this, new Observer<Module>() {
            @Override
            public void onChanged(@Nullable Module module) {
                modulePresenter.loadModule(rootView, module);
            }
        });

        userPresenter.init(0 /*mock for now */);
        userPresenter.getUserProgressLiveData().observe(this, new Observer<UserProgress>() {
            @Override
            public void onChanged(@Nullable UserProgress userProgress) {
                modulePresenter.updateProgress(rootView, userProgress);
            }
        });
    }


}
