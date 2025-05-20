
import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        CarGarage cars = new CarGarage();

        String[] options = {"Add new car", "Show all cars", "Delete car", "Exit"};

        while (true) {
            int choice = JOptionPane.showOptionDialog(
                    null,
                    "Choose an action:",
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
                    cars.addCar();
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



