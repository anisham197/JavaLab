import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SwingTest
{
    JFrame frame;
    JButton primeButton, factButton, clearButton;
    JTextField textField;
    JScrollPane scroll;
    JTextArea textArea;
    JPanel p1;

    public void prepareGUI()
    {
      textField = new JTextField(20);

  		primeButton = new JButton("Prime");
  		factButton = new JButton("Factorial");
  		clearButton = new JButton("Clear");

  		textArea = new JTextArea("", 10, 30);
  		textArea.setLineWrap(true);

  		scroll = new JScrollPane(textArea);

      p1 = new JPanel();
      p1.setLayout(new FlowLayout());
      p1.add(textField);
      p1.add(primeButton);
      p1.add(factButton);
      p1.add(clearButton);
      p1.add(scroll);

      frame = new JFrame("Math");
      frame.setLayout(new GridLayout(3, 1));
      frame.setSize(800,800);
      frame.add(p1);
      frame.setVisible(true);
    }

    public void setActions()
    {
      frame.addWindowListener(new WindowAdapter(){
          public void windowClosing(WindowEvent winEvt)
          {
              System.exit(0);
          }
      });

      primeButton.addActionListener(new ActionListener(){

        public void actionPerformed(ActionEvent ae)
        {
          String textFieldValue = textField.getText();

          if(textFieldValue.length() > 0 && Integer.parseInt(textFieldValue) > 0){
            textArea.append("\nPrime Numbers: \n");
            for(String s : getPrimes(Integer.parseInt(textFieldValue)) )
                textArea.append( s + "\n");
          }
          else
          {
            textArea.append("Enter valid input! \n");
          }
        }
      });

      factButton.addActionListener(new ActionListener() {

        public void actionPerformed(ActionEvent ae)
        {
          String textFieldValue = textField.getText();
          if(textFieldValue.length() > 0 && Integer.parseInt(textFieldValue) > 0)
            textArea.append("\nFactorial: " + factorial(Integer.parseInt(textFieldValue)) + "\n");
          else
              textArea.append("Enter some number! \n");
        }
      });

      clearButton.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent ae){
           textArea.setText("");
           textField.setText("");
         }
      });
    }

    public SwingTest()
    {
        prepareGUI();
        setActions();
    }

    public static void main(String[] args) {
      SwingTest st = new SwingTest();
    }

    public static long factorial(int n) {
      long fact = 1;
      for (int i = 1; i <= n; i++)
          fact = fact * i;
      return fact;
    }

    public static ArrayList<String> getPrimes(int number ){
      int count = 0;
      ArrayList<String> result = new ArrayList<>();
      int num = 2;
      while( count!= number)// while count!= number of prime numbers entered keep searching..
      {
        boolean prime = true;// to determine whether the number is prime or not
        for (int i = 2; i <= Math.sqrt(num); i++) //efficiency matters
        {
          if (num % i == 0)
          {
            prime = false;// if number divides any other number its not a prime so set prime to false and break the loop.
            break;
          }
        }
        if (prime)
        {
          count++;
          result.add(""+num);
        }
        num++;
      }
      return result;
    }
}
