import java.util.Scanner;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Actions actions = new Actions();
        String[] commandWords = null;
        String enteredString = null;
        Writer writer = new Writer();
        while (true) {
            System.out.println("Enter the command ('help' to get help): ");
            try {
                if (scan.hasNext()) {
                    enteredString = scan.nextLine();
                    if (enteredString == null || enteredString.trim().equals("")) continue;
                } else return;
            } catch (Exception ex) {
                System.out.println("I/O error");
                continue;
            }
            commandWords = enteredString.split(" ");
            switch (commandWords[0]) {
                case "help": {
                    System.out.println("To use this program enter:\n" +
                            "help -- to get help\n" +
                            "result 'function' 'step' 'min' 'max' -- to print the results of a function with entered step from min to max\n" +
                            "write 'function' 'file_name' 'step' 'min' 'max' -- to write the results of a function with entered step from min to max to the file\n" +
                            "exit -- to exit program\n" +
                            "Possible functions:\n" +
                            "sin, cos, tan, cot, sec, cosec, ln, log3, log5, log10, trigequation, logequation, system");
                    continue;
                }

                case "result": {
                    if (commandWords.length != 5) {
                        System.out.println("Wrong number of arguments! See 'help' for more information");
                        continue;
                    } else {
                        Function<Double, Double> function = getFunction(commandWords, actions);
                        if (function == null) continue;
                        double min = Double.valueOf(commandWords[3]);
                        double max = Double.valueOf(commandWords[4]);
                        double step = Double.valueOf(commandWords[2]);
                        showResults(function, step, min, max);
                        break;
                    }
                }
                case "write": {
                    if (commandWords.length != 6) {
                        System.out.println("Wrong number of arguments! See 'help' for more information");
                        continue;
                    } else {
                        Function<Double, Double> function = getFunction(commandWords, actions);
                        if (function == null) continue;
                        double min = Double.valueOf(commandWords[4]);
                        double max = Double.valueOf(commandWords[5]);
                        double step = Double.valueOf(commandWords[3]);
                        writeResults(function, commandWords[2], step, min, max, writer);
                        break;
                    }
                }
                case "exit": {
                    exit();
                }

                default: {
                    System.out.println("There is no such command :(");
                    continue;
                }
            }
        }
    }


    public static void showResults(Function<Double, Double> function, double step,
                                   double min, double max) {
        for (double i = min; i <= max; i += step) {
            System.out.println("x = " + i + ", result = " + function.apply(i));
        }
    }

    public static void writeResults(Function<Double, Double> function, String filename,
                                    double step, double min, double max, Writer writer) {
        for (double i = min; i < max; i += step) {
            writer.write(filename, i, function.apply(i));
        }
    }

    public static Function<Double, Double> getFunction(String[] commandWords, Actions actions) {
        switch (commandWords[1]) {
            case "sin": {
                return actions.getActs().get(0);
            }
            case "cos": {
                return actions.getActs().get(1);
            }
            case "tan": {
                return actions.getActs().get(2);
            }
            case "cot": {
                return actions.getActs().get(3);
            }
            case "sec": {
                return actions.getActs().get(4);
            }
            case "cosec": {
                return actions.getActs().get(5);
            }
            case "ln": {
                return actions.getActs().get(6);
            }
            case "log3": {
                return actions.getActs().get(7);
            }
            case "log5": {
                return actions.getActs().get(8);
            }
            case "log10": {
                return actions.getActs().get(9);
            }
            case "trigequation": {
                return actions.getActs().get(10);
            }
            case "logequation": {
                return actions.getActs().get(11);
            }
            case "system": {
                return actions.getActs().get(12);
            }
            default: {
                System.out.println("Wrong function name! See 'help' for more information");
                return null;
            }
        }
    }

    public static void exit() {
        System.exit(0);
    }
}
