package az.rahilv.rahilapi.util;

import az.rahilv.rahilapi.model.User;
import az.rahilv.rahilapi.response.RespStatus;
import az.rahilv.rahilapi.response.RespUser;
import az.rahilv.rahilapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

public class ExceptionConstants {
    public static final Integer INTERNAL_EXCEPTION = 101;
    public static final Integer USER_NOT_EXISTS = 102;

}
