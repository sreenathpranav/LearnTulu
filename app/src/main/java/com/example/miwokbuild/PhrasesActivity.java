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

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {
    private MediaPlayer mMediaPlayer;
    private AudioManager mAudioManager;


    AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT || focusChange==AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                mMediaPlayer.pause();
                mMediaPlayer.seekTo(0);
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                mMediaPlayer.start();
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                releaseMediaPlayer();
            }
        }
    };


    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        //creating array
        final ArrayList<Word> words = new ArrayList<Word>();
// objects
        words.add(new Word("Hello","Namaskara",R.raw.greeting_hello));
        words.add(new Word("Good Morning","Shubha dina",R.raw.greeting_goodmorning));
        words.add(new Word("Good Night","Shuba ratri",R.raw.greeting_night));
        words.add(new Word("How are you?","Eer encha ullar?",R.raw.greeting_howareyou));
        words.add(new Word("What is that?","Au jadhoo?",R.raw.greeting_whatisthat));
        words.add(new Word("What is your name?","Eeno pudar dado?",R.raw.greeting_whatisyourname));
        words.add(new Word("What is your number","Eena number jadhoo?",R.raw.greeting_whatisyournumber));
        words.add(new Word("How was your day?","Eena dina encha ithane?",R.raw.greeting_howwasyourday));
        words.add(new Word("Please come in!","Ulaye bale!",R.raw.greeting_comeinside));
        words.add(new Word("I am fine","Yan ushaar ulle",R.raw.greeting_iamfine));
        words.add(new Word("My name Ram","Yenna pudar Ram",R.raw.greeting_mynameisram));
        words.add(new Word("I am from India","Yan India daalu",R.raw.greeting_iamfromindia));
        words.add(new Word("Don't mention it","Malle athe",R.raw.greeting_dontmentionit));
        words.add(new Word("Never mind","Malle iddi",R.raw.greeting_nevermind));
        words.add(new Word("I will meet you there","Yan eereg aul thikue",R.raw.greeting_iwillmeetyou));
        words.add(new Word("Yes","Anth",R.raw.greeting_yes));
        words.add(new Word("No","Edhi",R.raw.greeting_no));
        words.add(new Word("Ok then","Auu anchanda",R.raw.greeting_bye));
        words.add(new Word("OK","Auu",R.raw.greeting_ok));
//add bye
        WordAdapter adapter = new WordAdapter(this, words,R.color.category_phrases);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long l) {
                Word word= words.get(position);

                releaseMediaPlayer();

                int result = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {


                mMediaPlayer = MediaPlayer.create(PhrasesActivity.this,word.getAudioResourceId());
                mMediaPlayer.start();

                mMediaPlayer.setOnCompletionListener(mCompletionListener);
                }
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    /*Clean up the media player by releasing its resources.
     */
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
        }
    }

}



