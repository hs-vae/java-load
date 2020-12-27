package com.hs_vae.Experiment.Demo1;
import java.io.Serializable;
//对log.txt日志文件的字段进行对象封装
public class Log implements Serializable {            //序列化和反序列化的时候,会抛出NotSerializableException没有序列化异常
    private static  final  long serialVersiouUID=1L;  //可以解决序列化冲突异常
    private String name;
    private String time;
    private String Ip;
    private String status;
    private String information;
    public String getName() {
        return name;
    }
    @Override
    public String toString() {
        return  "Log{" +
                "name='" + name + '\'' +
                ", time='" + time + '\'' +
                ", Ip='" + Ip + '\'' +
                ", status='" + status + '\'' +
                ", information='" + information + '\'' +
                '}';
    }

    public Log(String name, String time, String Ip, String status, String information) {
        this.name = name;
        this.time=time;
        this.Ip=Ip;
        this.status=status;
        this.information=information;
    }
    public Log(String s) {
    }

    public String getIp() {
        return Ip;
    }


    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setIp(String ip) {
        Ip = ip;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setName(String name) {
        this.name = name;
    }
}
