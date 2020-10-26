package com.example.covidtracking2;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class informacionPrevencion extends AppCompatActivity implements View.OnClickListener {
        private ImageView img1,img2,img3,img4,img5;
        private SoundPool s1,s2,s3,s4,s5;
        private EditText edittext1,editText2;
        int sd1,sd2,sd3,sd4,sd5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion_prevencion);



        img1=findViewById(R.id.imageView14);
        img2=findViewById(R.id.imageView12);
        img3=findViewById(R.id.imageView13);
        img4=findViewById(R.id.imageView15);
        img5=findViewById(R.id.imageView16);

        img1.setOnClickListener(this);
        img2.setOnClickListener(this);
        img3.setOnClickListener(this);
        img4.setOnClickListener(this);
        img5.setOnClickListener(this);


        s1 = new SoundPool(1, AudioManager.STREAM_MUSIC,1);
        sd1 = s1.load(this, R.raw.dista,1);
        s2 = new SoundPool(1, AudioManager.STREAM_MUSIC,1);
        sd2 = s2.load(this, R.raw.audioboca,1);
        s3 = new SoundPool(1, AudioManager.STREAM_MUSIC,1);
        sd3 = s3.load(this, R.raw.desin,1);
        s4 = new SoundPool(1, AudioManager.STREAM_MUSIC,1);
        sd4 = s4.load(this, R.raw.lavamanodura,1);
        s5 = new SoundPool(1, AudioManager.STREAM_MUSIC,1);
        sd5 = s5.load(this, R.raw.cubraboca,1);
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.imageView14:
                s1.play(sd1,1,1,1,0,0);
                break;
            case R.id.imageView12:
                s2.play(sd2,1,1,1,0,0);
                break;
            case R.id.imageView13:
                s3.play(sd3,1,1,1,0,0);
                break;
            case R.id.imageView15:
                s4.play(sd4,1,1,1,0,0);
                break;
            case R.id.imageView16:
                s5.play(sd5,1,1,1,0,0);
                break;
        }
    }
}