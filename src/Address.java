public class Address {
    private String houseNum;
    private String streetName;
    private String apartmentNum; //optional
    private String city;
    private String state;
    private int zipCode;

    public Address(String hN, String sName, String aN, String c, String s, int zC) {
        houseNum = hN;
        streetName = sName;
        apartmentNum = aN;
        city = c;
        state = s;
        zipCode = zC;
    }

    public Address(Address copyAddress){
        houseNum = copyAddress.houseNum;
        streetName = copyAddress.streetName;
        apartmentNum = copyAddress.apartmentNum;
        city = copyAddress.city;
        state = copyAddress.state;
        zipCode = copyAddress.zipCode;
    }

    public Address(String fullAddress){
        houseNum = fullAddress.substring(0, fullAddress.indexOf(" "));
        if(fullAddress.contains("Apt")) {
            streetName = fullAddress.substring(fullAddress.indexOf(" ") + 1, fullAddress.indexOf("Apt")-1);
            apartmentNum = fullAddress.substring(fullAddress.indexOf("Apt") + 4, fullAddress.indexOf(","));
        }
        else{
            streetName = fullAddress.substring(fullAddress.indexOf(" ") + 1, fullAddress.indexOf(","));
            apartmentNum = "";
        }
        String csz = fullAddress.substring(fullAddress.indexOf(",") + 1);
        city = csz.substring(1, csz.indexOf(","));
        state = csz.substring(csz.indexOf(",") + 2, csz.indexOf(",") + 4);
        zipCode = Integer.parseInt(csz.substring(csz.length()-5));
    }

    public String getHouseNum() {
        return houseNum;
    }

    public void setHouseNum(String houseNum) {
        this.houseNum = houseNum;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getApartmentNum() {
        return apartmentNum;
    }

    public void setApartmentNum(String apartmentNum) {
        this.apartmentNum = apartmentNum;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public String toString(){
        if(apartmentNum.equals("")){
           return houseNum + " " + streetName + ", " + city + ", " + state + " " + zipCode;
        }
        return houseNum + " " + streetName + " " + "Apt " + apartmentNum + ", " + city + ", " + state + " " + zipCode;
    }



}
