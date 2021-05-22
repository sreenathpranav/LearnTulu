/*
 * Copyright (C) 2016 The Android Open Source Project
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
package com.example.miwokbuild;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        //creating array
        ArrayList<Word> words = new ArrayList<Word>();
// objects
        words.add(new Word(R.drawable.number_one,"one","onji"));
        words.add(new Word(R.drawable.number_two,"two","eradu"));
        words.add(new Word(R.drawable.number_three,"three","muuji"));
        words.add(new Word(R.drawable.number_four,"four","naalu"));
        words.add(new Word(R.drawable.number_five,"five","ainu"));
        words.add(new Word(R.drawable.number_six,"six","aaji"));
        words.add(new Word(R.drawable.number_seven,"seven","eelu"));
        words.add(new Word(R.drawable.number_eight,"eight","enma"));
        words.add(new Word(R.drawable.number_nine,"nine","ormba"));
        words.add(new Word(R.drawable.number_ten,"ten","pattu"));


        WordAdapter adapter = new WordAdapter(this, words,R.color.category_numbers);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);
    }
}

