package com.kevin.misportbutton;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.RelativeLayout;

/**
 * Created by Kevin on 2015/10/28.
 */
public class MiSportButton extends RelativeLayout {

	private Button							mFinishBtn;		// 左边完成Btn
	private Button							mContinueBtn;		// 右边继续Btn
	private Button							mLongPressBtn;		// 长按暂停Btn
	private miSportButtonClickListener		clickListener;
	private miSportButtonLongClickListener	longclickListener;
	private Animation						alpha, translateLeft, translateRight;
	private int								moveWidth;								// 按钮移动的距离

	public MiSportButton(Context context, AttributeSet attrs) {
		super(context, attrs);
		LayoutInflater.from(context).inflate(R.layout.mi_sport_btn_layout, this);
		mFinishBtn = (Button) findViewById(R.id.finish_btn);
		mContinueBtn = (Button) findViewById(R.id.continue_btn);
		mLongPressBtn = (Button) findViewById(R.id.long_pressed_pause_tbn);

		LayoutParams btnPara = (LayoutParams) mLongPressBtn.getLayoutParams();
		moveWidth = btnPara.width;// 按钮移动的距离可自己定

		// 按钮监听
		mLongPressBtn.setOnLongClickListener(new OnLongClickListener() {
			@Override
			public boolean onLongClick(View v) {
				longclickListener.longPressClick();
				mLongPressBtn.startAnimation(alpha);
				return false;
			}
		});
		mFinishBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				clickListener.finishClick();
				mFinishBtn.setVisibility(View.INVISIBLE);
				mContinueBtn.setVisibility(View.INVISIBLE);
				mLongPressBtn.setVisibility(View.VISIBLE);
			}
		});
		mContinueBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				clickListener.continueClick();
				mFinishBtn.setVisibility(View.INVISIBLE);
				mContinueBtn.setVisibility(View.INVISIBLE);
				mLongPressBtn.setVisibility(View.VISIBLE);
			}
		});

		// 长按动画，中间的按钮会消失
		alpha = new AlphaAnimation(1.0f, 0.0f);
		alpha.setDuration(300);
		alpha.setAnimationListener(new Animation.AnimationListener() {
			@Override
			public void onAnimationStart(Animation animation) {

			}

			@Override
			public void onAnimationEnd(Animation animation) {
				mLongPressBtn.setVisibility(View.INVISIBLE);
				mContinueBtn.setVisibility(View.VISIBLE);
				mFinishBtn.setVisibility(View.VISIBLE);
				mContinueBtn.startAnimation(translateRight);
				mFinishBtn.startAnimation(translateLeft);
			}

			@Override
			public void onAnimationRepeat(Animation animation) {

			}
		});
		// 左移动画
		translateLeft = new TranslateAnimation(moveWidth, 0, 0, 0);
		translateLeft.setDuration(600);
		translateLeft.setAnimationListener(new Animation.AnimationListener() {
			@Override
			public void onAnimationStart(Animation animation) {

			}

			@Override
			public void onAnimationEnd(Animation animation) {
			}

			@Override
			public void onAnimationRepeat(Animation animation) {

			}
		});
		// 右移动画
		translateRight = new TranslateAnimation(-moveWidth, 0, 0, 0);
		translateRight.setDuration(600);
		translateRight.setAnimationListener(new Animation.AnimationListener() {
			@Override
			public void onAnimationStart(Animation animation) {

			}

			@Override
			public void onAnimationEnd(Animation animation) {
			}

			@Override
			public void onAnimationRepeat(Animation animation) {

			}
		});

	}

	public void setMiSportBtnClickListener(miSportButtonClickListener listener) {
		this.clickListener = listener;
	}

	public void setMiSportBtnLongClickListener(miSportButtonLongClickListener listener) {
		this.longclickListener = listener;
	}

	/**
	 * 实现自己的接口
	 *
	 * @author Kevin
	 */
	public interface miSportButtonClickListener {
		public void finishClick();

		public void continueClick();
	}

	public interface miSportButtonLongClickListener {
		public void longPressClick();
	}

}
