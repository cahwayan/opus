package cahwayan.apps.opus.util;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import cahwayan.apps.opus.R;

/**
 * Created by felip on 07-Aug-17.
 */

public class FragmentHelper {

    public static void addFragmentOnlyOnce(FragmentManager fragmentManager, int containeResId, Fragment fragment, String tag) {
        // Make sure the current transaction finishes first
        fragmentManager.executePendingTransactions();

        // If there is no fragment yet with this tag...
        if (fragmentManager.findFragmentByTag(tag) == null) {
            // Add it
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.add(containeResId, fragment, tag);
            transaction.commit();
        }
    }
}
