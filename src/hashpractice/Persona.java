
package hashpractice;

public class Persona {
    
    private String id;
    private String first_name;
    private String last_name;
    private String gender;

    public Persona(String id, String first_name, String last_name, String gender) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getGender() {
        return gender;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    
    @Override
    public int hashCode(){
        String llaveHash = id;
        
        int hash = 0;
        while(!llaveHash.isEmpty())
        {
            hash += (int)(llaveHash.charAt(0)) * Math.pow(2, llaveHash.length()-1);
            llaveHash = llaveHash.substring(1);
        }
        return hash;
    }
    
    @Override
    public boolean equals(Object o)
    {
        Persona otra = (Persona)o;
        return id.equals(otra.id);
    }
}
