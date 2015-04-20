/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import jpa.entities.User;

/**
 *
 * @author daniel.decarval
 */
@ManagedBean(name="loginBean")
public class LoginBean {
  private String username;
  private String password;
  private String group;
  private boolean isLogged;
  private String role;
  @PersistenceContext(unitName = "MyMovieCollectionPU")
  private EntityManager entityManager;
  
  public String getUsername() {
    return this.username;
  }
  
  
  public int getUserId(String username)
    {                
        //this.idUser = Integer.parseInt(request.getUserPrincipal().getName());
        System.out.println("YOLO"+username);

        Query query = this.entityManager.createQuery("SELECT u FROM User u WHERE u.username = :username").setParameter("username", username);
        List<User> results = query.getResultList();
        User user = results.get(0);
        
        return user.getId();
    }
  
  public String getRole()
  {
      return this.role;
  }
  
  public void setRole(String role)
  {
      this.role = role;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
  
  public String getGroup()
  {
      return this.group;
  }
  
  public void setGroup(String group)
  {
      this.group = group;
  }
  
  public boolean  getIsLogged()
  {
      return isLogged;
  }
  
  public void setIsLogged(boolean isLogged)
  {
      this.isLogged = isLogged;
  }
  
  public void killSession()
  {
        ((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(isLogged)).invalidate();
  }
  
  public String login () throws IOException {
    String message = "";
    String navto = "";
    
    HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
    List queryUser = new ArrayList();
    List queryGroup = new ArrayList();
    
        try {
            request.login(this.username, this.password);
            
            queryUser = this.entityManager.createQuery("SELECT u.role FROM User u WHERE u.username=:username").setParameter("username", this.username).getResultList();
            this.role = (String) queryUser.get(0);
            queryGroup = this.entityManager.createQuery("SELECT g.groupname FROM Groups g WHERE g.groupname = :groupname").setParameter("groupname", this.role).getResultList();

            //Retrieve the Principal
            Principal principal = request.getUserPrincipal();
                                    
            //Display a message based on the User role
            if(request.isUserInRole("Administrator")){
                message = "Username : " + principal.getName() + " You are an Administrator, you can really f**k things up now";
                System.out.println("List : " + navto);
                
                navto = "/admin/List.xhtml&faces-redirect=true";
                            

            }else if(request.isUserInRole("Manager")){
                message = "Username : " + principal.getName() + " You are only a Manager, Don't you have a Spreadsheet to be working on??";
            }else if(request.isUserInRole("User")){
                message = "Username : " + principal.getName() + " You're wasting my resources...";
            }
             
            //Add the welcome message to the faces context
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, null));
            setIsLogged(true);
            
            
            System.out.println("Login : " + navto);
            return navto;
            
        } catch (ServletException e) {
            navto = "/login/Login.xhtml";
            setIsLogged(false);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "An Error Occured: Login failed", null));
            e.printStackTrace();
        }
        return navto;
  }

  public String logout() {
      
      
    FacesContext context = FacesContext.getCurrentInstance();
    HttpServletRequest request = (HttpServletRequest) 
        context.getExternalContext().getRequest();
    try {
      request.logout();
      setIsLogged(false);
      killSession();
    } catch (ServletException e) {
      e.printStackTrace();
      context.addMessage(null, new FacesMessage("Logout failed."));
    }
    
    return "/index";
  }
}
