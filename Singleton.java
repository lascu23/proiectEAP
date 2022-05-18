package proiect;

import java.io.*;
import java.sql.*;
import java.util.*;

public class Singleton {
    private static Singleton instance;
    private  Singleton(){}

    public static Singleton getInstance(){
        if(instance==null){
            instance = new Singleton();
        }
        return instance;
    }

    private static String line = "";
    private static final String basePath = "C:\\Users\\Computer\\IdeaProjects\\ProiectEAP\\src\\proiect\\";

    public void menu(){
        System.out.println("--------------------MENIU--------------------");
        System.out.println("1. Citirea din fisiere");
        System.out.println("2. Scrierea in fisiere");
        System.out.println("3. Stergerea din fisier");
        System.out.println("0. EXIT");
        System.out.println("---------------------------------------------");
    }

    public void menu2(){
        System.out.println("--------------------MENIU--------------------");
        System.out.println("1. Crearea tabelelor");
        System.out.println("2. Insereaza valori in tabel");
        System.out.println("3. Selecteaza valorile din tabel");
        System.out.println("4. Sterge un tabel");
        System.out.println("5. Actualizeaza un tabel");
        System.out.println("0. EXIT");
        System.out.println("---------------------------------------------");
    }

    public void readFromFile(){
        System.out.println("Fisierele sunt:");
        System.out.println("1. Fisier pentru angajat");
        System.out.println("2. Fisier pentru client");
        System.out.println("3. Fisier pentru produs");
        System.out.println("4. Fisier pentru comanda");
        System.out.println("0. EXIT");
        System.out.println("Vreau sa citesc din fisierul: ");
        int option;
        Scanner scan = new Scanner(System.in);
        option = scan.nextInt();
        switch(option){
            case 1:try(BufferedReader br = new BufferedReader(new FileReader(basePath+"fisierEmployee.txt"))){
                List<Employee> emp = new ArrayList<>();
                while((line = br.readLine())!=null){
                    String[] values = line.split(",");
                    if(values.length>0){
                        Employee employee = new Employee();
                        employee.setCnp(values[0]);
                        employee.setAddress(values[1]);
                        employee.setHeight(Integer.parseInt(values[2]));
                        employee.setEmployeeName(values[3]);
                        employee.setBirthDay(values[4]);
                        emp.add(employee);
                    }
                }
                for(Employee e: emp){
                    System.out.println(e);
                }
            }catch(IOException e){
                e.printStackTrace();
            }
            break;
            case 2:try(BufferedReader br = new BufferedReader(new FileReader(basePath+"fisierClient.txt"))){
                List<Client> emp = new ArrayList<>();
                while((line = br.readLine())!=null){
                    String[] values = line.split(",");
                    if(values.length>0){
                        Client client = new Client();
                        client.setCnp(values[0]);
                        client.setAddress(values[1]);
                        client.setHeight(Integer.parseInt(values[2]));
                        client.setClientID(Integer.parseInt(values[3]));
                        client.setClientName(values[4]);
                        List<String> str = new ArrayList<>();
                        String[] desp = new String[values[5].length()];
                        desp = values[5].split(";");
                        for(String i: desp){
                            str.add(i);
                        }
                        client.setOrders(str);
                        emp.add(client);
                    }
                }
                for(Client c: emp){
                    System.out.println(c);
                }
            }catch(IOException e){
                e.printStackTrace();
            }
            break;
            case 3:try(BufferedReader br = new BufferedReader(new FileReader(basePath+"fisierProduct.txt"))){
                List<Product> emp = new ArrayList<>();
                while((line = br.readLine())!=null){
                    String[] values = line.split(",");
                    if(values.length>0){
                        Product prod = new Product();
                        prod.setProductID(Integer.parseInt(values[0]));
                        prod.setProductName(values[1]);
                        emp.add(prod);
                    }
                }
                for(Product e: emp){
                    System.out.println(e);
                }
            }catch(IOException e){
                e.printStackTrace();
            }
            break;
            case 4:try(BufferedReader br = new BufferedReader(new FileReader(basePath+"fisierOrder.txt"))){
                List<Order> emp = new ArrayList<>();
                while((line = br.readLine())!=null){
                    String[] values = line.split(",");
                    if(values.length>0){
                        Order order = new Order();
                        order.setOrderDate(values[0]);
                        order.setOrderID(Integer.parseInt(values[1]));
                        List<String> str = new ArrayList<>();
                        String[] desp = new String[values[5].length()];
                        desp = values[5].split(";");
                        for(String i: desp){
                            str.add(i);
                        }
                        order.setProducts(str);
                        emp.add(order);
                    }
                }
                for(Order e: emp){
                    System.out.println(e);
                }
            }catch(IOException e){
                e.printStackTrace();
            }
            break;
            case 0:
                break;
            default:
                System.out.println("Nu exista aceasta optiune!!!!");
        }
    }

