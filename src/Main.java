import java.io.IOException;
import java.lang.ProcessBuilder;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;
public class Main {
    private static final Map <String, Process> processes = new HashMap<>();
    public static void main(String[] args) throws IOException {
        System.out.println("Добро пожаловать в диспетчер программ!");
        while (true) {
            Scanner action = new Scanner(System.in);
            System.out.println("""
                    Введите номер необходимого Вам действия: \s
                    1) Запуск программы 'Блокнот' \s
                    2) Запуск программы 'Калькулятор' \s
                    3) Запуск программы 'Word' \s
                    --------------- \s
                    4) Выход из диспетчера программ \s
                    _______________ \s
                    Номер действия:\s""");
            int number = action.nextInt();
            ProcessBuilder process = new ProcessBuilder();
            if (number == 1) {
                while (true) {
                    process.command("notepad.exe", "C:\\Windows\\System32");
                    process.start();
                    System.out.println("""
                            Что выполнить далее? \
                            
                            1) Получить информацию о процессах программы 'Блокнот' \
                            
                            2) Выйти из программы 'Блокнот' в главное меню диспетчера программ (завершить процесс) \
                            
                            3) Выход из диспетчера программ \
                            
                            Номер действия:\s""");
                    int notepad = action.nextInt();
                    if (notepad == 1) {
                        long currentProcess = ProcessHandle.current().pid();
                        System.out.println("Информация о текущих процессах: " +
                                "\nИдентификатор процесса (Process IDentifier, PID): " + currentProcess +
                                "\nВремя активности: \nДочерние процессы: \nИнформация:");
                    }
                    if (notepad == 2) {
                        Runtime.getRuntime().exec("taskkill /f /im notepad.exe");
                        break;
                    }
                    if (notepad == 3) {
                        Runtime.getRuntime().exec("taskkill /f /im notepad.exe");
                        return;
                    } else {
                        System.out.println("Введите корректный номер!");
                    }
                }
            }
            if (number == 2) {
                while (true) {
                    process.command("calc.exe", "C:\\Windows\\System32");
                    process.start();
                    System.out.println("""
                            Что выполнить далее? \
                            
                            1) Получить информацию о процессах программы 'Калькулятор' \
                            
                            2) Выйти из программы 'Калькулятор' в главное меню диспетчера программ (завершить процесс) \
                            
                            3) Выход из диспетчера программ \
                            
                            Номер действия:\s""");
                    int calculator = action.nextInt();
                    if (calculator == 1) {
                        Information();
                    }
                    if (calculator == 2) {
                        Runtime.getRuntime().exec("taskkill /f /im CalculatorApp.exe");
                        break;
                    }
                    if (calculator == 3) {
                        Runtime.getRuntime().exec("taskkill /f /im CalculatorApp.exe");
                        return;
                    } else {
                        System.out.println("Введите корректный номер!");
                    }
                }
            }
            if (number == 3) {
                while (true) {
                    process.command("C:\\Program Files\\Microsoft Office\\root\\Office16\\WINWORD.EXE");
                    process.start();
                    System.out.println("""
                            Что выполнить далее? \
                            
                            1) Получить информацию о процессах программы 'Word' \
                            
                            2) Выйти из программы 'Word' в главное меню диспетчера программ (завершить процесс) \
                            
                            3) Выход из диспетчера программ \
                            
                            Номер действия:\s""");
                    int word = action.nextInt();
                    if (word == 1) {
                        long currentProcess = ProcessHandle.current().pid();
                        System.out.println("Информация о текущих процессах: " +
                                "\nИдентификатор процесса (Process IDentifier, PID): " + currentProcess +
                                "\nВремя активности: \nДочерние процессы: \nИнформация:");
                    }
                    if (word == 2) {
                        Runtime.getRuntime().exec("taskkill /f /im WINWORD.EXE");
                        break;
                    }
                    if (word == 3) {
                        Runtime.getRuntime().exec("taskkill /f /im WINWORD.EXE");
                        return;
                    } else {
                        System.out.println("Введите корректный номер!");
                    }
                }
            }
            if (number == 4) {
                return;
            }
            else {
                System.out.println("Введите корректный номер!");
            }
        }
    }
    static void Information () {
        for (Map.Entry<String, Process> entry : processes.entrySet()) {
            String name = entry.getKey();
            Process process = entry.getValue();
            ProcessHandle handle = process.toHandle();
            ProcessHandle.Info information = handle.info();

            System.out.println("Приложение: " +name+
                    "\nИдентификатор процесса (Process IDentifier, PID): " +handle.pid()+
                    "\nПродолжительность работы: " +handle.isAlive()+
                    "\nКоманда: " +information.command().orElse("Неизвестно")+
                    "\nАргументы: " +(information.arguments().isPresent() )+
                    "\nПользователь: " +information.user().orElse("Неизвестно")+
                    "\nВремя запуска: " +information.startInstant().orElse(null)+
                    "\nCPU время: " +information.totalCpuDuration().orElse(null));
        }
    }
}