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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de MorseBits complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="MorseBits">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="decodeBits2Morse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MorseBits", propOrder = {
    "decodeBits2Morse"
})
public class MorseBits {

    @XmlElement(required = true)
    protected String decodeBits2Morse;

    /**
     * Obtém o valor da propriedade decodeBits2Morse.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDecodeBits2Morse() {
        return decodeBits2Morse;
    }

    /**
     * Define o valor da propriedade decodeBits2Morse.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDecodeBits2Morse(String value) {
        this.decodeBits2Morse = value;
    }

}
