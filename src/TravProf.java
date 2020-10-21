
public class TravProf {
    private String travAgentID;
    private String firstName;
    private String lastName;
    private String address;
    private String phone;
    private float tripCost;
    private String travelType;
    private String paymentType;
    private MedCond medCondInfo;

    public TravProf (String travAgentId_, String firstName_, String lastName_, String address_, String phone_,
                     float tripCost_, String travelType_, String paymentType_, MedCond medCondInfo_)
    {
        //construct TravProf object using provided arguments
        this.travAgentID = travAgentId_;
        this.firstName = firstName_;
        this.lastName = lastName_;
        this.address = address_;
        this.phone = phone_;
        this.tripCost = tripCost_;
        //only accept travelType if it is valid input
        if(travelType_.equals("Business") || travelType_.equals("Pleasure")) {
            this.travelType = travelType_;
        }
        //only accept paymentType if it is valid input
        if(paymentType_.equals("Credit") || paymentType_.equals("Check")
                || paymentType_.equals("Debit") || paymentType_.equals("Invoice")) {
            this.paymentType = paymentType_;
        }
        this.medCondInfo = medCondInfo_;
    }

    public String gettravAgentID () {
        return this.travAgentID;
    }

    public String getFirstName () {
        return this.firstName;
    }

    public String getLastName () {
        return this.lastName;
    }

    public String getAddress () {
        return this.address;
    }

    public String getPhone () {
        return this.phone;
    }

    public float getTripCost () {
        return this.tripCost;
    }

    public String getTravelType () {
        return this.travelType;
    }

    public String getPaymentType () {
        return this.paymentType;
    }

    public MedCond getMedCondInfo () {
        return this.medCondInfo;
    }

    public void updateFirstName(String newFirstName) {
        this.firstName = newFirstName;
    }

    public void updateLastName(String newLastName) {
        this.lastName = newLastName;
    }

    public void updateAddress (String newAddress) {
        this.address = newAddress;
    }

    public void updatePhone (String newPhone) {
        this.phone = newPhone;
    }

    public void updateTripCost(float newTripCost) {
        this.tripCost = newTripCost;
    }

    public void updateTravelType (String newTravelType) throws Exception {
        //update travelType if the new input is a valid travel type, otherwise throw error
        if (newTravelType.equals("Pleasure") || newTravelType.equals("Business")) {
            this.travelType = newTravelType;
        }
        else
        {
            throw new Exception("Travel type not valid");
        }
    }

    public void updatePaymentType(String newPaymentType) throws Exception {
        //update paymentType if the new input is a valid payment type, otherwise throw error
        if (newPaymentType.equals("Credit") || newPaymentType.equals("Check")
                || newPaymentType.equals("Debit") || newPaymentType.equals("Invoice")) {
            this.paymentType = newPaymentType;
        }
        else
        {
            throw new Exception("Payment type not valid");
        }
    }

    public void updateMedCondInfo (MedCond newMedCondInfo) {
        medCondInfo = newMedCondInfo;
    }

    public static void main(String[] agrs) throws Exception {
        MedCond testMedCond = new MedCond("Anthony Zeimbekakis", "(413) 123-4568", "none", "none");
        TravProf test = new TravProf("ID", "Matthew", "Pluta", "8 Glendale Rd", "(413) 123-4567", 1234, "Pleasure", "Credit", testMedCond);
        System.out.println(test.getPaymentType());
        test.updatePaymentType("Debit");
        System.out.println(test.getPaymentType());
    }
}
