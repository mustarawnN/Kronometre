package Chest;

import java.util.Scanner;

public class Kronometre {
	
     long startTime;
     long elapsedTime;
     boolean running;

    public void start() {
        if (!running) {
            startTime = System.currentTimeMillis();
            running = true;
        } else {
            System.out.println("Kronometre zaten çalışıyor!");
        }
    }

    public void stop() {
        if (running) {
            elapsedTime += System.currentTimeMillis() - startTime;
            running = false;
        } else {
            System.out.println("Kronometre zaten durdurulmuş!");
        }
    }

    public void reset() {
        startTime = 0;
        elapsedTime = 0;
        running = false;
    }

    public void displayTime() {
        long totalElapsed = running ? elapsedTime + (System.currentTimeMillis() - startTime) : elapsedTime;
        long seconds = (totalElapsed / 1000) % 60;
        long minutes = (totalElapsed / (1000 * 60)) % 60;
        long hours = (totalElapsed / (1000 * 60 * 60));

        System.out.printf("Geçen Süre: %02d:%02d:%02d\n", hours, minutes, seconds);
    }

    public static void main(String[] args) {
        Kronometre Kronometre = new Kronometre();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Kronometre Uygulamasına Hoş Geldiniz!");
        System.out.println("Komutlar: start, stop, reset, time, exit");

        while (true) {
            System.out.print("Komut girin: ");
            String command = scanner.nextLine().toLowerCase();

            switch (command) {
            
                case ("start"):
                	Kronometre.start();
                    break;
                    
                case "stop":
                	Kronometre.stop();
                	System.out.println("Süre durduruldu . ");
                    break;
                    
                case "reset":
                	Kronometre.reset();
                	System.out.println("Süre durduruldu .");
                    break;
                    
                case "time":             	
                	Kronometre.displayTime();
                    break;
                    
                case "exit":
                    System.out.println("Kronometre uygulamasından çıkılıyor...");
                    scanner.close();
                    return;
                    
                    
                default:
                    System.out.println("Geçersiz komut! Lütfen 'start', 'stop', 'reset', 'time' veya 'exit' komutlarından birini girin.");
            }
        }
    }
}
