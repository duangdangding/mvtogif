/*
 * Created by JFormDesigner on Sun Feb 07 13:06:09 CST 2021
 */

package com.lsh.app.mvtogif.frame;

import com.lsh.app.mvtogif.tools.SwingUtil;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.*;

/**
 * @author asdasda
 */
@Component("MainFrame")
public class MainFrame extends JFrame {
    public MainFrame() {
        initComponents();
    }

    private void button1ActionPerformed(ActionEvent e) {
        setText(0,textField1);
    }
    private void button2ActionPerformed(ActionEvent e) {
        setText(1,textField2);
    }
    private void button3ActionPerformed(ActionEvent e) {
    }

    /**
     * 选择文件或者文件夹之后 设置内容
     * @param model
     * @param textField
     */
    private void setText(int model,JTextField textField) {
        int i = SwingUtil.openF(model);
        if (i == 1) {
            return;
        } else {
            String absolutePath = SwingUtil.JFILE.getSelectedFile().getAbsolutePath();
            textField.setText(absolutePath);
        }
    }

    private void okButtonActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        dialogPane = new JPanel();
        buttonBar = new JPanel();
        okButton = new JButton();
        panel1 = new JPanel();
        label2 = new JLabel();
        textField1 = new JTextField();
        button1 = new JButton();
        panel2 = new JPanel();
        label3 = new JLabel();
        textField2 = new JTextField();
        button2 = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            dialogPane.setLayout(new BorderLayout());

            //======== buttonBar ========
            {
                buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));
                buttonBar.setLayout(new GridBagLayout());
                ((GridBagLayout)buttonBar.getLayout()).columnWidths = new int[] {0, 80};
                ((GridBagLayout)buttonBar.getLayout()).columnWeights = new double[] {1.0, 0.0};

                //---- okButton ----
                okButton.setText("\u5f00\u59cb\u8f6c\u6362");
                okButton.addActionListener(e -> okButtonActionPerformed(e));
                buttonBar.add(okButton, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 0), 0, 0));
            }
            dialogPane.add(buttonBar, BorderLayout.SOUTH);

            //======== panel1 ========
            {
                panel1.setLayout(new FlowLayout());

                //---- label2 ----
                label2.setText("\u89c6\u9891\u6587\u4ef6\uff1a");
                panel1.add(label2);
                panel1.add(textField1);

                //---- button1 ----
                button1.setText("\u9009\u62e9");
                button1.addActionListener(e -> button1ActionPerformed(e));
                panel1.add(button1);
            }
            dialogPane.add(panel1, BorderLayout.NORTH);

            //======== panel2 ========
            {
                panel2.setLayout(new FlowLayout());

                //---- label3 ----
                label3.setText("\u4fdd\u5b58\u8def\u5f84\uff1a");
                panel2.add(label3);
                panel2.add(textField2);

                //---- button2 ----
                button2.setText("\u9009\u62e9");
                button2.addActionListener(e -> button2ActionPerformed(e));
                panel2.add(button2);
            }
            dialogPane.add(panel2, BorderLayout.CENTER);
        }
        contentPane.add(dialogPane, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel dialogPane;
    private JPanel buttonBar;
    private JButton okButton;
    private JPanel panel1;
    private JLabel label2;
    private JTextField textField1;
    private JButton button1;
    private JPanel panel2;
    private JLabel label3;
    private JTextField textField2;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
