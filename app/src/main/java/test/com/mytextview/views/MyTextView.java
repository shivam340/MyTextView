package test.com.mytextview.views;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by shivam on 9/11/15.
 */
public class MyTextView extends View {

    public MyTextView(Context context) {
        super(context);
    }

    public MyTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //method to draw things on canvas (empty space given to you by system)

        /*
            # If you set a background drawable for a View, then the View will draw it for you before calling back to its onDraw() method.
            # onAttachedToWindow () is called when the view is attached to a window. At this point it has a Surface and will start drawing.
            Note that this function is guaranteed to be called before onDraw(android.graphics.Canvas), however it may be called any time before the first onDraw
            -- including before or after onMeasure(int, int).

            invalidate() mark the area defined by dirty as needing to be drawn. If the view is visible, onDraw(android.graphics.Canvas) will be called at some point in the future.
        */

    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        //onMeasure() is your opportunity to tell Android how big you want your custom view to be
        // dependent on the layout constraints provided by the parent;

        // to see more description about onMeasure -> http://stackoverflow.com/questions/12266899/onmeasure-custom-view-explanation

        setMeasuredDimension(widthMeasureSpec, heightMeasureSpec);
    }


}
