/*
 * Copyright (C) 2013 Andreas Stuetz <andreas.stuetz@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.astuetz.viewpager.extensions.sample;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;

import java.util.Date;

public class SuperAwesomeCardFragment extends Fragment {

    private static final String ARG_POSITION = "position";
    private static final String ARG_TITLE = "title";
    private static final String ARG_SAVED_DATA = "saveddata";

    private int position;
    private String title, savedDatas;
    private TextView mTextView;

    public static SuperAwesomeCardFragment newInstance(int position, String title, String savedData) {
        SuperAwesomeCardFragment f = new SuperAwesomeCardFragment();
        Bundle b = new Bundle();
        b.putInt(ARG_POSITION, position);
        b.putString(ARG_TITLE, title);
        b.putString(ARG_SAVED_DATA, savedData);
        f.setArguments(b);
        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        position = getArguments().getInt(ARG_POSITION);
        title = getArguments().getString(ARG_TITLE);
        savedDatas = getArguments().getString(ARG_SAVED_DATA);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);

        FrameLayout fl = new FrameLayout(getActivity());
        fl.setLayoutParams(params);

        final int margin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 8, getResources()
                .getDisplayMetrics());

        mTextView = new TextView(getActivity());
        params.setMargins(margin, margin, margin, margin);
        mTextView.setLayoutParams(params);
        mTextView.setLayoutParams(params);
        mTextView.setGravity(Gravity.CENTER);
        mTextView.setBackgroundResource(R.drawable.background_card);
        if (TextUtils.isEmpty(savedDatas))
            mTextView.setText(title + " " + new Date());
        else
            mTextView.setText(savedDatas);
        fl.addView(mTextView);
        return fl;
    }

    /*@Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (outState == null)
            outState = new Bundle();
        outState.putString(ARG_TITLE, mTextView.getText().toString());
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        if (savedInstanceState != null) {
            mTextView.setText(savedInstanceState.getString(ARG_TITLE));
        }
    }*/

    public String getData() {
        return mTextView.getText().toString();
    }
}