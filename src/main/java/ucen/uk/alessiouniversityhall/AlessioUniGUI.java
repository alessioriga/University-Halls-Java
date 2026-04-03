package ucen.uk.alessiouniversityhall;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.time.LocalDateTime;


/**
 * This class provides the graphical user interface for the university hall system.
 * It allows users to add students and employees, view records,
 * save data to a file, and load existing records.
 *
 * @author Alessio
 */
public class AlessioUniGUI {

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
    private final JTextField salaryField;

    private final JComboBox<String> courseBox;
    private final JComboBox<String> dietBox;
    private final JComboBox<String> roleBox;

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
        roleBox.setEnabled(!isStudent);
        salaryField.setEnabled(!isStudent);
    }

    /**
     * Constructs the application GUI and initialises all components.
     */
    public AlessioUniGUI() {

        JFrame frame = new JFrame("Alessio University App");
        frame.setSize(900, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        displayArea = new JTextArea();
        displayArea.setEditable(false);
        displayArea.setLineWrap(true);

// FORM PANEL

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(16, 2, 10, 10));

        nameField = new JTextField();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        dobField = new JFormattedTextField(format);
        dobField.setColumns(10);
        nationalityField = new JTextField();
        idField = new JTextField();
        phoneField = new JTextField();
        yearField = new JTextField();
        rentField = new JTextField();
        salaryField = new JTextField();

        JRadioButton studentRadio = new JRadioButton("Student");
        JRadioButton employeeRadio = new JRadioButton("Employee");

        JRadioButton male = new JRadioButton("Male");
        JRadioButton female = new JRadioButton("Female");

        genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);

        groundFloorBox = new JCheckBox("Ground Floor Needed");

        studentRadio.addActionListener(e -> {

            boolean hasData =
                    !nameField.getText().isEmpty() ||
                            !dobField.getText().isEmpty() ||
                            !nationalityField.getText().isEmpty();

            if (hasData) {

                int confirm = JOptionPane.showConfirmDialog(
                        frame,
                        "Clear current form?",
                        "Switch to Student",
                        JOptionPane.YES_NO_OPTION
                );

                if (confirm == JOptionPane.YES_OPTION) {

                    clearForm(
                            nameField,
                            dobField,
                            nationalityField,
                            idField,
                            phoneField,
                            yearField,
                            rentField,
                            salaryField,
                            groundFloorBox
                    );

                    updateFieldState(true);
                }

            } else {

                updateFieldState(true);
            }
        });

        employeeRadio.addActionListener(e -> {

            boolean hasData =
                    !nameField.getText().isEmpty() ||
                            !dobField.getText().isEmpty() ||
                            !nationalityField.getText().isEmpty();

            if (hasData) {

                int confirm = JOptionPane.showConfirmDialog(
                        frame,
                        "Clear current form?",
                        "Switch to Employee",
                        JOptionPane.YES_NO_OPTION
                );

                if (confirm == JOptionPane.YES_OPTION) {

                    clearForm(
                            nameField,
                            dobField,
                            nationalityField,
                            idField,
                            phoneField,
                            yearField,
                            rentField,
                            salaryField,
                            groundFloorBox
                    );

                    updateFieldState(false);
                }

            } else {

                updateFieldState(false);
            }
        });

        typeGroup = new ButtonGroup();
        typeGroup.add(studentRadio);
        typeGroup.add(employeeRadio);



        String[] courses = {"Software Engineer", "Network Engineer", "Cyber Security"};
        courseBox = new JComboBox<>(courses);

        String[] diets = {"Mixed", "Halal", "Vegetarian", "Vegan"};
        dietBox = new JComboBox<>(diets);

        String[] roles = {"Professor", "PhD Student", "HR Manager", "Cleaner", "Career Advisor", "President", "IT Technician"};
        roleBox = new JComboBox<>(roles);

        // add fields
        formPanel.add(new JLabel("Person Type"));
        formPanel.add(studentRadio);
        formPanel.add(new JLabel(""));
        formPanel.add(employeeRadio);

        formPanel.add(new JLabel("Full Name"));
        formPanel.add(nameField);

        formPanel.add(new JLabel("DOB (dd/MM/yyyy)"));
        formPanel.add(dobField);

        formPanel.add(new JLabel("Nationality"));
        formPanel.add(nationalityField);

        formPanel.add(new JLabel("Gender"));
        formPanel.add(male);
        formPanel.add(new JLabel(""));
        formPanel.add(female);

        formPanel.add(new JLabel("ID"));
        formPanel.add(idField);

        formPanel.add(new JLabel("Phone"));
        formPanel.add(phoneField);

        formPanel.add(new JLabel("Course"));
        formPanel.add(courseBox);

        formPanel.add(new JLabel("Year of Study"));
        formPanel.add(yearField);

        formPanel.add(new JLabel("Diet"));
        formPanel.add(dietBox);

        formPanel.add(new JLabel("Rent (£)"));
        formPanel.add(rentField);

        formPanel.add(new JLabel("Ground Floor"));
        formPanel.add(groundFloorBox);

        formPanel.add(new JLabel("Employee Role"));
        formPanel.add(roleBox);

        formPanel.add(new JLabel("Salary (£)"));
        formPanel.add(salaryField);

