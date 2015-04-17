/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author daniel.decarval
 */
@Stateless
@Named
public class LoginBean {
  private String username;
  private String password;
  private String group;
  private boolean isLogged;

  public String getUsername() {
    return this.username;
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
  
  public String login () {
    FacesContext context = FacesContext.getCurrentInstance();
    HttpServletRequest request = (HttpServletRequest) 
        context.getExternalContext().getRequest();
    
    
    try {
      request.login(this.username, this.password);
    } catch (ServletException e) {
      e.printStackTrace();
      context.addMessage(null, new FacesMessage("Login failed."));
        setIsLogged(false);
      return "/login/Login";
    }
    /*if(this.username.contains("admin"))
    {
        setIsLogged(true);
        return "/index";
    }*/
    setIsLogged(true);
    return "/index";
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
