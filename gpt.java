/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giaiphuongtrinhb2;

import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author CHU TUAN KIET
 */
public class gpt extends JFrame {

    int tam;
    double a, b, c, xx1, xx2, delta, x1, x2;
    String s;

    JLabel tieude = new JLabel();
    JLabel gioithieu = new JLabel();
    JLabel HeSoA = new JLabel();
    JLabel HeSoB = new JLabel();
    JLabel HeSoC = new JLabel();
    JLabel ketqua = new JLabel();

    JTextField khungHsa = new JTextField();
    JTextField khungHsb = new JTextField();
    JTextField khungHsc = new JTextField();

    JTextArea khungketqua = new JTextArea();

    JButton thoat = new JButton();
    JButton tieptuc = new JButton();
    JButton thuchien = new JButton();

//    ButtonGroup group1 = new ButtonGroup();
    Font font = new Font("Tahoma", Font.BOLD, 20);

    public gpt() {
        this.getContentPane().setLayout(null);

        tieude.setBounds(new Rectangle(30, 20, 350, 30));
        tieude.setText("Giải phương trình bậc HIGH");
        tieude.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        tieude.setFont(font);

        gioithieu.setBounds(new Rectangle(100, 50, 200, 30));
        gioithieu.setText("Chu Tuấn Kiệt - ANHTTT K55");
        this.getContentPane().add(gioithieu);

        // nhap he so a
        HeSoA.setBounds(new Rectangle(30, 100, 100, 30));
        HeSoA.setText("Nhập hệ số a: ");
        this.getContentPane().add(HeSoA);

        khungHsa.setBounds(new Rectangle(120, 100, 40, 25));
        this.getContentPane().add(khungHsa);

        //nhap he so b
        HeSoB.setBounds(new Rectangle(30, 140, 100, 30));
        HeSoB.setText("Nhập hệ số b: ");
        this.getContentPane().add(HeSoB);

        khungHsb.setBounds(new Rectangle(120, 140, 40, 25));
        this.getContentPane().add(khungHsb);

        //nhap he so c 
        HeSoC.setBounds(new Rectangle(30, 180, 100, 30));
        HeSoC.setText("Nhập hệ số c: ");
        this.getContentPane().add(HeSoC);

        khungHsc.setBounds(new Rectangle(120, 180, 40, 25));
        this.getContentPane().add(khungHsc);

        // ket qua
        ketqua.setBounds(new Rectangle(260, 100, 100, 30));
        ketqua.setText("Kết quả");
        this.getContentPane().add(ketqua);

        khungketqua.setBounds(new Rectangle(190, 140, 180, 65));
        khungketqua.setLineWrap(true);
        khungketqua.setWrapStyleWord(true);
        this.getContentPane().add(khungketqua);

        // button
        thuchien.setBounds(new Rectangle(30, 260, 100, 30));
        thuchien.setText("Thực hiện");
        this.getContentPane().add(thuchien);

        tieptuc.setBounds(new Rectangle(140, 260, 100, 30));
        tieptuc.setText("Tiếp tục");
        this.getContentPane().add(tieptuc);

        thoat.setBounds(new Rectangle(250, 260, 100, 30));
        thoat.setText("Thoát");
        this.getContentPane().add(thoat);

        // phan mac dinh button
        phanButton j = new phanButton();
        thuchien.addActionListener(j);
        tieptuc.addActionListener(j);
        thoat.addActionListener(j);

        this.setBounds(500, 250, 400, 360);
        this.getContentPane().add(tieude);
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
//        this.addWindowListener(new WindowAdapter() {
//            public void windowClosing(WindowEvent windowEvent) {
//                System.exit(0);
//            }
//        });

    }

    public class phanButton implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == thoat) {
                System.exit(0);
            }
            if (e.getSource() == tieptuc) {
                khungHsa.setText("");
                khungHsb.setText("");
                khungHsc.setText("");
                khungketqua.setText("");
            }

            if (e.getSource() == thuchien) {
                try {
                    a = Double.parseDouble(khungHsa.getText());
                    b = Double.parseDouble(khungHsb.getText());
                    c = Double.parseDouble(khungHsc.getText());
                } catch (NumberFormatException i) {
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập đúng định dạng. Mã lỗi : " + i);
                    khungketqua.setText("");
                }

                if (a == 0) {
                    xx2 = (-c) / b;
                    s = String.valueOf(xx2);
                    khungketqua.setText(s);
                } else {
                    delta = (b * b) - 4 * a * c;
                    if (delta < 0) {
                        khungketqua.setText("Phương trình vô nghiệm");
                    } else {
                        if (delta == 0) {
                            xx2 = (-b) / (2 * a);
                            s = String.valueOf(xx2);
                            khungketqua.setText("Phương trình có nghiệm kép \nx = " + s);
                        } else {
                            x1 = (-b + Math.sqrt(delta) / (2 * a));
                            x2 = (-a + Math.sqrt(delta) / (2 * a));
                            khungketqua.setText("Phương trình có hai nghiệm \nx1 = " + x1 + " và x2 = " + x2);
                        }
                    }
                }

            }
        }
    }

    public static void main(String[] args) {
        gpt f = new gpt();
        f.setSize(400, 360);
    }
}
