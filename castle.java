import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Scanner;

public class castle {
    static Scanner sc = new Scanner();
    static ArrayList <string[]> residents = new ArrayList<>(); //будет родительский класс существо и 2 дочерних класса
    static ArrayList <string[]> workers = new ArrayList<>(); //дочерний класс жители и работники
    static ArrayList <string[]> rooms = new ArrayList<>();
    static Dictionary<residents, rooms> resident_room = new Dictionary<>();
    int money;
    bool tavern_open;
    int tavern_storage;
    public static void main(String[] args) {
        
    }
    
    public void kazna(){
        if(money <= 0){
            System.out.println("Выберите действие: \n 1. Депозит \n 2. Снятие \n 3. Выход");
            int choice = sc.nextInt();
            switch(choice){
                case 1:
                    deposit();
                    break;
                case 2:
                    withdraw();
                    break;
                case 3:
                    kazna();
                    break;
            }
        }
    }

    public void deposit(){
        System.out.println("Введите сумму депозита: ");
        int deposit = sc.nextInt();
        money += deposit;
    }
    
    public void withdraw(){
        System.out.println("Введите сумму снятия: ");
        int withdraw = sc.nextInt();
        if(withdraw <= money){
            money -= withdraw;
        }
    }

    public static void addWorker(){
        System.out.println("Введите имя нового работника: ");
        string name = sc.nextLine();
        System.out.println("Введите возраст работника: ");
        int age = sc.nextInt();
        System.out.println("Введите профессию: ");
        string profession = sc.nextLine();
        string[] worker = {name,age,profession};
        workers.add(worker);
    }

    public void residentRoom(){
        for(int i = 0; i < residents.size(); i++){
            for(int j = 0; j < rooms.size(); j++){
                if(residents.get(i)[2] == rooms.get(j)[0]){
                    resident_room.put(residents.get(i),rooms.get(j));
                    break;
                }
            }
        }
    }

    public static void addResident(){
        System.out.println("Введите имя нового жителя: ");
        string name = sc.nextLine();
        System.out.println("Введите возраст жителя: ");
        int age = sc.nextInt();
        System.out.println("Введите номер комнаты жителя: ");
        int room = sc.nextInt();
        string[] resident = {name,age,room};
        residents.add(resident);
    }
    
    public static void addRoom(){
        System.out.println("Введите номер комнаты: ");
        int room_number = sc.nextInt();
        System.out.println("Введите цену комнаты: ");
        int price = sc.nextInt();
        System.out.println("Введите вместимость комнаты: ");
        int capacity = sc.nextInt();
        string[] room = {room_number,price,capacity};
        rooms.add(room);
    }

    public void tavern(string name){
        if(tavern_open){
            System.out.println("Таверна закрыта");
        }
        else{
            if(tavern_storage > 0){
                System.out.println(name+" выпил одно пиво");
                tavern_storage--;
            }
            else{
                System.out.println("Напитки закончились");
            }
        }
    }

    public void openTavern(){
        tavern_open = true;
        System.out.println("Таверна открыта");
        tavern_storage = 10;
    }
    
    public void closeTavern(){
        tavern_open = false;
        System.out.println("Таверна закрыта");
    }
}
