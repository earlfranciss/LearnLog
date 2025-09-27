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


public class MainFrame extends JFrame {

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
	private final JPanel PublishPanel = new JPanel();
	private final JPanel SeminarPanel = new JPanel();
	private final JPanel TeacherPanel = new JPanel();
	private final JPanel SpeakerPanel = new JPanel();
	private final JPanel LogoutPanel = new JPanel();
	private final JLabel lblDashboard = new JLabel("Dashboard");
	private final JLabel lblSearch = new JLabel("Search");
	private final JLabel lblPublish = new JLabel("Publish");
	private final JLabel lblSeminarlist = new JLabel("Seminars");
	private final JLabel lblTeacherList = new JLabel("Teachers");
	private final JLabel lblSpeakers = new JLabel("Speakers");
	private final JLabel lblLogout = new JLabel("Logout");
	private final JPanel selectedDashboard = new JPanel();
	private final JPanel selectedSearch = new JPanel();
	private final JPanel selectedPublish = new JPanel();
	private final JPanel selectedSeminar = new JPanel();
	private final JPanel selectedTeacher = new JPanel();
	private final JPanel selectedSpeaker = new JPanel();
	private final JPanel panel_6 = new JPanel();
	private final JPanel CCSDashboardMain = new JPanel();
	private final JPanel SearchMain = new JPanel();
	private final JPanel PublishMain = new JPanel();
	private final JPanel SeminarMain = new JPanel();
	private final JPanel TeacherMain = new JPanel();
	private final JPanel SpeakerMain = new JPanel();
	private final CardLayout crd = new CardLayout();
	private final JButton btnSpeaker = new JButton("");
	private final JButton btnTeacher = new JButton("");
	private final JButton btnSeminar = new JButton("");
	private final JButton btnPublish = new JButton("");
	private final JButton btnSearch = new JButton("");
	private final JButton btnDashboard = new JButton("");
	private int mouseX, mouseY;
	//private Color fieldColor = new Color(0, 31, 63, 50);//21,82,116,60
	private Color panelColor = new Color(0, 64, 128, 180);
	private Color btnColor = Color.decode("#6ab7e5");
	private Color btnColorBG = new Color(106, 183, 229, 100);//106, 183, 229
	private final JPanel field1 = new RoundedPanel(20, panelColor);
	private final JPanel field4 = new RoundedPanel(20, panelColor);
	private final JPanel field7 = new RoundedPanel(20, panelColor);
	private final JPanel field2 = new RoundedPanel(20, panelColor);
	private final JPanel field5 = new RoundedPanel(20, panelColor);
	private final JPanel field8 = new RoundedPanel(20, panelColor);
	private final JPanel field3 = new RoundedPanel(20, panelColor);
	private final JPanel field6 = new RoundedPanel(20, panelColor);
	private final JPanel field9 = new RoundedPanel(20, panelColor);
	private final JPanel searchbar = new RoundedPanel(35, panelColor);
	private JTextField txtSearch;
	private final JLabel Spec1 = new JLabel("");
	private final JLabel Spec2 = new JLabel("");
	private final JLabel Spec3 = new JLabel("");
	private final JLabel Spec6 = new JLabel("");
	private final JLabel Spec5 = new JLabel("");
	private final JLabel Spec4 = new JLabel("");
	private final JLabel Spec7 = new JLabel("");
	private final JLabel Spec8 = new JLabel("");
	private final JLabel Spec9 = new JLabel("");
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
	private final JLabel PublishTitle = new JLabel("Publish a Seminar:\r\n");
	private final JComboBox CollegeComboBox = new JComboBox(field);
	private final JComboBox SpecComboBox = new JComboBox();
	private final JDateChooser dateOfActChooser = new JDateChooser();
	private final JTextField SpeakerVenue = new JTextField();
	private final JTextField SpeakerFN = new JTextField();
	private final JTextField SpeakerLN = new JTextField();
	private final JComboBox SpeakerSpec = new JComboBox();
	private final JPanel panel_11 = new JPanel();
	private final JLabel DetailsTitle = new JLabel("Speaker's Details:");
	private JPanel SubmitPanel = new RoundedPanel(20, btnColor);
	private final JLabel btnSubmit = new JLabel("Submit");
	private final JPanel lSideSeminar = new JPanel();
	private final JPanel rSideSeminar = new JPanel();
	private final JPanel bottomSeminar = new JPanel();
	private final TableCustom seminartable = new TableCustom();
	private final TableCustom teachertable = new TableCustom();
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
	private final JPanel SearchTeachers = new RoundedPanel(35, panelColor);
	private final JPanel filterSearchTeachers = new RoundedPanel( 35, btnColor);
	private final JLabel lblNewLabel_6 = new JLabel("TEACHERS");
	private final JLabel SearchTeachersIcon = new JLabel("");
	private final JTextField txtSearchTeachers = new JTextField();
	private final JPanel panel_15 = new JPanel();
	private final JLabel filterTeachers = new JLabel("Search");
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
	private final JPanel panel_2 = new JPanel();
	private final JPanel panel_3 = new JPanel();
	private final JPanel CCADashboardMain = new JPanel();
	private final JPanel CCJDashboardMain = new JPanel();
	private final JPanel CHTMDashboardMain = new JPanel();
	private final JPanel CMEDashboardMain = new JPanel();
	private final JPanel CNDashboardMain = new JPanel();
	private final JPanel CMTDashboardMain = new JPanel();
	private final JPanel COEDashboardMain = new JPanel();
	private final JPanel CBADashboardMain = new JPanel();
	private final JPanel CTEDashboardMain = new JPanel();
	private JTextField Seminar;
	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	
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
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame("ccsadmin");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});  
	}


	@SuppressWarnings("serial")
	public MainFrame(String IDNumber) {
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
		
		
		txtSearchTeachers.setText("Search");
		txtSearchTeachers.setOpaque(false);
		txtSearchTeachers.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 14));
		txtSearchTeachers.setForeground(Color.WHITE);
		txtSearchTeachers.setBorder(null);
		txtSearchTeachers.setColumns(10);
		txtSearchTeachers.setBackground(new Color(0,0,0,0));
		
		txtSearchTeachers.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtSearchTeachers.getText().equals("Search")) {
					txtSearchTeachers.setText("");
				} else
					txtSearchTeachers.selectAll();
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtSearchTeachers.getText().equals("")) {
					txtSearchTeachers.setText("Search");	
				}
			}
		});
		
		filterSearchTeachers.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				removeRowsFromTable(TeachertblModel,txtSearchTeachers.getText());
	            searchInTextFiles(txtSearchTeachers.getText(), searchData, TeachertblModel);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				filterTeachers.setForeground(Color.red);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				filterTeachers.setForeground(Color.white);
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
		
		
		SpeakerLN.setFont(new Font("Arial", Font.PLAIN, 13));
		SpeakerLN.setColumns(10);
		SpeakerFN.setFont(new Font("Arial", Font.PLAIN, 13));
		SpeakerFN.setColumns(10);
		SpeakerVenue.setFont(new Font("Arial", Font.PLAIN, 13));
		SpeakerVenue.setColumns(10);
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
		panel_14.setPreferredSize(new Dimension(10, 380));
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
						"ID Number", "Name", "Specialization"
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
		
		
		if(IDNumber.equals("ccsadmin")) {
			
			crd.show(mainPanel, CCSDashboardMain.getName());
		}else if(IDNumber.equals("ccaadmin")) {
			mainPanel.add(CCADashboardMain, "CCA Dashboard Panel");
			crd.show(mainPanel, CCADashboardMain.getName());
		}else if(IDNumber.equals("ccjadmin")) {
			mainPanel.add(CCJDashboardMain, "CCJ Dashboard Panel");
			crd.show(mainPanel, CCJDashboardMain.getName());
		}else if(IDNumber.equals("cbaadmin")) {
			mainPanel.add(CBADashboardMain, "CBA Dashboard Panel");
			crd.show(mainPanel, CBADashboardMain.getName());
		}else if(IDNumber.equals("chtmadmin")) {
			mainPanel.add(CHTMDashboardMain, "CHTM Dashboard Panel");
			crd.show(mainPanel, CHTMDashboardMain.getName());
		}else if(IDNumber.equals("cmeadmin")) {
			mainPanel.add(CMEDashboardMain, "CME Dashboard Panel");
			crd.show(mainPanel, CMEDashboardMain.getName());
		}else if(IDNumber.equals("cmtadmin")) {
			mainPanel.add(CMTDashboardMain, "CMT Dashboard Panel");
			crd.show(mainPanel, CMTDashboardMain.getName());
		}else if(IDNumber.equals("cnadmin")) {
			mainPanel.add(CNDashboardMain, "CN Dashboard Panel");
			crd.show(mainPanel, CNDashboardMain.getName());
		}else if(IDNumber.equals("coemadmin")) {
			mainPanel.add(COEDashboardMain, "COE Dashboard Panel");
			crd.show(mainPanel, COEDashboardMain.getName());
		}else if(IDNumber.equals("cteadmin")) {
			mainPanel.add(CTEDashboardMain, "CTE Dashboard Panel");
			crd.show(mainPanel, CTEDashboardMain.getName());
		}
		
		
		mainPanel.add(CCSDashboardMain, "CCS Dashboard Panel");
		
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
				btnPublish.setOpaque(false);
				btnSeminar.setOpaque(false);
				btnTeacher.setOpaque(false);
				selectedDashboard.setBackground(btnColor);
				selectedDashboard.setOpaque(true);
				selectedSearch.setOpaque(false);
				selectedPublish.setOpaque(false);
				selectedSpeaker.setOpaque(false);
				selectedSeminar.setOpaque(false);
				selectedTeacher.setOpaque(false);
				layeredPane.repaint();
			}
		});
		btnDashboard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(IDNumber.equals("ccsadmin"))
					crd.show(mainPanel, CCSDashboardMain.getName());
				else if(IDNumber.equals("ccaadmin"))
					crd.show(mainPanel, CCADashboardMain.getName());
				else if(IDNumber.equals("ccjadmin"))
					crd.show(mainPanel, CCJDashboardMain.getName());
				else if(IDNumber.equals("cbaadmin"))
					crd.show(mainPanel, CBADashboardMain.getName());
				else if(IDNumber.equals("chtmadmin"))
					crd.show(mainPanel, CHTMDashboardMain.getName());
				else if(IDNumber.equals("cmeadmin"))
					crd.show(mainPanel, CMEDashboardMain.getName());
				else if(IDNumber.equals("cmtadmin"))
					crd.show(mainPanel, CMTDashboardMain.getName());
				else if(IDNumber.equals("cnadmin"))
					crd.show(mainPanel, CNDashboardMain.getName());
				else if(IDNumber.equals("coemadmin"))
					crd.show(mainPanel, COEDashboardMain.getName());
				else if(IDNumber.equals("cteadmin"))
					crd.show(mainPanel, CTEDashboardMain.getName());
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
				btnPublish.setOpaque(false);
				btnSeminar.setOpaque(false);
				btnTeacher.setOpaque(false);
				selectedSearch.setBackground(btnColor);
				selectedSearch.setOpaque(true);
				selectedDashboard.setOpaque(false);
				selectedPublish.setOpaque(false);
				selectedSpeaker.setOpaque(false);
				selectedSeminar.setOpaque(false);
				selectedTeacher.setOpaque(false);
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
	
		PublishPanel.setOpaque(false);
		PublishPanel.setBounds(0, 160, 218, 55);
		
		panel_14.add(PublishPanel);
		PublishPanel.setLayout(null);
		
		JLabel publishBtn = new JLabel();
		
		publishBtn.setHorizontalAlignment(SwingConstants.CENTER);
		publishBtn.setIcon(new ImageIcon(publishbtn));
		publishBtn.setOpaque(false);
		publishBtn.setBorder(null);
		publishBtn.setBounds(24, 10, 33, 26);
		PublishPanel.add(publishBtn);
		lblPublish.setForeground(Color.WHITE);
		lblPublish.setFont(new Font("Lucida Sans Unicode", Font.BOLD, 15));
		lblPublish.setBounds(75, 10, 135, 26);
		
		PublishPanel.add(lblPublish);
		selectedPublish.setOpaque(false);
		selectedPublish.setBounds(0, 0, 5, 55);
		
		PublishPanel.add(selectedPublish);
		btnPublish.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				PublishPanel.setBackground(Color.decode("#44738f"));
				PublishPanel.setOpaque(true);
				layeredPane.repaint();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				PublishPanel.setOpaque(false);
				layeredPane.repaint();
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				btnPublish.setBackground(btnColorBG);
				btnPublish.setOpaque(true);
				btnDashboard.setOpaque(false);
				btnSpeaker.setOpaque(false);
				btnSearch.setOpaque(false);
				btnSeminar.setOpaque(false);
				btnTeacher.setOpaque(false);
				selectedPublish.setBackground(btnColor);
				selectedPublish.setOpaque(true);
				selectedDashboard.setOpaque(false);
				selectedSearch.setOpaque(false);
				selectedSpeaker.setOpaque(false);
				selectedSeminar.setOpaque(false);
				selectedTeacher.setOpaque(false);
				layeredPane.repaint();
			}
		});
		btnPublish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crd.show(mainPanel, PublishMain.getName());
			}
		});
		btnPublish.setOpaque(false);
		btnPublish.setFocusPainted(false);
		btnPublish.setContentAreaFilled(false);
		btnPublish.setBorderPainted(false);
		btnPublish.setBorder(null);
		btnPublish.setBounds(0, 0, 268, 55);
		
		PublishPanel.add(btnPublish);
		SeminarPanel.setOpaque(false);
		SeminarPanel.setBounds(0, 215, 218, 55);
		
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
				btnPublish.setOpaque(false);
				btnSearch.setOpaque(false);
				btnTeacher.setOpaque(false);
				selectedSeminar.setBackground(btnColor);
				selectedSpeaker.setOpaque(false);
				selectedDashboard.setOpaque(false);
				selectedSearch.setOpaque(false);
				selectedPublish.setOpaque(false);
				selectedSeminar.setOpaque(true);
				selectedTeacher.setOpaque(false);
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
		
		TeacherPanel.setOpaque(false);
		TeacherPanel.setBounds(0, 270, 218, 55);
		
		panel_14.add(TeacherPanel);
		TeacherPanel.setLayout(null);
		
		JLabel TeacherBtn = new JLabel();
		
		TeacherBtn.setHorizontalAlignment(SwingConstants.CENTER);
		TeacherBtn.setIcon(new ImageIcon(teacherbtn));
		TeacherBtn.setOpaque(false);
		TeacherBtn.setBorder(null);
		TeacherBtn.setBounds(24, 10, 33, 26);
		TeacherPanel.add(TeacherBtn);
		lblTeacherList.setForeground(Color.WHITE);
		lblTeacherList.setFont(new Font("Lucida Sans Unicode", Font.BOLD, 15));
		lblTeacherList.setBounds(75, 10, 135, 26);
		
		TeacherPanel.add(lblTeacherList);
		selectedTeacher.setOpaque(false);
		selectedTeacher.setBounds(0, 0, 5, 55);
		
		TeacherPanel.add(selectedTeacher);
		btnTeacher.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				TeacherPanel.setBackground(Color.decode("#44738f"));
				TeacherPanel.setOpaque(true);
				layeredPane.repaint();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				TeacherPanel.setOpaque(false);
				layeredPane.repaint();
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				btnTeacher.setBackground(btnColorBG);
				btnTeacher.setOpaque(true);
				btnDashboard.setOpaque(false);
				btnSearch.setOpaque(false);
				btnPublish.setOpaque(false);
				btnSeminar.setOpaque(false);
				btnSpeaker.setOpaque(false);
				selectedTeacher.setBackground(btnColor);
				selectedSpeaker.setOpaque(false);
				selectedDashboard.setOpaque(false);
				selectedSearch.setOpaque(false);
				selectedPublish.setOpaque(false);
				selectedSeminar.setOpaque(false);
				selectedTeacher.setOpaque(true);
				layeredPane.repaint();
			}
		});
		btnTeacher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crd.show(mainPanel, TeacherMain.getName());
			}
		});
		loadTableData(teacherUser, TeachertblModel);
		btnTeacher.setOpaque(false);
		btnTeacher.setFocusPainted(false);
		btnTeacher.setContentAreaFilled(false);
		btnTeacher.setBorderPainted(false);
		btnTeacher.setBorder(null);
		btnTeacher.setBounds(0, 0, 268, 55);
		
		TeacherPanel.add(btnTeacher);
		
		SpeakerPanel.setOpaque(false);
		SpeakerPanel.setBounds(0, 325, 218, 55);
		
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
				btnPublish.setOpaque(false);
				btnSeminar.setOpaque(false);
				btnTeacher.setOpaque(false);
				selectedSpeaker.setBackground(btnColor);
				selectedSpeaker.setOpaque(true);
				selectedDashboard.setOpaque(false);
				selectedSearch.setOpaque(false);
				selectedPublish.setOpaque(false);
				selectedSeminar.setOpaque(false);
				selectedTeacher.setOpaque(false);
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
		

		
		CCSDashboardMain.setName("CCS Dashboard Panel");
		CCSDashboardMain.setOpaque(false);
		CCSDashboardMain.setBorder(null);
		CCSDashboardMain.setFocusable(false);
		CCSDashboardMain.setRequestFocusEnabled(false);

		
		CCSDashboardMain.setLayout(new MigLayout("fill, inset 20 70 20 50", "[grow]30[grow]30[grow]", "[grow 30][grow 40]20[grow]10[grow]10[grow]"));
		searchbar.setOpaque(false);
		
		CCSDashboardMain.add(searchbar, "cell 2 0,grow");
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
				btnPublish.setOpaque(false);
				btnSeminar.setOpaque(false);
				btnTeacher.setOpaque(false);
				selectedSearch.setBackground(btnColor);
				selectedSearch.setOpaque(true);
				selectedDashboard.setOpaque(false);
				selectedPublish.setOpaque(false);
				selectedSpeaker.setOpaque(false);
				selectedSeminar.setOpaque(false);
				selectedTeacher.setOpaque(false);
				layeredPane.repaint();
	            searchtable.repaint();
	            searchtable.revalidate();
			}
		});
		 
		panel_7.setOpaque(false);
		panel_7.setLayout(null);
		CCSDashboardMain.add(panel_7, "cell 0 1 2 1,grow");
		lblField.setForeground(Color.WHITE);
		lblField.setFont(new Font("Impact", Font.PLAIN, 35));
		lblField.setBounds(26, 0, 617, 46);
		
		panel_7.add(lblField);
		
		field1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				crd.show(mainPanel, SearchMain.getName());
				removeRowsFromTable(SearchtblModel, Spec1.getText());
	            searchInTextFiles(Spec1.getText(), searchData, SearchtblModel);
	            txtSearch_1.setText(Spec1.getText());
	            btnSearch.setBackground(btnColorBG);
				btnSearch.setOpaque(true);
				btnDashboard.setOpaque(false);
				btnSpeaker.setOpaque(false);
				btnPublish.setOpaque(false);
				btnSeminar.setOpaque(false);
				btnTeacher.setOpaque(false);
				selectedSearch.setBackground(btnColor);
				selectedSearch.setOpaque(true);
				selectedDashboard.setOpaque(false);
				selectedPublish.setOpaque(false);
				selectedSpeaker.setOpaque(false);
				selectedSeminar.setOpaque(false);
				selectedTeacher.setOpaque(false);
				layeredPane.repaint();
	            searchtable.repaint();
	            searchtable.revalidate();
			}
		});
		field2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				crd.show(mainPanel, SearchMain.getName());
				removeRowsFromTable(SearchtblModel, Spec2.getText());
	            searchInTextFiles(Spec2.getText(), searchData, SearchtblModel);
	            txtSearch_1.setText(Spec2.getText());
	            btnSearch.setBackground(btnColorBG);
				btnSearch.setOpaque(true);
				btnDashboard.setOpaque(false);
				btnSpeaker.setOpaque(false);
				btnPublish.setOpaque(false);
				btnSeminar.setOpaque(false);
				btnTeacher.setOpaque(false);
				selectedSearch.setBackground(btnColor);
				selectedSearch.setOpaque(true);
				selectedDashboard.setOpaque(false);
				selectedPublish.setOpaque(false);
				selectedSpeaker.setOpaque(false);
				selectedSeminar.setOpaque(false);
				selectedTeacher.setOpaque(false);
				layeredPane.repaint();
	            searchtable.repaint();
	            searchtable.revalidate();
			}
		});
		field3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				crd.show(mainPanel, SearchMain.getName());
				removeRowsFromTable(SearchtblModel, Spec3.getText());
	            searchInTextFiles(Spec3.getText(), searchData, SearchtblModel);
	            txtSearch_1.setText(Spec3.getText());
	            btnSearch.setBackground(btnColorBG);
				btnSearch.setOpaque(true);
				btnDashboard.setOpaque(false);
				btnSpeaker.setOpaque(false);
				btnPublish.setOpaque(false);
				btnSeminar.setOpaque(false);
				btnTeacher.setOpaque(false);
				selectedSearch.setBackground(btnColor);
				selectedSearch.setOpaque(true);
				selectedDashboard.setOpaque(false);
				selectedPublish.setOpaque(false);
				selectedSpeaker.setOpaque(false);
				selectedSeminar.setOpaque(false);
				selectedTeacher.setOpaque(false);
				layeredPane.repaint();
	            searchtable.repaint();
	            searchtable.revalidate();
			}
		});
		field4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				crd.show(mainPanel, SearchMain.getName());
				removeRowsFromTable(SearchtblModel, Spec4.getText());
	            searchInTextFiles(Spec4.getText(), searchData, SearchtblModel);
	            txtSearch_1.setText(Spec4.getText());
	            btnSearch.setBackground(btnColorBG);
				btnSearch.setOpaque(true);
				btnDashboard.setOpaque(false);
				btnSpeaker.setOpaque(false);
				btnPublish.setOpaque(false);
				btnSeminar.setOpaque(false);
				btnTeacher.setOpaque(false);
				selectedSearch.setBackground(btnColor);
				selectedSearch.setOpaque(true);
				selectedDashboard.setOpaque(false);
				selectedPublish.setOpaque(false);
				selectedSpeaker.setOpaque(false);
				selectedSeminar.setOpaque(false);
				selectedTeacher.setOpaque(false);
				layeredPane.repaint();
	            searchtable.repaint();
	            searchtable.revalidate();
			}
		});
		field5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				crd.show(mainPanel, SearchMain.getName());
				removeRowsFromTable(SearchtblModel, Spec5.getText());
	            searchInTextFiles(Spec5.getText(), searchData, SearchtblModel);
	            txtSearch_1.setText(Spec5.getText());
	            btnSearch.setBackground(btnColorBG);
				btnSearch.setOpaque(true);
				btnDashboard.setOpaque(false);
				btnSpeaker.setOpaque(false);
				btnPublish.setOpaque(false);
				btnSeminar.setOpaque(false);
				btnTeacher.setOpaque(false);
				selectedSearch.setBackground(btnColor);
				selectedSearch.setOpaque(true);
				selectedDashboard.setOpaque(false);
				selectedPublish.setOpaque(false);
				selectedSpeaker.setOpaque(false);
				selectedSeminar.setOpaque(false);
				selectedTeacher.setOpaque(false);
				layeredPane.repaint();
	            searchtable.repaint();
	            searchtable.revalidate();
			}
		});
		field6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				crd.show(mainPanel, SearchMain.getName());
				removeRowsFromTable(SearchtblModel, Spec6.getText());
	            searchInTextFiles(Spec6.getText(), searchData, SearchtblModel);
	            txtSearch_1.setText(Spec6.getText());
	            btnSearch.setBackground(btnColorBG);
				btnSearch.setOpaque(true);
				btnDashboard.setOpaque(false);
				btnSpeaker.setOpaque(false);
				btnPublish.setOpaque(false);
				btnSeminar.setOpaque(false);
				btnTeacher.setOpaque(false);
				selectedSearch.setBackground(btnColor);
				selectedSearch.setOpaque(true);
				selectedDashboard.setOpaque(false);
				selectedPublish.setOpaque(false);
				selectedSpeaker.setOpaque(false);
				selectedSeminar.setOpaque(false);
				selectedTeacher.setOpaque(false);
				layeredPane.repaint();
	            searchtable.repaint();
	            searchtable.revalidate();
			}
		});
		field7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				crd.show(mainPanel, SearchMain.getName());
				removeRowsFromTable(SearchtblModel, Spec7.getText());
	            searchInTextFiles(Spec7.getText(), searchData, SearchtblModel);
	            txtSearch_1.setText(Spec7.getText());
	            btnSearch.setBackground(btnColorBG);
				btnSearch.setOpaque(true);
				btnDashboard.setOpaque(false);
				btnSpeaker.setOpaque(false);
				btnPublish.setOpaque(false);
				btnSeminar.setOpaque(false);
				btnTeacher.setOpaque(false);
				selectedSearch.setBackground(btnColor);
				selectedSearch.setOpaque(true);
				selectedDashboard.setOpaque(false);
				selectedPublish.setOpaque(false);
				selectedSpeaker.setOpaque(false);
				selectedSeminar.setOpaque(false);
				selectedTeacher.setOpaque(false);
				layeredPane.repaint();
	            searchtable.repaint();
	            searchtable.revalidate();
			}
		});
		field8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				crd.show(mainPanel, SearchMain.getName());
				removeRowsFromTable(SearchtblModel, Spec8.getText());
	            searchInTextFiles(Spec8.getText(), searchData, SearchtblModel);
	            txtSearch_1.setText(Spec8.getText());
	            btnSearch.setBackground(btnColorBG);
				btnSearch.setOpaque(true);
				btnDashboard.setOpaque(false);
				btnSpeaker.setOpaque(false);
				btnPublish.setOpaque(false);
				btnSeminar.setOpaque(false);
				btnTeacher.setOpaque(false);
				selectedSearch.setBackground(btnColor);
				selectedSearch.setOpaque(true);
				selectedDashboard.setOpaque(false);
				selectedPublish.setOpaque(false);
				selectedSpeaker.setOpaque(false);
				selectedSeminar.setOpaque(false);
				selectedTeacher.setOpaque(false);
				layeredPane.repaint();
	            searchtable.repaint();
	            searchtable.revalidate();
			}
		});
		field9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				crd.show(mainPanel, SearchMain.getName());
				removeRowsFromTable(SearchtblModel, Spec9.getText());
	            searchInTextFiles(Spec9.getText(), searchData, SearchtblModel);
	            txtSearch_1.setText(Spec9.getText());
	            btnSearch.setBackground(btnColorBG);
				btnSearch.setOpaque(true);
				btnDashboard.setOpaque(false);
				btnSpeaker.setOpaque(false);
				btnPublish.setOpaque(false);
				btnSeminar.setOpaque(false);
				btnTeacher.setOpaque(false);
				selectedSearch.setBackground(btnColor);
				selectedSearch.setOpaque(true);
				selectedDashboard.setOpaque(false);
				selectedPublish.setOpaque(false);
				selectedSpeaker.setOpaque(false);
				selectedSeminar.setOpaque(false);
				selectedTeacher.setOpaque(false);
				layeredPane.repaint();
	            searchtable.repaint();
	            searchtable.revalidate();
			}
		});
		
		field1.setOpaque(false);
		
		CCSDashboardMain.add(field1, "cell 0 2,grow");
		field1.setLayout(new BorderLayout(0, 0));
		Spec1.setVerticalAlignment(SwingConstants.BOTTOM);
		Spec1.setHorizontalAlignment(SwingConstants.LEFT);
		Spec1.setHorizontalTextPosition(SwingConstants.CENTER);
		
		Spec1.setForeground(Color.WHITE);
		Spec1.setVerticalTextPosition(SwingConstants.TOP);
		Spec1.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 19));
		
		field1.add(Spec1, BorderLayout.CENTER);
		panel.setPreferredSize(new Dimension(15, 10));
		panel.setOpaque(false);
		
		field1.add(panel, BorderLayout.WEST);
		panel_1.setOpaque(false);
		
		field1.add(panel_1, BorderLayout.SOUTH);
		field2.setOpaque(false);
		
		CCSDashboardMain.add(field2, "cell 1 2,grow");
		field2.setLayout(new BorderLayout(0, 0));

		Spec2.setForeground(Color.WHITE);
		Spec2.setVerticalTextPosition(SwingConstants.BOTTOM);
		Spec2.setVerticalAlignment(SwingConstants.BOTTOM);
		Spec2.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 19));
		
		field2.add(Spec2);
		panel_2.setPreferredSize(new Dimension(15, 10));
		panel_2.setOpaque(false);
		
		field2.add(panel_2, BorderLayout.WEST);
		panel_3.setOpaque(false);
		
		field2.add(panel_3, BorderLayout.SOUTH);
		field3.setOpaque(false);
		
		CCSDashboardMain.add(field3, "cell 2 2,grow");
		field3.setLayout(new BorderLayout(0, 0));

		Spec3.setForeground(Color.WHITE);
		Spec3.setVerticalTextPosition(SwingConstants.BOTTOM);
		Spec3.setVerticalAlignment(SwingConstants.BOTTOM);
		Spec3.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 19));
		
		field3.add(Spec3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setPreferredSize(new Dimension(15, 10));
		panel_4.setOpaque(false);
		field3.add(panel_4, BorderLayout.WEST);
		
		JPanel panel_5 = new JPanel();
		panel_5.setOpaque(false);
		field3.add(panel_5, BorderLayout.SOUTH);
		field4.setOpaque(false);
		
		CCSDashboardMain.add(field4, "cell 0 3,grow");
		field4.setLayout(new BorderLayout(0, 0));

		Spec4.setForeground(Color.WHITE);
		Spec4.setVerticalTextPosition(SwingConstants.BOTTOM);
		Spec4.setVerticalAlignment(SwingConstants.BOTTOM);
		Spec4.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 19));
		
		field4.add(Spec4);
		
		JPanel panel_17 = new JPanel();
		panel_17.setPreferredSize(new Dimension(15, 10));
		panel_17.setOpaque(false);
		field4.add(panel_17, BorderLayout.WEST);
		
		JPanel panel_18 = new JPanel();
		panel_18.setOpaque(false);
		field4.add(panel_18, BorderLayout.SOUTH);
		field5.setOpaque(false);
		
		CCSDashboardMain.add(field5, "cell 1 3,grow");
		field5.setLayout(new BorderLayout(0, 0));

		Spec5.setForeground(Color.WHITE);
		Spec5.setVerticalTextPosition(SwingConstants.BOTTOM);
		Spec5.setVerticalAlignment(SwingConstants.BOTTOM);
		Spec5.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 19));
		
		field5.add(Spec5);
		
		JPanel panel_19 = new JPanel();
		panel_19.setPreferredSize(new Dimension(15, 10));
		panel_19.setOpaque(false);
		field5.add(panel_19, BorderLayout.WEST);
		
		JPanel panel_20 = new JPanel();
		panel_20.setOpaque(false);
		field5.add(panel_20, BorderLayout.SOUTH);
		field6.setOpaque(false);
		
		CCSDashboardMain.add(field6, "cell 2 3,grow");
		field6.setLayout(new BorderLayout(0, 0));

		Spec6.setForeground(Color.WHITE);
		Spec6.setVerticalTextPosition(SwingConstants.BOTTOM);
		Spec6.setVerticalAlignment(SwingConstants.BOTTOM);
		Spec6.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 19));
		
		field6.add(Spec6);
		
		JPanel panel_21 = new JPanel();
		panel_21.setPreferredSize(new Dimension(15, 10));
		panel_21.setOpaque(false);
		field6.add(panel_21, BorderLayout.WEST);
		
		JPanel panel_22 = new JPanel();
		panel_22.setOpaque(false);
		field6.add(panel_22, BorderLayout.SOUTH);
		field7.setOpaque(false);
		
		CCSDashboardMain.add(field7, "cell 0 4,grow");
		field7.setLayout(new BorderLayout(0, 0));

		Spec7.setForeground(Color.WHITE);
		Spec7.setVerticalTextPosition(SwingConstants.BOTTOM);
		Spec7.setVerticalAlignment(SwingConstants.BOTTOM);
		Spec7.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 19));
		
		field7.add(Spec7);
		
		JPanel panel_23 = new JPanel();
		panel_23.setPreferredSize(new Dimension(15, 10));
		panel_23.setOpaque(false);
		field7.add(panel_23, BorderLayout.WEST);
		
		JPanel panel_24 = new JPanel();
		panel_24.setOpaque(false);
		field7.add(panel_24, BorderLayout.SOUTH);
		field8.setOpaque(false);
		
		CCSDashboardMain.add(field8, "cell 1 4,grow");
		field8.setLayout(new BorderLayout(0, 0));

		Spec8.setForeground(Color.WHITE);
		Spec8.setVerticalTextPosition(SwingConstants.BOTTOM);
		Spec8.setVerticalAlignment(SwingConstants.BOTTOM);
		Spec8.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 19));
		
		field8.add(Spec8);
		
		JPanel panel_25 = new JPanel();
		panel_25.setPreferredSize(new Dimension(15, 10));
		panel_25.setOpaque(false);
		field8.add(panel_25, BorderLayout.WEST);
		
		JPanel panel_26 = new JPanel();
		panel_26.setOpaque(false);
		field8.add(panel_26, BorderLayout.SOUTH);
		field9.setOpaque(false);
		
		CCSDashboardMain.add(field9, "cell 2 4,grow");
		field9.setLayout(new BorderLayout(0, 0));

		Spec9.setForeground(Color.WHITE);
		Spec9.setVerticalTextPosition(SwingConstants.BOTTOM);
		Spec9.setVerticalAlignment(SwingConstants.BOTTOM);
		Spec9.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 19));

		

		if(IDNumber.equals("ccsadmin")) {
			Spec1.setText("Computer Science");
			Spec2.setText("Software Engineering");
			Spec3.setText("Cybersecurity");
			Spec4.setText("Data Science");
			Spec5.setText("Information Technology");
			Spec6.setText("Database Administration");
			Spec7.setText("Network Administration");
			Spec8.setText("IT Project Management");
			Spec9.setText("Machine Learning");
		}else if(IDNumber.equals("ccaadmin")) {
			Spec1.setText("Customs Compliance");
			Spec2.setText("Trade Facilitation");
			Spec3.setText("Tariff Classification");
			Spec4.setText("Customs Valuation");
			Spec5.setText("Customs Risk Management");
			Spec6.setText("International Trade Agreements");
		}else if(IDNumber.equals("ccjadmin")) {
			Spec1.setText("Law");
			Spec2.setText("Criminal Justice");
			Spec3.setText("Criminology");
			Spec4.setText("Legal Studies");
			Spec5.setText("Forensic Science");
			Spec6.setText("Cybersecurity");
		}else if(IDNumber.equals("cbaadmin")) {
			Spec1.setText("Finance");
			Spec2.setText("Accounting");
			Spec3.setText("Marketing");
			Spec4.setText("Management");
			Spec5.setText("Management Accounting");
			Spec6.setText("Entrepreneurship");
			Spec7.setText("Business Analytics");
			Spec8.setText("Taxation");
			Spec9.setText("Economics");
		}else if(IDNumber.equals("chtmadmin")) {
			Spec1.setText("Hotel Management");
			Spec2.setText("Restaurant Management");
			Spec3.setText("Travel and Tourism Management");
			Spec4.setText("Revenue and Yield Management");
			Spec5.setText("Sustainable Tourism Management");
			Spec6.setText("Resort Management");
		}else if(IDNumber.equals("cmeadmin")) {
			Spec1.setText("Marine Propulsion Systems");
			Spec2.setText("Marine Power Systems");
			Spec3.setText("Marine Systems Engineering");
			Spec4.setText("Marine Materials and Corrosion Engineering");
			Spec5.setText("Marine Safety and Risk Assessment");
			Spec6.setText("Offshore Engineering");
		}else if(IDNumber.equals("cmtadmin")) {
			Spec1.setText("Ship Navigation and Operations");
			Spec2.setText("Ship Management and Operations");
			Spec3.setText("Port and Terminal Operations");
			Spec4.setText("Maritime Law and Regulations");
			Spec5.setText("Maritime Safety and Environmental Protection");
			Spec6.setText("Maritime Business and Logistics");
		}else if(IDNumber.equals("cnadmin")) {
			Spec1.setText("Pediatric Nursing");
			Spec2.setText("Geriatric Nursing");
			Spec3.setText("Obstetric and Gynecological Nursing");
			Spec4.setText("Critical Care Nursing");
			Spec5.setText("Medical-Surgical Nursing");
			Spec6.setText("Emergency Nursing");
		}else if(IDNumber.equals("coemadmin")) {
			Spec1.setText("Civil Engineering");
			Spec2.setText("Mechanical Engineering");
			Spec3.setText("Electrical Engineering");
			Spec4.setText("Aerospace Engineering");
			Spec5.setText("Chemical Engineering");
			Spec6.setText("Industrial Engineering");
		}else if(IDNumber.equals("cteadmin")) {
			Spec1.setText("Elementary Education");
			Spec2.setText("Secondary Education");
			Spec3.setText("Special Education");
			Spec4.setText("Higher Education Administration");
			Spec5.setText("Early Childhood Education");
			Spec6.setText("English as a Second Language (ESL)");
		}
		
		field9.add(Spec9);
		
		JPanel panel_28 = new JPanel();
		panel_28.setPreferredSize(new Dimension(15, 10));
		panel_28.setOpaque(false);
		field9.add(panel_28, BorderLayout.WEST);
		
		JPanel panel_29 = new JPanel();
		panel_29.setOpaque(false);
		field9.add(panel_29, BorderLayout.SOUTH);
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
		scrollPane2.setPreferredSize(new Dimension(800, 460));
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
		teachertable.getTableHeader().setReorderingAllowed(false);
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

		PublishMain.setName("Publish Panel");
		PublishMain.setOpaque(false);
		
		mainPanel.add(PublishMain, "Publish Panel");
		PublishMain.setLayout(new MigLayout("fill, insets 20 150 20 200", "[grow 5][grow 20][grow]", "[grow 15]20[grow][grow][grow][grow][grow][grow 10][grow][grow][grow]25[grow 50][]"));
		PublishTitle.setFont(new Font("Arial Black", Font.PLAIN, 20));
		PublishTitle.setForeground(Color.WHITE);
		
		PublishMain.add(PublishTitle, "cell 0 0 2 1");
		
		JLabel SeminarTitle = new JLabel("Seminar Title:");
		SeminarTitle.setFont(new Font("Arial", Font.BOLD, 15));
		SeminarTitle.setForeground(Color.WHITE);
		SeminarTitle.setHorizontalTextPosition(SwingConstants.LEFT);
		SeminarTitle.setHorizontalAlignment(SwingConstants.LEFT);
		PublishMain.add(SeminarTitle, "cell 1 1");
		
		Seminar = new JTextField();
		Seminar.setFont(new Font("Arial", Font.PLAIN, 13));
		PublishMain.add(Seminar, "cell 2 1,growx");
		Seminar.setColumns(10);
		
		JLabel CollegeTitle = new JLabel("College:");
		CollegeTitle.setFont(new Font("Arial", Font.BOLD, 15));
		CollegeTitle.setForeground(Color.WHITE);
		CollegeTitle.setHorizontalTextPosition(SwingConstants.LEFT);
		CollegeTitle.setHorizontalAlignment(SwingConstants.LEFT);
		PublishMain.add(CollegeTitle, "cell 1 2,alignx left");
		CollegeComboBox.setFont(new Font("Arial", Font.PLAIN, 13));
		
		PublishMain.add(CollegeComboBox, "cell 2 2,growx");
		
		JLabel SpecTitle = new JLabel("Specialization:");
		SpecTitle.setForeground(Color.WHITE);
		SpecTitle.setFont(new Font("Arial", Font.BOLD, 15));
		SpecTitle.setHorizontalTextPosition(SwingConstants.LEFT);
		SpecTitle.setHorizontalAlignment(SwingConstants.LEFT);
		PublishMain.add(SpecTitle, "cell 1 3,alignx left");
		SpecComboBox.setFont(new Font("Arial", Font.PLAIN, 13));
		
		PublishMain.add(SpecComboBox, "cell 2 3,growx");
		
		JLabel DateTitle = new JLabel("Date of Activity:");
		DateTitle.setFont(new Font("Arial", Font.BOLD, 15));
		DateTitle.setForeground(Color.WHITE);
		DateTitle.setHorizontalTextPosition(SwingConstants.LEFT);
		DateTitle.setHorizontalAlignment(SwingConstants.LEFT);
		PublishMain.add(DateTitle, "cell 1 4");
		dateOfActChooser.setPreferredSize(new Dimension(73, 15));
		dateOfActChooser.setMinimumSize(new Dimension(28, 20));
		
		PublishMain.add(dateOfActChooser, "cell 2 4,growx");
		
		JLabel VenueTitle = new JLabel("Venue:");
		VenueTitle.setFont(new Font("Arial", Font.BOLD, 15));
		VenueTitle.setForeground(Color.WHITE);
		VenueTitle.setHorizontalTextPosition(SwingConstants.LEFT);
		VenueTitle.setHorizontalAlignment(SwingConstants.LEFT);
		PublishMain.add(VenueTitle, "cell 1 5,alignx left");
		
		PublishMain.add(SpeakerVenue, "cell 2 5,growx");
		DetailsTitle.setFont(new Font("Arial", Font.BOLD, 16));
		DetailsTitle.setForeground(Color.WHITE);
		
		PublishMain.add(DetailsTitle, "cell 1 6");
		
		JLabel FNTitle = new JLabel("        Speaker's First Name:");
		FNTitle.setFont(new Font("Arial", Font.BOLD, 15));
		FNTitle.setForeground(Color.WHITE);
		FNTitle.setHorizontalTextPosition(SwingConstants.LEFT);
		FNTitle.setHorizontalAlignment(SwingConstants.LEFT);
		PublishMain.add(FNTitle, "cell 1 7,alignx left");
		
		PublishMain.add(SpeakerFN, "cell 2 7,growx");
		
		JLabel LNTItle = new JLabel("        Speaker's Last Name:");
		LNTItle.setFont(new Font("Arial", Font.BOLD, 15));
		LNTItle.setForeground(Color.WHITE);
		LNTItle.setHorizontalTextPosition(SwingConstants.LEFT);
		LNTItle.setHorizontalAlignment(SwingConstants.LEFT);
		PublishMain.add(LNTItle, "cell 1 8,alignx left");
		
		PublishMain.add(SpeakerLN, "cell 2 8,growx");
		
		JLabel SpeakerSpecTitle = new JLabel("        Speaker's Specialization:");
		SpeakerSpecTitle.setForeground(Color.WHITE);
		SpeakerSpecTitle.setFont(new Font("Arial", Font.BOLD, 15));
		SpeakerSpecTitle.setHorizontalTextPosition(SwingConstants.LEFT);
		SpeakerSpecTitle.setHorizontalAlignment(SwingConstants.LEFT);
		PublishMain.add(SpeakerSpecTitle, "cell 1 9,alignx left");
		SpeakerSpec.setFont(new Font("Arial", Font.PLAIN, 13));
		
		PublishMain.add(SpeakerSpec, "cell 2 9,growx");
		panel_11.setOpaque(false);
		
		
		CollegeComboBox.setSelectedItem(null);
		CollegeComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					if(CollegeComboBox.getSelectedItem().equals("Business and Accountancy")) {
						SpecComboBox.removeAllItems();
						SpecComboBox.addItem("Finance");
						SpecComboBox.addItem("Accounting");
						SpecComboBox.addItem("Marketing");
						SpecComboBox.addItem("Management");
						SpecComboBox.addItem("Management Accounting");
						SpecComboBox.addItem("Entrepreneurship");
						SpecComboBox.addItem("Business Analytics");
						SpecComboBox.addItem("Taxation");
						SpecComboBox.addItem("Economics");
						SpecComboBox.setSelectedItem(null);
					} else if(CollegeComboBox.getSelectedItem().equals("Customs Administration")) { 
						SpecComboBox.removeAllItems();
						SpecComboBox.addItem("Customs Compliance");
						SpecComboBox.addItem("Trade Facilitation");
						SpecComboBox.addItem("Tariff Classification");
						SpecComboBox.addItem("Customs Valuation");
						SpecComboBox.addItem("Customs Risk Management");
						SpecComboBox.addItem("International Trade Agreements");
						SpecComboBox.setSelectedItem(null);
					} else if(CollegeComboBox.getSelectedItem().equals("Law and Criminal Justice")) {
						SpecComboBox.removeAllItems();
						SpecComboBox.addItem("Law");
						SpecComboBox.addItem("Criminal Justice");
						SpecComboBox.addItem("Criminology");
						SpecComboBox.addItem("Legal Studies");
						SpecComboBox.addItem("Forensic Science");
						SpecComboBox.addItem("Cybersecurity");
						SpecComboBox.setSelectedItem(null);
					} else if(CollegeComboBox.getSelectedItem().equals( "Computer Studies")) {
						SpecComboBox.removeAllItems();
						SpecComboBox.addItem("Computer Science");
						SpecComboBox.addItem("Software Engineering");
						SpecComboBox.addItem("Cybersecurity");
						SpecComboBox.addItem("Data Science");
						SpecComboBox.addItem("Information Technology");
						SpecComboBox.addItem("Database Administration");
						SpecComboBox.addItem("Network Administration");
						SpecComboBox.addItem("IT Project Management");
						SpecComboBox.addItem("Machine Learning");
						SpecComboBox.setSelectedItem(null);
					} else if(CollegeComboBox.getSelectedItem().equals("Hospitality and Tourism Management")) {
						SpecComboBox.removeAllItems();
						SpecComboBox.addItem("Hotel Management");
						SpecComboBox.addItem("Restaurant Management");
						SpecComboBox.addItem("Travel and Tourism Management");
						SpecComboBox.addItem("Revenue and Yield Management");
						SpecComboBox.addItem("Sustainable Tourism Management");
						SpecComboBox.addItem("Resort Management");
						SpecComboBox.setSelectedItem(null);
					} else if(CollegeComboBox.getSelectedItem().equals( "Marine Engineering")) {
						SpecComboBox.removeAllItems();
						SpecComboBox.addItem("Marine Propulsion Systems");
						SpecComboBox.addItem("Marine Power Systems");
						SpecComboBox.addItem("Marine Systems Engineering");
						SpecComboBox.addItem("Marine Materials and Corrosion Engineering");
						SpecComboBox.addItem("Marine Safety and Risk Assessment");
						SpecComboBox.addItem("Offshore Engineering");
						SpecComboBox.setSelectedItem(null);
					} else if(CollegeComboBox.getSelectedItem().equals( "Marine Transportation")) {
						SpecComboBox.removeAllItems();
						SpecComboBox.addItem("Ship Navigation and Operations");
						SpecComboBox.addItem("Ship Management and Operations");
						SpecComboBox.addItem("Port and Terminal Operations");
						SpecComboBox.addItem("Maritime Law and Regulations");
						SpecComboBox.addItem("Maritime Safety and Environmental Protection");
						SpecComboBox.addItem("Maritime Business and Logistics");
						SpecComboBox.setSelectedItem(null);
					} else if(CollegeComboBox.getSelectedItem().equals( "Teacher Education")) {
						SpecComboBox.removeAllItems();
						SpecComboBox.addItem("Elementary Education");
						SpecComboBox.addItem("Secondary Education");
						SpecComboBox.addItem("Special Education");
						SpecComboBox.addItem("Higher Education Administration");
						SpecComboBox.addItem("Early Childhood Education");
						SpecComboBox.addItem("English as a Second Language (ESL)");
						SpecComboBox.setSelectedItem(null);
					} else if(CollegeComboBox.getSelectedItem().equals( "Nursing")) {
						SpecComboBox.removeAllItems();
						SpecComboBox.addItem("Pediatric Nursing");
						SpecComboBox.addItem("Geriatric Nursing");
						SpecComboBox.addItem("Obstetric and Gynecological Nursing");
						SpecComboBox.addItem("Critical Care Nursing");
						SpecComboBox.addItem("Medical-Surgical Nursing");
						SpecComboBox.addItem("Emergency Nursing");
						SpecComboBox.setSelectedItem(null);
					} else if(CollegeComboBox.getSelectedItem().equals( "Engineering")) {
						SpecComboBox.removeAllItems();
						SpecComboBox.addItem("Civil Engineering");
						SpecComboBox.addItem("Mechanical Engineering");
						SpecComboBox.addItem("Electrical Engineering");
						SpecComboBox.addItem("Aerospace Engineering");
						SpecComboBox.addItem("Chemical Engineering");
						SpecComboBox.addItem("Industrial Engineering");
						SpecComboBox.setSelectedItem(null);
					}
				} catch(Exception exc) {
					System.out.println(exc);
				}
			}
		});
		
		SpeakerSpec.addItem("Finance");
		SpeakerSpec.addItem("Accounting");
		SpeakerSpec.addItem("Marketing");
		SpeakerSpec.addItem("Management");
		SpeakerSpec.addItem("Management Accounting");
		SpeakerSpec.addItem("Entrepreneurship");
		SpeakerSpec.addItem("Business Analytics");
		SpeakerSpec.addItem("Taxation");
		SpeakerSpec.addItem("Economics");
		SpeakerSpec.addItem("Customs Compliance");
		SpeakerSpec.addItem("Trade Facilitation");
		SpeakerSpec.addItem("Tariff Classification");
		SpeakerSpec.addItem("Customs Valuation");
		SpeakerSpec.addItem("Customs Risk Management");
		SpeakerSpec.addItem("International Trade Agreements");
		SpeakerSpec.addItem("Law");
		SpeakerSpec.addItem("Criminal Justice");
		SpeakerSpec.addItem("Criminology");
		SpeakerSpec.addItem("Legal Studies");
		SpeakerSpec.addItem("Forensic Science");
		SpeakerSpec.addItem("Cybersecurity");
		SpeakerSpec.addItem("Computer Science");
		SpeakerSpec.addItem("Software Engineering");
		SpeakerSpec.addItem("Cybersecurity");
		SpeakerSpec.addItem("Data Science");
		SpeakerSpec.addItem("Information Technology");
		SpeakerSpec.addItem("Database Administration");
		SpeakerSpec.addItem("Network Administration");
		SpeakerSpec.addItem("IT Project Management");
		SpeakerSpec.addItem("Machine Learning");
		SpeakerSpec.addItem("Hotel Management");
		SpeakerSpec.addItem("Restaurant Management");
		SpeakerSpec.addItem("Travel and Tourism Management");
		SpeakerSpec.addItem("Revenue and Yield Management");
		SpeakerSpec.addItem("Sustainable Tourism Management");
		SpeakerSpec.addItem("Resort Management");
		SpeakerSpec.addItem("Marine Propulsion Systems");
		SpeakerSpec.addItem("Marine Power Systems");
		SpeakerSpec.addItem("Marine Systems Engineering");
		SpeakerSpec.addItem("Marine Materials and Corrosion Engineering");
		SpeakerSpec.addItem("Marine Safety and Risk Assessment");
		SpeakerSpec.addItem("Offshore Engineering");
		SpeakerSpec.addItem("Ship Navigation and Operations");
		SpeakerSpec.addItem("Ship Management and Operations");
		SpeakerSpec.addItem("Port and Terminal Operations");
		SpeakerSpec.addItem("Maritime Law and Regulations");
		SpeakerSpec.addItem("Maritime Safety and Environmental Protection");
		SpeakerSpec.addItem("Maritime Business and Logistics");
		SpeakerSpec.addItem("Elementary Education");
		SpeakerSpec.addItem("Secondary Education");
		SpeakerSpec.addItem("Special Education");
		SpeakerSpec.addItem("Higher Education Administration");
		SpeakerSpec.addItem("Early Childhood Education");
		SpeakerSpec.addItem("English as a Second Language (ESL)");
		SpeakerSpec.addItem("Pediatric Nursing");
		SpeakerSpec.addItem("Geriatric Nursing");
		SpeakerSpec.addItem("Obstetric and Gynecological Nursing");
		SpeakerSpec.addItem("Critical Care Nursing");
		SpeakerSpec.addItem("Medical-Surgical Nursing");
		SpeakerSpec.addItem("Emergency Nursing");
		SpeakerSpec.addItem("Civil Engineering");
		SpeakerSpec.addItem("Mechanical Engineering");
		SpeakerSpec.addItem("Electrical Engineering");
		SpeakerSpec.addItem("Aerospace Engineering");
		SpeakerSpec.addItem("Chemical Engineering");
		SpeakerSpec.addItem("Industrial Engineering");
		SpeakerSpec.setSelectedItem(null);
		
		
		PublishMain.add(panel_11, "cell 1 10 2 1,grow");
		SubmitPanel.setOpaque(false);
		SubmitPanel.setPreferredSize(new Dimension(300, 50));
		
		panel_11.add(SubmitPanel);
		SubmitPanel.setLayout(new BorderLayout(0, 0));
		btnSubmit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!alreadyExist(Seminar.getText())) {
					if((dateOfActChooser.getDate() != null) && !Seminar.getText().equals("") && !SpeakerVenue.getText().equals("") && !SpeakerFN.getText().equals("") && !SpeakerLN.getText().equals("") &&  CollegeComboBox.getSelectedItem() != null &&  SpecComboBox.getSelectedItem() != null &&  SpeakerSpec.getSelectedItem() != null) {
						 try (BufferedWriter writer = new BufferedWriter(new FileWriter(seminarData, true))) {
							 	writer.newLine();
					            writer.write(dateFormat.format(dateOfActChooser.getDate()) + "," + Seminar.getText() + "," + CollegeComboBox.getSelectedItem() + "," + SpecComboBox.getSelectedItem() + ","
					                    + SpeakerVenue.getText() + "," + SpeakerFN.getText() + "," + SpeakerLN.getText() + "," + SpeakerSpec.getSelectedItem());
					            writer.flush();
					            loadSeminarTableData(seminarData, SeminartblModel);
					            loadSpeakerTableData(seminarData, SpeakertblModel);
					            seminartable.repaint();
					            speakertable.repaint();
					            loadTableData(searchData, SearchtblModel);
					            searchtable.repaint();
					            searchtable.revalidate();
					            JOptionPane.showMessageDialog(null, "Seminar successfully added!");
					        } catch (IOException ex) {
					            ex.printStackTrace();
					        }
					} else {
						JOptionPane.showMessageDialog(null, "Enter missing details.", "Error message", JOptionPane.ERROR_MESSAGE);
					}
				} 
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnSubmit.setForeground(Color.red);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnSubmit.setForeground(Color.white);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				btnSubmit.setForeground(Color.red);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				btnSubmit.setForeground(Color.white);
			}
		});
		btnSubmit.setFont(new Font("Arial", Font.BOLD, 22));
		btnSubmit.setForeground(Color.WHITE);
		btnSubmit.setHorizontalAlignment(SwingConstants.CENTER);
		
		SubmitPanel.add(btnSubmit, BorderLayout.CENTER);
		
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
		topTeacher.setPreferredSize(new Dimension(10, 100));
		topTeacher.setOpaque(false);
		topTeacher.setLayout(new MigLayout("fill, insets 50 150 50 150", "[grow 50]250[grow 250]10[grow]", "[grow]"));
		TeacherMain.add(topTeacher, BorderLayout.NORTH);
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setFont(new Font("Lucida Sans Unicode", Font.BOLD, 20));
		
		topTeacher.add(lblNewLabel_6, "cell 0 0");
		SearchTeachers.setOpaque(false);
		
		topTeacher.add(SearchTeachers, "cell 1 0,grow");
		SearchTeachers.setLayout(new BorderLayout(0, 0));
		SearchTeachersIcon.setPreferredSize(new Dimension(30, 0));
		SearchTeachersIcon.setIcon(new ImageIcon(MainFrame.class.getResource("/Project/icons/searchLightSmall.png")));
		
		SearchTeachers.add(SearchTeachersIcon, BorderLayout.EAST);
		
		SearchTeachers.add(txtSearchTeachers, BorderLayout.CENTER);
		panel_15.setOpaque(false);
		panel_15.setPreferredSize(new Dimension(15, 10));
		
		SearchTeachers.add(panel_15, BorderLayout.WEST);
		filterSearchTeachers.setOpaque(false);
		
		topTeacher.add(filterSearchTeachers, "cell 2 0,grow");
		filterSearchTeachers.setLayout(new BorderLayout(0, 0));
		filterTeachers.setHorizontalAlignment(SwingConstants.CENTER);
		filterTeachers.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 14));
		filterTeachers.setForeground(Color.WHITE);
		
		filterSearchTeachers.add(filterTeachers, BorderLayout.CENTER);
		
		JPanel bottomTeacher = new JPanel();
		bottomTeacher.setPreferredSize(new Dimension(10, 25));
		bottomTeacher.setOpaque(false);
		TeacherMain.add(bottomTeacher, BorderLayout.SOUTH);
		
		JPanel TeacherCenter = new JPanel();
		TeacherCenter.setOpaque(false);
		TeacherCenter.setLayout(new MigLayout("fill, insets 20 100 20 100", "[grow]", "[grow]"));
		TeacherMain.add(TeacherCenter, BorderLayout.CENTER);
		
		TeacherCenter.add(scrollPane2, "cell 0 0,grow");
		teachertable.setPreferredScrollableViewportSize(new Dimension(800, 500));
		teachertable.setModel(TeachertblModel);
		scrollPane2.setViewportView(teachertable);
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
		scrollPane3.setViewportView(speakertable);
		searchtable.fixTable(scrollPane);
		seminartable.fixTable(scrollPane1);
		teachertable.fixTable(scrollPane2);
		speakertable.fixTable(scrollPane3);
		
		
		CCADashboardMain.setRequestFocusEnabled(false);
		CCADashboardMain.setOpaque(false);
		CCADashboardMain.setName("CCA Dashboard Panel");
		CCADashboardMain.setFocusable(false);
		CCADashboardMain.setBorder(null);
		CCADashboardMain.setLayout(new MigLayout("fill, inset 20 70 20 50", "[grow]30[grow]30[grow]", "[grow 35][grow 40]20[grow]10[grow]10[grow]"));
		
		
		
		CCJDashboardMain.setRequestFocusEnabled(false);
		CCJDashboardMain.setOpaque(false);
		CCJDashboardMain.setName("CCJ Dashboard Panel");
		CCJDashboardMain.setFocusable(false);
		CCJDashboardMain.setBorder(null);
		CCJDashboardMain.setLayout(new MigLayout("fill, inset 20 70 20 50", "[grow]30[grow]30[grow]", "[grow 35][grow 40]20[grow]10[grow]10[grow]"));
		
		
		CBADashboardMain.setRequestFocusEnabled(false);
		CBADashboardMain.setOpaque(false);
		CBADashboardMain.setName("CBA Dashboard Panel");
		CBADashboardMain.setFocusable(false);
		CBADashboardMain.setBorder(null);
		CBADashboardMain.setLayout(new MigLayout("fill, inset 20 70 20 50", "[grow]30[grow]30[grow]", "[grow 35][grow 40]20[grow]10[grow]10[grow]"));
		
		
		CHTMDashboardMain.setRequestFocusEnabled(false);
		CHTMDashboardMain.setOpaque(false);
		CHTMDashboardMain.setName("CHTM Dashboard Panel");
		CHTMDashboardMain.setFocusable(false);
		CHTMDashboardMain.setBorder(null);
		CHTMDashboardMain.setLayout(new MigLayout("fill, inset 20 70 20 50", "[grow]30[grow]30[grow]", "[grow 35][grow 40]20[grow]10[grow]10[grow]"));
		
		
		
		
		CMEDashboardMain.setRequestFocusEnabled(false);
		CMEDashboardMain.setOpaque(false);
		CMEDashboardMain.setName("CME Dashboard Panel");
		CMEDashboardMain.setFocusable(false);
		CMEDashboardMain.setBorder(null);
		CMEDashboardMain.setLayout(new MigLayout("fill, inset 20 70 20 50", "[grow]30[grow]30[grow]", "[grow 35][grow 40]20[grow]10[grow]10[grow]"));
		
		
		
		
		CNDashboardMain.setRequestFocusEnabled(false);
		CNDashboardMain.setOpaque(false);
		CNDashboardMain.setName("CN Dashboard Panel");
		CNDashboardMain.setFocusable(false);
		CNDashboardMain.setBorder(null);
		CNDashboardMain.setLayout(new MigLayout("fill, inset 20 70 20 50", "[grow]30[grow]30[grow]", "[grow 35][grow 40]20[grow]10[grow]10[grow]"));
		
		
		
		
		CMTDashboardMain.setRequestFocusEnabled(false);
		CMTDashboardMain.setOpaque(false);
		CMTDashboardMain.setName("CMT Dashboard Panel");
		CMTDashboardMain.setFocusable(false);
		CMTDashboardMain.setBorder(null);
		CMTDashboardMain.setLayout(new MigLayout("fill, inset 20 70 20 50", "[grow]30[grow]30[grow]", "[grow 35][grow 40]20[grow]10[grow]10[grow]"));
		
		
		
		
		COEDashboardMain.setRequestFocusEnabled(false);
		COEDashboardMain.setOpaque(false);
		COEDashboardMain.setName("COE Dashboard Panel");
		COEDashboardMain.setFocusable(false);
		COEDashboardMain.setBorder(null);
		COEDashboardMain.setLayout(new MigLayout("fill, inset 20 70 20 50", "[grow]30[grow]30[grow]", "[grow 35][grow 40]20[grow]10[grow]10[grow]"));
		
		
		
		
		CTEDashboardMain.setRequestFocusEnabled(false);
		CTEDashboardMain.setOpaque(false);
		CTEDashboardMain.setName("CTE Dashboard Panel");
		CTEDashboardMain.setFocusable(false);
		CTEDashboardMain.setBorder(null);
		CTEDashboardMain.setLayout(new MigLayout("fill, inset 20 70 20 50", "[grow]30[grow]30[grow]", "[grow 35][grow 40]20[grow]10[grow]10[grow]"));
		
		
		
		
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
		            
		            SeminarDetailsFrame secondFrame = new SeminarDetailsFrame(date, title, specialization);
                    secondFrame.setVisible(true);
		        }
		    }
		});
		
		teachertable.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        if (e.getClickCount() == 1) {
		            int row = teachertable.getSelectedRow();
		            String id = teachertable.getValueAt(row, 0).toString();
		            String name = teachertable.getValueAt(row, 1).toString();
		            String specialization = teachertable.getValueAt(row, 2).toString();
		            
		            TeacherDetailsFrame secondFrame = new TeacherDetailsFrame(id, name, specialization);
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
		            
		            SpeakerDetailsFrame secondFrame = new SpeakerDetailsFrame(id, name, specialization);
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
}
