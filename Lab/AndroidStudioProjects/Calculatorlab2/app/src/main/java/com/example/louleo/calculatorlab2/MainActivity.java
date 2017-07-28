package com.example.louleo.calculatorlab2;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import com.example.louleo.calculatorlab2.databinding.ActivityMainBinding;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class MainActivity extends AppCompatActivity {

    //    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//    }
    private ActivityMainBinding binding;

    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';

    private char CURRENT_ACTION;

    private double valueOne = Double.NaN;
    private double valueTwo;

    private DecimalFormat decimalFormat;
    //file staff here
    private String firstValue = "0.0";
    private String operator;
    private String secondValue;

    //file staff ends
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        decimalFormat = new DecimalFormat("#.##########");

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        final File exfile = new File(getFilesDir(),"exfile");

        binding.button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.editText.setText(binding.editText.getText() + "0");
            }
        });

        binding.button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.editText.setText(binding.editText.getText() + "1");
            }
        });

        binding.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.editText.setText(binding.editText.getText() + "2");
            }
        });

        binding.button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.editText.setText(binding.editText.getText() + "3");
            }
        });

        binding.button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.editText.setText(binding.editText.getText() + "4");
            }
        });

        binding.button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.editText.setText(binding.editText.getText() + "5");
            }
        });

        binding.button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.editText.setText(binding.editText.getText() + "6");
            }
        });

        binding.button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.editText.setText(binding.editText.getText() + "7");
            }
        });

        binding.button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.editText.setText(binding.editText.getText() + "8");
            }
        });

        binding.button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.editText.setText(binding.editText.getText() + "9");
            }
        });

        binding.buttonplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                computeCalculation();
//                CURRENT_ACTION = ADDITION;
//                binding.infoTextView.setText(decimalFormat.format(valueOne) + "+");
//                binding.editText.setText(null);
                modification();
                operator = "+";
                binding.infoTextView.setText(firstValue+operator);
                binding.editText.setText(null);
            }
        });

        binding.buttonminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                computeCalculation();
//                CURRENT_ACTION = SUBTRACTION;
//                binding.infoTextView.setText(decimalFormat.format(valueOne) + "-");
//                binding.editText.setText(null);
                modification();
                operator = "-";
                binding.infoTextView.setText(firstValue+operator);
                binding.editText.setText(null);
            }
        });

        binding.buttonmulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                computeCalculation();
//                CURRENT_ACTION = MULTIPLICATION;
//                binding.infoTextView.setText(decimalFormat.format(valueOne) + "*");
//                binding.editText.setText(null);
                modification();
                operator = "*";
                binding.infoTextView.setText(firstValue+operator);
                binding.editText.setText(null);
            }
        });

        binding.buttondivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                computeCalculation();
//                CURRENT_ACTION = DIVISION;
//                binding.infoTextView.setText(decimalFormat.format(valueOne) + "/");
//                binding.editText.setText(null);
                modification();
                operator = "/";
                binding.infoTextView.setText(firstValue+operator);
                binding.editText.setText(null);
            }
        });

        binding.buttonequal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                computeCalculation();
//                binding.infoTextView.setText(binding.infoTextView.getText().toString() +
//                        decimalFormat.format(valueTwo) + " = " + decimalFormat.format(valueOne));
//                valueOne = Double.NaN;
//                CURRENT_ACTION = '0';
                //from here
                modification();
                binding.infoTextView.setText(firstValue+operator+secondValue);
                binding.editText.setText(null);
                Expression expression = new Expression(firstValue,operator,secondValue);
                expression.save(exfile);
                //to here

            }
        });
//replay from here
        binding.buttonreplay.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Expression expressionload = Expression.load(exfile);
                binding.editText.setText(expressionload.firstvalue + expressionload.operator+expressionload.secondvalue);
            }
        });
