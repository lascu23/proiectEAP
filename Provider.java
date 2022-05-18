package proiect;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Provider implements Comparable<Provider>{
    private String provider;
    private int phone;
    private String city;
    private List<RawMaterial> rm = new ArrayList<>();

    Provider(){
        provider = " ";
        phone = 0;
        city = " ";
        rm = null;
    }

    public Provider(String provider, int phone, String city, List rm) {
        this.provider = provider;
        this.phone = phone;
        this.city = city;
        this.rm = rm;
    }

    public String getProvider() {
        return provider;
    }
    public void setProvider(String provider) {
        this.provider = provider;
    }

    public int getPhone() {
        return phone;
    }
    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    public List getRm() {
        return rm;
    }
    public void setRm(List rm) {
        this.rm = rm;
    }

    public String toString(){
        return "Furnizorul " + provider + " vine din " + city + " si are numarul de telefon " + phone+
                " iar materiile sunt "+ Arrays.toString(rm.toArray());
    }


    public int compareTo(Provider j){
        String _provider = new String(this.provider);
        return _provider.compareTo(j.provider);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Provider)) return false;
        Provider provider1 = (Provider) o;
        return phone == provider1.phone && provider.equals(provider1.provider) && city.equals(provider1.city);
    }
}
