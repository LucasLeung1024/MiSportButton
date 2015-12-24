# MiSportButton
仿照小米运动的长按暂停和继续运动按钮。
## 效果
![](https://github.com/Kevin-Stark/MiSportButton/blob/master/GIF/MiSportButton.gif)
## 使用
···Java
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
		```
