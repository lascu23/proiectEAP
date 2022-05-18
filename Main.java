package proiect;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final String basePath = "C:\\Users\\Computer\\IdeaProjects\\ProiectEAP\\src\\proiect\\";

    private static String line = "";

    public static void fisier(File f){
        try{    if(f.createNewFile()){
                System.out.println("File created");
            }else{
                System.out.println(f.exists());
                System.out.println("File already exists");
            }
        }
        catch(IOException e){
            System.out.println(e);
        }
    }

    public static void aplicatie(){
        int option = 0;
        Singleton app = Singleton.getInstance();
        do{
            app.menu();
            System.out.println("Alegeti optiunea:");
            Scanner scan = new Scanner(System.in);
            option = scan.nextInt();
            switch (option){
                case 1:
                    app.readFromFile();
                    break;
                case 2:
                    app.writeInFile();
                    break;
                case 3:
                    app.remove();
                    break;//probleme aici. de fiecare data cand incerc sa scriu in fisier, mi l sterge
                case 0:
                    System.out.println("Iesire din aplicatie");
                    break;
                default:{
                    System.out.println("Nu exista aceasta optiune!!!!");
                }
            }
        }while(option!=0);
    }

    public static void sql() throws SQLException {
        int option = 0;
        Singleton app = Singleton.getInstance();
        do{
            app.menu2();
            System.out.println("Alegeti optiunea:");
            Scanner scan = new Scanner(System.in);
            option = scan.nextInt();
            switch (option){
                case 1:
                    app.createTable();
                    break;
                case 2:
                    app.insertInTable();
                    break;
                case 3:
                    app.selectFromTable();
                case 4:
                    app.deleteATable();
                case 5:
                    app.update();
                case 0:
                    System.out.println("Iesire din aplicatie");
                    break;
                default:{
                    System.out.println("Nu exista aceasta optiune!!!!");
                }
            }
        }while(option!=0);
    }

    public static void main(String[] args) throws SQLException{
        sql();
//        File f1 = new File(basePath,"fisierEmployee.txt");
//        File f2 = new File(basePath,"fisierProduct.txt");
//        File f3 = new File(basePath,"fisierOrder.txt");
//        File f4 = new File(basePath,"fisierClient.txt");
//        File f9 = new File(basePath,"ActionStamp.txt");
//        fisier(f1);
//        fisier(f2);
//        fisier(f3);
//        fisier(f4);
//        fisier(f9);
//        try{
//            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcschema","root","!Nustiu123!");
//            Statement statement = conn.createStatement();
//            ResultSet resultSet = statement.executeQuery("select * from employee");
//            while (resultSet.next())
//            {
//                System.out.print(resultSet.getString("Birthday"));
//                System.out.print(" ");
//                System.out.println(resultSet.getString("employeeName"));
//            }
//        }catch(SQLException e){
//            e.printStackTrace();
//        }

//        aplicatie();

//        Product p = new Product(999,"pizza");
//        Product p2 = new Product(444,"burger");
//        Product p3 = new Product(123,"paste");
//        List<Product> products = new ArrayList<>();
//        products.add(p);
//        products.add(p2);
//        products.add(p3);
//        Order o = new Order("23/03/2002",000,products);
//        //System.out.println(o);
//
//        RestaurantService rs = new RestaurantService();
//        List<RawMaterial> rm = new ArrayList<>();
//        RawMaterial rm1 = new RawMaterial("faina",100,25, java.util.Collections.emptyList());
//        RawMaterial rm2 = new RawMaterial("oua",150,30, java.util.Collections.emptyList());
//        rm.add(rm1);
//        rm.add(rm2);
//        Provider provider = new Provider("NumeProvider",123,"Bucuresti",rm);
//
//        List<Employee> emp = new ArrayList<>();
//        Employee e1 = new Employee("321321","maniu",180,"Lascu","23/03/2002");
//        Employee e2 = new Employee("000000","brancusi",200,"popa","11/11/2011");
//        emp.add(e1);
//        emp.add(e2);
//
//        Client c1 = new Client("50203","vladimirescu",150,999,"ilie",Collections.emptyList());
//
//        List<Department> departments = new ArrayList<>();
//        Department d1 = new Department(111,"Vanzari",emp);
//        Department d2 = new Department(999,"Livrari",Collections.emptyList());
//        departments.add(d1);
//        departments.add(d2);
//        Restaurant restaurant = new Restaurant("Trattoria","Maniu",225200,departments);
//        rs.showDepartments(restaurant);
//        rs.theMostExpensiveRM(provider);
//        rs.renameDepartment(d1,restaurant);
//        rs.commandFromProvider(rm1);
//        rs.schedule(restaurant);
//        rs.expirationDate(p2);
//        System.out.println(d1);
//        rs.fireEmployee(e1,d1);
//        rs.addOrder(c1);
//        rs.commandBrought();
    }
}
