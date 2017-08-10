package cahwayan.apps.opus.courses.coursemodel.modules;

import android.arch.lifecycle.LiveData;

import java.util.List;

import javax.inject.Inject;

import cahwayan.apps.opus.courses.database.dao.ModuleDao;

import static cahwayan.apps.opus.courses.coursemodel.modules.ModuleMVP.ModulePresenter;
import static cahwayan.apps.opus.courses.coursemodel.modules.ModuleMVP.ModuleModel;

/**
 * Created by felip on 07-Aug-17.
 */

public class ModuleModelImpl implements ModuleModel {

    private ModulePresenter modulePresenter;

    private ModuleDao moduleDao;

    @Inject
    public ModuleModelImpl(ModuleDao moduleDao, ModulePresenter presenter) {
        this.moduleDao = moduleDao;
        this.modulePresenter = presenter;
    }

    public void setModulePresenter(ModulePresenter modulePresenter) {
        this.modulePresenter = modulePresenter;
    }

    @Override
    public LiveData<List<Module>> getModuleList(String courseType) {
        return moduleDao.getModuleList(courseType);
    }


}
