package ucen.uk.alessiouniversityhall;

import javax.swing.*;
import java.awt.*;
import java.io.*;


/**
 * This class provides the graphical user interface for the university hall system.
 * It allows users to add students and employees, view records,
 * save data to a file, and load existing records.
 *
 * @author Alessio
 */
public class UniversityGUI {

    private final Store store = new Store();
    private static final String FILE_NAME = "residents.txt";
    private final JTextArea displayArea;

    private final ButtonGroup typeGroup;
    private final ButtonGroup genderGroup;

    private final JTextField nameField;
    private final JFormattedTextField dobField;
    private final JTextField nationalityField;
    private final JTextField idField;
    private final JTextField phoneField;
    private final JTextField yearField;
    private final JTextField rentField;
    private final JTextField roleField;
    private final JTextField salaryField;

    private final JComboBox<String> courseBox;
    private final JComboBox<String> dietBox;

    private final JCheckBox groundFloorBox;

    // halls
    private final Hall vvgHall = new Hall("VVG Hall", "Vegan/Vegetarian", false);
    private final Hall halalHall = new Hall("Halal Hall", "Halal", false);
    private final Hall mainHall = new Hall("Main Hall", "Mixed", false);
    private final Hall groundHall = new Hall("Ground Hall", "Ground Floor", true);
    private final Hall staffHall = new Hall("Staff Hall", "Staff", false);

    /**
     * Clears all input fields in the form.
     *
     * @param nameField full name field
     * @param dobField date of birth field
     * @param nationalityField nationality field
     * @param idField ID field
     * @param phoneField phone number field
     * @param yearField year of study field
     * @param rentField rent field
     * @param roleField employee role field
     * @param salaryField salary field
     * @param groundFloorBox ground floor checkbox
     */
    private void clearForm(
            JTextField nameField,
            JFormattedTextField dobField,
            JTextField nationalityField,
            JTextField idField,
            JTextField phoneField,
            JTextField yearField,
            JTextField rentField,
            JTextField roleField,
            JTextField salaryField,
            JCheckBox groundFloorBox
    ) {

        nameField.setText("");
        dobField.setText("");
        nationalityField.setText("");
        idField.setText("");
        phoneField.setText("");
        yearField.setText("");
        rentField.setText("");
        roleField.setText("");
        salaryField.setText("");

        genderGroup.clearSelection();
        typeGroup.clearSelection();
        groundFloorBox.setSelected(false);
    }

    /**
     * Enables or disables fields depending on person type.
     *
     * @param isStudent true if student fields should be enabled
     */
    private void updateFieldState(boolean isStudent) {

        // Student fields
        yearField.setEnabled(isStudent);
        rentField.setEnabled(isStudent);
        courseBox.setEnabled(isStudent);
        dietBox.setEnabled(isStudent);
        groundFloorBox.setEnabled(isStudent);

        // Employee fields
        roleField.setEnabled(!isStudent);
        salaryField.setEnabled(!isStudent);
    }

    /**
     * Constructs the university GUI and initialises all components.
     */
    public UniversityGUI() {

        JFrame frame = new JFrame("Alessio University App");
        frame.setSize(900, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        displayArea = new JTextArea();
        displayArea.setEditable(false);
        displayArea.setLineWrap(true);