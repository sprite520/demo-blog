package rhr.po;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "t_user")
public class User {

    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private String password;
    private String avatar;
    private String nichen;
    private String xingqing;
    private String yingsi;
    private String sex;
    private String juzhudi;
    private String wangzhanming;
    private String wangzhi;
    private String qqnumber;
    private String weixingnumber;
    private String weibonumber;
    private String githubnumber;

    @OneToMany(mappedBy = "user")
    private List<Blog> blogs = new ArrayList<>();

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public void setNichen(String nichen){this.nichen=nichen;}
    public void setYingsi(String yingsi){this.yingsi=yingsi;}
    public void setSex(String sex){this.sex=sex;}
    public void setXingqing(String xingqing){this.xingqing=xingqing;}
    public void setJuzhudi(String juzhudi){this.juzhudi=juzhudi;}
    public void setWangzhanming(String wangzhanming){this.wangzhanming=wangzhanming;}
    public void setWangzhi(String wangzhi){this.wangzhi=wangzhi;}
    public void setQqnumber(String qqnumber){this.qqnumber=qqnumber;}
    public void setWeixingnumber(String weixingnumber){this.weixingnumber=weixingnumber;}
    public void setWeibonumber(String weibonumber){this.weibonumber=weibonumber;}
    public void setGithubnumber(String githubnumber){this.githubnumber=githubnumber;}

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public List<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", avatar='" + avatar + '\'' +
                '}';
    }
}
