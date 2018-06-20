package com.cold.base;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Picture;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2018/2/24.
 */

public class TestView extends View {

    // 1.创建一个画笔
    private Paint mPaint = new Paint();

    // 2.初始化画笔
    private void initPaint() {
        mPaint.setColor(Color.BLUE);       //设置画笔颜色
        mPaint.setStyle(Paint.Style.STROKE);  //设置画笔模式为填充
        mPaint.setStrokeWidth(10f);         //设置画笔宽度为10px
    }

    // 1.创建Picture
    private Picture mPicture = new Picture();

    // 2.录制内容方法
    private void recording() {
        // 开始录制 (接收返回值Canvas)
        Canvas canvas = mPicture.beginRecording(500, 500);
        // 创建一个画笔
        Paint paint = new Paint();
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.FILL);

        // 在Canvas中具体操作
        // 位移
        canvas.translate(250,250);
        // 绘制一个圆
        canvas.drawCircle(0,0,100,paint);

        mPicture.endRecording();
    }

    public TestView(Context context) {
        super(context);
    }

    // 3.在构造函数中初始化
    public TestView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaint();
//        recording();    // 调用录制
    }

    public TestView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        canvas.drawColor(Color.argb(255, 255, 0, 0));
//        canvas.drawRGB(255, 0, 255);
//        canvas.drawARGB(100, 0, 0, 255);

//        canvas.drawPoint(200, 200, mPaint);     //在坐标(200,200)位置绘制一个点
//        canvas.drawPoints(new float[]{          //绘制一组点，坐标位置由float数组指定
//                500,500,
//                500,600,
//                500,700
//        },mPaint);

//        canvas.drawLine(300,300,500,600,mPaint);    // 在坐标(300,300)(500,600)之间绘制一条直线
//        canvas.drawLines(new float[]{               // 绘制一组线 每四数字(两个点的坐标)确定一条线
//                100,200,200,200,
//                100,300,200,300
//        },mPaint);

//        // 第一种
//        canvas.drawRect(100,100,800,400,mPaint);
//
//        // 第二种
//        Rect rect = new Rect(100,100,800,400);
//        canvas.drawRect(rect,mPaint);
//
//        // 第三种
//        RectF rectF = new RectF(100,100,800,400);
//        canvas.drawRect(rectF,mPaint);
//
//        // 第一种
//        RectF rectF = new RectF(100,100,800,400);
//        canvas.drawRoundRect(rectF,30,30,mPaint);
//
//        // 第二种
//        canvas.drawRoundRect(100,100,800,400,30,30,mPaint);

//        // 第一种
//        RectF rectF = new RectF(100,100,800,400);
//        canvas.drawOval(rectF,mPaint);
//
//        // 第二种
//        canvas.drawOval(100,100,800,400,mPaint);

//        canvas.drawCircle(500,500,400,mPaint);  // 绘制一个圆心坐标在(500,500)，半径为400 的圆。

//        RectF rectF = new RectF(100,100,800,400);
//        // 绘制背景矩形
//        mPaint.setColor(Color.GRAY);
//        canvas.drawRect(rectF,mPaint);
//
//        // 绘制圆弧
//        mPaint.setColor(Color.BLUE);
//        canvas.drawArc(rectF,0,180,false,mPaint);
//
//        //-------------------------------------
//
//        RectF rectF2 = new RectF(100,600,800,900);
//        // 绘制背景矩形
//        mPaint.setColor(Color.GRAY);
//        canvas.drawRect(rectF2,mPaint);
//
//        // 绘制圆弧
//        mPaint.setColor(Color.BLUE);
//        canvas.drawArc(rectF2,0,180,true,mPaint);

//        Paint paint = new Paint();
//        paint.setColor(Color.BLUE);
//        paint.setStrokeWidth(40);     //为了实验效果明显，特地设置描边宽度非常大
//
//        // 描边
//        paint.setStyle(Paint.Style.STROKE);
//        canvas.drawCircle(200,200,100,paint);
//
//        // 填充
//        paint.setStyle(Paint.Style.FILL);
//        canvas.drawCircle(200,500,100,paint);
//
//        // 描边加填充
//        paint.setStyle(Paint.Style.FILL_AND_STROKE);
//        canvas.drawCircle(200, 800, 100, paint);
//
//        mPaint.setStyle(Paint.Style.FILL);  //设置画笔模式为填充

