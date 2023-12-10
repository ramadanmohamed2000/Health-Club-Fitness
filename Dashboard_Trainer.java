package HealthAndFitnessClub;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Dashboard_Trainer extends JFrame {

    private JPanel contentPane;
    private Profile_Trainer profilePage = null;
    private Classes_Trainer classesPage = null;
    private Equipment_Trainer equipmentPage = null;
    private Event_Trainer eventPage = null;
    private Members_Trainer membersPage = null;
    private Room_Trainer roomPage = null;
    private Sessions_Trainer sessionPage = null;
    private JPanel currentPage = null;
    private JButton btnEquipment;
    private JButton btnClasses;
    private JButton btnEvents;
    private JButton btnMembers;
    private JButton btnSessions;
    private JButton btnRooms;
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Dashboard_Trainer frame = new Dashboard_Trainer();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Dashboard_Trainer() {
        profilePage = new Profile_Trainer();
        classesPage = new Classes_Trainer();
        equipmentPage = new Equipment_Trainer();
        eventPage = new Event_Trainer();
        membersPage = new Members_Trainer();
        roomPage = new Room_Trainer();
        sessionPage = new Sessions_Trainer();

        profilePage.setBounds(80, 0, 1000, 1000);
        classesPage.setBounds(80, 0, 1000, 1000);
        equipmentPage.setBounds(80, 0, 1000, 1000);
        eventPage.setBounds(80, 0, 1000, 1000);
        membersPage.setBounds(80, 0, 1000, 1000);
        roomPage.setBounds(80, 0, 1000, 1000);
        sessionPage.setBounds(80, 0, 1000, 1000);

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

        btnClasses = new JButton("Classes");
        btnClasses.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                contentPane.remove(currentPage);
                contentPane.add(classesPage);
                currentPage = classesPage;
                classesPage.loadData();
                revalidate();
                repaint();
            }
        });
        btnClasses.setBounds(0, 68, 74, 63);
        contentPane.add(btnClasses);

        btnEquipment = new JButton("Equipment");
        btnEquipment.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                contentPane.remove(currentPage);
                contentPane.add(equipmentPage);
                currentPage = equipmentPage;
                equipmentPage.loadData();
                revalidate();
                repaint();
            }
        });
        btnEquipment.setBounds(0, 136, 74, 63);
        contentPane.add(btnEquipment);

        btnEvents = new JButton("Events");
        btnEvents.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                contentPane.remove(currentPage);
                contentPane.add(eventPage);
                currentPage = eventPage;
                eventPage.loadData();
                revalidate();
                repaint();
            }
        });
        btnEvents.setBounds(0, 204, 74, 63);
        contentPane.add(btnEvents);

        btnMembers = new JButton("Members");
        btnMembers.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                contentPane.remove(currentPage);
                contentPane.add(membersPage);
                currentPage = membersPage;
                membersPage.loadData();
                revalidate();
                repaint();
            }
        });
        btnMembers.setBounds(0, 272, 74, 63);
        contentPane.add(btnMembers);

        btnRooms = new JButton("Rooms");
        btnRooms.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                contentPane.remove(currentPage);
                contentPane.add(roomPage);
                currentPage = roomPage;
                roomPage.loadData();
                revalidate();
                repaint();
            }
        });
        btnRooms.setBounds(0, 340, 74, 63);
        contentPane.add(btnRooms);

        btnSessions = new JButton("Sessions");
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
        btnSessions.setBounds(0, 408, 74, 63);
        contentPane.add(btnSessions);

        contentPane.add(profilePage);
        currentPage = profilePage;
    }
    public void loadData() {
    	profilePage.loadData();
    	if(Data.role.equalsIgnoreCase("admin")) {
    		btnClasses.setEnabled(false);
    		btnMembers.setEnabled(false);
    		btnSessions.setEnabled(false);
    		
    	}
    	else {
    		btnEquipment.setEnabled(false);
    		btnEvents.setEnabled(false);
    		btnRooms.setEnabled(false);
    	}
    }
}
