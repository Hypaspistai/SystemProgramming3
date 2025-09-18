import java.io.IOException;
import java.lang.ProcessBuilder;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
public class Main {
    private static final Map <String, Process> processes = new HashMap<>();
    public static void main(String[] args) throws IOException {
        System.out.println("\u001B[32mДобро пожаловать в диспетчер программ!\u001B[0m");
        ProcessBuilder process = new ProcessBuilder();
        while (true) {
            Scanner action = new Scanner(System.in);
            System.out.println("""
                    Введите номер необходимого Вам действия: \s
                    1) Запуск программы 'Блокнот' \s
                    2) Запуск программы 'Калькулятор' \s
                    3) Запуск программы 'Word' \s
                    --------------- \s
                    4) Запуск всех программ \s
                    --------------- \s
                    5) Выход из диспетчера программ \s
                    _______________ \s
                    Номер действия:\s""");
            int number = action.nextInt();
            if (number == 1) {
                while (true) {
                    process.command("notepad.exe", "C:\\Windows\\System32");
                    process.start();
                    System.out.println("""
                            Что выполнить далее? \
                            
                            1) Получить информацию о программе 'Блокнот' и завершить текущий процесс (информация о нём будет сохранена) \
                            
                            2) Выйти из программы 'Блокнот' в главное меню диспетчера программ \
                            
                            3) Выход из диспетчера программ \
                            
                            Номер действия:\s""");
                    int notepad = action.nextInt();
                    if (notepad == 1) {
                        processes.put("Блокнот", process.start());
                        Information();
                        Runtime.getRuntime().exec("taskkill /f /im notepad.exe");
                    }
                    if (notepad == 2) {
                        Runtime.getRuntime().exec("taskkill /f /im notepad.exe");
                        break;
                    }
                    if (notepad == 3) {
                        Runtime.getRuntime().exec("taskkill /f /im notepad.exe");
                        return;
                    }
                    if (notepad < 1 || notepad > 3) {
                        System.out.println("\u001B[31mВведите корректный номер!\u001B[0m");
                    }
                }
            }
            if (number == 2) {
                while (true) {
                    process.command("calc.exe", "C:\\Windows\\System32");
                    process.start();
                    System.out.println("""
                            Что выполнить далее? \
                            
                            1) Получить информацию о программе 'Калькулятор' и завершить текущий процесс (информация о нём будет сохранена) \
                            
                            2) Выйти из программы 'Калькулятор' в главное меню диспетчера программ \
                            
                            3) Выход из диспетчера программ \
                            
                            Номер действия:\s""");
                    int calculator = action.nextInt();
                    if (calculator == 1) {
                        processes.put("Калькулятор", process.start());
                        Information();
                        Runtime.getRuntime().exec("taskkill /f /im CalculatorApp.exe");
                    }
                    if (calculator == 2) {
                        Runtime.getRuntime().exec("taskkill /f /im CalculatorApp.exe");
                        break;
                    }
                    if (calculator == 3) {
                        Runtime.getRuntime().exec("taskkill /f /im CalculatorApp.exe");
                        return;
                    }
                    if (calculator < 1 || calculator > 3) {
                        System.out.println("\u001B[31mВведите корректный номер!\u001B[0m");
                    }
                }
            }
            if (number == 3) {
                while (true) {
                    process.command("C:\\Program Files\\Microsoft Office\\root\\Office16\\WINWORD.EXE");
                    process.start();
                    System.out.println("""
                            Что выполнить далее? \
                            
                            1) Получить информацию о программе 'Word' и завершить текущий процесс (информация о нём будет сохранена) \
                            
                            2) Выйти из программы 'Word' в главное меню диспетчера программ \
                            
                            3) Выход из диспетчера программ \
                            
                            Номер действия:\s""");
                    int word = action.nextInt();
                    if (word == 1) {
                        processes.put("MS Office Word", process.start());
                        Information();
                        Runtime.getRuntime().exec("taskkill /f /im WINWORD.EXE");
                    }
                    if (word == 2) {
                        Runtime.getRuntime().exec("taskkill /f /im WINWORD.EXE");
                        break;
                    }
                    if (word == 3) {
                        Runtime.getRuntime().exec("taskkill /f /im WINWORD.EXE");
                        return;
                    }
                    if (word < 1 || word > 3) {
                        System.out.println("\u001B[31mВведите корректный номер!\u001B[0m");
                    }
                }
            }
            if (number == 4) {
                while (true) {
                    process.command("notepad.exe", "C:\\Windows\\System32");
                    process.start();
                    process.command("calc.exe", "C:\\Windows\\System32");
                    process.start();
                    process.command("C:\\Program Files\\Microsoft Office\\root\\Office16\\WINWORD.EXE");
                    process.start();
                    System.out.println("""
                            Дальнейшие действия: \
                            
                            1) информация о всех программах; \
                            
                            2) выход в главное меню диспетчера программ; \
                            
                            3) выход из диспетчера программ и вывод всех PIDов. \
                            
                            Номер действия:\s""");
                    int all = action.nextInt();
                    if (all == 1) {
                        processes.put("Блокнот", process.start());
                        Runtime.getRuntime().exec("taskkill /f /im notepad.exe");
                        processes.put("Калькулятор", process.start());
                        Runtime.getRuntime().exec("taskkill /f /im CalculatorApp.exe");
                        processes.put("MS Office Word", process.start());
                        Runtime.getRuntime().exec("taskkill /f /im WINWORD.EXE");
                        Information();
                        processes.clear();
                    }
                    if (all == 2) {
                        Runtime.getRuntime().exec("taskkill /f /im notepad.exe");
                        Runtime.getRuntime().exec("taskkill /f /im CalculatorApp.exe");
                        Runtime.getRuntime().exec("taskkill /f /im WINWORD.EXE");
                        processes.clear();
                        break;
                    }
                    if (all == 3) {
                        processes.put("Блокнот", process.start());
                        Runtime.getRuntime().exec("taskkill /f /im notepad.exe");
                        processes.put("Калькулятор", process.start());
                        Runtime.getRuntime().exec("taskkill /f /im CalculatorApp.exe");
                        processes.put("MS Office Word", process.start());
                        Runtime.getRuntime().exec("taskkill /f /im WINWORD.EXE");
                        InformationPID();
                        processes.clear();
                        return;
                    }
                    if (all < 1 || all > 3) {
                        System.out.println("\u001B[31mВведите корректный номер!\u001B[0m");
                    }
                }
            }
            if (number == 5) {
                return;
            }
            else if (number < 1 || number > 5) {
                System.out.println("\u001B[31mВведите корректный номер!\u001B[0m");
            }
        }
    }
    static void Information () {
        for (Map.Entry<String, Process> entry : processes.entrySet()) {
            String name = entry.getKey();
            Process process = entry.getValue();
            ProcessHandle handle = process.toHandle();
            ProcessHandle.Info information = handle.info();

            System.out.println("Приложение: " + "\u001B[34m" +name+ "\u001B[0m" +
                    "\nИдентификатор процесса (Process IDentifier, PID): " + "\u001B[34m" +handle.pid()+ "\u001B[0m" +
                    "\nТекущее состояние: " + "\u001B[34m" +handle.isAlive()+ "\u001B[0m" +
                    "\nАдресный путь: " + "\u001B[34m" +information.command().orElse("Неизвестно")+ "\u001B[0m" +
                    "\nПользователь: " + "\u001B[34m" +information.user().orElse("Неизвестно")+ "\u001B[0m" +
                    "\nВремя запуска: " + "\u001B[34m" +information.startInstant().orElse(null)+ "\u001B[0m" +
                    "\nПродолжительность работы CPU: " + "\u001B[34m" +information.totalCpuDuration().orElse(null)+ "\u001B[0m" +
                    "\n============================");
        }
    }
    static void InformationPID () {
        for (Map.Entry<String, Process> entry : processes.entrySet()) {
            String name = entry.getKey();
            Process process = entry.getValue();
            ProcessHandle handle = process.toHandle();

            System.out.println("\u001B[33mПриложение: " +name+
                    "\nИдентификатор процесса (Process IDentifier, PID): " +handle.pid()+
                    "\n============================\u001B[0m");
        }
    }
}