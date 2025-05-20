

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

    public void regCar() {
        String brand = null;
        String model = null;
        int year1 = 0;

        while (true) {
            brand = javax.swing.JOptionPane.showInputDialog("Enter brand:");
            if (brand == null || brand.trim().isEmpty()) {
                javax.swing.JOptionPane.showMessageDialog(null, "Brand cannot be empty.");
            } else {
                break;
            }
        }

        while (true) {
            model = javax.swing.JOptionPane.showInputDialog("Enter model:");
            if (model == null || model.trim().isEmpty()) {
                javax.swing.JOptionPane.showMessageDialog(null, "Model cannot be empty.");
            } else {
                break;
            }
        }


        while (true) {
            String year = javax.swing.JOptionPane.showInputDialog("Enter year:");
            if (year == null) return;

            if (!year.matches("\\d{4}")) {
                javax.swing.JOptionPane.showMessageDialog(null, "Year must be exactly 4 digits (e.g. 2023).");
                continue;
            }
            
            try {
                year1 = Integer.parseInt(year);
                break;
            } catch (NumberFormatException e) {
                javax.swing.JOptionPane.showMessageDialog(null, "Please enter a valid number for year.");
            }
        }

        this.brand = brand;
        this.model = model;
        this.year = year1;

        javax.swing.JOptionPane.showMessageDialog(null, "New car has been registered.");
    }
}
