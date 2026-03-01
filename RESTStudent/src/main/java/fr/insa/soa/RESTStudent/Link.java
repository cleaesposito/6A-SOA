package fr.insa.soa.RESTStudent;

public class Link {
    private String href;  
    private String relation; 

    public Link() {}

    public Link(String href, String relation) {
        this.href = href;
        this.relation = relation;
    }

    public String getHref() {return href;}
    public void setHref(String href) {this.href = href;}

    public String getRel() {return relation;}
    public void setRel(String relation) {this.relation = relation;}
}