package exeploreGame;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class GamePannel2 extends javax.swing.JPanel {

    int win = 0, levelwin = 0, level = 1, maxlevel = 3, bestScore = 0;

    final private Border darkborder = new LineBorder(Color.DARK_GRAY, 1);
    final private Border lightborder = new LineBorder(Color.lightGray, 1);
    final private Border nullborder = new LineBorder(Color.darkGray, 0);
    final private JLabel imageLabel = new JLabel();
    final private JPanel stage = new JPanel();
    final private GamePannel gamePannel;

    final private CardLayout card = new CardLayout();//layout for controlPannel

    //game variables
    private int maxpics = 8, a, b, c, d, e, i, ans = 0, pictime = 800, lock = 0;
    private Timer picTimer;

    public GamePannel2(GamePannel gamePannel) {
        initComponents();
        this.gamePannel = gamePannel;
        myinit();
    }//constructor

    public void updateBox() {

    }

    public final void myinit() {
        setSize(820, 620);//our standard game pannel size
        setOpaque(false);//to make buttons transparent

        controlPannel.setBounds(60, 150, 500, 288);//ratio 585:495 :: 13:11
        controlPannel.setLayout(null);
        controlPannel.setFocusable(true);
        controlPannel.setOpaque(false);//to make buttons transparent
        controlPannel.setFocusTraversalKeysEnabled(false);
        imageLabel.setBounds(0, 0, 588, 288);
        controlPannel.add(imageLabel);

        initBoard();

    }//my init

    public void gameFinish() {
        levelwin = 1;
        switch (level) {
            case 1:
                bestScore = 10;
                break;
            case 2:
                bestScore = 25;
                break;
            case 3:
                bestScore = 45;
                break;
        }
        if (levelwin == 1) {
            if (level < maxlevel) {
                level++;
                maxpics += 2;
                pictime -= 100;

                scoreLabel.setText("Điểm : " + bestScore);
                gamePannel.scoreUpdate();
                JOptionPane.showMessageDialog(controlPannel, "Sang level mới", "Hoàn thành phần chơi", JOptionPane.INFORMATION_MESSAGE);
                initBoard();
            } else if (level == maxlevel) {
                win = 1;

                scoreLabel.setText("Điểm : " + bestScore);
                gamePannel.scoreUpdate();
                JOptionPane.showMessageDialog(controlPannel, "Bạn thắng", "Hoàn thành phần chơi", JOptionPane.INFORMATION_MESSAGE);
                gamePannel.home();
            }
        }
    }//called on finish of a level

    public void initBoard() {
        ansTextField.setVisible(false);
        submitButton.setVisible(false);
        questionLabel.setVisible(false);
        levelLabel.setText("Màn : " + level + "/" + maxlevel);
        questionLabel.setText("Số lần ảnh trên được hiển thị : ");
        a = 0;
        b = 0;
        c = 0;
        d = 0;
        e = 0;
        i = 0;
        levelwin = 0;
        lock = 0;

        picTimer = new Timer(pictime, new updatePic());
        picTimer.start();
    }

    public class updatePic implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            int rnd = 0;
            if (i == 0) {
                imageLabel.setIcon(null);
            }
            if (i > 0 && i < (maxpics * 2) + 1) {
                if (i % 2 == 0) {//no image for even times
                    imageLabel.setIcon(null);
                } else {

                    rnd = (int) (Math.random() * 5) + 1;
                    switch (rnd) {
                        case 1:
                            imageLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/a.png")));
                            a++;
                            break;
                        case 2:
                            imageLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/b.png")));
                            b++;
                            break;
                        case 3:
                            imageLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/c.png")));
                            c++;
                            break;
                        case 4:
                            imageLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/d.png")));
                            d++;
                            break;
                        case 5:
                            imageLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/e.png")));
                            e++;
                            break;
                        default:
                            break;
                    }
                }//end else
            }

            if (i == maxpics * 2 + 1) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ex) {
                }
            }
            if (i == maxpics * 2 + 2) {
                picTimer.stop();
                question();
            }
            i++;
        }

    }

    public void question() {
        ansTextField.setVisible(true);
        submitButton.setVisible(true);
        questionLabel.setVisible(true);

        int rnd = (int) (Math.random() * 5) + 1;
        switch (rnd) {
            case 1:
                imageLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/a.png")));
                ans = a;
                break;
            case 2:
                imageLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/b.png")));
                ans = b;
                break;
            case 3:
                imageLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/c.png")));
                ans = c;
                break;
            case 4:
                imageLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/d.png")));
                ans = d;
                break;
            case 5:
                imageLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/e.png")));
                ans = e;
                break;
        }

    }

    public void getFocus() {
        controlPannel.grabFocus();//get focus back to control pannel
    }

    public void resetLevel() {
        picTimer.stop();
        imageLabel.setIcon(null);
        initBoard();
        controlPannel.grabFocus();//get focus back to control pannel
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        heading = new javax.swing.JLabel();
        controlPannel = new javax.swing.JPanel();
        newButton = new javax.swing.JButton();
        submitButton = new javax.swing.JButton();
        helpButton = new javax.swing.JButton();
        levelLabel = new javax.swing.JLabel();
        scoreLabel = new javax.swing.JLabel();
        questionLabel = new javax.swing.JLabel();
        ansTextField = new javax.swing.JTextField();
        footerLabel = new javax.swing.JLabel();
        background_Image = new javax.swing.JLabel();

        setLayout(null);

        heading.setFont(new java.awt.Font("DejaVu Serif", 1, 48)); // NOI18N
        heading.setForeground(new java.awt.Color(255, 255, 255));
        heading.setText("Ghi nhớ");
        add(heading);
        heading.setBounds(140, 10, 430, 90);

        javax.swing.GroupLayout controlPannelLayout = new javax.swing.GroupLayout(controlPannel);
        controlPannel.setLayout(controlPannelLayout);
        controlPannelLayout.setHorizontalGroup(
            controlPannelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        controlPannelLayout.setVerticalGroup(
            controlPannelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        add(controlPannel);
        controlPannel.setBounds(60, 150, 500, 288);
        controlPannel.getAccessibleContext().setAccessibleName("");

        newButton.setText("Chơi lại");
        newButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newButtonActionPerformed(evt);
            }
        });
        add(newButton);
        newButton.setBounds(670, 290, 110, 23);

        submitButton.setText("Nhập");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });
        add(submitButton);
        submitButton.setBounds(440, 490, 110, 23);

        helpButton.setText("Hướng dẫn");
        helpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpButtonActionPerformed(evt);
            }
        });
        add(helpButton);
        helpButton.setBounds(670, 350, 110, 23);

        levelLabel.setFont(new java.awt.Font("TakaoPGothic", 1, 24)); // NOI18N
        levelLabel.setForeground(new java.awt.Color(252, 236, 236));
        levelLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        levelLabel.setText("Màn : 1/3");
        add(levelLabel);
        levelLabel.setBounds(620, 20, 180, 50);

        scoreLabel.setFont(new java.awt.Font("TakaoPGothic", 1, 24)); // NOI18N
        scoreLabel.setForeground(new java.awt.Color(252, 236, 236));
        scoreLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        scoreLabel.setText("Điểm : 0");
        add(scoreLabel);
        scoreLabel.setBounds(620, 120, 180, 50);

        questionLabel.setFont(new java.awt.Font("TakaoPGothic", 1, 18)); // NOI18N
        questionLabel.setForeground(new java.awt.Color(255, 255, 255));
        questionLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        questionLabel.setText("Số lần ảnh trên được hiển thị : ");
        add(questionLabel);
        questionLabel.setBounds(80, 430, 350, 50);
        questionLabel.getAccessibleContext().setAccessibleDescription("");

        ansTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ansTextFieldKeyTyped(evt);
            }
        });
        add(ansTextField);
        ansTextField.setBounds(460, 450, 70, 30);

        footerLabel.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        footerLabel.setForeground(new java.awt.Color(255, 244, 244));
        add(footerLabel);
        footerLabel.setBounds(40, 590, 250, 20);

        background_Image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/gamePannelBackground2.jpg"))); // NOI18N
        add(background_Image);
        background_Image.setBounds(0, 0, 820, 620);
    }// </editor-fold>//GEN-END:initComponents

    private void newButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newButtonActionPerformed
        resetLevel();
    }//GEN-LAST:event_newButtonActionPerformed

    private void helpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpButtonActionPerformed
        JOptionPane.showMessageDialog(controlPannel, "* Đếm số lần hiển thị của mỗi bức ảnh\n"
                + "* Bức ảnh cuối cùng được hiển thị\n"
                + "* Nhập số lần nó được hiển thị\n"
                + "* Bạn có thể nhấn Enter hoặc nhấp vào nút Nhập để gửi câu trả lời\n"
                + "* Bạn chỉ có thể trả lời một lần. Tuy nhiên, bạn có thể chơi lại\n"
                + "* Cấp độ đầu tiên được 10 điểm\n"
                + "* Cấp độ thứ hai được 15 điểm\n"
                + "* Cấp độ thứ ba được 20 điểm\n",
                "Thông báo",
                JOptionPane.INFORMATION_MESSAGE
        );
        controlPannel.grabFocus();//get focus back to control pannel
    }//GEN-LAST:event_helpButtonActionPerformed

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        if (lock == 0) {
            lock = 1;
            boolean validans = false;
            String digit = (ansTextField.getText());
            if (digit.compareTo("") == 0) {
                digit = " "; //to make string length at least one
            }
            if (digit.charAt(0) >= '0' && digit.charAt(0) <= '9' && digit.length() == 1) {
                validans = true;
                if (ans == Integer.parseInt(ansTextField.getText())) {
                    questionLabel.setText("Chính xác !!!");
                    ansTextField.setVisible(false);
                    submitButton.setVisible(false);
                    gameFinish();
                    ansTextField.setText("");
                    return;
                } else {
                    questionLabel.setText("Sai! Ấn nút Chơi lại");
                    ansTextField.setVisible(false);
                    submitButton.setVisible(false);

                }
            }
            if (validans == false) {
                questionLabel.setText("Không hợp lệ! Ấn nút Chơi lại");
                ansTextField.setVisible(false);
                submitButton.setVisible(false);
            }
            ansTextField.setText("");
        }
    }//GEN-LAST:event_submitButtonActionPerformed

    private void ansTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ansTextFieldKeyTyped
        if (evt.getKeyChar() == '\n') {
            submitButtonActionPerformed(new ActionEvent(stage, d, TOOL_TIP_TEXT_KEY));
        }
    }//GEN-LAST:event_ansTextFieldKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ansTextField;
    private javax.swing.JLabel background_Image;
    private javax.swing.JPanel controlPannel;
    private javax.swing.JLabel footerLabel;
    private javax.swing.JLabel heading;
    private javax.swing.JButton helpButton;
    private javax.swing.JLabel levelLabel;
    private javax.swing.JButton newButton;
    private javax.swing.JLabel questionLabel;
    private javax.swing.JLabel scoreLabel;
    private javax.swing.JButton submitButton;
    // End of variables declaration//GEN-END:variables
}
