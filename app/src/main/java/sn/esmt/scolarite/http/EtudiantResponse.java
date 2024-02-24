package sn.esmt.scolarite.http;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EtudiantResponse {
    @SerializedName("mat")
    @Expose


    private String mat;
    @SerializedName("nom")
    @Expose

    private String nom;
    @SerializedName("prenom")
    @Expose

    private String prenom;
    @SerializedName("adr")
    @Expose

    private String adr;
    @SerializedName("tel")
    @Expose

    private int tel;
    @SerializedName("frais")
    @Expose

    private double frais;

    public String getMat() {
        return mat;
    }

    public void setMat(String mat) {
        this.mat = mat;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdr() {
        return adr;
    }

    public void setAdr(String adr) {
        this.adr = adr;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public double getFrais() {
        return frais;
    }

    public void setFrais(double frais) {
        this.frais = frais;
    }
}
