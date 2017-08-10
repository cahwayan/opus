package cahwayan.apps.opus.user;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by felip on 08-Aug-17.
 */

@Entity
public class UserProgress {

    @PrimaryKey
    private String courseName;
    private int moduleProgress;
    private int currentStageProgress;
    private int currentLessonProgress;

    public UserProgress(String courseName, int moduleProgress, int currentStageProgress, int currentLessonProgress) {
        this.courseName = courseName;
        this.moduleProgress = moduleProgress;
        this.currentStageProgress = currentStageProgress;
        this.currentLessonProgress = currentLessonProgress;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getModuleProgress() {
        return moduleProgress;
    }

    public void setModuleProgress(int moduleProgress) {
        this.moduleProgress = moduleProgress;
    }

    public int getCurrentStageProgress() {
        return currentStageProgress;
    }

    public void setCurrentStageProgress(int currentStageProgress) {
        this.currentStageProgress = currentStageProgress;
    }

    public int getCurrentLessonProgress() {
        return currentLessonProgress;
    }

    public void setCurrentLessonProgress(int currentLessonProgress) {
        this.currentLessonProgress = currentLessonProgress;
    }

    @Override
    public String toString() {
        return "UserProgress{" +
                "courseName='" + courseName + '\'' +
                ", moduleProgress=" + moduleProgress +
                ", currentStageProgress=" + currentStageProgress +
                ", currentLessonProgress=" + currentLessonProgress +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserProgress that = (UserProgress) o;

        if (moduleProgress != that.moduleProgress) return false;
        if (currentStageProgress != that.currentStageProgress) return false;
        if (currentLessonProgress != that.currentLessonProgress) return false;
        return courseName.equals(that.courseName);

    }

    @Override
    public int hashCode() {
        int result = courseName.hashCode();
        result = 31 * result + moduleProgress;
        result = 31 * result + currentStageProgress;
        result = 31 * result + currentLessonProgress;
        return result;
    }
}
