
import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        CarGarage cars = new CarGarage();

        String[] options = {"Add new car", "Show all cars", "Delete car", "Exit"};

        while (true) {
            int choice = JOptionPane.showOptionDialog(
                    null,
                    null,
                    "Car Garage Menu",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    options,
                    options[0]
            );

            if (choice == -1 || choice == 3) {
                JOptionPane.showMessageDialog(null, "Goodbye!");
                break;
            }

            switch (choice) {
                case 0:
                    int confirm = JOptionPane.showConfirmDialog(
                            null,
                            "Would you like to register a new car?",
                            "Confirm Registration",
                            JOptionPane.YES_NO_OPTION
                    );

                    if (confirm == JOptionPane.YES_OPTION) {
                        cars.addCar();
                    } else {
                        JOptionPane.showMessageDialog(null, "Car registration cancelled.");
                    }
                    break;
                case 1:
                    cars.allCars();
                    break;
                case 2:
                    cars.deleteCar();
                    break;
                default:
                    break;
            }
        }


    }
}



