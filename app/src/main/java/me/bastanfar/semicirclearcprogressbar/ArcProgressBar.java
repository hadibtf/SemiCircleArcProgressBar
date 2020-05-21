package me.bastanfar.semicirclearcprogressbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import java.util.Timer;
import java.util.TimerTask;

public class ArcProgressBar extends View
{
    private static final int PADDING = 15;

    private int progressPlaceHolderColor;
    private int progressBarColor;
    private int progressPlaceHolderWidth;
    private int progressBarWidth;
    private int percent;

    private int top = 0;
    private int left = 0;
    private int right = 0;
    private int bottom = 0;

    private RectF progressBar;

    //Constructors
    public ArcProgressBar(Context context)
    {
        super(context);
        init();
    }

    public ArcProgressBar(Context context, @Nullable AttributeSet attrs)
    {
        super(context, attrs);
        setAttrs(context, attrs);
        init();
    }

    public ArcProgressBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
        setAttrs(context, attrs);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public ArcProgressBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes)
    {
        super(context, attrs, defStyleAttr, defStyleRes);
        setAttrs(context, attrs);
        init();

    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        top = PADDING;
        left = PADDING;
        right = getMeasuredWidth();
        bottom = getMeasuredHeight() * 2;

        float progressAmount = percent * (float) 1.8;
        canvas.drawArc(progressBar, 180, 180, false, getPaint(progressPlaceHolderColor, progressPlaceHolderWidth));      //arg2: For the starting point, the starting point is 0 degrees from the positive direction of the x coordinate system. How many angles are arg3 selected to rotate clockwise?
        canvas.drawArc(progressBar, 180, progressAmount, false, getPaint(progressBarColor, progressBarWidth));      //arg2: For the starting point, the starting point is 0 degrees from the positive direction of the x coordinate system. How many angles are arg3 selected to rotate clockwise?
    }

    //Private Methods
    private void setAttrs(Context context, @Nullable AttributeSet attrs)
    {
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.ArcProgressBar, 0, 0);
        try
        {
            progressPlaceHolderColor = typedArray.getColor(R.styleable.ArcProgressBar_progressPlaceHolderColor, Color.GRAY);
            progressBarColor = typedArray.getColor(R.styleable.ArcProgressBar_progressBarColor, Color.WHITE);
            progressPlaceHolderWidth = typedArray.getInt(R.styleable.ArcProgressBar_progressPlaceHolderWidth, 25);
            progressBarWidth = typedArray.getInt(R.styleable.ArcProgressBar_progressBarWidth, 10);
            percent = typedArray.getInt(R.styleable.ArcProgressBar_percent, 76);
        } finally
        {
            typedArray.recycle();
        }
    }

    private Paint getPaint(int color, int strokeWidth)
    {
        Paint paint = new Paint();
        paint.setColor(color);

        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(strokeWidth);
        paint.setAntiAlias(true);
        paint.setStrokeCap(Paint.Cap.ROUND);
        return paint;
    }

    private void init()
    {
        progressBar = new RectF(left, top, right - PADDING, bottom - (PADDING * 2));
    }

    //Setters
    public void setProgressPlaceHolderColor(int color)
    {
        progressPlaceHolderColor = color;
    }

    public void setProgressBarColor(int color)
    {
        progressBarColor = color;
    }

    public void setProgressPlaceHolderWidth(int width)
    {
        progressPlaceHolderWidth = width;
    }

    public void setProgressBarWidth(int width)
    {
        progressBarWidth = width;
    }

    public void setPercent(int percent)
    {
        this.percent = percent;
        postInvalidate();
    }
    
    //Custom Setter
    public void setPercentWithAnimation(final int percent)
    {

        Timer timer = new Timer();

        timer.scheduleAtFixedRate(new TimerTask()
        {
            int step = 0;

            @Override
            public void run()
            {
                if (step <= percent) setPercent(step++);
            }

        }, 0, 5);
    }
}
