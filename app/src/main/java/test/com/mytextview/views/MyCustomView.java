package test.com.mytextview.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;

import test.com.mytextview.R;

/**
 * Created by shivam on 9/11/15.
 */
public class MyCustomView extends View {

    private Context mContext = null;

    private int viewColor = Color.BLACK;  // use default color
    private int textColor = Color.WHITE;
    private String label = "Hello";



    public MyCustomView(Context context) {
        super(context);
        mContext = context;
    }

    public MyCustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;


        //get the attributes specified in attrs.xml using the name we included
        TypedArray typedArray = mContext.getTheme().obtainStyledAttributes(attrs,
                R.styleable.myStyle, 0, 0);

        viewColor = typedArray.getInteger(R.styleable.myStyle_circleColor, Color.BLACK);
        textColor = typedArray.getInteger(R.styleable.myStyle_labelColor, Color.WHITE);
        label = typedArray.getString(R.styleable.myStyle_circleLabel);

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


    public int getViewColor() {
        return viewColor;
    }

    public void setViewColor(int viewColor) {
        this.viewColor = viewColor;

        //redraw the view
        invalidate();
        requestLayout();

    }

    public int getTextColor() {
        return textColor;
    }

    public void setTextColor(int textColor) {
        this.textColor = textColor;
        //redraw the view
        invalidate();
        requestLayout();
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;

        //redraw the view
        invalidate();
        requestLayout();
    }
}
