package entity;

public class Client {
    private int cl_id;
    private String cl_nick;
    private String cl_pass;

    public int getCl_id() {
        return cl_id;
    }

    public void setCl_id(int cl_id) {
        this.cl_id = cl_id;
    }

    public String getCl_nick() {
        return cl_nick;
    }

    public void setCl_nick(String cl_nick) {
        this.cl_nick = cl_nick;
    }

    public String getCl_pass() {
        return cl_pass;
    }

    public void setCl_pass(String cl_pass) {
        this.cl_pass = cl_pass;
    }
}
