package Project;

import java.awt.*;
import java.awt.geom.*;
import java.util.logging.*;
import javax.swing.*;
import java.awt.event.*;
import net.miginfocom.swing.MigLayout;
import javax.swing.table.*;
import com.toedter.calendar.JDateChooser;
import java.io.*;
import java.text.SimpleDateFormat;

import javax.swing.event.*;


public class UserMainFrame extends JFrame {

	Teacher teacher = new Teacher();
	Date date = new Date();
	Speaker speaker = new Speaker();
	protected static String adminUser = "d:\\Code\\Encapsulation\\src\\Project\\Admins.txt";
	protected static String seminarData = "d:\\Code\\Encapsulation\\src\\Project\\Seminars.txt";
	protected static String teacherUser = "d:\\Code\\Encapsulation\\src\\Project\\Teachers.txt";
	protected static String[] searchData = {teacherUser, seminarData};
	private JLayeredPane layeredPane = new jPanelGradient();
	private JPanel titleBar = new JPanel();
	private JPanel menuBar = new JPanel();
	private JPanel sidePanel = new JPanel();
	private final JPanel bottomPanel = new JPanel();
	private final JPanel mainPanel = new RoundedPanel(20, new Color(0, 31, 63, 150));//#7290a4
	private Image maxbtn = new ImageIcon(MainFrame.class.getResource("/Project/icons/maxBtn.png")).getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH);
	private Image minbtn = new ImageIcon(MainFrame.class.getResource("/Project/icons/minBtn.png")).getImage().getScaledInstance(23, 23, Image.SCALE_SMOOTH);
	private Image dashbtn = new ImageIcon(MainFrame.class.getResource("/Project/icons/dashLight.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
	private Image searchbtn = new ImageIcon(MainFrame.class.getResource("/Project/icons/searchLightSmall.png")).getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH);
	private Image publishbtn = new ImageIcon(MainFrame.class.getResource("/Project/icons/publishBtnLight.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
	private Image seminarbtn = new ImageIcon(MainFrame.class.getResource("/Project/icons/seminarLight.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
	private Image teacherbtn = new ImageIcon(MainFrame.class.getResource("/Project/icons/teacherLight.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
	private Image speakerbtn = new ImageIcon(MainFrame.class.getResource("/Project/icons/speakerLight.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
	private Image editbtn = new ImageIcon(MainFrame.class.getResource("/Project/icons/editLight.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
	private Image returnbtn = new ImageIcon(MainFrame.class.getResource("/Project/icons/returnBtnLight.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
	private Image menubtn = new ImageIcon(MainFrame.class.getResource("/Project/icons/menuBtnLight.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
	private Image logoutbtn = new ImageIcon(MainFrame.class.getResource("/Project/icons/logoutBtn.png")).getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
	private Image logouthover = new ImageIcon(MainFrame.class.getResource("/Project/icons/logoutHover.png")).getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
	private Image returnhover = new ImageIcon(MainFrame.class.getResource("/Project/icons/returnHover.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
	private Image menuhover = new ImageIcon(MainFrame.class.getResource("/Project/icons/menuhover.png")).getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
	private String[] field = {"Business and Accountancy", "Customs Administration", "Law and Criminal Justice", "Computer Studies", 
			"Hospitality and Tourism Management", "Marine Engineering", "Marine Transportation", "Nursing", "Engineering",  "Teacher Education"};
	private final JPanel ExitPanel = new JPanel();
	private final JLabel lblExitbtn_1 = new JLabel("X");
	private final JButton MinBtn = new JButton("");
	private final JButton MaxBtn = new JButton("");
	private final JPanel toolBarSidePanel = new JPanel();
	private final JPanel DashboardPanel = new JPanel();
	private final JPanel SearchPanel = new JPanel();
	private final JPanel SeminarPanel = new JPanel();
	private final JPanel InfoPanel = new JPanel();
	private final JPanel SpeakerPanel = new JPanel();
	private final JPanel LogoutPanel = new JPanel();
	private final JLabel lblDashboard = new JLabel("Dashboard");
	private final JLabel lblSearch = new JLabel("Search");
	private final JLabel lblSeminarlist = new JLabel("Seminars");
	private final JLabel lblPersonalInfo = new JLabel("Personal Info");
	private final JLabel lblSpeakers = new JLabel("Speakers");
	private final JLabel lblLogout = new JLabel("Logout");
	private final JPanel selectedDashboard = new JPanel();
	private final JPanel selectedSearch = new JPanel();
	private final JPanel selectedSeminar = new JPanel();
	private final JPanel selectedInfo = new JPanel();
	private final JPanel selectedSpeaker = new JPanel();
	private final JPanel panel_6 = new JPanel();
	private final JPanel DashboardMain = new JPanel();
	private final JPanel SearchMain = new JPanel();
	private final JPanel SeminarMain = new JPanel();
	private final JPanel TeacherMain = new JPanel();
	private final JPanel SpeakerMain = new JPanel();
	private final CardLayout crd = new CardLayout();
	private final JButton btnSpeaker = new JButton("");
	private final JButton btnInfo = new JButton("");
	private final JButton btnSeminar = new JButton("");
	private final JButton btnSearch = new JButton("");
	private final JButton btnDashboard = new JButton("");
	private int mouseX, mouseY;
	//private Color fieldColor = new Color(0, 31, 63, 50);//21,82,116,60
	private Color panelColor = new Color(0, 64, 128, 180);
	private Color btnColor = Color.decode("#6ab7e5");
	private Color btnColorBG = new Color(106, 183, 229, 100);//106, 183, 229
	private final JPanel field1 = new RoundedPanel(20, panelColor);
	private final JPanel searchbar = new RoundedPanel(35, panelColor);
	private JTextField txtSearch;
	private final JPanel panel_7 = new JPanel();
	private final JLabel lblField = new JLabel("College of Computer Studies");
	private final JPanel SearchBarTop = new JPanel();
	private final JPanel rSideSearch = new JPanel();
	private final JPanel lSideSearch = new JPanel();
	private final JPanel bottomSearch = new JPanel();
	private final JPanel searchCenter = new JPanel();
	private final TableCustom searchtable = new TableCustom();
	private final JPanel search = new RoundedPanel(35, panelColor);
	private final JTextField txtSearch_1 = new JTextField();
	private final JLabel lblNewLabel = new JLabel("");
	private final JPanel panel_8 = new JPanel();
	private final JPanel panel_9 = new RoundedPanel(35, btnColor);
	private final JLabel lblNewLabel_2 = new JLabel("Search");
	private final JPanel lSideSeminar = new JPanel();
	private final JPanel rSideSeminar = new JPanel();
	private final JPanel bottomSeminar = new JPanel();
	private final TableCustom seminartable = new TableCustom();
	private final TableCustom speakertable = new TableCustom();
	private final JScrollPane scrollPane = new JScrollPane();
	private final JScrollPane scrollPane1 = new JScrollPane();
	private final JScrollPane scrollPane2 = new JScrollPane();
	private final JScrollPane scrollPane3 = new JScrollPane();
	private DefaultTableModel SearchtblModel;
	private DefaultTableModel SeminartblModel;
	private DefaultTableModel TeachertblModel;
	private DefaultTableModel SpeakertblModel;
	private final JLabel lblSeminar = new JLabel("SEMINARS");
	private final JPanel searchSeminar = new RoundedPanel( 35, panelColor);
	private final JPanel filterSeminar = new RoundedPanel( 35, btnColor);
	private final JLabel SearchSeminarsIcon = new JLabel("");
	private final JTextField txtSearchSeminars = new JTextField();
	private final JPanel panel_12 = new JPanel();
	private final JLabel lblNewLabel_5 = new JLabel("Search");
	private final JLabel lblNewLabel_6 = new JLabel("Personal Information");
	private final JPanel searchSpeaker = new RoundedPanel(35, panelColor);
	private final JPanel filterSpeaker = new RoundedPanel( 35, btnColor);
	private final JLabel SpeakerIcon = new JLabel("");
	private final JPanel panel_13 = new JPanel();
	private final JTextField txtSearchSpeaker = new JTextField();
	private final JLabel lblNewLabel_7 = new JLabel("Search");
	private JPanel panel_14 = new JPanel();
	private final JPanel panel_16 = new JPanel();
	private final JPanel panel = new JPanel();
	private final JPanel panel_1 = new JPanel();
	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	protected final JLabel Name = new JLabel("");
	private final JLabel lblNewLabel_3 = new JLabel("Name");
	private final JLabel lblNewLabel_3_1 = new JLabel("ID Number:");
	private final JLabel lblNewLabel_3_2 = new JLabel("College:");
	private final JLabel lblNewLabel_3_3 = new JLabel("Specialization:");
	private final JLabel lblNewLabel_3_4 = new JLabel("Gender:");
	private final JLabel lblNewLabel_3_5 = new JLabel("Birthday:");
	private final JLabel lblNewLabel_3_6 = new JLabel("Total No. of Seminars attended:");
	private final JLabel lblNewLabel_3_7 = new JLabel("Total accumulated points:");
	protected final TableCustom teachertable = new TableCustom();
	protected final JLabel ID = new JLabel("");
	protected final JLabel College = new JLabel("");
	protected final JLabel Spec = new JLabel("");
	protected final JLabel Gender = new JLabel("");
	protected final JLabel Bday = new JLabel("");
	protected final JLabel SeminarsAttended = new JLabel("");
	protected final JLabel Points = new JLabel("");
	private static String IDNumber;
	private final JPanel panel_2 = new JPanel();
	private final JPanel panel_3 = new JPanel();
	private final JPanel panel_4 = new JPanel();
	private final JPanel panel_5 = new JPanel();
	private final JPanel Attend = new RoundedPanel( 20, btnColor);
	private final JLabel lblCollege = new JLabel("College:");
	private final JLabel CollegeDash = new JLabel("");
	private final JLabel lblSoec = new JLabel("Specification:");
	private final JLabel lblSeminars = new JLabel("Total no. of seminars attended:");
	private final JLabel lblPoints = new JLabel("Total accumulated points:");
	private final JLabel SpecDash = new JLabel("");
	protected final JLabel SeminarsDash = new JLabel("");
	protected final JLabel PointsDash = new JLabel("");
	private JLabel lblNewLabel_1 = new JLabel("Browse Seminar");
	private final RoundedPanel browseSpeaker = new RoundedPanel(20, new Color(106, 183, 229));
	private final JPanel panel_10 = new JPanel();
	private final JLabel lblNewLabel_4 = new JLabel("Browse Speakers");
	
	public static void main(String[] args) {
		try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
		/*
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserMainFrame frame = new UserMainFrame("ccsadmin");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});  */
	}


	@SuppressWarnings("serial")
	public UserMainFrame(String IDNumber) {
		this.IDNumber = IDNumber;
		mainPanel.setLayout(crd);
		txtSearchSpeaker.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 14));
		txtSearchSpeaker.setForeground(Color.WHITE);
		txtSearchSpeaker.setText("Search");
		txtSearchSpeaker.setBorder(null);
		txtSearchSpeaker.setOpaque(false);
		txtSearchSpeaker.setColumns(10);
		txtSearchSpeaker.setBackground(new Color(0,0,0,0));
		
		txtSearchSpeaker.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtSearchSpeaker.getText().equals("Search")) {
					txtSearchSpeaker.setText("");
				} else
					txtSearchSpeaker.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtSearchSpeaker.getText().equals("")) {
					txtSearchSpeaker.setText("Search");	
				}
			}
		});
		
		filterSpeaker.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				removeRowsFromTable(SpeakertblModel, txtSearchSpeaker.getText());
	            searchInTextFiles(txtSearchSpeaker.getText(), seminarData, SpeakertblModel);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_7.setForeground(Color.red);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_7.setForeground(Color.white);
			}
		});
		
		txtSearchSeminars.setText("Search");
		txtSearchSeminars.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 14));
		txtSearchSeminars.setForeground(Color.WHITE);
		txtSearchSeminars.setBackground(new Color(0,0,0,0));
		txtSearchSeminars.setBorder(null);
		txtSearchSeminars.setOpaque(false);
		
		txtSearchSeminars.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtSearchSeminars.getText().equals("Search")) {
					txtSearchSeminars.setText("");
				} else
					txtSearchSeminars.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtSearchSeminars.getText().equals("")) {
					txtSearchSeminars.setText("Search");	
				}
			}
		});
		
		filterSeminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				removeRowsFromTable(SeminartblModel,txtSearchSeminars.getText());
	            searchInTextFiles(txtSearchSeminars.getText(), searchData, SeminartblModel);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
	            lblNewLabel_5.setForeground(Color.red);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_5.setForeground(Color.white);
			}
		});
		txtSearch_1.setText("Search");
		txtSearch_1.setPreferredSize(new Dimension(300, 19));
		txtSearch_1.setOpaque(false);
		txtSearch_1.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 14));
		txtSearch_1.setForeground(Color.WHITE);
		txtSearch_1.setBackground(new Color(0,0,0,0));
		txtSearch_1.setBorder(null);
		txtSearch_1.setColumns(10);
		
		txtSearch_1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtSearch_1.getText().equals("Search")) {
					txtSearch_1.setText("");
				} else
					txtSearch_1.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtSearch_1.getText().equals("")) {
					txtSearch_1.setText("Search");	
				}
			}
		});
		
		panel_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				removeRowsFromTable(SearchtblModel,txtSearch_1.getText());
	            searchInTextFiles(txtSearch_1.getText(), searchData, SearchtblModel);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
	            lblNewLabel_2.setForeground(Color.red);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_2.setForeground(Color.white);
			}
		});
		
		
		setResizable(false);
		setUndecorated(true);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1200, 700);
		setShape(new RoundRectangle2D.Double(0, 0, 1200, 700, 15, 15));
		setContentPane(layeredPane);
		layeredPane.setLayout(new BorderLayout(0, 10));
		setLocationRelativeTo(null);
		
		
		layeredPane.setLayer(titleBar, 1);
		titleBar.setPreferredSize(new Dimension(10, 23));
		titleBar.setBackground(new Color(0, 32, 64));
		titleBar.setBounds(new Rectangle(0, 0, 100, 100));
		layeredPane.add(titleBar, BorderLayout.NORTH);
		titleBar.setLayout(new BorderLayout(0, 0));
		
		JLabel lblTitle = new JLabel("LearnLog");
		lblTitle.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				setLocation(getX() + e.getX() - mouseX, getY() + e.getY() - mouseY);
			}
		});
		lblTitle.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
			
			}
		});
		lblTitle.setForeground(Color.WHITE);
		lblTitle.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 13));
		titleBar.add(lblTitle, BorderLayout.CENTER);
		
		JPanel ToolBar = new JPanel();
		ToolBar.setOpaque(false);
		ToolBar.setPreferredSize(new Dimension(105, 10));
		ToolBar.setLayout(null);
		ToolBar.setBackground(new Color(4, 42, 69));
		titleBar.add(ToolBar, BorderLayout.EAST);
		ExitPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				ExitPanel.setBackground(Color.red);
				ExitPanel.setOpaque(true);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				ExitPanel.setBackground(null);
				ExitPanel.setOpaque(false);
			}
		});
		ExitPanel.setLayout(null);
		ExitPanel.setOpaque(false);
		ExitPanel.setBounds(70, -1, 40, 24);
		ToolBar.add(ExitPanel);
		
		lblExitbtn_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblExitbtn_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblExitbtn_1.setForeground(Color.WHITE);
		lblExitbtn_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		lblExitbtn_1.setBounds(0, 6, 30, 13);
		ExitPanel.add(lblExitbtn_1);
		
		MinBtn.setOpaque(false);
		MinBtn.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		MinBtn.setFocusPainted(false);
		MinBtn.setContentAreaFilled(false);
		MinBtn.setBorderPainted(false);
		MinBtn.setBorder(null);
		MinBtn.setAlignmentY(0.0f);
		MinBtn.setAlignmentX(0.5f);
		MinBtn.setBounds(0, 1, 35, 23);
		MinBtn.setIcon(new ImageIcon(minbtn));
		MinBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MinBtnActionPerformed(e);
			}
		});
		MinBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				MinBtn.setBackground(Color.red);
				MinBtn.setOpaque(true);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				MinBtn.setOpaque(false);
			}
		});
		ToolBar.add(MinBtn);

		MaxBtn.setOpaque(false);
		MaxBtn.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		MaxBtn.setFocusPainted(false);
		MaxBtn.setContentAreaFilled(false);
		MaxBtn.setBorderPainted(false);
		MaxBtn.setBorder(null);
		MaxBtn.setAlignmentY(0.0f);
		MaxBtn.setAlignmentX(0.5f);
		MaxBtn.setBounds(35, 1, 35, 23);
		MaxBtn.setIcon(new ImageIcon(maxbtn));
		MaxBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MaxBtnActionPerformed(e);
			}
		});
		MaxBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				MaxBtn.setBackground(Color.red);
				MaxBtn.setOpaque(true);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				MaxBtn.setOpaque(false);
			}
		});
		
		ToolBar.add(MaxBtn);
		toolBarSidePanel.setOpaque(false);
		
		titleBar.add(toolBarSidePanel, BorderLayout.WEST);
		
		layeredPane.setLayer(menuBar, 1);
		menuBar.setOpaque(false);
		menuBar.setBackground(Color.CYAN);
		menuBar.setPreferredSize(new Dimension(75, 10));
		layeredPane.add(menuBar, BorderLayout.WEST);
		
		JButton menuBtn = new JButton();
		menuBtn.setContentAreaFilled(false);
		menuBtn.setFocusPainted(false);
		menuBtn.setBorder(null);
		menuBtn.setBorderPainted(false);
		menuBtn.setOpaque(false);
		menuBtn.setIcon(new ImageIcon(menubtn));
		menuBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(menuBar.getWidth() == 75) {
				menuBar.setPreferredSize(new Dimension(200,10));
				layeredPane.revalidate();
				menuBtn.setIcon(new ImageIcon(returnbtn));
			} else {
				menuBar.setPreferredSize(new Dimension(75,10));
				layeredPane.revalidate();
				menuBtn.setIcon(new ImageIcon(menubtn));
			}
		}});
		menuBtn.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseEntered(MouseEvent e) {
				if(menuBar.getWidth() == 75) 
					menuBtn.setIcon(new ImageIcon(menuhover));
				else 
					menuBtn.setIcon(new ImageIcon(returnhover));
			}	
			@Override
			public void mouseExited(MouseEvent e) {
				if(menuBar.getWidth() == 75) 
					menuBtn.setIcon(new ImageIcon(menubtn));
				else 
					menuBtn.setIcon(new ImageIcon(returnbtn));
			}
		});
		menuBtn.setBounds(24, 10, 33, 26);
		panel_14.setPreferredSize(new Dimension(10, 325));
		panel_14.add(menuBtn);

		DashboardPanel.setOpaque(false);
		DashboardPanel.setBounds(0, 50, 215, 55);
		panel_14.add(DashboardPanel);
		DashboardPanel.setLayout(null);
		
		JLabel DashBtn = new JLabel();
		DashBtn.setVerifyInputWhenFocusTarget(false);
		DashBtn.setRequestFocusEnabled(false);
		DashBtn.setFocusTraversalKeysEnabled(false);
		DashBtn.setHorizontalAlignment(SwingConstants.CENTER);
		DashBtn.setFocusable(false);
		DashBtn.setIcon(new ImageIcon(dashbtn));
		DashBtn.setOpaque(false);
		DashBtn.setBorder(null);
		DashBtn.setBounds(24, 10, 33, 26);
		DashboardPanel.add(DashBtn);
		lblDashboard.setForeground(Color.WHITE);
		lblDashboard.setFont(new Font("Lucida Sans Unicode", Font.BOLD, 15));
		lblDashboard.setBounds(75, 10, 135, 26);
		DashboardPanel.add(lblDashboard);
		selectedDashboard.setOpaque(false);
		selectedDashboard.setBounds(0, 0, 5, 55);
		
		
		SearchtblModel = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"ID Number/Date of Activity", "Title/Name", "Specialization"
				}
			) {
				boolean[] canEdit = new boolean [] {
		                false, false, false
		            };

		            public boolean isCellEditable(int rowIndex, int columnIndex) {
		                return canEdit [columnIndex];
		            }
		};
		
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
			
		TeachertblModel = new DefaultTableModel(
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
		
		SpeakertblModel = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Last Name", "First Name", "Specialization"
				}
			) {
				boolean[] canEdit = new boolean [] {
		                false, false, false
		            };

		            public boolean isCellEditable(int rowIndex, int columnIndex) {
		                return canEdit [columnIndex];
		            }
		};
		
		
			
		crd.show(mainPanel, DashboardMain.getName());
		
		mainPanel.add(DashboardMain, "CCS Dashboard Panel");
		
		DashboardPanel.add(selectedDashboard);
		btnDashboard.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				DashboardPanel.setBackground(Color.decode("#44738f"));
				DashboardPanel.setOpaque(true);
				layeredPane.repaint();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				DashboardPanel.setOpaque(false);
				layeredPane.repaint();
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				btnDashboard.setBackground(btnColorBG);
				btnDashboard.setOpaque(true);
				btnSearch.setOpaque(false);
				btnSpeaker.setOpaque(false);
				btnSeminar.setOpaque(false);
				btnInfo.setOpaque(false);
				selectedDashboard.setBackground(btnColor);
				selectedDashboard.setOpaque(true);
				selectedSearch.setOpaque(false);
				selectedSpeaker.setOpaque(false);
				selectedSeminar.setOpaque(false);
				selectedInfo.setOpaque(false);
				layeredPane.repaint();
				teachertable.repaint();
				teachertable.validate();
				try (BufferedReader reader = new BufferedReader(new FileReader(teacherUser))) {
		            String line;
		            while ((line = reader.readLine()) != null) {
		                String[] parts = line.split(",");
		                if (parts[0].equals(IDNumber)) {
		                	College.setText(parts[4].trim());
		                	Name.setText(parts[2].trim() + " " + parts[3].trim());
		                	ID.setText(parts[0].trim());
		                	Spec.setText(parts[5].trim());
		                	Gender.setText(parts[6].trim());
		                	Bday.setText(parts[7].trim());
		                	SeminarsAttended.setText(String.valueOf(teacher.computeNoOfSeminars(teacherUser, ID.getText(), Name.getText(), Spec.getText())));
		                	Points.setText(String.valueOf(teacher.computeTotalPoints(teacherUser, ID.getText(), Name.getText(), Spec.getText())));
		                	lblField.setText("Hello, " + parts[2].trim());
		                	CollegeDash.setText(College.getText());
		                	SpecDash.setText(Spec.getText());
		                	SeminarsDash.setText(SeminarsAttended.getText());
		                	PointsDash.setText(Points.getText());
		                	break;
		                }
		            }
		        } catch (IOException exc) {
		            exc.printStackTrace();
		        }
			}
		});
		btnDashboard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crd.show(mainPanel, DashboardMain.getName());
			}
		});
		btnDashboard.setOpaque(false);
		btnDashboard.setFocusPainted(false);
		btnDashboard.setContentAreaFilled(false);
		btnDashboard.setBorderPainted(false);
		btnDashboard.setBorder(null);
		btnDashboard.setBounds(0, 0, 268, 55);
		
		DashboardPanel.add(btnDashboard);
		
		
		SearchPanel.setOpaque(false);
		SearchPanel.setBounds(0, 105, 218, 55);
		
		panel_14.add(SearchPanel);
		SearchPanel.setLayout(null);
		
		JLabel SearchBtn = new JLabel();
		SearchBtn.setHorizontalAlignment(SwingConstants.CENTER);
		SearchBtn.setIcon(new ImageIcon(searchbtn));
		SearchBtn.setOpaque(false);
		SearchBtn.setBorder(null);
		SearchBtn.setBounds(24, 10, 33, 26);
		SearchPanel.add(SearchBtn);
		lblSearch.setForeground(Color.WHITE);
		lblSearch.setFont(new Font("Lucida Sans Unicode", Font.BOLD, 15));
		lblSearch.setBounds(75, 10, 135, 26);
		
		SearchPanel.add(lblSearch);
		selectedSearch.setOpaque(false);
		selectedSearch.setBounds(0, 0, 5, 55);
		
		SearchPanel.add(selectedSearch);
		btnSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				SearchPanel.setBackground(Color.decode("#44738f"));
				SearchPanel.setOpaque(true);
				layeredPane.repaint();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				SearchPanel.setOpaque(false);
				layeredPane.repaint();
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				btnSearch.setBackground(btnColorBG);
				btnSearch.setOpaque(true);
				btnDashboard.setOpaque(false);
				btnSpeaker.setOpaque(false);
				btnSeminar.setOpaque(false);
				btnInfo.setOpaque(false);
				selectedSearch.setBackground(btnColor);
				selectedSearch.setOpaque(true);
				selectedDashboard.setOpaque(false);
				selectedSpeaker.setOpaque(false);
				selectedSeminar.setOpaque(false);
				selectedInfo.setOpaque(false);
				layeredPane.repaint();
	            searchtable.repaint();
	            searchtable.revalidate();
			}
		});
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crd.show(mainPanel, SearchMain.getName());
			}
		});
		loadTableData(searchData, SearchtblModel);
		btnSearch.setOpaque(false);
		btnSearch.setFocusPainted(false);
		btnSearch.setContentAreaFilled(false);
		btnSearch.setBorderPainted(false);
		btnSearch.setBorder(null);
		btnSearch.setBounds(0, 0, 268, 55);
		
		SearchPanel.add(btnSearch);
		SeminarPanel.setOpaque(false);
		SeminarPanel.setBounds(0, 160, 218, 55);
		
		panel_14.add(SeminarPanel);
		SeminarPanel.setLayout(null);
		
		JLabel SeminarBtn = new JLabel();
		SeminarBtn.setHorizontalAlignment(SwingConstants.CENTER);
		SeminarBtn.setIcon(new ImageIcon(seminarbtn));
		SeminarBtn.setOpaque(false);
		SeminarBtn.setBorder(null);
		SeminarBtn.setBounds(24, 10, 33, 26);
		SeminarPanel.add(SeminarBtn);
		lblSeminarlist.setForeground(Color.WHITE);
		lblSeminarlist.setFont(new Font("Lucida Sans Unicode", Font.BOLD, 15));
		lblSeminarlist.setBounds(75, 10, 135, 26);
		
		SeminarPanel.add(lblSeminarlist);
		selectedSeminar.setOpaque(false);
		selectedSeminar.setBounds(0, 0, 5, 55);
		
		SeminarPanel.add(selectedSeminar);
		btnSeminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				SeminarPanel.setBackground(Color.decode("#44738f"));
				SeminarPanel.setOpaque(true);
				layeredPane.repaint();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				SeminarPanel.setOpaque(false);
				layeredPane.repaint();
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				btnSeminar.setBackground(btnColorBG);
				btnSeminar.setOpaque(true);
				btnDashboard.setOpaque(false);
				btnSpeaker.setOpaque(false);
				btnSearch.setOpaque(false);
				btnInfo.setOpaque(false);
				selectedSeminar.setBackground(btnColor);
				selectedSpeaker.setOpaque(false);
				selectedDashboard.setOpaque(false);
				selectedSearch.setOpaque(false);
				selectedSeminar.setOpaque(true);
				selectedInfo.setOpaque(false);
				layeredPane.repaint();
			}
		});
		btnSeminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crd.show(mainPanel, SeminarMain.getName());
			}
		});
		loadSeminarTableData(seminarData, SeminartblModel);
		btnSeminar.setOpaque(false);
		btnSeminar.setFocusPainted(false);
		btnSeminar.setContentAreaFilled(false);
		btnSeminar.setBorderPainted(false);
		btnSeminar.setBorder(null);
		btnSeminar.setBounds(0, 0, 268, 55);
		
		SeminarPanel.add(btnSeminar);
		
		InfoPanel.setOpaque(false);
		InfoPanel.setBounds(0, 270, 218, 55);
		
		panel_14.add(InfoPanel);
		InfoPanel.setLayout(null);
		
		JLabel TeacherBtn = new JLabel();
		
		TeacherBtn.setHorizontalAlignment(SwingConstants.CENTER);
		TeacherBtn.setIcon(new ImageIcon(teacherbtn));
		TeacherBtn.setOpaque(false);
		TeacherBtn.setBorder(null);
		TeacherBtn.setBounds(24, 10, 33, 26);
		InfoPanel.add(TeacherBtn);
		lblPersonalInfo.setForeground(Color.WHITE);
		lblPersonalInfo.setFont(new Font("Lucida Sans Unicode", Font.BOLD, 15));
		lblPersonalInfo.setBounds(75, 10, 135, 26);
		
		InfoPanel.add(lblPersonalInfo);
		selectedInfo.setOpaque(false);
		selectedInfo.setBounds(0, 0, 5, 55);
		
		InfoPanel.add(selectedInfo);
		btnInfo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				InfoPanel.setBackground(Color.decode("#44738f"));
				InfoPanel.setOpaque(true);
				layeredPane.repaint();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				InfoPanel.setOpaque(false);
				layeredPane.repaint();
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				btnInfo.setBackground(btnColorBG);
				btnInfo.setOpaque(true);
				btnDashboard.setOpaque(false);
				btnSearch.setOpaque(false);
				btnSeminar.setOpaque(false);
				btnSpeaker.setOpaque(false);
				selectedInfo.setBackground(btnColor);
				selectedSpeaker.setOpaque(false);
				selectedDashboard.setOpaque(false);
				selectedSearch.setOpaque(false);
				selectedSeminar.setOpaque(false);
				selectedInfo.setOpaque(true);
				layeredPane.repaint();
				updateRowsFromTable(TeachertblModel);
				loadSeminarsTableData(teacherUser, seminarData, TeachertblModel);
				try (BufferedReader reader = new BufferedReader(new FileReader(teacherUser))) {
		            String line;
		            while ((line = reader.readLine()) != null) {
		                String[] parts = line.split(",");
		                if (parts[0].equals(IDNumber)) {
		                	College.setText(parts[4].trim());
		                	Name.setText(parts[2].trim() + " " + parts[3].trim());
		                	ID.setText(parts[0].trim());
		                	Spec.setText(parts[5].trim());
		                	Gender.setText(parts[6].trim());
		                	Bday.setText(parts[7].trim());
		                	SeminarsAttended.setText(String.valueOf(teacher.computeNoOfSeminars(teacherUser, ID.getText(), Name.getText(), Spec.getText())));
		                	Points.setText(String.valueOf(teacher.computeTotalPoints(teacherUser, ID.getText(), Name.getText(), Spec.getText())));
		                	lblField.setText("Hello, " + parts[2].trim());
		                	CollegeDash.setText(College.getText());
		                	SpecDash.setText(Spec.getText());
		                	SeminarsDash.setText(SeminarsAttended.getText());
		                	PointsDash.setText(Points.getText());
		                	break;
		                }
		            }
		        } catch (IOException exc) {
		            exc.printStackTrace();
		        }
			}
		});
		btnInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crd.show(mainPanel, TeacherMain.getName());
			}
		});
		//loadTableData(teacherUser, TeachertblModel);
		btnInfo.setOpaque(false);
		btnInfo.setFocusPainted(false);
		btnInfo.setContentAreaFilled(false);
		btnInfo.setBorderPainted(false);
		btnInfo.setBorder(null);
		btnInfo.setBounds(0, 0, 268, 55);
		
		InfoPanel.add(btnInfo);
		
		SpeakerPanel.setOpaque(false);
		SpeakerPanel.setBounds(0, 215, 218, 55);
		
		panel_14.add(SpeakerPanel);
		SpeakerPanel.setLayout(null);
		
		JLabel SpeakerBtn = new JLabel();

		SpeakerBtn.setHorizontalAlignment(SwingConstants.CENTER);
		SpeakerBtn.setIcon(new ImageIcon(speakerbtn));
		SpeakerBtn.setOpaque(false);
		SpeakerBtn.setBorder(null);
		SpeakerBtn.setBounds(24, 10, 33, 26);
		SpeakerPanel.add(SpeakerBtn);
		lblSpeakers.setForeground(Color.WHITE);
		lblSpeakers.setFont(new Font("Lucida Sans Unicode", Font.BOLD, 15));
		lblSpeakers.setBounds(75, 12, 135, 26);
		
		SpeakerPanel.add(lblSpeakers);
		selectedSpeaker.setOpaque(false);
		selectedSpeaker.setBounds(0, 0, 5, 55);
		
		SpeakerPanel.add(selectedSpeaker);
		btnSpeaker.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				SpeakerPanel.setBackground(Color.decode("#44738f"));
				SpeakerPanel.setOpaque(true);
				layeredPane.repaint();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				SpeakerPanel.setOpaque(false);
				layeredPane.repaint();
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				btnSpeaker.setBackground(btnColorBG);
				btnSpeaker.setOpaque(true);
				btnDashboard.setOpaque(false);
				btnSearch.setOpaque(false);
				btnSeminar.setOpaque(false);
				btnInfo.setOpaque(false);
				selectedSpeaker.setBackground(btnColor);
				selectedSpeaker.setOpaque(true);
				selectedDashboard.setOpaque(false);
				selectedSearch.setOpaque(false);
				selectedSeminar.setOpaque(false);
				selectedInfo.setOpaque(false);
				layeredPane.repaint();
			}
		});
		btnSpeaker.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crd.show(mainPanel, SpeakerMain.getName());
			}
		});
		loadSpeakerTableData(seminarData, SpeakertblModel);
		btnSpeaker.setOpaque(false);
		btnSpeaker.setFocusPainted(false);
		btnSpeaker.setContentAreaFilled(false);
		btnSpeaker.setBorderPainted(false);
		btnSpeaker.setBorder(null);
		btnSpeaker.setBounds(0, 0, 268, 55);
		
		SpeakerPanel.add(btnSpeaker);
		LogoutPanel.setOpaque(false);
		LogoutPanel.setBounds(0, 0, 290, 55);
		
		LogoutPanel.setLayout(null);
		
		JLabel LogoutBtn = new JLabel();
		LogoutBtn.setHorizontalAlignment(SwingConstants.CENTER);
		LogoutBtn.setIcon(new ImageIcon(logoutbtn));
		LogoutBtn.setOpaque(false);
		LogoutBtn.setBorder(null);
		LogoutBtn.setBounds(24, 10, 33, 26);
		LogoutPanel.add(LogoutBtn);
		lblLogout.setForeground(Color.WHITE);
		lblLogout.setFont(new Font("Lucida Sans Unicode", Font.BOLD, 15));
		lblLogout.setBounds(75, 10, 135, 26);
		LogoutPanel.add(lblLogout);
		panel_6.setOpaque(false);
		panel_6.setBounds(0, 0, 5, 55);
		
		LogoutPanel.add(panel_6);
		
		JButton btnLogout = new JButton("");
		btnLogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				LogoutPanel.setBackground(Color.decode("#578bac"));
				LogoutPanel.setOpaque(true);
				layeredPane.repaint();
				LogoutBtn.setIcon(new ImageIcon(logouthover));
				lblLogout.setForeground(Color.red);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				LogoutPanel.setOpaque(false);
				lblLogout.setForeground(Color.WHITE);
				LogoutBtn.setIcon(new ImageIcon(logoutbtn));
			}
		});
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginFrame lf = new LoginFrame();
				lf.show();
				dispose();
			}
		});
		menuBar.setLayout(new BorderLayout(0, 0));
		btnLogout.setOpaque(false);
		btnLogout.setContentAreaFilled(false);
		btnLogout.setFocusPainted(false);
		btnLogout.setBorder(null);
		btnLogout.setBorderPainted(false);
		btnLogout.setBounds(0, 0, 268, 55);
		LogoutPanel.add(btnLogout);
		panel_16.setPreferredSize(new Dimension(10, 65));
		panel_16.setOpaque(false);
		
		menuBar.add(panel_16, BorderLayout.SOUTH);
		panel_16.setLayout(null);
		panel_16.add(LogoutPanel);
		panel_14.setOpaque(false);
		menuBar.add(panel_14, BorderLayout.NORTH);
		panel_14.setLayout(null);
		
		sidePanel.setOpaque(false);
		layeredPane.setLayer(sidePanel, 1);
		layeredPane.add(sidePanel, BorderLayout.LINE_END);
		bottomPanel.setPreferredSize(new Dimension(10, 3));
		bottomPanel.setOpaque(false);
		
		layeredPane.add(bottomPanel, BorderLayout.SOUTH);
		

		mainPanel.setOpaque(false);
		layeredPane.add(mainPanel, BorderLayout.CENTER);
		

		
		DashboardMain.setName("CCS Dashboard Panel");
		DashboardMain.setOpaque(false);
		DashboardMain.setBorder(null);
		DashboardMain.setFocusable(false);
		DashboardMain.setRequestFocusEnabled(false);
		
		
		DashboardMain.setLayout(new MigLayout("fill, inset 20 70 20 50", "[grow]30[grow]30[grow]", "[grow 40][grow 60]20[grow][grow][grow]"));
		DashboardMain.add(field1, "cell 0 2 3 3,grow");
		DashboardMain.add(searchbar, "cell 2 0,grow");
		DashboardMain.add(panel_7, "cell 0 1 2 1,grow");
		
		
		searchbar.setOpaque(false);
		
		searchbar.setLayout(null);
		
		JLabel searchBtn = new JLabel("");
		searchBtn.setBounds(10, 9, 25, 20);
		searchBtn.setIcon(new ImageIcon(searchbtn));
		searchbar.add(searchBtn);
		
		txtSearch = new JTextField();
		txtSearch.setBorder(null);
		txtSearch.setText("Search");
		txtSearch.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
		txtSearch.setForeground(Color.WHITE);
		txtSearch.setBounds(42, 9, 278, 19);
		txtSearch.setBackground(new Color(0, 31, 64, 0));
		searchbar.add(txtSearch);
		txtSearch.setColumns(10);
		txtSearch.setOpaque(false);
		
		txtSearch.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtSearch.getText().equals("Search")) {
					txtSearch.setText("");
				} else
					txtSearch.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtSearch.getText().equals("")) {
					txtSearch.setText("Search");	
				}
			}
		});
		
		txtSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
	            crd.show(mainPanel, SearchMain.getName());
	            removeRowsFromTable(SearchtblModel, txtSearch.getText());
	            searchInTextFiles(txtSearch.getText(), searchData, SearchtblModel);
	            txtSearch_1.setText(txtSearch.getText());
	            btnSearch.setBackground(btnColorBG);
				btnSearch.setOpaque(true);
				btnDashboard.setOpaque(false);
				btnSpeaker.setOpaque(false);
				btnSeminar.setOpaque(false);
				btnInfo.setOpaque(false);
				selectedSearch.setBackground(btnColor);
				selectedSearch.setOpaque(true);
				selectedDashboard.setOpaque(false);
				selectedSpeaker.setOpaque(false);
				selectedSeminar.setOpaque(false);
				selectedInfo.setOpaque(false);
				layeredPane.repaint();
	            searchtable.repaint();
	            searchtable.revalidate();
			}
		});
		 
		panel_7.setOpaque(false);
		panel_7.setLayout(null);
		lblField.setForeground(Color.WHITE);
		lblField.setFont(new Font("Arial Black", Font.PLAIN, 35));
		lblField.setBounds(26, 0, 617, 46);
		
		panel_7.add(lblField);
		
		
		
		field1.setOpaque(false);
		
		field1.setLayout(new BorderLayout(0, 0));
		panel.setPreferredSize(new Dimension(30, 10));
		panel.setOpaque(false);
		
		field1.add(panel, BorderLayout.WEST);
		panel_1.setPreferredSize(new Dimension(10, 20));
		panel_1.setOpaque(false);
		
		field1.add(panel_1, BorderLayout.SOUTH);
		panel_2.setOpaque(false);
		panel_2.setPreferredSize(new Dimension(10, 20));
		
		field1.add(panel_2, BorderLayout.NORTH);
		panel_3.setPreferredSize(new Dimension(30, 10));
		panel_3.setOpaque(false);
		
		field1.add(panel_3, BorderLayout.EAST);
		panel_4.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 17));
		panel_4.setForeground(Color.WHITE);
		panel_4.setOpaque(false);
		
		field1.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new MigLayout("fill, inset 30 50 10 50", "[grow]25[grow]", "[grow 20][grow 20][grow 20][grow 20]60[grow 30]"));
		lblCollege.setFont(new Font("Arial", Font.BOLD, 16));
		lblCollege.setForeground(Color.WHITE);
		
		panel_4.add(lblCollege, "cell 0 0,alignx center");
		CollegeDash.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 19));
		CollegeDash.setForeground(Color.WHITE);
		
		panel_4.add(CollegeDash, "cell 1 0");
		lblSoec.setForeground(Color.WHITE);
		lblSoec.setFont(new Font("Arial", Font.BOLD, 16));
		
		panel_4.add(lblSoec, "cell 0 1,alignx center");
		SpecDash.setForeground(Color.WHITE);
		SpecDash.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 19));
		
		panel_4.add(SpecDash, "cell 1 1");
		lblSeminars.setPreferredSize(new Dimension(0, 13));
		lblSeminars.setForeground(Color.WHITE);
		lblSeminars.setFont(new Font("Arial", Font.BOLD, 16));
		
		panel_4.add(lblSeminars, "cell 0 2,alignx center");
		SeminarsDash.setForeground(Color.WHITE);
		SeminarsDash.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 19));
		
		panel_4.add(SeminarsDash, "cell 1 2");
		lblPoints.setHorizontalAlignment(SwingConstants.TRAILING);
		lblPoints.setForeground(Color.WHITE);
		lblPoints.setFont(new Font("Arial", Font.BOLD, 16));
		
		panel_4.add(lblPoints, "cell 0 3,alignx center");
		PointsDash.setForeground(Color.WHITE);
		PointsDash.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 19));
		
		panel_4.add(PointsDash, "cell 1 3");
		panel_5.setOpaque(false);
		
		panel_4.add(panel_5, "cell 0 4 2 1,grow");
		Attend.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				crd.show(mainPanel, SeminarMain.getName());
				btnSeminar.setBackground(btnColorBG);
				btnSeminar.setOpaque(true);
				btnDashboard.setOpaque(false);
				btnSpeaker.setOpaque(false);
				btnSearch.setOpaque(false);
				btnInfo.setOpaque(false);
				selectedSeminar.setBackground(btnColor);
				selectedSpeaker.setOpaque(false);
				selectedDashboard.setOpaque(false);
				selectedSearch.setOpaque(false);
				selectedSeminar.setOpaque(true);
				selectedInfo.setOpaque(false);
				layeredPane.repaint();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				Attend.setPreferredSize(new Dimension(302,40));
				lblNewLabel_1.setForeground(Color.red);
				Attend.revalidate();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Attend.setPreferredSize(new Dimension(300,40));
				lblNewLabel_1.setForeground(Color.white);
				Attend.revalidate();
			}
		});
		Attend.setOpaque(false);
		Attend.setPreferredSize(new Dimension(300, 40));
		
		panel_5.add(Attend);
		Attend.setLayout(new BorderLayout(0, 0));
		
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		Attend.add(lblNewLabel_1, BorderLayout.CENTER);
		panel_10.setOpaque(false);
		
		panel_5.add(panel_10);
		browseSpeaker.setPreferredSize(new Dimension(300, 40));
		browseSpeaker.setOpaque(false);
		
		panel_5.add(browseSpeaker);
		browseSpeaker.setLayout(new BorderLayout(0, 0));
		browseSpeaker.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				crd.show(mainPanel, SpeakerMain.getName());
				btnSpeaker.setBackground(btnColorBG);
				btnSpeaker.setOpaque(true);
				btnDashboard.setOpaque(false);
				btnSearch.setOpaque(false);
				btnSeminar.setOpaque(false);
				btnInfo.setOpaque(false);
				selectedSpeaker.setBackground(btnColor);
				selectedSpeaker.setOpaque(true);
				selectedDashboard.setOpaque(false);
				selectedSearch.setOpaque(false);
				selectedSeminar.setOpaque(false);
				selectedInfo.setOpaque(false);
				layeredPane.repaint();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				browseSpeaker.setPreferredSize(new Dimension(302,40));
				lblNewLabel_4.setForeground(Color.red);
				browseSpeaker.revalidate();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				browseSpeaker.setPreferredSize(new Dimension(300,40));
				lblNewLabel_4.setForeground(Color.white);
				browseSpeaker.revalidate();
			}
		});
		lblNewLabel_4.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_4.setForeground(Color.WHITE);
		
		browseSpeaker.add(lblNewLabel_4, BorderLayout.CENTER);

		

		SearchMain.setOpaque(false);
		SearchMain.setName("Search Panel");
		
		mainPanel.add(SearchMain, "Search Panel");
		SearchMain.setLayout(new BorderLayout(0, 0));
		SearchBarTop.setOpaque(false);
		SearchBarTop.setPreferredSize(new Dimension(10, 120));
		
		SearchMain.add(SearchBarTop, BorderLayout.NORTH);
		SearchBarTop.setLayout(new MigLayout("fill, inset 50 225 20 225", "[grow][][grow 30]", "[grow]20[grow]"));
		search.setOpaque(false);
		SearchBarTop.add(search, "cell 0 0, grow");
		search.setLayout(new BorderLayout(0, 0));
		
		search.add(txtSearch_1, BorderLayout.CENTER);
		lblNewLabel.setPreferredSize(new Dimension(30, 0));
		lblNewLabel.setIcon(new ImageIcon(MainFrame.class.getResource("/Project/icons/searchLightSmall.png")));
		
		search.add(lblNewLabel, BorderLayout.EAST);
		panel_8.setPreferredSize(new Dimension(15, 10));
		panel_8.setOpaque(false);
		
		search.add(panel_8, BorderLayout.WEST);
		panel_9.setOpaque(false);
		
		SearchBarTop.add(panel_9, "cell 2 0,grow");
		panel_9.setLayout(new BorderLayout(0, 0));
		lblNewLabel_2.setFont(new Font("Lucida Sans Unicode", Font.BOLD, 14));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		
		panel_9.add(lblNewLabel_2, BorderLayout.CENTER);
		rSideSearch.setOpaque(false);
		rSideSearch.setPreferredSize(new Dimension(25, 10));
		
		SearchMain.add(rSideSearch, BorderLayout.WEST);
		lSideSearch.setOpaque(false);
		lSideSearch.setPreferredSize(new Dimension(25, 10));
		
		SearchMain.add(lSideSearch, BorderLayout.EAST);
		bottomSearch.setOpaque(false);
		bottomSearch.setPreferredSize(new Dimension(10, 25));
		
		SearchMain.add(bottomSearch, BorderLayout.SOUTH);
		searchCenter.setOpaque(false);
		
		SearchMain.add(searchCenter, BorderLayout.CENTER);
		searchCenter.setLayout(new MigLayout("fill, insets 20 100 20 100", "[grow]", "[grow]"));
		scrollPane.setOpaque(false);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBorder(null);
		scrollPane.setPreferredSize(new Dimension(800, 460));
		scrollPane1.setOpaque(false);
		scrollPane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane1.setBorder(null);
		scrollPane1.setPreferredSize(new Dimension(800, 460));
		scrollPane2.setOpaque(false);
		scrollPane2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane2.setBorder(null);
		scrollPane2.setPreferredSize(new Dimension(800, 200));
		scrollPane3.setOpaque(false);
		scrollPane3.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane3.setBorder(null);
		scrollPane3.setPreferredSize(new Dimension(800, 460));
		
		searchCenter.add(scrollPane, "cell 0 0,grow");
		searchtable.setPreferredScrollableViewportSize(new Dimension(450, 10000));
		scrollPane.setViewportView(searchtable);
		searchtable.setShowHorizontalLines(false);
		searchtable.setShowGrid(false);
		searchtable.setBorder(null);
		searchtable.setFont(new Font("Arial", Font.BOLD, 12));
		searchtable.setForeground(new Color(0, 0, 0));
		searchtable.getTableHeader().setReorderingAllowed(false);
		seminartable.getTableHeader().setReorderingAllowed(false);
		speakertable.getTableHeader().setReorderingAllowed(false);
		searchtable.setModel(SearchtblModel);
		searchtable.getColumnModel().getColumn(0).setPreferredWidth(15);
		searchtable.getColumnModel().getColumn(0).setMinWidth(9);
		searchtable.getColumnModel().getColumn(2).setPreferredWidth(15);
		for (int i = 0; i < searchtable.getColumnCount(); i++) {
		    TableColumn column = searchtable.getColumnModel().getColumn(i);
		    column.setResizable(false);
		}
		for (int i = 0; i < seminartable.getColumnCount(); i++) {
		    TableColumn column = seminartable.getColumnModel().getColumn(i);
		    column.setResizable(false);
		}
		for (int i = 0; i < teachertable.getColumnCount(); i++) {
		    TableColumn column = teachertable.getColumnModel().getColumn(i);
		    column.setResizable(false);
		}
		for (int i = 0; i < speakertable.getColumnCount(); i++) {
		    TableColumn column = speakertable.getColumnModel().getColumn(i);
		    column.setResizable(false);
		}
		searchtable.setDragEnabled(false);
		
		SeminarMain.setName("Seminar Panel");
		SeminarMain.setOpaque(false);
		
		mainPanel.add(SeminarMain, "Seminar Panel");
		SeminarMain.setLayout(new BorderLayout(0, 0));
		lSideSeminar.setOpaque(false);
		lSideSeminar.setPreferredSize(new Dimension(25, 10));
		
		SeminarMain.add(lSideSeminar, BorderLayout.WEST);
		rSideSeminar.setPreferredSize(new Dimension(25, 10));
		rSideSeminar.setOpaque(false);
		
		SeminarMain.add(rSideSeminar, BorderLayout.EAST);
		bottomSeminar.setPreferredSize(new Dimension(10, 25));
		bottomSeminar.setOpaque(false);
		
		SeminarMain.add(bottomSeminar, BorderLayout.SOUTH);
		
		JPanel topSeminar =  new JPanel();
		topSeminar.setPreferredSize(new Dimension(10, 100));
		topSeminar.setOpaque(false);
		SeminarMain.add(topSeminar, BorderLayout.NORTH);
		topSeminar.setLayout(new MigLayout("fill, insets 50 150 50 150", "[grow 50]250[grow 250]10[grow]", "[grow]"));
		lblSeminar.setPreferredSize(new Dimension(60, 13));
		lblSeminar.setFont(new Font("Lucida Sans Unicode", Font.BOLD, 20));
		lblSeminar.setForeground(Color.WHITE);
		
		topSeminar.add(lblSeminar, "cell 0 0");
		searchSeminar.setOpaque(false);
		
		topSeminar.add(searchSeminar, "cell 1 0,grow");
		searchSeminar.setLayout(new BorderLayout(0, 0));
		SearchSeminarsIcon.setPreferredSize(new Dimension(30, 0));
		SearchSeminarsIcon.setIcon(new ImageIcon(MainFrame.class.getResource("/Project/icons/searchLightSmall.png")));
		
		searchSeminar.add(SearchSeminarsIcon, BorderLayout.EAST);
		
		searchSeminar.add(txtSearchSeminars, BorderLayout.CENTER);
		panel_12.setOpaque(false);
		panel_12.setMinimumSize(new Dimension(15, 10));
		
		searchSeminar.add(panel_12, BorderLayout.WEST);
		filterSeminar.setOpaque(false);
		
		topSeminar.add(filterSeminar, "cell 2 0,grow");
		filterSeminar.setLayout(new BorderLayout(0, 0));
		lblNewLabel_5.setPreferredSize(new Dimension(40, 13));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 14));
		lblNewLabel_5.setForeground(Color.WHITE);
		
		filterSeminar.add(lblNewLabel_5, BorderLayout.CENTER);
		
		JPanel SeminarCenter = new JPanel();
		SeminarCenter.setOpaque(false);
		SeminarMain.add(SeminarCenter, BorderLayout.CENTER);
		SeminarCenter.setLayout(new MigLayout("fill, insets 20 100 20 100", "[grow]", "[grow]"));
		seminartable.setPreferredScrollableViewportSize(new Dimension(800, 500));
		seminartable.setShowGrid(false);
		seminartable.setShowHorizontalLines(false);
		seminartable.setShowVerticalLines(false);
		
		SeminarCenter.add(scrollPane1, "cell 0 0,grow");
		seminartable.setModel(SeminartblModel);
		scrollPane1.setViewportView(seminartable);
		TeacherMain.setName("Teacher Panel");
		TeacherMain.setOpaque(false);
		
		mainPanel.add(TeacherMain, "Teacher Panel");
		TeacherMain.setLayout(new BorderLayout(0, 0));
		
		JPanel lSideTeacher = new JPanel();
		lSideTeacher.setPreferredSize(new Dimension(25, 10));
		lSideTeacher.setOpaque(false);
		TeacherMain.add(lSideTeacher, BorderLayout.WEST);
		
		JPanel rSideTeacher = new JPanel();
		rSideTeacher.setPreferredSize(new Dimension(25, 10));
		rSideTeacher.setOpaque(false);
		TeacherMain.add(rSideTeacher, BorderLayout.EAST);
		
		JPanel topTeacher = new JPanel();
		topTeacher.setPreferredSize(new Dimension(10, 75));
		topTeacher.setOpaque(false);
		topTeacher.setLayout(new MigLayout("fill, insets 15 120 10 150", "[]250[grow 250]10[grow]", "[grow 20]"));
		TeacherMain.add(topTeacher, BorderLayout.NORTH);
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setFont(new Font("Lucida Sans Unicode", Font.BOLD, 24));
		
		topTeacher.add(lblNewLabel_6, "cell 0 0, grow");
		
		JPanel bottomTeacher = new JPanel();
		bottomTeacher.setPreferredSize(new Dimension(10, 25));
		bottomTeacher.setOpaque(false);
		TeacherMain.add(bottomTeacher, BorderLayout.SOUTH);
		
		JPanel TeacherCenter = new JPanel();
		TeacherCenter.setOpaque(false);
		TeacherCenter.setLayout(new MigLayout("fill, insets 0 125 0 100", "[grow 40]20[grow]", "[grow 50][grow][grow][grow][grow][grow][grow][grow]10[][]"));
		TeacherMain.add(TeacherCenter, BorderLayout.CENTER);
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 15));
		
		TeacherCenter.add(lblNewLabel_3, "cell 0 0, grow");
		Name.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 15));
		Name.setForeground(Color.WHITE);
		
		TeacherCenter.add(Name, "cell 1 0, grow");
		lblNewLabel_3_1.setForeground(Color.WHITE);
		lblNewLabel_3_1.setFont(new Font("Arial", Font.BOLD, 15));
		
		TeacherCenter.add(lblNewLabel_3_1, "cell 0 1, grow");
		ID.setForeground(Color.WHITE);
		ID.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 15));
		
		TeacherCenter.add(ID, "cell 1 1, grow");
		lblNewLabel_3_2.setForeground(Color.WHITE);
		lblNewLabel_3_2.setFont(new Font("Arial", Font.BOLD, 15));
		
		TeacherCenter.add(lblNewLabel_3_2, "cell 0 2, grow");
		College.setForeground(Color.WHITE);
		College.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 15));
		
		TeacherCenter.add(College, "cell 1 2, grow");
		lblNewLabel_3_3.setForeground(Color.WHITE);
		lblNewLabel_3_3.setFont(new Font("Arial", Font.BOLD, 15));
		
		TeacherCenter.add(lblNewLabel_3_3, "cell 0 3, grow");
		Spec.setForeground(Color.WHITE);
		Spec.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 15));
		
		TeacherCenter.add(Spec, "cell 1 3, grow");
		lblNewLabel_3_4.setForeground(Color.WHITE);
		lblNewLabel_3_4.setFont(new Font("Arial", Font.BOLD, 15));
		
		TeacherCenter.add(lblNewLabel_3_4, "cell 0 4, grow");
		Gender.setForeground(Color.WHITE);
		Gender.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 15));
		
		TeacherCenter.add(Gender, "cell 1 4, grow");
		lblNewLabel_3_5.setForeground(Color.WHITE);
		lblNewLabel_3_5.setFont(new Font("Arial", Font.BOLD, 15));
		
		TeacherCenter.add(lblNewLabel_3_5, "cell 0 5, grow");
		Bday.setForeground(Color.WHITE);
		Bday.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 15));
		
		TeacherCenter.add(Bday, "cell 1 5, grow");
		lblNewLabel_3_6.setForeground(Color.WHITE);
		lblNewLabel_3_6.setFont(new Font("Arial", Font.BOLD, 15));
		
		TeacherCenter.add(lblNewLabel_3_6, "cell 0 6, grow");
		SeminarsAttended.setForeground(Color.WHITE);
		SeminarsAttended.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 15));
		
		TeacherCenter.add(SeminarsAttended, "cell 1 6, grow");
		lblNewLabel_3_7.setForeground(Color.WHITE);
		lblNewLabel_3_7.setFont(new Font("Arial", Font.BOLD, 15));
		
		TeacherCenter.add(lblNewLabel_3_7, "cell 0 7, grow");
		Points.setForeground(Color.WHITE);
		Points.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 15));
		
		TeacherCenter.add(Points, "cell 1 7, grow");
		teachertable.setModel(TeachertblModel);
		SpeakerMain.setName("Speaker Panel");
		SpeakerMain.setOpaque(false);
		
		mainPanel.add(SpeakerMain, "Speaker Panel");
		SpeakerMain.setLayout(new BorderLayout(0, 0));
		
		JPanel lSideSpeaker = new JPanel();
		lSideSpeaker.setPreferredSize(new Dimension(25, 10));
		lSideSpeaker.setOpaque(false);
		SpeakerMain.add(lSideSpeaker, BorderLayout.WEST);
		
		JPanel rSideSpeaker = new JPanel();
		rSideSpeaker.setPreferredSize(new Dimension(25, 10));
		rSideSpeaker.setOpaque(false);
		SpeakerMain.add(rSideSpeaker, BorderLayout.EAST);
		
		JPanel bottomSpeaker = new JPanel();
		bottomSpeaker.setPreferredSize(new Dimension(10, 25));
		bottomSpeaker.setOpaque(false);
		SpeakerMain.add(bottomSpeaker, BorderLayout.SOUTH);
		
		JPanel topSpeaker = new JPanel();
		topSpeaker.setPreferredSize(new Dimension(10, 100));
		topSpeaker.setOpaque(false);
		topSpeaker.setLayout(new MigLayout("fill, insets 50 150 50 150", "[grow 50]250[grow 250]10[grow]", "[grow]"));
		SpeakerMain.add(topSpeaker, BorderLayout.NORTH);
		
		JLabel lblSpeakerTitle = new JLabel("SPEAKERS");
		lblSpeakerTitle.setFont(new Font("Lucida Sans Unicode", Font.BOLD, 20));
		lblSpeakerTitle.setForeground(Color.WHITE);
		topSpeaker.add(lblSpeakerTitle, "cell 0 0");
		searchSpeaker.setOpaque(false);
		
		topSpeaker.add(searchSpeaker, "cell 1 0,grow");
		searchSpeaker.setLayout(new BorderLayout(0, 0));
		SpeakerIcon.setPreferredSize(new Dimension(30, 0));
		SpeakerIcon.setIcon(new ImageIcon(MainFrame.class.getResource("/Project/icons/searchLightSmall.png")));
		
		searchSpeaker.add(SpeakerIcon, BorderLayout.EAST);
		panel_13.setPreferredSize(new Dimension(15, 10));
		panel_13.setOpaque(false);
		
		searchSpeaker.add(panel_13, BorderLayout.WEST);
		
		searchSpeaker.add(txtSearchSpeaker, BorderLayout.CENTER);
		
		filterSpeaker.setOpaque(false);
		topSpeaker.add(filterSpeaker, "cell 2 0,grow");
		filterSpeaker.setLayout(new BorderLayout(0, 0));
		lblNewLabel_7.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 14));
		lblNewLabel_7.setForeground(Color.WHITE);
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		
		filterSpeaker.add(lblNewLabel_7, BorderLayout.CENTER);
		
		JPanel SpeakerCenter = new JPanel();
		SpeakerCenter.setOpaque(false);
		SpeakerCenter.setLayout(new MigLayout("fill, insets 20 100 20 100", "[grow]", "[grow]"));
		SpeakerMain.add(SpeakerCenter, BorderLayout.CENTER);
		
		SpeakerCenter.add(scrollPane3, "cell 0 0,grow");
		speakertable.setPreferredScrollableViewportSize(new Dimension(800, 500));
		speakertable.setModel(SpeakertblModel);
		TeacherCenter.add(scrollPane2, "cell 0 8 2 2,grow");
		scrollPane2.setViewportView(teachertable);
		scrollPane3.setViewportView(speakertable);
		searchtable.fixTable(scrollPane);
		seminartable.fixTable(scrollPane1);
		speakertable.fixTable(scrollPane3);
		teachertable.fixTable(scrollPane2);
		
		teachertable.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        if (e.getClickCount() == 1) {
		            int row = teachertable.getSelectedRow();
		            String date = teachertable.getValueAt(row, 0).toString();
		            String title = teachertable.getValueAt(row, 1).toString();
		            String specialization = teachertable.getValueAt(row, 2).toString();
		            
		            SeminarDetailsFrame secondFrame = new SeminarDetailsFrame(date, title, specialization);
                    secondFrame.setVisible(true);
		        }
		    }
		});
		
		loadSeminarsTableData(teacherUser, seminarData, TeachertblModel);
		
		
		try (BufferedReader reader = new BufferedReader(new FileReader(teacherUser))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[0].equals(IDNumber)) {
                	College.setText(parts[4].trim());
                	Name.setText(parts[2].trim() + " " + parts[3].trim());
                	ID.setText(parts[0].trim());
                	Spec.setText(parts[5].trim());
                	Gender.setText(parts[6].trim());
                	Bday.setText(parts[7].trim());
                	SeminarsAttended.setText(String.valueOf(teacher.computeNoOfSeminars(teacherUser, ID.getText(), Name.getText(), Spec.getText())));
                	Points.setText(String.valueOf(teacher.computeTotalPoints(teacherUser, ID.getText(), Name.getText(), Spec.getText())));
                	lblField.setText("Hello, " + parts[2].trim());
                	CollegeDash.setText(College.getText());
                	SpecDash.setText(Spec.getText());
                	SeminarsDash.setText(SeminarsAttended.getText());
                	PointsDash.setText(Points.getText());
                	break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		searchtable.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        if (e.getClickCount() == 1) {
		            int row = searchtable.getSelectedRow();
		            if(isInteger(searchtable.getValueAt(row, 0).toString())) {
			            String date = searchtable.getValueAt(row, 0).toString();
			            String title = searchtable.getValueAt(row, 1).toString();
			            String specialization = searchtable.getValueAt(row, 2).toString();
			            
			            TeacherDetailsFrame secondFrame = new TeacherDetailsFrame(date, title, specialization);
	                    secondFrame.setVisible(true);
		            } else {
		            	String day = searchtable.getValueAt(row, 0).toString();
		            	String[] values = day.split("-");
		            	if(isInteger(values[0])) {
			            	String date = searchtable.getValueAt(row, 0).toString();
				            String title = searchtable.getValueAt(row, 1).toString();
				            String specialization = searchtable.getValueAt(row, 2).toString();
				            
				            SeminarDetailsFrame secondFrame = new SeminarDetailsFrame(date, title, specialization);
		                    secondFrame.setVisible(true);
		            	} else {
		            		String date = searchtable.getValueAt(row, 0).toString();
				            String title = searchtable.getValueAt(row, 1).toString();
				            String specialization = searchtable.getValueAt(row, 2).toString();
				            
				            SpeakerDetailsFrame secondFrame = new SpeakerDetailsFrame(date, title, specialization);
		                    secondFrame.setVisible(true);
		            	}
		            }
		        }
		    }
		});
		
		seminartable.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        if (e.getClickCount() == 1) {
		            int row = seminartable.getSelectedRow();
		            String date = seminartable.getValueAt(row, 0).toString();
		            String title = seminartable.getValueAt(row, 1).toString();
		            String specialization = seminartable.getValueAt(row, 2).toString();
		            
		            AttendSeminarDetailsFrame secondFrame = new AttendSeminarDetailsFrame(date, title, specialization, IDNumber);
                    secondFrame.setVisible(true);
		        }
		    }
		});
		
		speakertable.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        if (e.getClickCount() == 1) {
		            int row = speakertable.getSelectedRow();
		            String id = speakertable.getValueAt(row, 0).toString();
		            String name = speakertable.getValueAt(row, 1).toString();
		            String specialization = speakertable.getValueAt(row, 2).toString();
		            
		            UserSpeakerDetailsFrame secondFrame = new UserSpeakerDetailsFrame(id, name, specialization, IDNumber);
                    secondFrame.setVisible(true);
		        }
		    }
		});
	}
	
	private void MinBtnActionPerformed(ActionEvent evt) {
        this.setExtendedState(MainFrame.ICONIFIED); 
    }
	
	private void MaxBtnActionPerformed(ActionEvent evt) {
		if (this.getExtendedState() != MainFrame.MAXIMIZED_BOTH) {
			this.setExtendedState(MainFrame.MAXIMIZED_BOTH); 
			setShape(null);
		} else { 
			this.setExtendedState(MainFrame.NORMAL);
			setShape(new RoundRectangle2D.Double(0, 0, 1200, 700, 15, 15));
		}
	 }
	
	private static void loadTableData(String filePath, DefaultTableModel model) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(","); 

                String id = values[0].trim();
                String firstName = values[2].trim();
                String lastName = values[3].trim();
                String specialization = values[5].trim();

                Object[] rowData = {id, firstName + " " + lastName, specialization};

                model.addRow(rowData);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	 private static void loadTableData(String[] filePaths, DefaultTableModel model) {
	        for (String filePath : filePaths) {
	            try {
	                BufferedReader reader = new BufferedReader(new FileReader(filePath));
	                String line;
	                while ((line = reader.readLine()) != null) {
	                    String[] values = line.split(","); 

	                    String idOrDate = values[0].trim();
	                    if(isInteger(idOrDate)) { 
		                    String firstName = values[2].trim();
		                    String lastName = values[3].trim();
		                    String specialization = values[5].trim();
	
		                    Object[] rowData = {idOrDate, firstName + " " + lastName, specialization};
	
		                    model.addRow(rowData);
	                    } else {
	                    	String title = values[1].trim();
		                    String specialization = values[3].trim();
	
		                    Object[] rowData = {idOrDate, title, specialization};
	
		                    model.addRow(rowData);
	                    } 
	                }
	                
	                if(filePath.equals(seminarData)) {
	                	BufferedReader reader1 = new BufferedReader(new FileReader(filePath));
	                	while ((line = reader1.readLine()) != null) {
		                    String[] values = line.split(","); 

		                    String firstName = values[5].trim();
		                    String lastName = values[6].trim();
		                    String specialization = values[7].trim();
	
		                    Object[] rowData = {firstName, lastName, specialization};
	
		                    model.addRow(rowData);
		                }
	                }
	                reader.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	 
	 private static void loadSeminarTableData(String filePath, DefaultTableModel model) {
	        try {
	            BufferedReader reader = new BufferedReader(new FileReader(filePath));
	            String line;
	            while ((line = reader.readLine()) != null) {
	                String[] values = line.split(","); 

	                String date = values[0].trim();
	                String title = values[1].trim();
                    String specialization = values[3].trim();

	                Object[] rowData = {date, title, specialization};

	                model.addRow(rowData);
	            }
	            reader.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	 
	 private static void loadSpeakerTableData(String filePath, DefaultTableModel model) {
	        try {
	            BufferedReader reader = new BufferedReader(new FileReader(filePath));
	            String line;
	            while ((line = reader.readLine()) != null) {
	                String[] values = line.split(","); 

	                String firstName = values[5].trim();
	                String lastName = values[6].trim();
	                String specialization = values[7].trim();

	                Object[] rowData = {firstName, lastName, specialization};

	                model.addRow(rowData);
	            }
	            reader.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	 
	 public static boolean isInteger(String str) {
		    try {
		        Integer.parseInt(str);
		        return true;
		    } catch (NumberFormatException nfe) {
		        return false;
		    }
		}
	 
	 public static boolean alreadyExist(String titleInput) {
		 try (BufferedReader reader = new BufferedReader(new FileReader(seminarData))) {
			    String line;
			    while ((line = reader.readLine()) != null) {
			        String[] data = line.split(",");
			        String title = data[1].trim(); 

			        if (title.equalsIgnoreCase(titleInput)) {
			            JOptionPane.showMessageDialog(null, "Seminar already exists.", "Error", JOptionPane.ERROR_MESSAGE);
			            return true;
			        }
			    }
			} catch (IOException e) {
			    e.printStackTrace();
			}
		 return false;
	 }
	 
	 public static void searchInTextFiles(String searchQuery, String[] filePaths, DefaultTableModel model) {
	        for (String filePath : filePaths) {
	            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
	                String line;
	                while ((line = reader.readLine()) != null) {
	                    if (line.toLowerCase().contains(searchQuery.toLowerCase())) {
	                    	String[] values = line.split(",");
	                    	String idOrDate = values[0].trim();
		                    if(isInteger(idOrDate)) { 
			                    String firstName = values[2].trim();
			                    String lastName = values[3].trim();
			                    String specialization = values[5].trim();
		
			                    Object[] rowData = {idOrDate, firstName + " " + lastName, specialization};
		
			                    model.addRow(rowData);
		                    } else {
		                    	String title = values[1].trim();
			                    String specialization = values[3].trim();
		
			                    Object[] rowData = {idOrDate, title, specialization};
		
			                    model.addRow(rowData);
		                    } 
	                    }
	                }
	            } catch (IOException e) {
	            	e.printStackTrace();
	            }
	        }
	    }
	 
	 public static void searchInTextFiles(String searchQuery, String filePath, DefaultTableModel model) {
		 try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
             String line;
             while ((line = reader.readLine()) != null) {
                 if (line.toLowerCase().contains(searchQuery.toLowerCase())) {
                 	String[] values = line.split(",");
                 	
                 	String firstName = values[5].trim();
	                String lastName = values[6].trim();
	                String specialization = values[7].trim();

	                Object[] rowData = {firstName, lastName, specialization};

	                model.addRow(rowData);
                 }
             }
         } catch (IOException e) {
         	e.printStackTrace();
         }
	 }
	 
	 public void removeRowsFromTable(DefaultTableModel tableModel, String search) {
	        for (int i = tableModel.getRowCount() - 1; i >= 0; i--) {
	        	if (!tableModel.getValueAt(i, 0).toString().equalsIgnoreCase(search) && !tableModel.getValueAt(i, 1).toString().equalsIgnoreCase(search) && !tableModel.getValueAt(i, 2).toString().equalsIgnoreCase(search)) {
	                tableModel.removeRow(i);
	            }
	        }
	    }
	 
	 private static void loadSeminarsTableData(String filePath1, String filePath2, DefaultTableModel model) {
	        try {
	            BufferedReader reader1 = new BufferedReader(new FileReader(filePath1));
	            String line1, line2;
	            while ((line1 = reader1.readLine()) != null) {
	            	if (line1.contains(IDNumber)) {
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
	 
	 public void updateRowsFromTable(DefaultTableModel tableModel) {
	        for (int i = tableModel.getRowCount() - 1; i >= 0; i--) {
	        	tableModel.removeRow(i);
	        }
	    }
}
