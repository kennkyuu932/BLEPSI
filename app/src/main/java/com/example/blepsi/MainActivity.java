package com.example.blepsi;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.blepsi.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'blepsi' library on application startup.
    static {
        System.loadLibrary("blepsi");
    }

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Example of a call to a native method
        TextView tv = binding.sampleText;
        tv.setText(stringFromJNI());
        Log.d(TAG, "LibTest: "+LibTest());
    }

    /**
     * A native method that is implemented by the 'blepsi' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();

    public native int LibTest();
}