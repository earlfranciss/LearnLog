package Project;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.io.*;

public class SpeakerDetailsFrame extends JFrame {
	
	protected static String teacherUser = "d:\\Code\\Encapsulation\\src\\Project\\Teachers.txt";
	protected static String seminarData = "d:\\Code\\Encapsulation\\src\\Project\\Seminars.txt";
	private JPanel contentPane;
	private int mouseX, mouseY;
	private TableCustom seminardetailtable = new TableCustom();
	private DefaultTableModel SeminartblModel;
	private final JScrollPane scrollPane = new JScrollPane();
	private static String FN, LN, specialization;
	Teacher teacher = new Teacher();
	
	public SpeakerDetailsFrame(String FN, String LN, String specialization) {
		this.FN = FN;
		this.LN = LN;
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
		scrollPane.setBounds(0, 176, 760, 278);
		center.add(scrollPane);
		
		JLabel lblDetailName = new JLabel("Speaker's Details");
		lblDetailName.setForeground(Color.WHITE);
		lblDetailName.setFont(new Font("Arial Black", Font.PLAIN, 25));
		lblDetailName.setBounds(0, 10, 300, 30);
		center.add(lblDetailName);
		
		JLabel lblFName = new JLabel("First Name:");
		lblFName.setForeground(Color.WHITE);
		lblFName.setFont(new Font("Arial", Font.BOLD, 18));
		lblFName.setBounds(30, 60, 117, 20);
		center.add(lblFName);
		
		JLabel lblLName = new JLabel("Last Name:");
		lblLName.setForeground(Color.WHITE);
		lblLName.setFont(new Font("Arial", Font.BOLD, 18));
		lblLName.setBounds(30, 95, 117, 20);
		center.add(lblLName);
		
		JLabel lblSpec = new JLabel("Specialization:");
		lblSpec.setForeground(Color.WHITE);
		lblSpec.setFont(new Font("Arial", Font.BOLD, 18));
		lblSpec.setBounds(30, 127, 138, 20);
		center.add(lblSpec);
		
		JLabel tableLabel = new JLabel("Seminars hosted:");
		tableLabel.setForeground(Color.WHITE);
		tableLabel.setFont(new Font("Arial", Font.PLAIN, 17));
		tableLabel.setBounds(0, 155, 232, 23);
		center.add(tableLabel);
		
		JLabel FName = new JLabel("");
		FName.setBackground(Color.WHITE);
		FName.setForeground(Color.WHITE);
		FName.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 18));
		FName.setBounds(200, 60, 570, 20);
		center.add(FName);
		
		JLabel LName = new JLabel("");
		LName.setBackground(Color.WHITE);
		LName.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 18));
		LName.setForeground(Color.WHITE);
		LName.setBounds(200, 95, 570, 20);
		center.add(LName);
		
		JLabel Spec = new JLabel("");
		Spec.setForeground(Color.WHITE);
		Spec.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 18));
		Spec.setBounds(200, 127, 570, 20);
		center.add(Spec);
		
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
		seminardetailtable.setShowHorizontalLines(false);
		seminardetailtable.setShowGrid(false);
		seminardetailtable.setPreferredScrollableViewportSize(new Dimension(800, 400));
		seminardetailtable.setFillsViewportHeight(true);
		scrollPane.setViewportView(seminardetailtable);
		scrollPane.setOpaque(false);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBorder(null);
		seminardetailtable.setModel(SeminartblModel);
		seminardetailtable.fixTable(scrollPane);
		seminardetailtable.getTableHeader().setReorderingAllowed(false);
		seminardetailtable.setDragEnabled(false);
		seminardetailtable.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        if (e.getClickCount() == 1) {
		            int row = seminardetailtable.getSelectedRow();
		            String date = seminardetailtable.getValueAt(row, 0).toString();
		            String title = seminardetailtable.getValueAt(row, 1).toString();
		            String specialization = seminardetailtable.getValueAt(row, 2).toString();
		            
		            SeminarDetailsFrame secondFrame = new SeminarDetailsFrame(date, title, specialization);
	                secondFrame.setVisible(true);
		        }
		    }
		});
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(75, 10));
		panel.setOpaque(false);
		contentPane.add(panel, BorderLayout.WEST);
		loadSeminarTableData(seminarData, SeminartblModel);
		
		for (int i = 0; i < seminardetailtable.getColumnCount(); i++) {
		    TableColumn column = seminardetailtable.getColumnModel().getColumn(i);
		    column.setResizable(false);
		}
		
		 try (BufferedReader reader = new BufferedReader(new FileReader(seminarData))) {
	            String line;
	            while ((line = reader.readLine()) != null) {
	                String[] parts = line.split(",");
	                if (parts[5].equals(FN) && parts[6].equals(LN) && parts[7].equals(specialization)) {
	                	FName.setText(parts[5].trim());
	                	LName.setText(parts[6].trim());
	                	Spec.setText(parts[7].trim());
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
                String[] values = line.split(","); 
                if(FN.equals(values[5]) && LN.equals(values[6])) {
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
}

