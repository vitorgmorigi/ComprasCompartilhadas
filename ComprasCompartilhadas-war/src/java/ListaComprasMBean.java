/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import ejb.Item;
import ejb.ItemFachada;
import ejb.ListaCompras;
import ejb.ListaComprasFachada;
import ejb.Usuario;
import ejb.UsuarioFachada;
import ejb.UsuarioLista;
import ejb.UsuarioListaFachada;
import java.util.Collection;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author igor
 */
@ManagedBean(name = "listaComprasMBean")
@SessionScoped
public class ListaComprasMBean {
    @EJB
    private ListaComprasFachada lcFachada;
    
    @EJB
    private ItemFachada iFachada;
    
    @EJB
    private UsuarioListaFachada ulFachada;

    private Item item = new Item();
    private ListaCompras listaCompras = new ListaCompras();  // Guarda os dados do formulário
    
    
    public List<ListaCompras> getListasCompras() {
        return lcFachada.getListasCompras();
    }

    /**
     * Creates a new instance of ListaComprasMBean
     */
    public ListaComprasMBean() {
        
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
    
    public ListaCompras getListaCompras(){
        return listaCompras;
    }
    
    public void setListaCompras(ListaCompras listaCompras){
        this.listaCompras = listaCompras;
    }
    
    public String criaListaCompras(Usuario usuario, ListaCompras listaCompras){
        listaCompras.setId(lcFachada.getMaxId() + 1);
        lcFachada.criaListaCompras(usuario, listaCompras);
        UsuarioLista usuarioLista = new UsuarioLista(usuario.getId(), listaCompras.getId());
        ulFachada.vinculaListaAoUsuario(usuarioLista);
        return "menu_logado";
    }
    
    public String salvaListaCompras(){
        lcFachada.salvarListaCompras(listaCompras);
        return "menu_logado";
    }
    
    public String removerListaCompras(String nome){
        lcFachada.removerListaCompras(nome);
        listaCompras = new ListaCompras();
        return "menu_logado";
    }
    
    public String atualizarItem(Item item){
        this.iFachada.salvarItem(item);
        return "exibir_lista_compras";
    }
    
    public String adicionarItem(ListaCompras lista) {
        this.iFachada.cadastrarItem(lista, this.item);
        this.item = new Item();
        return "exibir_lista_compras";
    }
    public String removerItem(ListaCompras lista, Item item) {
        this.iFachada.removerItem(lista, item);
        return "exibir_lista_compras";
    }
}
