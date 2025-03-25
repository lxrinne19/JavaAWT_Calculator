/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.calcu;

/**
 *
 * @author maria
 */
 import java.awt.*;
import java.awt.event.*;




public class Calcu extends Frame implements ActionListener {
    private TextField t;
    private String operator;
    private double num1, num2, result;
    

    public Calcu() {
        
        
        setSize(400, 500);
        setLayout(new BorderLayout());
        setResizable(false);
        setBackground(Color.BLACK);
      setForeground(Color.WHITE);
       

        t = new TextField();
        t.setFont(new Font("Arial", Font.PLAIN, 36));
        t.setEditable(false);
        t.setBackground(new Color(192,96,168));
        t.setText(" ");
        add(t, BorderLayout.NORTH);

        Panel b = new Panel();
      b.setLayout(new GridLayout(5, 4, 10, 10));
    b.setBackground(new Color(255,192,203));
        
        String[] buttonLabels = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "C", "0", "=", "+"
        };

        for (String label : buttonLabels) {
            Button button = new Button(label);
            button.setFont(new Font("Arial", Font.BOLD, 20));
            button.setBackground(new Color(168,72,96));
            button.setForeground(Color.WHITE);
            button.addActionListener(this);
            b.add(button);
        }

        add(b, BorderLayout.CENTER);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        try {
            if ("0123456789".contains(command)) {
                t.setText(t.getText() + command);
            } else if ("+-*/".contains(command)) {
                num1= Double.parseDouble(t.getText());
                operator = command;
                t.setText("");
            } else if ("=".equals(command)) {
                num2 = Double.parseDouble(t.getText());
                switch (operator) {
                    case "+":
                        result = num1 + num2;
                        break;
                    case "-":
                        result = num1 - num2;
                        break;
                    case "*":
                        result = num1 * num2;
                        break;
                    case "/":
                        if (num2 == 0) {
                            t.setText("Undefined");
                            return;
                        }
                        result = num1 / num2;
                        break;
                }
                t.setText(String.valueOf(result));
            } else if ("C".equals(command)) {
                t.setText("");
                num1 = num2 = result = 0;
                operator = "";
            }
        } catch (NumberFormatException ex) {
            t.setText("Syntax Error");
        }
    }

    public static void main(String[] args) {
      new Calcu();
    }
}