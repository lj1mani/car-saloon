import java.util.LinkedList;
import javax.swing.*;

public class CarGarage {

    private LinkedList<Car> cars;

    public CarGarage() {
        cars = new LinkedList<>();
    }

    public void addCar() {
        Car car = new Car();
        car.regCar();
        cars.add(car);
    }

    public void allCars() {
        if (cars.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No cars on list.");
            return;
        }

        StringBuilder sb = new StringBuilder("All cars:\n\n");
        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            sb.append(i + 1).append(": ")
                    .append(car.getBrand()).append(" ")
                    .append(car.getModel()).append(" (")
                    .append(car.getYear()).append(")\n");
        }

        JTextArea textArea = new JTextArea(sb.toString());
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new java.awt.Dimension(200, 200));

        JOptionPane.showMessageDialog(null, scrollPane, "All Cars", JOptionPane.INFORMATION_MESSAGE);
    }

    public void deleteCar() {
        if (cars.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(null, "No cars to delete.");
            return;
        }

        StringBuilder sb = new StringBuilder("Select a car to delete:\n");
        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            sb.append(i + 1).append(": ")
                    .append(car.getBrand()).append(" ")
                    .append(car.getModel()).append(" (").append(car.getYear()).append(")\n");
        }

        String input = javax.swing.JOptionPane.showInputDialog(sb.toString() + "\nEnter the number of the car to delete:");
        if (input == null) return;

        try {
            int index = Integer.parseInt(input);
            index = index - 1;
            if (index >= 0 && index < cars.size()) {
                cars.remove(index);
                javax.swing.JOptionPane.showMessageDialog(null, "Car deleted.");
            } else {
                javax.swing.JOptionPane.showMessageDialog(null, "Invalid index.");
            }
        } catch (NumberFormatException e) {
            javax.swing.JOptionPane.showMessageDialog(null, "Please enter a valid number.");
        }


    }
}
