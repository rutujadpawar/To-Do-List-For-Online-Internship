import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToDoListUI extends JFrame implements ActionListener {
    private DefaultListModel<String> toDoListModel;
    private JList<String> toDoList;
    private JTextField newItemField;

    public ToDoListUI() {
        // Frame setup
        setTitle("To-Do List");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 400);
        setLayout(new BorderLayout());

        // To-Do List Model
        toDoListModel = new DefaultListModel<>();
        toDoList = new JList<>(toDoListModel);

        // Scroll Pane for the List
        JScrollPane scrollPane = new JScrollPane(toDoList);
        add(scrollPane, BorderLayout.CENTER);

        // Panel for Text Field and Buttons
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());

        // Text Field for New Item
        newItemField = new JTextField(15);
        inputPanel.add(newItemField);

        // Buttons
        JButton addButton = new JButton("Add");
        addButton.addActionListener(this);
        inputPanel.add(addButton);

        JButton removeButton = new JButton("Remove");
        removeButton.addActionListener(this);
        inputPanel.add(removeButton);

        // Add components to the frame
        add(inputPanel, BorderLayout.SOUTH);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Add")) {
            String newItem = newItemField.getText();
            if (!newItem.isEmpty()) {
                toDoListModel.addElement(newItem);
                newItemField.setText("");
            }
        } else if (e.getActionCommand().equals("Remove")) {
            int selectedIndex = toDoList.getSelectedIndex();
            if (selectedIndex != -1) {
                toDoListModel.remove(selectedIndex);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ToDoListUI toDoListUI = new ToDoListUI();
            toDoListUI.setVisible(true);
        });
    }
}
