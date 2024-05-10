package CalculatorMMDC;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MilestoneCalculator extends JFrame {
    private JTextField nameField, studentNumberField, milestone1Field, milestone2Field, terminalAssessmentField;
    private JButton calculateButton;
    private int milestone2Width = 60;
    private int milestone2Height = 40;
    private int buttonWidth = 100;
    private int buttonHeight = 40;

    public MilestoneCalculator() {
        setTitle("Milestone Calculator");
        setSize(500, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(new Color(36, 37, 60)); // Set panel color to rgba(36,37,60,255)

        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new GridLayout(2, 2));
        infoPanel.setBackground(new Color(36, 37, 60)); // Set input panel color to rgba(36,37,60,255)
        infoPanel.setPreferredSize(new Dimension(300, 80)); // Set input panel size (width, height)

        JLabel nameLabel = new JLabel("Name: ");
        nameLabel.setForeground(Color.WHITE); // Set text color to white
        nameField = new JTextField();
        nameField.setPreferredSize(new Dimension(60, 20)); // Set text field size (width, height)
        infoPanel.add(nameLabel);
        infoPanel.add(nameField);

        JLabel studentNumberLabel = new JLabel("Student Number: ");
        studentNumberLabel.setForeground(Color.WHITE); // Set text color to white
        studentNumberField = new JTextField();
        studentNumberField.setPreferredSize(new Dimension(60, 20)); // Set text field size (width, height)
        infoPanel.add(studentNumberLabel);
        infoPanel.add(studentNumberField);

        panel.add(infoPanel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(3, 2));
        inputPanel.setBackground(new Color(36, 37, 60)); // Set input panel color to rgba(36,37,60,255)
        inputPanel.setPreferredSize(new Dimension(150, 120)); // Set input panel size (width, height)

        JLabel milestone1Label = new JLabel("Milestone (Up to 25 points): ");
        milestone1Label.setForeground(Color.WHITE); // Set text color to white
        milestone1Field = new JTextField();
        milestone1Field.setPreferredSize(new Dimension(60, 40)); // Set text field size (width, height)
        inputPanel.add(milestone1Label);
        inputPanel.add(milestone1Field);

        JLabel milestone2Label = new JLabel("Milestone (Up to 40 points): ");
        milestone2Label.setForeground(Color.WHITE); // Set text color to white
        milestone2Field = new JTextField();
        milestone2Field.setPreferredSize(new Dimension(milestone2Width, milestone2Height)); // Set text field size (width, height)
        inputPanel.add(milestone2Label);
        inputPanel.add(milestone2Field);

        JLabel terminalAssessmentLabel = new JLabel("Terminal Assessment (Up to 35 points): ");
        terminalAssessmentLabel.setForeground(Color.WHITE); // Set text color to white
        terminalAssessmentField = new JTextField();
        terminalAssessmentField.setPreferredSize(new Dimension(60, 40)); // Set text field size (width, height)
        inputPanel.add(terminalAssessmentLabel);
        inputPanel.add(terminalAssessmentField);

        panel.add(inputPanel, BorderLayout.CENTER);

        calculateButton = new JButton("Calculate");
        calculateButton.setForeground(new Color(229, 56, 84)); // Set button text color to #e53854
        calculateButton.setBorder(BorderFactory.createLineBorder(new Color(229, 56, 84), 2)); // Set button border color to #e53854
        calculateButton.setOpaque(false); // Make button background transparent
        calculateButton.setFocusPainted(false); // Remove button focus
        calculateButton.setPreferredSize(new Dimension(buttonWidth, buttonHeight)); // Set button size (width, height)
        calculateButton.addActionListener(new CalculateButtonListener());
        panel.add(calculateButton, BorderLayout.SOUTH);

        add(panel);
        setVisible(true);
    }

    public void setMilestone2FieldSize(int width, int height) {
        milestone2Width = width;
        milestone2Height = height;
        milestone2Field.setPreferredSize(new Dimension(width, height));
        revalidate();
    }

    public void setButtonSize(int width, int height) {
        buttonWidth = width;
        buttonHeight = height;
        calculateButton.setPreferredSize(new Dimension(width, height));
        revalidate();
    }

    private class CalculateButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                double milestone1 = Double.parseDouble(milestone1Field.getText());
                double milestone2 = Double.parseDouble(milestone2Field.getText());
                double terminalAssessment = Double.parseDouble(terminalAssessmentField.getText());

                if (milestone1 < 0 || milestone1 > 25 || milestone2 < 0 || milestone2 > 40 || terminalAssessment < 0 || terminalAssessment > 35) {
                    throw new IllegalArgumentException("Invalid input");
                }

                double milestone1Points = milestone1;
                double milestone2Points = milestone2;
                double terminalAssessmentPoints = terminalAssessment;

                double totalGrade = milestone1Points + milestone2Points + terminalAssessmentPoints;

                JOptionPane.showMessageDialog(null, "Total Grade: " + totalGrade);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Please enter valid numbers for each field.");
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(null, "Invalid input. Values should be between 0 and the maximum points per Milestone.");
            }
        }
    }

    public static void main(String[] args) {
        new MilestoneCalculator();
    }
}