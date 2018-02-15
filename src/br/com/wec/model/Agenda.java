/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.wec.model;

import java.sql.Date;



/**
 *
 * @author arodrigues
 */
public class Agenda {

    private int numero;
    private Date data;
    private Date dthora;
    private Date hi;
    private Date hf;
    private float duracao;
    private int paciente;
    private int medico;
    private int status;

    /**
     * @return the numero
     */
    public int getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * @return the data
     */
    public Date getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Date data) {
        this.data = data;
    }

    /**
     * @return the dthora
     */
    public Date getDthora() {
        return dthora;
    }

    /**
     * @param dthora the dthora to set
     */
    public void setDthora(Date dthora) {
        this.dthora = dthora;
    }

    /**
     * @return the hi
     */
    public Date getHi() {
        return hi;
    }

    /**
     * @param hi the hi to set
     */
    public void setHi(Date hi) {
        this.hi = hi;
    }

    /**
     * @return the hf
     */
    public Date getHf() {
        return hf;
    }

    /**
     * @param hf the hf to set
     */
    public void setHf(Date hf) {
        this.hf = hf;
    }

    /**
     * @return the duracao
     */
    public float getDuracao() {
        return duracao;
    }

    /**
     * @param duracao the duracao to set
     */
    public void setDuracao(float duracao) {
        this.duracao = duracao;
    }

    /**
     * @return the paciente
     */
    public int getPaciente() {
        return paciente;
    }

    /**
     * @param paciente the paciente to set
     */
    public void setPaciente(int paciente) {
        this.paciente = paciente;
    }

    /**
     * @return the medico
     */
    public int getMedico() {
        return medico;
    }

    /**
     * @param medico the medico to set
     */
    public void setMedico(int medico) {
        this.medico = medico;
    }

    /**
     * @return the status
     */
    public int getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(int status) {
        this.status = status;
    }

    
}
