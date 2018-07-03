package bilulo.androidtest02.dagger;

import bilulo.androidtest02.data.DataInteractor;
import bilulo.androidtest02.data.DataInteractorImpl;
import dagger.Module;
import dagger.Provides;

@Module
public class DataInteractorModule {
    @Provides
    public DataInteractor providesDataInteractor() {
        return new DataInteractorImpl();
    }

}
