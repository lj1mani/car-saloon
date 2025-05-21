
import java.util.LinkedList;
import javax.swing.*;


public class CarGarage {


    private LinkedList<Car> cars;


    public CarGarage() {
        cars = new LinkedList<>();
    }

    // Method to add a new car
    public void addCar() {
        Car car = new Car();     // Create a new Car object
        car.regCar();            // Call method to input car details
        cars.add(car);           // Add the car to the list
    }

    // Method to show all cars in a scrollable JTextArea
    public void allCars() {

        if (cars.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No cars on list."); // Show message if list is empty
            return;
        }

        // Create a string of all car info
        StringBuilder sb = new StringBuilder("All cars:\n\n");
        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            sb.append(i + 1).append(": ")
                    .append(car.getBrand()).append(" ")
                    .append(car.getModel()).append(" (")
                    .append(car.getYear()).append(")\n");
        }

        // Create a text area to show car info
        JTextArea textArea = new JTextArea(sb.toString());
        textArea.setEditable(false); // Make text not editable
        textArea.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 16)); // Set font size

        // Add the text area to a scroll pane (in case there are many cars)
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new java.awt.Dimension(200, 200));

        // Show the scroll pane in a dialog
        JOptionPane.showMessageDialog(null, scrollPane, "All Cars", JOptionPane.INFORMATION_MESSAGE);
    }

    // Method to delete a selected car from the list
    public void deleteCar() {

        if (cars.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No cars to delete."); // Show message if list is empty
            return;
        }

        // Create an array of car descriptions to show in a selection dialog
        String[] carOptions = new String[cars.size()];
        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            carOptions[i] = (i + 1) + ": " + car.getBrand() + " " + car.getModel() + " (" + car.getYear() + ")";
        }

        // Show selection dialog where user can choose which car to delete
        String selectedCar = (String) JOptionPane.showInputDialog(
                null,
                "Select a car to delete:",
                "Delete Car",
                JOptionPane.PLAIN_MESSAGE,
                null,
                carOptions,
                carOptions[0] // Default selected value
        );

        // If user cancels or closes the dialog
        if (selectedCar == null) return;

        // Get index of selected car
        int index = Integer.parseInt(selectedCar.split(":")[0]) - 1;
        Car carToDelete = cars.get(index); // Get the car object

        // Ask user to confirm deletion
        int confirm = JOptionPane.showConfirmDialog(
                null,
                "Do you really want to delete " + carToDelete.getBrand() + " " +
                        carToDelete.getModel() + " (" + carToDelete.getYear() + ")?",
                "Confirm Deletion",
                JOptionPane.YES_NO_OPTION
        );

        // Delete car if confirmed
        if (confirm == JOptionPane.YES_OPTION) {
            cars.remove(index);
            JOptionPane.showMessageDialog(null, "Car deleted.");
        } else {
            JOptionPane.showMessageDialog(null, "Deletion canceled."); // If user says no
        }
    }
}
