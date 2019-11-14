import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;


class PasswordChecker extends JPanel
        implements ActionListener {
    private static String OK = "ok";
    private static String HELP = "help";

    private JFrame controllingFrame; //needed for dialogs
    private JPasswordField passwordField;

    public PasswordChecker(JFrame f) {
        //Use the default FlowLayout.
        controllingFrame = f;

        //Create everything.
        passwordField = new JPasswordField(10);
        passwordField.setActionCommand(OK);
        passwordField.addActionListener(this);

        JLabel label = new JLabel("Enter your password: ");
        label.setLabelFor(passwordField);

        JComponent buttonPane = createButtonPanel();

        //Lay out everything.
        JPanel textPane = new JPanel(new FlowLayout(FlowLayout.TRAILING));
        textPane.add(label);
        textPane.add(passwordField);

        add(textPane);
        add(buttonPane);
    }

    protected JComponent createButtonPanel() {
        JPanel p = new JPanel(new GridLayout(0,1));
        JButton okButton = new JButton("Check");
        JButton helpButton = new JButton("Help");

        okButton.setActionCommand(OK);
        helpButton.setActionCommand(HELP);
        okButton.addActionListener(this);
        helpButton.addActionListener(this);

        p.add(okButton);
        p.add(helpButton);

        return p;
    }

    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        if (OK.equals(cmd)) { //Process the password.
            char[] input = passwordField.getPassword();
            System.out.println("Invalid password combination : " + passwordField.getPassword());
            if (isPasswordCorrect(input)) {
                JOptionPane.showMessageDialog(controllingFrame,
                        "Success! Your password comply with company standards.");
            } else {
                JOptionPane.showMessageDialog(controllingFrame,
                        "Password does not meet standards. Try again.\n" +
                                "Minimum 8 characters in length.\n" +
                                "Contains the following items:\n" +
                                "- 2 Uppercase Letters\n" +
                                "- 2 Lowercase Letters\n" +
                                "- 2 Numbers",
                        "Error Message",
                        JOptionPane.ERROR_MESSAGE);
            }


            passwordField.selectAll();
            resetFocus();
        } else { //The user has asked for help.
            JOptionPane.showMessageDialog(controllingFrame,
                    "Minimum 8 characters in length\n" +
                            "Contains the following items:\n" +
                            "- 2 Uppercase Letters\n" +
                            "- 2 Lowercase Letters\n" +
                            "- 2 Numbers");
        }
    }

    /**
     * Checks the passed-in array.
     */
    private static boolean isPasswordCorrect(char[] input) {
        boolean isCorrect = true;
        int charUpperCount = 0;
        int charLowerCount = 0;
        int numCount = 0;

        if (input.length < 8) {
            return false;
        } else {
            for (char ch : input) {

                if (is_Numeric(ch)) numCount++;
                else if (is_Upper_Case(ch)) charUpperCount++;
                else if (is_Lower_Case(ch)) charLowerCount++;
                else return false;
            }
        }

        return (numCount >= 2 && charUpperCount >= 2 && charLowerCount >=2);
    }

    private static boolean is_Upper_Case(char ch) {
        return (ch >= 'A' && ch <= 'Z');
    }

    private static boolean is_Lower_Case(char ch) {
        return (ch >= 'a' && ch <= 'z');
    }

    private static boolean is_Numeric(char ch) {
        return (ch >= '0' && ch <= '9');
    }

    //Must be called from the event dispatch thread.
    protected void resetFocus() {
        passwordField.requestFocusInWindow();
    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event dispatch thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Password Checker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        final PasswordChecker newContentPane = new PasswordChecker(frame);
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

        //Make sure the focus goes to the right component
        //whenever the frame is initially given the focus.
        frame.addWindowListener(new WindowAdapter() {
            public void windowActivated(WindowEvent e) {
                newContentPane.resetFocus();
            }
        });

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                //Turn off metal's use of bold fonts
                UIManager.put("swing.boldMetal", Boolean.FALSE);
                createAndShowGUI();
            }
        });
    }
}
