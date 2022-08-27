package SanjaValley.Persuance.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="PALAVRA")
public class Palavra {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "PA_NOME")
    private String nome;

    @Column(name = "PA_TRADUCAO")
    private String traducao;

    @Column(name = "PA_APROVADA")
    private boolean aprovada;

    @Column(name = "PA_SIGNIFICADO")
    private String descricao;


}
