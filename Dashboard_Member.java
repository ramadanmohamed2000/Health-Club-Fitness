package HealthAndFitnessClub;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Dashboard_Member extends JFrame {

    private JPanel contentPane;
    private Profile_Member profilePage = null;
    private Home_Member homePage = null;
    private Session_Member sessionPage = null;
    private Classes_Member classesPage = null;
    private Goals_Member goalsPage = null;
    private Event_Member eventPage = null;
    private JPanel currentPage = null;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Dashboard_Member frame = new Dashboard_Member();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Dashboard_Member() {
    	profilePage = new Profile_Member();
    	homePage = new Home_Member();
    	sessionPage = new Session_Member();
    	classesPage = new Classes_Member();
    	goalsPage = new Goals_Member();
    	eventPage = new Event_Member();
        profilePage.setBounds(80, 0, 1000, 1000);
        homePage.setBounds(80, 0, 1000, 1000);
        sessionPage.setBounds(80, 0, 1000, 1000);
        classesPage.setBounds(80, 0, 1000, 1000);
        goalsPage.setBounds(80, 0, 1000, 1000);
        eventPage.setBounds(80, 0, 1000, 1000);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1010, 767);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btnProfile = new JButton("Profile");
        btnProfile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
                contentPane.remove(currentPage);
                contentPane.add(profilePage);
                currentPage = profilePage;
                profilePage.loadData();
                revalidate();
                repaint();
            }
        });
        btnProfile.setBounds(0, 0, 74, 63);
        contentPane.add(btnProfile);

        JButton btnHome = new JButton("Home");
        btnHome.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            	contentPane.remove(currentPage);
                contentPane.add(homePage);
                currentPage = homePage;
                homePage.loadData();
                revalidate();
                repaint();
            }
        });
        btnHome.setBounds(0, 68, 74, 63);
        contentPane.add(btnHome);

        JButton btnSessions = new JButton("Sessions");
        btnSessions.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                contentPane.remove(currentPage);
                contentPane.add(sessionPage);
                currentPage = sessionPage;
                sessionPage.loadData();
                revalidate();
                repaint();
            }
        });
        btnSessions.setBounds(0, 214, 74, 63);
        contentPane.add(btnSessions);

        JButton btnGoals = new JButton("Goals");
        btnGoals.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                contentPane.remove(currentPage);
                contentPane.add(goalsPage);
                currentPage = goalsPage;
                goalsPage.loadData();
                revalidate();
                repaint();
            }
        });
        btnGoals.setBounds(0, 141, 74, 63);
        contentPane.add(btnGoals);

        contentPane.add(profilePage);
        currentPage = profilePage;
    }
    public void loadData() {
    	profilePage.loadData();
    }
}
