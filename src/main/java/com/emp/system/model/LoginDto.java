package com.emp.system.model;

public class LoginDto {
    String employeeId;
    String password;

    public LoginDto(String employeeId, String password) {
        this.employeeId = employeeId;
        this.password = password;
    }

    public String getEmployeeId(){
        return employeeId;
    }
    public String getPassword(){
        return password;
    }
    public void setEmployeeId(String employeeId){
        employeeId=this.employeeId;
    }
    public void setPassword(String password){
        password=this.password;
    }
}