// BUTTONS

        JButton addBtn = new JButton("Add Person");
        JButton nextBtn = new JButton("Next Record");
        JButton saveBtn = new JButton("Save File");
        JButton loadBtn = new JButton("Load File");
        JButton clearBtn = new JButton("Clear");

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 1, 10, 10));

        buttonPanel.add(addBtn);
        buttonPanel.add(nextBtn);
        buttonPanel.add(saveBtn);
        buttonPanel.add(loadBtn);
        buttonPanel.add(clearBtn);

        JSplitPane split = new JSplitPane(
                JSplitPane.VERTICAL_SPLIT,
                new JScrollPane(formPanel),
                new JScrollPane(displayArea)
        );

        split.setDividerLocation(400);

        frame.add(split, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.WEST);

// ADD PERSON BUTTON

        addBtn.addActionListener(e -> {

            try {

                LocalDateTime dateTimeNow = LocalDateTime.now();

                if (nameField.getText().isEmpty())
                    throw new Exception("Name required");

                String gender = male.isSelected() ? "Male" : "Female";

                Hall hall;

                int yearDob = Integer.parseInt(dobField.getText().split("/")[2]);

                if (yearDob < 1940 || yearDob > 2026)
                    throw new Exception("Year mush be between 1940 and 2026");

                if (employeeRadio.isSelected()) {

                    hall = staffHall;

                    double salary = Double.parseDouble(salaryField.getText());

                    Employee emp = new Employee(
                            nameField.getText(),
                            dobField.getText(),
                            nationalityField.getText(),
                            gender,
                            hall,
                            dateTimeNow,
                            idField.getText(),
                            roleBox.getSelectedItem().toString(),
                            salary
                    );

                    store.addPerson(emp);
                    hall.addResident(emp);

                    JOptionPane.showMessageDialog(frame, "Employee Record Added");

                    clearForm(
                            nameField,
                            dobField,
                            nationalityField,
                            idField,
                            phoneField,
                            yearField,
                            rentField,
                            salaryField,
                            groundFloorBox
                    );

                } else {

                    int year = Integer.parseInt(yearField.getText());

                    if (year < 1 || year > 5)
                        throw new Exception("Year must be between 1-5");

                    double rent = Double.parseDouble(rentField.getText());

                    Payment payment = new Payment(rent);

                    String diet = dietBox.getSelectedItem().toString();

                    if (groundFloorBox.isSelected())
                        hall = groundHall;
                    else if (diet.equals("Vegan") || diet.equals("Vegetarian"))
                        hall = vvgHall;
                    else if (diet.equals("Halal"))
                        hall = halalHall;
                    else
                        hall = mainHall;

                    Student stu = new Student(
                            nameField.getText(),
                            dobField.getText(),
                            nationalityField.getText(),
                            gender,
                            hall,
                            dateTimeNow,
                            idField.getText(),
                            phoneField.getText(),
                            courseBox.getSelectedItem().toString(),
                            year,
                            diet,
                            groundFloorBox.isSelected(),
                            payment
                    );

                    store.addPerson(stu);
                    hall.addResident(stu);

                    JOptionPane.showMessageDialog(frame, "Student Record Added");

                    clearForm(
                            nameField,
                            dobField,
                            nationalityField,
                            idField,
                            phoneField,
                            yearField,
                            rentField,
                            salaryField,
                            groundFloorBox
                    );
                }

            } catch (Exception ex) {

                JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage());
            }

        });

// NEXT RECORD BUTTON

        nextBtn.addActionListener(e -> {

            Person p = store.getNextPerson();

            if (p == null)
                displayArea.setText("No records");
            else
                displayArea.setText(p.toString());
        });

// SAVE BUTTON

        saveBtn.addActionListener(e -> {

            try {

                ObjectOutputStream out =
                        new ObjectOutputStream(
                                new FileOutputStream(FILE_NAME));

                out.writeObject(store.getPeople());
                out.close();

                JOptionPane.showMessageDialog(frame, "Saved");

            } catch (Exception ex) {

                JOptionPane.showMessageDialog(frame, "Save error");
            }

        });

// LOAD BUTTON

        loadBtn.addActionListener(e -> {

            try {

                ObjectInputStream in =
                        new ObjectInputStream(
                                new FileInputStream(FILE_NAME));

                ArrayList<Person> list =
                        (ArrayList<Person>) in.readObject();

                store.setPeople(list);
                in.close();

                JOptionPane.showMessageDialog(frame, "Loaded");

            } catch (Exception ex) {

                JOptionPane.showMessageDialog(frame, "Load error");
            }

        });

// CLEAR BUTTON

        clearBtn.addActionListener(e -> {

            boolean hasData =
                    !nameField.getText().isEmpty() ||
                            !dobField.getText().isEmpty() ||
                            !nationalityField.getText().isEmpty() ||
                            !idField.getText().isEmpty() ||
                            !phoneField.getText().isEmpty() ||
                            !yearField.getText().isEmpty() ||
                            !rentField.getText().isEmpty() ||
                            !salaryField.getText().isEmpty() ||
                            groundFloorBox.isSelected();

            if (hasData) {

                int confirm = JOptionPane.showConfirmDialog(
                        frame,
                        "Clear current form?",
                        "Confirm Clear",
                        JOptionPane.YES_NO_OPTION
                );

                if (confirm == JOptionPane.YES_OPTION) {

                    clearForm(
                            nameField,
                            dobField,
                            nationalityField,
                            idField,
                            phoneField,
                            yearField,
                            rentField,
                            salaryField,
                            groundFloorBox
                    );
                }

            } else {

                JOptionPane.showMessageDialog(frame, "Form already empty");
            }
        });

        studentRadio.setSelected(true);
        updateFieldState(true);

        frame.setVisible(true);
    }
}