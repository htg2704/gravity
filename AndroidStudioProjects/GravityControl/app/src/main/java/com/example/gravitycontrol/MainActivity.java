package com.example.gravitycontrol;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    LinearLayout ll;
    ImageView imageView;
    float y;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ll = (LinearLayout) findViewById(R.id.ll);
        imageView = (ImageView) findViewById(R.id.imv);


        ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                y = imageView.getY();
                
                if(y>=0&&y<=100){
                        ObjectAnimator ay = ObjectAnimator.ofFloat(imageView,"translationY",0f,1800f);
                ay.setDuration(1000);
                AnimatorSet as = new AnimatorSet();
                as.play(ay);
                as.start();}
                if(y>100){
                    ObjectAnimator ay = ObjectAnimator.ofFloat(imageView,"translationY",1800f,0f);
                    ay.setDuration(1000);
                    AnimatorSet as = new AnimatorSet();
                    as.play(ay);
                    as.start();
                }
            }
        });
    }
}
