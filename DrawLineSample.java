package com.android.drawlinesample;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.FrameLayout;

public class DrawLineSample extends AppCompatActivity {

    public Button changecolor;
    public Button changelinewide;
    public Button changestyle;
    public Button deletecanvas;
    public View.OnClickListener colorlistener = null;
    public View.OnLongClickListener widelistener1 = null;
    public View.OnClickListener widelistener2 = null;
    public View.OnClickListener stylelistener =null;
    public View.OnClickListener deletelistener =null;

    private int width = 8;
    private int stats = 0;
    private int n=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final TestView t = new TestView(this);
        FrameLayout frameLayout = new FrameLayout(this);;
        setContentView(frameLayout);

        changecolor = new Button(this);
        changecolor.setText("改变线颜色");
        FrameLayout.LayoutParams prams1= new FrameLayout.LayoutParams(300,
                120);
        prams1.setMargins(10,10,0,0);
        changecolor.setLayoutParams(prams1);
        frameLayout.addView(changecolor);
        colorlistener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stats++;
                int times = stats%4;
                switch (times){
                    case 0:
                        t.p.setColor(Color.RED);
                        break;
                    case 1:
                        t.p.setColor(Color.BLUE);
                        break;
                    case 2:
                        t.p.setColor(Color.YELLOW);
                        break;
                    case 3:
                        t.p.setColor(Color.GREEN);
                        break;
                }
            }
        };
        changecolor.setOnClickListener(colorlistener);

        changelinewide = new Button(this);
        changelinewide.setText("改变线粗细");
        FrameLayout.LayoutParams prams2= new FrameLayout.LayoutParams(300,
                120);
        prams2.setMargins(310,10,0,0);
        changelinewide.setLayoutParams(prams2);
        frameLayout.addView(changelinewide);
        widelistener1 = new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                if (width<=20){
                    width++;
                    t.p.setStrokeWidth(width);
                }
                return true;
            }
        };
        changelinewide.setOnLongClickListener(widelistener1);
        widelistener2 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(width>=1){
                    width--;
                    t.p.setStrokeWidth(width);
                }
            }
        };
        changelinewide.setOnClickListener(widelistener2);

        changestyle = new Button(this);
        changestyle.setText("改变线类型");
        FrameLayout.LayoutParams prams3= new FrameLayout.LayoutParams(300,
                120);
        prams3.setMargins(620,10,0,0);
        changestyle.setLayoutParams(prams3);
        frameLayout.addView(changestyle);
        stylelistener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                n++;
                int m = n%2;
                switch (m){
                    case 1:
                        t.p.setStrokeCap(Paint.Cap.SQUARE);
                        break;
                    case 0:
                        t.p.setStrokeCap(Paint.Cap.ROUND);
                        break;
                }
            }
        };
        changestyle.setOnClickListener(stylelistener);

        deletecanvas = new Button(this);
        deletecanvas.setText("清除");
        FrameLayout.LayoutParams prams4= new FrameLayout.LayoutParams(300,
                120);
        prams4.setMargins(10,130,0,0);
        deletecanvas.setLayoutParams(prams4);
        frameLayout.addView(deletecanvas);
        deletelistener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t.canvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);
            }
        };
        deletecanvas.setOnClickListener(deletelistener);

        frameLayout.addView(t);
    }
}


