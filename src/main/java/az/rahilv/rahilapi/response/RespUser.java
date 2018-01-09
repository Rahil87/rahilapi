package az.rahilv.rahilapi.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class RespUser {

    private String username;
    private String name;
    private String surname;
    private RespStatus respStatus;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public RespStatus getRespStatus() {
        return respStatus;
    }

    public void setRespStatus(RespStatus respStatus) {
        this.respStatus = respStatus;
    }
}
