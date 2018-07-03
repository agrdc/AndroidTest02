package bilulo.androidtest02.dagger;

import bilulo.androidtest02.ui.ContactsFragment;
import bilulo.androidtest02.ui.InvestmentFragment;
import bilulo.androidtest02.ui.TabActivity;
import dagger.Component;

@Component (modules = {DataInteractorModule.class, ScreenInteractorModule.class})
public interface AppComponent {
    //void inject(TabActivity tabActivity);

    void inject(ContactsFragment contactsFragment);

    void inject(InvestmentFragment investmentFragment);
}

