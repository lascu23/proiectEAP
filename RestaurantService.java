package proiect;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLOutput;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.*;

public class RestaurantService{

    public RestaurantService(){

    }

    private final String basePath = "C:\\Users\\Computer\\IdeaProjects\\ProiectEAP\\src\\proiect\\";

    public void renameDepartment(Department d,Restaurant r){
        Scanner scan = new Scanner(System.in);
        System.out.println("Introduceti noul nume al departamentului:");
        String newName = scan.next();
        d.setDepName(newName);
        if(r.getDepartments().contains(d)){
            d.setDepName(newName);
        }
        System.out.println(d);
        try(FileWriter fw = new FileWriter(basePath+"ActionStamp.txt",true);){
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            fw.write("renameDepartment, "+timestamp.toString());
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void commandFromProvider(RawMaterial rm){
        if(rm.getAmount() < 50)
            System.out.println("Nu se comanda " + rm.getNameRM());
        else
            System.out.println("Sa se comande " + rm.getNameRM());
        try(FileWriter fw = new FileWriter(basePath+"ActionStamp.txt",true);){
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            fw.write("commandFromProvider, "+timestamp.toString());
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void schedule(Restaurant r){
        int option;
        Scanner scan = new Scanner(System.in);
        System.out.println("Ziua saptamanii (0-EXIT): ");
        option = scan.nextInt();
        switch(option){
            case 1:
                System.out.print("Programul de luni este: ");
                System.out.println("08:00-22:00");
                break;
            case 2:
                System.out.print("Programul de marti este: ");
                System.out.println("08:00-22:00");
                break;
            case 3:
                System.out.print("Programul de miercuri este: ");
                System.out.println("08:00-22:00");
                break;
            case 4:
                System.out.print("Programul de joi este: ");
                System.out.println("08:00-22:00");
                break;
            case 5:
                System.out.print("Programul de vineri este: ");
                System.out.println("08:00-00:00");
                break;
            case 6:
                System.out.print("Programul de sambata este: ");
                System.out.println("12:00-04:00");
                break;
            case 7:
                System.out.println("Restaurantul este inchis");
                break;
            case 0:
                break;
        }
        try(FileWriter fw = new FileWriter(basePath+"ActionStamp.txt",true);){
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            fw.write("schedule, "+timestamp.toString());
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void age(Employee a, Employee b){
        if(a.compareTo(b)<0) System.out.println("Angajatul " + a.getEmployeeName() + " este mai tanar");
        else if(a.compareTo(b)==0) System.out.println("Cei doi angajati au aceeasi varsta");
        else System.out.println("Angajatul " + b.getEmployeeName() + " este mai tanar");
        try(FileWriter fw = new FileWriter(basePath+"ActionStamp.txt",true);){
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            fw.write("age, "+timestamp.toString());
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void expirationDate(Product p){
        if(p.getProductID()<1000)
            System.out.println("Produsul este expirat. Trebuie aruncat!!!");
        else
            System.out.println("Produsul este inca valabil");
        try(FileWriter fw = new FileWriter(basePath+"ActionStamp.txt",true);){
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            fw.write("expirationDate, "+timestamp.toString());
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void fireEmployee(Employee emp,Department d){
        if(d.getEmployees().contains(emp)){
            d.getEmployees().remove(emp);
        }
        System.out.println(d);
        try(FileWriter fw = new FileWriter(basePath+"ActionStamp.txt",true);){
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            fw.write("fireEmployee, "+timestamp.toString());
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void addOrder(Client c){
        System.out.println("Clientul "+c.getClientName() +" vrea sa comande!");
        Order o = new Order();
        System.out.println("Numarul comenzii este: ");
        Scanner scan = new Scanner(System.in);
        int nrCom = scan.nextInt();
        o.setOrderID(nrCom);
        System.out.println("Data de azi este: ");
        String date = scan.next();
        o.setOrderDate(date);
        List<Order> temp = new ArrayList<>(c.getOrders());
        Collections.copy(temp,c.getOrders());
        temp.add(o);
        c.setOrders(temp);
        System.out.println(c);
        try(FileWriter fw = new FileWriter(basePath+"ActionStamp.txt",true);){
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            fw.write("addOrder, "+timestamp.toString());
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void addNewRestaurant(Restaurant restaurant){
        System.out.println("Se deschide un nou restaurant");
        System.out.println("Acesta are numele: ");
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();
        System.out.println("Adresa restaurantului este: ");
        String address = scan.nextLine();
        System.out.println("Zona restaurantului are codul postal: ");
        int postal = scan.nextInt();
        System.out.println("Restaurantul inca nu are departamente");
        restaurant.setRestaurantName(name);
        restaurant.setAddress(address);
        restaurant.setPostalCode(postal);
        restaurant.setDepartments(null);
        try(FileWriter fw = new FileWriter(basePath+"ActionStamp.txt",true);){
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            fw.write("addNewRestaurant, "+timestamp.toString());
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void clientOrders(Client c){
        System.out.println(c.getOrders());
        try(FileWriter fw = new FileWriter(basePath+"ActionStamp.txt",true);){
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            fw.write("clientOrders, " +timestamp.toString());
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void commandBrought(){
        System.out.println("Comanda a fost adusa la masa");
        try(FileWriter fw = new FileWriter(basePath+"ActionStamp.txt",true);){
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            fw.write("commandBrought, "+timestamp.toString());
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void showDepartments(Restaurant r){
        Iterator<Department> it = r.getDepartments().iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
        try(FileWriter fw = new FileWriter(basePath+"ActionStamp.txt",true);){
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            fw.write("showDepartments, "+timestamp.toString());
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void theMostExpensiveRM(Provider p){
        Iterator<RawMaterial> it = p.getRm().iterator();
        int m=-1;
        while(it.hasNext()){
            if(it.next().getPrice()>m){
                m = it.next().getPrice();
            }
        }
        System.out.print("Cea mai scumpa materie prima are pretul: ");
        System.out.println(m);
        try(FileWriter fw = new FileWriter(basePath+"ActionStamp.txt",true);){
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            fw.write("theMostExpensiveRM, "+timestamp.toString());
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
