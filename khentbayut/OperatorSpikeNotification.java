package khentbayut;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class OperatorSpikeNotification {

    private static final int RESIDENTIAL_SPIKE_THRESHOLD = 100;
    private static final int COMMERCIAL_SPIKE_THRESHOLD = 500;

    public static void checkAndNotifySpike() {
        Connection connection = null;
        Statement statement = null;
        try {
            Connect connect = new Connect();
            connection = connect.c;
            statement = connect.s;

            // Get all meter numbers
            List<String> meterNumbers = getAllMeterNumbers(statement);

            for (String meter : meterNumbers) {
                System.out.println("Checking meter: " + meter); // Debug log

                // Get all invoices for the meter number ordered by date and id_no
                List<InvoiceData> invoices = getInvoices(statement, meter);
                System.out.println("Invoices size for meter " + meter + ": " + invoices.size()); // Debug log

                if (invoices.size() < 2) {
                    System.out.println("Not enough invoices to compare for meter: " + meter); // Debug log
                    continue; // Not enough data to determine a spike for this meter
                }

                // Check for spikes between the last two invoices
                InvoiceData previousInvoice = invoices.get(invoices.size() - 2);
                InvoiceData currentInvoice = invoices.get(invoices.size() - 1);
                System.out.println("Previous Reading: " + previousInvoice.meterReading + ", Current Reading: " + currentInvoice.meterReading); // Debug log

                // Determine spike threshold based on meter type
                int spikeThreshold = getSpikeThreshold(statement, meter);
                System.out.println("Spike Threshold for meter " + meter + ": " + spikeThreshold); // Debug log

                // Check if the difference exceeds the spike threshold
                if (currentInvoice.meterReading - previousInvoice.meterReading > spikeThreshold) {
                    System.out.println("Spike detected for meter: " + meter); // Debug log
                    // Log the warning in adopspike table
                    logAdminWarning(statement, currentInvoice.idNo, meter, currentInvoice.meterReading);

                    // Notify the admin with a warning dialog
                    showWarningDialog(meter);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } finally {
            // Close resources in the finally block
            try {
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private static List<String> getAllMeterNumbers(Statement statement) throws SQLException {
        List<String> meterNumbers = new ArrayList<>();
        ResultSet rs = statement.executeQuery("SELECT meter_no FROM customerf");
        while (rs.next()) {
            meterNumbers.add(rs.getString("meter_no"));
        }
        rs.close();
        return meterNumbers;
    }

    private static List<InvoiceData> getInvoices(Statement statement, String meter) throws SQLException {
        List<InvoiceData> invoices = new ArrayList<>();
        ResultSet rs = statement.executeQuery("SELECT id_no, meter_reading FROM invoice WHERE meter_no = '" + meter + "' ORDER BY date_issued, id_no");
        while (rs.next()) {
            invoices.add(new InvoiceData(rs.getString("id_no"), rs.getInt("meter_reading")));
        }
        rs.close();
        return invoices;
    }

    private static int getSpikeThreshold(Statement statement, String meter) throws SQLException {
        ResultSet rs = statement.executeQuery("SELECT meter_type FROM customerf WHERE meter_no = '" + meter + "'");
        if (rs.next()) {
            String meterType = rs.getString("meter_type");
            rs.close();
            if ("residential".equalsIgnoreCase(meterType)) {
                return RESIDENTIAL_SPIKE_THRESHOLD;
            } else if ("commercial".equalsIgnoreCase(meterType)) {
                return COMMERCIAL_SPIKE_THRESHOLD;
            }
        }
        rs.close();
        return 0;
    }

    private static void logAdminWarning(Statement statement, String meter, String invoiceId, int meterReading) throws SQLException {
        statement.executeUpdate("INSERT INTO operator_warnings (meter_no, id_no,  meter_reading) VALUES ('" + meter + "', '" + invoiceId + "', " + meterReading + ")");
    }

    private static void showWarningDialog(String meter) {
        JOptionPane.showMessageDialog(null, "WARNING: Significant spike in usage detected for meter: " + meter, "Warning", JOptionPane.WARNING_MESSAGE);
    }

    // Inner class to represent an invoice
    private static class InvoiceData {
        private String idNo;
        private int meterReading;

        public InvoiceData(String idNo, int meterReading) {
            this.idNo = idNo;
            this.meterReading = meterReading;
        }
    }
}
