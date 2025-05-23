
public class Car {


    private String brand;
    private String model;
    private int year;


    public Car(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }


    public Car() {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }


    public String getBrand() {
        return brand;
    }


    public String getModel() {
        return model;
    }


    public int getYear() {
        return year;
    }


    public void setBrand(String brand) {
        this.brand = brand;
    }


    public void setModel(String model) {
        this.model = model;
    }


    public void setYear(int year) {
        this.year = year;
    }

    // Method that opens dialogs to register a new car
    public void regCar() {
        String brand = null;
        String model = null;
        int year1 = 0;

        // Loop until a valid brand is entered
        while (true) {
            brand = javax.swing.JOptionPane.showInputDialog("Enter brand:");
            if (brand == null || brand.trim().isEmpty()) {
                javax.swing.JOptionPane.showMessageDialog(null, "Brand cannot be empty.");
            } else {
                break;
            }
        }

        // Loop until a valid model is entered
        while (true) {
            model = javax.swing.JOptionPane.showInputDialog("Enter model:");
            if (model == null || model.trim().isEmpty()) {
                javax.swing.JOptionPane.showMessageDialog(null, "Model cannot be empty.");
            } else {
                break;
            }
        }

        // Loop until a valid 4-digit year is entered
        while (true) {
            String year = javax.swing.JOptionPane.showInputDialog("Enter year:");
            if (year == null) return;  // If user clicks cancel, exit method

            // Check if input is exactly 4 digits
            if (!year.matches("\\d{4}")) {
                javax.swing.JOptionPane.showMessageDialog(null, "Year must be exactly 4 digits (e.g. 2023).");
                continue;
            }

            try {
                year1 = Integer.parseInt(year);  // Try to convert string to number
                break;  // If successful, exit loop
            } catch (NumberFormatException e) {
                javax.swing.JOptionPane.showMessageDialog(null, "Please enter a valid number for year.");
            }
        }

        // After collecting valid inputs, set the values to this Car object
        this.brand = brand;
        this.model = model;
        this.year = year1;

        // Show confirmation message
        javax.swing.JOptionPane.showMessageDialog(null, "New car has been registered.");
    }
}