//replay ends here
        binding.buttonclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if(binding.editText.getText().length() > 0) {
//                    CharSequence currentText = binding.editText.getText();
//                    binding.editText.setText(currentText.subSequence(0, currentText.length()-1));
//                }
//                else {
//                    valueOne = Double.NaN;
//                    valueTwo = Double.NaN;
                    firstValue = "0.0";
                    secondValue = "0.0";
                    operator = "";
                    binding.editText.setText("");
                    binding.infoTextView.setText("");
//                }
            }
        });
    }
    private void modification(){
        if(firstValue.equals("0.0")){
            firstValue = binding.editText.getText().toString();
        }else{
            secondValue = binding.editText.getText().toString();
        }
    }

    private void computeCalculation() {
        if(!Double.isNaN(valueOne)) {
            valueTwo = Double.parseDouble(binding.editText.getText().toString());
            binding.editText.setText(null);

            if(CURRENT_ACTION == ADDITION)
                valueOne = this.valueOne + valueTwo;
            else if(CURRENT_ACTION == SUBTRACTION)
                valueOne = this.valueOne - valueTwo;
            else if(CURRENT_ACTION == MULTIPLICATION)
                valueOne = this.valueOne * valueTwo;
            else if(CURRENT_ACTION == DIVISION)
                valueOne = this.valueOne / valueTwo;
        }
        else {
            try {
                valueOne = Double.parseDouble(binding.editText.getText().toString());
            }
            catch (Exception e){}
        }
    }
// expression
static class Expression{
        private static final String EXPRESSION = "Expression";
        private static final String FIRSTVALUE = "Firstvalue";
        private static final String SECONDVALUE = "Secondvalue";
        private static final String OPERATOR = "Operator";
        String firstvalue;
        String secondvalue;
        String operator;
        public Expression(String firstvalue, String operator,String secondvalue){
            this.firstvalue = firstvalue;
            this.secondvalue= secondvalue;
            this.operator = operator;
        }
        public Expression(){

        }
        public void save(File f){
//            File f = new File(filename);
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db;
            try {
                // make the xml tree
                db = dbf.newDocumentBuilder();
                Document doc = db.newDocument();
                Element expression = doc.createElement(EXPRESSION);

                Element en = doc.createElement(FIRSTVALUE);
                en.appendChild(doc.createTextNode(firstvalue));
                expression.appendChild(en);

                Element ea = doc.createElement(OPERATOR);
                ea.appendChild(doc.createTextNode(operator));
                expression.appendChild(ea);

                Element eb = doc.createElement(SECONDVALUE);
                eb.appendChild(doc.createTextNode(secondvalue));
                expression.appendChild(eb);

                doc.appendChild(expression);
                // save the xml file
                TransformerFactory transformerFactory = TransformerFactory
                        .newInstance();
                Transformer transformer = transformerFactory.newTransformer();

                // set xml encoding to utf-8
                transformer.setOutputProperty(OutputKeys.ENCODING,"utf-8");

                DOMSource source = new DOMSource(doc);
                StreamResult result = new StreamResult(f);
                transformer.transform(source, result);
            } catch (Exception e) {
                System.err.println("Problem saving ");
            }

        }
        public static Expression load(File f) {
            //File f = new File(filename);
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db;
            Expression res = new Expression();

            try {
                // load the xml tree
                db = dbf.newDocumentBuilder();
                Document doc = db.parse(f);

                // parse the tree and obtain the person info
                Node expression = doc.getFirstChild();

                NodeList nl = expression.getChildNodes();
                for (int i =0;i< nl.getLength();i++) {
                    Node n = nl.item(i);
                    if (n.getNodeName().equals(FIRSTVALUE)) {
                        res.firstvalue = n.getTextContent();
                    } else if (n.getNodeName().equals(OPERATOR)) {
                        res.operator = n.getTextContent();
                    } else if(n.getNodeName().equals(SECONDVALUE)){
                        res.secondvalue = n.getTextContent();
                    }
                }

            } catch (Exception e) {
                System.err.println("Problem loading ");
            }
            return res;
        }
    }

}
