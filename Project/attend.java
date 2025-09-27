package Project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ItemListener;
import java.awt.geom.RoundRectangle2D;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;

public class attend extends JFrame implements ItemListener{

	private JPanel main = new JPanel();
	private static String IDNumber;
	private int total = 0;
	private JCheckBox chckbxFacilitator = new JCheckBox("Facilitator");
	private JCheckBox chckbxParticipant = new JCheckBox("Participant");
	private JCheckBox chckbxSpeaker = new JCheckBox("Speaker");
	protected static String teacherUser = "d:\\Code\\Encapsulation\\src\\Project\\Teachers.txt";
/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					attend frame = new attend();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/

	public attend(String title, String IDNumber) {
		this.IDNumber = IDNumber;
		setUndecorated(true);
		getContentPane().setLayout(new BorderLayout(0, 10));
		setBounds(0,0,500,300);
		setVisible(true);
		setLocationRelativeTo(null);
		setShape(new RoundRectangle2D.Double(0, 0, 500, 300, 20, 20));
		setContentPane(main);
		main.setBackground( Color.decode("#193e83"));
		JPanel panel1 = new JPanel();
		panel1.setOpaque(false);
		JPanel panel2 = new JPanel();
		panel2.setOpaque(false);
		JPanel panel3 = new JPanel();
		panel3.setOpaque(false);
		JPanel panel4 = new JPanel();
		panel4.setOpaque(false);
		JPanel panel5 = new JPanel();
		panel5.setOpaque(false);
		JLabel exit = new JLabel("X");
		main.setLayout(new BorderLayout(0,0));
		panel1.setPreferredSize(new Dimension(10, 23));
		panel2.setPreferredSize(new Dimension(20, 10));
		panel3.setPreferredSize(new Dimension(20, 10));
		panel4.setPreferredSize(new Dimension(10, 20));
		panel5.setPreferredSize(new Dimension(10, 20));
		panel1.setLayout(new BorderLayout());
		exit.setPreferredSize(new Dimension(40, 23));
		exit.setForeground(Color.WHITE);
		exit.setOpaque(false);
		exit.setHorizontalAlignment(SwingConstants.CENTER);
		exit.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		exit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				exit.setBackground(Color.red);
				exit.setOpaque(true);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				exit.setBackground(null);
				exit.setOpaque(false);
			}
		});
		panel1.add(exit, BorderLayout.EAST);
		main.add(panel1, BorderLayout.NORTH);
		main.add(panel2, BorderLayout.WEST);
		main.add(panel3, BorderLayout.EAST);
		main.add(panel4, BorderLayout.SOUTH);
		main.add(panel5, BorderLayout.CENTER);
		panel5.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Attend Seminar as:");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(20, 22, 182, 24);
		panel5.add(lblNewLabel);
		
		chckbxParticipant.setFont(new Font("Arial", Font.PLAIN, 15));
		chckbxParticipant.setForeground(Color.WHITE);
		chckbxParticipant.setContentAreaFilled(false);
		chckbxParticipant.setBorder(null);
		chckbxParticipant.setBounds(159, 71, 182, 21);
		chckbxParticipant.addItemListener(this);
		panel5.add(chckbxParticipant);
		
		chckbxSpeaker.setForeground(Color.WHITE);
		chckbxSpeaker.setFont(new Font("Arial", Font.PLAIN, 15));
		chckbxSpeaker.setContentAreaFilled(false);
		chckbxSpeaker.setBorder(null);
		chckbxSpeaker.setBounds(159, 115, 182, 21);
		chckbxSpeaker.addItemListener(this);
		panel5.add(chckbxSpeaker);
		
		chckbxFacilitator.setForeground(Color.WHITE);
		chckbxFacilitator.setFont(new Font("Arial", Font.PLAIN, 15));
		chckbxFacilitator.setContentAreaFilled(false);
		chckbxFacilitator.setBorder(null);
		chckbxFacilitator.setBounds(159, 158, 182, 21);
		chckbxFacilitator.addItemListener(this);
		panel5.add(chckbxFacilitator);
		
		JPanel panel = new RoundedPanel(20, Color.decode("#6ab7e5"));
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Path path = Paths.get(teacherUser);
			        List<String> lines = Files.readAllLines(path);
			        StringBuilder fileContent = new StringBuilder();
			        
			        for (int i = 0; i < lines.size(); i++) {
			            String line = lines.get(i);
			            String[] parts = line.split(",");
			            
			            if (parts[0].trim().equals(IDNumber)) {
			                fileContent.append(line += ","  + title + "," + String.valueOf(total));
			                String[] newparts = fileContent.toString().split(",");
			                lines.set(i, String.join(",", newparts));
			                break;
			            }
			        }
			        Files.write(path, lines);
		        } catch (IOException exc) {
		            exc.printStackTrace();
		        }
				JOptionPane.showMessageDialog(null, "You have successfully registered for the seminar!");
				dispose();
			}
		});
		panel.setOpaque(false);
		panel.setBounds(120, 200, 200, 30);
		panel5.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("Attend");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 17));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_1, BorderLayout.CENTER);
	}
	
	public void itemStateChanged(ItemEvent e){
	      if(e.getSource()==chckbxParticipant){
	         if(e.getStateChange()== ItemEvent.SELECTED) {
	         	total += 5;
	         }else if(e.getStateChange() == ItemEvent.DESELECTED) {
	            total -= 5;
	         }
	      }
	      
	      else if(e.getSource()==chckbxSpeaker){
		         if(e.getStateChange()== ItemEvent.SELECTED) {
		         	total += 20;
		         }else if(e.getStateChange() == ItemEvent.DESELECTED) {
		            total -= 20;
		         }
		      }
	      
	      else if(e.getSource()==chckbxFacilitator){
		         if(e.getStateChange()== ItemEvent.SELECTED) {
		         	total += 10;
		         }else if(e.getStateChange() == ItemEvent.DESELECTED) {
		            total -= 10;
		         }
		      }
	}
}

