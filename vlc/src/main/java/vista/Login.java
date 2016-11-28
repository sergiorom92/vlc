package vista;

import co.com.session.EmpleadoFacade;
import co.com.session.PersonaFacade;
import entidad.Empleado;
import java.io.Serializable;
import javax.ejb.EJB;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import login.SessionUtils;

@ManagedBean
@SessionScoped
public class Login implements Serializable {

    @EJB
    EmpleadoFacade ef;

    @EJB
    PersonaFacade pf;

    private static final long serialVersionUID = 1094801825228386363L;

    private String pwd;
    private String msg;
    private String user;
    private String nombre;

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getMsg() {
        return msg;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String validateUsernamePassword() {
        Empleado empleado = ef.buscarEmpleado(user);

        if (empleado != null) {
            if (empleado.getContrasena().equalsIgnoreCase(pwd)) {
                HttpSession session = SessionUtils.getSession();
                nombre = pf.buscarPersona(user).getNombre();
                session.setAttribute("username", nombre);
                if (!empleado.isGerente()) {
                    return "menuEmpleado";
                }
                return "menuGerente";
            }
        } else {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Contraseña o nombre de usuario incorrectos",
                            "Por favor verifique nombre de usuario y contraseña"));
            return "index";
        }
        FacesContext.getCurrentInstance().addMessage(
                null,
                new FacesMessage(FacesMessage.SEVERITY_WARN,
                        "Contraseña o nombre de usuario incorrectos",
                        "Por favor verifique nombre de usuario y contraseña"));
        return "index";
    }

    public String logout() {
        HttpSession session = SessionUtils.getSession();
        session.invalidate();
        return "index";
    }
}
