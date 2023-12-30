public class Client {
    public int id;
    public String FirstName;
    public String LastName;
    public String PhoneNumber;
    public String Mail;

    public Client(int id, String FirstName,String LastName,String PhoneNumber,String Mail)
    {
        this.id = id;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.PhoneNumber = PhoneNumber;
        this.Mail = Mail;
    }

    //getters

    public int getId(){return id;}
    public String getFirstName(){return FirstName;}
    public String getLastName(){return LastName;}
    public String getPhoneNumber(){return PhoneNumber;}
    public String getMail(){return Mail;}

    //setters

    public void setId(int id)
    {
        this.id = id;
    }

    public void setFirstName(String FN)
    {
        this.FirstName = FN;
    }

    public void setLastName(String LN)
    {
        this.LastName = LN;
    }

    public void setPhoneNumber(String PN)
    {
        this.PhoneNumber = PN;
    }

    public void setMail(String Mail)
    {
        this.Mail = Mail;
    }
}
