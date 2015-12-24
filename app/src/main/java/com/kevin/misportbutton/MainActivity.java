package com.kevin.misportbutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 * 仿照小米运动按钮
 */
public class MainActivity extends AppCompatActivity {

	private MiSportButton	mBtn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mBtn = (MiSportButton) findViewById(R.id.mi_btn);
		mBtn.setMiSportBtnClickListener(new MiSportButton.miSportButtonClickListener() {
			@Override
			public void finishClick() {

			}

			@Override
			public void continueClick() {

			}
		});

		mBtn.setMiSportBtnLongClickListener(new MiSportButton.miSportButtonLongClickListener() {
			@Override
			public void longPressClick() {

			}
		});
	}
}
