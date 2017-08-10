package cahwayan.apps.opus.user;

import android.arch.lifecycle.LiveData;

import cahwayan.apps.opus.courses.coursemodel.CourseType;

/**
 * Created by felip on 08-Aug-17.
 */

public interface UserMVP {

    interface UserView {
        void setPresenter(UserPresenter presenter);
    }

    interface UserPresenter {
        void saveUser(User user);
        void saveUserProgress(UserProgress userProgress);

        LiveData<User> getUserLiveData();
        LiveData<UserProgress> getUserProgressLiveData();

        void setUserView(UserView view);
        void init(int userId);
    }

    interface UserModel {
        LiveData<User> getUser(int userId);
        LiveData<UserProgress> getUserProgress(String courseName);

        void saveUserProgress(UserProgress userProgress);
        void saveUser(User user);

        void setPresenter(UserPresenter presenter);
    }
}
