package Project;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.io.*;

public class TeacherDetailsFrame extends JFrame {
	
	protected static String teacherUser = "d:\\Code\\Encapsulation\\src\\Project\\Teachers.txt";
	protected static String seminarData = "d:\\Code\\Encapsulation\\src\\Project\\Seminars.txt";
	private JPanel contentPane;
	private int mouseX, mouseY;
	private TableCustom teacherdetailtable = new TableCustom();
	private DefaultTableModel SeminartblModel;
	private final JScrollPane scrollPane = new JScrollPane();
	Teacher teacher = new Teacher();
	private static String id;
	private String name;
	private String specialization;
	
	public TeacherDetailsFrame(String id, String name, String specialization) {
		this.id = id;
		this.name = name;
		this.specialization = specialization;
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
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel titleBar = new JPanel();
		titleBar.setOpaque(false);
		titleBar.setBorder(null);
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
		scrollPane.setBounds(0, 333, 760, 121);
		center.add(scrollPane);
		
		JLabel lblDetailName = new JLabel("Teacher's Details");
		lblDetailName.setForeground(Color.WHITE);
		lblDetailName.setFont(new Font("Arial Black", Font.PLAIN, 25));
		lblDetailName.setBounds(0, 10, 300, 20);
		center.add(lblDetailName);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("Arial", Font.BOLD, 18));
		lblName.setBounds(30, 60, 117, 20);
		center.add(lblName);
		
		JLabel lblIDNum = new JLabel("ID Number:");
		lblIDNum.setForeground(Color.WHITE);
		lblIDNum.setFont(new Font("Arial", Font.BOLD, 18));
		lblIDNum.setBounds(30, 95, 117, 20);
		center.add(lblIDNum);
		
		JLabel lblCollege = new JLabel("College:");
		lblCollege.setForeground(Color.WHITE);
		lblCollege.setFont(new Font("Arial", Font.BOLD, 18));
		lblCollege.setBounds(30, 130, 152, 20);
		center.add(lblCollege);
		
		JLabel lblSpec = new JLabel("Specialization:");
		lblSpec.setForeground(Color.WHITE);
		lblSpec.setFont(new Font("Arial", Font.BOLD, 18));
		lblSpec.setBounds(30, 165, 138, 20);
		center.add(lblSpec);
		
		JLabel lblGender = new JLabel("Gender:");
		lblGender.setForeground(Color.WHITE);
		lblGender.setFont(new Font("Arial", Font.BOLD, 18));
		lblGender.setBounds(30, 193, 193, 23);
		center.add(lblGender);
		
		JLabel lblSpeakerFN = new JLabel("Total no. of Seminars attended:");
		lblSpeakerFN.setForeground(Color.WHITE);
		lblSpeakerFN.setFont(new Font("Arial", Font.BOLD, 18));
		lblSpeakerFN.setBounds(80, 250, 284, 23);
		center.add(lblSpeakerFN);
		
		JLabel lblSpeakerLN = new JLabel("Total accumulated points:");
		lblSpeakerLN.setForeground(Color.WHITE);
		lblSpeakerLN.setFont(new Font("Arial", Font.BOLD, 18));
		lblSpeakerLN.setBounds(80, 280, 272, 23);
		center.add(lblSpeakerLN);
		
		JLabel lblSpeakerSpec = new JLabel("Seminars attended:");
		lblSpeakerSpec.setForeground(Color.WHITE);
		lblSpeakerSpec.setFont(new Font("Arial", Font.PLAIN, 17));
		lblSpeakerSpec.setBounds(0, 310, 232, 23);
		center.add(lblSpeakerSpec);
		
