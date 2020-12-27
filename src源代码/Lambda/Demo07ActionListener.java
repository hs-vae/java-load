package com.hs_vae.Lambda;
/*
    使用Lambda表达式实现监听器
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Demo07ActionListener extends JFrame{
    JPanel p;
    JTextArea ta;
    JButton bt1,bt2;
    public Demo07ActionListener(){
        super("com.hs_vae.Lambda 测试");
        p = new JPanel();
        ta = new JTextArea();
        bt1 = new JButton("传统方式");
        bt2 = new JButton("Lambda方式");
        //添加监听器
        //传统写法
        bt1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ta.append("点击传统方式按钮\n");
            }
        });
        //使用Lambda表达式
        bt2.addActionListener(e -> ta.append("点击Lambda方式按钮\n"));
        this.add(ta);
        p.add(bt1);
        p.add(bt2);
        this.add(p, BorderLayout.SOUTH);
        this.setSize(600,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new Demo07ActionListener().setVisible(true);
    }

}
