package com.qf.csdn.other.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import com.qf.csdn.R;

/**
 * Created by LiuTao008
 * on 2016/2/18.
 */
public class CloseTagView extends TextView {


    private Bitmap bgBitmap;
    private int bgWidth;
    private int bgHeight;
    private Bitmap closedBitmap;

    public CloseTagView(Context context) {
        super(context);
        initView(context, null, 0);
    }

    public CloseTagView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context, attrs, 0);
    }

    public CloseTagView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context, attrs, defStyleAttr);
    }

    private void initView(Context context, AttributeSet attrs, int defStyleAttr) {
        bgBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.blog_tag_no_book);
        closedBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.closed);

        bgWidth = bgBitmap.getWidth();
        bgHeight = bgBitmap.getHeight();

        Paint paint = new Paint();

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        // super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int measuredWidth = bgWidth;
        int measuredHeight = bgHeight;
        setMeasuredDimension(measuredWidth, measuredHeight);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //画底图
        canvas.drawBitmap(bgBitmap, 0, 0, null);
        canvas.drawBitmap(closedBitmap,bgWidth,bgHeight/3,null);

    }
}
