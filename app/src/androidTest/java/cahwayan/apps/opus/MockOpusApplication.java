package cahwayan.apps.opus;

import cahwayan.apps.opus.database.DaggerApplicationComponentTest_MockApplicationComponent;
import cahwayan.apps.opus.injection.MockApplicationComponent;
import cahwayan.apps.opus.injection.MockApplicationModule;
import cahwayan.apps.opus.injection.MockCourseModule;
import cahwayan.apps.opus.injection.MockUserModule;
import cahwayan.apps.opus.injection.component.application.ApplicationComponent;

/**
 * Created by felip on 08-Aug-17.
 */

public class MockOpusApplication extends OpusApplication{

    @Override
    protected ApplicationComponent createApplicationComponent() {
        return DaggerApplicationComponentTest_MockApplicationComponent
                .builder()
                .mockApplicationModule(new MockApplicationModule(this))
                .mockUserModule(new MockUserModule())
                .mockCourseModule(new MockCourseModule())
                .build();
    }
}
