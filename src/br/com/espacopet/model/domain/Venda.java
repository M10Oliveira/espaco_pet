/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.espacopet.model.domain;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Matheus Oliveira
 */
public class Venda {
    
    private int id;
    private LocalDate data;
    private BigDecimal total;
    private boolean pago;
    
    private EStatusVenda statusVenda;
    
    private List<ItemDeVenda> itensDeVenda;
    private Cliente cliente;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public BigDecimal getTotal() {
        calcularTotalVenda();
        return total;
    }
    
    public boolean isPago() {
        return pago;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }

    
    public EStatusVenda getStatusVenda() {
        return statusVenda;
    }

    public void setStatusVenda(EStatusVenda statusVenda) {
        this.statusVenda = statusVenda;
    }

    public List<ItemDeVenda> getItensDeVenda() {
        return itensDeVenda;
    }

    public void setItensDeVenda(List<ItemDeVenda> itensDeVenda) {
        this.itensDeVenda = itensDeVenda;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public void add(ItemDeVenda itemVenda) {
        if (itensDeVenda == null) {
            itensDeVenda = new ArrayList<>();
        }
        itensDeVenda.add(itemVenda);
        itemVenda.setVenda(this);
    }
    
    public void remove(ItemDeVenda itemVenda) {
        itensDeVenda.remove(itemVenda);
    }
    
    private void calcularTotalVenda() {
        total = new BigDecimal(0.0);
        for (ItemDeVenda item: this.getItensDeVenda()) {
            total = total.add(item.getValor());
        }
        
    }
    
}
