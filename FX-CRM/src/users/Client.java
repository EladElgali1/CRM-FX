package users;
import org.json.simple.JSONObject;
/**
 * Created by elad on 14/08/2017.
 */
public class Client extends Person{

    private String invoiceNumber="";
    private boolean asAgreement=false;
    private boolean asMedicalcCertificate=false;
    JSONObject obj;
    private Coach coach=null;
    private int bandNumber=0;
    private  boolean asGroup=false;


    public Client(String name, String id, String phone, String address, String age, String invoiceNumber, boolean asAgreement) {
        super();
        super.setName(name);
        super.setId(id);
        super.setPhone(phone);
        super.setAddress(address);
        super.setAge(age);
        this.invoiceNumber = invoiceNumber;
        this.asAgreement = asAgreement;


    }

    public Client() {

    }

    public String toJason(){
        obj = new JSONObject();

        obj.put("name",super.getName());
        obj.put("id",super.getId());
        obj.put("phone",super.getPhone());
        obj.put("address",super.getAddress());
        obj.put("age",super.getAge());
        obj.put("invoiceNumber",invoiceNumber);
        obj.put("asMedicalcCertificate",asMedicalcCertificate);
        return  obj.toJSONString();
    }

    public void setCoach(Coach coach){
        this.coach=coach;
    }
    public Coach getCoach(){
        return coach;
    }

    public void setAsMedicalcCertificate(boolean flag){
        asMedicalcCertificate=flag;
    }
    public boolean getAsMedicalcCertificate(){
        return asMedicalcCertificate;
    }


    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public boolean isAsAgreement() {
        return asAgreement;
    }

    public void setAsAgreement(boolean asAgreement) {
        this.asAgreement = asAgreement;
    }


    public boolean isAsGroup() {
        return asGroup;
    }

    public void setAsGroup(boolean asGroup) {
        this.asGroup = asGroup;
    }

    public int getBandNumber() {
        return bandNumber;
    }

    public void setBandNumber(int bandNumber) {
        this.bandNumber = bandNumber;
    }





    @Override
    public String toString() {
        return toJason()+"\n" ;

    }
}
