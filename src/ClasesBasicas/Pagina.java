package ClasesBasicas;

public class Pagina {

    //Atributos
    private String url;
    private String descripcion;
    private int pageRank;
    private String [] palabrasClaves;
    private String enlacesReferente;

    //Constructor con parametros
    public Pagina(String url, String descripcion, int pageRank, String[] palabrasClaves, String enlacesReferente) {
        this.url = url;
        this.descripcion = descripcion;
        this.pageRank = pageRank;
        this.palabrasClaves = palabrasClaves;
        this.enlacesReferente = enlacesReferente;
    }

    //Constructor por defecto
    public Pagina() {
        url = "google";
        descripcion = "maravillosa";
        pageRank = 0;
        palabrasClaves = new String[]{"vacio"};
        enlacesReferente = "otrapagina";
    }

    //Getters and setters
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPageRank() {
        return pageRank;
    }

    public void setPageRank(int pageRank) {
        this.pageRank = pageRank;
    }

    public String[] getPalabrasClaves() {
        return palabrasClaves;
    }

    public void setPalabrasClaves(String[] palabrasClaves) {
        this.palabrasClaves = palabrasClaves;
    }

    public String getEnlacesReferente() {
        return enlacesReferente;
    }

    public void setEnlacesReferente(String enlacesReferente) {
        this.enlacesReferente = enlacesReferente;
    }


}
