import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.io.FileWriter;
import java.util.Scanner;

public class TravProfDB {
    private int numTravelers;
    private int currentTravelerIndex;
    private String fileName;
    //private TravProf[] travelerList;
    private ArrayList<TravProf> travelerList;

    //allocate, then expand when numTravelers exceeds it
    public TravProfDB(String fileName_) {
        this.fileName = fileName_;
        this.travelerList = new ArrayList<TravProf>();
    }

    private void insertNewProfile(TravProf newProfile) {
        this.travelerList.add(newProfile);
        this.currentTravelerIndex++;
        this.numTravelers++;
    }

    public TravProf findProfile(String travAgentID, String lastName) throws Exception{
        for(int i = 0; i < this.travelerList.size(); i++)
        {
            if((this.travelerList.get(i).gettravAgentID().equals(travAgentID)) &&
                    this.travelerList.get(i).getLastName().equals(lastName))
            {
                return this.travelerList.get(i);
            }
        }

        throw new Exception("Profile not found");
    }
    //helper function to return index, -1 if not found

    public boolean deleteProfile(String travAgentID, String lastName) throws Exception{
        TravProf profile;

        try {
            profile = this.findProfile(travAgentID, lastName);
        }
        catch (Exception e) {
            return false;
        }

        int index = this.travelerList.indexOf(profile);
        //get index from find and start there
        this.travelerList.remove(index);

        return true;
    }

    public TravProf findFirstProfile() {
        return this.travelerList.get(0);
    }

    public TravProf findNextProfile() {
        if (this.currentTravelerIndex + 1 > this.travelerList.size() - 1)
        {
            this.currentTravelerIndex = 0;
            return this.findFirstProfile();
        }
        else
        {
            this.currentTravelerIndex++;
            return this.travelerList.get(this.currentTravelerIndex);
        }
    }

    public void writeAllTravProf(String x) throws IOException {
        FileWriter fw = new FileWriter(this.fileName);
        for(int i = 0; i < this.travelerList.size(); i++)
        {
            fw.write(this.travelerList.get(i).gettravAgentID() + "\n");
            fw.write(this.travelerList.get(i).getFirstName() + "\n");
            fw.write(this.travelerList.get(i).getLastName() + "\n");
            fw.write(this.travelerList.get(i).getAddress() + "\n");
            fw.write(this.travelerList.get(i).getPhone() + "\n");
            fw.write(this.travelerList.get(i).getTripCost() + "\n");
            fw.write(this.travelerList.get(i).getTravelType() + "\n");
            fw.write(this.travelerList.get(i).getPaymentType() + "\n");
            fw.write(this.travelerList.get(i).getMedCondInfo().getMdContact() + "\n");
            fw.write(this.travelerList.get(i).getMedCondInfo().getMdPhone() + "\n");
            fw.write(this.travelerList.get(i).getMedCondInfo().getAlgType() + "\n");
            fw.write(this.travelerList.get(i).getMedCondInfo().getIllType() + "\n");
        }
        fw.close();
    }

    public void initializeDatabase(String x) {
        Scanner reader = new Scanner(this.fileName);

        String travAgentID = "";
        String firstName = "";
        String lastName = "";
        String address = "";
        String phone = "";
        float tripCost = 0;
        String travelType = "";
        String paymentType = "";
        String mdContact = "";
        String mdPhone = "";
        String algType = "";
        String illType = "";

        //reads file
        while(reader.hasNextLine()) {

            //builds profile
            travAgentID = reader.nextLine();
            firstName = reader.nextLine();
            lastName = reader.nextLine();
            address = reader.nextLine();
            phone = reader.nextLine();
            tripCost = Float.parseFloat(reader.nextLine());
            travelType = reader.nextLine();
            paymentType = reader.nextLine();
            mdContact = reader.nextLine();
            mdPhone = reader.nextLine();
            illType = reader.nextLine();
            algType = reader.nextLine();

            this.insertNewProfile(new TravProf(travAgentID, firstName, lastName, address, phone, tripCost, travelType, paymentType, new MedCond(mdContact, mdPhone, algType, illType)));
        }
    }
}