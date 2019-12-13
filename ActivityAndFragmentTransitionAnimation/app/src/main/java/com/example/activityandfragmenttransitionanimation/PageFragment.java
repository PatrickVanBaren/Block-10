package com.example.activityandfragmenttransitionanimation;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Random;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class PageFragment extends Fragment {

    private static final String NUMBER_ARGUMENT_KEY = "PageFragment.NUMBER_ARGUMENT";

    private int mNumber;

    private Listener mListener;

    private final Random mRandom = new Random();

    public static PageFragment newInstance(final int number) {
        final PageFragment fragment = new PageFragment();

        final Bundle arguments = new Bundle();
        arguments.putInt(NUMBER_ARGUMENT_KEY, number);
        fragment.setArguments(arguments);

        return fragment;
    }

    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mNumber = getArguments().getInt(NUMBER_ARGUMENT_KEY);
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             final Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_page, container, false);
    }

    @Override
    public void onViewCreated(final View view, @Nullable final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.view_page_layout).setBackgroundColor(Utils.generateRandomColor(mRandom));
        ((TextView) view.findViewById(R.id.view_number)).setText(String.valueOf(mNumber));
        view.findViewById(R.id.view_next).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(final View v) {
                mListener.onOpenPage(++mNumber);
            }
        });
    }

    @Override
    public void onAttach(final Context context) {
        super.onAttach(context);
        mListener = (Listener) context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface Listener {

        void onOpenPage(final int number);
    }
}
