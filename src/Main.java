import javax.swing.*;


public class Main {
    public static void main(String[] args) {

        // Create a new CarGarage object to manage the list of cars
        CarGarage cars = new CarGarage();

        // Menu options for the user to choose from
        String[] options = {"Add new car", "Show all cars", "Delete car", "Exit"};

        // Infinite loop to keep showing the menu until user chooses "Exit"
        while (true) {

            // Show a dialog with options as buttons
            int choice = JOptionPane.showOptionDialog(
                    null,               // Parent component (null means center on screen)
                    null,                     // Message (none in this case)
                    "Car Garage Menu",        // Title of the dialog
                    JOptionPane.DEFAULT_OPTION, // Type of options
                    JOptionPane.PLAIN_MESSAGE,  // No icon
                    null,                  // No custom icon
                    options,                    // Options displayed as buttons
                    options[0]                  // Default selected option
            );

            // If user closes the dialog (choice == -1) or clicks "Exit" (choice == 3), exit the loop
            if (choice == -1 || choice == 3) {
                JOptionPane.showMessageDialog(null, "Goodbye!"); // Say goodbye
                break;
            }

            // Handle user's choice using switch statement
            switch (choice) {
                case 0:
                    // If user selects "Add new car", ask for confirmation first
                    int confirm = JOptionPane.showConfirmDialog(
                            null,
                            "Would you like to register a new car?", // Ask user
                            "Confirm Registration",
                            JOptionPane.YES_NO_OPTION
                    );

                    // If user clicks YES, call addCar()
                    if (confirm == JOptionPane.YES_OPTION) {
                        cars.addCar();
                    } else {
                        // If user clicks NO, cancel registration
                        JOptionPane.showMessageDialog(null, "Car registration cancelled.");
                    }
                    break;

                case 1:
                    // Show list of all cars
                    cars.allCars();
                    break;

                case 2:
                    // Allow user to delete a car
                    cars.deleteCar();
                    break;

                default:
                    break;
            }
        }
    }
}
