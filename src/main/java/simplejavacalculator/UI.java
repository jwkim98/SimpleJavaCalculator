/**
 * @name        Simple Java Calculator
 * @file        UI.java
 * @author      SORIA Pierre-Henry
 * @copyright   Copyright Pierre-Henry SORIA, All Rights Reserved.
 * @license     Apache (http://www.apache.org/licenses/LICENSE-2.0)
 */

package simplejavacalculator;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.Box;
import javax.swing.BoxLayout;


import java.io.*;

public class UI implements ActionListener {
   
   private final JFrame frame;
   
   private final JPanel panel;
   private final JPanel panelSub1;
   private final JPanel panelSub2;
   private final JPanel panelSub3;
   private final JPanel panelSub4;
   private final JPanel panelSub5;
   private final JPanel panelSub6;
   private final JPanel panelSub7;
   private final JPanel panelSub8;
   
   private final JTextArea text;
   private final JButton but[], butAdd, butMinus, butMultiply, butDivide,
      butEqual, butCancel, butSquareRoot, butSquare, butOneDevidedBy,
      butCos, butSin, butTan, butxpowerofy, butlog, butrate, butabs, butBinary;
   private final Calculator calc;
   
   private final String[] buttonValue = {"0", "1", "2", "3", "4", "5", "6",
      "7", "8", "9"};
   
   private final Font font;
   private final Font textFont;

   
   public UI() throws IOException {
      frame = new JFrame("Calculator PH");

      
      panel = new JPanel();
      panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
      panelSub1 = new JPanel(new FlowLayout());
      panelSub2 = new JPanel(new FlowLayout());
      panelSub3 = new JPanel(new FlowLayout());
      panelSub4 = new JPanel(new FlowLayout());
      panelSub5 = new JPanel(new FlowLayout());
      panelSub6 = new JPanel(new FlowLayout());
      panelSub7 = new JPanel(new FlowLayout());
      panelSub8 = new JPanel(new FlowLayout());
      
      font = new Font("Consolas",Font.PLAIN, 18);
      
      text = new JTextArea(1, 30);
      
      textFont = new Font("Consolas",Font.BOLD, 24);
      
      but = new JButton[10];      
      for (int i = 0; i < 10; i++) {
         but[i] = new JButton(String.valueOf(i));
      }      
      butAdd = new JButton("+");      
      butMinus = new JButton("-");      
      butMultiply = new JButton("*");      
      butDivide = new JButton("/");      
      butEqual = new JButton("=");      
      butSquareRoot = new JButton("sqrt");      
      butSquare = new JButton("x*x");      
      butOneDevidedBy = new JButton("1/x");      
      butCos = new JButton("Cos");      
      butSin = new JButton("Sin");      
      butTan = new JButton("Tan");      
      butxpowerofy = new JButton("x^y");      
      butlog = new JButton("log10(x)");      
      butrate = new JButton("x%");      
      butabs = new JButton("abs(x)");      
      butCancel = new JButton("C");      
      butBinary = new JButton("Bin");      
      
      calc = new Calculator();
      
   }
   
   public void init() {      
      frame.setSize(450, 450);
      frame.setVisible(true);
      frame.setLocationRelativeTo(null); 
      frame.setResizable(false);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

      
      text.setFont(textFont);
      text.setEditable(false);
      
      for (int i = 0; i < 10; i++) {
         but[i].setFont(font);
      }      
      butAdd.setFont(font);
      butMinus.setFont(font);
      butMultiply.setFont(font);
      butDivide.setFont(font);
      butEqual.setFont(font);
      butSquareRoot.setFont(font);
      butSquare.setFont(font);
      butOneDevidedBy.setFont(font);
      butCos.setFont(font);
      butSin.setFont(font);
      butTan.setFont(font);
      butxpowerofy.setFont(font);
      butlog.setFont(font);
      butrate.setFont(font);
      butabs.setFont(font);
      butCancel.setFont(font);
      butBinary.setFont(font); 
      
      panel.add(Box.createHorizontalStrut(100));
      panelSub1.add(text);
      panel.add(panelSub1);
      
      panelSub2.add(but[1]);
      panelSub2.add(but[2]);
      panelSub2.add(but[3]);
      panelSub2.add(Box.createHorizontalStrut(15));
      panelSub2.add(butAdd);
      panelSub2.add(butMinus);
      panel.add(panelSub2);
      
      panelSub3.add(but[4]);
      panelSub3.add(but[5]);
      panelSub3.add(but[6]);
      panelSub3.add(Box.createHorizontalStrut(15));
      panelSub3.add(butMultiply);
      panelSub3.add(butDivide);      
      panel.add(panelSub3);
      
      panelSub4.add(but[7]);
      panelSub4.add(but[8]);
      panelSub4.add(but[9]);
      panelSub4.add(Box.createHorizontalStrut(15));
      panelSub4.add(butEqual);
      panelSub4.add(butCancel);
      panel.add(panelSub4);
      
      panelSub5.add(but[0]);
      panelSub5.add(Box.createHorizontalStrut(210));
      panel.add(panelSub5);
      
      panelSub6.add(butSquare);
      panelSub6.add(butSquareRoot);
      panelSub6.add(butOneDevidedBy);
      panelSub6.add(butxpowerofy);
      panel.add(panelSub6);
      
      panelSub7.add(butCos);
      panelSub7.add(butSin);
      panelSub7.add(butTan);
      panel.add(panelSub7);
      
      panelSub8.add(butlog);
      panelSub8.add(butrate);
      panelSub8.add(butabs);
      panelSub8.add(butBinary);
      panel.add(panelSub8);
      
      for (int i = 0; i < 10; i++) {
         but[i].addActionListener(this);
      }      
      butAdd.addActionListener(this);
      butMinus.addActionListener(this);
      butMultiply.addActionListener(this);
      butDivide.addActionListener(this);
      butSquare.addActionListener(this);
      butSquareRoot.addActionListener(this);
      butOneDevidedBy.addActionListener(this);
      butCos.addActionListener(this);
      butSin.addActionListener(this);
      butTan.addActionListener(this);
      butxpowerofy.addActionListener(this);
      butlog.addActionListener(this);
      butrate.addActionListener(this);
      butabs.addActionListener(this);
      butBinary.addActionListener(this);
      
      butEqual.addActionListener(this);
      butCancel.addActionListener(this);
      
      frame.add(panel);
   }
   
