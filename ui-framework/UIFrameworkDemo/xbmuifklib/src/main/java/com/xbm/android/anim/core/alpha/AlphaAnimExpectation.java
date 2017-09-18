package com.xbm.android.anim.core.alpha;

import android.view.View;
import com.xbm.android.anim.core.AnimExpectation;

/**
 * Created by florentchampigny on 17/02/2017.
 */

public abstract class AlphaAnimExpectation extends AnimExpectation{
    public abstract Float getCalculatedAlpha(View viewToMove);
}
