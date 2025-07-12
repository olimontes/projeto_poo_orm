/*
 * Copyright (C) 2025 Luis Guisso &lt;luis dot guisso at ifnmg dot edu dot br&gt;
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
package io.github.guisso.javasepersistencewithhibernateorm.beta;

//import io.github.guisso.javasepersistencewithhibernateorm.beta.aluno.Aluno;
//import io.github.guisso.javasepersistencewithhibernateorm.beta.aluno.AlunoRepository;
import io.github.guisso.javasepersistencewithhibernateorm.beta.cliente.Cliente;
import io.github.guisso.javasepersistencewithhibernateorm.beta.cliente.ClienteRepository;
import io.github.guisso.javasepersistencewithhibernateorm.beta.itempedido.ItemPedido;
import io.github.guisso.javasepersistencewithhibernateorm.beta.itempedido.ItemPedidoRepository;
import io.github.guisso.javasepersistencewithhibernateorm.beta.pedido.Pedido;
import io.github.guisso.javasepersistencewithhibernateorm.beta.pedido.PedidoRepository;
import java.time.LocalDate;
import io.github.guisso.javasepersistencewithhibernateorm.beta.produto.Produto;
import io.github.guisso.javasepersistencewithhibernateorm.beta.produto.ProdutoRepository;
import java.time.LocalDateTime;

/**
 * Runs tests of the "Beta" version
 *
 * @author Luis Guisso &lt;luis dot guisso at ifnmg dot edu dot br&gt;
 * @version 0.1
 * @since 0.1, Jul 1, 2025
 */
public class Program {

    public static void betaTests() {

//        AlunoRepository alunoRepository = new AlunoRepository();
//        Long id;
//
//        Aluno a1 = new Aluno();
//        a1.setNome("Ana Zaira");
//        a1.setMatricula(123456789);
//        a1.setNascimento(LocalDate.of(1999, 7, 1));
//        
//        alunoRepository.saveOrUpdate(a1);
//        System.out.println("> " + a1);
//        
//        a1.setNome("Beariz Yana");
//        
//        id = alunoRepository.saveOrUpdate(a1);
//        System.out.println("> " + a1);
//        
//        Aluno a2 = alunoRepository.findById(id);
//        System.out.println("> " + a2);
//        
//        a2.setId(null);
//        a2.setNome("Cecília Xerxes");
//        
//        alunoRepository.saveOrUpdate(a2);
//        System.out.println("> " + a2);
//        
        ////        boolean excluded = alunoRepository.delete(id);
//        boolean excluded = alunoRepository.delete(a2);
//
//        System.out.println("> " + (excluded ? "Excluded" : "Exclusion fails..."));
//
//        CredencialRepository credencialRepository = new CredencialRepository();
//        
//        Credencial c1 = new Credencial();
//        c1.setEmail("y@mail.com");
//        c1.setSenha("123456");
//        
////        credencialRepository.saveOrUpdate(c1);
////        if(true) return;
//        
//        UsuarioRepository usuarioRepository = new UsuarioRepository();
//        
//        Usuario u1 = new Usuario();
//        u1.setNome("Ana Zaira");
//        
//        u1.setCredencial(c1); // <---------------------------------------------
//        c1.setUsuario(u1); // <---------------------------------------------
//        
//        usuarioRepository.saveOrUpdate(u1);
//        
//        Usuario u2 = usuarioRepository.findById(1L);
//        
//        System.out.println("> " + u2.getCredencial().getEmail());

 ProdutoRepository produtoRepository = new ProdutoRepository();

        Long id;
        Produto p1 = new Produto();
        p1.setNome("Anel");
        p1.setMaterial("Prata 911");
        p1.setDescricao("Produto de boa qualidade");
        p1.setPreco_venda(95);
        p1.setQtd_estoque(21);
        p1.setPeso(5);
        p1.setQtd_estoque(26);
        p1.setTipo("Cravejado");

        //Salvando um produto
        produtoRepository.saveOrUpdate(p1);
        System.out.println("> " + p1);

        //Buscando um produto pelo id
        Produto p2 = produtoRepository.findById(1L);
        System.out.println("> " + p2.getNome());

        //Atualizando um produto e salvando
        p2.setNome("Corrente");
        produtoRepository.saveOrUpdate(p2);
        System.out.println("> " + p2.getNome());

        ////////////////////////////////////////////////////////////////////////
        
        ClienteRepository clienteRepository = new ClienteRepository();
        //Long id;
        Cliente c1 = new Cliente();
        c1.setNome("Paulo");
        c1.setCpf("123456577786793");
        c1.setEmail("paulo@gmail.com");

        //Salvando um cliente
        clienteRepository.saveOrUpdate(c1);
        System.out.println("> " + c1.getNome());

        //Buscando um cliente pelo id
        Cliente c2 = clienteRepository.findById(1L);
        System.out.println("> " + c2.getNome());

        //Atualizando um cliente e salvando
        c2.setNome("Pedro");
        clienteRepository.saveOrUpdate(c2);
        System.out.println("> " + c2.getNome());

        ////////////////////////////////////////////////////////////////////////
        
        ItemPedidoRepository itemPedidoRepository = new ItemPedidoRepository();
        ItemPedido i1 = new ItemPedido();
        i1.setQuantidade(3);

        //Salvando um itemPedido
        //itemPedidoRepository.saveOrUpdate(i1);
        //System.out.println("> " + i1.getQuantidade());

        //Buscando um ItemPedido pelo id
        ItemPedido i2 = itemPedidoRepository.findById(1L);
        System.out.println("> " + i2.getQuantidade());

        //Atualizando um itemPedido e salvando
        i2.setQuantidade(5);
        itemPedidoRepository.saveOrUpdate(i2);
        System.out.println("> " + i2.getQuantidade());

        ////////////////////////////////////////////////////////////////////////

    PedidoRepository pedidoRepository = new PedidoRepository();

// Buscando cliente já existente
        Cliente clientePedido = clienteRepository.findById(1L);
        if (clientePedido == null) {
            System.out.println("Cliente com ID 1 não encontrado!");
            return;
        }

        Pedido pedido1 = new Pedido();
        pedido1.setCliente(clientePedido);
        pedido1.setStatus(Pedido.StatusPedido.CRIADO);
        pedido1.setDataCriacao(LocalDateTime.now());

// Criando o item e associando ao pedido via método helper
        ItemPedido item1 = new ItemPedido();
        item1.setQuantidade(3);

// Método addItemPedido deve ser implementado para manter as duas associações consistentes
        pedido1.addItemPedido(item1);

// Salvando o pedido com os itens em cascata
        pedidoRepository.saveOrUpdate(pedido1);

        System.out.println("> Pedido salvo com ID: " + pedido1.getId());

// Buscando o pedido para confirmar
        Pedido pedido2 = pedidoRepository.findById(pedido1.getId());
        System.out.println("> Pedido do cliente: " + pedido2.getCliente().getNome());

// Atualizando status do pedido
        pedido2.setStatus(Pedido.StatusPedido.ENVIADO);
        pedidoRepository.saveOrUpdate(pedido2);
        System.out.println("> Status atualizado: " + pedido2.getStatus());

    }

}
