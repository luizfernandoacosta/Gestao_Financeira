import javax.persistence.*;
import java.util.Date;

@Entity
public class Conta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //DECLARAÇÃO DAS VARIAVEÍS
    private int id;
    private float valor;
    @Temporal(TemporalType.DATE)
    private Date datacompra;
    @Temporal(TemporalType.DATE)
    private Date datapgmnto;
    private String meiopgmnto;
    private String descricao;

    //MÉTODOS GETTERS E SETTERS

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getValor(){return valor;}

    public void setValor(float valor){
        this.valor = valor;
    }

    public Date getDatacompra(){
        return datacompra;
    }

    public void setDatacompra(Date datacompra){
        this.datacompra = datacompra;
    }

    public Date getDatapgmnto(){
        return datapgmnto;
    }

    public void setDatapgmnto(Date datapgmnto){
        this.datapgmnto = datapgmnto;
    }

    public String getMeiopgmnto(){
        return meiopgmnto;
    }

    public void setMeiopgmnto(String meiopgmnto){
        this.meiopgmnto = meiopgmnto;
    }

    public String getDescricao(){
        return descricao;
    }

    public void setDescricao(String descricao){
        this.descricao = descricao;
    }
}