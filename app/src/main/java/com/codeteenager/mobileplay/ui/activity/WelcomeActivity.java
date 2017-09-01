package com.codeteenager.mobileplay.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.codeteenager.mobileplay.R;
import com.eftimoff.androipathview.PathView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WelcomeActivity extends AppCompatActivity {
    @BindView(R.id.activity_welcome)
    LinearLayout mActivityWelcome;
    @BindView(R.id.path_view)
    PathView mPathView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        ButterKnife.bind(this);
        mPathView.getPathAnimator().delay(100).duration(5000).listenerEnd(new PathView.AnimatorBuilder.ListenerEnd() {
            @Override
            public void onAnimationEnd() {
                jump();
            }
        }).start();
    }

    private void jump() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
