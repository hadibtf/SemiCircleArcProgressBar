package me.bastanfar.semicirclearcprogressbar;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class DemoActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);
        SemiCircleArcProgressBar smc = findViewById(R.id.smc);
        smc.setPercentWithAnimation(100);
    }

    public void test(View view)
    {
        SemiCircleArcProgressBar smc = findViewById(R.id.smc);
        smc.setPercentWithAnimation(100);
    }
}
