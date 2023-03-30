package com.codewithsidd.calyx;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Stack;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;
    private Button button0;
    private Button buttonplus;
    private Button buttonminus;
    private Button buttonmultiply;
    private Button buttondivide;
    private Button button_right_brkt;
    private Button button_left_brkt;
    private Button button_power;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView1);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        button0 = findViewById(R.id.button0);
        buttonplus = findViewById(R.id.buttonplus);
        buttonminus = findViewById(R.id.buttonminus);
        buttonmultiply = findViewById(R.id.buttonmultiply);
        buttondivide = findViewById(R.id.buttondivide);
        button_right_brkt = findViewById(R.id.button_right_brkt);
        button_left_brkt = findViewById(R.id.button_left_brkt);
        button_power= findViewById(R.id.button_power);

        button_power.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String prev = textView.getText().toString();
                prev = prev + '^';
                textView.setText(prev);
            }
        });

        button_left_brkt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String prev = textView.getText().toString();
                prev = prev + '(';
                textView.setText(prev);
            }
        });
        button_right_brkt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String prev = textView.getText().toString();
                prev = prev + ')';
                textView.setText(prev);
            }
        });
        buttondivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String prev = textView.getText().toString();
                prev = prev + '/';
                textView.setText(prev);
            }
        });
        buttonmultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String prev = textView.getText().toString();
                prev = prev + '*';
                textView.setText(prev);
            }
        });
        buttonminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String prev = textView.getText().toString();
                prev = prev + '-';
                textView.setText(prev);
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String prev = textView.getText().toString();
                prev = prev + '1';
                textView.setText(prev);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String prev = textView.getText().toString();
                prev = prev + '2';
                textView.setText(prev);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String prev = textView.getText().toString();
                prev = prev + '3';
                textView.setText(prev);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String prev = textView.getText().toString();
                prev = prev + '4';
                textView.setText(prev);
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String prev = textView.getText().toString();
                prev = prev + '5';
                textView.setText(prev);
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String prev = textView.getText().toString();
                prev = prev + '6';
                textView.setText(prev);
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String prev = textView.getText().toString();
                prev = prev + '7';
                textView.setText(prev);
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String prev = textView.getText().toString();
                prev = prev + '8';
                textView.setText(prev);
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String prev = textView.getText().toString();
                prev = prev + '9';
                textView.setText(prev);
            }
        });
        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String prev = textView.getText().toString();
                prev = prev + '0';
                textView.setText(prev);
            }
        });
        buttonplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String prev = textView.getText().toString();
                prev = prev + '+';
                textView.setText(prev);
            }
        });

    }

    static double evaluatePostfix(String postfix) {
        Stack<Double> stack = new Stack<Double>();

        for (int i = 0; i < postfix.length(); i++) {
            char c = postfix.charAt(i);

            if (Character.isDigit(c)) {
                double num = 0;
                while (i < postfix.length() && Character.isDigit(c)) {
                    num = num * 10 + (c - '0');
                    i++;
                    if (i < postfix.length())
                        c = postfix.charAt(i);
                }
                i--;
                stack.push(num);
            } else if (c == '+' || c == '-' || c == '*' || c == '/' || c == '%' || c == '^') {
                double operand2 = stack.pop();
                double operand1 = stack.pop();
                double result = 0;

                switch (c) {
                    case '+':
                        result = operand1 + operand2;
                        break;
                    case '-':
                        result = operand1 - operand2;
                        break;
                    case '*':
                        result = operand1 * operand2;
                        break;
                    case '/':
                        result = operand1 / operand2;
                        break;
                    case '%':
                        result = operand1 % operand2;
                        break;
                    case '^':
                        result = Math.pow(operand1, operand2);
                        break;
                }

                stack.push(result);
            }
        }

        return stack.pop();
    }

    static int precedence(char c) {
        switch (c) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
            case '%':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    static String infixToPostfix(String infix) {
        String postfix = "";
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);

            if (Character.isDigit(c)) {
                StringBuilder sb = new StringBuilder();
                while (i < infix.length() && Character.isDigit(c)) {
                    sb.append(c);
                    i++;
                    if (i < infix.length())
                        c = infix.charAt(i);
                }
                i--;
                postfix += sb.toString() + " ";
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix += stack.pop() + " ";
                }
                if (!stack.isEmpty() && stack.peek() != '(') {
                    return "Invalid Expression";
                } else {
                    stack.pop();
                }
            } else if (c == '+' || c == '-' || c == '*' || c == '/' || c == '%' || c == '^') {
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    postfix += stack.pop() + " ";
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            postfix += stack.pop() + " ";
        }

        return postfix.trim();
    }

    public void calculate(View view) {
        String expression = textView.getText().toString();
        Toast.makeText(this, expression, Toast.LENGTH_SHORT).show();
        String postfix = infixToPostfix(expression);
        double result = evaluatePostfix(postfix);
        String answer = String.valueOf(result);
        //Toast.makeText(this, answer, Toast.LENGTH_SHORT).show();
        textView.setText(answer);
        //String answer = String.valueOf(evaluate(expression));
        //textView.setText(answer);
    }

    public void clear(View view) {
        //Toast.makeText(this, "Clear", Toast.LENGTH_SHORT).show();
        textView.setText("");
    }

    public void bkpsp(View view)
    {
        textView.setText(textView.getText().subSequence(0,textView.getText().length()-1));
    }
}