		JLabel Name = new JLabel("");
		Name.setBackground(Color.WHITE);
		Name.setForeground(Color.WHITE);
		Name.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 18));
		Name.setBounds(200, 60, 570, 20);
		center.add(Name);
		
		JLabel ID = new JLabel("");
		ID.setBackground(Color.WHITE);
		ID.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 18));
		ID.setForeground(Color.WHITE);
		ID.setBounds(200, 95, 570, 20);
		center.add(ID);
		
		JLabel College = new JLabel("");
		College.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 18));
		College.setForeground(Color.WHITE);
		College.setBounds(200, 130, 570, 20);
		center.add(College);
		
		JLabel Spec = new JLabel("");
		Spec.setForeground(Color.WHITE);
		Spec.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 18));
		Spec.setBounds(200, 163, 570, 20);
		center.add(Spec);
		
		JLabel NumSeminar = new JLabel("");
		NumSeminar.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 18));
		NumSeminar.setForeground(Color.WHITE);
		NumSeminar.setBounds(390, 250, 360, 20);
		center.add(NumSeminar);
		
		JLabel Points = new JLabel("");
		Points.setForeground(Color.WHITE);
		Points.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 18));
		Points.setBounds(390, 280, 360, 20);
		center.add(Points);
		
		SeminartblModel = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Date of Activity", "Title", "Specialization"
				}
			) {
				boolean[] canEdit = new boolean [] {
		                false, false, false
		            };

		            public boolean isCellEditable(int rowIndex, int columnIndex) {
		                return canEdit [columnIndex];
		            }
			};
			
		scrollPane.setPreferredSize(new Dimension(760, 100));
		teacherdetailtable.setShowHorizontalLines(false);
		teacherdetailtable.setShowGrid(false);
		teacherdetailtable.setPreferredScrollableViewportSize(new Dimension(800, 10000));
		teacherdetailtable.setFillsViewportHeight(true);
		scrollPane.setViewportView(teacherdetailtable);
		scrollPane.setOpaque(false);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBorder(null);
		teacherdetailtable.setModel(SeminartblModel);
		teacherdetailtable.fixTable(scrollPane);
		teacherdetailtable.getTableHeader().setReorderingAllowed(false);
		teacherdetailtable.setDragEnabled(false);
		
		JLabel lblBirthday = new JLabel("Birthday:");
		lblBirthday.setForeground(Color.WHITE);
		lblBirthday.setFont(new Font("Arial", Font.BOLD, 18));
		lblBirthday.setBounds(30, 220, 138, 20);
		center.add(lblBirthday);
		
		JLabel Bday = new JLabel("");
		Bday.setForeground(Color.WHITE);
		Bday.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 18));
		Bday.setBounds(200, 220, 570, 20);
		center.add(Bday);
		
		JLabel Gender = new JLabel("");
		Gender.setForeground(Color.WHITE);
		Gender.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 18));
		Gender.setBounds(200, 193, 570, 20);
		center.add(Gender);
		teacherdetailtable.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        if (e.getClickCount() == 1) {
		            int row = teacherdetailtable.getSelectedRow();
		            String date = teacherdetailtable.getValueAt(row, 0).toString();
		            String title = teacherdetailtable.getValueAt(row, 1).toString();
		            String specialization = teacherdetailtable.getValueAt(row, 2).toString();
		            
		            SeminarDetailsFrame secondFrame = new SeminarDetailsFrame(date, title, specialization);
	                secondFrame.setVisible(true);
		        }
		    }
		});
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(75, 10));
		panel.setOpaque(false);
		contentPane.add(panel, BorderLayout.WEST);
		loadSeminarsTableData(teacherUser, seminarData, SeminartblModel);
		
		for (int i = 0; i < teacherdetailtable.getColumnCount(); i++) {
		    TableColumn column = teacherdetailtable.getColumnModel().getColumn(i);
		    column.setResizable(false);
		}
		
		 try (BufferedReader reader = new BufferedReader(new FileReader(teacherUser))) {
	            String line;
	            while ((line = reader.readLine()) != null) {
	                String[] parts = line.split(",");
	                if (parts[0].equals(id) && (parts[2] + " " + parts[3]).equals(name) && parts[5].equals(specialization)) {
	                	College.setText(parts[4].trim());
	                	Name.setText(parts[2].trim() + " " + parts[3].trim());
	                	ID.setText(parts[0].trim());
	                	Spec.setText(parts[5].trim());
	                	Gender.setText(parts[6].trim());
	                	Bday.setText(parts[7].trim());
	                	NumSeminar.setText(String.valueOf(teacher.computeNoOfSeminars(teacherUser, id, name, specialization)));
	                	Points.setText(String.valueOf(teacher.computeTotalPoints(teacherUser, id, name, specialization)));
	                    break;
	                }
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	}

	private static void loadSeminarTableData(String filePath, DefaultTableModel model) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = reader.readLine()) != null) {
            	if (line.contains(id)) {
	                String[] values = line.split(","); 
	
	                String date = values[0].trim();
	                String title = values[1].trim();
	                String specialization = values[3].trim();
	
	                Object[] rowData = {date, title, specialization};
	
	                model.addRow(rowData);
            	}
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
	
	}
	
	private static void loadSeminarsTableData(String filePath1, String filePath2, DefaultTableModel model) {
        try {
            BufferedReader reader1 = new BufferedReader(new FileReader(filePath1));
            String line1, line2;
            while ((line1 = reader1.readLine()) != null) {
            	if (line1.contains(id)) {
            		String[] values = line1.split(","); 
            		
            		for(int i = 8; i < values.length; i += 2) {
            			BufferedReader reader2 = new BufferedReader(new FileReader(filePath2));
        	            while ((line2 = reader2.readLine()) != null) {
        	            	String[] value2 = line2.split(",");
        	            	
        	            	if(values[i].equalsIgnoreCase(value2[1].trim())) { 
        	            		String date = value2[0].trim();
        		                String title = value2[1].trim();
        		                String specialization = value2[3].trim();
        		
        		                Object[] rowData = {date, title, specialization};
        		
        		                model.addRow(rowData);
        	            	}
        	            }
        	            reader2.close();
                    }
            		break;
            	}
            }
            
            reader1.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
	
	}
}

