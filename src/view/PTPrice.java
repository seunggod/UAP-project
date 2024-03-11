package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import model.FitnessDao;

import javax.swing.JRadioButton;
import java.awt.Font;

public class PTPrice extends JFrame 
implements MouseListener, ActionListener {
   JButton extension;
   JRadioButton w6, w15, w24, w36;
   ButtonGroup bg;
   private String id = "";
   FitnessDao fDao;
   JButton previewBtn;

   private int num = 10; // 횟수 저장해놓는 변수

   public static void main(String[] args) {
      new PTPrice("1");
   }
   public PTPrice(String id2) {

      this.id = id2;
      this.setTitle("남은 기간 연장");

      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setSize(400, 440);
      this.setLocationRelativeTo(null);
      getContentPane().setLayout(null);

      JLabel month_1 = new JLabel("PT 10회");
      month_1.setHorizontalAlignment(SwingConstants.CENTER);
      month_1.setFont(new Font("굴림", Font.BOLD, 16));
      month_1.setBounds(58, 39, 89, 30);
      getContentPane().add(month_1);

      JLabel month_3 = new JLabel("PT 30회");
      month_3.setFont(new Font("굴림", Font.BOLD, 16));
      month_3.setHorizontalAlignment(SwingConstants.CENTER);
      month_3.setBounds(58, 109, 89, 30);
      getContentPane().add(month_3);

      JLabel month_6 = new JLabel("PT 60회");
      month_6.setHorizontalAlignment(SwingConstants.CENTER);
      month_6.setFont(new Font("굴림", Font.BOLD, 16));
      month_6.setBounds(58, 179, 89, 30);
      getContentPane().add(month_6);

      JLabel month_12 = new JLabel("PT 120회");
      month_12.setFont(new Font("굴림", Font.BOLD, 16));
      month_12.setHorizontalAlignment(SwingConstants.CENTER);
      month_12.setBounds(58, 249, 89, 30);
      getContentPane().add(month_12);

      extension = new JButton("연장하기");
      extension.setFont(new Font("굴림", Font.PLAIN, 15));
      extension.setBounds(106, 310, 157, 50);
      getContentPane().add(extension);

      bg = new ButtonGroup();

      w6 = new JRadioButton("500,000원");
      w6.setFont(new Font("굴림", Font.BOLD, 14));
      w6.setBounds(204, 39, 121, 30);
      getContentPane().add(w6);

      w15 = new JRadioButton("1,000,000원");
      w15.setFont(new Font("굴림", Font.BOLD, 14));
      w15.setBounds(204, 109, 121, 30);
      getContentPane().add(w15);

      w24 = new JRadioButton("2,400,000원");
      w24.setFont(new Font("굴림", Font.BOLD, 14));
      w24.setBounds(204, 179, 121, 30);
      getContentPane().add(w24);

      w36 = new JRadioButton("3,600,000원");
      w36.setFont(new Font("굴림", Font.BOLD, 14));
      w36.setBounds(204, 249, 121, 30);
      getContentPane().add(w36);

      bg.add(w6);
      bg.add(w15);
      bg.add(w24);
      bg.add(w36);
      
      previewBtn = new JButton("<회원화면");
      previewBtn.setFont(new Font("굴림", Font.PLAIN, 13));
      previewBtn.setBounds(12, 10, 97, 23);
      getContentPane().add(previewBtn);

   
      w6.setSelected(true);
      
      this.w6.addMouseListener(this);
      this.w15.addMouseListener(this);
      this.w24.addMouseListener(this);
      this.w36.addMouseListener(this);
      this.extension.addActionListener(this);
      this.previewBtn.addActionListener(this);

      this.setVisible(true);

   }


   @Override
   public void mouseClicked(MouseEvent e) {
      // TODO Auto-generated method stub

      
   }


   @Override
   public void mousePressed(MouseEvent e) {
      // TODO Auto-generated method stub

      if (e.getSource() == w6) {
         System.out.println("PT 10회");
         num = 10;
      } else if (e.getSource() == w15) {
         System.out.println("PT 30회");
         num = 30;
      } else if (e.getSource() == w24) {
         System.out.println("PT 60회");
         num = 60;
      } else if (e.getSource() == w36) {
         System.out.println("PT 120회");
         num = 120;
      }
      
   }


   @Override
   public void mouseReleased(MouseEvent e) {
      // TODO Auto-generated method stub
      
   }


   @Override
   public void mouseEntered(MouseEvent e) {
      // TODO Auto-generated method stub
      
   }


   @Override
   public void mouseExited(MouseEvent e) {
      // TODO Auto-generated method stub
      
   }
   @Override
   public void actionPerformed(ActionEvent e) {
      // TODO Auto-generated method stub
	   if(e.getActionCommand().equals("<회원화면")) {
		   this.dispose();
		   new UserMenu(id);
	   }
      fDao = new FitnessDao();

      if (e.getActionCommand().equals("연장하기") && num == 0) {
         JOptionPane.showMessageDialog(null, "선택해주세요");
      } 
      else if (e.getActionCommand().equals("연장하기") && num != 0){
         fDao.addNum(id, num);
         dispose();
         new MyInfo(id);
      }
      
   }
}