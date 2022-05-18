package proiect;

import java.util.*;

public class Client extends Person implements Comparable<Client>{
    protected int clientID;
    protected String clientName;
    private List<Order> orders = new ArrayList<>();

    public Client(){
        clientID = 0;
        clientName = " ";
        orders = null;
    }
    public Client(String cnp, String address, int height,int clientID, String clientName, List orders) {
        super(cnp, address, height);
        this.clientID = clientID;
        this.clientName = clientName;
        this.orders = orders;
    }

    public String getCnp(){return cnp;}
    public void setCnp(String cnp){this.cnp=cnp;}

    public String getAddress(){return address;}
    public void setAddress(String address){this.address=address;}

    public int getHeight(){return height;}
    public void setHeight(int height){this.height=height;}

    public int getClientID() {return clientID;}
    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public String getClientName() {
        return clientName;
    }
    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public List getOrders() {
        return orders;
    }
    public void setOrders(List orders) {
        this.orders = orders;
    }

    @Override
    public void work() {
        System.out.println("Lucrez pentru restaurant!");
    }

    public String toString(){
        return super.toString()+". Clientul " + clientName +" are codul " + clientID +" iar comenzile lui sunt "+
                Arrays.toString(orders.toArray());
    }
    public int compareTo(Client j){
        Integer _clientID = new Integer(this.clientID);
        return _clientID.compareTo(j.clientID);
    }

    public boolean equals(Object obj){
        if(this == obj) return true;
        if(obj == null || this.getClass() != obj.getClass()) return false;
        Client client = (Client) obj;
        return this.clientID == client.clientID && Objects.equals(this.clientName,client.clientName);
    }
}
