
public class MedCond {
    private String mdContact;
    private String mdPhone;
    private String algType;
    private String illType;

    public MedCond (String mdContact_, String mdPhone_, String algType_, String illType_) {
        //construct new MedCond object using provided arguments
        this.mdContact = mdContact_;
        this.mdPhone = mdPhone_;
        //only accept algType if it is valid input
        if (algType_.equals("none") || algType_.equals("food")
                || algType_.equals("medication") || algType_.equals("other"))
        {
            this.algType = algType_;
        }
        //only accept illType if it is valid input
        if (illType_.equals("none") || illType_.equals("heart")
                || illType_.equals("diabetes") || illType_.equals("asthma")
                || illType_.equals("other"))
        {
            this.illType = illType_;
        }
    }

    public String getMdContact () {
        return this.mdContact;
    }

    public String getMdPhone() {
        return this.mdPhone;
    }

    public String getAlgType() {
        return this.algType;
    }

    public String getIllType() {
        return this.illType;
    }

    public void updateMdContact(String newMdContact) {
        this.mdContact = newMdContact;
    }

    public void updateMdPhone(String newMdPhone) {
        this.mdPhone = newMdPhone;
    }

    public void updateAlgType(String newAlgType) throws Exception {
        //update algType if the new input is a valid allergy, otherwise throw error
        if (newAlgType.equals("none") || newAlgType.equals("food")
                || newAlgType.equals("medication") || newAlgType.equals("other"))
        {
            this.algType = newAlgType;
        }
        else
        {
            throw new Exception("Invalid allergy");
        }
    }

    public void updateIllType(String newIllType) throws Exception {
        //update illType if the new input is a valid illness, otherwise throw error
        if (newIllType.equals("none") || newIllType.equals("heart")
                || newIllType.equals("diabetes") || newIllType.equals("asthma")
                || newIllType.equals("other"))
        {
            this.illType = newIllType;
        }
        else
        {
            throw new Exception("Invalid illness");
        }
    }

    public static void main(String[] args) throws Exception {
        MedCond test = new MedCond("Anthony Zeimbekakis", "1234568", "none", "none");
        System.out.println(test.getAlgType());
        test.updateAlgType("use case diagrams");
        System.out.println(test.getAlgType());
    }
}