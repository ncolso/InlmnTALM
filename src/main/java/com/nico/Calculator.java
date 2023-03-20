package com.nico;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator implements ActionListener {

    JFrame frame;
    JTextField textField;
    JButton[] numBtns = new JButton[10];
    JButton[] funcBtns = new JButton[8];
    JButton addBtn, subBtn, mulBtn, divBtn, decBtn, equalBtn, delBtn, clrBtn;
    JPanel panel;

    Font font = new Font("Helvetica", Font.PLAIN, 30);
    Font fontTextField = new Font("Helvetica", Font.BOLD, 45);


    double num1 = 0, num2 = 0, result = 0;
    char operator;

    Calculator() {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(410, 530);
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.white);

        textField = new JTextField();
        textField.setBounds(50, 25, 300, 65);
        textField.setFont(fontTextField);
        textField.setEditable(false);
        textField.setBackground(Color.black);
        textField.setForeground(Color.white);

        addBtn = new JButton("+");
        addBtn.setBackground(Color.orange);
        subBtn = new JButton("-");
        subBtn.setBackground(Color.orange);
        mulBtn = new JButton("*");
        mulBtn.setBackground(Color.orange);
        divBtn = new JButton("/");
        divBtn.setBackground(Color.orange);
        decBtn = new JButton(".");
        decBtn.setBackground(Color.orange);
        equalBtn = new JButton("=");
        equalBtn.setBackground(Color.orange);
        delBtn = new JButton("<");
        delBtn.setBackground(Color.orange);
        clrBtn = new JButton("C");
        clrBtn.setBackground(Color.red);

        funcBtns[0] = addBtn;
        funcBtns[1] = subBtn;
        funcBtns[2] = mulBtn;
        funcBtns[3] = divBtn;
        funcBtns[4] = decBtn;
        funcBtns[5] = equalBtn;
        funcBtns[6] = delBtn;
        funcBtns[7] = clrBtn;

        for (int i = 0; i < 8; i++) {
            funcBtns[i].addActionListener(this);
            funcBtns[i].setFont(font);
            funcBtns[i].setFocusable(false);
        }

        for (int i = 0; i < 10; i++) {
            numBtns[i] = new JButton(String.valueOf(i));
            numBtns[i].addActionListener(this);
            numBtns[i].setFont(font);
            numBtns[i].setFocusable(false);
        }

        clrBtn.setBounds(50, 100, 145, 50);
        delBtn.setBounds(205, 100, 145, 50);

        panel = new JPanel();
        panel.setBounds(50, 160, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));
        panel.setBackground(Color.white);

        panel.add(numBtns[7]);
        panel.add(numBtns[8]);
        panel.add(numBtns[9]);
        panel.add(addBtn);
        panel.add(numBtns[4]);
        panel.add(numBtns[5]);
        panel.add(numBtns[6]);
        panel.add(subBtn);
        panel.add(numBtns[1]);
        panel.add(numBtns[2]);
        panel.add(numBtns[3]);
        panel.add(mulBtn);
        panel.add(numBtns[0]);
        panel.add(decBtn);
        panel.add(equalBtn);
        panel.add(divBtn);


        frame.add(panel);
        frame.add(clrBtn);
        frame.add(delBtn);
        frame.add(textField);
        frame.setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numBtns[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource() == decBtn) {
            textField.setText(textField.getText().concat("."));
        }
        if (e.getSource() == addBtn) {
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }
        if (e.getSource() == subBtn) {
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }
        if (e.getSource() == mulBtn) {
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }
        if (e.getSource() == divBtn) {
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }
        if (e.getSource() == equalBtn) {
            num2 = Double.parseDouble(textField.getText());
            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
            }
            textField.setText(String.valueOf(result));
            num1 = result;
        }
        if (e.getSource() == clrBtn) {
            textField.setText("");
        }
        if (e.getSource() == delBtn) {
            String string = textField.getText();
            textField.setText("");
            for (int i = 0; i < string.length() - 1; i++) {
                textField.setText(textField.getText() + string.charAt(i));
            }
        }

    }
}