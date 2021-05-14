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

public class PhrasesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phrases);

        //creating array
        ArrayList<Word> words = new ArrayList<Word>();
// objects
        words.add(new Word("Hello","Namaskara"));
        words.add(new Word("Good Morning","Shubha dina"));
        words.add(new Word("Good Night","Shuba ratri"));
        words.add(new Word("How are you?","Eer encha ullar?"));
        words.add(new Word("What is that?","Au jadhoo?"));
        words.add(new Word("What is your number","Eena number jadhoo?"));
        words.add(new Word("How was your day?","Eena dina encha ithane?"));
        words.add(new Word("Please come in!","Ulaye bale!"));
        words.add(new Word("I am fine","Yan ushaar ulle"));
        words.add(new Word("What is your name?","Eeno pudar dado?"));
        words.add(new Word("My name Krishna","Yenna pudar Krishna"));
        words.add(new Word("I am from India","Yan India daalu"));
        words.add(new Word("Don't mention it","Malle athe"));
        words.add(new Word("Never mind","Malle iddi"));
        words.add(new Word("I will meet you there","Yan eereg aul thikue"));
        words.add(new Word("Yes","Anth"));
        words.add(new Word("No","Edhi"));
        words.add(new Word("Bye","Auu anchanda"));
        words.add(new Word("OK","Auu"));

        WordAdapter adapter = new WordAdapter(this, words);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);
    }
}

