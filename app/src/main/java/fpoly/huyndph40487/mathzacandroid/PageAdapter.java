package fpoly.huyndph40487.mathzacandroid;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class PageAdapter extends FragmentPagerAdapter   {

    private final List<Fragment> fragments = new ArrayList<>();
    private List<String> quizzes = new ArrayList<>();


    public PageAdapter(@NonNull @NotNull FragmentManager  fragment) {
        super(fragment);
    }

    public void add(Fragment fragment) {
        fragments.add(fragment);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
