package skylab.zeng.td_beacon.animation;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.LinearLayout.LayoutParams;

/**
 * This animation class is animating the expanding and reducing the size of a
 * view. The animation toggles between the Expand and Reduce, depending on the
 * current state of the view
 * 
 * @author Udinic
 * 
 */
public class ExpandAnimation extends Animation {
	private View mAnimatedView;
	private LayoutParams mViewLayoutParams;
	private int mMarginStart, mMarginEnd;
	private boolean mIsVisibleAfter = false;
	private boolean mWasEndedAlready = false;
	int n = 0;
	int h = 0;
	int w = 0;

	/**
	 * Initialize the animation
	 * 
	 * @param view
	 *            The layout we want to animate
	 * @param duration
	 *            The duration of the animation, in ms
	 */
	public ExpandAnimation(View view, int duration, int n) {
		this.n = n;
		setDuration(duration);
		mAnimatedView = view;

		mViewLayoutParams = (LayoutParams) view.getLayoutParams();

		// if the bottom margin is 0,
		// then after the animation will end it'll be negative, and invisible.
		mIsVisibleAfter = (mViewLayoutParams.bottomMargin == 0);

		mMarginStart = mViewLayoutParams.bottomMargin;
		mMarginEnd = (mMarginStart == 0 ? (0 - view.getHeight()) : 0);
		if (n == View.VISIBLE) {
			view.setVisibility(n);
		}

	}

	@Override
	protected void applyTransformation(float interpolatedTime, Transformation ta) {
		super.applyTransformation(interpolatedTime, ta);
		System.out.println("?????" + "====" + n);
		if (interpolatedTime < 1.0f) {

			// Calculating the new bottom margin, and setting it
			mViewLayoutParams.bottomMargin = mMarginStart
					+ (int) ((mMarginEnd - mMarginStart) * interpolatedTime);
			System.out
					.println("?????" + mViewLayoutParams.bottomMargin
							+ "mMarginStart" + mMarginStart + "mMarginEnd"
							+ mMarginEnd);
			// Invalidating the layout, making us seeing the changes we made
			mAnimatedView.requestLayout();

			// Making sure we didn't run the ending before (it happens!)
		} else if (!mWasEndedAlready) {
			mViewLayoutParams.bottomMargin = mMarginEnd;
			mAnimatedView.requestLayout();

			if (mIsVisibleAfter) {
				mAnimatedView.setVisibility(View.GONE);
			}
			mWasEndedAlready = true;
		}
	}
}