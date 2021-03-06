package heimat.com.luoyer.ui.zhihu;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;

import com.flyco.tablayout.SlidingTabLayout;
import com.flyco.tablayout.listener.OnTabSelectListener;

import butterknife.BindView;
import heimat.com.luoyer.R;
import heimat.com.luoyer.base.BaseFragment;

/**
 * Created by code5 on 2017/3/29.
 */
public class HuMainFragment extends BaseFragment {
    @BindView(R.id.slindTab)
    SlidingTabLayout mSlindTab;
    @BindView(R.id.mViewPager)
    ViewPager mViewPager;
    String[] titles = new String[]{"今日看点", "叶落无声", "三生三世"};

    @Override
    public int getLayoutId() {
        return R.layout.fragment_hu_main;
    }

    @Override
    public void initView() {
        mViewPager.setAdapter(new MinePagerAdapter(getActivity().getSupportFragmentManager()));
        mSlindTab.setViewPager(mViewPager);
        mSlindTab.setCurrentTab(0);
    }

    @Override
    public void initListener() {
        mSlindTab.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                Log.i("Position", "------>" + position);
                mSlindTab.setCurrentTab(position);
            }

            @Override
            public void onTabReselect(int position) {
                Log.i("unPosition", "---un--->" + position);
            }
        });
    }

    @Override
    public void initData() {

    }

    class MinePagerAdapter extends FragmentPagerAdapter {

        public MinePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Log.i("Position", "选择的位置==Postion" + position);
            return new HuListFragment();
        }

        @Override
        public int getCount() {
            return titles.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }
    }

}