    public void writeInFile(){
        System.out.println("Fisierele sunt:");
        System.out.println("1. Fisier pentru angajat");
        System.out.println("2. Fisier pentru client");
        System.out.println("3. Fisier pentru produs");
        System.out.println("4. Fisier pentru comanda");
        System.out.println("0. EXIT");
        System.out.println("Vreau sa scriu in fisierul: ");
        int option;
        Scanner scan = new Scanner(System.in);
        option = scan.nextInt();
        switch (option){
            case 1:
                try(BufferedWriter bw = new BufferedWriter(new FileWriter(basePath+"fisierEmployee.txt",true))){
                    System.out.println("Ce doriti sa inserati in fisier?:");
                    String str;
                    Scanner scan2= new Scanner(System.in);
                    str = scan2.nextLine();
                    bw.write(str);
                    bw.write('\n');
                }catch(IOException e){
                    e.printStackTrace();
                }
                break;
            case 2:
                try(BufferedWriter bw = new BufferedWriter(new FileWriter(basePath+"fisierClient.txt",true))){
                    System.out.println("Ce doriti sa inserati in fisier?:");
                    String str;
                    Scanner scan2= new Scanner(System.in);
                    str = scan2.nextLine();
                    bw.write(str);
                    bw.write('\n');
                }catch(IOException e){
                    e.printStackTrace();
                }
                break;
            case 3:
                try(BufferedWriter bw = new BufferedWriter(new FileWriter(basePath+"fisierProduct.txt",true))){
                    System.out.println("Ce doriti sa inserati in fisier?:");
                    String str;
                    Scanner scanner= new Scanner(System.in);
                    str = scanner.nextLine();
                    bw.write(str);
                    bw.write('\n');
                }catch(IOException e){
                    e.printStackTrace();
                }
                break;
            case 4:
                try(BufferedWriter bw = new BufferedWriter(new FileWriter(basePath+"fisierOrder.txt",true))){
                    System.out.println("Ce doriti sa inserati in fisier?:");
                    String str;
                    Scanner scan2= new Scanner(System.in);
                    str = scan2.nextLine();
                    bw.write(str);
                    bw.write('\n');
                }catch(IOException e){
                    e.printStackTrace();
                }
                break;
        }
    }

    public void remove(){
        System.out.println("Fisierele sunt:");
        System.out.println("1. Fisier pentru angajat");
        System.out.println("2. Fisier pentru client");
        System.out.println("3. Fisier pentru produs");
        System.out.println("4. Fisier pentru comanda");
        System.out.println("0. EXIT");
        System.out.println("Vreau sa sterg din fisierul: ");
        Scanner scan = new Scanner(System.in);
        int option = scan.nextInt();
        switch (option){
            case 1:
                try(BufferedWriter bw = new BufferedWriter(new FileWriter(basePath+"fisierEmployee.txt"));
                    BufferedReader br = new BufferedReader(new FileReader(basePath+"fisierEmployee.txt"));){
                    System.out.println("Ce linie doriti sa stergeti din fisier");
                    Scanner scanner = new Scanner(System.in);
                    String line1 = scanner.nextLine();
                    String line;
                    while((line = br.readLine())!=null) {
                        if(!line.trim().equals(line1))
                            bw.write(line);
                    }
                }catch(IOException e){
                    e.printStackTrace();
                }
                break;
            case 2:
                try(BufferedWriter bw = new BufferedWriter(new FileWriter(basePath+"fisierClient.txt"));
                    BufferedReader br = new BufferedReader(new FileReader(basePath+"fisierClient.txt"));){
                    System.out.println("Ce linie doriti sa stergeti din fisier");
                    Scanner scanner = new Scanner(System.in);
                    String line1 = scanner.nextLine();
                    String line;
                    while((line = br.readLine())!=null) {
                        if(!line.trim().equals(line1))
                            bw.write(line);
                    }
                }catch(IOException e){
                    e.printStackTrace();
                }
                break;
            case 3:
                try(BufferedWriter bw = new BufferedWriter(new FileWriter(basePath+"fisierProduct.txt"));
                    BufferedReader br = new BufferedReader(new FileReader(basePath+"fisierProduct.txt"))){
                    System.out.println("Ce linie doriti sa stergeti din fisier");
                    Scanner scanner = new Scanner(System.in);
                    String line1 = scanner.nextLine();
                    String line;
                    while((line = br.readLine())!=null) {
                        if(!line.trim().equals(line1))
                            bw.write(line);
                    }
                }catch(IOException e){
                    e.printStackTrace();
                }
                break;
            case 4:
                try(BufferedWriter bw = new BufferedWriter(new FileWriter(basePath+"fisierOrder.txt"));
                    BufferedReader br = new BufferedReader(new FileReader(basePath+"fisierOrder.txt"));){
                    System.out.println("Ce linie doriti sa stergeti din fisier");
                    Scanner scanner = new Scanner(System.in);
                    String line1 = scanner.nextLine();
                    String line;
                    while((line = br.readLine())!=null) {
                        if(!line.trim().equals(line1))
                            bw.write(line);
                    }
                }catch(IOException e){
                    e.printStackTrace();
                }
                break;
            case 0:
                break;
        }
    }

