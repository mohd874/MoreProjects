/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ae.hct.admc.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Saeed
 */

@Entity
@Table(name="system_user")
public class User extends BaseEntity{

    @Column(name="login_name")
    private String loginName;
    
    @Column(name="login_password")
    private String password;
    
    @JoinColumn(name = "role", referencedColumnName = "id")
    @ManyToOne
    private Role role;

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
    /*
     TODO add user type
     */
    
}
