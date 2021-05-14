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

public class FamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family);

        //creating array
        ArrayList<Word> words = new ArrayList<Word>();
// objects
        words.add(new Word("Mother","Amma"));
        words.add(new Word("Older Sister","Akka"));
        words.add(new Word("Younger Sister","Megdi"));
        words.add(new Word("Daughter","Magal"));
        words.add(new Word("Son","Mage"));
        words.add(new Word("Older Brother","Anna"));
        words.add(new Word("Younger Brother","Megye"));
        words.add(new Word("Father","Appa"));
        words.add(new Word("Grand Mother","Dhoda"));
        words.add(new Word("Grand Father","Ajje"));


        WordAdapter adapter = new WordAdapter(this, words);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);
    }
}