    public void createTable() throws SQLException {
            System.out.println("Creeaza un tabel cu: ");
            System.out.println("1. Angajati");
            System.out.println("2. Clienti");
            System.out.println("3. Produse");
            System.out.println("4. Comenzi");
            System.out.println("0. EXIT");
            System.out.println("Vreau sa creez tabelul: ");
            Scanner scanner = new Scanner(System.in);
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    try {
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcschema",
                                "root", "!Nustiu123!");
                        PreparedStatement create = con.prepareStatement("CREATE TABLE IF NOT EXISTS " +
                                "employees(CNP varchar(20),Address varchar(45),Height int,EmployeeName varchar(45)," +
                                "Birthday varchar(45),PRIMARY KEY(EmployeeName))");
                        create.executeUpdate();
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    break;
                case 2:
                    try {
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcschema",
                                "root", "!Nustiu123!");
                        PreparedStatement create = con.prepareStatement("CREATE TABLE IF NOT EXISTS " +
                                "clients(CNP varchar(20),Address varchar(45),Height int,ClientID int," +
                                "ClientName varchar(45),OrderID int,PRIMARY KEY(ClientID,OrderID))");
                        create.executeUpdate();
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    break;
                case 3:
                    try {
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcschema",
                                "root", "!Nustiu123!");
                        PreparedStatement create = con.prepareStatement("CREATE TABLE IF NOT EXISTS " +
                                "products(ProductID int,ProductName varchar(45),PRIMARY KEY(ProductID))");
                        create.executeUpdate();
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    break;
                case 4:
                    try {
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcschema",
                                "root", "!Nustiu123!");
                        PreparedStatement create = con.prepareStatement("CREATE TABLE IF NOT EXISTS " +
                                "orders(OrderDate varchar(15),OrderID int,Products varchar(45),PRIMARY KEY(OrderID,Products))");
                        create.executeUpdate();
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    break;
            }
    }

    public void insertInTable(){
        System.out.println("Insereaza in tabelul cu: ");
        System.out.println("1. Angajati");
        System.out.println("2. Clienti");
        System.out.println("3. Produse");
        System.out.println("4. Comenzi");
        System.out.println("0. EXIT");
        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();
        switch (option){
            case 1:
                try{
                    System.out.println("Care este CNP-ul angajatului?");
                    Scanner scan4 = new Scanner(System.in);
                    String cnp = scan4.nextLine();
                    System.out.println("Care este adresa angajatului?");
                    Scanner scan5 = new Scanner(System.in);
                    String address = scan5.nextLine();
                    System.out.println("Care este inaltimea angajatului?");
                    Scanner scan6 = new Scanner(System.in);
                    String inal = scan6.nextLine();
                    System.out.println("Care este numele angajatului?");
                    Scanner scan = new Scanner(System.in);
                    String nume = scan.nextLine();
                    System.out.println("Care este data de nastere a angajatului?");
                    Scanner scan2 = new Scanner(System.in);
                    String date = scan2.nextLine();
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcschema",
                            "root", "!Nustiu123!");
                    PreparedStatement statement = con.prepareStatement("INSERT INTO employees(CNP,Address,Height" +
                            ",EmployeeName,Birthday) VALUES('"+cnp+"','"+address+"','"+inal+"','"+nume+"', '"+date+"')");
                    statement.executeUpdate();
                }catch (Exception e){
                    e.printStackTrace();
                }
                break;
            case 2:
                try{
                    System.out.println("Care este CNP-ul clientului?");
                    Scanner scan4 = new Scanner(System.in);
                    String cnp = scan4.nextLine();
                    System.out.println("Care este adresa clientului?");
                    Scanner scan5 = new Scanner(System.in);
                    String address = scan5.nextLine();
                    System.out.println("Care este inaltimea clientului?");
                    Scanner scan6 = new Scanner(System.in);
                    String inal = scan6.nextLine();
                    System.out.println("Care este ID-ul clientului?");
                    Scanner scan = new Scanner(System.in);
                    int id = scan.nextInt();
                    System.out.println("Care este numele clientului?");
                    Scanner scan2 = new Scanner(System.in);
                    String nume = scan2.nextLine();
                    System.out.println("Ce comenzi a dat?");
                    Scanner scan3 = new Scanner(System.in);
                    String comenzi = scan3.nextLine();
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcschema",
                            "root", "!Nustiu123!");
                    PreparedStatement statement = con.prepareStatement("INSERT INTO clients(CNP,Address,Height," +
                            "ClientID,ClientName,OrderID) VALUES('"+cnp+"','"+address+"','"+inal+"','"+id+"', '"+nume+"', '"+comenzi+"')");
                    statement.executeUpdate();
                }catch (Exception e){
                    e.printStackTrace();
                }
                break;
            case 3:
                try{
                    System.out.println("Care este ID-ul produsului?");
                    Scanner scan = new Scanner(System.in);
                    int id = scan.nextInt();
                    System.out.println("Care este numele produsului?");
                    Scanner scan2 = new Scanner(System.in);
                    String nume = scan2.nextLine();
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcschema",
                            "root", "!Nustiu123!");
                    PreparedStatement statement = con.prepareStatement("INSERT INTO products(ProductID,ProductName) " +
                            "VALUES('"+id+"', '"+nume+"')");
                    statement.executeUpdate();
                }catch (Exception e){
                    e.printStackTrace();
                }
                break;
            case 4:
                try{
                    System.out.println("Care este data comenzii?");
                    Scanner scan = new Scanner(System.in);
                    String date = scan.nextLine();
                    System.out.println("Care este ID-ul comenzii?");
                    Scanner scan2 = new Scanner(System.in);
                    int id = scan2.nextInt();
                    System.out.println("Ce produse contine?");
                    Scanner scan3 = new Scanner(System.in);
                    String products = scan3.nextLine();
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcschema",
                            "root", "!Nustiu123!");
                    PreparedStatement statement = con.prepareStatement("INSERT INTO employees(OrderDate,OrderID,Products) " +
                            "VALUES('"+date+"', '"+id+"', '"+products+"')");
                    statement.executeUpdate();
                }catch (Exception e){
                    e.printStackTrace();
                }
                break;
            case 0:
                break;
        }
    }

    public void selectFromTable() throws SQLException{
        System.out.println("Selecteaza din tabelul: ");
        System.out.println("1. Angajati");
        System.out.println("2. Clienti");
        System.out.println("3. Produse");
        System.out.println("4. Comenzi");
        System.out.println("0. EXIT");
        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();
        switch(option){
            case 1:
                try{
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcschema",
                           "root", "!Nustiu123!");
                    PreparedStatement statement = con.prepareStatement("Select * from employees");
                    ResultSet resultSet = statement.executeQuery();
                    while(resultSet.next()){
                        System.out.print(resultSet.getString("CNP"));
                        System.out.print(" ");
                        System.out.print(resultSet.getString("Address"));
                        System.out.print(" ");
                        System.out.print(resultSet.getString("Height"));
                        System.out.print(" ");
                        System.out.print(resultSet.getString("EmployeeName"));
                        System.out.print(" ");
                        System.out.println(resultSet.getString("Birthday"));
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
                break;
            case 2:
                try{
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcschema",
                            "root", "!Nustiu123!");
                    PreparedStatement statement = con.prepareStatement("Select * from clients");
                    ResultSet resultSet = statement.executeQuery();
                    while(resultSet.next()){
                        System.out.print(resultSet.getString("CNP"));
                        System.out.print(" ");
                        System.out.print(resultSet.getString("Address"));
                        System.out.print(" ");
                        System.out.print(resultSet.getString("Height"));
                        System.out.print(" ");
                        System.out.print(resultSet.getString("ClientID"));
                        System.out.print(" ");
                        System.out.print(resultSet.getString("ClientName"));
                        System.out.print(" ");
                        System.out.println("OrderID");
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
                break;
            case 3:
                try{
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcschema",
                            "root", "!Nustiu123!");
                    PreparedStatement statement = con.prepareStatement("Select * from products");
                    ResultSet resultSet = statement.executeQuery();
                    while(resultSet.next()){
                        System.out.print(resultSet.getString("ProductID"));
                        System.out.print(" ");
                        System.out.println(resultSet.getString("ProductName"));
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
                break;
            case 4:
                try{
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcschema",
                            "root", "!Nustiu123!");
                    PreparedStatement statement = con.prepareStatement("Select * from orders");
                    ResultSet resultSet = statement.executeQuery();
                    while(resultSet.next()){
                        System.out.print(resultSet.getString("OrderDate"));
                        System.out.print(" ");
                        System.out.print(resultSet.getString("OrderID"));
                        System.out.print(" ");
                        System.out.println("Prodcuts");
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
                break;
            case 0:
                break;
        }
    }

    public void deleteATable() throws SQLException{
        System.out.println("Ce tabel vrei sa stergi?");
        System.out.println("1. Angajati");
        System.out.println("2. Clienti");
        System.out.println("3. Produse");
        System.out.println("4. Comenzi");
        System.out.println("0. EXIT");
        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();
        switch(option) {
            case 1:
                try {
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcschema",
                            "root", "!Nustiu123!");
                    PreparedStatement statement = con.prepareStatement("DROP TABLE employees");
                    statement.executeUpdate();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case 2:
                try {
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcschema",
                            "root", "!Nustiu123!");
                    PreparedStatement statement = con.prepareStatement("DROP TABLE clients");
                    statement.executeUpdate();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case 3:
                try {
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcschema",
                            "root", "!Nustiu123!");
                    PreparedStatement statement = con.prepareStatement("DROP TABLE products");
                    statement.executeUpdate();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case 4:
                try {
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcschema",
                            "root", "!Nustiu123!");
                    PreparedStatement statement = con.prepareStatement("DROP TABLE orders");
                    statement.executeUpdate();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case 0:
                break;
        }
    }

    public void update(){
        System.out.println("Ce tabel vrei sa actualizezi?");
        System.out.println("1. Angajati");
        System.out.println("2. Clienti");
        System.out.println("3. Produse");
        System.out.println("4. Comenzi");
        System.out.println("0. EXIT");
        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();
        switch(option){
            case 1:
                try {
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcschema",
                            "root", "!Nustiu123!");
                    PreparedStatement statement = con.prepareStatement("UPDATE employees SET Address=? where EmployeeName=?");
                    System.out.println("Care e noua adresa a angajatului?:");
                    Scanner scan1 = new Scanner(System.in);
                    String address = scan1.nextLine();
                    System.out.println("Pe cat e nascut?");
                    Scanner scan2 = new Scanner(System.in);
                    String name = scan2.nextLine();
                    statement.setString(1,address);
                    statement.setString(2,name);
                    statement.executeUpdate();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case 2:
                try {
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcschema",
                            "root", "!Nustiu123!");
                    PreparedStatement statement = con.prepareStatement("UPDATE clients SET Address=? where ClientID=?");
                    System.out.println("Care e noua adresa a clientului?:");
                    Scanner scan1 = new Scanner(System.in);
                    String address = scan1.nextLine();
                    System.out.println("Ce ID are?");
                    Scanner scan2 = new Scanner(System.in);
                    String id = scan2.nextLine();
                    statement.setString(1,address);
                    statement.setString(2,id);
                    statement.executeUpdate();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case 3:
                try {
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcschema",
                            "root", "!Nustiu123!");
                    PreparedStatement statement = con.prepareStatement("UPDATE products SET ProductName=? where ProductID=?");
                    System.out.println("Care e noul nume al produsului?:");
                    Scanner scan1 = new Scanner(System.in);
                    String name = scan1.nextLine();
                    System.out.println("Ce ID are?");
                    Scanner scan2 = new Scanner(System.in);
                    String id = scan2.nextLine();
                    statement.setString(1,name);
                    statement.setString(2,id);
                    statement.executeUpdate();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case 4:
                try {
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcschema",
                            "root", "!Nustiu123!");
                    PreparedStatement statement = con.prepareStatement("UPDATE orders SET OrderDate=? where OrderID=?");
                    System.out.println("Care e noua data a comenzii?:");
                    Scanner scan1 = new Scanner(System.in);
                    String date = scan1.nextLine();
                    System.out.println("Ce ID are?");
                    Scanner scan2 = new Scanner(System.in);
                    String id = scan2.nextLine();
                    statement.setString(1,date);
                    statement.setString(2,id);
                    statement.executeUpdate();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case 0:
                break;
        }
    }
}

