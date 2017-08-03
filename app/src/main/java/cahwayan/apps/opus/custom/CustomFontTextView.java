package cahwayan.apps.opus.custom;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

/**
 * Created by felip on 01-Aug-17.
 */

public class CustomFontTextView extends AppCompatTextView {

    protected static final String CONSOLAS = "fonts/Consolas.ttf";

    public CustomFontTextView(Context context, String fontLocation) {
        super(context);
        Typeface typeface = Typeface.createFromAsset(context.getAssets(), fontLocation);
        this.setTypeface(typeface);
    }

    public CustomFontTextView(Context context, AttributeSet attrs, String fontLocation) {
        super(context, attrs);
        Typeface typeface = Typeface.createFromAsset(context.getAssets(), fontLocation);
        this.setTypeface(typeface);
    }

    public CustomFontTextView(Context context, AttributeSet attrs, int defStyleAttr, String fontLocation) {
        super(context, attrs, defStyleAttr);
        Typeface typeface = Typeface.createFromAsset(context.getAssets(), fontLocation);
        this.setTypeface(typeface);
    }

}
