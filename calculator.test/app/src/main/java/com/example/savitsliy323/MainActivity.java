package com.example.savitsliy323;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.graphics.Insets;

public class MainActivity extends AppCompatActivity {

    // Объявляем переменные для пользовательских интерфейсов
    private EditText ta; // Поле ввода для первого числа
    private EditText tb;
    private TextView lr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        LinearLayout bs1 = findViewById(R.id.buttonsSection);
        EditText et1 = findViewById(R.id.txtB);
        TextView tv1 = findViewById(R.id.textView2);
        LinearLayout bs2 = findViewById(R.id.buttonsSection2);
        LinearLayout bs3 = findViewById(R.id.buttonsSection3);
        bs1.setVisibility(View.VISIBLE);
        et1.setVisibility(View.VISIBLE);
        tv1.setVisibility(View.VISIBLE);
        bs2.setVisibility(View.INVISIBLE);
        bs3.setVisibility(View.INVISIBLE);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        // Инициализация компонентов после setContentView
        ta = findViewById(R.id.txtA); // Находим поле ввода первого числа
        tb = findViewById(R.id.txtB);
        lr = findViewById(R.id.labC);
    }






    public void switchnumber(View v) {
        LinearLayout bs1 = findViewById(R.id.buttonsSection);
        EditText et1 = findViewById(R.id.txtB);
        TextView tv1 = findViewById(R.id.textView2);
        LinearLayout bs2 = findViewById(R.id.buttonsSection2);
        LinearLayout bs3 = findViewById(R.id.buttonsSection3);
        if (bs1.getVisibility() == View.VISIBLE) {
            bs1.setVisibility(View.INVISIBLE);
            et1.setVisibility(View.INVISIBLE);
            bs2.setVisibility(View.VISIBLE);
            tv1.setVisibility(View.INVISIBLE);
            bs3.setVisibility(View.VISIBLE);
        } else {
            bs1.setVisibility(View.VISIBLE);
            et1.setVisibility(View.VISIBLE);
            tv1.setVisibility(View.VISIBLE);
            bs2.setVisibility(View.INVISIBLE);
            bs3.setVisibility(View.INVISIBLE);
        }
    }

    public void my_add_click(View v) {
        performOperation("+");
    }

    public void my_ctg_click(View v) {
        performOperation("ctg");
    }
    public void my_tg_click(View v) {
        performOperation("tg");
    }
    public void my_sin_click(View v) {
        performOperation("sin");
    }
    public void my_cos_click(View v) {
        performOperation("cos");
    }
    public void my_two_click(View v) {
        performOperation("two");
    }
    public void my_sqrt_click(View v) {
        performOperation("sqrt");
    }


    public void my_sub_click(View v)
    {
        performOperation("-");
    }

    public void my_mul_click(View v)
    {
        performOperation("*");
    }

    public void my_div_click(View v) {
        performOperation("/");
    }

    private void performOperation(String operation) {
        String sa = ta.getText().toString();
        String sb = tb.getText().toString();

        if (!sa.isEmpty() && !sb.isEmpty()) {
            try {
                float a = Float.parseFloat(sa);
                float b = Float.parseFloat(sb);
                float result;



                switch (operation) {
                    case "sin":
                        result = (float) Math.sin(a);
                        break;
                    case "cos":
                        result = (float) Math.cos(a);
                        break;
                    case "tg":
                        result = (float) Math.tan(a);
                        break;
                    case "ctg":
                        if (Math.tan(a) == 0) {
                            lr.setText("Undefined operation");
                            return;
                        }
                        result = (float) 1 / (float) Math.tan(a);
                        break;
                    case "sqrt":
                        if (a < 0) {
                            lr.setText("Invalid operation: square root of a negative number");
                            return;
                        }
                        result = (float) Math.sqrt(a);
                        break;
                    case "two":
                        result = (float) a*a;
                        break;
                    case "+":
                        result = a + b;
                        break;
                    case "-":
                        result = a - b;
                        break;
                    case "*":
                        result = a * b;
                        break;
                    case "/":
                        if (b != 0) {
                            result = a / b;
                        } else {
                            lr.setText("You mustn't division on null");
                            return;
                        }
                        break;
                    default:
                        throw new IllegalArgumentException("Unexpected operation: " + operation);
                }

                lr.setText(String.valueOf(result));

            } catch (NumberFormatException e) {
                lr.setText("Invallid input");
            }
        } else {
            LinearLayout bs1 = findViewById(R.id.buttonsSection);

// Check if the buttons section is visible
            if (bs1.getVisibility() == View.VISIBLE) {
                lr.setText("Please enter numbers!");
            } else {
                // Assuming `a` is an EditText or similar input field you're validating
                EditText txt = findViewById(R.id.txtA);
                String textValue = txt.getText().toString();

                // Check if the input text is empty or equals to 0
                if (textValue.isEmpty()) {
                    lr.setText("Please enter a non-zero number!");

                }
            }
        }
    }
}