   @Override
   public void actionPerformed(ActionEvent e) {
      final Object source = e.getSource();
      
      for (int i = 0; i < 10; i++) {
         if (source == but[i]) {
            text.replaceSelection(buttonValue[i]);
            return;
         }
      }

      if(source == butAdd || source == butMinus || source == butMultiply || source == butDivide ||
      source == butxpowerofy || source == butSquare || source == butSquareRoot || source == butOneDevidedBy)
      {
         simpleArithmetics(source);
      }
      else{
         complexArithmetics(source);
      }
      
      text.selectAll();
   }

   private void simpleArithmetics(final Object source)
   {
      if (source == butAdd) {
         writer(calc.calculateBi(Calculator.BiOperatorModes.ADD, reader()));
      }
      else if (source == butMinus) {
         writer(calc.calculateBi(Calculator.BiOperatorModes.MINUS, reader()));
      }
      else if (source == butMultiply) {
         writer(calc.calculateBi(Calculator.BiOperatorModes.MULTIPLY,
                 reader()));
      }
      else if (source == butDivide) {
         writer(calc
                 .calculateBi(Calculator.BiOperatorModes.DIVIDE, reader()));
      }
      else if (source == butxpowerofy) {
         writer(calc
                 .calculateBi(Calculator.BiOperatorModes.XPOWEROFY, reader()));
      }
      else if (source == butSquare) {
         writer(calc.calculateMono(Calculator.MonoOperatorModes.SQUARE,
                 reader()));
      }
      else if (source == butSquareRoot) {
         writer(calc.calculateMono(Calculator.MonoOperatorModes.SQUARE_ROOT,
                 reader()));
      }
      else if (source == butOneDevidedBy) {
         writer(calc.calculateMono(
                 Calculator.MonoOperatorModes.ONE_DIVIDED_BY, reader()));
      }
   }

   private void complexArithmetics(final Object source)
   {
      if (source == butCos) {
      writer(calc.calculateMono(Calculator.MonoOperatorModes.COS,
              reader()));
      }
      else if (source == butSin) {
         writer(calc.calculateMono(Calculator.MonoOperatorModes.SIN,
                 reader()));
      }
      else if (source == butTan) {
         writer(calc.calculateMono(Calculator.MonoOperatorModes.TAN,
                 reader()));
      }
      else if (source == butlog) {
         writer(calc.calculateMono(Calculator.MonoOperatorModes.LOG,
                 reader()));
      }
      else if (source == butrate) {
         writer(calc.calculateMono(Calculator.MonoOperatorModes.RATE,
                 reader()));
      }
      else if(source == butabs){
         writer(calc.calculateMono(Calculator.MonoOperatorModes.ABS, reader()));
      }
      else if (source == butEqual) {
         writer(calc.calculateEqual(reader()));
      }
      else if (source == butCancel) {
         writer(calc.reset());
      }
      else if (source == butBinary) {
         parsetoBinary();
      }
   }
   
   private void parsetoBinary() {
      try {
         text.setText("" + Long.toBinaryString(Long.parseLong(text.getText())));
      } catch (NumberFormatException ex) {
         System.err.println("Error while parse to binary." + ex.toString());
      }
   }
   
   public Double reader() {
      Double num;
      String str;
      str = text.getText();
      num = Double.valueOf(str);
      
      return num;
   }
   
   public void writer(final Double num) {
      if (Double.isNaN(num)) {
         text.setText("");
      } else {
         text.setText(Double.toString(num));
      }
   }
}