//        // 在坐标原点绘制一个黑色圆形
//        mPaint.setColor(Color.BLACK);
//        canvas.translate(200,200);
//        canvas.drawCircle(0,0,100,mPaint);
//
//        // 在坐标原点绘制一个蓝色圆形
//        mPaint.setColor(Color.BLUE);
//        canvas.translate(200,200);
//        canvas.drawCircle(0,0,100,mPaint);

//        // 将坐标系原点移动到画布正中心
//        canvas.translate(getWidth() / 2, getHeight() / 2);
//
//        RectF rect = new RectF(0,-400,400,0);   // 矩形区域
//
//        mPaint.setColor(Color.BLACK);           // 绘制黑色矩形
//        canvas.drawRect(rect,mPaint);
//
////        canvas.scale(0.5f, 0f);                // 画布缩放
//
//        canvas.scale(0.5f,0.5f,200,0);          // 画布缩放  <-- 缩放中心向右偏移了200个单位
//
//        mPaint.setColor(Color.BLUE);            // 绘制蓝色矩形
//        canvas.drawRect(rect,mPaint);
//
//        canvas.scale(0.5f,0.5f);
//        canvas.scale(0.5f,0.1f);


//        // 将坐标系原点移动到画布正中心
//        canvas.translate(getWidth() / 2, getHeight() / 2);
//
//        RectF rect = new RectF(0,-400,400,0);   // 矩形区域
//
//        mPaint.setColor(Color.BLACK);           // 绘制黑色矩形
//        canvas.drawRect(rect,mPaint);
//
//        canvas.rotate(180);                     // 旋转180度 <-- 默认旋转中心为原点
//
//        mPaint.setColor(Color.BLUE);            // 绘制蓝色矩形
//        canvas.drawRect(rect,mPaint);

//        // 将坐标系原点移动到画布正中心
//        canvas.translate(getWidth() / 2, getHeight() / 2);
//
//        RectF rect = new RectF(0,0,200,200);   // 矩形区域
//
//        mPaint.setColor(Color.BLACK);           // 绘制黑色矩形
//        canvas.drawRect(rect,mPaint);
//
//        canvas.skew(1, -1);                       // 水平错切 <- 45度
//
//        mPaint.setColor(Color.BLUE);            // 绘制蓝色矩形
//        canvas.drawRect(rect,mPaint);

//        save();      //保存状态
//...          //具体操作
//        restore();   //回滚到之前的状态

//        mPicture.draw(canvas);

//        canvas.drawPicture(mPicture,new RectF(0, 0, mPicture.getWidth(), 200));

        // 包装成为Drawable
//        PictureDrawable drawable = new PictureDrawable(mPicture);
//        // 设置绘制区域 -- 注意此处所绘制的实际内容不会缩放
//        drawable.setBounds(0,0,250,mPicture.getHeight());
//        // 绘制
//        drawable.draw(canvas);

        // 将画布坐标系移动到画布中央
//        canvas.translate(getWidth() / 2, getHeight() / 2);
//
//        // 指定图片绘制区域(左上角的四分之一)
//        Rect src = new Rect(0,0,bitmap.getWidth()/2,bitmap.getHeight()/2);
//
//        // 指定图片在屏幕上显示的区域
//        Rect dst = new Rect(0,0,200,400);
//
//        // 绘制图片
//        canvas.drawBitmap(bitmap,src,dst,mPaint);

//        // 文本(要绘制的内容)
//        String str = "ABCDEFG";
//
//        // 参数分别为 (文本 基线x 基线y 画笔)
//        canvas.drawText(str,200,500,textPaint);

//        String str = "SLOOP";
//
//        canvas.drawPosText(str,new float[]{
//                100,100,    // 第一个字符位置
//                200,200,    // 第二个字符位置
//                300,300,    // ...
//                400,400,
//                500,500
//        },textPaint);

//        canvas.translate(getWidth() / 2, getWidth() / 2);  // 移动坐标系到屏幕中心(宽高数据在onSizeChanged中获取)
//
//        Path path = new Path();                     // 创建Path
//
//        path.lineTo(200, 200);                      // lineTo
//        path.lineTo(200,0);
//
//        canvas.drawPath(path, mPaint);              // 绘制Path

//        canvas.translate(getWidth() / 2, getWidth() / 2);  // 移动坐标系到屏幕中心
//
//        Path path = new Path();                     // 创建Path
//
//        path.lineTo(200, 200);                      // lineTo
//
//        path.moveTo(200,100);                       // moveTo
//
//        path.lineTo(200,0);                         // lineTo
//
//        canvas.drawPath(path, mPaint);              // 绘制Path

