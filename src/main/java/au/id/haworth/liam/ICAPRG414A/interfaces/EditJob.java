package au.id.haworth.liam.ICAPRG414A.interfaces;

import au.id.haworth.liam.ICAPRG414A.Job;
import au.id.haworth.liam.ICAPRG414A.JobRegister;

import javax.swing.*;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This interface is used to
 * edit an existing jobs information
 *
 * @author Liam Haworth
 * @version 1.0
 */
public class EditJob extends JDialog {

    private final Job job;
    private final MainInterface parent;

    public EditJob(MainInterface parent, int jobID) {
        this.job = JobRegister.getJob(jobID);
        this.parent = parent;

        this.buildInterface();
    }

    private void buildInterface() {
        this.setTitle("Edit Job");

        JPanel mainContent = new JPanel();
        this.setContentPane(mainContent);

        JLabel clientFirstNameLabel = new JLabel("First Name:");
        JTextField clientFirstName = new JTextField(job.getName());

        JLabel clientSurnameLabel = new JLabel("Surname:");
        JTextField clientSurname = new JTextField(job.getSurname());

        JLabel clientAddressLabel = new JLabel("Address:");
        JTextField clientAddress = new JTextField(job.getAddress());

        JLabel clientSuburbLabel = new JLabel("Suburb:");
        JTextField clientSuburb = new JTextField(job.getSuburb());

        JLabel clientPostcodeLabel = new JLabel("Postcode:");
        JFormattedTextField clientPostcode = new JFormattedTextField(new DecimalFormat("####"));
        clientPostcode.setValue(job.getPostcode());

        JLabel completeDateLabel = new JLabel("Complete Date:");
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        JFormattedTextField completeDate = new JFormattedTextField(format);
        completeDate.setValue(job.getDate());

        JLabel hoursWorkedLabel = new JLabel("Hours On Job:");
        JSpinner hoursWorked = new JSpinner();
        hoursWorked.setValue(job.getHoursWorked());

        JLabel jobPriceLabel = new JLabel("Job Price:");
        JSpinner jobPrice = new JSpinner();
        jobPrice.setValue(job.getPrice());

        JLabel jobDetailsLabel = new JLabel("Job Details:");
        JTextArea jobDetails = new JTextArea(job.getJobDetails());
        JScrollPane jobDetailsPane = new JScrollPane(jobDetails);

        JCheckBox jobCompleted = new JCheckBox("Job Completed");
        jobCompleted.setSelected(job.isCompleted());

        JCheckBox jobPaid = new JCheckBox("Job Paid");
        jobPaid.setSelected(job.isPaid());

        JButton saveButton = new JButton("Save Changes");
        saveButton.addActionListener(e -> {
            try {
                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                Date completeDateValue = dateFormat.parse(completeDate.getText());

                int postcode, hours, price;

                if(clientPostcode.getValue() instanceof Long)
                    postcode = ((Long) clientPostcode.getValue()).intValue();
                else
                    postcode = (int) clientPostcode.getValue();

                if(hoursWorked.getValue() instanceof Long)
                    hours = ((Long) hoursWorked.getValue()).intValue();
                else
                    hours = (int) hoursWorked.getValue();

                if(jobPrice.getValue() instanceof Long)
                    price = ((Long) jobPrice.getValue()).intValue();
                else
                    price = (int) jobPrice.getValue();

                JobRegister.updateJob(job.getJobID(), clientFirstName.getText(), clientSurname.getText(), clientAddress.getText(), clientSuburb.getText(), postcode,
                                      completeDateValue, hours, jobDetails.getText(), jobCompleted.isSelected(), price, jobPaid.isSelected());

                parent.rebuildTable();

                dispose();
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "There was an error saving job", JOptionPane.ERROR_MESSAGE);
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "There was an error saving job", JOptionPane.ERROR_MESSAGE);
            }
        });

        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(e -> dispose());

        GroupLayout layout = new GroupLayout(this.getContentPane());
        getContentPane().setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addComponent(clientFirstNameLabel)
                        .addComponent(clientFirstName)
                        .addComponent(clientSurnameLabel)
                        .addComponent(clientSurname)
                )
                .addGroup(layout.createSequentialGroup()
                        .addComponent(clientAddressLabel)
                        .addComponent(clientAddress)
                )
                .addGroup(layout.createSequentialGroup()
                        .addComponent(clientSuburbLabel)
                        .addComponent(clientSuburb)
                        .addComponent(clientPostcodeLabel)
                        .addComponent(clientPostcode)
                )
                .addGroup(layout.createSequentialGroup()
                        .addComponent(jobDetailsLabel)
                        .addComponent(jobDetailsPane)
                )
                .addGroup(layout.createSequentialGroup()
                        .addComponent(completeDateLabel)
                        .addComponent(completeDate)
                        .addComponent(hoursWorkedLabel)
                        .addComponent(hoursWorked)
                )
                .addGroup(layout.createSequentialGroup()
                        .addComponent(jobPriceLabel)
                        .addComponent(jobPrice)
                        .addComponent(jobCompleted)
                        .addComponent(jobPaid)
                )
                .addGroup(layout.createSequentialGroup()
                        .addComponent(saveButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cancelButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                )
        );

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(clientFirstNameLabel)
                        .addComponent(clientFirstName)
                        .addComponent(clientSurnameLabel)
                        .addComponent(clientSurname)
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(clientAddressLabel)
                        .addComponent(clientAddress)
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(clientSuburbLabel)
                        .addComponent(clientSuburb)
                        .addComponent(clientPostcodeLabel)
                        .addComponent(clientPostcode)
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(jobDetailsLabel)
                        .addComponent(jobDetailsPane)
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(completeDateLabel)
                        .addComponent(completeDate)
                        .addComponent(hoursWorkedLabel)
                        .addComponent(hoursWorked)
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(jobPriceLabel)
                        .addComponent(jobPrice)
                        .addComponent(jobCompleted)
                        .addComponent(jobPaid)
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(saveButton)
                        .addComponent(cancelButton)
                )
        );
    }

    public void displayWindow() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setSize(640, 480);
        setVisible(true);
    }
}
