
public class Celda {
    private boolean tieneMina;
    private boolean descubierta;
    private boolean tieneBandera;
    private int minasAlrededor;
    
    public Celda() {
        this.tieneMina = false;
        this.descubierta = false;
        this.tieneBandera = false;
        this.minasAlrededor = 0;
    }
    
    // Getters y setters
    public boolean isTieneMina() {
        return tieneMina;
    }
    
    public void setTieneMina(boolean tieneMina) {
        this.tieneMina = tieneMina;
    }
    
    public boolean isDescubierta() {
        return descubierta;
    }
    
    public void setDescubierta(boolean descubierta) {
        this.descubierta = descubierta;
    }
    
    public boolean isTieneBandera() {
        return tieneBandera;
    }
    
    public void setTieneBandera(boolean tieneBandera) {
        this.tieneBandera = tieneBandera;
    }
    
    public int getMinasAlrededor() {
        return minasAlrededor;
    }
    
    public void setMinasAlrededor(int minasAlrededor) {
        this.minasAlrededor = minasAlrededor;
    }
}