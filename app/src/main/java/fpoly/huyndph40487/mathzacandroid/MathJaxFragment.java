package fpoly.huyndph40487.mathzacandroid;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class MathJaxFragment extends Fragment {

    private String listQuizzes;
    int position;

    public   MathJaxFragment(int index, String listQuizzes) {
        this.position = index;
        this.listQuizzes = listQuizzes;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_math_jax, container, false);
        MathJaxView math1 = view.findViewById(R.id.math1);
        MathJaxView math2 = view.findViewById(R.id.math2);
        MathJaxView math3 = view.findViewById(R.id.math3);
        MathJaxView math4 = view.findViewById(R.id.math4);
        MathJaxView math5 = view.findViewById(R.id.math5);

        math1.setTextWord(listQuizzes);
        math2.setTextWord(listQuizzes);
        math3.setTextWord(listQuizzes);
        math4.setTextWord(listQuizzes);
        math5.setTextWord(listQuizzes);

        return view;

    }
}