//        canvas.translate(getWidth() / 2, getWidth() / 2);  // 移动坐标系到屏幕中心
//
//        Path path = new Path();                     // 创建Path
//
//        path.lineTo(100, 200);                      // lineTo
//
//        path.lineTo(200, 200);                      // lineTo
//
//        path.setLastPoint(200,100);                 // setLastPoint
//
//        path.lineTo(200,0);                         // lineTo
//
//        canvas.drawPath(path, mPaint);              // 绘制Path

//        canvas.translate(getWidth() / 2, getHeight() / 2);  // 移动坐标系到屏幕中心
//        Path path = new Path();                     // 创建Path
//        path.lineTo(200, 200);                      // lineTo
//        path.moveTo(200, 100);
//        path.lineTo(200,0);                         // lineTo
//        path.close();                               // close
//        canvas.drawPath(path, mPaint);              // 绘制Path

//        canvas.translate(getWidth() / 2, getHeight() / 2);  // 移动坐标系到屏幕中心
//        Path path = new Path();
//        path.addRect(200, 200, -200, -200, Path.Direction.CW);
//        path.setLastPoint(-100, 100);
//        canvas.drawPath(path, mPaint);

//        canvas.translate(getWidth()/ 2, getHeight() / 2);  // 移动坐标系到屏幕中心
//        canvas.scale(1,-1);                         // <-- 注意 翻转y坐标轴
//
//        Path path = new Path();
//        Path src =  new Path();
//
//        path.addRect(-200,-200,200,200, Path.Direction.CW);
//        src.addCircle(0,0,200, Path.Direction.CW);
//
//        path.addPath(src,200,200);
//
//        mPaint.setColor(Color.BLACK);           // 绘制合并后的路径
//        canvas.drawPath(path,mPaint);

//        canvas.translate(getWidth() / 2, getHeight() / 2);  // 移动坐标系到屏幕中心
//        canvas.scale(1,-1);                         // <-- 注意 翻转y坐标轴
//
//        Path path = new Path();
//        path.lineTo(100,100);
//
//        RectF oval = new RectF(0,0,300,300);
//
//        path.addArc(oval,0,270);
//        //         path.arcTo(oval,0,270,true);             // <-- 和上面一句作用等价
//
//        canvas.drawPath(path,mPaint);

//        canvas.translate(getWidth() / 2, getHeight() / 2);  // 移动坐标系到屏幕中心
//        canvas.scale(1,-1);                         // <-- 注意 翻转y坐标轴
//
//        Path path = new Path();
//        path.lineTo(100,100);
//
//        RectF oval = new RectF(0,0,300,300);
//
//        path.arcTo(oval,0,-270);
//        // path.arcTo(oval,0,270,false);             // <-- 和上面一句作用等价
//
//        canvas.drawPath(path,mPaint);

//        Path path = new Path();
//        Log.e("1",path.isEmpty()+"");
//
//        path.lineTo(100,100);
//        Log.e("2",path.isEmpty()+"");

//        Path path = new Path();
//        path.lineTo(0,400);
//        path.lineTo(400,400);
//        path.lineTo(400,0);
//        path.lineTo(0,0);
//
//        RectF rect = new RectF();
//        boolean b = path.isRect(rect);
//        Log.e("Rect","isRect:"+b+"| left:"+rect.left+"| top:"+rect.top+"| right:"+rect.right+"| bottom:"+rect.bottom);

//        canvas.translate(getWidth() / 2, getHeight() / 2);  // 移动坐标系到屏幕中心
//        canvas.scale(1,-1);                         // <-- 注意 翻转y坐标轴
//        Path path = new Path();                     // path添加一个矩形
//        path.addRect(-200,-200,200,200, Path.Direction.CW);
//        Path src = new Path();                      // src添加一个圆
//        src.addCircle(0,0,100, Path.Direction.CW);
//        path.set(src);                              // 大致相当于 path = src;
//        canvas.drawPath(path,mPaint);

//        canvas.translate(getWidth() / 2, getHeight() / 2);  // 移动坐标系到屏幕中心
//        canvas.scale(1,-1);                         // <-- 注意 翻转y坐标轴
//        Path path = new Path();                     // path中添加一个圆形(圆心在坐标原点)
//        path.addCircle(0,0,100, Path.Direction.CW);
//        Path dst = new Path();                      // dst中添加一个矩形
//        dst.addRect(-200,-200,200,200, Path.Direction.CW);
//        path.offset(300,0,dst);                     // 平移
//        canvas.drawPath(path,mPaint);               // 绘制path
//        mPaint.setColor(Color.BLUE);                // 更改画笔颜色
//        canvas.drawPath(dst,mPaint);                // 绘制dst




    }
}
