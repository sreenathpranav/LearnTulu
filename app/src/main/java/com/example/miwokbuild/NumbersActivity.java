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

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        //creating array
        final ArrayList<Word> words = new ArrayList<Word>();
        // objects
        words.add(new Word(R.drawable.number_one,"one","onji",R.raw.number_one));
        words.add(new Word(R.drawable.number_two,"two","eradu",R.raw.number_two));
        words.add(new Word(R.drawable.number_three,"three","muuji",R.raw.number_three));
        words.add(new Word(R.drawable.number_four,"four","naalu",R.raw.number_four));
        words.add(new Word(R.drawable.number_five,"five","ainu",R.raw.number_five));
        words.add(new Word(R.drawable.number_six,"six","aaji",R.raw.number_six));
        words.add(new Word(R.drawable.number_seven,"seven","eelu",R.raw.number_seven));
        words.add(new Word(R.drawable.number_eight,"eight","enma",R.raw.number_eight));
        words.add(new Word(R.drawable.number_nine,"nine","ormba",R.raw.number_nine));
        words.add(new Word(R.drawable.number_ten,"ten","pattu",R.raw.number_ten));

        WordAdapter adapter = new WordAdapter(this, words,R.color.category_numbers);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long l) {
               Word word= words.get(position);
               mMediaPlayer = MediaPlayer.create(NumbersActivity.this,word.getAudioResourceId());
               mMediaPlayer.start();
            }
        });

    }
}

