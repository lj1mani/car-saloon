


public class Main {
    public static void main(String[] args) {

        //Car car = new Car();
        //car.regCar();

        CarGarage cars = new CarGarage();


        while (true) {
            String chois = javax.swing.JOptionPane.showInputDialog("Enter number: \n1: Add new car \n2: Show all cars \n3: Delete car \n 4: Exit");

            if (chois == null) {
                return;
            }

            try {
                int chois1 = Integer.parseInt(chois);

                if (chois1 == 1) {
                    cars.addCar();
                } else if (chois1 == 2) {
                    cars.allCars();
                } else if (chois1 == 3) {
                    cars.deleteCar();
                } else if (chois1 == 4) {
                    javax.swing.JOptionPane.showMessageDialog(null, "Goodbye!");
                    break;
                }

            } catch (NumberFormatException e) {
                javax.swing.JOptionPane.showMessageDialog(null, "Please enter valid numbers for chois");
            }


        }

    }


}
