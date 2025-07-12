package io.github.guisso.javasepersistencewithhibernateorm.beta.pedido;

import io.github.guisso.javasepersistencewithhibernateorm.beta.cliente.Cliente;
import io.github.guisso.javasepersistencewithhibernateorm.beta.itempedido.ItemPedido;
import io.github.guisso.javasepersistencewithhibernateorm.beta.repository.ProjectEntity;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Pedido extends ProjectEntity {
    
    public enum StatusPedido {
        CRIADO,
        PROCESSADO,
        CANCELADO,
        ENVIADO
    }

    @ManyToOne(optional = false)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemPedido> itens = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusPedido status;

    @Column(nullable = false)
    private LocalDateTime dataCriacao;

    // Getters e setters

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedido> itens) {
        this.itens = itens;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    // Método auxiliar para adicionar item
    public void addItemPedido(ItemPedido item) {
        itens.add(item);
        item.setPedido(this);
    }

    // Método auxiliar para remover item
    public void removeItemPedido(ItemPedido item) {
        itens.remove(item);
        item.setPedido(null);
    }
}
