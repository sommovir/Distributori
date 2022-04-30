/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aziendadistributori;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Matteo
 */
public class DistributoreCaldo implements Distributore {

    private float credito;
    List<ProdottoCaldo> prodotti;

    public DistributoreCaldo() {
        prodotti = new LinkedList<ProdottoCaldo>();
        credito = 0;
    }

    public void aggiungiProdotto(Object o) {
        try {
            prodotti.add((ProdottoCaldo) o);
        } catch (Exception e) {
            System.out.println("|ATTENZIONE!| L'oggetto inserito non è un Prodotto Caldo");
        }
    }

    public boolean isProdottoInserito(Object o) {
        try {
            return prodotti.contains((ProdottoCaldo) o);
        } catch (Exception e) {
            System.out.println("|ATTENZIONE!| L'oggetto inserito non è un Prodotto Caldo");
            return false;
        }
    }
    
    public void rimuoviProdotto(int posizione) {
        //controlla che ti stai riferendo alla giusta posizione
        prodotti.remove(posizione);
    }

    public void erogaProdotto(int posizione) {
        System.out.println("Erogazione " + prodotti.get(posizione).getProdotto());
        credito -= prodotti.get(posizione).getPrezzo();
        if (credito > 0) {
            System.out.println("Resto: " + credito);
            credito = 0;
        }
    }

    public boolean isProdottoPagato(int posizione) {
        if (credito >= prodotti.get(posizione).getPrezzo()) {
            return true;
        }
        return false;
    }

    public void aggiungiMoneta(float moneta) {
        credito += moneta;
    }

     public void mostraProdotti() {
        for (int i = 0; i < prodotti.size(); i++) {
            System.out.println(60 + i + ") " + prodotti.get(i).getProdotto());
        }
    }
     
    public int prodottiDisponibili() {
        return prodotti.size();
    } 
}
