import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainFrame extends JFrame{
    private Container cp;
    private JButton btns[] = new JButton[9];
    private JTextField tf = new JTextField();
    private JPanel pan = new JPanel(new GridLayout(3,3,3,3));
    private LoginFrame log;
    public MainFrame(LoginFrame login){
        log = login;
        initComp();
    }
    private void initComp(){
        this.setBounds(100,100,500,500);
        cp = this.getContentPane();
        cp.setLayout(new BorderLayout(3,3));
        cp.add(tf, BorderLayout.NORTH);
        cp.add(pan, BorderLayout.CENTER);
        tf.setEditable(false);
        for(int i = 0; i < 9; i++){
            btns[i] = new JButton();
            pan.add(btns[i]);
            btns[i].setText(Integer.toString(i));
            btns[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton tmpBtn = (JButton) e.getSource();
                    tf.setText(tf.getText() + tmpBtn.getText());
                }
            });
        }

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                log.setVisible(true);
                dispose();
            }
        });
    }
}
