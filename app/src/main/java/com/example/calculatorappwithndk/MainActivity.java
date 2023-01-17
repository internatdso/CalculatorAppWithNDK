package com.example.calculatorappwithndk;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.calculatorappwithndk.databinding.ActivityMainBinding;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'calculatorappwithndk' library on application startup.
    static {
        System.loadLibrary("calculatorappwithndk");
    }

    private String TAG = "MainActivity";
    private ActivityMainBinding binding;

    private int int1, int2;
    private TextView results;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate(): Entered");
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Example of a call to a native method
        TextView tv = binding.instructionText;
        tv.setText(stringFromJNI());

        //Get integer inputs
//        EditText inputInt1 = binding.inputInt1;
//        String inputInt1string = inputInt1.getText().toString();
//        int1 = Integer.parseInt(inputInt1string);
//        Log.d(TAG, "onCreate(): inputInt1 = " + int1);
//        TextView inputInt2 = binding.inputInt2;
//        String inputInt2string = inputInt2.getText().toString();
//        int2 = Integer.parseInt(inputInt2string);
//        Log.d(TAG, "onCreate(): inputInt2 = " + int2);


//        int1 = Integer.parseInt(binding.inputInt1.getText().toString().trim());
//        Log.d(TAG, "onCreate(): inputInt1 = " + int1);
//        int2 = Integer.parseInt(binding.inputInt2.getText().toString().trim());
//        Log.d(TAG, "onCreate(): inputInt1 = " + int2);

        //Get result textview
        results = binding.results;

    }

    /**
     * A native method that is implemented by the 'calculatorappwithndk' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
    public native int add(int x, int y);
    public native int sub(int x, int y);
    public native int multiply(int x, int y);
    public native int divide(int x, int y);

    public void inputs(){
        int1 = Integer.parseInt(binding.inputInt1.getText().toString().trim());
        Log.d(TAG, "onCreate(): inputInt1 = " + int1);
        int2 = Integer.parseInt(binding.inputInt2.getText().toString().trim());
        Log.d(TAG, "onCreate(): inputInt1 = " + int2);
    }

    public void add(View view) {
        inputs();
        Log.d(TAG, "add(): " + int1 + " + " + int2);
        int result = add(int1, int2);
        results.setText(String.valueOf(result));
        Log.d(TAG, "add(): " + int1 + " + " + int2 + " = " + result);
    }

    public void subtract(View view) {
        inputs();
        results.setText(String.valueOf(sub(int1, int2)));
    }

    public void multiply(View view) {
        inputs();
        results.setText(String.valueOf(multiply(int1, int2)));
    }

    public void divide(View view) {
        inputs();
        results.setText(String.valueOf(divide(int1, int2)));
    }
}