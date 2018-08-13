package com.example.codingtest.codingapplication.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.codingtest.codingapplication.R;

/**
 * Fragment1 is a fragment to display in ViewPager
 */
public class Fragment1 extends Fragment {
    private String title;
    private int page;

    public static Fragment1 newInstance(int page, String title) {
        Fragment1 fragment = new Fragment1();
        Bundle args = new Bundle();
        args.putInt("someInt", page);
        args.putString("someTitle", title);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        page = getArguments().getInt("someInt", 0);
        title = getArguments().getString("someTitle");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_view, container, false);
        TextView tvLabel = (TextView) view.findViewById(R.id.titleTextView);
        tvLabel.setText(title);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Fragment1.this.getActivity(), getString(R.string.fragment_number) + " "+ (page+1), Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

}
