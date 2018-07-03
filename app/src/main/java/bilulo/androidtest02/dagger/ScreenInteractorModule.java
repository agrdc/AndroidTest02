package bilulo.androidtest02.dagger;

import bilulo.androidtest02.data.ScreenInteractor;
import bilulo.androidtest02.data.ScreenInteractorImpl;
import dagger.Module;
import dagger.Provides;

@Module
public class ScreenInteractorModule {
    @Provides
    public ScreenInteractor providesScreenInteractor() {
        return new ScreenInteractorImpl();
    }
}
