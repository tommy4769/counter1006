package tw.edu.pu.s1088123.counter1006;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button n_500;
    private Button n_260;
    private Button n_300;
    private Button n_250;
    private Button n_600;
    private Button n_450;
    private Button n_280;
    private Button n_320;
    private Button n_240;
    private Button n_200;
    private Button addup;
    private Button sub;
    private Button equal;
    private Button det;
    boolean clean;

    private EditText editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        n_500 = findViewById(R.id.btn1);
        n_260 = findViewById(R.id.btn2);
        n_300 = findViewById(R.id.btn3);
        n_250 = findViewById(R.id.btn4);
        n_600 = findViewById(R.id.btn5);
        n_450 = findViewById(R.id.btn6);
        n_280 = findViewById(R.id.btn7);
        n_320 = findViewById(R.id.btn8);
        n_240 = findViewById(R.id.btn9);
        n_200 = findViewById(R.id.btn10);
        det = findViewById(R.id.btn11);
        equal =findViewById(R.id.btn12);
        addup = findViewById(R.id.btn13);
        sub = findViewById(R.id.btn14);

        editText = findViewById(R.id.ediText);

        n_500.setOnClickListener((View.OnClickListener) this);
        n_260.setOnClickListener((View.OnClickListener) this);
        n_300.setOnClickListener((View.OnClickListener) this);
        n_250.setOnClickListener((View.OnClickListener) this);
        n_600.setOnClickListener((View.OnClickListener) this);
        n_450.setOnClickListener((View.OnClickListener) this);
        n_280.setOnClickListener((View.OnClickListener) this);
        n_320.setOnClickListener((View.OnClickListener) this);
        n_240.setOnClickListener((View.OnClickListener) this);
        n_200.setOnClickListener((View.OnClickListener) this);
        addup.setOnClickListener((View.OnClickListener) this);
        sub.setOnClickListener((View.OnClickListener) this);
        det.setOnClickListener((View.OnClickListener) this);
        equal.setOnClickListener((View.OnClickListener) this);
    }

    public void onclick(View view){
        String input = editText.getText().toString();

            switch (view.getId()){
                case R.id.btn1:
                case R.id.btn2:
                case R.id.btn3:
                case R.id.btn4:
                case R.id.btn5:
                case R.id.btn6:
                case R.id.btn7:
                case R.id.btn8:
                case R.id.btn9:
                case R.id.btn10:
                case R.id.btn11://清除det
                    if(clean){
                        clean=false;
                        input = "";
                        editText.setText("");
                    }else if(input!= null|| !input.equals("")){
                        editText.setText(input.substring(0,input.length()-1));
                        break;
                    } break;
                case R.id.btn12://總共equal
                    getResult();
                    break;
            }

    }
            private void getResult(){
                String exp =editText.getText().toString();
                if(exp == null||exp.equals("")){
                    return;
                }
                if(!exp.contains("")){
                    return;
                }
                if (clean){
                    clean= false;
                    return;
                }
                clean = true;
                double result=0;

                String s1 = exp.substring(0,exp.indexOf(" "));
                String  op = exp.substring(exp.indexOf(" ")+1,exp.indexOf(" ")+2);
                String s2 = exp.substring(exp.indexOf(" ")+3);
                if(!s1.equals("")&&!s2.equals("")){
                    double d1=Double.parseDouble(s1);//數字都是double型別
                    double d2=Double.parseDouble(s2);

                    if(op.equals("+")){
                        //如果是+
                        result=d1+d2;
                    }else if(op.equals("-")){
                        //如果是-
                        result=d1-d2;
                    }
                }else if (s1.equals("")&& !s2.equals("")) {
                    double d2 = Double.parseDouble(s2);
                    if (op.equals("+")) {
                        result = 0 + d2;
                    } else if (op.equals("-")) {
                        result = 0 - d2;
                    }
                    if(!s1.contains(".")&&!s2.contains(".")){
                        int r=(int) result;
                        editText.setText(r+"");
                    }else {
                        editText.setText(result+"");
                    }
                    }else {
                    editText.setText("");
                }

    }
}