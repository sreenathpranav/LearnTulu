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

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors);

        //creating array
        ArrayList<Word> words = new ArrayList<Word>();
// objects
        words.add(new Word(R.drawable.color_black,"Black","Kap"));
        words.add(new Word(R.drawable.color_brown,"Brown","Kandu"));
        words.add(new Word(R.drawable.color_green,"Green","Pacche"));
        words.add(new Word(R.drawable.color_red,"Red","Kempu"));
        words.add(new Word(R.drawable.color_white,"White","Boldu"));
        words.add(new Word(R.drawable.color_mustard_yellow,"Yellow","Manjol"));


        WordAdapter adapter = new WordAdapter(this, words,R.color.category_colors);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);
    }
}

