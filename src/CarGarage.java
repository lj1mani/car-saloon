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
        textArea.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 16));

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new java.awt.Dimension(200, 200));

        JOptionPane.showMessageDialog(null, scrollPane, "All Cars", JOptionPane.INFORMATION_MESSAGE);
    }

    public void deleteCar() {
        if (cars.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No cars to delete.");
            return;
        }

        String[] carOptions = new String[cars.size()];
        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            carOptions[i] = (i + 1) + ": " + car.getBrand() + " " + car.getModel() + " (" + car.getYear() + ")";
        }

        String selectedCar = (String) JOptionPane.showInputDialog(
                null,
                "Select a car to delete:",
                "Delete Car",
                JOptionPane.PLAIN_MESSAGE,
                null,
                carOptions,
                carOptions[0]
        );

        if (selectedCar == null) return;

        int index = Integer.parseInt(selectedCar.split(":")[0]) - 1;
        Car carToDelete = cars.get(index);

        int confirm = JOptionPane.showConfirmDialog(
                null,
                "Do you really want to delete " + carToDelete.getBrand() + " " + carToDelete.getModel() + " (" + carToDelete.getYear() + ")?",
                "Confirm Deletion",
                JOptionPane.YES_NO_OPTION
        );

        if (confirm == JOptionPane.YES_OPTION) {
            cars.remove(index);
            JOptionPane.showMessageDialog(null, "Car deleted.");
        } else {
            JOptionPane.showMessageDialog(null, "Deletion canceled.");
        }
    }


}
