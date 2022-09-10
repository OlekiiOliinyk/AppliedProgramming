public class Abiturient {
    private int id;
    private String surname;
    private String name;
    private String patronymic;
    private String address;
    private String telephone;
    private double avgScore;

    public String toString(){
        return("\n-----------------------------------" + // для наочності кожного об'єкту
                "\nID: " + this.id +
                "\nПрізвище: " + this.name +
                "\nПо-батькові: " + this.patronymic +
                "\nАдреса: " + this.address +
                "\nТелефон: " + this.telephone +
                "\nСередній бал: " + this.avgScore);
    }

    public int getId(){return this.id;}
    public String getSurname(){return this.surname;}
    public String getName(){return this.name;}
    public String getPatronymic(){return this.patronymic;}
    public String getAddress(){return this.address;}
    public String getTelephone(){return this.telephone;}
    public double getAvgScore(){return this.avgScore;}

    public void setId(int id){this.id = id;}
    public void setSurname(String surname){this.surname = surname;}
    public void setName(String name){this.name = name;}
    public void setPatronymic(String patronymic){this.patronymic = patronymic;}
    public void setAddress(String address){this.address = address;}
    public void setTelephone(String telephone){this.telephone = telephone;}
    public void setAvgScore(double avgScore){this.avgScore = avgScore;}

}
