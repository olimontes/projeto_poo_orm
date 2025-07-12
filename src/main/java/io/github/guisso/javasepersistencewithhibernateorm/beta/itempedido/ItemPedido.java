/*
 * Copyright (C) 2025 fgabr
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package io.github.guisso.javasepersistencewithhibernateorm.beta.itempedido;

import io.github.guisso.javasepersistencewithhibernateorm.beta.pedido.Pedido;
import io.github.guisso.javasepersistencewithhibernateorm.beta.repository.ProjectEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.io.Serializable;

/**
 *
 * @author fgabr
 */
@Entity

public class ItemPedido extends ProjectEntity
        implements Serializable {

    @ManyToOne(optional = false)
    @JoinColumn(name = "pedido_id") // nome da coluna FK no banco
    private Pedido pedido;

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

//TODO relacionamento a ser feito mais frente
//    @Column(nullable = true)
//    private Produto produto;
    @Column(nullable = true)
    private int quantidade;

//<editor-fold defaultstate="collapsed" desc="get/set">
    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    //</editor-fold>

  

}
