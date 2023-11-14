package oneshot.model.dto;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "유저 모델", description = "유저 정보")
public class User {
    private int id;
    private String userEmail;
    private String password;
    private String nickName;
    private int admin;
    private String createdTime;
    private String updatedTime;

    public User() {
    }

    public User(String userEmail, String password, String nickName) {
        this.userEmail = userEmail;
        this.password = password;
        this.nickName = nickName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getAdmin() {
        return admin;
    }

    public void setAdmin(int admin) {
        this.admin = admin;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public String getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(String updatedTime) {
        this.updatedTime = updatedTime;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", userEmail=" + userEmail + ", password=" + password + ", nickName=" + nickName
                + ", admin=" + admin + ", createdTime=" + createdTime + ", updatedTime=" + updatedTime + "]";
    }

}
