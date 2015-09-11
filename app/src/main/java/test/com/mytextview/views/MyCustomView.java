package test.com.mytextview.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
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

    private Paint circlePaint = null;


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

        try {

            viewColor = typedArray.getInteger(R.styleable.myStyle_circleColor, Color.BLACK);
            textColor = typedArray.getInteger(R.styleable.myStyle_labelColor, Color.WHITE);
            label = typedArray.getString(R.styleable.myStyle_circleLabel);
        }finally {
            typedArray.recycle();
        }
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







        //paint object for drawing in onDraw
        circlePaint = new Paint();

        //get half of the width and height as we are working with a circle
        int viewWidthHalf = this.getMeasuredWidth()/2;
        int viewHeightHalf = this.getMeasuredHeight()/2;



        //get the radius as half of the width or height, whichever is smaller
        //subtract ten so that it has some space around it
        int radius = 0;
        if(viewWidthHalf>viewHeightHalf) {
            radius = viewHeightHalf - 10;
        }
        else {
            radius = viewWidthHalf - 10;
        }

        circlePaint.setStyle(Paint.Style.FILL);
        circlePaint.setAntiAlias(true);
        //set the paint color using the circle color specified
        circlePaint.setColor(viewColor);

        canvas.drawCircle(viewWidthHalf, viewHeightHalf, radius, circlePaint);



        // draw text
        //set the text color using the color specified
        circlePaint.setColor(textColor);
        //set text properties
        circlePaint.setTextAlign(Paint.Align.CENTER);
        circlePaint.setTextSize(50);

        //draw the text using the string attribute and chosen properties
        canvas.drawText(label, viewWidthHalf, viewHeightHalf, circlePaint);

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
