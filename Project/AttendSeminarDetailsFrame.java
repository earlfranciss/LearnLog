package Project;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;
import javax.swing.*;
import java.io.*;

public class AttendSeminarDetailsFrame extends JFrame {
	
	protected static String seminarData = "d:\\Code\\Encapsulation\\src\\Project\\Seminars.txt";
	private JPanel contentPane;
	private int mouseX, mouseY;
	private JLabel lblNewLabel = new JLabel("Attend Seminar");
	
	public AttendSeminarDetailsFrame(String date, String title, String specialization, String IDNumber) {
		setResizable(false);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 500);
		contentPane = new GradientPanel();
		contentPane.setFocusable(false);
		contentPane.setOpaque(false);
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		setShape(new RoundRectangle2D.Double(0, 0, 900, 500, 20, 20));
		contentPane.setBackground(Color.BLACK);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel titleBar = new JPanel();
		titleBar.setBorder(null);
		titleBar.setOpaque(false);
		titleBar.setBackground(new Color(0, 64, 128));
		titleBar.setPreferredSize(new Dimension(10, 23));
		contentPane.add(titleBar, BorderLayout.NORTH);
		titleBar.setLayout(null);
		
		JLabel lblExit = new JLabel("X");
		lblExit.setPreferredSize(new Dimension(6, 23));
		lblExit.setForeground(Color.WHITE);
		lblExit.setHorizontalAlignment(SwingConstants.CENTER);
		lblExit.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		lblExit.setBounds(865, 0, 35, 25);
		lblExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				repaint();
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblExit.setBackground(Color.red);
				lblExit.setOpaque(true);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblExit.setBackground(null);
				lblExit.setOpaque(false);
			}
		});
		titleBar.add(lblExit);
		
		titleBar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				setLocation(getX() + e.getX() - mouseX, getY() + e.getY() - mouseY);
			}
		});
		titleBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
			
			}
		});
		
		JPanel leftGap = new JPanel();
		leftGap.setOpaque(false);
		leftGap.setPreferredSize(new Dimension(75, 10));
		contentPane.add(leftGap, BorderLayout.WEST);
		
		JPanel btmGap = new JPanel();
		btmGap.setOpaque(false);
		btmGap.setPreferredSize(new Dimension(10, 20));
		contentPane.add(btmGap, BorderLayout.SOUTH);
		
		JPanel rightGap = new JPanel();
		rightGap.setOpaque(false);
		rightGap.setPreferredSize(new Dimension(65, 10));
		contentPane.add(rightGap, BorderLayout.EAST);
		
		JPanel center = new JPanel();
		center.setOpaque(false);
		contentPane.add(center, BorderLayout.CENTER);
		center.setLayout(null);
		
		JLabel lblDetailName = new JLabel("Seminar's Details");
		lblDetailName.setForeground(Color.WHITE);
		lblDetailName.setFont(new Font("Lucida Sans Unicode", Font.BOLD, 25));
		lblDetailName.setBounds(0, 45, 220, 20);
		center.add(lblDetailName);
		
		JLabel lblTitleName = new JLabel("Title:");
		lblTitleName.setForeground(Color.WHITE);
		lblTitleName.setFont(new Font("Lucida Sans Unicode", Font.BOLD, 18));
		lblTitleName.setBounds(30, 95, 117, 20);
		center.add(lblTitleName);
		
		JLabel lblTypeName = new JLabel("Type:");
		lblTypeName.setForeground(Color.WHITE);
		lblTypeName.setFont(new Font("Lucida Sans Unicode", Font.BOLD, 18));
		lblTypeName.setBounds(30, 130, 117, 20);
		center.add(lblTypeName);
		
		JLabel lblDateName = new JLabel("Date of Activity:");
		lblDateName.setForeground(Color.WHITE);
		lblDateName.setFont(new Font("Lucida Sans Unicode", Font.BOLD, 18));
		lblDateName.setBounds(30, 165, 152, 20);
		center.add(lblDateName);
		
		JLabel lblVenueName = new JLabel("Venue:");
		lblVenueName.setForeground(Color.WHITE);
		lblVenueName.setFont(new Font("Lucida Sans Unicode", Font.BOLD, 18));
		lblVenueName.setBounds(30, 200, 117, 20);
		center.add(lblVenueName);
		
		JLabel lblSpeakerDetails = new JLabel("Speaker's Details:");
		lblSpeakerDetails.setForeground(Color.WHITE);
		lblSpeakerDetails.setFont(new Font("Lucida Sans Unicode", Font.BOLD, 19));
		lblSpeakerDetails.setBounds(30, 250, 193, 23);
		center.add(lblSpeakerDetails);
		
		JLabel lblSpeakerFN = new JLabel("Speaker's First Name:");
		lblSpeakerFN.setForeground(Color.WHITE);
		lblSpeakerFN.setFont(new Font("Lucida Sans Unicode", Font.BOLD, 18));
		lblSpeakerFN.setBounds(80, 285, 220, 23);
		center.add(lblSpeakerFN);
		
		JLabel lblSpeakerLN = new JLabel("Speaker's Last Name:");
		lblSpeakerLN.setForeground(Color.WHITE);
		lblSpeakerLN.setFont(new Font("Lucida Sans Unicode", Font.BOLD, 18));
		lblSpeakerLN.setBounds(80, 320, 220, 23);
		center.add(lblSpeakerLN);
		
		JLabel lblSpeakerSpec = new JLabel("Speaker's Specialization:");
		lblSpeakerSpec.setForeground(Color.WHITE);
		lblSpeakerSpec.setFont(new Font("Lucida Sans Unicode", Font.BOLD, 18));
		lblSpeakerSpec.setBounds(80, 355, 232, 23);
		center.add(lblSpeakerSpec);
		
		JLabel Title = new JLabel("");
		Title.setBackground(Color.WHITE);
		Title.setForeground(Color.WHITE);
		Title.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 18));
		Title.setBounds(200, 95, 570, 20);
		center.add(Title);
		
		JLabel Type = new JLabel("");
		Type.setBackground(Color.WHITE);
		Type.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 18));
		Type.setForeground(Color.WHITE);
		Type.setBounds(200, 130, 570, 20);
		center.add(Type);
		
		JLabel Date = new JLabel("");
		Date.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 18));
		Date.setForeground(Color.WHITE);
		Date.setBounds(200, 165, 570, 20);
		center.add(Date);
		
		JLabel Venue = new JLabel("");
		Venue.setForeground(Color.WHITE);
		Venue.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 18));
		Venue.setBounds(200, 200, 570, 20);
		center.add(Venue);
		
		JLabel FirstName = new JLabel("");
		FirstName.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 18));
		FirstName.setForeground(Color.WHITE);
		FirstName.setBounds(330, 285, 440, 20);
		center.add(FirstName);
		
		JLabel LastName = new JLabel("");
		LastName.setForeground(Color.WHITE);
		LastName.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 18));
		LastName.setBounds(330, 320, 440, 20);
		center.add(LastName);
		
		JLabel Specialization = new JLabel("");
		Specialization.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 18));
		Specialization.setForeground(Color.WHITE);
		Specialization.setBounds(330, 355, 440, 20);
		center.add(Specialization);
		
		JPanel AttendSeminar = new RoundedPanel(20, Color.decode("#6ab7e5"));
		AttendSeminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				attend secondframe = new attend(title, IDNumber);
				secondframe.setVisible(true);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				AttendSeminar.setPreferredSize(new Dimension(302, 40));
				lblNewLabel.setForeground(Color.red);
				AttendSeminar.revalidate();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				AttendSeminar.setPreferredSize(new Dimension(300, 40));
				lblNewLabel.setForeground(Color.white);
				AttendSeminar.revalidate();
			}
		});
		AttendSeminar.setOpaque(false);
		AttendSeminar.setBounds(250, 400, 300, 40);
		center.add(AttendSeminar);
		AttendSeminar.setLayout(new BorderLayout(0, 0));
		
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel.setForeground(Color.WHITE);
		AttendSeminar.add(lblNewLabel, BorderLayout.CENTER);
		
		 try (BufferedReader reader = new BufferedReader(new FileReader(seminarData))) {
	            String line;
	            while ((line = reader.readLine()) != null) {
	                String[] parts = line.split(",");
	                if (parts.length == 8 && parts[0].equals(date) && parts[1].equals(title) && parts[3].equals(specialization)) {
	                	Date.setText(parts[0].trim());
	                	Title.setText(parts[1].trim());
	                	Type.setText(parts[3].trim());
	                	Venue.setText(parts[4].trim());
	                	FirstName.setText(parts[5].trim());
	                	LastName.setText(parts[6].trim());
	                	Specialization.setText(parts[7].trim());
	                    break;
	                }
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	}
}
