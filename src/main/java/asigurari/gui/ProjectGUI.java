package asigurari.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by andreea on 27.10.2016.
 */
public class ProjectGUI extends JFrame implements ActionListener{

    protected JLabel orasLabel;
    protected JTextField orasTextField;
    protected JLabel stradaLabel;
    protected JTextField stradaTextField;
    protected JLabel numarLabel;
    protected JTextField numarTextField;
    protected JLabel apartmentLabel;
    protected JTextField apartmentTextField;


    @Override
    public void actionPerformed(ActionEvent e) {
        ((Command)e.getSource()).execute();
    }
}
