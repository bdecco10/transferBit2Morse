//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.7 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2020.08.19 às 09:41:28 PM BRT 
//


package com.mercadolivre.morseresource;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de anonymous complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="morseBits" type="{http://mercadolivre.com/morseResource}MorseBits"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "morseBits"
})
@XmlRootElement(name = "MorseBitsRequest")
public class MorseBitsRequest {

    @XmlElement(required = true)
    protected MorseBits morseBits;

    /**
     * Obtém o valor da propriedade morseBits.
     * 
     * @return
     *     possible object is
     *     {@link MorseBits }
     *     
     */
    public MorseBits getMorseBits() {
        return morseBits;
    }

    /**
     * Define o valor da propriedade morseBits.
     * 
     * @param value
     *     allowed object is
     *     {@link MorseBits }
     *     
     */
    public void setMorseBits(MorseBits value) {
        this.morseBits = value;
    }

}
