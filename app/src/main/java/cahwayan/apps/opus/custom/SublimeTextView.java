package cahwayan.apps.opus.custom;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

/**
 * Created by felip on 01-Aug-17.
 */

public class SublimeTextView extends CustomFontTextView {

    public SublimeTextView(Context context) {
        super(context, CONSOLAS);
    }

    public SublimeTextView(Context context, AttributeSet attrs) {
        super(context, attrs, CONSOLAS);
    }

    public SublimeTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr, CONSOLAS);
    }
}
